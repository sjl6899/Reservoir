package com.example.demo.service.Impl;

import com.example.demo.domain.Reservoir;
import com.example.demo.mapper.ReservoirMapper;
import com.example.demo.service.ReservoirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservoirServiceImpl implements ReservoirService {
    @Autowired
    private ReservoirMapper reservoirMapper;
    @Override
    public List<Reservoir> selectall() {
        return reservoirMapper.selectall();
    }
}
