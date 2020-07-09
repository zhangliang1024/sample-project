package top.lzx.sample.svc.platform.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "top.liangzixin")
@MapperScan("top.liangzixin.cisample.svc.platform.order.mapper")
public class SvcPlatformOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvcPlatformOrderApplication.class, args);
	}

}

