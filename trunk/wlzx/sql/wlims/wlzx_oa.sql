-- phpMyAdmin SQL Dump
-- version 3.3.3
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2011 年 08 月 29 日 23:43
-- 服务器版本: 5.0.91
-- PHP 版本: 5.2.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `wlzx_oa`
--

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_attachment`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_attachment` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `path` varchar(100) NOT NULL,
  `type` varchar(10) NOT NULL,
  `size` bigint(20) NOT NULL,
  `upload_date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=31 ;

--
-- 转存表中的数据 `wlzx_oa_attachment`
--

INSERT INTO `wlzx_oa_attachment` (`id`, `name`, `path`, `type`, `size`, `upload_date`) VALUES
(1, 'task-2011-0725.doc', '110812095154.doc', 'doc', 37376, '2011-08-12 09:51:54'),
(2, '学鼎需求用例.doc', '110812095154.doc', 'doc', 360448, '2011-08-12 09:51:54'),
(3, '温岭行政结构_权限配置_通知方案.doc', 'attach_110812100228.doc', 'doc', 101376, '2011-08-12 10:02:28'),
(4, '温岭行政结构_权限配置-首页.doc', 'attach_110812100228.doc', 'doc', 146432, '2011-08-12 10:02:28'),
(5, '项目规划.doc', 'attach_110812100228.doc', 'doc', 21504, '2011-08-12 10:02:28'),
(6, '杭州池墨科技有限公司_股份制度.pdf', 'attach_110812115546.pdf', 'pdf', 136560, '2011-08-12 11:55:46'),
(7, '环境信息系统设计方案-20110615.pdf', 'attach_110812115546.pdf', 'pdf', 832565, '2011-08-12 11:55:46'),
(8, '火车票预订系统需求分析及设计_V1.3.doc', 'attach_110812115546.3.doc', '3.doc', 940544, '2011-08-12 11:55:46'),
(9, '上海动量软件技术有限公司介绍.pdf', 'attach_110812115546.pdf', 'pdf', 1810266, '2011-08-12 11:55:46'),
(10, '通达OA教育管理解决方案.pdf', 'attach_110812115547.pdf', 'pdf', 1280730, '2011-08-12 11:55:47'),
(11, '温岭OA系统BUG管理表.xls', 'attach_110812115548.xls', 'xls', 4714496, '2011-08-12 11:55:48'),
(12, '温岭行政结构_权限配置_0803.doc', 'attach_110812115548.doc', 'doc', 147968, '2011-08-12 11:55:48'),
(13, '温岭行政结构_权限配置_通知方案.doc', 'attach_110812115548.doc', 'doc', 101376, '2011-08-12 11:55:48'),
(14, '温岭行政结构_权限配置-首页.doc', 'attach_110812115549.doc', 'doc', 146432, '2011-08-12 11:55:49'),
(15, '项目规划.doc', 'attach_110812115549.doc', 'doc', 21504, '2011-08-12 11:55:49'),
(16, '项目章程.doc', 'attach_110812115550.doc', 'doc', 23552, '2011-08-12 11:55:50'),
(17, '需求用例模板.doc', 'attach_110812115550.doc', 'doc', 50176, '2011-08-12 11:55:50'),
(18, 'slogan_bg.jpg', 'attach_110827100357.jpg', 'jpg', 92643, '2011-08-27 22:03:57'),
(19, 'slogan_bg.png', 'attach_110827100357.png', 'png', 196571, '2011-08-27 22:03:57'),
(20, 'structure .png', 'attach_110827100357.png', 'png', 132249, '2011-08-27 22:03:57'),
(21, '2.jpg', 'attach_110827104931.jpg', 'jpg', 44379, '2011-08-27 22:49:31'),
(22, 'slogan_bg.jpg', 'attach_110827115947.jpg', 'jpg', 92643, '2011-08-27 23:59:47'),
(23, 'slogan_bg.png', 'attach_110827115948.png', 'png', 196571, '2011-08-27 23:59:48'),
(24, 'structure .png', 'attach_110827115948.png', 'png', 132249, '2011-08-27 23:59:48'),
(25, 'slogan_bg.jpg', 'attach_110828122306.jpg', 'jpg', 92643, '2011-08-28 00:23:06'),
(26, 'slogan_bg.png', 'attach_110828122307.png', 'png', 196571, '2011-08-28 00:23:07'),
(27, 'structure .png', 'attach_110828122307.png', 'png', 132249, '2011-08-28 00:23:07'),
(28, '2.jpg', 'attach_110828122914.jpg', 'jpg', 44379, '2011-08-28 00:29:14'),
(29, 'slogan_bg.png', 'attach_110829091421.png', 'png', 196571, '2011-08-29 09:14:21'),
(30, 'structure .png', 'attach_110829091422.png', 'png', 132249, '2011-08-29 09:14:22');

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_conference`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_conference` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(200) NOT NULL,
  `date` date NOT NULL,
  `time_begin` varchar(100) NOT NULL,
  `time_end` varchar(100) NOT NULL,
  `attend_num` int(11) NOT NULL,
  `teacher_attend_ids` text,
  `department_id` bigint(20) default NULL,
  `place_id` bigint(20) NOT NULL,
  `contact_user_id` bigint(20) NOT NULL,
  `contact_phone_number` varchar(200) NOT NULL,
  `service_needed` varchar(200) default NULL,
  `description` text,
  `apply_user_id` bigint(20) NOT NULL,
  `apply_time` datetime NOT NULL,
  `apply_status` smallint(6) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_oa_conference`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_conference_attachment_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_conference_attachment_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `conference_id` bigint(20) NOT NULL,
  `attachment_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_oa_conference_attachment_relationship`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_conference_summary_attachment_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_conference_summary_attachment_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `conference_id` bigint(20) NOT NULL,
  `attachment_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_oa_conference_summary_attachment_relationship`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_course_adjust_apply`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_course_adjust_apply` (
  `id` bigint(20) NOT NULL auto_increment,
  `apply_no` varchar(200) NOT NULL,
  `apply_type` int(11) NOT NULL default '0',
  `apply_teacher_id` bigint(20) NOT NULL,
  `apply_reason` text NOT NULL,
  `apply_status` int(11) NOT NULL default '0',
  `approve_teacher_id` bigint(20) default NULL,
  `approve_remark` text,
  `approve_date` datetime default NULL,
  `apply_creation_date` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_oa_course_adjust_apply`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_course_adjust_apply_item`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_course_adjust_apply_item` (
  `id` bigint(20) NOT NULL auto_increment,
  `apply_id` bigint(20) NOT NULL,
  `apply_class` varchar(200) NOT NULL,
  `apply_course` varchar(200) NOT NULL,
  `apply_course_date` datetime NOT NULL,
  `apply_course_time` varchar(200) NOT NULL,
  `adjust_mean_date` datetime default NULL,
  `adjust_mean_teacher_id` bigint(20) NOT NULL,
  `adjust_actual_date` datetime default NULL,
  `adjust_actual_time` varchar(200) default NULL,
  `adjust_actual_teacher_id` bigint(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_oa_course_adjust_apply_item`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_moverestday_apply`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_moverestday_apply` (
  `id` bigint(20) NOT NULL auto_increment,
  `moveRestDay_applyNo` varchar(200) NOT NULL,
  `moveRestDay_teacher_id` bigint(20) NOT NULL,
  `moveRestDay_times` text NOT NULL,
  `moveRestDay_officeChief_approver_id` bigint(20) default NULL,
  `moveRestDay_officeChief_approve_time` datetime default NULL,
  `moveRestDay_officeChief_approve_option` text,
  `moveRestDay_officeChief_status` tinyint(1) default NULL,
  `moveRestDay_vicePrincipal_approver_id` bigint(20) default NULL,
  `moveRestDay_vicePrincipal_approve_time` datetime default NULL,
  `moveRestDay_vicePrincipal_approve_option` text,
  `moveRestDay_vicePrincipal_status` tinyint(1) default NULL,
  `moveRestDay_status` int(11) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_oa_moverestday_apply`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_notice`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_notice` (
  `id` bigint(20) NOT NULL auto_increment,
  `scope` smallint(6) NOT NULL,
  `type` varchar(200) NOT NULL,
  `post_department_id` bigint(20) NOT NULL,
  `poster_id` bigint(20) default NULL,
  `emergence_flag` smallint(6) NOT NULL,
  `title` varchar(200) NOT NULL,
  `content` text,
  `postTime` datetime default NULL,
  `last_edit_time` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `last_editor_id` bigint(20) default NULL,
  `status` smallint(6) NOT NULL COMMENT '是否发布',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `wlzx_oa_notice`
--

INSERT INTO `wlzx_oa_notice` (`id`, `scope`, `type`, `post_department_id`, `poster_id`, `emergence_flag`, `title`, `content`, `postTime`, `last_edit_time`, `last_editor_id`, `status`) VALUES
(1, 1, '其他', 3, 708, 0, ' 1', ' 2', '2011-08-12 10:02:54', '2011-08-12 09:51:56', 708, 1);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_notice_attachment_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_notice_attachment_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `notice_id` bigint(20) NOT NULL,
  `attachment_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- 转存表中的数据 `wlzx_oa_notice_attachment_relationship`
--

INSERT INTO `wlzx_oa_notice_attachment_relationship` (`id`, `notice_id`, `attachment_id`) VALUES
(19, 2, 12),
(20, 2, 11);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_option`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_option` (
  `option_id` bigint(20) NOT NULL auto_increment COMMENT '系统自增编号',
  `option_name` varchar(50) character set utf8 NOT NULL COMMENT '字典名称',
  `option_value` varchar(120) character set utf8 NOT NULL COMMENT '字典值',
  `option_slug` varchar(50) character set utf8 NOT NULL COMMENT '字典类型',
  `option_description` varchar(120) character set utf8 default NULL COMMENT '字典描述',
  `option_extra_value` varchar(30) character set utf8 default NULL COMMENT '字典额外值',
  PRIMARY KEY  (`option_id`),
  KEY `option_slug` (`option_slug`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='数据字典表' AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_oa_option`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_overwork_apply`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_overwork_apply` (
  `id` bigint(20) NOT NULL auto_increment,
  `overWork_applyNo` varchar(200) NOT NULL,
  `overWork_teacher_id` bigint(20) NOT NULL,
  `overWork_times` text NOT NULL,
  `overWork_reason` text NOT NULL,
  `overWork_officeChief_approver_id` bigint(20) default NULL,
  `overWork_officeChief_approve_time` datetime default NULL,
  `overWork_officeChief_approve_option` text,
  `overWork_officeChief_status` smallint(6) default NULL,
  `overWork_status` int(11) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_oa_overwork_apply`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_receipt`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_receipt` (
  `id` bigint(20) NOT NULL auto_increment,
  `do_number` varchar(20) default NULL,
  `office` varchar(100) default NULL,
  `in_number` varchar(20) default NULL,
  `in_date` date default NULL,
  `subject` varchar(200) default NULL,
  `title` varchar(200) NOT NULL,
  `summary` text,
  `status` int(4) NOT NULL,
  `is_completed` int(4) NOT NULL,
  `registed_date` datetime default NULL,
  `receiver_id` bigint(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `wlzx_oa_receipt`
--

INSERT INTO `wlzx_oa_receipt` (`id`, `do_number`, `office`, `in_number`, `in_date`, `subject`, `title`, `summary`, `status`, `is_completed`, `registed_date`, `receiver_id`) VALUES
(1, '1+1', '1', '1', '2011-08-16', '1', '我12', '222222222222', 0, 0, NULL, NULL),
(2, '1+1', '2', '2', '2011-08-28', '222', '12', '222222', 3, 0, NULL, 708),
(3, '2+w', 'w', 'w', '2011-08-16', 'w', 'q', 'wq', 0, 0, NULL, 708);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_receipt_attachment`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_receipt_attachment` (
  `id` bigint(20) NOT NULL auto_increment,
  `receipt_id` bigint(20) NOT NULL,
  `attachment_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `receipt_id` (`receipt_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=78 ;

--
-- 转存表中的数据 `wlzx_oa_receipt_attachment`
--

INSERT INTO `wlzx_oa_receipt_attachment` (`id`, `receipt_id`, `attachment_id`) VALUES
(74, 2, 29),
(77, 1, 28);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_receipt_flow`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_receipt_flow` (
  `id` bigint(20) NOT NULL auto_increment,
  `type` smallint(6) NOT NULL,
  `is_completed` smallint(6) default NULL,
  `text` text,
  `user_id` bigint(20) NOT NULL,
  `receipt_id` bigint(20) NOT NULL,
  `completed_date` datetime default NULL,
  `creation_date` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `wlzx_oa_receipt_flow`
--

INSERT INTO `wlzx_oa_receipt_flow` (`id`, `type`, `is_completed`, `text`, `user_id`, `receipt_id`, `completed_date`, `creation_date`) VALUES
(1, 0, 1, '收文登记 ', 708, 2, '2011-08-29 17:16:04', '2011-08-28 01:55:15'),
(2, 2, 1, 'bbcccccc', 708, 2, '2011-08-29 23:41:30', '2011-08-29 11:03:15');

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_schedule`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_schedule` (
  `id` bigint(20) NOT NULL auto_increment,
  `title` text NOT NULL,
  `content` text,
  `begin_time` varchar(300) NOT NULL,
  `end_time` varchar(300) NOT NULL,
  `poster_id` bigint(20) NOT NULL,
  `type` smallint(6) NOT NULL,
  `department_share` smallint(6) default NULL,
  `school_share` smallint(6) default NULL,
  `department_id` bigint(20) default NULL,
  `emergence` smallint(6) NOT NULL,
  `finish_status` smallint(6) default NULL,
  `submit_status` smallint(6) default NULL,
  `repeat_status` smallint(6) default NULL,
  `repeat_type` smallint(6) default NULL,
  `repeat_interval` smallint(6) default NULL,
  `repeat_on_days` varchar(200) default NULL,
  `repeat_end_time` varchar(200) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `wlzx_oa_schedule`
--

INSERT INTO `wlzx_oa_schedule` (`id`, `title`, `content`, `begin_time`, `end_time`, `poster_id`, `type`, `department_share`, `school_share`, `department_id`, `emergence`, `finish_status`, `submit_status`, `repeat_status`, `repeat_type`, `repeat_interval`, `repeat_on_days`, `repeat_end_time`) VALUES
(1, '新日程1', '333333333', '2011-08-13 11:00:27', '2011-08-13 12:00:27', 708, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_sendingfiles`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_sendingfiles` (
  `id` bigint(20) NOT NULL auto_increment,
  `title` varchar(500) character set utf8 default NULL COMMENT '标题',
  `content` text character set utf8 NOT NULL COMMENT '内容',
  `author_id` bigint(20) NOT NULL COMMENT '拟稿人',
  `creation_date` datetime NOT NULL COMMENT '创建日期',
  `auspice_department` varchar(200) character set utf8 default NULL COMMENT '主办单位',
  `subject` varchar(500) character set utf8 default NULL COMMENT '事由',
  `main_sends` varchar(500) character set utf8 default NULL COMMENT '主送机关',
  `up_sends` varchar(500) character set utf8 default NULL COMMENT '抄报',
  `down_sends` varchar(500) character set utf8 default NULL COMMENT '抄送',
  `dispatch_word` varchar(100) character set utf8 default NULL COMMENT '发文机关代字',
  `dispatch_year` varchar(50) character set utf8 default NULL COMMENT '发文年份',
  `dispatch_number` varchar(50) character set utf8 default NULL COMMENT '发文序号',
  `dispatch_date` date default NULL COMMENT '封发日期',
  `status` smallint(6) NOT NULL default '0',
  `is_completed` smallint(6) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- 转存表中的数据 `wlzx_oa_sendingfiles`
--

INSERT INTO `wlzx_oa_sendingfiles` (`id`, `title`, `content`, `author_id`, `creation_date`, `auspice_department`, `subject`, `main_sends`, `up_sends`, `down_sends`, `dispatch_word`, `dispatch_year`, `dispatch_number`, `dispatch_date`, `status`, `is_completed`) VALUES
(1, '4', '<TEXTFORMAT LEADING="2"><P ALIGN="LEFT"><FONT FACE="宋体" SIZE="12" COLOR="#000000" LETTERSPACING="0" KERNING="0">1</FONT></P></TEXTFORMAT>', 708, '2011-08-12 11:06:46', '2', '3', '', '', '', '', '', '', NULL, 2, 0),
(2, '4', '<TEXTFORMAT LEADING="2"><P ALIGN="LEFT"><FONT FACE="宋体" SIZE="12" COLOR="#000000" LETTERSPACING="0" KERNING="0">1</FONT></P></TEXTFORMAT>', 708, '2011-08-12 11:56:54', '2', '3', '', '', '', '', '', '', NULL, 0, 0),
(3, '3', '<TEXTFORMAT LEADING="2"><P ALIGN="LEFT"><FONT FACE="宋体" SIZE="12" COLOR="#000000" LETTERSPACING="0" KERNING="0">1</FONT></P></TEXTFORMAT>', 708, '2011-08-12 12:10:07', '2', '2', '', '', '', '', '', '', NULL, 0, 0),
(4, '4', '<TEXTFORMAT LEADING="2"><P ALIGN="LEFT"><FONT FACE="宋体" SIZE="12" COLOR="#000000" LETTERSPACING="0" KERNING="0">1</FONT></P></TEXTFORMAT>', 708, '2011-08-12 12:28:22', '2', '3', '', '', '', '', '', '', NULL, 0, 0);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_sendingfiles_attachment`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_sendingfiles_attachment` (
  `id` bigint(20) NOT NULL auto_increment,
  `sendingfile_id` bigint(20) NOT NULL,
  `attachment_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- 转存表中的数据 `wlzx_oa_sendingfiles_attachment`
--

INSERT INTO `wlzx_oa_sendingfiles_attachment` (`id`, `sendingfile_id`, `attachment_id`) VALUES
(1, 1, 13),
(2, 1, 12),
(3, 1, 9),
(4, 1, 8),
(5, 1, 15),
(6, 1, 11),
(7, 1, 6),
(8, 1, 7),
(9, 1, 17),
(10, 1, 10),
(11, 1, 14),
(12, 1, 16);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_sendingfile_flow`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_sendingfile_flow` (
  `id` bigint(20) NOT NULL auto_increment,
  `type` smallint(4) NOT NULL,
  `is_completed` smallint(4) default NULL,
  `text` text,
  `user_id` bigint(20) NOT NULL,
  `sendingfile_id` bigint(20) NOT NULL,
  `completed_date` datetime default NULL,
  `creation_date` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- 转存表中的数据 `wlzx_oa_sendingfile_flow`
--

INSERT INTO `wlzx_oa_sendingfile_flow` (`id`, `type`, `is_completed`, `text`, `user_id`, `sendingfile_id`, `completed_date`, `creation_date`) VALUES
(1, 0, 1, NULL, 708, 1, '2011-08-29 20:32:13', '2011-08-12 11:06:46'),
(2, 0, NULL, '发文拟稿', 708, 2, NULL, '2011-08-12 11:56:54'),
(3, 0, NULL, '发文拟稿', 708, 3, NULL, '2011-08-12 12:10:07'),
(4, 0, 1, NULL, 708, 4, '2011-08-12 12:28:28', '2011-08-12 12:28:22'),
(5, 0, NULL, '发文拟稿', 708, 4, NULL, '2011-08-29 20:30:36'),
(6, 2, NULL, NULL, 708, 1, NULL, '2011-08-29 20:32:49');

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_takeleave_apply`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_takeleave_apply` (
  `id` bigint(20) NOT NULL auto_increment,
  `takeLeave_applyNo` varchar(200) NOT NULL,
  `takeLeave_type` int(11) NOT NULL default '0',
  `takeLeave_teacher_id` bigint(20) NOT NULL,
  `takeLeave_beginTime` varchar(200) NOT NULL,
  `takeLeave_endTime` varchar(200) NOT NULL,
  `takeLeave_reason` text,
  `takeLeave_arrange_tech` text,
  `takeLeave_arrange_tech_deal_already` tinyint(1) default NULL,
  `takeLeave_arrange_service` text,
  `takeLeave_arrange_service_deal_already` tinyint(1) default NULL,
  `takeLeave_arrange_manage` text,
  `takeLeave_arrange_manage_deal_already` tinyint(1) default NULL,
  `takeLeave_officeChief_approver_id` bigint(20) default NULL,
  `takeLeave_officeChief_approve_time` datetime default NULL,
  `takeLeave_officeChief_approve_option` text,
  `takeLeave_officeChief_status` tinyint(1) default NULL,
  `takeLeave_vicePrincipal_approver_id` bigint(20) default NULL,
  `takeLeave_vicePrincipal_approve_time` datetime default NULL,
  `takeLeave_vicePrincipal_approve_option` text,
  `takeLeave_vicePrincipal_status` tinyint(1) default NULL,
  `takeLeave_principal_approver_id` bigint(20) default NULL,
  `takeLeave_principal_approve_time` datetime default NULL,
  `takeLeave_principal_approve_option` text,
  `takeLeave_principal_status` tinyint(1) default NULL,
  `takeLeave_remark` text,
  `takeLeave_status` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_oa_takeleave_apply`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_takeleave_terminate`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_takeleave_terminate` (
  `id` bigint(20) NOT NULL auto_increment,
  `terminate_dateTime` varchar(200) NOT NULL,
  `terminate_reason` text,
  `terminate_applyTime` datetime NOT NULL,
  `terminate_officeApprover_id` bigint(20) default NULL,
  `terminate_officeApprover_option` text,
  `terminate_approveTime` datetime default NULL,
  `terminate_status` smallint(11) NOT NULL default '0',
  `takeLeave_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_oa_takeleave_terminate`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_task`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_task` (
  `id` bigint(20) NOT NULL auto_increment,
  `title` varchar(200) NOT NULL,
  `content` text NOT NULL,
  `assign_time` datetime NOT NULL,
  `assigner_id` bigint(20) NOT NULL,
  `last_editor_id` bigint(20) default NULL,
  `last_edit_time` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `worker_ids` text NOT NULL,
  `worker_status` text NOT NULL,
  `status` smallint(6) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_oa_task`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_workflow_log`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_workflow_log` (
  `id` bigint(20) NOT NULL auto_increment,
  `operation_object_type` varchar(200) NOT NULL,
  `operation_object_id` bigint(20) NOT NULL,
  `operation_teacher_id` bigint(20) NOT NULL,
  `operation_time` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  `operation_name` varchar(200) NOT NULL,
  `operation_result` text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_oa_workflow_log`
--

