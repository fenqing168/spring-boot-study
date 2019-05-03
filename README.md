# Spring Boot 入门
## 1、Spring Boot简介
> 简化Spring应用开发的一个框架;<br>
> 整个Spring技术栈的一大整合; <br/>
> J2EE开发的一站式解决方案; <br/>
## 2、微服务
2014，martin fowler<br/><br/>
微服务： 架构风格<br/><br/>
一个应用应该是一组小型服务； 可以通过HTTP的方式进行互通；<br/>


每一个功能元素最终都是一个可独立替换的和独立升级的软件单元；<br/>

[详细参照微服务文档](https://martinfowler.com/articles/microservices.html#MicroservicesAndSoa)

环境约束<br/>
-Spring Boot 官方推荐jdk1.及级以上<br/>
-maven3.x maven3.3以上<br/>
-IntelliJIDEA<br/>
-SpringBoot 1.5.9.RELEASE<br/>

统一环境

maven设置的settings.xml配置文件的profiles标签添加设置编译选择的jdk版本<br>
```java
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
