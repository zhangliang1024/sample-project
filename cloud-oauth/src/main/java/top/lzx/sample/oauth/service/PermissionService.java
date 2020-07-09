package top.lzx.sample.oauth.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.lzx.sample.oauth.service.impl.PermissionServiceImpl;
import top.lzx.sample.svc.platform.entity.entity.Permission;

import java.util.List;

/**
 * @Author: colin
 * @Date: 2019/3/13 13:59
 * @Description:
 * @Version: V1.0
 */
@FeignClient(name = "svc-platform-user",fallback = PermissionServiceImpl.class)
public interface PermissionService {
    @GetMapping("/permission/list/{roleId}")
    List<Permission> getPermissionListByRoleId(@PathVariable("roleId") Integer roleId);
}
