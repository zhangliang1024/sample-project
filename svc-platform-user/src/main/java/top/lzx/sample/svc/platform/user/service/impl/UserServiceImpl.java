package top.lzx.sample.svc.platform.user.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lzx.sample.svc.platform.entity.page.PageUtils;
import top.lzx.sample.svc.platform.entity.page.Query;
import top.lzx.sample.svc.platform.entity.entity.User;
import top.lzx.sample.svc.platform.entity.utils.JwtTokenUtil;
import top.lzx.sample.svc.platform.user.Vo.LoginVo;
import top.lzx.sample.svc.platform.user.Vo.UserVo;
import top.lzx.sample.svc.platform.user.dto.UserDTO;
import top.lzx.sample.svc.platform.user.exception.UserException;
import top.lzx.sample.svc.platform.user.mapper.UserMapper;
import top.lzx.sample.svc.platform.user.service.IUserService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: colin
 * @Date: 2019/2/14 15:22
 * @Description:
 * @Version: V1.0
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageUtils getUserList(Map<String, Object> params) {
        Page<User> page = this.selectPage(new Query<User>(params).getPage(),new EntityWrapper<User>());
        PageUtils pageUtils = new PageUtils(page);
        List<?> userList = pageUtils.getList();
        if(userList == null||userList.size() < 0){
            return null;
        }
        List<UserDTO> userDTOList = userList.stream().map(e ->{
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(e,userDTO);
            return userDTO;
        }).collect(Collectors.toList());
        pageUtils.setList(userDTOList);
        return pageUtils;
    }

    public void createUser(UserVo userVo) {
        if(userVo == null){
            log.error("createUser,input user is:{}",userVo);
            throw new UserException("用户信息为空");
        }
        User user = new User();
        BeanUtils.copyProperties(userVo,user);
        userMapper.insertUser(user);
    }

    @Override
    public void updateUser(UserVo userVo) {
        if(userVo == null){
            log.error("updateUser,input user is: {}",userVo);
            throw new UserException("用户信息为空");
        }
        User user = new User();
        BeanUtils.copyProperties(userVo,user);
        userMapper.updateUser(user);
    }

    @Override
    public UserDTO selectUserById(Integer id) {
        if(id == null || id == 0){
            log.error("selectUserById,id is: {}",id);
            throw new UserException("用户Id输入有误");
        }
        User user = userMapper.selectUserById(id);
        if(user != null){
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user,userDTO);
            return userDTO;
        }
        return null;
    }

    @Override
    public void deleteUserById(Integer id) {
        if(id == null || id == 0){
            log.error("deleteUserById,id is: {}",id);
            throw new UserException("用户Id输入有误");
        }
        userMapper.deleteUserById(id);
    }

    @Override
    public String login(LoginVo loginUser) {
        if(loginUser == null || loginUser.getUsername() == null){
            log.error("login, user is: {}",loginUser);
            throw new UserException("登陆用户信息为空");
        }
        User user = new User();
        user.setName(loginUser.getUsername());
        user = userMapper.selectOne(user);
        if(user == null){
            throw new UserException ("用户信息不存在");
        }
        if(!loginUser.getPassword().equals(user.getPassword())){
            throw new UserException ("账号密码输入有误");
        }
        return JwtTokenUtil.generateToken(user.getName());
    }
}
