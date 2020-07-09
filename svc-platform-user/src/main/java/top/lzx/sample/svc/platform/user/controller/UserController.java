package top.lzx.sample.svc.platform.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import top.lzx.sample.svc.platform.entity.page.PageUtils;
import top.lzx.sample.svc.platform.user.Vo.UserVo;
import top.lzx.sample.svc.platform.user.dto.UserDTO;
import top.lzx.sample.svc.platform.user.feign.OrderClient;
import top.lzx.sample.svc.platform.user.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api("平台用户管理接口")
@ApiResponses({
        @ApiResponse(code=500,message="服务器内部错误")
})
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private OrderClient orderClient;

    @ApiOperation("获取用户的订单列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name="userId",dataType="int",required=true,value="用户ID信息"),
            @ApiImplicitParam(paramType="query",name="pageSize",dataType="int",defaultValue = "10",required=false,value="每页显示条数"),
            @ApiImplicitParam(paramType="query",name="pageNum",dataType="int",defaultValue = "1",required=false,value="当前页")
    })
    @RequestMapping(value="/order/list",method=RequestMethod.GET)
    public PageUtils getOrderListByUserId(@RequestParam("userId") Integer userId,
                                           @RequestParam(defaultValue = "10",required = false) Integer pageSize,
                                           @RequestParam(defaultValue = "1",required = false) Integer pageNum ) {
        return orderClient.selectOrderListByUserId(userId,pageSize,pageNum);
    }

    @ApiOperation("获取用户列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name="pageSize",dataType="int",defaultValue = "10",required=false,value="每页显示条数"),
            @ApiImplicitParam(paramType="query",name="pageNum",dataType="int",defaultValue = "1",required=false,value="当前页")
    })
    @RequestMapping(value="/list",method=RequestMethod.GET)
    public PageUtils getUserList(@RequestParam(defaultValue = "10",required = false) Integer pageSize,
                                 @RequestParam(defaultValue = "1",required = false) Integer pageNum ) {
        Map<String, Object> params = new HashMap<>();
        params.put("page",pageNum);
        params.put("limit",pageSize);
        return userService.getUserList(params);
    }

    @ApiOperation("保存用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="body",name="user",dataType="UserVo",required=true,value="用户信息")
    })
    @RequestMapping(value="/",method=RequestMethod.POST)
    public void createUser(@RequestBody UserVo user) {
        userService.createUser(user);
    }

    @ApiOperation("获取用户信息根据用户ID")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="path",name="id",dataType="int",required=true,value="用户ID")
    })
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public UserDTO fetchUser(@PathVariable("id") Integer id) {
        return userService.selectUserById(id);
    }

    @ApiOperation("修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="body",name="user",dataType="UserVo",required=true,value="用户信息")
    })
    @RequestMapping(value="/",method=RequestMethod.PUT)
    public void updateUser(@RequestBody UserVo user) {
        userService.updateUser(user);
    }

    @ApiOperation("删除用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="path",name="id",dataType="int",required=true,value="用户ID")
    })
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public void deleteUserById(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
    }
}