package top.lzx.sample.svc.platform.user.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import top.lzx.sample.svc.platform.entity.entity.User;

import java.util.List;

/**
 * @Author: colin
 * @Date: 2019/2/14 15:04
 * @Description:
 * @Version: V1.0
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> getUserList();

    void insertUser(User user);

    User selectUserById(Integer id);

    void updateUser(User user);

    void deleteUserById(Integer id);
}
