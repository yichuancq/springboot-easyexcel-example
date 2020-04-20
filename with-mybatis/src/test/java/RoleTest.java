import example.EasyExcelMyBatisApplication;
import example.application.RoleApplication;
import example.model.role.RoleStatusEnum;
import example.model.role.SysRole;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

}
