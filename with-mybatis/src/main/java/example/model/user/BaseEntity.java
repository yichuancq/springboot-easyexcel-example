package example.model.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yichuan
 */

@Getter
@Setter
@ToString
public abstract class BaseEntity implements Serializable {
    /**
     * 创建时间a
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime = new Date();
    /**
     * 更新时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime = new Date();

    /**
     * 版本号
     */
    private Long version = 0L;
}
