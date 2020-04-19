package example.model.mapper;

import example.model.user.UserInfo;

import java.util.List;

/**
 * @author yichuan
 */
public interface UserMapper {

    List<UserInfo> getAll();

}