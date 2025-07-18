package com.service.customerservice.configuartion;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

        @Bean
        public OpenAPI newOpenApi(){
            return new OpenAPI().info(new Info().title("Customer APIs").
                    version("1.0").
                    description("API Documentation for Customer Servicve").
                    contact(new Contact().
                            name("Kowsik Ratnagiri").
                            email("kowsikratnagiri@gmail.com").
                            url("http://localhost:8080/api-docs"))
                            .license(new License()
                    .name("Apache 2.0")
                    .url("https://www.apache.org/licenses/LICENSE-2.0.html")));
        }


}
