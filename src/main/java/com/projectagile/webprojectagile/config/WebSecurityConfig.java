/*Cette classe va nous servir à configurer la sécurité de notre application
Elle est annotée par @Configuration qui informe à Spring qu'elle est une classe de configuration
et par conséquent, elle sera analysée par Spring durant l'exécution de  l'application.*/

package com.projectagile.webprojectagile.config;

import com.projectagile.webprojectagile.security.CustomLogoutSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



import javax.sql.DataSource;

@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        String[] listLoginPathExclude = {"/user/**"};


        httpSecurity.antMatcher("/**").authorizeRequests()
                .and().formLogin().loginProcessingUrl("/user/login").successForwardUrl("/user/login-success").failureForwardUrl("/user/login-failure").permitAll()
                .usernameParameter("userEmail").passwordParameter("userPassword")
                .and().csrf().disable()
                .logout().logoutUrl("/user/logout").logoutSuccessHandler(new CustomLogoutSuccessHandler()).deleteCookies("JSESSIONID").permitAll();
    }

}
