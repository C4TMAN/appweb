package com.appweb.demo.web;

import com.appweb.demo.exception.SessionException;
import com.appweb.demo.mvc.annotation.RequestDecrypt;
import com.appweb.demo.mvc.annotation.ResponseEncrypt;
import com.appweb.demo.web.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxiaoman on 2018/10/17.
 */
@RestController
public class IndexController {
    final static List<User> users = new ArrayList();

    static{
        User user1 = User.builder().id("001").name("Ashe").age(23).build();
        users.add(user1);

        User user2 = User.builder().id("002").name("Echo").age(19).build();
        users.add(user2);

    }

    @RequestMapping("/index")
    public String index() {
        return "hello world";
    }

    @RequestMapping("/session")
    public void session() throws SessionException {
        throw new SessionException();
    }

    @RequestMapping("/queryUser")
    @RequestDecrypt
    @ResponseEncrypt
    public User queryUser(@RequestBody User user) {
        for(User u : users){
            if(user.getId().equals(u.getId()))
                return u;
        }
        return null;
    }
}
