# springboot-easyexcel-example
- 阿里巴巴开源easyexcel案例

```
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

```

  导出 Excel 时使用的映射实体类，Excel 模型
```

/**
 * 导出 Excel 时使用的映射实体类，Excel 模型
 *
 * @author yichuan
 */
@Data
public class UserInfoExportVo extends BaseRowModel {

    @ExcelProperty(value = "姓名", index = 0)
    private String name;

    @ExcelProperty(value = "年龄", index = 1)
    private Integer age;

    @ExcelProperty(value = "邮箱", index = 2)
    private String email;

    @ExcelProperty(value = "地址", index = 3)
    private String address;

    @ExcelProperty(value = "性别", index = 4)
    private UserSexEnum userSex;
    /**
     * 只支持 java.util.Date格式化
     */
    @ExcelProperty(value = "创建时间", format = "yyyy-MM-dd HH:mm:ss", index = 5)
    private Date createTime;

}

```

  配置mybatis分页
  
```
 public ResultDTO<UserInfo> getUsersPage(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<UserInfo> userInfos = userMapper.selectPage();
        return new ResultDTO(200, "", userInfos.size(), userInfos);
    }
```

