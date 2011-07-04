-- phpMyAdmin SQL Dump
-- version 3.3.3
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2011 年 07 月 04 日 12:27
-- 服务器版本: 5.0.91
-- PHP 版本: 5.2.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `wlzx_basic`
--

-- --------------------------------------------------------

--
-- 表的结构 `basic_teacher`
--

CREATE TABLE IF NOT EXISTS `basic_teacher` (
  `teacher_id` int(20) NOT NULL auto_increment COMMENT '系统自增编号',
  `user_id` bigint(20) NOT NULL COMMENT '账号外键',
  `teacher_cname` varchar(50) NOT NULL COMMENT '中文名',
  `teacher_sex` smallint(2) NOT NULL COMMENT '性别',
  `teacher_birthday` date NOT NULL COMMENT '出生日期',
  `teacher_marrage` smallint(2) NOT NULL COMMENT '婚姻',
  `teacher_nation` varchar(10) NOT NULL COMMENT '民族',
  `teacher_politics_status` smallint(2) NOT NULL COMMENT '政治面貌',
  `teacher_identify` char(20) NOT NULL COMMENT '身份证',
  `teacher_native_place` varchar(50) NOT NULL COMMENT '籍贯',
  `teacher_email` varchar(50) default NULL COMMENT '邮箱',
  `teacher_home_phone` varchar(20) NOT NULL COMMENT '家庭电话',
  `teacher_address` varchar(200) default NULL COMMENT '家庭地址',
  `teacher_mobile_phone` varchar(20) NOT NULL COMMENT '手机',
  `teacher_no` varchar(20) NOT NULL COMMENT '短号',
  `teacher_education` varchar(10) NOT NULL COMMENT '最高学历',
  `teacher_profession` varchar(50) NOT NULL COMMENT '专业',
  `teacher_graduate_school` varchar(100) NOT NULL COMMENT '毕业院校',
  `teacher_professional_title` varchar(50) default NULL COMMENT '职称',
  `teacher_skill_level` varchar(20) default NULL COMMENT '技能等级',
  `teacher_skill_level_date` date default NULL COMMENT '技能鉴定时间',
  `teacher_department` varchar(50) default NULL COMMENT '部门',
  `teacher_position` varchar(50) default NULL COMMENT '职务',
  `teacher_office_phone` varchar(20) default NULL COMMENT '办公电话',
  `teacher_contact_phone` varchar(50) default NULL COMMENT '紧要联络电话',
  `teacher_work_date` date default NULL COMMENT '何时工作',
  `teacher_attend_date` date default NULL COMMENT '入校时间',
  `teacher_status` tinyint(4) NOT NULL COMMENT '员工状态',
  `teacher_photo_src` varchar(200) default NULL COMMENT '照片地址',
  `teacher_create_date` date NOT NULL COMMENT '创建日期',
  `teacher_modified_date` date NOT NULL COMMENT '修改日期',
  PRIMARY KEY  (`teacher_id`),
  KEY `teacher_no` (`teacher_no`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='教师记录' AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `basic_teacher`
--

INSERT INTO `basic_teacher` (`teacher_id`, `user_id`, `teacher_cname`, `teacher_sex`, `teacher_birthday`, `teacher_marrage`, `teacher_nation`, `teacher_politics_status`, `teacher_identify`, `teacher_native_place`, `teacher_email`, `teacher_home_phone`, `teacher_address`, `teacher_mobile_phone`, `teacher_no`, `teacher_education`, `teacher_profession`, `teacher_graduate_school`, `teacher_professional_title`, `teacher_skill_level`, `teacher_skill_level_date`, `teacher_department`, `teacher_position`, `teacher_office_phone`, `teacher_contact_phone`, `teacher_work_date`, `teacher_attend_date`, `teacher_status`, `teacher_photo_src`, `teacher_create_date`, `teacher_modified_date`) VALUES
(1, 2, '余峰', 0, '1990-08-03', 1, '汉', 0, '', '', 'yufeng@126.com', '', '浙江衢州', '***********', '561963', '硕士', '计算机', '浙江大学', '高级', '1', '1990-08-03', NULL, NULL, '280561221', '', '1900-12-12', '1992-08-03', 1, NULL, '2011-07-02', '2011-07-02'),
(2, 3, '吴裕岳', 0, '1987-02-24', 0, '汉', 2, '******************', '浙江温州', 'wuyuyue@126.com', '0577-********', '浙江温州瑞安', '***********', '561997', '本科', '软件工程', '杭州电子科技大学', '高级', '2', '2005-08-03', NULL, NULL, '280561221', '13732261801', '2000-01-01', '2010-11-11', 1, NULL, '2011-07-02', '2011-07-02'),
(3, 4, '张三', 0, '2011-07-12', 0, 'A', 0, '111111111111111111', 'AB', '', '', '', '', '123456', '0', '', '', '', '', NULL, NULL, NULL, '', '', NULL, NULL, 0, 'uploads/basic/teacherProfile/default_head.jpg', '2011-07-04', '2011-07-04');

-- --------------------------------------------------------

--
-- 表的结构 `basic_teacher_social_relation`
--

CREATE TABLE IF NOT EXISTS `basic_teacher_social_relation` (
  `relation_id` int(20) NOT NULL auto_increment COMMENT '系统自增编号',
  `teacher_id` bigint(20) default NULL COMMENT '教师外键',
  `relation_name` varchar(20) NOT NULL COMMENT '姓名',
  `relation_with` varchar(20) NOT NULL COMMENT '与本人关系',
  `relation_company` varchar(50) NOT NULL COMMENT '所在工作单位',
  `relation_phone` varchar(20) NOT NULL COMMENT '联系电话',
  PRIMARY KEY  (`relation_id`),
  KEY `relation_id` (`relation_id`),
  KEY `teacher_id` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='社会关系' AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `basic_teacher_social_relation`
--


-- --------------------------------------------------------

--
-- 表的结构 `basic_teacher_work_experience`
--

CREATE TABLE IF NOT EXISTS `basic_teacher_work_experience` (
  `experience_id` int(20) NOT NULL auto_increment COMMENT '系统自增编号',
  `teacher_id` bigint(20) default NULL COMMENT '教师外键',
  `experience_start_date` date NOT NULL COMMENT '开始时间',
  `experience_end_date` date NOT NULL COMMENT '结束时间',
  `experience_company` varchar(50) NOT NULL COMMENT '工作单位',
  `experience_position` varchar(50) NOT NULL COMMENT '职务',
  PRIMARY KEY  (`experience_id`),
  KEY `experience_id` (`experience_id`),
  KEY `teacher_id` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师工作经历' AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `basic_teacher_work_experience`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_basic_directory`
--

CREATE TABLE IF NOT EXISTS `wlzx_basic_directory` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(200) NOT NULL,
  `value` varchar(200) NOT NULL,
  `type` varchar(200) NOT NULL,
  `sequence` int(11) NOT NULL default '0',
  `extra_value` varchar(200) default NULL,
  `creation_date` datetime NOT NULL,
  `modified_date` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_basic_directory`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_basic_place`
--

CREATE TABLE IF NOT EXISTS `wlzx_basic_place` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(200) NOT NULL,
  `type` varchar(200) NOT NULL,
  `position` varchar(200) NOT NULL,
  `symbol` varchar(200) NOT NULL,
  `functions` varchar(200) default NULL,
  `area_begin` float default NULL,
  `area_end` float default NULL,
  `contain_begin` int(11) default NULL,
  `contain_end` int(11) default NULL,
  `remarks` text,
  `creation_date` datetime NOT NULL,
  `modified_date` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_basic_place`
--

