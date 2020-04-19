package com.example.controller;

import com.example.model.ExportInfo;
import com.example.model.ImportInfo;
import com.example.model.MultiLineHeadExcelModel;
import com.example.util.ExcelUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yichuan
 */
@RestController
public class ExcelController {
    /**
     * 读取 Excel（允许多个 sheet）
     */
    @RequestMapping(value = "readExcelWithSheets", method = RequestMethod.POST)
    @ApiOperation(value = "readExcelWithSheets", notes = "readExcelWithSheets")
    public Object readExcelWithSheets(MultipartFile excel) {
        return ExcelUtil.readExcel(excel, new ImportInfo());
    }

    /**
     * 读取 Excel（指定某个 sheet）
     */
    @ApiOperation(value = "readExcel", notes = "readExcel")
    @RequestMapping(value = "readExcel", method = RequestMethod.POST)
    public Object readExcel(MultipartFile excel, int sheetNo,
                            @RequestParam(defaultValue = "1") int headLineNum) {
        return ExcelUtil.readExcel(excel, new ImportInfo(), sheetNo, headLineNum);
    }

    /**
     * 导出 Excel（一个 sheet）
     */
    @ApiOperation(value = "writeExcel", notes = "writeExcel")
    @RequestMapping(value = "writeExcel", method = RequestMethod.GET)
    public void writeExcel(HttpServletResponse response) throws IOException {
        List<ExportInfo> list = getList();
        String fileName = "一个 Excel 文件";
        String sheetName = "第一个 sheet";

        ExcelUtil.writeExcel(response, list, fileName, sheetName, new ExportInfo());
    }

    /**
     * 导出 Excel（一个 sheet）
     */
    @ApiOperation(value = "writeMultiLineHeadExcel", notes = "一个复杂表头的Excel")
    @RequestMapping(value = "writeMultiLineHeadExcel", method = RequestMethod.GET)
    public void writeMultiLineHeadExcel(HttpServletResponse response) throws IOException {
        List<MultiLineHeadExcelModel> list = getMultiHeaderExcelData();
        String fileName = "一个复杂表头的Excel文件";
        String sheetName = "第一个 sheet";
        //
        ExcelUtil.writeExcel(response, list, fileName, sheetName, new ExportInfo());
    }

    private List<MultiLineHeadExcelModel> getMultiHeaderExcelData() {
        List<MultiLineHeadExcelModel> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            MultiLineHeadExcelModel item = new MultiLineHeadExcelModel();
            item.setP1("p1" + i);
            item.setP2("p2" + i);
            item.setP3("p3" + i);
            item.setP4("p4" + i);
            item.setP5("p5" + i);
            item.setP6("p6" + i);
            item.setP7("p7" + i);
            item.setP8("p8" + i);
            item.setP9("p9" + i);
            data.add(item);
        }
        return data;
    }


    private List<ExportInfo> getList() {
        List<ExportInfo> list = new ArrayList<>();
        ExportInfo model1 = new ExportInfo();
        model1.setName("howie");
        model1.setAge("19");
        model1.setAddress("123456789");
        model1.setEmail("123456789@gmail.com");
        list.add(model1);
        ExportInfo model2 = new ExportInfo();
        model2.setName("harry");
        model2.setAge("20");
        model2.setAddress("198752233");
        model2.setEmail("198752233@gmail.com");
        list.add(model2);
        return list;
    }
}
