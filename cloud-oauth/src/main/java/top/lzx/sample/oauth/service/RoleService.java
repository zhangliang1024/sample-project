package top.lzx.sample.oauth.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.lzx.sample.oauth.service.impl.RoleServiceImpl;
import top.lzx.sample.svc.platform.entity.entity.Role;

import java.util.List;

/**
 * @Author: colin
 * @Date: 2019/3/13 13:54
 * @Description:
 * @Version: V1.0
 */
@FeignClient(name = "svc-platform-user",fallback = RoleServiceImpl.class)
public interface RoleService {

    @GetMapping("/role/list/{userId}")
    List<Role> getRoleListByUserId(@PathVariable("userId") Integer userId);

}
