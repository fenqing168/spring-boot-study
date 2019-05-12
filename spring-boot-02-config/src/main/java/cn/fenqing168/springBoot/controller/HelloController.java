package cn.fenqing168.springBoot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${person.last-name}")
    private String name;

    @GetMapping("/hello")
    public String hello(){
        return "hello" + name;
    }

}
