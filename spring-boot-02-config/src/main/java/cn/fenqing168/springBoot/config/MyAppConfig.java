package cn.fenqing168.springBoot.config;

import cn.fenqing168.springBoot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration：当前类是一个配置类；就是来代替之前的Spring配置文件
 */
@Configuration
public class MyAppConfig {

    /**
     * 将方法的返回值添加到容器中；容器中这个组件默认的id就是方法名
     * @return
     */
    @Bean
    public HelloService helloService(){
        System.out.println("给容器中添加组件");
        return new HelloService();
    }

}
