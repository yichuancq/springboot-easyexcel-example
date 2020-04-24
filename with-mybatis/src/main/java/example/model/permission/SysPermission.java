package example.model.permission;
import example.model.user.BaseEntity;
import lombok.Data;

import java.util.List;

/**
 * 系统权限
 *
 * @author yichuan
 */
@Data
public class SysPermission extends BaseEntity {
    /**
     * ID
     */
    private Long id;
    /**
     * 父ID
     */
    private Long parentId;
    /**
     * 权限名称
     */
    private String permissionName;
    /**
     * URL
     */
    private String url;
    /**
     * 资源类型
     */
    private ElementTypeEnum elementTypeEnum;
    /**
     * 子权限
     */
    private List<SysPermission> childPermissionList;
    /**
     *
     */
    private String memo;

}
