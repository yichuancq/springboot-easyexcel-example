import example.EasyExcelMyBatisApplication;
import example.application.RoleApplication;
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

import java.util.List;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EasyExcelMyBatisApplication.class)
public class RoleTest {
    @Autowired
    private RoleApplication roleApplication;

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

    @Test
    public void findRoleByUserId() {
        List<SysRole> sysRoles = roleApplication.selectRolesByUserId(1L);
        if (sysRoles != null) {
            System.out.println("size:" + sysRoles.size());
        }
        //角色
        for (SysRole sysRole : sysRoles) {
            System.out.println("" + sysRole.toString());
            System.out.println("getCreateTime:" + sysRole.getCreateTime());
        }
        //sysPermission
        for (SysRole sysRole : sysRoles) {
            System.out.println("role:" + sysRole.getRoleName());
            List<SysPermission> sysPermissionList = sysRole.getSysPermissionList();
            assert (sysPermissionList != null);
            for (SysPermission sysPermission : sysPermissionList) {
                if (sysPermission != null) {
                    System.out.println("permission:" + sysPermission.getPermissionName());
                }
            }
        }
        //权限
    }

}
