package top.lzx.sample.svc.platform.order.service;




import top.lzx.sample.svc.platform.entity.page.PageUtils;
import top.lzx.sample.svc.platform.order.Vo.OrderItemVo;
import top.lzx.sample.svc.platform.order.dto.OrderItemDTO;

import java.util.Map;

/**
 * @Author: colin
 * @Date: 2019/2/14 17:23
 * @Description:
 * @Version: V1.0
 */
public interface IOrderItemService {

    PageUtils getOrderItemList(Map<String, Object> params);

    void createOrderItem(OrderItemVo orderItemVo) ;

    void updateOrderItem(OrderItemVo orderItemVo);

    OrderItemDTO selectOrderItemById(Integer id);

    void deleteOrderItemById(Integer id);
    
}
