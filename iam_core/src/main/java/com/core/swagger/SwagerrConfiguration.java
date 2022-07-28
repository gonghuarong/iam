package com.core.swagger;

import org.springframework.beans.factory.annotation.Value;
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

@Configuration
@EnableSwagger2
public class SwagerrConfiguration {
    @Value("${swagger.cfg.enable}")
    private boolean enable;
    @Value("${swagger.cfg.title}")
    private String title;
    @Value("${swagger.cfg.description}")
    private String description;
    @Value("${swagger.cfg.version}")
    private String version;
    @Value("${swagger.cfg.basepackage}")
    private String basePackage;

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .contact(new Contact("warom","https://waromcloud.cn","1178817608@qq.com"))
                .version(version)
                .build();
    }
}
