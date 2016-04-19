package com.hg.oauth2.oauthserver.config.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;



@PropertySource({ "classpath:persistence.properties" })
@EnableAuthorizationServer
@Configuration
public class JdbcAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private Environment env;



    @Autowired
    @Qualifier("oauthDataSource")
    DataSource oauthDataSource;

	@Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {// @formatter:off
        clients
               .jdbc( oauthDataSource )
//               .inMemory()

                .withClient("admin")
                .secret("admin")
                .authorizedGrantTypes("password","authorization_code", "refresh_token")
                .scopes("read","write","foo","bar")
                .accessTokenValiditySeconds(3600) // 1 hour
                .refreshTokenValiditySeconds(2592000) // 30 days

                .and()
               .withClient("sampleClientId")
               .authorizedGrantTypes("implicit")
               .scopes("read","write","foo","bar")
               .autoApprove(false)
               .accessTokenValiditySeconds(3600)

               .and()
               .withClient("fooClientIdPassword")
               .secret("secret")
               .authorizedGrantTypes("password","authorization_code", "refresh_token")
               .scopes("foo","read","write")
               .accessTokenValiditySeconds(3600) // 1 hour
               .refreshTokenValiditySeconds(2592000) // 30 days

               .and()
               .withClient("barClientIdPassword")
               .secret("secret")
               .authorizedGrantTypes("password","authorization_code", "refresh_token")
               .scopes("bar","read","write")
               .accessTokenValiditySeconds(3600) // 1 hour
               .refreshTokenValiditySeconds(2592000) // 30 days
               ;
    } // @formatter:on

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer)
			throws Exception {
		oauthServer
			.tokenKeyAccess("permitAll()")
			.checkTokenAccess("isAuthenticated()");
	}
	
	@Bean
	public DefaultAccessTokenConverter defaultAccessTokenConverter() {
		return new DefaultAccessTokenConverter();
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints)
			throws Exception {
		endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager);
	}

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(
                oauthDataSource
        );
    }



}
