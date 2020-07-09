package top.lzx.sample.svc.platform.order.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import top.lzx.sample.svc.platform.entity.entity.Order;

import java.util.List;

@Repository
public interface OrderMapper extends BaseMapper<Order> {

    void saveOrder(Order order);

    List<Order> selectOrderList();

    List<Order> selectOrderListByUserId(Integer userId);

    Order selectOrderById(Integer id);

    void  deleteOrderById(Integer id);

    void updateOrder(Order order);
}
