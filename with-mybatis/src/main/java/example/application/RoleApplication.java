package example.application;

import example.model.mapper.SysRoleMapper;
import example.model.role.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yichuan
 */
@Service
public class RoleApplication {
    @Autowired
    private SysRoleMapper sysRoleMapper;


    /**
     * AddRole
     *
     * @param sysRole
     */
    public int AddRole(SysRole sysRole) {
        return sysRoleMapper.addSysRole(sysRole);
    }

    /**
     * findOneById
     *
     * @param roleId
     * @return
     */
    public SysRole findOneById(Long roleId) {
        return sysRoleMapper.findOneById(roleId);
    }
}
