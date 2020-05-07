import example.MyBatisApplication;
import example.application.RoleApplication;
import example.model.mapper.SysRoleMapper;
import example.model.permission.SysPermission;
import example.model.role.RoleStatusEnum;
import example.model.role.SysRole;
import example.model.role.UserSysRole;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyBatisApplication.class)
public class RoleTest {
    @Autowired
    private RoleApplication roleApplication;

    @Resource
    private SysRoleMapper sysRoleMapper;

    /**
     *
     */
    @Test
    public void saveRole() {
        SysRole sysRole = new SysRole();
        sysRole.setId(null);
        sysRole.setMemo("memo");
        sysRole.setRoleName("roleName");
        //status
        sysRole.setRoleStatus(RoleStatusEnum.ENABLE);
        int result = roleApplication.AddRole(sysRole);
        if (result > 0) {
            System.out.println("添加成功");
        }
    }

    /**
     * 添加用户角色
     */
    @Test
    public void AddUserRole() {
        UserSysRole userSysRole = new UserSysRole();
        userSysRole.setId(null);
        userSysRole.setUserId(1L);
        userSysRole.setRoleId(1011L);
        int result = roleApplication.AddUserRole(userSysRole);
        if (result > 0) {
            System.out.println("添加成功");
        }
    }

    /**
     * 通过用户Id查询用户角色权限
     */
    @Test
    public void findRoleByUserId() {
        List<SysRole> sysRoles = roleApplication.selectRolesByUserId(1L);
        //user
        if (sysRoles != null) {
            System.out.println("size:" + sysRoles.size());
        }
        //role
        for (SysRole sysRole : sysRoles) {
            System.out.println("" + sysRole.toString());
            System.out.println("getCreateTime:" + sysRole.getCreateTime());
        }
        //permission
        for (SysRole sysRole : sysRoles) {
            System.out.println("role:" + sysRole.getRoleName());
            List<SysPermission> sysPermissionList = sysRoleMapper.selectPermissionsByRoleId(sysRole.getId());
            assert (sysPermissionList != null);
            for (SysPermission permission : sysPermissionList) {
                if (permission != null) {
                    System.out.println("permission:" + permission.toString());
                }
            }
        }
    }
}
