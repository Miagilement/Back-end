/*Cette classe va nous servir à configurer la sécurité de notre application
Elle est annotée par @Configuration qui informe à Spring qu'elle est une classe de configuration
et par conséquent, elle sera analysée par Spring durant l'exécution de  l'application.*/

package com.projectagile.webprojectagile.config;

import com.projectagile.webprojectagile.security.AuthTokenFilter;
import com.projectagile.webprojectagile.security.CustomLogoutSuccessHandler;
import com.projectagile.webprojectagile.security.DefaulUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DefaulUserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        String[] listLoginPathExclude = {"/user/**"};


        httpSecurity.cors().and().csrf().disable()
                .authorizeRequests().antMatchers(listLoginPathExclude).permitAll()
//                .and().authorizeRequests().anyRequest().authenticated()
                .and().logout().logoutUrl("/user/logout").logoutSuccessHandler(new CustomLogoutSuccessHandler()).deleteCookies("JSESSIONID").permitAll()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        log.warn("Illegal request occurred, request to [{}], AuthenticationException='{}'", httpServletRequest.getRequestURI(), e.getMessage());
                        httpServletRequest.getRequestDispatcher("/user/login-error").forward(httpServletRequest, httpServletResponse);
                    }
                })
                .accessDeniedHandler(new AccessDeniedHandler() {
                    @Override
                    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
                        log.warn("Access denied, request to [{}], AuthenticationException= '{}'", httpServletRequest.getRequestURI(), e.getMessage());
                        httpServletRequest.getRequestDispatcher("/user/login-error").forward(httpServletRequest, httpServletResponse);
                    }
                });
                httpSecurity.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }
}
