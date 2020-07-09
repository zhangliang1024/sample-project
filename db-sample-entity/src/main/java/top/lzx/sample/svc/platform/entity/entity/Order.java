package top.lzx.sample.svc.platform.entity.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author: colin
 * @Date: 2019/2/14 14:15
 * @Description: 订单
 * @Version: V1.0
 */
@Data
@TableName("t_order")
public class Order {
    private Integer id;
    private String name; 
    private String description;
    private Date createTime;
    private String status;
    private Integer userId;
}
