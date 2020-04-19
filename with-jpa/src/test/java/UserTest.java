import com.example.EasyExcelApplication;
import com.example.application.UserApplication;
import com.example.model.user.UserInfo;
import com.example.model.user.UserSexEnum;
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
@SpringBootTest(classes = EasyExcelApplication.class)
public class UserTest {

    @Autowired
    UserApplication userApplication;

    @Test
    public void saveAll() throws Exception {
        List<UserInfo> userInfoList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setAge(i);
            userInfo.setAddress("address" + i);
            userInfo.setName("name" + i);
            userInfo.setUserSex(UserSexEnum.MAN);
            userInfo.setEmail("abc@163.com");
            userInfoList.add(userInfo);
        }
        userApplication.saveAllUser(userInfoList);
    }

}
