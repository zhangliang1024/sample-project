package top.lzx.sample.oauth.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.lzx.sample.oauth.service.impl.UserServiceImpl;
import top.lzx.sample.svc.platform.entity.entity.User;

/**
 * @Author: colin
 * @Date: 2019/3/13 11:03
 * @Description:
 * @Version: V1.0
 */
@FeignClient(name = "svc-platform-user",fallback = UserServiceImpl.class)
public interface UserService {

    @GetMapping("/user")
    User findByUsername(@RequestParam("username")String username);
}
