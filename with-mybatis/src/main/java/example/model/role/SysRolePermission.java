package example.model.role;

import lombok.Data;
import lombok.ToString;

/**
 * 角色权限关联表
 *
 * @author yichuan
 */
@Data
@ToString
public class SysRolePermission {

    private Long id;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 权限ID
     */
    private Long permissionId;
}
