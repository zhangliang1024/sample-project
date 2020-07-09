package top.lzx.sample.svc.platform.user.exception;

import lombok.Data;

/**
 * @Author: colin
 * @Date: 2019/2/18 17:38
 * @Description:
 * @Version: V1.0
 */
@Data
public class UserException extends RuntimeException {

    public UserException(String message) {
        super(message);
    }
}
