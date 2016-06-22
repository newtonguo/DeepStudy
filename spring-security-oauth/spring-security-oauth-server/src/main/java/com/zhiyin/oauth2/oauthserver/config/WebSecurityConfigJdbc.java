package com.zhiyin.oauth2.oauthserver.config;

import com.zhiyin.oauth2.oauthserver.user.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfigJdbc extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    public void globalUserDetails(final AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().
//                withUser("root").password("root").roles("ADMIN").
//                and().
//                withUser("john").password("123").roles("USER").
//                and().
//                withUser("tom").password("111").roles("ADMIN");
        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        auth.userDetailsService(authenticationService).passwordEncoder(encoder);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests()
            .antMatchers("/login").permitAll()
            .anyRequest().authenticated()
            .and().formLogin().permitAll()
            ;
        // @formatter:on
    }


}
