package top.lzx.sample.oauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.lzx.sample.oauth.entity.MyUserDetails;
import top.lzx.sample.svc.platform.entity.entity.Permission;
import top.lzx.sample.svc.platform.entity.entity.Role;
import top.lzx.sample.svc.platform.entity.entity.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: colin
 * @Date: 2019/3/13 14:02
 * @Description:
 * @Version: V1.0
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if(user == null){
            throw new RuntimeException("用户:"+username+"不存在");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        List<Role> roleList = roleService.getRoleListByUserId(user.getId());
        if(roleList == null || roleList.size()<0){
            throw new RuntimeException("获取用户权限失败");
        }
        for (Role role : roleList) {
            //角色 必须是ROLE开头的
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getValue());
            grantedAuthorities.add(grantedAuthority);
            //获取权限
            List<Permission> permissionList = permissionService.getPermissionListByRoleId(role.getId());
            if(permissionList != null && permissionList.size()>0){
                for (Permission permission : permissionList) {
                    GrantedAuthority authority = new SimpleGrantedAuthority(permission.getCode());
                    grantedAuthorities.add(authority);
                }
            }
        }
        MyUserDetails userDetails = new MyUserDetails(user.getName(),user.getPassword(),grantedAuthorities);
        return userDetails;
    }
}
