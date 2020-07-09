package top.lzx.sample.svc.platform.order.service;



import top.lzx.sample.svc.platform.entity.page.PageUtils;
import top.lzx.sample.svc.platform.order.Vo.OrderVo;
import top.lzx.sample.svc.platform.order.dto.OrderDTO;

import java.util.Map;

public interface IOrderService {

    PageUtils selectOrderList(Integer userId,Map<String, Object> params);

    void saveOrder(OrderVo orderVo);

    OrderDTO selectOrderById(Integer id);

    void  deleteOrderById(Integer id);

    void updateOrder(OrderVo orderVo);
}
