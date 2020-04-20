package example.model.mapper;

import example.model.permission.SysPermission;

import java.util.List;

/**
 * @author yichuan
 */
public interface SysPermissionMapper {

    /**
     * @param sysPermission
     * @return
     */
    int addSysPermission(SysPermission sysPermission);

    /**
     * @param permissionId
     * @return
     */
    SysPermission findOneById(Long permissionId);

    /**
     * @param permissionId
     * @return
     */

    List<SysPermission> findChildPermissionsById(Long permissionId);


}
