package com.github.dylanz666.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : dylanz
 * @since : 08/30/2020
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello!";
    }

    @GetMapping("/ping")
    public String ping() {
        return "Success!";
    }

    @GetMapping("/admin/hello")
    public String adminHello() {
        return "Hello admin!";
    }

    @GetMapping("/user/hello")
    public String userHello() {
        return "Hello user!";
    }
}
