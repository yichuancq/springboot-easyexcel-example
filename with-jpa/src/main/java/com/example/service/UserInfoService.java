package com.example.service;


import com.example.model.user.UserInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 用户信息
 */
public interface UserInfoService {
    /**
     * findUserByName
     *
     * @param username
     * @return
     */
    UserInfo findUserByName(String username);

    /**
     * @param userInfos
     */
    void saveAllUser(List<UserInfo> userInfos);

    /**
     * save
     *
     * @param userInfo
     */
    void saveUser(UserInfo userInfo);

    /**
     * @return
     */
    List<UserInfo> findAll();

    /**
     * @param id
     */
    void deleteUserById(Long id);

    /**
     * @param id
     * @return
     */
    UserInfo findUserById(Long id);

    /**
     * @param
     * @return
     */
    Page<UserInfo> findAllByPage(UserInfo userInfo, int pageNumber, int pageSize);

}
