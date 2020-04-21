package example.model.mapper;

import example.model.permission.SysPermission;
import example.model.role.SysRole;
import org.apache.ibatis.annotations.Param;

/**
 * 系统角色
 *
 * @author yichuan
 */
public interface SysRoleMapper {

    /**
     * addSysRole
     *
     * @param sysRole
     * @return
     */
    int addSysRole(SysRole sysRole);

    /**
     * findOneById
     *
     * @param roleId
     * @return
     */
    SysRole findOneById(Long roleId);

    /**
     *
     * @param roleId
     * @return
     */
    SysPermission selectPermissionsByRoleId(@Param("roleId") Long roleId);
}
