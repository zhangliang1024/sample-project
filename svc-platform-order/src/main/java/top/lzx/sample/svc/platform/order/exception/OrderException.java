package top.lzx.sample.svc.platform.order.exception;


/**
 * @Author: colin
 * @Date: 2019/2/19 09:23
 * @Description:
 * @Version: V1.0
 */
public class OrderException extends RuntimeException {

    public OrderException (String message){
        super(message);
    }

}
