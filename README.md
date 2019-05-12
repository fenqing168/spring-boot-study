# 一、Spring Boot 入门
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

## 5、Hello World探究
### 1、POM文件
#### 1.父项目
```xml
    <!-- 继承springboot父工程 -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.9.RELEASE</version>
    </parent>
```
> * 以及他的上一级父项目

```xml
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-dependencies</artifactId>
    <version>2.0.9.RELEASE</version>
    <relativePath>../spring-boot-dependencies</relativePath>
  </parent>
```
> * 它充当全部可能用到的jar包依赖
> * 可以称为Spring Boot的版本仲裁
> * 大部分依赖可以不需要写版本号（没有在dependencies工程里面的依赖，还需手动声明版本号）

#### 2、导入的依赖
```xml
    <!-- 添加web启动器依赖 -->
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
```
> * spring-boot-starter:spring-boot场景启动器; 帮我们导入了web模块正常运行所依赖的组件；
> * Spring Boot 将所有的功能场景抽取出来，做成一个个starters（启动器）,只需要在项目里面引入这些starter相关场景的所有依赖都会导入进来，要用什么功能就导入什么场景的启动器

### 2、Spring Boot主程序类，入口类
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
> * @**SpringBootApplication**: Spring Boot引用标注正在某个类上说明这个类是SpringBoot的主配置类， SpringBoot就应该运行这个类的main你方法来启动SpringBoot应用
```java
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
public @interface SpringBootApplication{}
```
> * @**SpringBootApplication**:Spring Boot的配置类；
>> * 标注在某个类上，表示这个是一个Spring Boot的配置类
>> * @**Configuration**:配置类上标注这个注解：
>>> * 配置类 ---> 配置文件；配置类也是容器中的组件@Component
> * @**EnableAutoConfiguration** Spring Boot 自动开启配置注解
>> * 以前我们需要配置的东西，Spring Boot帮我们自动配置； @**EnableAutoConfiguration**告诉我吗SpringBoot将开启自动配置功能；这样自动配置才能生效
```java
@AutoConfigurationPackage
@Import({AutoConfigurationImportSelector.class})
public @interface EnableAutoConfiguration {}
```
>> * @**AutoConfigurationPackage** 自动配置包
>>
>> * @Import({Registrar.class});
>>
>> * Spring的底层注解，@Import,给容器中导入一个组件；导入一个组件由Registrar.class
>>
>> * 将主配置陪（@SpringBootApplication ）的所在包下面的所有自雷所有组件扫描到Spring容器中
>>
>>   > ```java
>>   > @Import({AutoConfigurationImportSelector.class}) 
>>   > ```

> > >  给容器中导入组件？
> > >
> > > ```java
> > > AutoConfigurationImportSelector
> > > ```

> > > 导入哪些组件选择器；
> > >
> > > 将所需要导入的组件以全类名的方式返回，这些组件就会添加到容器中；
> > >
> > > 会给容器中导入非常多的自动配置类的（XXXConfiguration）；就是给容器中导入这个场景需要的所有组件，并配置好这些组件；
> > >
> > > 有了自动配置类，免去了手动编写配置注入功能组件的工作
> > > SpringFactoriesLoader.loadFactoryNames（EnableAutoConfiguration.class， classLoader）
> > >
> > > Spring Boot在启动的时候从类路径下的META-INF/spring.factories中获取EnableAutoConfiguration指定的值，将这些指定的值的自动配置类导入到容器中，自动配置了生效，帮我妈进行自动配置工作；以前我们需要自己配置的东西，自动配置类会将我们自动配置
> > >
> > > J2EE的整体整合方案都在spring-boot-autoconfigure-2.0.9.RELEASE.jar下

## 6、是用Spring Initializer快速创建Spring Boot项目

### 1.IDE都支持使用Spring的项目创建向导快速创建一个Spring Boot项目；

> 选择我们需要的模块，向导会帮我从互联网创建Spring Boot项目
>
> 默认生成的Spring Boot项目
>
> * 主程序已经生成好了，我们只要写我们的业务逻辑
> * resources文件夹的目录结构
> * static: 保存所有的静态资源；js css images
> * templates: 保存所有的模板页面；（Spring Boot 默认jar包使用嵌入式的tomcat，默然不支持jsp页面）；可以使用模板引擎（freemarker， thymeleaf）
> * application.properties:Spring Boot应用的配置文件；可以修改一些默认设置 

# 二、配置文件

## 1、配置文件

> SpringBoot使用一个全局的配置文件，配置文件是固定的；
>
> application.properties
>
> application.yml
>
> 配置文件的作用：修改SpringBoot自动配置的默认值；SpringBoot在底层给我们自动配置好；
>
> YAML(YAML Ain't Markup Language)
>
> > * YAML A Markup Language:是一个标记语言
>
> > * YAML isn't Markup Language：不是一个标记语言
>
> 标记语言：
>
> > * 以前的配置文件；大多都使用的是xxx.xml文件；
> >
> > * YAML：以数据为中心，比json、xml等更适合做配置文件
> >
> > * YAML:配置例子
> >
> > * ```yml
> >   server:
> >   	port:8081
> >   	```
> >```
> > 
> >* xml:
> > 
> >   * ```xml
> >   <server>
> >   	<prot>8081</prot>
> >   </server>
> >```
> >   

## 2、YAML语法

### 1、基本语法

> k:(空格)v：标识一堆键值对（空格必须有）
>
> 以空格的缩进来控制层级关系；只要是左对齐的一列数据，都是同一个层级的
>
> ```yml
> server:
>   port: 8081
>   path: /hello
> ```
>
> 属性和值是大小写敏感的

### 2、值的语法

> 字面量：普通的值（数字，字符串，布尔）
>
> > k:v ： 字面直接来写；
> >
> > > 字符串默认不用加上单引号 或者双引号
> > >
> > > "":双引号；不会转义字符串里面的特殊字符；特殊字符或作为本身想表示的意思
> > >
> > > > name:  "zhangsan \n lisi" : 输出: zhangsan 换行 lisi
> > >
> > > ''单引号；会总喜欢以特殊字符，特殊字符最终只是一个普通的字符串数据
> > >
> > > > name: 'zhangsan \n lisi' 输出：zhangsan \n lisi
>
> 对象，Map（属性和值）（j键值对）
>
> > k:v： 在下一行来写对象的属性和值的关系；注意缩进
> >
> > > 对象还是k:v 的方式
> > >
> > > ```yaml
> > > friends:
> > >   lastName: zhangsan
> > >   age: 20
> > > ```
> > >
> > > 行内写法
> > >
> > > ```yaml
> > > friends: {lastName: zhangsan, age: 18}
> > > ```
>
> 数组（List,Set）
>
> > 用- 值表示数组中的一个元素
> >
> > ```yaml
> > pets:
> >  - cat
> >  - dog
> >  - pig
> > ```
> >
> > 行内写法
> >
> > ```yaml
> > pets:[cat, dog, pig]
> > ```
> >
> > 