package com.example.demo.service;

import com.example.demo.domain.ZJreservoir;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ZJreservoirService {
    List<ZJreservoir> selectall();
}
