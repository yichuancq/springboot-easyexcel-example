
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chongmengzhao
 * @描述 json解析工具类
 */
public class JsonUtil {

    private static Integer level = 0;
    //当前层级
    private static Integer currentLevel = 0;
    //上一层级
    private static Integer upperLevel = 0;

    public static void main(String[] args) {
//        String json = "{\n" +
//                "\"id\":\"root\",\n" +
//                "\"topic\":\"至尊借款\",\n" +
//                "\"children\":[\n" +
//                "        {\"id\":\"a0\",\"topic\":\"1-3\",\"children\":[]},\n" +
//                "        {\"id\":\"a1\",\"topic\":\"4-10\",\"children\":[]},\n" +
//                "        {\"id\":\"a2\",\"topic\":\"11-30\",\"children\":[]},\n" +
//                "        {\"id\":\"a3\",\"topic\":\"31-60\",\"children\":[\n" +
//                "            {\"id\":\"p0a2\",\"topic\":\"20%\",\"children\":[]},\n" +
//                "            {\"id\":\"p1a2\",\"topic\":\"80%\",\"html\":\"<br/>\",\"children\":[\n" +
//                "               {\n" +
//                "                   \"id\":\"p1a2i0\",\n" +
//                "                   \"topic\":\"是否共债\",\n" +
//                "                   \"children\":[\n" +
//                "                       {\"id\":\"p1a2i0d0\",\"topic\":\"否共债\",},\n" +
//                "                       {\"id\":\"p1a2i0d1\",\"topic\":\"是共债\",\"children\":[\n" +
//                "                                                         {\"id\":\"p1a2i0d1x0\",\"topic\":\"信用等级\",\"children\":[{\"id\":\"p1a2i0d1x0l0\",\"topic\":\"信用等级A\"},{\"id\":\"p1a2i0d1x0l1\",\"topic\":\"信用等级B\"},{\"id\":\"p1a2i0d1x0l2\",\"topic\":\"信用等级C\"},{\"id\":\"p1a2i0d1x0l3\",\"topic\":\"信用等级D\"}]}\n" +
//                "                                                                    ]}\n" +
//                "                   ]}\n" +
//                "            ]}\n" +
//                "        ]},\n" +
//                "        {\"id\":\"a4\",\"topic\":\"61-90\",\"children\":[]},\n" +
//                "        {\"id\":\"a5\",\"topic\":\"91-120\",\"children\":[]},\n" +
//                "        {\"id\":\"a6\",\"topic\":\"121-9999\",\"children\":[]}\n" +
//                "    ]}";

        String json = "{\n" +
                "\t\"childPermissionList\": [{\n" +
                "\t\t\"childPermissionList\": [],\n" +
                "\t\t\"elementTypeEnum\": \"BUTTON\",\n" +
                "\t\t\"id\": 1012,\n" +
                "\t\t\"memo\": \"用户添加\",\n" +
                "\t\t\"parentId\": 1011,\n" +
                "\t\t\"permissionName\": \"用户添加\",\n" +
                "\n" +
                "\t\t\"url\": \"/user/add\",\n" +
                "\t\t\"version\": 0\n" +
                "\t}, {\n" +
                "\t\t\"childPermissionList\": [],\n" +
                "\n" +
                "\t\t\"elementTypeEnum\": \"BUTTON\",\n" +
                "\t\t\"id\": 1013,\n" +
                "\t\t\"memo\": \"用户删除\",\n" +
                "\t\t\"parentId\": 1011,\n" +
                "\t\t\"permissionName\": \"用户删除\",\n" +
                "\n" +
                "\t\t\"url\": \"/user/del\",\n" +
                "\t\t\"version\": 0\n" +
                "\t}],\n" +
                "\t\"elementTypeEnum\": \"BUTTON\",\n" +
                "\t\"id\": 1011,\n" +
                "\t\"memo\": \"test\",\n" +
                "\t\"parentId\": 0,\n" +
                "\t\"permissionName\": \"用户管理\",\n" +
                "\t\"url\": \"/user\",\n" +
                "\t\"version\": 0\n" +
                "}";
        parseJsonString(json);
    }

    /**
     * @描述 将json字符串解析为map
     * @author chongmengzhao
     */
    public static void parseJsonString(String json) {
        LinkedHashMap<String, Object> jsonMap = JSON.parseObject(json, new TypeReference<LinkedHashMap<String, Object>>() {
        });
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            parseJsonMap(entry);
        }
    }

    /**
     * @描述 map按动态的key解析值
     * @author chongmengzhao
     */
    public static void parseJsonMap(Map.Entry<String, Object> entry) {

        //如果是单个map继续遍历
        if (entry.getValue() instanceof Map) {
            LinkedHashMap<String, Object> jsonMap = JSON.parseObject(entry.getValue().toString(), new TypeReference<LinkedHashMap<String, Object>>() {
            });
            for (Map.Entry<String, Object> entry2 : jsonMap.entrySet()) {
                parseJsonMap(entry2);
            }
        }

        //如果是list就提取出来
        if (entry.getValue() instanceof List && ((List) entry.getValue()).size() > 0) {
            level++;
            currentLevel = level;
            List list = (List) entry.getValue();
            for (int i = 0; i < list.size(); i++) {
                parseJsonString(list.get(i).toString());
            }
            if (upperLevel < currentLevel) {
                level = level - 1;
            }
        }

        //如果是String就获取它的值
        if (entry.getValue() instanceof Integer) {
            System.out.println("开始解析第" + level + "层数据key：" + entry.getKey() + ",   value:" + entry.getValue());
            if (upperLevel == currentLevel) {
                upperLevel = level;
            }
        }

        //如果是String就获取它的值
        if (entry.getValue() instanceof String) {
            System.out.println("开始解析第" + level + "层数据key：" + entry.getKey() + ",   value:" + entry.getValue());
            if (upperLevel == currentLevel) {
                upperLevel = level;
            }
        }
        //如果是空JSONArray,就返回它的值
        if (entry.getValue() instanceof JSONArray && ((JSONArray) entry.getValue()).size() == 0) {
            System.out.println("开始解析第" + level + "层数据key：" + entry.getKey() + ",   value: []");
            if (upperLevel == currentLevel) {
                upperLevel = level;
            }
        }
    }

}
