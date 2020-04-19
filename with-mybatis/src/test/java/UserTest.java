import example.EasyExcelMyBatisApplication;
import example.application.UserApplication;
import example.model.user.UserInfo;
import example.model.user.UserSexEnum;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EasyExcelMyBatisApplication.class)
public class UserTest {

    @Autowired
    UserApplication userApplication;

    @Test
    public void saveUser() throws Exception {

        for (int i = 0; i < 5; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setAge(i);
            userInfo.setId(0L);
            userInfo.setAddress("address" + i);
            userInfo.setName("name" + i);
            userInfo.setUserSex(UserSexEnum.MAN);
            userInfo.setEmail("abc@163.com");
            userApplication.saveUserInfo(userInfo);
        }

    }

}
