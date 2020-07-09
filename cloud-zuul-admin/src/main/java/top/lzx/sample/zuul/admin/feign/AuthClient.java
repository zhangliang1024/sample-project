package top.lzx.sample.zuul.admin.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: colin
 * @Date: 2019/2/21 00:10
 * @Description:
 * @Version: V1.0
 */
@FeignClient(name = "svc-platform-user")
public interface AuthClient {

    @RequestMapping(value="/auth/",method= RequestMethod.GET)
    public boolean AuthToken(@RequestParam("token") String token);
}
