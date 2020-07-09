package top.lzx.sample.svc.platform.user.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author: colin
 * @Date: 2019/3/13 14:28
 * @Description:
 * @Version: V1.0
 */
@Data
public class PermissionDTO {
    private Integer id;
    private String code;
    private String pCode;
    private String pId;
    private String name;
    private String url;
    private Integer isMenu;
    private Integer level;
    private Integer sort;
    private Integer status;
    private String icon;
    private Date createTime;
    private Date updateTime;
}
