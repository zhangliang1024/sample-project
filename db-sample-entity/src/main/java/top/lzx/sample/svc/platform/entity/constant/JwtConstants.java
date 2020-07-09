package top.lzx.sample.svc.platform.entity.constant;

/**
 * @Author: colin
 * @Date: 2019/2/20 15:16
 * @Description:
 * @Version: V1.0
 */
public interface JwtConstants {
    String AUTH_HEADER = "Authorization";

    String SECRET = "defaultSecret";

    Long EXPIRATION = 24L * 60 * 60;

    String BEARER = "Bearer ";

}
