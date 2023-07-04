package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//陈枳驿 2023-7-3-1:17
//测试类
@CrossOrigin
@RestController
@RequestMapping("/hello")
public class helloController {
@GetMapping("hello")
    public String hello(){
    return "hello";
}
}
