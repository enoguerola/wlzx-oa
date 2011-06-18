-- phpMyAdmin SQL Dump
-- version 3.3.3
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2011 年 06 月 16 日 10:57
-- 服务器版本: 5.0.91
-- PHP 版本: 5.2.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `wlzx_system`
--

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system`
--

CREATE TABLE IF NOT EXISTS `wlzx_system` (
  `id` bigint(20) NOT NULL auto_increment,
  `symbol` varchar(100) NOT NULL,
  `sequence` bigint(20) default '0',
  `name` varchar(100) NOT NULL,
  `detail` text,
  `index_path` varchar(200) NOT NULL,
  `system_icon` varchar(200) default NULL,
  `creation_date` datetime NOT NULL,
  `modified_date` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `symbol` (`symbol`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `wlzx_system`
--

INSERT INTO `wlzx_system` (`id`, `symbol`, `sequence`, `name`, `detail`, `index_path`, `system_icon`, `creation_date`, `modified_date`) VALUES
(1, 'root', 0, '温岭数字化校园系列', '数字化校园信息平台是以学校现有网络为基础，以服务于全校师生的教学、科研、生活为目的，建立在学校数据中心平台之上，涵盖了学校的信息化标准管理、学校管理、学生管理、教学管理、教职工管理、科研管理、财务管理、资产与设备管理、行政办公管理、数字图书资料管理等全方位的管理信息平台与信息服务平台。', 'system/index.swf', NULL, '2011-05-06 11:50:32', '2011-05-06 11:50:32'),
(2, 'basic', 0, '基础数据系统', '基础数据系统是数字化校园所有业务应用系统的公共数据库，处于中心位置，基础数据库保持最完整、最准确的数据，提供其他业务系统使用。基础数据库管理系统实现对基础数据库所有信息库的维护管理。', 'basic/index.swf', NULL, '2011-05-06 11:50:32', '2011-05-06 11:50:32'),
(3, 'oa', 0, '办公自动化系统', '办公自动化系统以公文流转为核心，实现办公流程的快速高效；同时提供多种部门间的信息交流的手段和渠道，加强部门间的沟通协作；提供信息共享的平台，实现公共资源的共享；提供辅助办公功能，为每一项业务提供相关信息，促进学校办公的成熟和规范化；提供强大的搜索查询功能，便于用户在日积月累的海量信息中快速的查找需要的内容', 'oa/index.swf', NULL, '2011-05-06 11:50:32', '2011-05-06 11:50:32');

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_data_access_mode`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_data_access_mode` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `symbol` varchar(100) NOT NULL,
  `sequence` bigint(20) default '0',
  `value` varchar(200) default NULL,
  `detail` text,
  `creation_date` datetime NOT NULL,
  `modified_date` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `symbol` (`symbol`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=52 ;

--
-- 转存表中的数据 `wlzx_system_data_access_mode`
--

INSERT INTO `wlzx_system_data_access_mode` (`id`, `name`, `symbol`, `sequence`, `value`, `detail`, `creation_date`, `modified_date`) VALUES
(3, '全部数据', 'basic_authorization_department_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-06 11:50:32', '2011-05-22 15:05:30'),
(4, '全部数据', 'basic_authorization_role_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-06 11:50:32', '2011-05-22 15:05:30'),
(5, '全部数据', 'basic_setting_department_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-06 11:50:32', '2011-05-22 15:05:30'),
(6, '全部数据', 'basic_setting_role_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-06 11:50:32', '2011-05-22 15:05:30'),
(7, '全部数据', 'notice_post_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-07 00:00:00', '2011-06-15 21:49:26'),
(8, '全部数据', 'department_notice_read_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-09 00:00:00', '2011-06-16 00:05:21'),
(9, '全部数据', 'notice_list_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-09 00:00:00', '2011-06-15 21:51:54'),
(11, '全部数据', 'work_to_deal_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-14 00:00:00', '2011-06-16 10:35:08'),
(12, '全部数据', 'public_schedule_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-14 00:00:00', '2011-06-16 10:38:11'),
(13, '全部数据', 'person_schedule_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-14 00:00:00', '2011-06-16 10:38:57'),
(14, '全部数据', 'person_work_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-14 00:00:00', '2011-06-16 10:33:33'),
(15, '全部数据', 'staff_work_assign_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-14 00:00:00', '2011-06-16 10:47:07'),
(16, '全部数据', 'public_address_book_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-14 00:00:00', '2011-05-22 15:05:30'),
(17, '全部数据', 'basic_data_staff_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-21 00:00:00', '2011-05-22 15:05:30'),
(18, '全部数据', 'basic_data_account_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-21 00:00:00', '2011-05-22 15:05:30'),
(19, '全部数据', 'staff_file_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-21 00:00:00', '2011-05-22 15:05:30'),
(20, '全部数据', 'system_account_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-21 00:00:00', '2011-05-22 15:05:30'),
(21, '全部数据', 'oa_department_set_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-21 00:00:00', '2011-05-22 15:05:30'),
(22, '全部数据', 'oa_role_set_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-21 00:00:00', '2011-05-22 15:05:30'),
(24, '全部数据', 'oa_role_authorization_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-21 00:00:00', '2011-05-22 15:05:30'),
(25, '全部数据', 'oa_pw_change_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-23 00:00:00', '2011-05-23 23:11:11'),
(27, '全部数据', 'places_manage_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-25 00:00:00', '2011-05-25 16:19:12'),
(28, '全部数据', 'basic_directory_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-26 00:00:00', '2011-05-26 09:51:43'),
(30, '全部数据', '@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-26 00:00:00', '2011-05-26 23:00:03'),
(31, '全部数据', 'staff_input_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-26 00:00:00', '2011-05-26 23:03:14'),
(32, '全部数据', 'adjust_class_apply_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-27 00:00:00', '2011-05-27 22:36:32'),
(33, '全部数据', 'adjust_class_apply_approve_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-05-27 00:00:00', '2011-05-27 22:37:40'),
(34, '全部数据', 'personal_message_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-06-06 00:00:00', '2011-06-06 17:19:37'),
(35, '全部数据', 'takeLeaveApply_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-06-06 00:00:00', '2011-06-06 17:21:58'),
(36, '全部数据', 'overWorkApply_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-06-06 00:00:00', '2011-06-10 16:09:35'),
(37, '全部数据', 'selfCanculateAttendance_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-06-06 00:00:00', '2011-06-10 21:22:21'),
(38, '全部数据', 'takeLeaveApprove_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-06-08 00:00:00', '2011-06-08 11:45:47'),
(39, '全部数据', 'takeLeaveWorkDeal@noFilter@', 0, NULL, NULL, '2011-06-08 00:00:00', '2011-06-08 13:32:46'),
(40, '全部数据', 'takeLeaveOfficeApprove@noFilter@', 0, NULL, NULL, '2011-06-08 00:00:00', '2011-06-08 13:26:23'),
(41, '全部数据', 'takeLeaveVicePrincipalApprove@noFilter@', 0, NULL, NULL, '2011-06-08 00:00:00', '2011-06-08 13:32:34'),
(42, '全部数据', 'takeLeavePrincipalApprove@noFilter@', 0, NULL, NULL, '2011-06-08 00:00:00', '2011-06-08 13:32:40'),
(43, '本处室请假出差数据（处室领导级别有效）', 'takeLeaveApprove_main@defaultVisit@@notSelfOfficeFilter@', 1, NULL, '', '2011-06-09 00:00:00', '2011-06-09 11:14:42'),
(44, '分管处室请假出差数据（副校长级别有效）', 'takeLeaveApprove_main@defaultVisit@@notSelfManagerFilter@', 2, NULL, '', '2011-06-09 00:00:00', '2011-06-09 11:14:09'),
(45, '全部数据', 'moveRestDay_apply_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-06-10 00:00:00', '2011-06-10 16:11:49'),
(46, '全部数据', 'overWork_approve_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-06-10 00:00:00', '2011-06-10 21:15:45'),
(47, '全部数据', 'moveRestDay_approve_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-06-10 00:00:00', '2011-06-10 21:16:34'),
(48, '全部数据', 'staffCanculateAttendance_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-06-10 00:00:00', '2011-06-10 21:23:26'),
(49, '全部数据', 'person_notice_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-06-16 00:00:00', '2011-06-16 00:04:01'),
(50, '全部数据', 'school_notice_read_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-06-16 00:00:00', '2011-06-16 00:04:50'),
(51, '全部数据', 'task_manager_main@defaultVisit@@noFilter@', 0, NULL, NULL, '2011-06-16 00:00:00', '2011-06-16 10:46:47');

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_department`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_department` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `symbol` varchar(100) NOT NULL,
  `phone` varchar(200) default NULL,
  `sequence` bigint(20) default '0',
  `detail` text,
  `creation_date` datetime NOT NULL,
  `modified_date` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `symbol` (`symbol`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='系统部门' AUTO_INCREMENT=13 ;

--
-- 转存表中的数据 `wlzx_system_department`
--

INSERT INTO `wlzx_system_department` (`id`, `name`, `symbol`, `phone`, `sequence`, `detail`, `creation_date`, `modified_date`) VALUES
(1, '行政组', 'root', NULL, 0, '', '2011-05-06 00:00:00', '2011-05-06 11:50:36'),
(3, '德育处', 'moral_education_office', NULL, 2, '', '2011-05-10 00:00:00', '2011-05-20 18:14:30'),
(6, '校长办公室', 'headmaster_office', NULL, 1, '', '2011-05-18 00:00:00', '2011-05-20 18:09:54'),
(9, '年级段管理委员会', 'grade_committee', '', 3, '', '2011-05-19 00:00:00', '2011-05-20 18:14:02'),
(10, '综践处', 'practice_education_office', '', 5, '', '2011-05-19 00:00:00', '2011-05-20 18:11:58'),
(11, '资源处', 'resources_office', '', 6, '', '2011-05-19 00:00:00', '2011-05-20 18:13:24'),
(12, '课程处', 'course_office', '', 4, '', '2011-05-20 00:00:00', '2011-05-20 18:12:52');

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_department_dam_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_department_dam_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `department_id` bigint(20) NOT NULL,
  `dam_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=53 ;

--
-- 转存表中的数据 `wlzx_system_department_dam_relationship`
--

INSERT INTO `wlzx_system_department_dam_relationship` (`id`, `department_id`, `dam_id`) VALUES
(29, 1, 16),
(32, 1, 19),
(33, 1, 22),
(35, 1, 24),
(36, 1, 15),
(37, 1, 13),
(38, 1, 14),
(39, 1, 11),
(40, 1, 12),
(41, 1, 21),
(42, 1, 20),
(44, 1, 7),
(45, 1, 9),
(46, 1, 8),
(47, 1, 17),
(48, 1, 18),
(49, 1, 3),
(50, 1, 6),
(51, 1, 5),
(52, 1, 4);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_department_leadship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_department_leadship` (
  `id` bigint(20) NOT NULL auto_increment,
  `leader_id` bigint(20) NOT NULL,
  `subordinate_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- 转存表中的数据 `wlzx_system_department_leadship`
--

INSERT INTO `wlzx_system_department_leadship` (`id`, `leader_id`, `subordinate_id`) VALUES
(2, 1, 3),
(5, 1, 6),
(8, 1, 9),
(9, 1, 10),
(10, 1, 11),
(11, 1, 12);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_department_role_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_department_role_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `department_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- 转存表中的数据 `wlzx_system_department_role_relationship`
--

INSERT INTO `wlzx_system_department_role_relationship` (`id`, `department_id`, `role_id`) VALUES
(1, 1, 1),
(3, 3, 3),
(6, 6, 6),
(9, 9, 15),
(10, 10, 16),
(11, 11, 17),
(12, 12, 22);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_menu`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_menu` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `symbol` varchar(100) NOT NULL,
  `sequence` bigint(20) default '0',
  `detail` text,
  `menu_icon` varchar(200) default NULL,
  `creation_date` datetime NOT NULL,
  `modified_date` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `symbol` (`symbol`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=64 ;

--
-- 转存表中的数据 `wlzx_system_menu`
--

INSERT INTO `wlzx_system_menu` (`id`, `name`, `symbol`, `sequence`, `detail`, `menu_icon`, `creation_date`, `modified_date`) VALUES
(1, '系统授权', 'basic_authorization', 0, NULL, NULL, '2011-05-06 11:50:32', '2011-05-06 11:50:32'),
(2, '部门授权', 'basic_authorization_department', 3, '', NULL, '2011-05-06 00:00:00', '2011-05-06 11:50:32'),
(3, '岗位授权', 'basic_authorization_role', 4, '', NULL, '2011-05-06 00:00:00', '2011-05-06 11:50:32'),
(4, '基础数据', 'basic_data', 0, NULL, NULL, '2011-05-06 11:50:32', '2011-05-06 11:50:32'),
(5, '员工基础', 'basic_data_staff', 2, '', NULL, '2011-05-06 00:00:00', '2011-05-06 11:50:32'),
(6, '系统设置', 'basic_setting', 0, NULL, NULL, '2011-05-06 11:50:32', '2011-05-06 11:50:32'),
(7, '部门设置', 'basic_setting_department', 1, '', NULL, '2011-05-06 00:00:00', '2011-05-06 11:50:32'),
(8, '岗位设置', 'basic_setting_role', 2, '', NULL, '2011-05-06 00:00:00', '2011-05-06 11:50:32'),
(9, '内部事务管理', 'oa_inside_affair', 2, '', 'oa_inside_affair', '2011-05-06 00:00:00', '2011-05-07 22:40:33'),
(10, '公文管理', 'oa_official_document', 3, '', 'oa_official_document', '2011-05-06 00:00:00', '2011-05-07 22:40:33'),
(11, '公共事务管理', 'oa_public_affair', 1, '', 'oa_public_affair', '2011-05-06 00:00:00', '2011-05-07 22:40:33'),
(12, '公告管理', 'notice_manage', 0, NULL, NULL, '2011-05-06 11:50:32', '2011-05-06 11:50:32'),
(13, '公告管理', 'notice_list', 4, '', NULL, '2011-05-06 00:00:00', '2011-05-06 11:50:32'),
(14, '公告发布', 'notice_post', 0, NULL, NULL, '2011-05-06 11:50:32', '2011-05-06 11:50:32'),
(16, '日程管理', 'scheduleManage', 0, NULL, NULL, '2011-05-06 11:50:32', '2011-05-06 11:50:32'),
(17, '学校管理', 'oa_school_affair', 4, '', 'oa_school_affair', '2011-05-06 00:00:00', '2011-05-07 22:40:33'),
(18, '系统管理', 'oa_system_management', 6, '', 'oa_system_management', '2011-05-06 00:00:00', '2011-05-07 22:40:33'),
(19, '部门与岗位', 'oa_school_affair_department_role', 0, NULL, NULL, '2011-05-06 11:50:33', '2011-05-06 11:50:33'),
(20, '部门公告', 'department_notice_read', 2, '', '', '2011-05-07 00:00:00', '2011-05-07 11:06:17'),
(21, '公共日程', 'public_schedule', 0, '', '', '2011-05-10 00:00:00', '2011-05-10 11:18:04'),
(22, '个人日程', 'person_schedule', 1, '', '', '2011-05-10 00:00:00', '2011-05-10 11:18:26'),
(23, '工作管理', 'work_management', 0, '', '', '2011-05-10 00:00:00', '2011-05-10 11:20:13'),
(24, '通讯录', 'address_book', 0, '', '', '2011-05-10 00:00:00', '2011-05-10 11:21:13'),
(26, '待办工作', 'work_to_deal', 1, '', '', '2011-05-10 00:00:00', '2011-05-10 11:23:24'),
(27, '我的工作', 'person_work', 2, '', '', '2011-05-10 00:00:00', '2011-05-10 11:25:18'),
(28, '工作指派', 'staff_work_assign', 3, '', '', '2011-05-10 00:00:00', '2011-05-10 11:26:18'),
(29, '公共通讯录', 'public_address_book', 0, '', '', '2011-05-10 00:00:00', '2011-05-10 11:28:18'),
(30, '帐号数据', 'basic_data_account', 1, '', '', '2011-05-21 00:00:00', '2011-05-21 09:27:24'),
(31, '人事管理', 'human_resource', 5, '', '', '2011-05-21 00:00:00', '2011-05-21 09:40:29'),
(32, '教师档案', 'staff_file', 1, '', '', '2011-05-21 00:00:00', '2011-05-21 09:44:43'),
(33, '帐号管理', 'system_account', 1, '', '', '2011-05-21 00:00:00', '2011-05-21 09:46:20'),
(34, '发文管理', 'document_dispatch ', 1, '', '', '2011-05-21 00:00:00', '2011-05-21 09:48:55'),
(35, '收文管理', 'document_receipt ', 2, '', '', '2011-05-21 00:00:00', '2011-05-21 09:49:28'),
(36, '部门设置', 'oa_department_set', 1, '', '', '2011-05-21 00:00:00', '2011-05-21 10:05:48'),
(37, '岗位设置', 'oa_role_set', 2, '', '', '2011-05-21 00:00:00', '2011-05-21 10:06:23'),
(39, '岗位授权', 'oa_role_authorization', 3, '', '', '2011-05-21 00:00:00', '2011-05-21 11:20:42'),
(40, '密码修改', 'oa_pw_change', 0, '', '', '2011-05-23 00:00:00', '2011-05-23 22:45:32'),
(41, '场所管理', 'places_manage', 0, '', '', '2011-05-25 00:00:00', '2011-05-25 10:16:25'),
(42, '数据字典', 'basic_directory', 0, '', '', '2011-05-26 00:00:00', '2011-05-26 09:50:57'),
(43, '教师录入', 'staff_input_menu', 0, '', '', '2011-05-26 00:00:00', '2011-05-26 22:58:28'),
(44, '调课管理', 'adjust_class', 0, '', '', '2011-05-27 00:00:00', '2011-05-27 22:28:44'),
(45, '会议管理', 'conference_manage', 0, '', '', '2011-05-27 00:00:00', '2011-05-27 22:29:34'),
(46, '考勤管理', 'attendance_manager', 0, '', '', '2011-05-27 00:00:00', '2011-05-27 22:30:15'),
(47, '调课申请', 'adjust_class_apply', 0, '', '', '2011-05-27 00:00:00', '2011-05-27 22:32:02'),
(48, '调课审批', 'adjust_class_apply_approve', 1, '', '', '2011-05-27 00:00:00', '2011-05-27 22:33:09'),
(49, '教师管理', 'teacher_manager', 0, '', '', '2011-05-27 00:00:00', '2011-05-27 22:38:31'),
(50, '个人办公', 'personal_office', 0, '', '', '2011-06-03 00:00:00', '2011-06-03 11:27:21'),
(51, '请假出差', 'personal_office_takeLeaveApply', 2, '', '', '2011-06-03 00:00:00', '2011-06-03 11:28:47'),
(52, '加班申请', 'personal_office_overWork Apply', 3, '', '', '2011-06-03 00:00:00', '2011-06-03 11:29:51'),
(53, '个人考勤', 'personal_office_canculateAttendance', 5, '', '', '2011-06-03 00:00:00', '2011-06-03 11:31:08'),
(54, '我的工作', 'personal_office_workDeal', 0, '', '', '2011-06-03 00:00:00', '2011-06-03 11:32:05'),
(55, '请假出差审批', 'attendance_manager_takeLeaveApprove', 0, '', '', '2011-06-03 00:00:00', '2011-06-03 11:33:25'),
(56, '加班审批', 'attendance_manager_overWorkApprove', 1, '', '', '2011-06-03 00:00:00', '2011-06-03 11:34:01'),
(57, '考勤统计', 'attendance_manager_canculateAttendance', 3, '', '', '2011-06-03 00:00:00', '2011-06-03 11:34:50'),
(58, '我的消息', 'personal_office_messageDeal', 1, '', '', '2011-06-03 00:00:00', '2011-06-03 11:36:28'),
(59, '调休申请', 'moveRestDay_apply', 4, '', '', '2011-06-10 00:00:00', '2011-06-10 16:10:32'),
(60, '调休审批', 'moveRestDay_approve', 2, '', '', '2011-06-10 00:00:00', '2011-06-10 21:14:42'),
(61, '我的公告', 'person_notice', 1, '', '', '2011-06-16 00:00:00', '2011-06-16 00:01:41'),
(62, '学校公告', 'school_notice_read', 3, '', '', '2011-06-16 00:00:00', '2011-06-16 00:02:52'),
(63, '工作查看', 'task_manager', 4, '', '', '2011-06-16 00:00:00', '2011-06-16 10:45:51');

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_menu_module_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_menu_module_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `menu_id` bigint(20) NOT NULL,
  `module_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=45 ;

--
-- 转存表中的数据 `wlzx_system_menu_module_relationship`
--

INSERT INTO `wlzx_system_menu_module_relationship` (`id`, `menu_id`, `module_id`) VALUES
(1, 2, 1),
(2, 3, 2),
(3, 7, 3),
(4, 8, 4),
(5, 14, 5),
(6, 20, 6),
(7, 13, 7),
(10, 26, 10),
(11, 21, 11),
(12, 22, 12),
(13, 27, 13),
(14, 28, 14),
(15, 29, 15),
(16, 5, 16),
(17, 30, 17),
(18, 32, 18),
(19, 33, 19),
(20, 36, 20),
(21, 37, 21),
(23, 39, 23),
(24, 40, 28),
(26, 41, 30),
(27, 42, 31),
(29, 43, 33),
(30, 43, 34),
(31, 47, 35),
(32, 48, 36),
(33, 58, 37),
(34, 51, 38),
(35, 52, 39),
(36, 53, 40),
(37, 55, 41),
(38, 59, 42),
(39, 56, 43),
(40, 60, 44),
(41, 57, 45),
(42, 61, 46),
(43, 62, 47),
(44, 63, 48);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_menu_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_menu_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `system_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- 转存表中的数据 `wlzx_system_menu_relationship`
--

INSERT INTO `wlzx_system_menu_relationship` (`id`, `system_id`, `menu_id`) VALUES
(1, 2, 1),
(2, 2, 4),
(3, 2, 6),
(4, 3, 9),
(5, 3, 10),
(6, 3, 11),
(7, 3, 17),
(8, 3, 18),
(9, 3, 31),
(10, 3, 50);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_menu_treeship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_menu_treeship` (
  `id` bigint(20) NOT NULL auto_increment,
  `parent_id` bigint(20) NOT NULL,
  `child_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=58 ;

--
-- 转存表中的数据 `wlzx_system_menu_treeship`
--

INSERT INTO `wlzx_system_menu_treeship` (`id`, `parent_id`, `child_id`) VALUES
(1, 1, 2),
(2, 1, 3),
(3, 4, 5),
(4, 6, 7),
(5, 6, 8),
(6, 11, 12),
(7, 11, 16),
(8, 12, 13),
(9, 12, 14),
(12, 19, 3),
(13, 19, 2),
(14, 19, 8),
(15, 19, 7),
(16, 12, 20),
(17, 16, 21),
(18, 16, 22),
(19, 9, 23),
(20, 9, 24),
(22, 23, 26),
(23, 23, 27),
(24, 23, 28),
(25, 24, 29),
(26, 4, 30),
(27, 49, 32),
(28, 18, 33),
(29, 10, 34),
(30, 10, 35),
(31, 17, 36),
(32, 17, 37),
(34, 18, 39),
(35, 18, 40),
(36, 17, 41),
(37, 18, 42),
(38, 49, 43),
(39, 9, 44),
(40, 9, 45),
(41, 9, 46),
(42, 44, 47),
(43, 44, 48),
(44, 31, 49),
(45, 50, 51),
(46, 50, 52),
(47, 50, 53),
(48, 50, 54),
(49, 46, 55),
(50, 46, 56),
(51, 46, 57),
(52, 50, 58),
(53, 50, 59),
(54, 46, 60),
(55, 12, 61),
(56, 12, 62),
(57, 23, 63);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_message`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_message` (
  `id` bigint(20) NOT NULL auto_increment,
  `from_user_id` bigint(20) default NULL,
  `to_user_id` bigint(20) NOT NULL,
  `status` int(11) NOT NULL default '0',
  `type` int(11) NOT NULL,
  `content` text NOT NULL,
  `creation_date` datetime NOT NULL,
  `read_date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_system_message`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_module`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_module` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `symbol` varchar(100) NOT NULL,
  `sequence` bigint(20) default '0',
  `detail` text,
  `creation_date` datetime NOT NULL,
  `modified_date` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  `url` varchar(500) default NULL,
  `parms` varchar(300) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `symbol` (`symbol`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=49 ;

--
-- 转存表中的数据 `wlzx_system_module`
--

INSERT INTO `wlzx_system_module` (`id`, `name`, `symbol`, `sequence`, `detail`, `creation_date`, `modified_date`, `url`, `parms`) VALUES
(1, '部门授权主模块', 'basic_authorization_department_main', 0, NULL, '2011-05-06 11:50:32', '2011-05-06 11:50:32', 'basic/authorization/departmentAuthorization.swf', NULL),
(2, '岗位授权主模块', 'basic_authorization_role_main', 0, NULL, '2011-05-06 11:50:32', '2011-05-06 11:50:32', 'basic/authorization/roleAuthorization.swf', NULL),
(3, '部门设置主模块', 'basic_setting_department_main', 0, NULL, '2011-05-06 11:50:32', '2011-05-06 11:50:32', 'basic/setting/departmentSetting.swf', NULL),
(4, '岗位设置主模块', 'basic_setting_role_main', 0, NULL, '2011-05-06 11:50:32', '2011-05-06 11:50:32', 'basic/setting/roleSetting.swf', NULL),
(5, '公告发布主模块', 'notice_post_main', 0, '', '2011-05-07 00:00:00', '2011-06-15 21:49:26', 'oa/notice/noticeManage.swf', 'add'),
(6, '部门公告阅读主模块', 'department_notice_read_main', 0, '', '2011-05-09 00:00:00', '2011-06-16 00:05:21', 'oa/notice/noticeList.swf', 'department'),
(7, '公告管理主模块', 'notice_list_main', 0, '', '2011-05-09 00:00:00', '2011-06-15 21:51:54', 'oa/notice/noticeManage.swf', 'list'),
(10, '待办工作主模块', 'work_to_deal_main', 0, '', '2011-05-14 00:00:00', '2011-06-16 10:35:08', 'oa/task/toDealTask.swf', ''),
(11, '公共日程主模块', 'public_schedule_main', 0, '', '2011-05-14 00:00:00', '2011-06-16 10:38:11', 'oa/schedule/publicSchedule.swf', ''),
(12, '个人日程主模块', 'person_schedule_main', 0, '', '2011-05-14 00:00:00', '2011-06-16 10:38:57', 'oa/schedule/personSchedule.swf', ''),
(13, '我的工作主模块', 'person_work_main', 0, '', '2011-05-14 00:00:00', '2011-06-16 10:33:33', 'oa/task/personTask.swf', ''),
(14, '工作指派主模块', 'staff_work_assign_main', 0, '', '2011-05-14 00:00:00', '2011-06-16 10:47:07', 'oa/task/taskManager.swf', 'add'),
(15, '公共通讯录主模块', 'public_address_book_main', 0, '', '2011-05-14 00:00:00', '2011-05-14 15:05:56', 'oa/communication/publicAddressBook.swf', NULL),
(16, '员工数据主模块', 'basic_data_staff_main', 0, '', '2011-05-21 00:00:00', '2011-05-21 09:30:48', 'basic/account/accountList.swf', NULL),
(17, '帐号数据主模块', 'basic_data_account_main', 0, '', '2011-05-21 00:00:00', '2011-05-21 09:31:31', 'basic/account/accountList.swf', NULL),
(18, '教师档案主模块', 'staff_file_main', 0, '', '2011-05-21 00:00:00', '2011-05-21 09:47:23', 'basic/staff/staffList.swf', NULL),
(19, '帐号管理主模块', 'system_account_main', 0, '', '2011-05-21 00:00:00', '2011-05-21 09:48:08', 'basic/account/accountList.swf', NULL),
(20, '部门设置主模块', 'oa_department_set_main', 0, '', '2011-05-21 00:00:00', '2011-05-21 14:06:34', 'basic/setting/departmentSetting.swf', NULL),
(21, '岗位设置主模块', 'oa_role_set_main', 0, '', '2011-05-21 00:00:00', '2011-05-21 10:09:11', 'basic/setting/roleSetting.swf', NULL),
(23, '岗位授权主模块', 'oa_role_authorization_main', 0, '', '2011-05-21 00:00:00', '2011-05-21 14:04:54', 'basic/authorization/roleAuthorization.swf', NULL),
(28, '密码修改主模块', 'oa_pw_change_main', 0, '', '2011-05-23 00:00:00', '2011-05-23 23:11:11', 'basic/account/accountPw.swf', NULL),
(30, '场所管理主模块', 'places_manage_main', 0, '', '2011-05-25 00:00:00', '2011-05-25 16:19:12', 'basic/place/placeList.swf', NULL),
(31, '数据字典主模块', 'basic_directory_main', 0, '', '2011-05-26 00:00:00', '2011-05-26 09:51:43', 'basic/directory/directoryList.swf', NULL),
(34, '教师录入主模块', 'staff_input_main', 0, '', '2011-05-26 00:00:00', '2011-05-26 23:03:14', 'basic/staff/staffInput.swf', NULL),
(35, '调课申请主模块', 'adjust_class_apply_main', 0, '', '2011-05-27 00:00:00', '2011-05-27 22:36:32', 'oa/course/adjust/adjustApply.swf', NULL),
(36, '调课审批主模块', 'adjust_class_apply_approve_main', 0, '', '2011-05-27 00:00:00', '2011-05-27 22:37:40', 'oa/course/adjust/adjustApprove.swf', NULL),
(37, '我的消息主模块', 'personal_message_main', 0, '', '2011-06-06 00:00:00', '2011-06-06 17:19:37', 'system/message/messageList.swf', NULL),
(38, '请假出差主模块', 'takeLeaveApply_main', 0, '', '2011-06-06 00:00:00', '2011-06-06 17:21:58', 'oa/attendance/takeLeaveApply.swf', NULL),
(39, '加班申请主模块', 'overWorkApply_main', 0, '', '2011-06-06 00:00:00', '2011-06-10 16:09:35', 'oa/attendance/overWorkApply.swf', NULL),
(40, '考勤统计主模块', 'selfCanculateAttendance_main', 0, '', '2011-06-06 00:00:00', '2011-06-10 21:22:21', 'oa/attendance/selfCanculateAttendance.swf', NULL),
(41, '请假出差审批主模块', 'takeLeaveApprove_main', 0, '', '2011-06-08 00:00:00', '2011-06-08 11:45:47', 'oa/attendance/takeLeaveApprove.swf', NULL),
(42, '调休申请主模块', 'moveRestDay_apply_main', 0, '', '2011-06-10 00:00:00', '2011-06-10 16:11:49', 'oa/attendance/moveRestDayApply.swf', NULL),
(43, '加班审批主模块', 'overWork_approve_main', 0, '', '2011-06-10 00:00:00', '2011-06-10 21:15:45', 'oa/attendance/overWorkApprove.swf', NULL),
(44, '调休审批主模块', 'moveRestDay_approve_main', 0, '', '2011-06-10 00:00:00', '2011-06-10 21:16:34', 'oa/attendance/moveRestDayApprove.swf', NULL),
(45, '员工考勤统计主模块', 'staffCanculateAttendance_main', 0, '', '2011-06-10 00:00:00', '2011-06-10 21:23:26', 'oa/attendance/canculateAttendance.swf', NULL),
(46, '我的公告主模块', 'person_notice_main', 0, '', '2011-06-16 00:00:00', '2011-06-16 00:04:01', 'oa/notice/personNotice.swf', ''),
(47, '学校公告主模块', 'school_notice_read_main', 0, '', '2011-06-16 00:00:00', '2011-06-16 00:04:50', 'oa/notice/noticeList.swf', 'school'),
(48, '工作查看主模块', 'task_manager_main', 0, '', '2011-06-16 00:00:00', '2011-06-16 10:46:47', 'oa/task/taskManager.swf', 'list');

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_module_operation_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_module_operation_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `module_id` bigint(20) NOT NULL,
  `operation_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=50 ;

--
-- 转存表中的数据 `wlzx_system_module_operation_relationship`
--

INSERT INTO `wlzx_system_module_operation_relationship` (`id`, `module_id`, `operation_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 2, 4),
(5, 3, 5),
(6, 4, 6),
(7, 5, 7),
(8, 6, 8),
(9, 7, 9),
(11, 10, 11),
(12, 11, 12),
(13, 12, 13),
(14, 13, 14),
(15, 14, 15),
(16, 15, 16),
(17, 16, 17),
(18, 17, 18),
(19, 18, 19),
(20, 19, 20),
(21, 20, 21),
(22, 21, 22),
(24, 23, 24),
(25, 28, 25),
(27, 30, 27),
(28, 31, 28),
(30, 33, 30),
(31, 34, 31),
(32, 35, 32),
(33, 36, 33),
(34, 37, 34),
(35, 38, 35),
(36, 39, 36),
(37, 40, 37),
(38, 41, 38),
(39, 41, 39),
(40, 41, 40),
(41, 41, 41),
(42, 41, 42),
(43, 42, 43),
(44, 43, 44),
(45, 44, 45),
(46, 45, 46),
(47, 46, 47),
(48, 47, 48),
(49, 48, 49);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_module_treeship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_module_treeship` (
  `id` bigint(20) NOT NULL auto_increment,
  `parent_id` bigint(20) NOT NULL,
  `child_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_system_module_treeship`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_operation`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_operation` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `symbol` varchar(100) NOT NULL,
  `sequence` bigint(20) default '0',
  `rs_type` varchar(100) NOT NULL,
  `rs_value` varchar(200) NOT NULL,
  `detail` text,
  `creation_date` datetime NOT NULL,
  `modified_date` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `symbol` (`symbol`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=50 ;

--
-- 转存表中的数据 `wlzx_system_operation`
--

INSERT INTO `wlzx_system_operation` (`id`, `name`, `symbol`, `sequence`, `rs_type`, `rs_value`, `detail`, `creation_date`, `modified_date`) VALUES
(3, '页面访问', 'basic_authorization_department_main@defaultVisit@', 0, 'URL', '/basic/authorization/departmentAuthorization.swf*', NULL, '2011-05-06 11:50:32', '2011-05-22 15:06:06'),
(4, '页面访问', 'basic_authorization_role_main@defaultVisit@', 0, 'URL', '/basic/authorization/roleAuthorization.swf*', NULL, '2011-05-06 11:50:32', '2011-05-22 15:06:06'),
(5, '页面访问', 'basic_setting_department_main@defaultVisit@', 0, 'URL', '/basic/setting/departmentSetting.swf*', NULL, '2011-05-06 11:50:32', '2011-05-22 15:06:06'),
(6, '页面访问', 'basic_setting_role_main@defaultVisit@', 0, 'URL', '/basic/setting/roleSetting.swf*', NULL, '2011-05-06 11:50:32', '2011-05-22 15:06:06'),
(7, '页面访问', 'notice_post_main@defaultVisit@', 0, 'URL', '/oa/notice/noticeManage.swf*', NULL, '2011-05-07 00:00:00', '2011-06-15 21:49:26'),
(8, '页面访问', 'department_notice_read_main@defaultVisit@', 0, 'URL', '/oa/notice/noticeList.swf*', NULL, '2011-05-09 00:00:00', '2011-06-16 00:05:21'),
(9, '页面访问', 'notice_list_main@defaultVisit@', 0, 'URL', '/oa/notice/noticeManage.swf*', NULL, '2011-05-09 00:00:00', '2011-06-15 21:51:54'),
(11, '页面访问', 'work_to_deal_main@defaultVisit@', 0, 'URL', '/oa/task/toDealTask.swf*', NULL, '2011-05-14 00:00:00', '2011-06-16 10:35:08'),
(12, '页面访问', 'public_schedule_main@defaultVisit@', 0, 'URL', '/oa/schedule/publicSchedule.swf*', NULL, '2011-05-14 00:00:00', '2011-06-16 10:38:11'),
(13, '页面访问', 'person_schedule_main@defaultVisit@', 0, 'URL', '/oa/schedule/personSchedule.swf*', NULL, '2011-05-14 00:00:00', '2011-06-16 10:38:57'),
(14, '页面访问', 'person_work_main@defaultVisit@', 0, 'URL', '/oa/task/personTask.swf*', NULL, '2011-05-14 00:00:00', '2011-06-16 10:33:33'),
(15, '页面访问', 'staff_work_assign_main@defaultVisit@', 0, 'URL', '/oa/task/taskManager.swf*', NULL, '2011-05-14 00:00:00', '2011-06-16 10:47:07'),
(16, '页面访问', 'public_address_book_main@defaultVisit@', 0, 'URL', '/oa/communication/publicAddressBook.swf*', NULL, '2011-05-14 00:00:00', '2011-05-22 15:06:06'),
(17, '页面访问', 'basic_data_staff_main@defaultVisit@', 0, 'URL', '/basic/account/accountList.swf*', NULL, '2011-05-21 00:00:00', '2011-05-22 15:06:06'),
(18, '页面访问', 'basic_data_account_main@defaultVisit@', 0, 'URL', '/basic/account/accountList.swf*', NULL, '2011-05-21 00:00:00', '2011-05-22 15:06:06'),
(19, '页面访问', 'staff_file_main@defaultVisit@', 0, 'URL', '/basic/staff/staffList.swf*', NULL, '2011-05-21 00:00:00', '2011-05-22 15:06:06'),
(20, '页面访问', 'system_account_main@defaultVisit@', 0, 'URL', '/basic/account/accountList.swf*', NULL, '2011-05-21 00:00:00', '2011-05-22 15:06:06'),
(21, '页面访问', 'oa_department_set_main@defaultVisit@', 0, 'URL', '/basic/setting/departmentSetting.swf*', NULL, '2011-05-21 00:00:00', '2011-05-22 15:06:06'),
(22, '页面访问', 'oa_role_set_main@defaultVisit@', 0, 'URL', '/basic/setting/roleSetting.swf*', NULL, '2011-05-21 00:00:00', '2011-05-22 15:06:06'),
(24, '页面访问', 'oa_role_authorization_main@defaultVisit@', 0, 'URL', '/basic/authorization/roleAuthorization.swf*', NULL, '2011-05-21 00:00:00', '2011-05-22 15:06:06'),
(25, '页面访问', 'oa_pw_change_main@defaultVisit@', 0, 'URL', '/basic/account/accountPw.swf*', NULL, '2011-05-23 00:00:00', '2011-05-23 23:11:11'),
(27, '页面访问', 'places_manage_main@defaultVisit@', 0, 'URL', '/basic/place/placeList.swf*', NULL, '2011-05-25 00:00:00', '2011-05-25 16:19:12'),
(28, '页面访问', 'basic_directory_main@defaultVisit@', 0, 'URL', '/basic/directory/directoryList.swf*', NULL, '2011-05-26 00:00:00', '2011-05-26 09:51:43'),
(30, '页面访问', '@defaultVisit@', 0, 'URL', '/basic/staff/staffInput.swf*', NULL, '2011-05-26 00:00:00', '2011-05-26 23:00:03'),
(31, '页面访问', 'staff_input_main@defaultVisit@', 0, 'URL', '/basic/staff/staffInput.swf*', NULL, '2011-05-26 00:00:00', '2011-05-26 23:03:14'),
(32, '页面访问', 'adjust_class_apply_main@defaultVisit@', 0, 'URL', '/oa/course/adjust/adjustApply.swf*', NULL, '2011-05-27 00:00:00', '2011-05-27 22:36:32'),
(33, '页面访问', 'adjust_class_apply_approve_main@defaultVisit@', 0, 'URL', '/oa/course/adjust/adjustApprove.swf*', NULL, '2011-05-27 00:00:00', '2011-05-27 22:37:40'),
(34, '页面访问', 'personal_message_main@defaultVisit@', 0, 'URL', '/system/message/messageList.swf*', NULL, '2011-06-06 00:00:00', '2011-06-06 17:19:37'),
(35, '页面访问', 'takeLeaveApply_main@defaultVisit@', 0, 'URL', '/oa/attendance/takeLeaveApply.swf*', NULL, '2011-06-06 00:00:00', '2011-06-06 17:21:58'),
(36, '页面访问', 'overWorkApply_main@defaultVisit@', 0, 'URL', '/oa/attendance/overWorkApply.swf*', NULL, '2011-06-06 00:00:00', '2011-06-10 16:09:35'),
(37, '页面访问', 'selfCanculateAttendance_main@defaultVisit@', 0, 'URL', '/oa/attendance/selfCanculateAttendance.swf*', NULL, '2011-06-06 00:00:00', '2011-06-10 21:22:21'),
(38, '页面访问', 'takeLeaveApprove_main@defaultVisit@', 0, 'URL', '/oa/attendance/takeLeaveApprove.swf*', NULL, '2011-06-08 00:00:00', '2011-06-08 11:45:47'),
(39, '请假出差工作落实', 'takeLeaveWorkDeal', 4, 'METHOD', 'takeLeaveWorkDeal()', '', '2011-06-08 00:00:00', '2011-06-08 15:27:48'),
(40, '请假出差处室审批', 'takeLeaveOfficeApprove', 1, 'METHOD', 'takeLeaveOfficeApprove()', '', '2011-06-08 00:00:00', '2011-06-08 15:27:31'),
(41, '请假出差副校长审批', 'takeLeaveVicePrincipalApprove', 2, 'METHOD', 'takeLeaveVicePrincipalApprove()', '', '2011-06-08 00:00:00', '2011-06-08 15:27:37'),
(42, '请假出差校长审批', 'takeLeavePrincipalApprove', 3, 'METHOD', 'takeLeavePrincipalApprove()', '', '2011-06-08 00:00:00', '2011-06-08 15:27:42'),
(43, '页面访问', 'moveRestDay_apply_main@defaultVisit@', 0, 'URL', '/oa/attendance/moveRestDay.swf*', NULL, '2011-06-10 00:00:00', '2011-06-10 16:11:49'),
(44, '页面访问', 'overWork_approve_main@defaultVisit@', 0, 'URL', '/oa/attendance/overWorkApprove.swf*', NULL, '2011-06-10 00:00:00', '2011-06-10 21:15:45'),
(45, '页面访问', 'moveRestDay_approve_main@defaultVisit@', 0, 'URL', '/oa/attendance/moveRestDayApprove.swf*', NULL, '2011-06-10 00:00:00', '2011-06-10 21:16:34'),
(46, '页面访问', 'staffCanculateAttendance_main@defaultVisit@', 0, 'URL', '/oa/attendance/canculateAttendance.swf*', NULL, '2011-06-10 00:00:00', '2011-06-10 21:23:26'),
(47, '页面访问', 'person_notice_main@defaultVisit@', 0, 'URL', '/oa/notice/personNotice.swf*', NULL, '2011-06-16 00:00:00', '2011-06-16 00:04:01'),
(48, '页面访问', 'school_notice_read_main@defaultVisit@', 0, 'URL', '/oa/notice/noticeList.swf*', NULL, '2011-06-16 00:00:00', '2011-06-16 00:04:50'),
(49, '页面访问', 'task_manager_main@defaultVisit@', 0, 'URL', '/oa/task/taskManager.swf*', NULL, '2011-06-16 00:00:00', '2011-06-16 10:46:47');

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_operation_dam_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_operation_dam_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `operation_id` bigint(20) NOT NULL,
  `dam_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=52 ;

--
-- 转存表中的数据 `wlzx_system_operation_dam_relationship`
--

INSERT INTO `wlzx_system_operation_dam_relationship` (`id`, `operation_id`, `dam_id`) VALUES
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 7, 7),
(8, 8, 8),
(9, 9, 9),
(11, 11, 11),
(12, 12, 12),
(13, 13, 13),
(14, 14, 14),
(15, 15, 15),
(16, 16, 16),
(17, 17, 17),
(18, 18, 18),
(19, 19, 19),
(20, 20, 20),
(21, 21, 21),
(22, 22, 22),
(24, 24, 24),
(25, 25, 25),
(27, 27, 27),
(28, 28, 28),
(30, 30, 30),
(31, 31, 31),
(32, 32, 32),
(33, 33, 33),
(34, 34, 34),
(35, 35, 35),
(36, 36, 36),
(37, 37, 37),
(38, 38, 38),
(39, 39, 39),
(40, 40, 40),
(41, 41, 41),
(42, 42, 42),
(43, 38, 43),
(44, 38, 44),
(45, 43, 45),
(46, 44, 46),
(47, 45, 47),
(48, 46, 48),
(49, 47, 49),
(50, 48, 50),
(51, 49, 51);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_role`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_role` (
  `id` bigint(20) NOT NULL auto_increment,
  `symbol` varchar(100) NOT NULL,
  `sequence` bigint(20) default '0',
  `name` varchar(50) NOT NULL,
  `level` int(11) NOT NULL,
  `detail` text,
  `creation_date` datetime NOT NULL,
  `modified_date` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  `supervisor_flag` tinyint(1) NOT NULL default '0',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `symbol` (`symbol`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='系统角色' AUTO_INCREMENT=23 ;

--
-- 转存表中的数据 `wlzx_system_role`
--

INSERT INTO `wlzx_system_role` (`id`, `symbol`, `sequence`, `name`, `level`, `detail`, `creation_date`, `modified_date`, `supervisor_flag`) VALUES
(1, 'root_supervisor', 0, '校长', 1, '', '2011-05-06 00:00:00', '2011-06-16 00:11:15', 1),
(3, 'moral_education_office_supervisor', 0, '德育处处长', 3, '', '2011-05-10 00:00:00', '2011-05-20 18:47:06', 1),
(6, 'headmaster_office_supervisor', 0, '校长办公室主任', 3, '', '2011-05-18 00:00:00', '2011-05-20 18:47:00', 1),
(15, 'grade_committee_supervisor', 0, '段长', 3, '', '2011-05-19 00:00:00', '2011-05-20 18:46:54', 1),
(16, 'practice_education_office_supervisor', 0, '综践处处长', 3, '', '2011-05-19 00:00:00', '2011-05-20 18:46:33', 1),
(17, 'resources_office_supervisor', 0, '资源处处长', 3, '', '2011-05-19 00:00:00', '2011-05-20 18:46:41', 1),
(18, 'executive_vice_president', 1, '行政副校长', 2, '', '2011-05-19 00:00:00', '2011-05-20 18:45:51', 0),
(19, 'moral_education_vice_president', 2, '德育副校长', 2, '', '2011-05-19 00:00:00', '2011-05-20 18:46:10', 0),
(20, 'teaching_vice_president', 3, '教学副校长', 2, '', '2011-05-19 00:00:00', '2011-05-30 14:57:40', 0),
(21, 'logistical_vice_president', 4, '后勤副校长', 2, '', '2011-05-19 00:00:00', '2011-05-30 15:38:26', 0),
(22, 'course_office_supervisor', 0, '课程处处长', 3, '', '2011-05-20 00:00:00', '2011-05-20 18:46:47', 1);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_role_dam_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_role_dam_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `role_id` bigint(20) NOT NULL,
  `dam_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=92 ;

--
-- 转存表中的数据 `wlzx_system_role_dam_relationship`
--

INSERT INTO `wlzx_system_role_dam_relationship` (`id`, `role_id`, `dam_id`) VALUES
(4, 1, 24),
(12, 1, 20),
(17, 1, 17),
(18, 1, 18),
(19, 1, 3),
(20, 1, 6),
(21, 1, 5),
(22, 1, 4),
(25, 1, 19),
(27, 1, 25),
(28, 19, 3),
(29, 19, 6),
(30, 19, 5),
(31, 19, 4),
(32, 19, 17),
(33, 19, 18),
(34, 1, 21),
(35, 1, 22),
(38, 19, 19),
(39, 19, 22),
(40, 19, 23),
(41, 19, 15),
(42, 19, 24),
(43, 19, 16),
(44, 19, 25),
(45, 19, 13),
(46, 19, 26),
(47, 19, 14),
(48, 19, 11),
(49, 19, 12),
(50, 19, 21),
(51, 19, 20),
(52, 19, 10),
(53, 19, 7),
(54, 19, 9),
(55, 19, 8),
(56, 1, 23),
(57, 1, 15),
(58, 1, 16),
(59, 1, 13),
(60, 1, 26),
(61, 1, 14),
(62, 1, 11),
(63, 1, 12),
(64, 1, 10),
(65, 1, 7),
(66, 1, 9),
(67, 1, 8),
(68, 1, 28),
(69, 1, 31),
(70, 1, 27),
(71, 1, 33),
(72, 1, 32),
(73, 1, 35),
(74, 1, 36),
(75, 1, 34),
(76, 1, 37),
(77, 1, 39),
(78, 1, 38),
(80, 1, 41),
(81, 1, 40),
(82, 1, 43),
(83, 1, 42),
(84, 1, 45),
(85, 1, 44),
(86, 1, 47),
(87, 1, 46),
(88, 1, 48),
(89, 1, 49),
(90, 1, 50),
(91, 1, 51);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_role_department_leadership`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_role_department_leadership` (
  `id` bigint(20) NOT NULL auto_increment,
  `role_id` bigint(20) NOT NULL,
  `department_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- 转存表中的数据 `wlzx_system_role_department_leadership`
--

INSERT INTO `wlzx_system_role_department_leadership` (`id`, `role_id`, `department_id`) VALUES
(1, 18, 6),
(2, 20, 10),
(3, 20, 12),
(4, 21, 11),
(5, 19, 9),
(6, 18, 9),
(7, 20, 9),
(8, 21, 9),
(9, 19, 3);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_role_leadship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_role_leadship` (
  `id` bigint(20) NOT NULL auto_increment,
  `leader_id` bigint(20) NOT NULL,
  `subordinate_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- 转存表中的数据 `wlzx_system_role_leadship`
--

INSERT INTO `wlzx_system_role_leadship` (`id`, `leader_id`, `subordinate_id`) VALUES
(7, 1, 18),
(8, 1, 19),
(9, 1, 20),
(10, 1, 21);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_role_user_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_role_user_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `role_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- 转存表中的数据 `wlzx_system_role_user_relationship`
--

INSERT INTO `wlzx_system_role_user_relationship` (`id`, `role_id`, `user_id`) VALUES
(5, 20, 3),
(11, 6, 3),
(13, 22, 3),
(14, 21, 3),
(15, 18, 3),
(20, 19, 2);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_treeship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_treeship` (
  `id` bigint(20) NOT NULL auto_increment,
  `parent_id` bigint(20) NOT NULL,
  `child_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `wlzx_system_treeship`
--

INSERT INTO `wlzx_system_treeship` (`id`, `parent_id`, `child_id`) VALUES
(1, 1, 2),
(2, 1, 3);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_user`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_user` (
  `id` bigint(20) NOT NULL auto_increment,
  `symbol` varchar(100) NOT NULL,
  `sequence` bigint(20) default '0',
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `last_login_time` datetime default NULL,
  `last_login_ip` varchar(50) default NULL,
  `account_style` int(11) NOT NULL default '0' COMMENT '账号类型,默认教师账号',
  `person_id` bigint(20) default NULL,
  `person_name` varchar(200) default NULL,
  `email` varchar(50) default NULL,
  `creation_date` datetime NOT NULL,
  `modified_date` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  `active` tinyint(1) NOT NULL default '1',
  `main_role_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `symbol` (`symbol`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='系统用户' AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `wlzx_system_user`
--

INSERT INTO `wlzx_system_user` (`id`, `symbol`, `sequence`, `name`, `password`, `last_login_time`, `last_login_ip`, `account_style`, `person_id`, `person_name`, `email`, `creation_date`, `modified_date`, `active`, `main_role_id`) VALUES
(2, 'admin', 0, 'admin', 'c81e728d9d4c2f636f067f89cc14862c', '2011-06-16 10:28:51', '127.0.0.1', 0, NULL, NULL, NULL, '2011-05-07 11:04:22', '2011-06-11 14:33:56', 1, 1);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_user_leadship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_user_leadship` (
  `id` bigint(20) NOT NULL auto_increment,
  `leader_id` bigint(20) NOT NULL,
  `subordinate_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_system_user_leadship`
--
