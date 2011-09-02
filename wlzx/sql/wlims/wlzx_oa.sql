/*
MySQL Data Transfer
Source Host: localhost
Source Database: wlzx_oa
Target Host: localhost
Target Database: wlzx_oa
Date: 2011-8-31 1:21:07
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for wlzx_oa_attachment
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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_oa_conference
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
-- Table structure for wlzx_oa_conference_attachment_relationship
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_conference_attachment_relationship`;
CREATE TABLE `wlzx_oa_conference_attachment_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `conference_id` bigint(20) NOT NULL,
  `attachment_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_oa_conference_summary_attachment_relationship
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_conference_summary_attachment_relationship`;
CREATE TABLE `wlzx_oa_conference_summary_attachment_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `conference_id` bigint(20) NOT NULL,
  `attachment_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_oa_course_adjust_apply
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
-- Table structure for wlzx_oa_course_adjust_apply_item
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
  `adjust_mean_teacher_id` bigint(20) NOT NULL,
  `adjust_actual_date` datetime default NULL,
  `adjust_actual_time` varchar(200) default NULL,
  `adjust_actual_teacher_id` bigint(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_oa_moverestday_apply
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
-- Table structure for wlzx_oa_notice
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
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_oa_notice_attachment_relationship
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_notice_attachment_relationship`;
CREATE TABLE `wlzx_oa_notice_attachment_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `notice_id` bigint(20) NOT NULL,
  `attachment_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_oa_option
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
-- Table structure for wlzx_oa_overwork_apply
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
-- Table structure for wlzx_oa_receipt
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_oa_receipt_attachment
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_receipt_attachment`;
CREATE TABLE `wlzx_oa_receipt_attachment` (
  `id` bigint(20) NOT NULL auto_increment,
  `receipt_id` bigint(20) NOT NULL,
  `attachment_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `receipt_id` (`receipt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_oa_receipt_flow
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_oa_schedule
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_oa_sendingfile_flow
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_oa_sendingfiles
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for wlzx_oa_sendingfiles_attachment
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_oa_sendingfiles_attachment`;
CREATE TABLE `wlzx_oa_sendingfiles_attachment` (
  `id` bigint(20) NOT NULL auto_increment,
  `sendingfile_id` bigint(20) NOT NULL,
  `attachment_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_oa_takeleave_apply
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_oa_takeleave_terminate
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
-- Table structure for wlzx_oa_task
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
-- Table structure for wlzx_oa_workflow_log
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `wlzx_oa_attachment` VALUES ('1', 'task-2011-0725.doc', '110812095154.doc', 'doc', '37376', '2011-08-12 09:51:54');
INSERT INTO `wlzx_oa_attachment` VALUES ('2', '学鼎需求用例.doc', '110812095154.doc', 'doc', '360448', '2011-08-12 09:51:54');
INSERT INTO `wlzx_oa_attachment` VALUES ('3', '温岭行政结构_权限配置_通知方案.doc', 'attach_110812100228.doc', 'doc', '101376', '2011-08-12 10:02:28');
INSERT INTO `wlzx_oa_attachment` VALUES ('4', '温岭行政结构_权限配置-首页.doc', 'attach_110812100228.doc', 'doc', '146432', '2011-08-12 10:02:28');
INSERT INTO `wlzx_oa_attachment` VALUES ('5', '项目规划.doc', 'attach_110812100228.doc', 'doc', '21504', '2011-08-12 10:02:28');
INSERT INTO `wlzx_oa_attachment` VALUES ('6', '杭州池墨科技有限公司_股份制度.pdf', 'attach_110812115546.pdf', 'pdf', '136560', '2011-08-12 11:55:46');
INSERT INTO `wlzx_oa_attachment` VALUES ('7', '环境信息系统设计方案-20110615.pdf', 'attach_110812115546.pdf', 'pdf', '832565', '2011-08-12 11:55:46');
INSERT INTO `wlzx_oa_attachment` VALUES ('8', '火车票预订系统需求分析及设计_V1.3.doc', 'attach_110812115546.3.doc', '3.doc', '940544', '2011-08-12 11:55:46');
INSERT INTO `wlzx_oa_attachment` VALUES ('9', '上海动量软件技术有限公司介绍.pdf', 'attach_110812115546.pdf', 'pdf', '1810266', '2011-08-12 11:55:46');
INSERT INTO `wlzx_oa_attachment` VALUES ('10', '通达OA教育管理解决方案.pdf', 'attach_110812115547.pdf', 'pdf', '1280730', '2011-08-12 11:55:47');
INSERT INTO `wlzx_oa_attachment` VALUES ('11', '温岭OA系统BUG管理表.xls', 'attach_110812115548.xls', 'xls', '4714496', '2011-08-12 11:55:48');
INSERT INTO `wlzx_oa_attachment` VALUES ('12', '温岭行政结构_权限配置_0803.doc', 'attach_110812115548.doc', 'doc', '147968', '2011-08-12 11:55:48');
INSERT INTO `wlzx_oa_attachment` VALUES ('13', '温岭行政结构_权限配置_通知方案.doc', 'attach_110812115548.doc', 'doc', '101376', '2011-08-12 11:55:48');
INSERT INTO `wlzx_oa_attachment` VALUES ('14', '温岭行政结构_权限配置-首页.doc', 'attach_110812115549.doc', 'doc', '146432', '2011-08-12 11:55:49');
INSERT INTO `wlzx_oa_attachment` VALUES ('15', '项目规划.doc', 'attach_110812115549.doc', 'doc', '21504', '2011-08-12 11:55:49');
INSERT INTO `wlzx_oa_attachment` VALUES ('16', '项目章程.doc', 'attach_110812115550.doc', 'doc', '23552', '2011-08-12 11:55:50');
INSERT INTO `wlzx_oa_attachment` VALUES ('17', '需求用例模板.doc', 'attach_110812115550.doc', 'doc', '50176', '2011-08-12 11:55:50');
INSERT INTO `wlzx_oa_attachment` VALUES ('18', 'slogan_bg.jpg', 'attach_110827100357.jpg', 'jpg', '92643', '2011-08-27 22:03:57');
INSERT INTO `wlzx_oa_attachment` VALUES ('19', 'slogan_bg.png', 'attach_110827100357.png', 'png', '196571', '2011-08-27 22:03:57');
INSERT INTO `wlzx_oa_attachment` VALUES ('20', 'structure .png', 'attach_110827100357.png', 'png', '132249', '2011-08-27 22:03:57');
INSERT INTO `wlzx_oa_attachment` VALUES ('21', '2.jpg', 'attach_110827104931.jpg', 'jpg', '44379', '2011-08-27 22:49:31');
INSERT INTO `wlzx_oa_attachment` VALUES ('22', 'slogan_bg.jpg', 'attach_110827115947.jpg', 'jpg', '92643', '2011-08-27 23:59:47');
INSERT INTO `wlzx_oa_attachment` VALUES ('23', 'slogan_bg.png', 'attach_110827115948.png', 'png', '196571', '2011-08-27 23:59:48');
INSERT INTO `wlzx_oa_attachment` VALUES ('24', 'structure .png', 'attach_110827115948.png', 'png', '132249', '2011-08-27 23:59:48');
INSERT INTO `wlzx_oa_attachment` VALUES ('25', 'slogan_bg.jpg', 'attach_110828122306.jpg', 'jpg', '92643', '2011-08-28 00:23:06');
INSERT INTO `wlzx_oa_attachment` VALUES ('26', 'slogan_bg.png', 'attach_110828122307.png', 'png', '196571', '2011-08-28 00:23:07');
INSERT INTO `wlzx_oa_attachment` VALUES ('27', 'structure .png', 'attach_110828122307.png', 'png', '132249', '2011-08-28 00:23:07');
INSERT INTO `wlzx_oa_attachment` VALUES ('28', '2.jpg', 'attach_110828122914.jpg', 'jpg', '44379', '2011-08-28 00:29:14');
INSERT INTO `wlzx_oa_attachment` VALUES ('29', 'slogan_bg.png', 'attach_110829091421.png', 'png', '196571', '2011-08-29 09:14:21');
INSERT INTO `wlzx_oa_attachment` VALUES ('30', 'structure .png', 'attach_110829091422.png', 'png', '132249', '2011-08-29 09:14:22');
INSERT INTO `wlzx_oa_notice` VALUES ('1', '1', '其他', '3', '708', '0', ' 1', ' 2', '2011-08-12 10:02:54', '2011-08-12 09:51:56', '708', '1');
INSERT INTO `wlzx_oa_notice_attachment_relationship` VALUES ('19', '2', '12');
INSERT INTO `wlzx_oa_notice_attachment_relationship` VALUES ('20', '2', '11');
INSERT INTO `wlzx_oa_receipt` VALUES ('1', '1+1', '1', '1', '2011-08-16', '1', '我12', '222222222222', '0', '0', null, null);
INSERT INTO `wlzx_oa_receipt` VALUES ('2', '1+1', '2', '2', '2011-08-28', '222', '12', '222222', '3', '0', null, '708');
INSERT INTO `wlzx_oa_receipt` VALUES ('3', '2+w', 'w', 'w', '2011-08-16', 'w', 'q', 'wq', '0', '0', null, '708');
INSERT INTO `wlzx_oa_receipt_attachment` VALUES ('74', '2', '29');
INSERT INTO `wlzx_oa_receipt_attachment` VALUES ('77', '1', '28');
INSERT INTO `wlzx_oa_receipt_flow` VALUES ('1', '0', '1', '收文登记 ', '708', '2', '2011-08-29 17:16:04', '2011-08-28 01:55:15');
INSERT INTO `wlzx_oa_receipt_flow` VALUES ('2', '2', '1', 'bbcccccc', '708', '2', '2011-08-29 23:41:30', '2011-08-29 11:03:15');
INSERT INTO `wlzx_oa_schedule` VALUES ('1', '新日程1', '333333333', '2011-08-13 11:00:27', '2011-08-13 12:00:27', '708', '0', '0', '0', '1', '0', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('2', '安排职评人员上交评审量化评分表', '安排职评人员上交评审量化评分表', '2011-09-01 09:25:00', '2011-09-01 17:25:00', '718', '1', '0', '0', '24', '0', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('3', '考核表打分', null, '2011-09-01 09:31:00', '2011-09-01 10:31:00', '718', '1', '0', '0', '24', '0', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('5', '新日程', null, '2011-08-31 00:56:51', '2011-08-31 01:56:51', '984', '1', '0', '0', '11', '0', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('6', '新日程', null, '2011-08-31 01:00:04', '2011-08-31 02:00:04', '709', '0', '0', '0', '1', '0', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('7', '新日程', null, '2011-08-31 01:00:20', '2011-08-31 02:00:20', '709', '1', '1', '1', '1', '0', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_sendingfile_flow` VALUES ('1', '0', '1', null, '708', '1', '2011-08-29 20:32:13', '2011-08-12 11:06:46');
INSERT INTO `wlzx_oa_sendingfile_flow` VALUES ('2', '0', null, '发文拟稿', '708', '2', null, '2011-08-12 11:56:54');
INSERT INTO `wlzx_oa_sendingfile_flow` VALUES ('3', '0', null, '发文拟稿', '708', '3', null, '2011-08-12 12:10:07');
INSERT INTO `wlzx_oa_sendingfile_flow` VALUES ('4', '0', '1', null, '708', '4', '2011-08-12 12:28:28', '2011-08-12 12:28:22');
INSERT INTO `wlzx_oa_sendingfile_flow` VALUES ('5', '0', null, '发文拟稿', '708', '4', null, '2011-08-29 20:30:36');
INSERT INTO `wlzx_oa_sendingfile_flow` VALUES ('6', '2', null, null, '708', '1', null, '2011-08-29 20:32:49');
INSERT INTO `wlzx_oa_sendingfiles` VALUES ('1', '4', '<TEXTFORMAT LEADING=\"2\"><P ALIGN=\"LEFT\"><FONT FACE=\"宋体\" SIZE=\"12\" COLOR=\"#000000\" LETTERSPACING=\"0\" KERNING=\"0\">1</FONT></P></TEXTFORMAT>', '708', '2011-08-12 11:06:46', '2', '3', '', '', '', '', '', '', null, '2', '0');
INSERT INTO `wlzx_oa_sendingfiles` VALUES ('2', '4', '<TEXTFORMAT LEADING=\"2\"><P ALIGN=\"LEFT\"><FONT FACE=\"宋体\" SIZE=\"12\" COLOR=\"#000000\" LETTERSPACING=\"0\" KERNING=\"0\">1</FONT></P></TEXTFORMAT>', '708', '2011-08-12 11:56:54', '2', '3', '', '', '', '', '', '', null, '0', '0');
INSERT INTO `wlzx_oa_sendingfiles` VALUES ('3', '3', '<TEXTFORMAT LEADING=\"2\"><P ALIGN=\"LEFT\"><FONT FACE=\"宋体\" SIZE=\"12\" COLOR=\"#000000\" LETTERSPACING=\"0\" KERNING=\"0\">1</FONT></P></TEXTFORMAT>', '708', '2011-08-12 12:10:07', '2', '2', '', '', '', '', '', '', null, '0', '0');
INSERT INTO `wlzx_oa_sendingfiles` VALUES ('4', '4', '<TEXTFORMAT LEADING=\"2\"><P ALIGN=\"LEFT\"><FONT FACE=\"宋体\" SIZE=\"12\" COLOR=\"#000000\" LETTERSPACING=\"0\" KERNING=\"0\">1</FONT></P></TEXTFORMAT>', '708', '2011-08-12 12:28:22', '2', '3', '', '', '', '', '', '', null, '0', '0');
INSERT INTO `wlzx_oa_sendingfiles_attachment` VALUES ('1', '1', '13');
INSERT INTO `wlzx_oa_sendingfiles_attachment` VALUES ('2', '1', '12');
INSERT INTO `wlzx_oa_sendingfiles_attachment` VALUES ('3', '1', '9');
INSERT INTO `wlzx_oa_sendingfiles_attachment` VALUES ('4', '1', '8');
INSERT INTO `wlzx_oa_sendingfiles_attachment` VALUES ('5', '1', '15');
INSERT INTO `wlzx_oa_sendingfiles_attachment` VALUES ('6', '1', '11');
INSERT INTO `wlzx_oa_sendingfiles_attachment` VALUES ('7', '1', '6');
INSERT INTO `wlzx_oa_sendingfiles_attachment` VALUES ('8', '1', '7');
INSERT INTO `wlzx_oa_sendingfiles_attachment` VALUES ('9', '1', '17');
INSERT INTO `wlzx_oa_sendingfiles_attachment` VALUES ('10', '1', '10');
INSERT INTO `wlzx_oa_sendingfiles_attachment` VALUES ('11', '1', '14');
INSERT INTO `wlzx_oa_sendingfiles_attachment` VALUES ('12', '1', '16');
