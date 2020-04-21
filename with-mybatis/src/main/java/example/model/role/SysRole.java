package example.model.role;

import example.model.permission.SysPermission;
import example.model.user.BaseEntity;
import lombok.Data;
import lombok.ToString;

import java.util.List;
/**
 * 角色
 *
 * @author yichuan
 */
@Data
@ToString
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
     * sysPermissionList
     */
    private List<SysPermission> sysPermissionList;
}
