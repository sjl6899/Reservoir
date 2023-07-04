package com.example.demo.mapper;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
//陈枳驿 2023-7-4-10:17
@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> selectall();
    @Insert("insert into user (name,password) value (#{name},#{password})")
    int addUser(User user);
    @Delete("delete from user where userId=#{userId}")
    int deleteUser(int userId);
    @Update("update user set name=#{name},password=#{password} where userId=#{userId}")
    int updateUser(String name,String password,int userId);
    @Select("select password from user where name=#{name}")
    String selectpw(String name);
}
