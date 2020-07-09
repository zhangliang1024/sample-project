package top.lzx.sample.svc.platform.user.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author: colin
 * @Date: 2019/2/18 15:27
 * @Description:
 * @Version: V1.0
 */
@Data
public class UserDTO {

    private Integer id;
    private String name;
    private String gender;
    private String mobile;
    private String password;
    private List<OrderDTO> orderDTOList;
}
