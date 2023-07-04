package com.example.demo.service;

import com.example.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
//陈枳驿 2023-7-4-10:17
@Service
public interface UserService {
    List<User> selectall();
    int addUser(User user);
    int deleteUser(int userId);
    int updateUser(String name,String password,int userId);
    String selectpw(String name);
}
