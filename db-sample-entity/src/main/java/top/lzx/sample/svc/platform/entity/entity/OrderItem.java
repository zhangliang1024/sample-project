package top.lzx.sample.svc.platform.entity.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: colin
 * @Date: 2019/2/14 14:15
 * @Description: 订单明细
 * @Version: V1.0
 */
@Data
public class OrderItem {
    private String id;
    private Integer orderId;
    private String name; 
    private String count;
    private String price;
    private String status;
    private Date createTime;
    private Date updateTime;

}
