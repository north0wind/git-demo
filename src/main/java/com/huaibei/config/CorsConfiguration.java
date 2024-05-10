package com.huaibei.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
    @Bean
    public WebMvcConfigurer corsMappings() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                 registry.addMapping("/**")
                    .allowedOrigins("http://example.com") // 明确指定允许的源
                     .allowedMethods("GET","POST") // 明确指定允许的请求⽅法
                    .allowedHeaders("*") // 明确指定允许的请求头
                    .allowCredentials(true) // 根据实际需求决定是否允许发送Cookie
                    .maxAge(3600); // 预检请求的有效期，单位为秒
                 }
            };
        }
}
