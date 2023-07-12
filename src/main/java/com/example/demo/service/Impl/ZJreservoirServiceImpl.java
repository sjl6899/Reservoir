package com.example.demo.service.Impl;

import com.example.demo.domain.ZJreservoir;
import com.example.demo.mapper.ZJreservoirMapper;
import com.example.demo.service.ZJreservoirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZJreservoirServiceImpl implements ZJreservoirService {
    @Autowired
    private ZJreservoirMapper zJreservoirMapper;
    @Override
    public List<ZJreservoir> selectall() {
        return zJreservoirMapper.selectall();
    }
}
