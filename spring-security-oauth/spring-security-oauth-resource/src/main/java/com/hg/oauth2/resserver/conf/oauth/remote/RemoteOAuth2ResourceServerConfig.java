package com.hg.oauth2.resserver.conf.oauth.remote;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.security.oauth2.provider.authentication.TokenExtractor;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 通过远程方式验证token有效性
 */
@PropertySource({ "classpath:remote_token_service.properties" })
@Configuration
@EnableResourceServer
public class RemoteOAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "demo-res";


    @Autowired
    private Environment env;

	private TokenExtractor tokenExtractor = new BearerTokenExtractor();

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.addFilterAfter(new OncePerRequestFilter() {
			@Override
			protected void doFilterInternal(HttpServletRequest request,
					HttpServletResponse response, FilterChain filterChain)
					throws ServletException, IOException {
				// We don't want to allow access to a resource with no token so clear
				// the security context in case it is actually an OAuth2Authentication
				if (tokenExtractor.extract(request) == null) {
					SecurityContextHolder.clearContext();
				}
				filterChain.doFilter(request, response);
			}
		}, AbstractPreAuthenticatedProcessingFilter.class);

		http.csrf().disable();
		http.authorizeRequests().anyRequest().authenticated();

        http.requestMatchers().antMatchers("/foos/**","/bars/**");

    }

    @Override
    public void configure(final ResourceServerSecurityConfigurer config) {
        config.resourceId(RESOURCE_ID);
        config.tokenServices(remoteTokenServices());
    }

//
//	@Override
//	public void configure(final HttpSecurity http) throws Exception {
//		// @formatter:off
//		http
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//				.and().authorizeRequests().anyRequest().authenticated();
////            .requestMatchers().antMatchers("/foos/**","/bars/**")
////            .and()
////            .authorizeRequests()
////                .antMatchers(HttpMethod.GET,"/foos/**").access("#oauth2.hasScope('foo') and #oauth2.hasScope('read')")
////                .antMatchers(HttpMethod.POST,"/foos/**").access("#oauth2.hasScope('foo') and #oauth2.hasScope('write')")
////                .antMatchers(HttpMethod.GET,"/bars/**").access("#oauth2.hasScope('bar') and #oauth2.hasScope('read')")
////                .antMatchers(HttpMethod.POST,"/bars/**").access("#oauth2.hasScope('bar') and #oauth2.hasScope('write') and hasRole('ROLE_ADMIN')")
//		;
//		// @formatter:on
//	}

	@Bean
	public AccessTokenConverter accessTokenConverter() {
		return new DefaultAccessTokenConverter();
	}



//    @Bean
//    public RemoteTokenServices remoteTokenServices(final @Value("${auth.server.url}") String checkTokenUrl,
//                                                   final @Value("${auth.server.clientId}") String clientId,
//                                                   final @Value("${auth.server.clientsecret}") String clientSecret) {
//        final RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
//        remoteTokenServices.setCheckTokenEndpointUrl(checkTokenUrl);
//        remoteTokenServices.setClientId(clientId);
//        remoteTokenServices.setClientSecret(clientSecret);
//        remoteTokenServices.setAccessTokenConverter(accessTokenConverter());
//        return remoteTokenServices;
//    }



	@Bean
	public RemoteTokenServices remoteTokenServices( ) {
		final RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
		remoteTokenServices.setCheckTokenEndpointUrl(env.getProperty("check_token_url"));
		remoteTokenServices.setClientId( env.getProperty("client_id") );
		remoteTokenServices.setClientSecret( env.getProperty("client_secret") );
		remoteTokenServices.setAccessTokenConverter(accessTokenConverter());
		return remoteTokenServices;
	}

}