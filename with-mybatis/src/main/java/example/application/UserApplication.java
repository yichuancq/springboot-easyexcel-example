package example.application;


import example.model.mapper.UserMapper;
import example.model.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserApplication {

    @Autowired
    private UserMapper userMapper;

    public List<UserInfo> getAll() {
        return userMapper.getAll();
    }

}
