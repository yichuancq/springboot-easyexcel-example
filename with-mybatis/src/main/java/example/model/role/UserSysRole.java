package example.model.role;

import example.model.permission.SysPermission;
import example.model.user.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/***
 * 用户角色
 * @author yichuan
 */

@Getter
@Setter
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
    /**
     * 角色的权限
     */
    private List<SysPermission> sysPermissionList;
}
