package top.lzx.sample.oauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

/**
 * @Author: colin
 * @Date: 2019/3/14 11:55
 * @Description: 做验证
 * @Version: V1.0
 */
@RestController
public class UserController {

    @RequestMapping("/user")
    public Principal user(Principal user){
        return user;
    }
}
