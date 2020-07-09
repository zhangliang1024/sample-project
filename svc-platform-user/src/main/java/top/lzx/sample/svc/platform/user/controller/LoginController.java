package top.lzx.sample.svc.platform.user.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.lzx.sample.svc.platform.user.Vo.LoginVo;
import top.lzx.sample.svc.platform.user.service.IUserService;

/**
 * @Author: colin
 * @Date: 2019/2/20 14:57
 * @Description:
 * @Version: V1.0
 */
@RestController
@RequestMapping("/login")
@Api("平台用户登陆接口")
@ApiResponses({
        @ApiResponse(code=500,message="服务器内部错误")
})
public class LoginController {

    @Autowired
    private IUserService userService;

    @ApiOperation("用户登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="body",name="loginUser",dataType="LoginVo",required=true,value="用户登陆信息")
    })
    @RequestMapping(value="/",method= RequestMethod.POST)
    public String login(@RequestBody LoginVo loginUser){
        return userService.login(loginUser);
    }
}
