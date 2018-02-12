package br.com.system.vbankback.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

//Com esta classe de Filtro elimina ficar colocando em
//todos os controllers a Anotação:
//@CrossOrigin(origins="http://localhost:8090")
//Esta classe também precisa ser informada no Web.xml.

@Component
public class WebConfig implements Filter {

public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletResponse response = (HttpServletResponse) res;
//    response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8090");
    response.setHeader("Access-Control-Allow-Origin", "*");
//    response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8090");
    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me, WWW-Authenticate, Authorization, Origin, Version");
    chain.doFilter(req, res);
}

public void init(FilterConfig filterConfig) {}

public void destroy() {}

}