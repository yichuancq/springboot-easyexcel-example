package com.example.application;

import com.example.model.user.UserInfo;
import com.example.service.UserInfoService;
import com.example.vo.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserApplication {

    @Autowired
    private UserInfoService userInfoService;

    public void saveAllUser(List<UserInfo> userInfoList) {
        userInfoService.saveAllUser(userInfoList);
    }

    /**
     * @param userInfo
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public ResultDTO findByPage(UserInfo userInfo, int pageNumber, int pageSize) {
        Page<UserInfo> userInfoPage = userInfoService.findAllByPage(userInfo, pageNumber, pageSize);
        return new ResultDTO(0, "OK", Math.toIntExact(userInfoPage.getTotalElements()),
                userInfoPage.getContent());
    }

}
