package com.example.model.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.example.model.user.UserSexEnum;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

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
    @Enumerated(EnumType.STRING)
    private UserSexEnum userSex;
    /**
     * 只支持 java.util.Date格式化
     */
    @ExcelProperty(value = "创建时间", format = "yyyy-MM-dd HH:mm:ss", index = 5)
    private Date createTime;

}
