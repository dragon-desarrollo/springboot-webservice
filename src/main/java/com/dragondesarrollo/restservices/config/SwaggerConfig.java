package com.dragondesarrollo.restservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Import(BeanValidatorPluginsConfiguration.class)
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.dragondesarrollo.restservices"))
				.paths(PathSelectors.ant("/users/**"))
				.build();
	}
	
	// Swagger metadata: http://localhost:8080/v2/api.docs
	// Swagger UI URL: http://localhost:8080/swagger-ui.html
	
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("Dragon Desarrollo - Servicio para la administración de usuarios")
				.description("Ésta página lista todas las apis para la administración de usuarios")
				.version("2.0")
				.contact(new Contact("Dragon Desarrollo", "http://www.dragondesarrollo.com", "dragon-desarrollo@gmail.com"))
				.license("2.0")
				.licenseUrl("http://www.dragondesarrollo.com/licence.html")
				.build();
	}
	

}
