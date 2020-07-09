package top.lzx.sample.svc.platform.user.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import top.lzx.sample.svc.platform.entity.utils.JwtTokenUtil;

/**
 * @Author: colin
 * @Date: 2019/2/21 00:04
 * @Description:
 * @Version: V1.0
 */
@RestController
@RequestMapping("/auth")
@Api("用户TOKEN验证接口")
@ApiResponses({
        @ApiResponse(code=500,message="服务器内部错误")
})
public class AuthController {

    @ApiOperation("用户TOKEN验证接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name="token",dataType="String",required=true,value="用户TOKEN信息")
    })
    @RequestMapping(value="/",method= RequestMethod.GET)
    public boolean AuthToken(@RequestParam("token") String token){
        return JwtTokenUtil.isTokenExpired(token);
    }
}
