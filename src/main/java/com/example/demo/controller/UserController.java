package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//陈枳驿 2023-7-4-10:17
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private User user;
    @Autowired
    private UserService userService;
    @PostMapping("select")
    public List<User> selectAll(){
        return userService.selectall();
    }
    @GetMapping("add")
    public String addUser(String username,String password){
        user.setUsername(username);
        user.setPassword(password);
        int i;
        i=userService.addUser(user);
        if(i==1){
            return "添加成功";
        }
        else {
            return "添加失败";
        }
    }
    @GetMapping("delete")
    public String deleteUser(int userId){
        int i;
        i=userService.deleteUser(userId);
        if(i==1){
            return "删除成功";
        }
        else {
            return "删除失败";
        }
    }
    @GetMapping("update")
    public String updateUser(String name,String password,int userId){
        int i;
        i=userService.updateUser(name,password,userId);
        if(i==1){
            return "修改成功";
        }
        else {
            return "修改失败";
        }
    }
    @RequestMapping("login")
    public String login(@RequestBody User user){
        String username=user.getUsername();
        String password=user.getPassword();
        if(password.equals(userService.selectpw(username))){
            return "success";
        }
        else if(userService.selectpw(username)==null){
            return "null";
        }
        else{
            return "err";
        }
    }
}
