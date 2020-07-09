package top.lzx.sample.svc.platform.order.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.lzx.sample.svc.platform.entity.page.PageUtils;
import top.lzx.sample.svc.platform.order.Vo.OrderItemVo;
import top.lzx.sample.svc.platform.order.dto.OrderItemDTO;
import top.lzx.sample.svc.platform.order.service.IOrderItemService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/orderItem")
@Api("平台订单明细管理接口")
@ApiResponses({
        @ApiResponse(code=500,message="服务器内部错误")
})
public class OrderItemController {

    @Autowired
    private IOrderItemService orderItemService;

    @ApiOperation("获取订单明细列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name="pageSize",dataType="int",defaultValue = "10",required=false,value="每页显示条数"),
            @ApiImplicitParam(paramType="query",name="currPage",dataType="int",defaultValue = "1",required=false,value="当前页")
    })
    @RequestMapping(value="/list",method= RequestMethod.GET)
    public PageUtils getOrderItemList(@RequestParam(defaultValue = "10",required = false) Integer pageSize,
                                      @RequestParam(defaultValue = "1",required = false) Integer currPage ) {
        Map<String, Object> params = new HashMap<>();
        params.put("page",currPage);
        params.put("limit",pageSize);
        return orderItemService.getOrderItemList(params);
    }

    @ApiOperation("获取订单明细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="path",name="id",dataType="int",required=true,value="订单明细编号")
    })
    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    public OrderItemDTO fetchOrder(@PathVariable("id") Integer id) {
        return orderItemService.selectOrderItemById(id);
    }


    @ApiOperation("创建订单明细")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="body",name="orderItemVo",dataType="OrderItemVo",required=true,value="订单明细信息")
    })
    @RequestMapping(value="/",method=RequestMethod.POST)
    public void create(@RequestBody OrderItemVo orderItemVo) {
        orderItemService.createOrderItem(orderItemVo);
    }

    @ApiOperation("修改订单明细")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="body",name="orderItemVo",dataType="OrderItemVo",required=true,value="订单信息")
    })
    @RequestMapping(value="/",method=RequestMethod.PUT)
    public void updateOrderItem(@RequestBody OrderItemVo orderItemVo) {
        orderItemService.updateOrderItem(orderItemVo);
    }

    @ApiOperation("删除订单明细")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="path",name="id",dataType="int",required=true,value="订单明细ID")
    })
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public void deleteOrderItemById(@PathVariable("id") Integer id) {
        orderItemService.deleteOrderItemById(id);
    }
}
