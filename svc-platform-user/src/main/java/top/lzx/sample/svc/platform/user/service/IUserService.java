package top.lzx.sample.svc.platform.user.service;


import com.baomidou.mybatisplus.service.IService;
import top.lzx.sample.svc.platform.entity.page.PageUtils;
import top.lzx.sample.svc.platform.entity.entity.User;
import top.lzx.sample.svc.platform.user.Vo.LoginVo;
import top.lzx.sample.svc.platform.user.Vo.UserVo;
import top.lzx.sample.svc.platform.user.dto.UserDTO;

import java.util.Map;

public interface IUserService extends IService<User> {

    public PageUtils getUserList(Map<String, Object> params);

    public void createUser(UserVo user) ;

    public void updateUser(UserVo user);

    public UserDTO selectUserById(Integer id);

    public void deleteUserById(Integer id);

    String login(LoginVo loginUser);
}
