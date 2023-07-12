package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.domain.ZJreservoir;
import com.example.demo.service.ZJreservoirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/zjreservoir")
public class ZJreservoirController {
    @Autowired
    private ZJreservoir zJreservoir;
    @Autowired
    private ZJreservoirService zJreservoirService;
    @PostMapping("select")
    public List<ZJreservoir> selectAll(){
        return zJreservoirService.selectall();
    }

}
