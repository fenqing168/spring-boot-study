package cn.fenqing168;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication Spring Boot 标识注解，表明这个类是Spring Boot 主程序类
 */
@SpringBootApplication
public class HelloWorldMainApplication {


    public static void main(String[] args) {
        // 执行Spring boot应用
        SpringApplication.run(HelloWorldMainApplication.class, args);
    }

}
