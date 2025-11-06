package com.lzh.it.entity;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class JobPosition {
    private Long id;
    private String companyName;
    private String positionName;
    private Double salaryMin;
    private Double salaryMax;
    private String salaryUnit;
    private String location;
    private String experienceRequired;
    private String educationRequired;
    private String jobDescription;
    private String jobRequirements;
    private String companyDescription;
    private LocalDate publishDate;
    private LocalDate applicationDeadline;
    private String contactPerson;
    private String contactPhone;
    private String contactEmail;
    private String status;
    private String priority;
    private String notes;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}