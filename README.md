# Spring Boot 入门
## 1、Spring Boot简介
> * 简化Spring应用开发的一个框架;<br>
> * 整个Spring技术栈的一大整合; <br/>
> * J2EE开发的一站式解决方案; <br/>
## 2、微服务
> * 2014，martin fowler<br/><br/>
> * 微服务： 架构风格<br/><br/>
> * 一个应用应该是一组小型服务； 可以通过HTTP的方式进行互通；<br/>


> * 每一个功能元素最终都是一个可独立替换的和独立升级的软件单元；<br/>

> * [详细参照微服务文档](https://martinfowler.com/articles/microservices.html#MicroservicesAndSoa)

> * 环境约束<br/>
> * -Spring Boot 官方推荐jdk1.及级以上<br/>
> * -maven3.x maven3.3以上<br/>
> * -IntelliJIDEA<br/>
> * -SpringBoot 1.5.9.RELEASE<br/>

> * 统一环境

> * maven设置的settings.xml配置文件的profiles标签添加设置编译选择的jdk版本<br>
```xml
<profile>    
    <id>jdk-1.8</id>    
    <activation>    
          <activeByDefault>true</activeByDefault>    
          <jdk>1.8</jdk>    
      </activation>    
    <properties>    
        <maven.compiler.source>1.8</maven.compiler.source>    
        <maven.compiler.target>1.8</maven.compiler.target>    
        <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>    
    </properties>     
</profile>
```
## 4、Spring Boot HelloWorld
* 一个功能：
* 浏览器发送hello请求，服务器接收请求并处理，响应Hello World字符串

### 1、创建一个maven工程（jar）
### 2、导入依赖Spring Boot相关的依赖
```xml
    <!-- 继承springboot父工程 -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.9.RELEASE</version>
    </parent>

    <!-- 添加web启动器依赖 -->
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
```
### 3、编写一个主程序；启动Spring Boot应用
```java
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
```
### 4、编写相关的Controller,Service 
```java
@Controller
public class HelloWorldController {

    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

}
```
### 5、运行主程序测试
### 6、部署程序
```xml
    <!-- 用来给Spring Boot项目打包成可执行文件的maven插件 -->
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
```
> * 将这个应用打成可执行jar包