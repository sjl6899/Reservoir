package com.example.demo.service;

import com.example.demo.domain.Reservoir;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReservoirService {

    List<Reservoir> selectall();
}
