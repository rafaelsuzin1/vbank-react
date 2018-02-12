package br.com.system.vbankback.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

//A classe responsavel por iniciar o servico de seguranca do Spring

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebApplicationInitializer() {
        super(SecurityConfig.class);
    }
}
