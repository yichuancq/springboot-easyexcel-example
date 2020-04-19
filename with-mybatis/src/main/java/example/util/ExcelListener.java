package example.util;


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * 监听类，可以自定义
 */
public class ExcelListener extends AnalysisEventListener {
    /**
     * 批处理阈值2000
     */
    private static final int BATCH_COUNT = 2000;
    /**
     * 自定义用于暂时存储data。
     * 可以通过实例获取该值
     */

    private List<Object> datas = new ArrayList<>();

    /**
     * 通过 AnalysisContext 对象还可以获取当前 sheet，当前行等数据
     */
    @Override
    public void invoke(Object object, AnalysisContext context) {
        // 如数据过大，可以进行定量分批处理
        if (datas.size() <= BATCH_COUNT) {
            datas.add(object);
        } else {
            doSomething();
            datas = new ArrayList<Object>();
        }
    }

    /**
     * 根据业务自行实现该方法
     */
    private void doSomething() {
    }

    /**
     * 解析结束销毁不用的资源
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        datas.clear();
    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }
}