package com.lzh.it.controller;

import com.lzh.it.entity.JobPosition;
import com.lzh.it.service.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JobPositionController {
    
    @Autowired
    private JobPositionService jobPositionService;
    
    // 首页，显示所有岗位
    @GetMapping("/")
    public String index(Model model) {
        try {
            System.out.println("开始查询所有岗位");
            List<JobPosition> jobPositions = jobPositionService.getAllJobPositions();
            System.out.println("查询到岗位数量: " + jobPositions.size());
            model.addAttribute("jobPositions", jobPositions);
            // 添加搜索参数的默认值
            model.addAttribute("companyName", "");
            model.addAttribute("positionName", "");
            model.addAttribute("location", "");
            model.addAttribute("status", "");
        } catch (Exception e) {
            System.out.println("查询岗位失败: " + e.getMessage());
            e.printStackTrace();
            // 如果查询失败，使用空列表
            model.addAttribute("jobPositions", java.util.Collections.emptyList());
            model.addAttribute("companyName", "");
            model.addAttribute("positionName", "");
            model.addAttribute("location", "");
            model.addAttribute("status", "");
            model.addAttribute("error", "数据库查询失败: " + e.getMessage());
        }
        return "index";
    }
    
    // 搜索岗位
    @GetMapping("/search")
    public String search(@RequestParam(required = false) String companyName,
                        @RequestParam(required = false) String positionName,
                        @RequestParam(required = false) String location,
                        @RequestParam(required = false) String status,
                        Model model) {
        List<JobPosition> jobPositions = jobPositionService.searchJobPositions(
                companyName, positionName, location, status);
        model.addAttribute("jobPositions", jobPositions);
        model.addAttribute("companyName", companyName);
        model.addAttribute("positionName", positionName);
        model.addAttribute("location", location);
        model.addAttribute("status", status);
        return "index";
    }
    
    // 跳转到添加岗位页面
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("jobPosition", new JobPosition());
        return "add";
    }
    
    // 添加岗位
    @PostMapping("/add")
    public String addJobPosition(@ModelAttribute JobPosition jobPosition) {
        jobPositionService.addJobPosition(jobPosition);
        return "redirect:/";
    }
    
    // 跳转到编辑岗位页面
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        JobPosition jobPosition = jobPositionService.getJobPositionById(id);
        model.addAttribute("jobPosition", jobPosition);
        return "edit";
    }
    
    // 更新岗位
    @PostMapping("/edit/{id}")
    public String updateJobPosition(@PathVariable Long id, @ModelAttribute JobPosition jobPosition) {
        jobPosition.setId(id);
        jobPositionService.updateJobPosition(jobPosition);
        return "redirect:/";
    }
    
    // 删除岗位
    @GetMapping("/delete/{id}")
    public String deleteJobPosition(@PathVariable Long id) {
        jobPositionService.deleteJobPosition(id);
        return "redirect:/";
    }
    
    // 查看岗位详情
    @GetMapping("/view/{id}")
    public String viewJobPosition(@PathVariable Long id, Model model) {
        JobPosition jobPosition = jobPositionService.getJobPositionById(id);
        model.addAttribute("jobPosition", jobPosition);
        return "detail";
    }
}