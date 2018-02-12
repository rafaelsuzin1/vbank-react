package br.com.system.vbankback.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Override
	protected void configure(HttpSecurity http) throws Exception {
    	//Aqui estou mostrando o bloqueio individual de cada controller,
    	//mas pode ser geral colocar apenas /**, ou seja, qualquer acesso
    	//após a raiz será pedido autenticacao.
		http.addFilterBefore(new WebConfig(), ChannelProcessingFilter.class)
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/**").authenticated()
			.antMatchers(HttpMethod.POST, "/**").authenticated()
			.antMatchers(HttpMethod.PUT, "/**").authenticated()
			.antMatchers(HttpMethod.DELETE, "/**").authenticated()				
			.anyRequest().permitAll()
			.and()
			.httpBasic()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.csrf().disable();
		
		System.out.println("Security Configurado");
	}
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("vbank").password("vbank").roles("ADMIN");
    }

}
