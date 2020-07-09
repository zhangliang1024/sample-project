package top.lzx.sample.svc.platform.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "top.liangzixin")
@MapperScan("top.liangzixin.cisample.svc.platform.user.mapper")
@EnableFeignClients(basePackages = "top.liangzixin.cisample.svc.platform.user.feign")
public class SvcPlatformUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvcPlatformUserApplication.class, args);
	}

}

