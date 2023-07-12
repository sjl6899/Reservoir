package com.example.demo.controller;

import com.example.demo.domain.Reservoir;
import com.example.demo.service.ReservoirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/reservoir")
public class ReservoirController {
    @Autowired
    private ReservoirService reservoirService;
    @PostMapping("select")
    public List<Reservoir> selectAll(){
        return reservoirService.selectall();
    }
}
