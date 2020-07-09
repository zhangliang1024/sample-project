package top.lzx.sample.zuul.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableZuulProxy
@EnableCaching
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "top.liangzixin.cisample.zuul.admin.feign")
public class CloudZuulAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudZuulAdminApplication.class, args);
	}

}

