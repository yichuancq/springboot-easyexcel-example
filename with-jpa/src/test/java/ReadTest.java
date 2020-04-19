import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.example.EasyExcelApplication;
import com.example.model.ExportInfo;
import com.example.model.MultiLineHeadExcelModel;
import com.example.util.StyleExcelHandler;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EasyExcelApplication.class)
public class ReadTest {

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

    @Test
    public void write() throws Exception {
        StyleExcelHandler handler = new StyleExcelHandler();
        OutputStream outputStream = new FileOutputStream("Test2007.xlsx");
        // 这里要把上面创建的样式类通过构造函数传入
        ExcelWriter writer = new ExcelWriter(null, outputStream,
                ExcelTypeEnum.XLSX, true, handler);
        Sheet sheet1 = new Sheet(1, 1, ExportInfo.class,
                "userInfo", null);
        //设置列宽 设置每列的宽度
        Map columnWidth = new HashMap();
        columnWidth.put(0, 10000);
        columnWidth.put(1, 10000);
        columnWidth.put(2, 10000);
        columnWidth.put(3, 10000);
        sheet1.setColumnWidthMap(columnWidth);
        //或自适应宽度
        //sheet1.setAutoWidth(true);
        writer.write(getList(), sheet1);
        writer.finish();
        outputStream.close();

    }

    /** 复杂表头
     * @throws IOException
     */
    @Test
    public void writeWithMultiHead() throws IOException {
        try (OutputStream out = new FileOutputStream("withMultiHead.xlsx");) {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet1 = new Sheet(1, 0, MultiLineHeadExcelModel.class);
            sheet1.setSheetName("sheet1");
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
            writer.write(data, sheet1);
            writer.finish();
        }
    }
}
