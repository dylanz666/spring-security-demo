package com.github.dylanz666.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : dylanz
 * @since : 08/30/2020
 */
@RestController
public class HelloController {
    @GetMapping("/hello")//任何角色登录均可访问；
    public String sayHello() {
        return "Hello!";
    }

    @GetMapping("/ping")//无需登录即可访问；
    public String ping() {
        return "Success!";
    }

    @GetMapping("/admin/hello")//ADMIN角色登录方可访问；
    public String adminHello() {
        return "Hello admin!";
    }

    @GetMapping("/user/hello")//USER及比USER权限大的角色登录方可访问；
    public String userHello() {
        return "Hello user!";
    }
}
