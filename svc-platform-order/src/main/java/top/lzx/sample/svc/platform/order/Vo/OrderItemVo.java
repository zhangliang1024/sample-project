package top.lzx.sample.svc.platform.order.Vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author: colin
 * @Date: 2019/2/20 09:39
 * @Description:
 * @Version: V1.0
 */
@Data
public class OrderItemVo {

    private String id;
    private Integer orderId;
    private String name;
    private String count;
    private String price;
    private String status;
}
