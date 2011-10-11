/*
Navicat MySQL Data Transfer

Source Server         : 60.12.111.11
Source Server Version : 50077
Source Host           : 60.12.111.11:3306
Source Database       : wlzx_oa

Target Server Type    : MYSQL
Target Server Version : 50077
File Encoding         : 65001

Date: 2011-10-11 08:54:50
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_conference
-- ----------------------------
INSERT INTO `wlzx_oa_conference` VALUES ('1', '会议1', '2011-09-30', '07:00', '08:00', '10', '708;710;', '12', '1', '733', '666756', '', '', '733', '2011-09-30 18:22:55', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_course_adjust_apply
-- ----------------------------
INSERT INTO `wlzx_oa_course_adjust_apply` VALUES ('1', '20110930181403', '0', '743', '请假', '1', '733', '通过', '2011-09-30 18:24:56', '2011-09-30 18:14:03');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_course_adjust_apply_item
-- ----------------------------
INSERT INTO `wlzx_oa_course_adjust_apply_item` VALUES ('1', '1', '1', '语文', '2011-09-30 00:00:00', '第二节 第三节 ', '2011-09-30 00:00:00', '第三节 第四节 ', '708', '2011-09-30 00:00:00', '第三节 第四节 ', '708', '1', '2011-09-30 18:24:28');

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_notice
-- ----------------------------
INSERT INTO `wlzx_oa_notice` VALUES ('4', '0', '考勤信息', '6', '718', '0', ' 9月20日教工大会出勤', ' 请假：杨华 李迅若 王茜 陈军红 陈兆明 王华君 江丽芳 应崇杨 郭仁勇 余卜秋 梁瑞阳 徐根玲 叶理富\r 缺席：金伟飞 将照明 徐敏燕', '2011-09-28 05:26:26', '2011-09-28 05:26:26', '718', '1', '48');
INSERT INTO `wlzx_oa_notice` VALUES ('5', '1', '其他', '6', '718', '0', ' 督导评估指导会议', ' 明天（周五）第二节课邀请市教育局督导室陈和平老师对我校督导评估准备工作进行指导，请大家准时参加。', '2011-09-29 15:16:26', '2011-09-29 15:16:26', '718', '1', '14');
INSERT INTO `wlzx_oa_notice` VALUES ('6', '1', '其他', '6', '716', '0', ' 工作量清单。', '工作量清单。肖健周四（9月29日）下午前完成并列出名单。', '2011-09-29 15:26:49', '2011-09-29 15:26:49', '716', '1', '20');
INSERT INTO `wlzx_oa_notice` VALUES ('8', '1', '考勤信息', '6', '716', '0', ' 校报初稿', '校报初稿。毛丽丽具办2011秋季版，要在10月中旬拿出样稿。', '2011-09-29 15:30:07', '2011-09-29 15:30:07', '716', '1', '18');

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
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_schedule
-- ----------------------------
INSERT INTO `wlzx_oa_schedule` VALUES ('7', '教工宿舍天井美化', null, '2011-09-26 08:31:00', '2011-09-30 17:31:00', '983', '1', '1', '1', '11', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('8', '劳保发放', null, '2011-09-27 08:32:00', '2011-09-27 17:00:00', '983', '1', '0', '1', '11', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('9', '回收学生宿舍饮水机', null, '2011-09-26 08:33:00', '2011-09-29 17:33:00', '983', '1', '0', '1', '11', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('10', '食堂圆桌和酒柜采购', null, '2011-09-26 08:34:00', '2011-09-29 17:00:00', '983', '1', '0', '1', '11', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('11', '高三第一次月考', null, '2011-09-29 08:49:00', '2011-09-30 16:49:00', '733', '1', '0', '1', '12', '1', '1', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('13', '各教研组推荐参加本学期的“解题、命题、析题”的老师，要求被推荐的老师提前对三年高考五年模拟进行强化训练', null, '2011-09-26 08:51:00', '2011-09-30 09:51:00', '733', '1', '0', '1', '12', '3', '1', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('14', '教学常规检查(作业管理,提高作业效率)', null, '2011-09-26 08:52:00', '2011-09-30 09:52:00', '733', '1', '0', '1', '12', '3', '1', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('15', '综合实践活动课程平台建设', null, '2011-09-26 08:52:00', '2011-09-30 09:52:00', '733', '1', '0', '1', '12', '3', '1', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('16', '周日晚（25号）在6302举行高一高二演讲赛', null, '2011-09-25 18:54:00', '2011-09-25 20:54:00', '722', '1', '0', '1', '3', '1', '1', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('18', '各班班委、团支委名单统计上报', null, '2011-09-26 08:56:00', '2011-09-30 09:56:00', '722', '1', '0', '1', '3', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('19', '部署国庆系列活动', null, '2011-09-26 08:56:00', '2011-09-30 09:56:00', '722', '1', '0', '1', '3', '1', '1', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('20', '周四中午清泉助学基金资助生座谈会', null, '2011-09-29 08:57:00', '2011-09-29 17:57:00', '722', '1', '0', '1', '3', '1', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('21', '周五安全检查', null, '2011-09-30 08:57:00', '2011-09-30 09:57:00', '722', '1', '0', '1', '3', '1', '1', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('22', 'OA系统调试', null, '2011-09-28 08:58:00', '2011-09-28 10:58:00', '718', '1', '0', '0', '6', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('24', '电影安排 周日晚高三（1-12）及教师', null, '2011-09-25 19:20:00', '2011-09-25 21:16:00', '722', '1', '0', '1', '3', '3', '1', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('25', '电影：周一晚高三（13-24）及教师', null, '2011-09-26 19:35:00', '2011-09-26 21:35:00', '722', '1', '0', '1', '3', '3', '1', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('26', '电影：周二晚高二', null, '2011-09-27 19:36:00', '2011-09-27 21:36:00', '722', '1', '0', '1', '3', '3', '1', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('27', '电影：周四晚高一', null, '2011-09-29 19:36:00', '2011-09-29 21:36:00', '722', '1', '0', '1', '3', '3', '1', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('33', '组织参加信息学奥赛初赛', null, '2011-10-09 15:41:00', '2011-10-14 16:41:00', '946', '1', '0', '1', '10', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('34', '校体育节开始筹备，部分项目开始比赛', null, '2011-10-08 15:43:00', '2011-10-14 16:43:00', '946', '1', '0', '1', '10', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('35', '温岭市数学教学大比武服务工作', null, '2011-10-08 15:45:00', '2011-10-11 16:45:00', '946', '1', '0', '1', '10', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('36', '电子图书馆建设调查', null, '2011-10-08 15:47:00', '2011-10-14 16:47:00', '946', '1', '0', '1', '10', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('37', '我的日程', 'test', '2011-09-30 16:58:38', '2011-09-30 17:58:38', '708', '0', '0', '0', '1', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('38', '迎接创建园林城市的检查', null, '2011-10-09 07:06:00', '2011-09-09 18:06:00', '983', '1', '0', '1', '11', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('39', '两米直径圆桌的添加', null, '2011-10-11 07:07:00', '2011-10-11 18:07:00', '983', '1', '0', '1', '11', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('40', '教室的校产登记', null, '2011-10-10 07:08:00', '2011-10-14 18:08:00', '983', '1', '0', '1', '11', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('41', '十二楼的办公室构隔方案', null, '2011-10-13 07:08:00', '2011-10-15 18:08:00', '983', '1', '0', '1', '11', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('42', '体育馆玻璃的维修', null, '2011-10-15 07:09:00', '2011-10-15 18:09:00', '983', '1', '0', '1', '11', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('43', '新日程1', 'test', '2011-09-30 17:58:04', '2011-09-30 18:58:04', '1', '1', '1', '1', null, '0', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('45', '国庆系列活动', null, '2011-10-01 10:23:53', '2011-10-07 11:23:00', '722', '1', '0', '1', '3', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('46', '制定十月主题教育活动方案', null, '2011-10-01 10:25:06', '2011-10-07 11:25:00', '722', '1', '0', '1', '3', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('48', '各社团招收新成员及规范海报刊登', null, '2011-10-01 10:27:20', '2011-10-14 11:27:00', '722', '1', '0', '1', '3', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('49', '（国庆加班）市督导评估材料准备', null, '2011-10-01 10:30:12', '2011-10-07 11:30:00', '722', '1', '0', '1', '3', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('50', '规范温中学生广播电台', null, '2011-10-07 10:31:00', '2011-10-14 11:31:00', '722', '1', '0', '1', '3', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);
INSERT INTO `wlzx_oa_schedule` VALUES ('52', '7号晚在1106教室进行心理团辅（高二）', null, '2011-10-07 10:36:00', '2011-10-08 11:36:00', '722', '1', '0', '1', '3', '3', '0', '0', '0', '0', '1', '0;0;0;0;0;0;0', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_takeleave_apply
-- ----------------------------
INSERT INTO `wlzx_oa_takeleave_apply` VALUES ('2', '20110928053937', '0', '952', '2011-09-27 0', '2011-09-30 0', '1', '1', '0', '1', '0', '1', '0', '946', '2011-09-27 00:00:00', '', '1', null, null, '', null, null, null, null, null, '11', '1');
INSERT INTO `wlzx_oa_takeleave_apply` VALUES ('3', '20110928160320', '0', '736', '2011-09-28 0', '2011-10-03 0', 'test', 'test', '0', '', '0', '', '0', '733', '2011-09-28 00:00:00', '', '1', '709', '2011-09-28 00:00:00', '', '1', '708', '2011-09-28 00:00:00', null, '1', '', '3');
INSERT INTO `wlzx_oa_takeleave_apply` VALUES ('4', '20110928161633', '0', '737', '2011-09-28 0', '2011-09-29 0', 'test', '1', '0', '2', '0', '3', '0', '946', '2011-09-30 00:00:00', 'test', '1', null, null, '', null, null, null, null, null, '', '3');
INSERT INTO `wlzx_oa_takeleave_apply` VALUES ('5', '20110928182503', '1', '721', '2011-09-29 0', '2011-09-29 1', '参加督导评估听课', '已安排', '0', '已安排', '0', '', '0', '716', '2011-09-28 00:00:00', '', '1', null, null, '', null, null, null, null, null, '', '3');
INSERT INTO `wlzx_oa_takeleave_apply` VALUES ('6', '20110930090456', '1', '1009', '2011-10-08 0', '2011-10-09 1', '培训', '', '0', '', '0', '', '0', '722', '2011-09-30 00:00:00', '', '1', null, null, '', null, null, null, null, null, '', '1');
INSERT INTO `wlzx_oa_takeleave_apply` VALUES ('7', '20110930090644', '1', '1009', '2011-10-17 0', '2011-10-17 1', '培训', '', '0', '', '0', '', '0', '722', '2011-09-30 00:00:00', '', '1', null, null, '', null, null, null, null, null, '', '3');
INSERT INTO `wlzx_oa_takeleave_apply` VALUES ('10', '20111008082238', '0', '775', '2011-10-08 0', '2011-11-07 1', '产假', '', '0', '', '0', '', '0', '733', '2011-10-08 00:00:00', '同意', '1', '709', '2011-10-08 00:00:00', '同意,请备课组提出课务安排建议', '1', null, null, null, null, '', '2');
INSERT INTO `wlzx_oa_takeleave_apply` VALUES ('11', '20111008085615', '1', '779', '2011-10-09 0', '2011-10-10 1', '市大比武评委', '', '0', '', '0', '', '0', '733', '2011-10-08 00:00:00', '同意', '1', '709', '2011-10-08 00:00:00', '同意', '1', null, null, null, null, '', '3');
INSERT INTO `wlzx_oa_takeleave_apply` VALUES ('12', '20111008085802', '1', '787', '2011-10-09 0', '2011-10-10 1', '市大比武评委', '', '0', '', '0', '', '0', '733', '2011-10-08 00:00:00', '同意', '1', '709', '2011-10-08 00:00:00', '同意', '1', null, null, null, null, '', '3');
INSERT INTO `wlzx_oa_takeleave_apply` VALUES ('13', '20111008091222', '1', '737', '2011-10-09 0', '2011-10-09 1', '去松门中学参加大比武评委(教研室安维琪老师通知)', '调课', '0', '提前完成', '0', '无', '0', '733', '2011-10-09 00:00:00', '', '1', null, null, '', null, null, null, null, null, '', '3');
INSERT INTO `wlzx_oa_takeleave_apply` VALUES ('14', '20111008155743', '1', '976', '2011-10-09 0', '2011-10-09 1', '参加温岭市教学大比武上课.', '', '0', '', '0', '', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `wlzx_oa_takeleave_apply` VALUES ('15', '20111009090346', '1', '959', '2011-10-10 0', '2011-10-13 1', '参加省优质课评比', '高一由徐敏燕老师代，高二由赵阳老师代', '0', '', '0', '', '0', '946', '2011-10-09 00:00:00', '同意', '1', null, null, '', null, null, null, null, null, '', '1');
INSERT INTO `wlzx_oa_takeleave_apply` VALUES ('16', '20111009121219', '1', '973', '2011-10-08 0', '2011-10-08 1', '学校指派：去双语上课,上午二节，下午二节', '', '0', '', '0', '', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `wlzx_oa_takeleave_apply` VALUES ('18', '20111010165303', '1', '958', '2011-10-11 0', '2011-10-13 1', '省优质课观摩', '高一由王平波代，高二由王海辉代', '0', '', '0', '', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_oa_workflow_log
-- ----------------------------
INSERT INTO `wlzx_oa_workflow_log` VALUES ('4', 'TakeLeaveWorkFlowLog', '2', '952', '2011-09-28 05:39:37', '发起申请', '生成编号为20110928053937的申请记录');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('5', 'TakeLeaveWorkFlowLog', '2', '946', '2011-09-28 05:45:26', '处室审批', '处室审批编号为20110928053937的申请通过');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('6', 'TakeLeaveWorkFlowLog', '3', '736', '2011-09-28 16:03:20', '发起申请', '生成编号为20110928160320的申请记录');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('7', 'TakeLeaveWorkFlowLog', '3', '733', '2011-09-28 16:09:21', '处室审批', '处室审批编号为20110928160320的申请通过');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('8', 'TakeLeaveWorkFlowLog', '3', '709', '2011-09-28 16:10:40', '分管副校长审批', '分管副校长审批编号为20110928160320的申请通过');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('9', 'TakeLeaveWorkFlowLog', '3', '708', '2011-09-28 16:11:26', '校长审批', '校长审批编号为20110928160320的申请通过');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('10', 'TakeLeaveWorkFlowLog', '4', '737', '2011-09-28 16:16:33', '发起申请', '生成编号为20110928161633的申请记录');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('11', 'TakeLeaveWorkFlowLog', '5', '721', '2011-09-28 18:25:03', '发起申请', '生成编号为20110928182503的申请记录');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('12', 'TakeLeaveWorkFlowLog', '5', '716', '2011-09-29 15:24:31', '处室审批', '处室审批编号为20110928182503的申请通过');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('13', 'TakeLeaveWorkFlowLog', '6', '1009', '2011-09-30 09:04:56', '发起申请', '生成编号为20110930090456的申请记录');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('14', 'TakeLeaveWorkFlowLog', '7', '1009', '2011-09-30 09:06:44', '发起申请', '生成编号为20110930090644的申请记录');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('15', 'TakeLeaveWorkFlowLog', '6', '1009', '2011-09-30 09:06:59', '编辑申请', '编辑编号为20110930090456的申请记录');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('16', 'TakeLeaveWorkFlowLog', '7', '722', '2011-09-30 11:27:09', '处室审批', '处室审批编号为20110930090644的申请通过');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('17', 'TakeLeaveWorkFlowLog', '6', '722', '2011-09-30 11:27:23', '处室审批', '处室审批编号为20110930090456的申请通过');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('18', 'TakeLeaveWorkFlowLog', '4', '946', '2011-09-30 15:34:32', '处室审批', '处室审批编号为20110928161633的申请通过');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('21', 'ApplyWorkFlowLog', '1', '743', '2011-09-30 18:14:03', '发起申请', '生成编号为20110930181403的申请记录');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('23', 'ApplyWorkFlowLog', '1', '733', '2011-09-30 18:24:47', '课程员安排', '课程员安排编号为20110930181403的调课申请');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('24', 'ApplyWorkFlowLog', '1', '733', '2011-09-30 18:25:15', '课程处审批', '课程处审批编号为20110930181403的申请通过');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('25', 'TakeLeaveWorkFlowLog', '10', '775', '2011-10-08 08:22:38', '发起申请', '生成编号为20111008082238的申请记录');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('26', 'TakeLeaveWorkFlowLog', '10', '733', '2011-10-08 08:53:03', '处室审批', '处室审批编号为20111008082238的申请通过');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('27', 'TakeLeaveWorkFlowLog', '11', '779', '2011-10-08 08:56:15', '发起申请', '生成编号为20111008085615的申请记录');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('28', 'TakeLeaveWorkFlowLog', '12', '787', '2011-10-08 08:58:02', '发起申请', '生成编号为20111008085802的申请记录');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('29', 'TakeLeaveWorkFlowLog', '12', '733', '2011-10-08 09:09:53', '处室审批', '处室审批编号为20111008085802的申请通过');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('30', 'TakeLeaveWorkFlowLog', '11', '733', '2011-10-08 09:10:11', '处室审批', '处室审批编号为20111008085615的申请通过');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('31', 'TakeLeaveWorkFlowLog', '13', '737', '2011-10-08 09:12:22', '发起申请', '生成编号为20111008091222的申请记录');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('32', 'TakeLeaveWorkFlowLog', '10', '709', '2011-10-08 11:04:18', '分管副校长审批', '分管副校长审批编号为20111008082238的申请通过');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('33', 'TakeLeaveWorkFlowLog', '12', '709', '2011-10-08 11:04:50', '分管副校长审批', '分管副校长审批编号为20111008085802的申请通过');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('34', 'TakeLeaveWorkFlowLog', '11', '709', '2011-10-08 11:05:15', '分管副校长审批', '分管副校长审批编号为20111008085615的申请通过');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('35', 'TakeLeaveWorkFlowLog', '14', '976', '2011-10-08 15:57:43', '发起申请', '生成编号为20111008155743的申请记录');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('36', 'TakeLeaveWorkFlowLog', '15', '959', '2011-10-09 09:03:46', '发起申请', '生成编号为20111009090346的申请记录');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('37', 'TakeLeaveWorkFlowLog', '16', '973', '2011-10-09 12:12:19', '发起申请', '生成编号为20111009121219的申请记录');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('38', 'TakeLeaveWorkFlowLog', '15', '946', '2011-10-09 12:17:28', '处室审批', '处室审批编号为20111009090346的申请通过');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('39', 'TakeLeaveWorkFlowLog', '13', '733', '2011-10-09 12:19:13', '处室审批', '处室审批编号为20111008091222的申请通过');
INSERT INTO `wlzx_oa_workflow_log` VALUES ('41', 'TakeLeaveWorkFlowLog', '18', '958', '2011-10-10 16:53:03', '发起申请', '生成编号为20111010165303的申请记录');
