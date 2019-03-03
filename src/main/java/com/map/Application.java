package com.map;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.annotation.JsonIgnore;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.map.*")
@EnableAutoConfiguration(exclude = { HypermediaAutoConfiguration.class })

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Docket newsApi() {
		List<SecurityScheme> schemeList = new ArrayList<>();
		schemeList.add(new BasicAuth("basicAuth"));
		return new Docket(DocumentationType.SWAGGER_2).groupName("Map Service").apiInfo(apiInfo())
				.securitySchemes(schemeList).select().paths(regex("/map/.*")).build()
				.useDefaultResponseMessages(false).directModelSubstitute(XMLGregorianCalendar.class, MixIn.class);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Map Service").description("Map Service API")
				.termsOfServiceUrl("http://....").version("1.0").build();
	}

	public static interface MixIn {
		@JsonIgnore
		public void setYear(int year);
	}

}
