package top.lzx.sample.svc.platform.entity.page;

import com.baomidou.mybatisplus.plugins.Page;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: colin
 * @Date: 2019/2/20 13:42
 * @Description:
 * @Version: V1.0
 */
@Getter
public class Query<T> extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    /**
     * mybatis-plus分页参数
     */
    private Page<T> page;
    /**
     * 当前页码
     */
    private Integer currPage = 1;
    /**
     * 每页条数
     */
    private Integer limit = 10;

    public Query(Map<String, Object> params){
        this.putAll(params);
        //分页参数
        if(params.get("page") != null){
            currPage = (Integer)params.get("page");
        }
        if(params.get("limit") != null){
            limit = (Integer)params.get("limit");
        }
        this.put("offset", (currPage - 1) * limit);
        this.put("page", currPage);
        this.put("limit", limit);
        this.page = new Page<>(currPage, limit);
    }
}
