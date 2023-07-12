package com.example.demo.mapper;

import com.example.demo.domain.ZJreservoir;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ZJreservoirMapper {
    @Select("select * from zjreservoir")
    List<ZJreservoir> selectall();
}
