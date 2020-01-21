package ru.vladigeras.springneo4j.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author vladi_geras on 21.01.2020
 */
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
	@Bean
	public Docket apiV1() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("v1")
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("/.*v1.*"))
				.build()
				.apiInfo(buildApiInfo("1"));
	}

	private ApiInfo buildApiInfo(String version) {
		return new ApiInfoBuilder()
				.title("API")
				.contact(new Contact("Vladislav Gerasimov", "https://github.com/gerasimovv88", "gerasimov.v88@gmail.com"))
				.version(version)
				.build();
	}
}
