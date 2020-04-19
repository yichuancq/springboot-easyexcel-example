package com.example.controller;

import com.example.application.UserApplication;
import com.example.model.excel.ExportInfo;
import com.example.model.user.UserInfo;
import com.example.util.ExcelUtil;
import com.example.vo.ResultDTO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserApplication userApplication;

    @GetMapping("/userList")
    @ApiOperation(value = "userList", notes = "userList")
    public ResponseEntity userList(UserInfo userInfo, int page, int limit)
            throws Exception {
        logger.info("page{},limit{}", page, limit);
        logger.info("userData");
        ResultDTO resultDTO = userApplication.findByPage(userInfo, page, limit);
        return ResponseEntity.ok(resultDTO);
    }

    /** localhost:8080/exportUserInfoExcel?limit=1000&page=1
     * @param response
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @GetMapping("/exportUserInfoExcel")
    @ApiOperation(value = "exportUserInfoExcel", notes = "exportUserInfoExcel")
    public void exportUserInfoExcel(HttpServletResponse response, UserInfo userInfo, int page, int limit)
            throws Exception {
        logger.info("page{},limit{}", page, limit);
        logger.info("userData");
        String fileName = "UserInfoExcel文件";
        String sheetName = "第一个sheet";
        ExcelUtil.writeExcel(response, userApplication.exportUserInfo(userInfo, page, limit),
                fileName, sheetName, new ExportInfo());
    }

}
