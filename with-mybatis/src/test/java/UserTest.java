import example.MyBatisApplication;
import example.application.UserApplication;
import example.model.role.SysRole;
import example.model.user.UserInfo;
import example.model.user.UserSexEnum;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyBatisApplication.class)
public class UserTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    UserApplication userApplication;

    @Test
    public void testLogger() {
        logger.info("info日志记录测试--------------------------");
        logger.error("error日志记录测试--------------------------");
        logger.debug("error日志记录测试--------------------------");
        try {
            System.out.println(3 / 0);
        } catch (Exception e) {
            logger.error("exception error -------------", e);
        }
    }


    @Test
    public void saveUser() throws Exception {

        for (int i = 0; i < 5; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setAge(i);
            // userInfo.setId(0L);
            userInfo.setAddress("address" + i);
            userInfo.setName("name" + i);
            userInfo.setUserSex(UserSexEnum.MAN);
            userInfo.setEmail("abc@163.com");
            userApplication.saveUserInfo(userInfo);
            logger.info("user name:{}", userInfo.getName());
        }
    }

    @Test
    public void findOneById() {
        UserInfo userInfo = userApplication.findOneById(1L);
        if (userInfo != null) {
            //System.out.println("name:" + userInfo.getName());
            logger.info("user name:{}", userInfo.getName());
        }

    }

    @Test
    public void deleteOneById() {
        userApplication.deleteOneById(4);

    }


    @Test
    public void saveAllUser() throws Exception {

        List<UserInfo> userInfoList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setAge(i);
            userInfo.setAddress("address" + i);
            userInfo.setName("name" + i);
            userInfo.setUserSex(UserSexEnum.MAN);
            userInfo.setEmail("abc@163.com");
            userInfoList.add(userInfo);
        }
        userApplication.saveAllUserInfo(userInfoList);
    }

    /**
     * 通过用户ID查询角色
     */
    @Test
    public void findUserRolesByUserId() {
        UserInfo userInfo = userApplication.findUserRoleByUserId(1L);
//        List<SysRole> sysRoleList = userInfo.getSysRoleList();
//        assert (sysRoleList != null);
        if (userInfo != null) {
            System.out.println("name:" + userInfo.getName());
            List<SysRole> sysRoles = userInfo.getSysRoleList();
            if (sysRoles != null && sysRoles.size() > 0) {
                for (SysRole sysRole : sysRoles) {
                    System.out.println(sysRole.toString());
                    System.out.println("roleName:" + sysRole.getRoleName());
                }
            }
        }
    }

}
