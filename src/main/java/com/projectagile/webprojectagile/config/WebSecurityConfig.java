/*Cette classe va nous servir à configurer la sécurité de notre application
Elle est annotée par @Configuration qui informe à Spring qu'elle est une classe de configuration
et par conséquent, elle sera analysée par Spring durant l'exécution de  l'application.*/

package com.projectagile.webprojectagile.config;

import com.projectagile.webprojectagile.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
   @Autowired
   private UserDetailsServiceImpl userDetailsService;
 
    @Autowired
    private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        // Configuration du Service pour trouver l'utilisateur dans la base de donnée.
        // Paramètrage de PasswordEncoder
    
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
 
        http.csrf().disable();
        // Cette page ne necessite pas une connexion
        http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();
 
        // La page /userinfo nécessite une connexion en tant que ROLE_USER ou ROLE_ENTREPRISE
        // Si aucune connexion n'est établie, elle sera redirigée vers la page /login
        http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
 
        // Reserver aux entreprises.
        http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");
 
        //CRUD method*
        // Lorsque l'utilisateur s'est connecté en tant que XX
        // Mais accède à une page qui necessite le role YY
        // Accès interdit et envoie  une page d'erreur 403*
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
 
        // 
        http.authorizeRequests().and().formLogin()//
                
                .loginProcessingUrl("/j_spring_security_check") // 
                .loginPage("/login")//
                .defaultSuccessUrl("/userAccountInfo")//
                .failureUrl("/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Logout
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");

        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
 
    }
    // Pour mémoriser les infos des utilisateurs en méthode database, on aurait pu utiliser la méthode memory
    /*
    // Methode 1
    @Bean
public PersistentTokenRepository persistentTokenRepository() {
    InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
    return memory;
}    
    */
    
    //Méthode 2
    //Token enrégistrer dans la table (Persistent_Logins)BD*
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }
 


}
