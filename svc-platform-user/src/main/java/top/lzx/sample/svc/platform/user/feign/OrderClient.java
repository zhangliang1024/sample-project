package top.lzx.sample.svc.platform.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import top.lzx.sample.svc.platform.entity.page.PageUtils;

/**
 * @Author: colin
 * @Date: 2019/2/19 16:07
 * @Description:
 * @Version: V1.0
 */
@FeignClient(name = "svc-platform-order")
public interface OrderClient {

    @RequestMapping(value = "/order/list/" ,method = RequestMethod.GET)
    public PageUtils selectOrderListByUserId(@RequestParam(value = "userId")Integer userId,
                                             @RequestParam(name = "pageSize") Integer pageSize,
                                             @RequestParam(name = "pageNum") Integer pageNum);
}
