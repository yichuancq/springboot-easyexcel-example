package example.model.mapper;

import example.model.role.SysRole;
import example.model.role.UserSysRole;

import java.util.List;

/**
 *
 * @author yichuan
 */
public interface UserRoleMapper {

    /**
     * 通过用户ID查询用户角色
     *
     * @param userId
     * @return
     */
    List<SysRole> selectRolesByUserId(Long userId);

    int addUserRole(UserSysRole userSysRole);
}
