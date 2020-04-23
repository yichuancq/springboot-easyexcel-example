package example.controller;

import example.application.PermissonApplication;
import example.model.permission.SysPermission;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yichuan
 */
@RestController
public class PermissionController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PermissonApplication permissonApplication;

    /**
     * @param sysPermission
     */
    @ApiOperation(value = "/save/permission", notes = "批量保存权限")
    @RequestMapping(value = "/save/permission", method = RequestMethod.POST)
    public void savePermission(@RequestBody SysPermission sysPermission) {
        //
        // String json="{\"childPermissionList\":[{\"childPermissionList\":[],\"elementTypeEnum\":\"BUTTON\",\"id\":1012,\"memo\":\"用户添加\",\"parentId\":1011,\"permissionName\":\"用户添加\",\"url\":\"/user/add\",\"version\":0},{\"childPermissionList\":[],\"elementTypeEnum\":\"BUTTON\",\"id\":1013,\"memo\":\"用户删除\",\"parentId\":1011,\"permissionName\":\"用户删除\",\"url\":\"/user/del\",\"version\":0}],\"elementTypeEnum\":\"BUTTON\",\"id\":1011,\"memo\":\"test\",\"parentId\":0,\"permissionName\":\"用户管理\",\"url\":\"/user\",\"version\":0}";
        try {
            logger.info("sysPermission{}", sysPermission);
            permissonApplication.addPermission(sysPermission);
        } catch (Exception e) {
            e.getMessage();
        }
    }



}
