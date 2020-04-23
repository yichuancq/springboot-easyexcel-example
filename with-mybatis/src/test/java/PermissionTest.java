import com.alibaba.fastjson.JSON;
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

import java.util.ArrayList;
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
     * 递归查询父子菜单
     * <p>
     * 父权限:用户管理
     * 权限名称:用户添加
     * 父权限:用户管理
     * 权限名称:用户删除
     * 用户管理
     */
    @Test
    public void findChildAllPermissionsById() {
        Long permissionId = 1011L;
        List<SysPermission> sysPermissions = permissonApplication.selectAllMenu(permissionId);
        if (sysPermissions != null && sysPermissions.size() > 0) {
            for (SysPermission temp : sysPermissions) {
                //
                List<SysPermission> childPermissionList = temp.getChildPermissionList();
                if (childPermissionList != null) {
                    System.out.println("" + childPermissionList.size());
                    for (SysPermission sysPermission : childPermissionList) {
                        //
                        //System.out.println("父权限:" + sysPermission.getParentPermission().getPermissionName());
                        System.out.println("权限名称:" + sysPermission.getPermissionName());
                    }
                }
                System.out.println("" + temp.getPermissionName());
            }
        }
        //集合转换为JSON
        String str1 = JSON.toJSONString(sysPermissions);
        System.out.println(str1);
    }


    /**
     * 获取某个父节点下面的所有子节点
     *
     * @param menuList
     * @param pid
     * @return
     */

    static List<SysPermission> childMenu = new ArrayList<SysPermission>();

    /**
     * @param menuList
     * @param pid
     * @return
     */
    public static List<SysPermission> treeMenuList(List<SysPermission> menuList, Long pid) {
        for (SysPermission mu : menuList) {
            //遍历出父id等于参数的id，add进子节点集合
            if (mu.getParentId().equals(pid)) {
                //递归遍历下一级
                treeMenuList(menuList, mu.getId());
                childMenu.add(mu);
            }
        }
        return childMenu;

    }


    /**
     * 递归获取某个父机构节点下面的所有子机构节点
     *
     * @param childOrg 要返回的结果
     * @param orgList  数据库查询出来的所有机构集合
     * @param pid      父id
     *                 注:本身的机构节点不会添加进去
     */
    private void orgRecursion(List<SysPermission> childOrg, List<SysPermission> orgList, Long pid) {
        for (SysPermission org : orgList) {
            if (org.getParentId() != null) {
                //遍历出父id等于参数的id，add进子节点集合
                if (org.getParentId().equals(pid)) {
                    //递归遍历下一级
                    orgRecursion(childOrg, orgList, org.getId());
                    System.out.println("--->" + org.toString());
                    childOrg.add(org);
                }
            }
        }
    }

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
        //

//        List<SysPermission> childList = sysPermission.getChildPermissionList();
//        List<SysPermission> childList2 = new ArrayList<>();
//        orgRecursion(childList2, childList, sysPermission.getId());
        List<SysPermission> childList = this.treeMenuList(sysPermission.getChildPermissionList(), 0L);
        for (SysPermission permission : childList) {
            System.out.println("-->" + permission.toString());
        }
        //集合转换为JSON
//        String str1 = JSON.toJSONString(sysPermission);
//        System.out.println(str1);
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
