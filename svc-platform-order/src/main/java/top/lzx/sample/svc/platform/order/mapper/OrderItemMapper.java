package top.lzx.sample.svc.platform.order.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import top.lzx.sample.svc.platform.entity.entity.OrderItem;

import java.util.List;

/**
 * @Author: colin
 * @Date: 2019/2/14 17:21
 * @Description:
 * @Version: V1.0
 */
public interface OrderItemMapper extends BaseMapper<OrderItem> {

    List<OrderItem> getOrderItemListByOrderId(Integer orderId);

    List<OrderItem> getOrderItemList();

    void insertOrderItem(OrderItem orderItem);

    OrderItem selectOrderItemById(Integer id);

    void updateOrderItem(OrderItem orderItem);

    void deleteOrderItemById(Integer id);
}
