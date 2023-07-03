package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController

@RequestMapping("/hello")
public class helloController {
@GetMapping("hello")
    public String hello(){
    return "hello";
}
}
