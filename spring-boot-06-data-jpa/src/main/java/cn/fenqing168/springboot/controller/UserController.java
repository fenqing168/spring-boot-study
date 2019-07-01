package cn.fenqing168.springboot.controller;

import cn.fenqing168.springboot.dao.UserDao;
import cn.fenqing168.springboot.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/user/{id}")
    public UserPojo getUser(@PathVariable("id") Integer id){
        UserPojo user = userDao.findOne(id);
        return user;
    }

    @GetMapping("/user")
    public UserPojo insertUser(UserPojo user){
        user = userDao.save(user);
        return user;
    }

}
