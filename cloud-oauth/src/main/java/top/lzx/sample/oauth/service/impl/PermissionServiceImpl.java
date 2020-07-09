package top.lzx.sample.oauth.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.lzx.sample.oauth.service.PermissionService;
import top.lzx.sample.svc.platform.entity.entity.Permission;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-06-13
 * Time: 11:14
 */
@Slf4j
@Service
public class PermissionServiceImpl implements PermissionService {
    @Override
    public List<Permission> getPermissionListByRoleId(Integer roleId) {
        log.info("调用{}失败","getRolePermission");
        return null;
    }
}
