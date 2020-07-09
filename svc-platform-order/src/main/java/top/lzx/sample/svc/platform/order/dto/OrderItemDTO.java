package top.lzx.sample.svc.platform.order.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author: colin
 * @Date: 2019/2/18 14:47
 * @Description:
 * @Version: V1.0
 */
@Data
public class OrderItemDTO {

    private String id;
    private Integer orderId;
    private String name;
    private String count;
    private String price;
    private String status;
    private Date createTime;
    private Date updateTime;

}
