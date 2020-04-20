package example.application;

import example.model.mapper.SysRoleMapper;
import example.model.mapper.UserRoleMapper;
import example.model.role.SysRole;
import example.model.role.UserSysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yichuan
 */
@Service
public class RoleApplication {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;


    /**
     * @param userId
     * @return
     */
    public List<SysRole> selectRolesByUserId(Long userId) {
        return userRoleMapper.selectRolesByUserId(userId);
    }


    /**
     * @param userSysRole
     * @return
     */
    public int AddUserRole(UserSysRole userSysRole) {
        return userRoleMapper.addUserRole(userSysRole);
    }

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
