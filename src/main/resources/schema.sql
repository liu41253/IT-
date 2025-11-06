-- 创建IT岗位求职记录系统数据库表
-- 如果数据库不存在，创建数据库
CREATE DATABASE IF NOT EXISTS emo10;
USE emo10;

-- 创建岗位信息表
DROP TABLE IF EXISTS job_position;
CREATE TABLE job_position (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '岗位ID',
    company_name VARCHAR(100) NOT NULL COMMENT '企业名称',
    position_name VARCHAR(100) NOT NULL COMMENT '岗位名称',
    salary_min DECIMAL(10,2) COMMENT '最低薪资',
    salary_max DECIMAL(10,2) COMMENT '最高薪资',
    salary_unit VARCHAR(10) DEFAULT 'K/月' COMMENT '薪资单位',
    location VARCHAR(100) COMMENT '工作地点',
    experience_required VARCHAR(50) COMMENT '经验要求',
    education_required VARCHAR(50) COMMENT '学历要求',
    job_description TEXT COMMENT '岗位描述',
    job_requirements TEXT COMMENT '岗位要求',
    company_description TEXT COMMENT '企业描述',
    publish_date DATE COMMENT '发布日期',
    application_deadline DATE COMMENT '申请截止日期',
    contact_person VARCHAR(50) COMMENT '联系人',
    contact_phone VARCHAR(20) COMMENT '联系电话',
    contact_email VARCHAR(100) COMMENT '联系邮箱',
    status VARCHAR(20) DEFAULT '进行中' COMMENT '申请状态(进行中/已投递/面试中/已拒绝/已接受)',
    priority VARCHAR(20) DEFAULT '普通' COMMENT '优先级(高/中/低)',
    notes TEXT COMMENT '备注',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='IT岗位信息表';

-- 插入示例数据
INSERT INTO job_position (
    company_name, position_name, salary_min, salary_max, salary_unit, location, 
    experience_required, education_required, job_description, job_requirements,
    company_description, publish_date, application_deadline, contact_person, 
    contact_phone, contact_email, status, priority, notes
) VALUES 
(
    '阿里巴巴', 'Java开发工程师', 20, 35, 'K/月', '杭州', 
    '3-5年', '本科及以上', '负责电商平台后端系统开发，参与系统架构设计和优化', 
    '1. 熟悉Java编程语言，掌握Spring Boot、Spring Cloud等框架\n2. 熟悉MySQL数据库设计和优化\n3. 有高并发系统开发经验者优先',
    '阿里巴巴集团是全球领先的电子商务和科技公司', '2023-11-01', '2023-12-31', 
    '张经理', '13800138000', 'hr@alibaba.com', '进行中', '高', '心仪公司，薪资待遇好'
),
(
    '腾讯', '前端开发工程师', 18, 30, 'K/月', '深圳', 
    '2-4年', '本科及以上', '负责Web前端开发，参与产品界面设计和用户体验优化', 
    '1. 熟悉HTML5、CSS3、JavaScript等前端技术\n2. 熟悉Vue.js或React框架\n3. 有移动端开发经验者优先',
    '腾讯是中国领先的互联网科技公司', '2023-11-05', '2023-12-20', 
    '李主管', '13900139000', 'hr@tencent.com', '进行中', '高', '发展前景好'
),
(
    '字节跳动', 'Python开发工程师', 22, 40, 'K/月', '北京', 
    '3-5年', '本科及以上', '负责推荐算法和数据分析系统的开发', 
    '1. 熟悉Python编程语言，掌握Django或Flask框架\n2. 熟悉数据处理和分析\n3. 有机器学习或推荐系统经验者优先',
    '字节跳动是全球领先的移动互联网公司', '2023-11-10', '2024-01-15', 
    '王总监', '13700137000', 'hr@bytedance.com', '已投递', '中', '已提交简历'
),
(
    '美团', '测试工程师', 15, 25, 'K/月', '上海', 
    '1-3年', '本科及以上', '负责产品质量测试，制定测试计划和测试用例', 
    '1. 熟悉软件测试理论和测试方法\n2. 熟悉自动化测试工具\n3. 有接口测试经验者优先',
    '美团是中国领先的生活服务电子商务平台', '2023-11-15', '2023-12-25', 
    '赵经理', '13600136000', 'hr@meituan.com', '进行中', '中', '工作内容符合兴趣'
),
(
    '京东', '运维工程师', 18, 32, 'K/月', '北京', 
    '2-4年', '本科及以上', '负责系统运维和服务器管理，保障系统稳定运行', 
    '1. 熟悉Linux系统管理和Shell脚本\n2. 熟悉Docker、Kubernetes等容器技术\n3. 有云平台运维经验者优先',
    '京东是中国领先的综合电商平台', '2023-11-20', '2024-01-10', 
    '钱主管', '13500135000', 'hr@jd.com', '进行中', '低', '考虑中'
);