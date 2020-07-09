package top.lzx.sample.svc.platform.user.service;

import com.baomidou.mybatisplus.service.IService;
import top.lzx.sample.svc.platform.entity.entity.Permission;
import top.lzx.sample.svc.platform.user.dto.PermissionDTO;

import java.util.List;

/**
 * @Author: colin
 * @Date: 2019/3/13 14:26
 * @Description:
 * @Version: V1.0
 */
public interface IPermissionService extends IService<Permission> {

    List<PermissionDTO> getPermissionListByRoleId(Integer roleId);

}
