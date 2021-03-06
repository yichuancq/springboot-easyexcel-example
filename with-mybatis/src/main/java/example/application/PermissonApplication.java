package example.application;

import example.model.mapper.SysPermissionMapper;
import example.model.permission.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yichuan
 */
@Service
public class PermissonApplication {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    public int addPermission(SysPermission sysPermission) {
        return sysPermissionMapper.addSysPermission(sysPermission);
    }

    /**
     *
     * @param parentId
     * @return
     */
    public List<SysPermission> selectAllMenu(Long parentId) {
        return sysPermissionMapper.selectAllMenu(parentId);
    }


    public List<SysPermission> findChildPermissionsById(Long permissionId) {
        return sysPermissionMapper.findChildPermissionsById(permissionId);
    }

    public SysPermission findOneById(Long permissionId) {
        return sysPermissionMapper.findOneById(permissionId);
    }
}
