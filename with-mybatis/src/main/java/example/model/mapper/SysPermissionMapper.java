package example.model.mapper;

import example.model.permission.SysPermission;
import org.apache.ibatis.annotations.Param;

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

    /**
     * @param permissionId
     * @return
     */
    SysPermission findMenuByPid(Long permissionId);

    /**
     * @return
     */
    List<SysPermission> selectAllMenu(@Param("parentId") Long parentId);

}
