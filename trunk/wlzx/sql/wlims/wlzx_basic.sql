-- phpMyAdmin SQL Dump
-- version 3.3.3
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2011 年 06 月 06 日 22:52
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
  `teacher_identify` char(14) NOT NULL COMMENT '身份证',
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
  `teacher_position` varchar(50) NOT NULL COMMENT '职务',
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
(1, 22, 'sas', 0, '2011-05-16', 0, '', 0, '', '', '', '', NULL, '12212', '1212', '0', '', '', '', '', NULL, '0', '', '', '', NULL, NULL, 0, NULL, '2011-05-31', '2011-05-31'),
(2, 24, 'ss', 0, '2011-05-17', 0, 'ss', 0, '', 'ss', '', '', NULL, '313131', '12', '0', '', '', '', '', NULL, '0', 'ss', '', '', NULL, NULL, 2, NULL, '2011-05-31', '2011-05-31'),
(3, 25, 'yufeng', 0, '2011-05-09', 0, 'ss', 0, '', 'sssss', '', '', NULL, '', '12313', '0', '', '', '', '', NULL, '0', '1212', '', '', NULL, NULL, 3, NULL, '2011-05-31', '2011-05-31');

-- --------------------------------------------------------

--
-- 表的结构 `basic_teacher_department`
--

CREATE TABLE IF NOT EXISTS `basic_teacher_department` (
  `department_id` int(20) NOT NULL auto_increment COMMENT '系统自增编号',
  `teacher_id` bigint(20) NOT NULL COMMENT '教师外键',
  `teacher_department` varchar(50) NOT NULL COMMENT '部门',
  `teacher_position` varchar(50) NOT NULL COMMENT '职务',
  PRIMARY KEY  (`department_id`),
  KEY `department_id` (`department_id`),
  KEY `teacher_id` (`teacher_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='教师所在其他部门' AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `basic_teacher_department`
--

INSERT INTO `basic_teacher_department` (`department_id`, `teacher_id`, `teacher_department`, `teacher_position`) VALUES
(1, 3, 's', 'ss'),
(2, 3, 's', 'ss');

-- --------------------------------------------------------

--
-- 表的结构 `basic_teacher_social_relation`
--

CREATE TABLE IF NOT EXISTS `basic_teacher_social_relation` (
  `relation_id` int(20) NOT NULL auto_increment COMMENT '系统自增编号',
  `teacher_id` bigint(20) NOT NULL COMMENT '教师外键',
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
  `teacher_id` bigint(20) NOT NULL COMMENT '教师外键',
  `experience_start_date` date NOT NULL COMMENT '开始时间',
  `experience_end_date` date NOT NULL COMMENT '结束时间',
  `experience_company` varchar(50) NOT NULL COMMENT '工作单位',
  `experience_position` varchar(50) NOT NULL COMMENT '职务',
  PRIMARY KEY  (`experience_id`),
  KEY `experience_id` (`experience_id`),
  KEY `teacher_id` (`teacher_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='教师工作经历' AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `basic_teacher_work_experience`
--

INSERT INTO `basic_teacher_work_experience` (`experience_id`, `teacher_id`, `experience_start_date`, `experience_end_date`, `experience_company`, `experience_position`) VALUES
(1, 3, '2011-06-22', '2011-06-22', 'w', 'w');

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- 转存表中的数据 `wlzx_basic_directory`
--

INSERT INTO `wlzx_basic_directory` (`id`, `name`, `value`, `type`, `sequence`, `extra_value`, `creation_date`, `modified_date`) VALUES
(7, '1', '1', 'placeType', 0, 'TP', '2011-05-26 23:06:02', '2011-05-27 13:43:00'),
(8, '2', '2', 'building', 2, 'BP', '2011-05-26 23:06:09', '2011-05-27 13:45:58');

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- 转存表中的数据 `wlzx_basic_place`
--

INSERT INTO `wlzx_basic_place` (`id`, `name`, `type`, `position`, `symbol`, `functions`, `area_begin`, `area_end`, `contain_begin`, `contain_end`, `remarks`, `creation_date`, `modified_date`) VALUES
(2, '会议室', '1', '2--111', 'undefined111', '教学;会客;', 1, 2, 1, 2, '会议室', '2011-05-27 13:43:49', '2011-05-27 13:43:49'),
(3, '啊啊啊啊啊啊啊', '1', '2--233', 'undefined233', '多媒体;教学;', 1, 2, 1, 2, '啊啊啊啊啊啊啊', '2011-05-27 13:45:24', '2011-05-27 13:45:24'),
(5, 'weg', '1', '2--1111', 'BP1111', '培训;教学;会客;', 1, 2, 2, 3, '', '2011-05-27 14:24:05', '2011-05-27 14:24:23'),
(6, 'gwe', '1', '2--22', 'BP22', '', 1, 2, 0, 0, '', '2011-05-27 14:25:26', '2011-05-27 14:25:26'),
(7, 'g2e2', '1', '2--222', 'BP222', '', 0, 0, 0, 0, '', '2011-05-27 14:28:56', '2011-05-27 14:28:56');
