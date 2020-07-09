package top.lzx.sample.gateway.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: colin
 * @Date: 2019/2/22 11:26
 * @Description:
 * @Version: V1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableOAuth2Sso
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class,args);
    }
}
