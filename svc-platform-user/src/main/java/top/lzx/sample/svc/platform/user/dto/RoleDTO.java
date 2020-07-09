package top.lzx.sample.svc.platform.user.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author: colin
 * @Date: 2019/3/13 14:28
 * @Description:
 * @Version: V1.0
 */
@Data
public class RoleDTO {
    private Integer id;
    private String name;
    private String value;
    private String tips;
    private Date createTime;
    private Date updateTime;
    private Integer status;
    private List<PermissionDTO> permissionDTOList;
}
