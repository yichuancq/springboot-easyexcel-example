package example.model.mapper;

import example.model.permission.SysPermission;
import example.model.role.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
     * 通过角色Id查询用户权限
     *
     * @param roleId
     * @return
     */
    List<SysPermission> selectPermissionsByRoleId(@Param("roleId") Long roleId);
}
