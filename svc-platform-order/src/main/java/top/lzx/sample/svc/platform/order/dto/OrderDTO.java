package top.lzx.sample.svc.platform.order.dto;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {

    private Integer id;
    private String name;
    private String description;
    private Date createTime;
    private String status;
    private Integer userId;
    private List<OrderItemDTO> orderItemDTOList;
}
