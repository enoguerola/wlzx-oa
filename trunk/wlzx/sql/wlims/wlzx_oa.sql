/*
Navicat MySQL Data Transfer

Source Server         : 60.12.111.11
Source Server Version : 50077
Source Host           : 60.12.111.11:3306
Source Database       : wlzx_oa

Target Server Type    : MYSQL
Target Server Version : 50077
File Encoding         : 65001

Date: 2011-09-27 22:31:26
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `wlzx_oa_attachment`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_attachment`;
CREATE TABLE `wlzx_oa_attachment` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `path` varchar(100) NOT NULL,
  `type` varchar(10) NOT NULL,
  `size` bigint(20) NOT NULL,
  `upload_date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_attachment
-- ----------------------------

-- ----------------------------
-- Table structure for `wlzx_oa_conference`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_conference`;
CREATE TABLE `wlzx_oa_conference` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_conference
-- ----------------------------

-- ----------------------------
-- Table structure for `wlzx_oa_conference_attachment_relationship`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_conference_attachment_relationship`;
CREATE TABLE `wlzx_oa_conference_attachment_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `conference_id` bigint(20) NOT NULL,
  `attachment_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_conference_attachment_relationship
-- ----------------------------

-- ----------------------------
-- Table structure for `wlzx_oa_conference_summary_attachment_relationship`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_conference_summary_attachment_relationship`;
CREATE TABLE `wlzx_oa_conference_summary_attachment_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `conference_id` bigint(20) NOT NULL,
  `attachment_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_conference_summary_attachment_relationship
-- ----------------------------

-- ----------------------------
-- Table structure for `wlzx_oa_course_adjust_apply`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_course_adjust_apply`;
CREATE TABLE `wlzx_oa_course_adjust_apply` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_course_adjust_apply
-- ----------------------------

-- ----------------------------
-- Table structure for `wlzx_oa_course_adjust_apply_item`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_course_adjust_apply_item`;
CREATE TABLE `wlzx_oa_course_adjust_apply_item` (
  `id` bigint(20) NOT NULL auto_increment,
  `apply_id` bigint(20) NOT NULL,
  `apply_class` varchar(200) NOT NULL,
  `apply_course` varchar(200) NOT NULL,
  `apply_course_date` datetime NOT NULL,
  `apply_course_time` varchar(200) NOT NULL,
  `adjust_mean_date` datetime default NULL,
  `adjust_mean_time` varchar(200) default NULL,
  `adjust_mean_teacher_id` bigint(20) NOT NULL,
  `adjust_actual_date` datetime default NULL,
  `adjust_actual_time` varchar(200) default NULL,
  `adjust_actual_teacher_id` bigint(20) default NULL,
  `adjust_arrange_already` smallint(6) default NULL,
  `adjust_arrange_date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_course_adjust_apply_item
-- ----------------------------

-- ----------------------------
-- Table structure for `wlzx_oa_moverestday_apply`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_moverestday_apply`;
CREATE TABLE `wlzx_oa_moverestday_apply` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_moverestday_apply
-- ----------------------------

-- ----------------------------
-- Table structure for `wlzx_oa_notice`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_notice`;
CREATE TABLE `wlzx_oa_notice` (
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
  `read_nums` int(11) default '0' COMMENT '阅读数',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_notice
-- ----------------------------
INSERT INTO `wlzx_oa_notice` VALUES ('4', '0', '考勤信息', '6', '718', '0', ' 9月20日教工大会出勤', ' 请假：杨华 李迅若 王茜 陈军红 陈兆明 王华君 江丽芳 应崇杨 郭仁勇 余卜秋 梁瑞阳 徐根玲 叶理富\r 缺席：金伟飞 将照明 徐敏燕', '2011-09-28 05:26:26', '2011-09-28 05:26:26', '718', '1', '0');

-- ----------------------------
-- Table structure for `wlzx_oa_notice_attachment_relationship`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_notice_attachment_relationship`;
CREATE TABLE `wlzx_oa_notice_attachment_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `notice_id` bigint(20) NOT NULL,
  `attachment_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_notice_attachment_relationship
-- ----------------------------

-- ----------------------------
-- Table structure for `wlzx_oa_option`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_option`;
CREATE TABLE `wlzx_oa_option` (
  `option_id` bigint(20) NOT NULL auto_increment COMMENT '系统自增编号',
  `option_name` varchar(50) character set utf8 NOT NULL COMMENT '字典名称',
  `option_value` varchar(120) character set utf8 NOT NULL COMMENT '字典值',
  `option_slug` varchar(50) character set utf8 NOT NULL COMMENT '字典类型',
  `option_description` varchar(120) character set utf8 default NULL COMMENT '字典描述',
  `option_extra_value` varchar(30) character set utf8 default NULL COMMENT '字典额外值',
  PRIMARY KEY  (`option_id`),
  KEY `option_slug` (`option_slug`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='数据字典表';

-- ----------------------------
-- Records of wlzx_oa_option
-- ----------------------------

-- ----------------------------
-- Table structure for `wlzx_oa_overwork_apply`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_overwork_apply`;
CREATE TABLE `wlzx_oa_overwork_apply` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_overwork_apply
-- ----------------------------

-- ----------------------------
-- Table structure for `wlzx_oa_receipt`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_receipt`;
CREATE TABLE `wlzx_oa_receipt` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_receipt
-- ----------------------------

-- ----------------------------
-- Table structure for `wlzx_oa_receipt_attachment`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_receipt_attachment`;
CREATE TABLE `wlzx_oa_receipt_attachment` (
  `id` bigint(20) NOT NULL auto_increment,
  `receipt_id` bigint(20) NOT NULL,
  `attachment_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `receipt_id` (`receipt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_receipt_attachment
-- ----------------------------

-- ----------------------------
-- Table structure for `wlzx_oa_receipt_flow`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_receipt_flow`;
CREATE TABLE `wlzx_oa_receipt_flow` (
  `id` bigint(20) NOT NULL auto_increment,
  `type` smallint(6) NOT NULL,
  `is_completed` smallint(6) default NULL,
  `text` text,
  `user_id` bigint(20) NOT NULL,
  `receipt_id` bigint(20) NOT NULL,
  `completed_date` datetime default NULL,
  `creation_date` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_receipt_flow
-- ----------------------------

-- ----------------------------
-- Table structure for `wlzx_oa_schedule`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_schedule`;
CREATE TABLE `wlzx_oa_schedule` (
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_schedule
-- ----------------------------
INSERT INTO `wlzx_oa_schedule` VALUES ('2', '我的日程', '我的日程', '2011-09-27 18:03:00', '2011-09-27 17:27:08', '1', '1', '1', '1', null, '0', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);

-- ----------------------------
-- Table structure for `wlzx_oa_sendingfiles`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_sendingfiles`;
CREATE TABLE `wlzx_oa_sendingfiles` (
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of wlzx_oa_sendingfiles
-- ----------------------------

-- ----------------------------
-- Table structure for `wlzx_oa_sendingfiles_attachment`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_sendingfiles_attachment`;
CREATE TABLE `wlzx_oa_sendingfiles_attachment` (
  `id` bigint(20) NOT NULL auto_increment,
  `sendingfile_id` bigint(20) NOT NULL,
  `attachment_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_sendingfiles_attachment
-- ----------------------------

-- ----------------------------
-- Table structure for `wlzx_oa_sendingfile_flow`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_sendingfile_flow`;
CREATE TABLE `wlzx_oa_sendingfile_flow` (
  `id` bigint(20) NOT NULL auto_increment,
  `type` smallint(4) NOT NULL,
  `is_completed` smallint(4) default NULL,
  `text` text,
  `user_id` bigint(20) NOT NULL,
  `sendingfile_id` bigint(20) NOT NULL,
  `completed_date` datetime default NULL,
  `creation_date` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_sendingfile_flow
-- ----------------------------

-- ----------------------------
-- Table structure for `wlzx_oa_takeleave_apply`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_takeleave_apply`;
CREATE TABLE `wlzx_oa_takeleave_apply` (
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_takeleave_apply
-- ----------------------------
INSERT INTO `wlzx_oa_takeleave_apply` VALUES ('1', '20110926194135', '0', '718', '2011-09-26 0', '2011-09-28 0', '1', '', '0', '', '0', '', '0', '716', '2011-09-26 00:00:00', '111111', '1', '712', '2011-09-27 00:00:00', '2222222222222222', '1', null, null, null, null, '', '3');
INSERT INTO `wlzx_oa_takeleave_apply` VALUES ('2', '20110928053937', '0', '952', '2011-09-27 0', '2011-09-30 0', '1', '1', '0', '1', '0', '1', '0', '946', '2011-09-27 00:00:00', '', '1', null, null, '', null, null, null, null, null, '11', '1');

-- ----------------------------
-- Table structure for `wlzx_oa_takeleave_terminate`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_takeleave_terminate`;
CREATE TABLE `wlzx_oa_takeleave_terminate` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_takeleave_terminate
-- ----------------------------

-- ----------------------------
-- Table structure for `wlzx_oa_task`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_task`;
CREATE TABLE `wlzx_oa_task` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_task
-- ----------------------------

-- ----------------------------
-- Table structure for `wlzx_oa_workflow_log`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_workflow_log`;
CREATE TABLE `wlzx_oa_workflow_log` (
  `id` bigint(20) NOT NULL auto_increment,
  `operation_object_type` varchar(200) NOT NULL,
  `operation_object_id` bigint(20) NOT NULL,
  `operation_teacher_id` bigint(20) NOT NULL,
  `operation_time` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  `operation_name` varchar(200) NOT NULL,
  `operation_result` text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_workflow_log
-- ----------------------------
INSERT INTO `wlzx_oa_workflow_log` VALUES ('1', 'TakeLeaveWorkFlowLog', '1', '718', '2011-09-26 19:41:35', '发起申请', '生成编号为20110926194135的申请记录');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('2', 'TakeLeaveWorkFlowLog', '1', '716', '2011-09-26 22:56:59', '处室审批', '处室审批编号为20110926194135的申请通过');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('3', 'TakeLeaveWorkFlowLog', '1', '712', '2011-09-26 23:40:04', '分管副校长审批', '分管副校长审批编号为20110926194135的申请通过');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('4', 'TakeLeaveWorkFlowLog', '2', '952', '2011-09-28 05:39:37', '发起申请', '生成编号为20110928053937的申请记录');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('5', 'TakeLeaveWorkFlowLog', '2', '946', '2011-09-28 05:45:26', '处室审批', '处室审批编号为20110928053937的申请通过');
