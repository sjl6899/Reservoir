package com.example.demo.mapper;

import com.example.demo.domain.Reservoir;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ReservoirMapper {
    @Select("select * from reservoir")
    List<Reservoir> selectall();
}
