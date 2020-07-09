package top.lzx.sample.oauth.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.lzx.sample.oauth.service.RoleService;
import top.lzx.sample.svc.platform.entity.entity.Role;

import java.util.List;

/**
 * @Author: colin
 * @Date: 2019/3/13 13:57
 * @Description:
 * @Version: V1.0
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Override
    public List<Role> getRoleListByUserId(Integer userId) {
        log.info("调用{}失败","getRoleListByUserId");
        return null;
    }
}
