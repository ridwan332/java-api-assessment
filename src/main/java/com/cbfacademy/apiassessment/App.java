package com.cbfacademy.apiassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.web.config.EnableSpringDataWebSupport;





@SpringBootApplication
@EnableSpringDataWebSupport
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	/* 
	@Bean
    public Docket productApi()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
                
    }
*/
}
