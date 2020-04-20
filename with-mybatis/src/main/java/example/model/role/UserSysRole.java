package example.model.role;

import example.model.user.BaseEntity;
import lombok.Data;
import lombok.ToString;

/***
 * 用户角色
 * @author yichuan
 */
@Data
@ToString
public class UserSysRole extends BaseEntity {

    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 角色ID
     */
    private Long roleId;
}
