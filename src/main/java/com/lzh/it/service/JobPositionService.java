package com.lzh.it.service;

import com.lzh.it.entity.JobPosition;
import java.util.List;

public interface JobPositionService {
    
    // 获取所有岗位
    List<JobPosition> getAllJobPositions();
    
    // 根据ID获取岗位
    JobPosition getJobPositionById(Long id);
    
    // 添加岗位
    boolean addJobPosition(JobPosition jobPosition);
    
    // 更新岗位
    boolean updateJobPosition(JobPosition jobPosition);
    
    // 删除岗位
    boolean deleteJobPosition(Long id);
    
    // 根据条件查询岗位
    List<JobPosition> searchJobPositions(String companyName, String positionName, 
                                        String location, String status);
}