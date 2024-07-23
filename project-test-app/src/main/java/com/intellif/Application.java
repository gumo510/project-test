package com.intellif;

import com.intellif.trigger.http.TestController;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
@Configurable
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }

    /**
     * 打包执行某个方法逻辑 自动关闭
     * @param args
     * @throws Exception
     */
/*    public static void main(String[] args) throws Exception {
        // 创建Spring应用上下文
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        // 获取Web应用上下文
        WebApplicationContext webApplicationContext = (WebApplicationContext) context;

        // 获取Controller Bean
        TestController testController = webApplicationContext.getBean(TestController.class);

        // 调用Controller的某个方法
        String test = testController.getTest();

        // 你可以处理这个结果，比如打印输出
        System.out.println("方法执行结果: " + test);

        // 方法执行完毕，关闭Spring应用上下文
        context.close();

        // 正常退出应用
        System.exit(0);
    }*/

}
