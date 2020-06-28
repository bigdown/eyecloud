package com.t.s.eyecloud.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置
 * <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月15日
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	@Primary
	public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider defaultResourcesProvider) {
		return () -> {
			List<SwaggerResource> resourcesList = new ArrayList<>();

			// 模拟数据库获取拼接的文档，请求见SwaggerController
			SwaggerResource resource2 = new SwaggerResource();
			resource2.setName("动态API");
			resource2.setSwaggerVersion("2.0");
			resource2.setLocation("/v2/qding-api-docs");
			resourcesList.add(resource2);

			// 自身代码扫描生成的文档，默认路径http://localhost:8080/v2/api-docs
			SwaggerResource resource3 = new SwaggerResource();
			resource3.setName("自身");
			resource3.setSwaggerVersion("2.0");
			resource3.setLocation("/v2/api-docs");
			resourcesList.add(resource3);
			return resourcesList;
		};
	}

	@Bean
	public Docket createRestApi() {
		// 添加head参数start
		ParameterBuilder tokenPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		tokenPar.name("token").description("令牌").modelRef(new ModelRef("string")).parameterType("header")
				.required(true).build();
		pars.add(tokenPar.build());
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				//加了ApiOperation注解的类，生成接口文档
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				//包下的类，生成接口文档
				//.apis(RequestHandlerSelectors.basePackage("io.renren.modules.job.controller"))
				.paths(PathSelectors.any()).build().globalOperationParameters(pars);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("eyecloud-web").description("eyecloud-web文档")
				.termsOfServiceUrl("https://www.baidu.com").version("1.0.0").build();
	}

}