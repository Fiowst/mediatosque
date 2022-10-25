package com.plb.mediatosque;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable() // simplifier l'intéraction client/server
		.authorizeRequests() // la suite de la configuration concerne des requêtes antMatchers 
		.antMatchers(HttpMethod.GET, "/api/users/**/borrows") // définit le comportement de la page mentionnée
			.authenticated() // URL accessible par utilisateur authentifié (peu importe le rôle)
		.anyRequest() // définit le comportement par défaut des URL non mentionnées
			.permitAll()
		.and() // configuration terminée mais on souhaite ajouter d'autres choses
		.logout().logoutUrl("/logout") // choix de l'URL de déconnexion
			.logoutSuccessUrl("/api/items"); // redirection vers le catalogue lors de la déconnexion
		
		http.headers().frameOptions().disable();
	}

	
}
