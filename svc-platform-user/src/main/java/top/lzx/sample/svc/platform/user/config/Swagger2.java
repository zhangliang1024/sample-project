package top.lzx.sample.svc.platform.user.config;

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
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("top.liangzixin"))//api接口包扫描路径
                .paths(PathSelectors.any())//可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("平台用户管理接口")//设置文档的标题
                .description("top.liangzixin.cisample")//设置文档的描述->1.Overview
//                .version("v1.0.0")//设置文档的版本信息-> 1.1 Version information
//                .contact(new Contact("ABC Boot", "http://www.abc.comt", ""))//设置文档的联系方式->1.2 Contact information
                .termsOfServiceUrl("http://wiki.liangzixin.top")//设置文档的License信息->1.3 License information
                .build();
    }
}