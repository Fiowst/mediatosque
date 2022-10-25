package com.plb.mediatosque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.plb.mediatosque.service.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable() // simplifier l'intéraction client/server
        .authorizeRequests() // la suite de la configuration concerne des requêtes antMatchers 
        .antMatchers(HttpMethod.GET, "/api/users/**/borrows") // définit le comportement de la page mentionnée
            .authenticated() // URL accessible par utilisateur authentifié (peu importe le rôle)
        .antMatchers(HttpMethod.POST, "/api/users/**") // définit le comportement de la page mentionnée
            .authenticated() // URL accessible par utilisateur authentifié (peu importe le rôle)
        .anyRequest() // définit le comportement par défaut des URL non mentionnées
            .permitAll()  // URL accessible par tous les utilisateurs
        .and() // configuration terminée mais on souhaite ajouter d'autres choses
            .formLogin()
        .and() 
        .logout().logoutUrl("/logout") // choix de l'URL de déconnexion
            .logoutSuccessUrl("/api/items"); // redirection vers le catalogue lors de la déconnexion
        
        http.headers().frameOptions().disable();
    }
    
	@Override 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		// utiliser le realm de la base H2
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	 
	}

	// cryptage des mots de passe
    public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }

    
}