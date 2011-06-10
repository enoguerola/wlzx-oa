-- phpMyAdmin SQL Dump
-- version 3.3.3
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2011 年 06 月 10 日 21:33
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `wlzx_oa_course_adjust_apply`
--

INSERT INTO `wlzx_oa_course_adjust_apply` (`id`, `apply_no`, `apply_type`, `apply_teacher_id`, `apply_reason`, `apply_status`, `approve_teacher_id`, `approve_remark`, `approve_date`, `apply_creation_date`) VALUES
(3, '20110601070021', 0, 2, '444444', 1, 1, '22222222', '2011-06-03 01:07:17', '2011-06-01 19:00:21');

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=18 ;

--
-- 转存表中的数据 `wlzx_oa_course_adjust_apply_item`
--

INSERT INTO `wlzx_oa_course_adjust_apply_item` (`id`, `apply_id`, `apply_class`, `apply_course`, `apply_course_date`, `apply_course_time`, `adjust_mean_date`, `adjust_mean_teacher_id`, `adjust_actual_date`, `adjust_actual_time`, `adjust_actual_teacher_id`) VALUES
(15, 3, '1', '体育', '2011-06-15 00:00:00', '第一节 第二节 ', '2011-06-22 00:00:00', 2, '2011-06-10 00:00:00', '第一节 第二节 ', 2),
(16, 3, '21', '化学', '2011-06-20 00:00:00', '第一节 第二节 第三节 第四节 第五节 第六节 第七节 第八节 第九节 ', '2011-06-09 00:00:00', 1, '2011-06-02 00:00:00', '第一节 ', 1),
(17, 3, '3333333', '英语', '2011-06-22 00:00:00', '第一节 第二节 第三节 第四节 第五节 第六节 第七节 第八节 第九节 ', '2011-06-15 00:00:00', 3, '2011-06-14 00:00:00', '第一节 第二节 ', 3);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `wlzx_oa_moverestday_apply`
--

INSERT INTO `wlzx_oa_moverestday_apply` (`id`, `moveRestDay_applyNo`, `moveRestDay_teacher_id`, `moveRestDay_times`, `moveRestDay_officeChief_approver_id`, `moveRestDay_officeChief_approve_time`, `moveRestDay_officeChief_approve_option`, `moveRestDay_officeChief_status`, `moveRestDay_vicePrincipal_approver_id`, `moveRestDay_vicePrincipal_approve_time`, `moveRestDay_vicePrincipal_approve_option`, `moveRestDay_vicePrincipal_status`, `moveRestDay_status`) VALUES
(1, '20110610090454', 2, '2011-06-11 1-1-0;2011-06-23 1-1-1;', NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, 4);

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
  `overWork_officeChief_status` tinyint(1) default NULL,
  `overWork_status` int(11) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `wlzx_oa_overwork_apply`
--

INSERT INTO `wlzx_oa_overwork_apply` (`id`, `overWork_applyNo`, `overWork_teacher_id`, `overWork_times`, `overWork_reason`, `overWork_officeChief_approver_id`, `overWork_officeChief_approve_time`, `overWork_officeChief_approve_option`, `overWork_officeChief_status`, `overWork_status`) VALUES
(1, '20110610114719', 2, '2011-06-10 1-1-1;2011-06-11 1-1-1;', '3333333333333', NULL, NULL, NULL, 0, 3),
(2, '20110610050009', 2, '2011-06-17 1-0-0;2011-06-23 0-0-1;2011-06-15 1-1-0;', '12222222222222', NULL, NULL, NULL, 0, 0);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `wlzx_oa_takeleave_apply`
--

INSERT INTO `wlzx_oa_takeleave_apply` (`id`, `takeLeave_applyNo`, `takeLeave_type`, `takeLeave_teacher_id`, `takeLeave_beginTime`, `takeLeave_endTime`, `takeLeave_reason`, `takeLeave_arrange_tech`, `takeLeave_arrange_tech_deal_already`, `takeLeave_arrange_service`, `takeLeave_arrange_service_deal_already`, `takeLeave_arrange_manage`, `takeLeave_arrange_manage_deal_already`, `takeLeave_officeChief_approver_id`, `takeLeave_officeChief_approve_time`, `takeLeave_officeChief_approve_option`, `takeLeave_officeChief_status`, `takeLeave_vicePrincipal_approver_id`, `takeLeave_vicePrincipal_approve_time`, `takeLeave_vicePrincipal_approve_option`, `takeLeave_vicePrincipal_status`, `takeLeave_principal_approver_id`, `takeLeave_principal_approve_time`, `takeLeave_principal_approve_option`, `takeLeave_principal_status`, `takeLeave_remark`, `takeLeave_status`) VALUES
(2, '20110608082544', 0, 2, '2011-06-16 1', '2011-06-22 0', NULL, '2', 0, '3', 0, '4', 0, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 5),
(3, '20110608093112', 1, 2, '2011-06-08 0', '2011-06-16 0', '1', '1', 1, '1', 1, '1', 1, NULL, NULL, '', 0, NULL, NULL, '', 0, NULL, NULL, '', 0, NULL, 0);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=17 ;

--
-- 转存表中的数据 `wlzx_oa_workflow_log`
--

INSERT INTO `wlzx_oa_workflow_log` (`id`, `operation_object_type`, `operation_object_id`, `operation_teacher_id`, `operation_time`, `operation_name`, `operation_result`) VALUES
(1, 'TakeLeaveWorkFlowLog', 2, 2, '2011-06-08 08:25:44', '发起申请', '生成编号为20110608082544的申请记录'),
(2, 'TakeLeaveWorkFlowLog', 3, 2, '2011-06-08 09:31:12', '发起申请', '生成编号为20110608093112的申请记录'),
(3, 'TakeLeaveWorkFlowLog', 2, 2, '2011-06-08 10:49:44', '取消申请', '取消编号为20110608082544的申请记录'),
(4, 'OverWorkWorkFlowLog', 1, 2, '2011-06-10 11:47:19', '发起申请', '生成编号为20110610114719的申请记录'),
(5, 'OverWorkWorkFlowLog', 1, 2, '2011-06-10 16:43:24', '编辑申请', '编辑编号为20110610114719的申请记录'),
(12, 'OverWorkWorkFlowLog', 1, 2, '2011-06-10 16:59:37', '取消申请', '取消编号为20110610114719的申请记录'),
(13, 'OverWorkWorkFlowLog', 2, 2, '2011-06-10 17:00:09', '发起申请', '生成编号为20110610050009的申请记录'),
(14, 'MoveRestDayWorkFlowLog', 1, 2, '2011-06-10 21:04:54', '发起申请', '生成编号为20110610090454的申请记录'),
(15, 'MoveRestDayWorkFlowLog', 1, 2, '2011-06-10 21:05:03', '编辑申请', '编辑编号为20110610090454的申请记录'),
(16, 'MoveRestDayWorkFlowLog', 1, 2, '2011-06-10 21:05:17', '取消申请', '取消编号为20110610090454的申请记录');
