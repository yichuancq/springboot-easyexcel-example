package com.example.application;

import com.example.model.excel.UserInfoExportVo;
import com.example.model.user.UserInfo;
import com.example.service.UserInfoService;
import com.example.vo.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserApplication {

    @Autowired
    private UserInfoService userInfoService;

    public void saveAllUser(List<UserInfo> userInfoList) {
        userInfoService.saveAllUser(userInfoList);
    }


    /**
     * 导出数据转换
     *
     * @param userInfo
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public List<UserInfoExportVo> exportUserInfo(UserInfo userInfo, int pageNumber, int pageSize) {

        ResultDTO resultDTO = this.findByPage(userInfo, pageNumber, pageSize);
        List<UserInfo> userInfos = (List<UserInfo>) resultDTO.getData();
        List<UserInfoExportVo> list = new ArrayList<>();
        for (UserInfo userInfoTemp : userInfos) {
            UserInfoExportVo model1 = new UserInfoExportVo();
            model1.setName(userInfoTemp.getName());
            model1.setAge(userInfoTemp.getAge());
            model1.setAddress(userInfoTemp.getAddress());
            model1.setEmail(userInfoTemp.getEmail());
            model1.setUserSex(userInfoTemp.getUserSex());
            list.add(model1);
        }
        return list;
    }

    /**
     * 分页查询
     *
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
