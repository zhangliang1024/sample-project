package top.lzx.sample.svc.platform.order.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lzx.sample.svc.platform.entity.entity.OrderItem;
import top.lzx.sample.svc.platform.entity.page.PageUtils;
import top.lzx.sample.svc.platform.entity.page.Query;
import top.lzx.sample.svc.platform.order.Vo.OrderItemVo;
import top.lzx.sample.svc.platform.order.dto.OrderItemDTO;
import top.lzx.sample.svc.platform.order.exception.OrderItemException;
import top.lzx.sample.svc.platform.order.mapper.OrderItemMapper;
import top.lzx.sample.svc.platform.order.service.IOrderItemService;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: colin
 * @Date: 2019/2/14 17:25
 * @Description:
 * @Version: V1.0
 */
@Service
@Slf4j
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper,OrderItem> implements IOrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public PageUtils getOrderItemList(Map<String, Object> params) {
        Page<OrderItem> page = this.selectPage(new Query<OrderItem>(params).getPage(),new EntityWrapper<OrderItem>());
        PageUtils pageUtils = new PageUtils(page);
        List<?> orderItemList = pageUtils.getList();
        if(orderItemList == null||orderItemList.size() < 0){
            return null;
        }
        List<OrderItemDTO> orderDTOList = orderItemList.stream().map(e ->{
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            BeanUtils.copyProperties(e,orderItemDTO);
            return orderItemDTO;
        }).collect(Collectors.toList());
        pageUtils.setList(orderDTOList);
        return pageUtils;
    }

    @Override
    public void createOrderItem(OrderItemVo orderItemVo) {
        if(orderItemVo == null){
            log.error("createOrderItem,input orderItem is:{}",orderItemVo);
            throw new OrderItemException("订单明细信息不可以为空");
        }
        OrderItem orderItem = new OrderItem();
        BeanUtils.copyProperties(orderItemVo,orderItem);
        Date now = new Date();
        orderItem.setCreateTime(now);
        orderItem.setUpdateTime(now);
        orderItemMapper.insertOrderItem(orderItem);
    }

    @Override
    public void updateOrderItem(OrderItemVo orderItemVo) {
        if(orderItemVo == null){
            log.error("updateOrderItem,input orderItem is:{}",orderItemVo);
            throw new OrderItemException("订单明细信息不可以为空");
        }
        OrderItem orderItem = new OrderItem();
        BeanUtils.copyProperties(orderItemVo,orderItem);
        Date now = new Date();
        orderItem.setUpdateTime(now);
        orderItemMapper.updateOrderItem(orderItem);
    }

    @Override
    public OrderItemDTO selectOrderItemById(Integer id) {
        if(id == null || id == 0){
            log.error("selectOrderItemById,id is: {}",id);
            throw new OrderItemException("订单明细ID输入有误");
        }
        OrderItem orderItem = orderItemMapper.selectOrderItemById(id);
        if(orderItem != null){
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            BeanUtils.copyProperties(orderItem,orderItemDTO);
            return orderItemDTO;
        }
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        BeanUtils.copyProperties(orderItem,orderItemDTO);
        return orderItemDTO;
    }

    @Override
    public void deleteOrderItemById(Integer id) {
        if(id == null || id == 0){
            log.error("deleteOrderItemById,id is: {}",id);
            throw new OrderItemException("订单明细ID输入有误");
        }
        orderItemMapper.deleteOrderItemById(id);
    }
}
