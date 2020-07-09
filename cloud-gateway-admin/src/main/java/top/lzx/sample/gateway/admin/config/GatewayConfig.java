package top.lzx.sample.gateway.admin.config;

import top.lzx.sample.gateway.admin.factory.RequestTimeGatewayFilterFactory;
import top.lzx.sample.gateway.admin.filter.RequestTimeFilter;
import top.lzx.sample.gateway.admin.filter.TokenFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: colin
 * @Date: 2019/2/22 11:32
 * @Description:
 * @Version: V1.0
 */
@Configuration
public class GatewayConfig {

    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

    @Bean
    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }

    /**
     * 配置 路由转发：RouteLocator进行路由转发
     * @param builder RouteLocatorBuilder 创建路由
     * @return
     */
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        String httpUrl = "http://httpbin.org:80";
        return builder.routes()
                .route(r -> r
                        .path("/get") //predicates断言，具体的请求规则
                            //filters各种过滤器，用来对请求做各种判断和修改
                        .filters(f -> f.addRequestHeader("Hello","world"))
                        .uri(httpUrl)
                ).route(r -> r
                        .host("*.hystrix.com")// 当请求有 "*.hystrix.com"时，都会进入该router
                        .filters(f -> f
                                .hystrix(config -> config //这个路由中，有熔断配置
                                        .setName("myCmd") //配置名称
                                        .setFallbackUri("forward://fallback"))) //指向性fallback逻辑
                        .uri(httpUrl)
                ).route(r -> r
                        .path("/customer/**")
                        .filters(f -> f.filter(new RequestTimeFilter())
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("http://httpbin.org:80/get")
                        .order(0)
                        .id("customer_filter_router")
                )
                .build();
    }


}
