package top.lzx.sample.svc.platform.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: colin
 * @Date: 2019/3/13 18:41
 * @Description:
 * @Version: V1.0
 */
@RestController
@RequestMapping("/permission")
@Api("平台权限管理接口")
@ApiResponses({
        @ApiResponse(code=500,message="服务器内部错误")
})
public class PermissionController {

}
