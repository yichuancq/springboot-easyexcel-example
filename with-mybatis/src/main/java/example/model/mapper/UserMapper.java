package example.model.mapper;

import example.model.user.UserInfo;

import java.util.List;

/**
 * @author yichuan
 */
public interface UserMapper {

    int addUserInfo(UserInfo userInfo);


    /**
     *
     *
     * @param userInfos
     * @return
     */
    int addAllUserInfo(List<UserInfo> userInfos);

    /**
     * @return
     */
    List<UserInfo> getAll();

    /**
     * 分页查询用户
     *
     * @return
     */
    List<UserInfo> selectPage();
}