package top.lzx.sample.svc.platform.order.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lzx.sample.svc.platform.entity.entity.Order;
import top.lzx.sample.svc.platform.entity.entity.OrderItem;
import top.lzx.sample.svc.platform.entity.page.PageUtils;
import top.lzx.sample.svc.platform.entity.page.Query;
import top.lzx.sample.svc.platform.order.Vo.OrderVo;
import top.lzx.sample.svc.platform.order.dto.OrderDTO;
import top.lzx.sample.svc.platform.order.dto.OrderItemDTO;
import top.lzx.sample.svc.platform.order.exception.OrderException;
import top.lzx.sample.svc.platform.order.mapper.OrderItemMapper;
import top.lzx.sample.svc.platform.order.mapper.OrderMapper;
import top.lzx.sample.svc.platform.order.service.IOrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper,Order> implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public PageUtils selectOrderList(Integer userId,Map<String, Object> params) {
        EntityWrapper<Order> wrapper = new EntityWrapper<Order>();
        if(userId != null){
            wrapper.eq("user_id",userId);
        }
        Page<Order> page = this.selectPage(
                new Query<Order>(params).getPage(),wrapper);
        PageUtils pageUtils = new PageUtils(page);
        List<Order> orderList = (List<Order>)pageUtils.getList();
        if(orderList == null||orderList.size() < 0){
            return null;
        }
        List<OrderDTO> orderDTOList = orderList.stream().map(e ->{
            OrderDTO orderDTO = new OrderDTO();
            BeanUtils.copyProperties(e,orderDTO);
            return getOrderDTO(e, orderDTO);
        }).collect(Collectors.toList());
        pageUtils.setList(orderDTOList);
        return pageUtils;
    }

    @Override
    public void saveOrder(OrderVo orderVo) {
        if(orderVo == null){
            log.error("saveOrder,input order is:{}",orderVo);
            throw new OrderException("订单信息不可以为空");
        }
        Order order = new Order();
        BeanUtils.copyProperties(orderVo,order);
        order.setCreateTime(new Date());
        orderMapper.saveOrder(order);
    }


    @Override
    public OrderDTO selectOrderById(Integer id) {
        if(id == null || id == 0){
            log.error("selectOrderById,id is: {}",id);
            throw new OrderException("订单ID输入有误");
        }
        Order order = orderMapper.selectOrderById(id);
        if(order != null){
            OrderDTO orderDTO = new OrderDTO();
            BeanUtils.copyProperties(order,orderDTO);
            return getOrderDTO(order, orderDTO);
        }
        return null;
    }

    private OrderDTO getOrderDTO(Order order, OrderDTO orderDTO) {
        List<OrderItem> orderItemList = orderItemMapper.getOrderItemListByOrderId(order.getId());
        List<OrderItemDTO> orderItemDTOList = orderItemList.stream().map(e ->{
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            BeanUtils.copyProperties(e,orderItemDTO);
            return orderItemDTO;
        }).collect(Collectors.toList());
        orderDTO.setOrderItemDTOList(orderItemDTOList);
        return orderDTO;
    }

    @Override
    public void deleteOrderById(Integer id) {
        if(id == null || id == 0){
            log.error("deleteOrderById,id is: {}",id);
            throw new OrderException("订单ID输入有误");
        }
        orderMapper.deleteOrderById(id);
    }

    @Override
    public void updateOrder(OrderVo orderVo) {
        if(orderVo == null){
            log.error("updateOrder,input order is:{}",orderVo);
            throw new OrderException("订单信息不可以为空");
        }
        Order order = new Order();
        BeanUtils.copyProperties(orderVo,order);
        order.setCreateTime(new Date());
        orderMapper.updateOrder(order);
    }
}
