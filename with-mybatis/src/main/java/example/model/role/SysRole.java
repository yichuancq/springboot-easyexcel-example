package example.model.role;

import example.model.user.BaseEntity;
import lombok.Data;

/**
 * 角色
 *
 * @author yichuan
 */
@Data
public class SysRole extends BaseEntity {
    /**
     * id
     */
    private Long id;

    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 状态
     */
    private RoleStatusEnum roleStatus;
    /**
     * 备注
     */
    private String memo;

    /**
     * 角色权限
     */
    //List<SysPermission> sysPermissionList;
}
