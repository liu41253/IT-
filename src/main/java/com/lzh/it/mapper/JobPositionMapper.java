package com.lzh.it.mapper;

import com.lzh.it.entity.JobPosition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface JobPositionMapper {
    
    // 查询所有岗位
    List<JobPosition> findAll();
    
    // 根据ID查询岗位
    JobPosition findById(@Param("id") Long id);
    
    // 添加岗位
    int insert(JobPosition jobPosition);
    
    // 更新岗位
    int update(JobPosition jobPosition);
    
    // 删除岗位
    int deleteById(@Param("id") Long id);
    
    // 根据条件查询岗位
    List<JobPosition> findByCondition(@Param("companyName") String companyName, 
                                     @Param("positionName") String positionName,
                                     @Param("location") String location,
                                     @Param("status") String status);
}