package example.model.mapper;

import example.model.user.UserInfo;

import java.util.List;

/**
 * @author yichuan
 */
public interface UserMapper {

    /**
     * 添加用户信息
     *
     * @param userInfo
     * @return
     */
    int addUserInfo(UserInfo userInfo);

    /**
     * 通过ID删除
     *
     * @param userId
     */
    void deleteOneById(Long userId);

    /**
     * 通过ID查询
     *
     * @param userId
     * @return
     */
    UserInfo findOneById(Long userId);

    /**
     * 添加用户信息
     *
     * @param userInfos
     * @return
     */
    int addAllUserInfo(List<UserInfo> userInfos);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<UserInfo> getAll();

    /**
     * 分页查询用户
     *
     * @return
     */
    List<UserInfo> selectPage();

    /**
     *
     * @param userId
     * @return
     */
    UserInfo findUserRolesByUserId(Long userId);
}