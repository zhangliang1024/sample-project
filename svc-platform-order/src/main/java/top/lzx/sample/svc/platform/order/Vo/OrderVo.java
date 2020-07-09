package top.lzx.sample.svc.platform.order.Vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author: colin
 * @Date: 2019/2/20 09:38
 * @Description:
 * @Version: V1.0
 */
@Data
public class OrderVo {

    private Integer id;
    private String name;
    private String description;
    private String status;
    private Integer userId;
}
