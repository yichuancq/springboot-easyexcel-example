package example.application;


import com.github.pagehelper.PageHelper;
import example.model.excel.UserInfoExportVo;
import example.model.mapper.SysRoleMapper;
import example.model.mapper.UserMapper;
import example.model.mapper.UserRoleMapper;
import example.model.permission.SysPermission;
import example.model.role.SysRole;
import example.model.user.UserInfo;
import example.vo.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yichuan
 */
@Service
public class UserApplication {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private UserMapper userMapper;

    public List<UserInfo> getAll() {
        return userMapper.getAll();
    }


    /**
     * @param userId
     * @return
     */
    public List<SysPermission> getUserPermissionsByUserId(Long userId) {
        List<SysPermission> sysPermissionList = new ArrayList<>();
        List<SysRole> sysRoles = userRoleMapper.selectRolesByUserId(userId);
        //permission
        for (SysRole sysRole : sysRoles) {
            System.out.println("role:" + sysRole.getRoleName());
            List<SysPermission> sysPermissions = sysRoleMapper.selectPermissionsByRoleId(sysRole.getId());
            sysPermissionList.addAll(sysPermissions);
        }
        return sysPermissionList;
    }


    /**
     * @param userId
     * @return
     */
    public UserInfo findUserRoleByUserId(long userId) {
        return userMapper.findUserRolesByUserId(userId);
    }

    /**
     * findOneById
     *
     * @param userId
     * @return
     */
    public UserInfo findOneById(long userId) {
        return userMapper.findOneById(userId);
    }

    /**
     * deleteOneById
     *
     * @param userId
     */
    public Integer deleteOneById(long userId) {
        return userMapper.deleteOneById(userId);
    }

    /**
     * save
     *
     * @param userInfo
     * @return
     */
    public int saveUserInfo(UserInfo userInfo) {
        return userMapper.addUserInfo(userInfo);

    }

    public int saveAllUserInfo(List<UserInfo> userInfos) {
        return userMapper.addAllUserInfo(userInfos);
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
            model1.setCreateTime(userInfoTemp.getCreateTime());
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
