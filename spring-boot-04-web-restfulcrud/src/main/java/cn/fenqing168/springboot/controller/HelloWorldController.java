package cn.fenqing168.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloWorldController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/success")
    public String success(Map<String, Object> map){
        // classpath:/templates/success.html
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("张三", "李四", "王五"));
        return "success";
    }

}
