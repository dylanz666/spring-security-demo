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
    public String sayHello() throws Exception {
        return "Hello!";
    }
}
