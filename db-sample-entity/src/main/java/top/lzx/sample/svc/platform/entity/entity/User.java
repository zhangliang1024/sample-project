package top.lzx.sample.svc.platform.entity.entity;

import lombok.Data;

/**
 * @Author: colin
 * @Date: 2019/2/14 14:15
 * @Description: 用户
 * @Version: V1.0
 */
@Data
public class User {
    private Integer id;
    private String name; 
    private String gender;
    private String mobile; 
    private String password;

}
