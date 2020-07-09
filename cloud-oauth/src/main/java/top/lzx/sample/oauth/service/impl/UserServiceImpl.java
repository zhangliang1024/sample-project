package top.lzx.sample.oauth.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.lzx.sample.oauth.service.UserService;
import top.lzx.sample.svc.platform.entity.entity.User;

/**
 * @Author: colin
 * @Date: 2019/3/13 11:07
 * @Description:
 * @Version: V1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public User findByUsername(String username) {
        log.info("调用{}失败","findByUsername");
        User user = new User();
        user.setName("调用findByUsername接口失败");
        return user;
    }
}
