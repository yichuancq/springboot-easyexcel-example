package example.application;


import com.github.pagehelper.PageHelper;
import example.model.excel.UserInfoExportVo;
import example.model.mapper.UserMapper;
import example.model.user.UserInfo;
import example.vo.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserApplication {

    @Autowired
    private UserMapper userMapper;

    public List<UserInfo> getAll() {
        return userMapper.getAll();
    }

    /**
     * 导出数据构造
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public List<UserInfoExportVo> exportUserInfo(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<UserInfo> userInfos = userMapper.selectPage();
        List<UserInfoExportVo> list = new ArrayList<>();
        for (UserInfo userInfoTemp : userInfos) {
            UserInfoExportVo model1 = new UserInfoExportVo();
            model1.setName(userInfoTemp.getName());
            model1.setAge(userInfoTemp.getAge());
            model1.setAddress(userInfoTemp.getAddress());
            model1.setEmail(userInfoTemp.getEmail());
            model1.setUserSex(userInfoTemp.getUserSex());
            //convert date
            LocalDateTime localDateTime = userInfoTemp.getCreateTime();
            Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
            model1.setCreateTime(date);
            list.add(model1);
        }
        return list;
    }


    /**
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public ResultDTO<UserInfo> getUsersPage(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<UserInfo> userInfos = userMapper.selectPage();
        return new ResultDTO(200, "", userInfos.size(), userInfos);
    }

}