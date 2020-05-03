package example.controller;

import example.application.UserApplication;
import example.model.excel.UserInfoExportVo;
import example.util.ExcelUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author yichuan
 */
@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserApplication userApplication;

    /**
     * 查询所有
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getAll")
    @ApiOperation(value = "getAll", notes = "getAll")
    public ResponseEntity getAll()
            throws Exception {
        logger.info("userData");
        return ResponseEntity.ok(userApplication.getAll());
    }

    /**
     * 分页查询
     */
    @GetMapping("/getUsersPage")
    @ApiOperation(value = "getUsersPage", notes = "getUsersPage")
    public ResponseEntity getUsersPage(int pageNumber, int pageSize)
            throws Exception {
        logger.info("userData");
        return ResponseEntity.ok(userApplication.getUsersPage(pageNumber, pageSize));
    }

    /**
     * 分页查询
     */
    @GetMapping("/deleteUserById")
    @ApiOperation(value = "deleteUserById", notes = "deleteUserById")
    public ResponseEntity deleteUserById(long userId)
            throws Exception {
        logger.info("userData");
        return ResponseEntity.ok(userApplication.deleteOneById(userId));
    }


    /**
     * localhost:8080/exportUserInfoExcel?limit=1000&page=1
     *
     * @param response
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @GetMapping("/exportUserInfoExcel")
    @ApiOperation(value = "exportUserInfoExcel", notes = "exportUserInfoExcel")
    public void exportUserInfoExcel(HttpServletResponse response, int page, int limit)
            throws Exception {
        logger.info("page{},limit{}", page, limit);
        logger.info("userData");
        String fileName = "UserInfoExcel文件";
        String sheetName = "第一个sheet";
        ExcelUtil.writeExcel(response, userApplication.exportUserInfo(page, limit),
                fileName, sheetName, new UserInfoExportVo());
    }


}
