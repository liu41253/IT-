package com.lzh.it.controller;

import com.lzh.it.entity.JobPosition;
import com.lzh.it.service.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {
    
    @Autowired
    private JobPositionService jobPositionService;
    
    @GetMapping("/jobPositions")
    public List<JobPosition> getAllJobPositions() {
        return jobPositionService.getAllJobPositions();
    }
}