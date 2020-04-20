package example.model.mapper;

import example.model.role.SysRole;

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
}
