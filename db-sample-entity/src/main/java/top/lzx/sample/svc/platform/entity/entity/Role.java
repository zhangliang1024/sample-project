package top.lzx.sample.svc.platform.entity.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: colin
 * @Date: 2019/3/13 14:21
 * @Description:
 * @Version: V1.0
 */
@Data
public class Role {
    private Integer id;
    private String name;
    private String value;
    private String tips;
    private Date createTime;
    private Date updateTime;
    private Integer status;

}
