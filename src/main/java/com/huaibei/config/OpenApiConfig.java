package com.huaibei.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaolong
 * @date 2024/5/8
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI mallTinyOpenAPI(){
        return new OpenAPI()
                .info(
                        new Info().title("Day02项目API文档")
                                .description("JAVA中级培训班演示")
                                .version("v1.0.0")
                                .license(new License().name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringBoot项目额外文档"));
    }

    @Bean
    public GroupedOpenApi account(){
        return GroupedOpenApi.builder()
                .group("A-User")
                .displayName("Day02 System")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("B-Public")
                .pathsToMatch("/**")
                .build();
    }
}
