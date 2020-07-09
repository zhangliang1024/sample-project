package top.lzx.sample.svc.platform.user.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import top.lzx.sample.svc.platform.entity.entity.Permission;

import java.util.List;

/**
 * @Author: colin
 * @Date: 2019/3/13 14:34
 * @Description:
 * @Version: V1.0
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> selectPermissionListByRoleId(@Param("roleId")Integer roleId);
}
