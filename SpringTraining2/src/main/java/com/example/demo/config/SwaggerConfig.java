package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// swaggerを有効化
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("api").select()
				// HTTPメソッドでフィルタリングも可能
				.apis(RequestHandlerSelectors.withMethodAnnotation(GetMapping.class))
				// apiを含むパスをAPIグループに指定
				.paths(PathSelectors.regex("/api.*")).build().apiInfo(apiinfo());
	}

	@Bean
	public Docket admin() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("admin") // グループ名
				.select().apis(RequestHandlerSelectors.any()) // all
				.paths(PathSelectors.any()) // all
				.build().apiInfo(admininfo());
	}

	private ApiInfo admininfo() {
		return new ApiInfoBuilder().title("ALL API List").description("全てのAPIの一覧").version("1.0")
				.contact(new Contact("admin_sample", "http://www.xxx.xxx/", "admin_sample@xxx.com")).build();
	}

	private ApiInfo apiinfo() {
		return new ApiInfoBuilder().title("REST API List").description("REST APIの一覧").version("1.0")
				.contact(new Contact("sample", "http://www.xxx.xxx/", "sample@xxx.com")).build();
	}

}
