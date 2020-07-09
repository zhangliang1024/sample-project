package top.lzx.sample.svc.platform.order.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.lzx.sample.svc.platform.entity.page.PageUtils;
import top.lzx.sample.svc.platform.order.Vo.OrderVo;
import top.lzx.sample.svc.platform.order.dto.OrderDTO;
import top.lzx.sample.svc.platform.order.service.IOrderService;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/order")
@Api("平台订单管理接口")
@ApiResponses({
        @ApiResponse(code=500,message="服务器内部错误")
})
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @ApiOperation("订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name="userId",dataType="int",required=false,value="用户ID"),
            @ApiImplicitParam(paramType="query",name="pageSize",dataType="int",defaultValue = "10",required=false,value="每页显示条数"),
            @ApiImplicitParam(paramType="query",name="pageNum",dataType="int",defaultValue = "1",required=false,value="当前页")
    })
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public PageUtils selectOrderListByUserId(@RequestParam(value = "userId",required = false)Integer userId,
                                              @RequestParam(defaultValue = "10",required = false)Integer pageSize,
                                              @RequestParam(defaultValue = "1",required = false)Integer pageNum ) {
        Map<String, Object> params = new HashMap<>();
        params.put("page",pageNum);
        params.put("limit",pageSize);
        return orderService.selectOrderList(userId,params);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ApiOperation("创建订单")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="body",name="orderVo",dataType="OrderVo",required=true,value="订单")
    })
    public void saveOrder(@RequestBody OrderVo orderVo){
        orderService.saveOrder(orderVo);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ApiOperation("订单详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="path",name="id",dataType="int",required=true,value="订单ID")
    })
    public OrderDTO selectOrderById(@PathVariable(value = "id") Integer id){
        return orderService.selectOrderById(id);
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ApiOperation("删除order")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="path",name="id",dataType="int",required=true,value="订单id")
    })
    public void deleteOrderById(@PathVariable(value = "id") Integer id){
        orderService.deleteOrderById(id);
    }

    @RequestMapping(value = "/" ,method = RequestMethod.PUT)
    @ApiOperation("修改订单")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="body",name="orderVo",dataType="OrderVo",required=true,value="订单信息")
    })
    public void updateOrder(@RequestBody OrderVo orderVo){
        orderService.updateOrder(orderVo);
    }



}
