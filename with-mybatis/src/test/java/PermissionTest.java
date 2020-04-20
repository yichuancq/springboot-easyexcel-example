import example.EasyExcelMyBatisApplication;
import example.application.PermissonApplication;
import example.model.permission.ElementTypeEnum;
import example.model.permission.SysPermission;
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
public class PermissionTest {

    @Autowired
    PermissonApplication permissonApplication;

    @Test
    public void findChildPermissionsById() {
        Long permissionId = 1011L;
        List<SysPermission> sysPermissions = permissonApplication.findChildPermissionsById(permissionId);
        if (sysPermissions != null && sysPermissions.size() > 0) {
            for (SysPermission temp : sysPermissions) {
                System.out.println("" + temp.toString());
            }
        }

    }
    /**
     *递归查询父子菜单
     */
    @Test
    public void findChildAllPermissionsById() {
        Long permissionId = 1011L;
        List<SysPermission> sysPermissions = permissonApplication.selectAllMenu(permissionId);
        if (sysPermissions != null && sysPermissions.size() > 0) {
            for (SysPermission temp : sysPermissions) {
                System.out.println("" + temp.toString());
            }
        }
    }
    /**
     *
     */
    @Test
    public void findOneById() {


        SysPermission sysPermission = permissonApplication.findOneById(1011L);
        if (sysPermission != null) {
            System.out.println("" + sysPermission.toString());
            if (sysPermission.getChildPermissionList() != null) {
                for (SysPermission temp : sysPermission.getChildPermissionList()) {
                    System.out.println("" + temp.toString());
                }
            }
        }
    }


    @Test
    public void addPermission() {

        SysPermission sysPermission = new SysPermission();
        sysPermission.setParentId(0L);
        sysPermission.setPermissionName("用户管理");
        sysPermission.setElementTypeEnum(ElementTypeEnum.BUTTON);
        sysPermission.setMemo("test");
        sysPermission.setUrl("/user");
        sysPermission.setChildPermissionList(null);
        permissonApplication.addPermission(sysPermission);
    }

    @Test
    public void addSubPermission() {
        SysPermission sysPermission = new SysPermission();
        sysPermission.setParentId(1011L);
        sysPermission.setPermissionName("用户添加");
        sysPermission.setElementTypeEnum(ElementTypeEnum.BUTTON);
        sysPermission.setMemo("用户添加");
        sysPermission.setUrl("/user/add");
        sysPermission.setChildPermissionList(null);
        permissonApplication.addPermission(sysPermission);
        //
        SysPermission sysPermission2 = new SysPermission();
        sysPermission2.setParentId(1011L);
        sysPermission2.setPermissionName("用户删除");
        sysPermission2.setElementTypeEnum(ElementTypeEnum.BUTTON);
        sysPermission2.setMemo("用户删除");
        sysPermission2.setUrl("/user/del");
        sysPermission2.setChildPermissionList(null);
        permissonApplication.addPermission(sysPermission2);
    }

}
