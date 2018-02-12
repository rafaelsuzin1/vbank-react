package br.com.system.vbankback.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
    	System.out.println("configuracao Swagger");
    	
        return new Docket(DocumentationType.SWAGGER_2)  
          .apiInfo(apiInfo())		
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();  
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring REST API VBank")
                .description("Spring REST API VBank, desenvolvido por System Example.")
                //.termsOfServiceUrl("")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("1.0")
                .build();
    }
}
