package top.lzx.sample.svc.platform.user.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import top.lzx.sample.svc.platform.entity.entity.Permission;
import top.lzx.sample.svc.platform.user.dto.PermissionDTO;
import top.lzx.sample.svc.platform.user.mapper.PermissionMapper;
import top.lzx.sample.svc.platform.user.service.IPermissionService;

import java.util.List;

/**
 * @Author: colin
 * @Date: 2019/3/13 14:33
 * @Description:
 * @Version: V1.0
 */
public class IPermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<PermissionDTO> getPermissionListByRoleId(Integer roleId) {
        return null;
    }
}
