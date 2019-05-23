package cn.fenqing168.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author fenqing
 */
@Controller
public class LoginCountroller {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String, Object> map, HttpSession session){
        String passwordDefault = "123456";
        if(!StringUtils.isEmpty(username) && passwordDefault.equals(password)){
            //登陆成功,防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        }else{
            //登陆失败
            map.put("msg", "用户名密码错误");
            return "login";
        }

    }

}
