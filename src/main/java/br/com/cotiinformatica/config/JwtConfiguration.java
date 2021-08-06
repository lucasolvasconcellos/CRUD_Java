package br.com.cotiinformatica.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.swagger.models.HttpMethod;

@Configuration
@EnableWebSecurity
public class JwtConfiguration extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.addFilterAfter(new JwtAuthorizationFilter(),
				UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests();
		
		.antMatchers(HttpMethod.POST, "/api/empresa").permitAll()
		.antMatchers(HttpMethod.POST, "/api/funcionarios").permitAll()
		
		.anyRequest().authenticated();
	}
	

}
