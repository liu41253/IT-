package com.lzh.it.service.impl;

import com.lzh.it.entity.JobPosition;
import com.lzh.it.mapper.JobPositionMapper;
import com.lzh.it.service.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionServiceImpl implements JobPositionService {
    
    @Autowired
    private JobPositionMapper jobPositionMapper;
    
    @Override
    public List<JobPosition> getAllJobPositions() {
        return jobPositionMapper.findAll();
    }
    
    @Override
    public JobPosition getJobPositionById(Long id) {
        return jobPositionMapper.findById(id);
    }
    
    @Override
    public boolean addJobPosition(JobPosition jobPosition) {
        return jobPositionMapper.insert(jobPosition) > 0;
    }
    
    @Override
    public boolean updateJobPosition(JobPosition jobPosition) {
        return jobPositionMapper.update(jobPosition) > 0;
    }
    
    @Override
    public boolean deleteJobPosition(Long id) {
        return jobPositionMapper.deleteById(id) > 0;
    }
    
    @Override
    public List<JobPosition> searchJobPositions(String companyName, String positionName, 
                                               String location, String status) {
        return jobPositionMapper.findByCondition(companyName, positionName, location, status);
    }
}