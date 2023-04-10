package cn.edu.bupt.aiswitchboard.config;

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
public class SwaggerConfig {
    /**
     * 配置接口文档生成规则
     */
    @Bean
    public Docket getDocket() {
        // 设置文档生成规则
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false) // 禁用自动生成的状态码
                .apiInfo(apiInfo()) // 设置文档信息
                .select()
                // 设置哪个包下的类需要生成文档
                .apis(RequestHandlerSelectors.basePackage("cn.edu.bupt.aiswitchboard.controller"))
                .paths(PathSelectors.any()) // 定义哪些路径的接口需要生成文档
                .build();

    }

    /**
     * 设置文档信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("智能总机接口文档")
                .description("2023.4.6 将智能总机重构一份java版本，用于自己的java学习并使得项目更加灵活")
                .version("1.0")
                .contact(new Contact("CuriousLiu;",
                        "https://yixuan004.github.io/",
                        "liuyixuan@bupt.edu.cn"))
                .build();
    }
}
