package example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * https://alibaba-easyexcel.github.io/quickstart/fill.html
 *
 * @author yichuan
 */
@EnableSwagger2
@SpringBootApplication
/**
 * 扫描mapper
 */
@MapperScan("example.model.mapper")
//https://www.cnblogs.com/goolu/p/8820318.html
//Mybatis 多表查询及查询结果映射
//mybatis递归查询父子菜单
//https://blog.csdn.net/m0_37882063/article/details/88633781
//https://blog.csdn.net/qq_36827957/article/details/78541832
//https://blog.csdn.net/wangruoao/article/details/85004060

public class EasyExcelMyBatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyExcelMyBatisApplication.class, args);
    }

    /**
     * 可以定义多个组，比如本类中定义把test和demo区分开了
     * （访问页面就可以看到效果了）
     */
    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("user")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")
                .select()
                //过滤的接口
                .paths(or(regex("/.*")))
                .build()
                .apiInfo(testApiInfo());
    }

    private ApiInfo testApiInfo() {
        ApiInfo apiInfo = new ApiInfo("基于EasyExcel的演示",
                //小标题
                "Alibaba EasyExcel测试",
                //版本
                "0.1",
                "NO terms of service",
                //作者
                "易川",
                //链接显示文字
                "yichuancq@163.com",
                "http://www.apache.org/licenses/LICENSE-2.0.html"
        );
        return apiInfo;
    }


}
