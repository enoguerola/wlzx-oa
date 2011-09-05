/*
MySQL Data Transfer
Source Host: localhost
Source Database: wlzx_system
Target Host: localhost
Target Database: wlzx_system
Date: 2011-9-5 10:52:46
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for wlzx_system
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system`;
CREATE TABLE `wlzx_system` (
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_system_data_access_mode
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_data_access_mode`;
CREATE TABLE `wlzx_system_data_access_mode` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `symbol` varchar(100) NOT NULL,
  `sequence` bigint(20) default '0',
  `value` varchar(200) default NULL,
  `detail` text,
  `creation_date` datetime NOT NULL,
  `modified_date` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  `empty_flag` tinyint(1) NOT NULL default '1',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `symbol` (`symbol`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_system_department
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_department`;
CREATE TABLE `wlzx_system_department` (
  `id` bigint(20) NOT NULL auto_increment,
  `level` int(11) NOT NULL default '-1',
  `name` varchar(50) NOT NULL,
  `symbol` varchar(100) NOT NULL,
  `phone` varchar(200) default NULL,
  `sequence` bigint(20) default '0',
  `detail` text,
  `creation_date` datetime NOT NULL,
  `modified_date` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `symbol` (`symbol`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COMMENT='系统部门';

-- ----------------------------
-- Table structure for wlzx_system_department_dam_relationship
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_department_dam_relationship`;
CREATE TABLE `wlzx_system_department_dam_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `department_id` bigint(20) NOT NULL,
  `dam_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_system_department_leadship
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_department_leadship`;
CREATE TABLE `wlzx_system_department_leadship` (
  `id` bigint(20) NOT NULL auto_increment,
  `leader_id` bigint(20) NOT NULL,
  `subordinate_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_system_department_role_relationship
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_department_role_relationship`;
CREATE TABLE `wlzx_system_department_role_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `department_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_system_menu
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_menu`;
CREATE TABLE `wlzx_system_menu` (
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
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_system_menu_module_relationship
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_menu_module_relationship`;
CREATE TABLE `wlzx_system_menu_module_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `menu_id` bigint(20) NOT NULL,
  `module_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_system_menu_relationship
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_menu_relationship`;
CREATE TABLE `wlzx_system_menu_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `system_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_system_menu_treeship
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_menu_treeship`;
CREATE TABLE `wlzx_system_menu_treeship` (
  `id` bigint(20) NOT NULL auto_increment,
  `parent_id` bigint(20) NOT NULL,
  `child_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_system_message
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_message`;
CREATE TABLE `wlzx_system_message` (
  `id` bigint(20) NOT NULL auto_increment,
  `from_id` bigint(20) NOT NULL default '0' COMMENT '默认0表示系统发送的消息',
  `to_ids` text NOT NULL,
  `type` int(11) NOT NULL,
  `content` text NOT NULL,
  `creation_date` datetime NOT NULL,
  `read_flags` text,
  `read_dates` text,
  `postRemoved_flag` text,
  `receiveRemoved_flags` text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_system_module
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_module`;
CREATE TABLE `wlzx_system_module` (
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
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_system_module_operation_relationship
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_module_operation_relationship`;
CREATE TABLE `wlzx_system_module_operation_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `module_id` bigint(20) NOT NULL,
  `operation_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_system_module_treeship
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_module_treeship`;
CREATE TABLE `wlzx_system_module_treeship` (
  `id` bigint(20) NOT NULL auto_increment,
  `parent_id` bigint(20) NOT NULL,
  `child_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_system_operation
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_operation`;
CREATE TABLE `wlzx_system_operation` (
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
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_system_operation_dam_relationship
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_operation_dam_relationship`;
CREATE TABLE `wlzx_system_operation_dam_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `operation_id` bigint(20) NOT NULL,
  `dam_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_system_role
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_role`;
CREATE TABLE `wlzx_system_role` (
  `id` bigint(20) NOT NULL auto_increment,
  `symbol` varchar(100) NOT NULL,
  `sequence` bigint(20) default '0',
  `name` varchar(50) NOT NULL,
  `level` int(11) default NULL,
  `detail` text,
  `creation_date` datetime NOT NULL,
  `modified_date` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  `supervisor_flag` tinyint(1) default '0',
  `basic_flag` tinyint(1) default '0',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `symbol` (`symbol`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8 COMMENT='系统角色';

-- ----------------------------
-- Table structure for wlzx_system_role_dam_relationship
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_role_dam_relationship`;
CREATE TABLE `wlzx_system_role_dam_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `role_id` bigint(20) NOT NULL,
  `dam_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=720 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_system_role_department_leadership
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_role_department_leadership`;
CREATE TABLE `wlzx_system_role_department_leadership` (
  `id` bigint(20) NOT NULL auto_increment,
  `role_id` bigint(20) NOT NULL,
  `department_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_system_role_leadship
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_role_leadship`;
CREATE TABLE `wlzx_system_role_leadship` (
  `id` bigint(20) NOT NULL auto_increment,
  `leader_id` bigint(20) NOT NULL,
  `subordinate_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_system_role_user_relationship
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_role_user_relationship`;
CREATE TABLE `wlzx_system_role_user_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `role_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_system_treeship
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_treeship`;
CREATE TABLE `wlzx_system_treeship` (
  `id` bigint(20) NOT NULL auto_increment,
  `parent_id` bigint(20) NOT NULL,
  `child_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wlzx_system_user
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_user`;
CREATE TABLE `wlzx_system_user` (
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
  `main_role_id` bigint(20) default NULL,
  `main_department_id` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `symbol` (`symbol`)
) ENGINE=InnoDB AUTO_INCREMENT=1016 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Table structure for wlzx_system_user_leadship
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_system_user_leadship`;
CREATE TABLE `wlzx_system_user_leadship` (
  `id` bigint(20) NOT NULL auto_increment,
  `leader_id` bigint(20) NOT NULL,
  `subordinate_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `wlzx_system` VALUES ('1', 'root', '0', '温岭数字化校园系列', '数字化校园信息平台是以学校现有网络为基础，以服务于全校师生的教学、科研、生活为目的，建立在学校数据中心平台之上，涵盖了学校的信息化标准管理、学校管理、学生管理、教学管理、教职工管理、科研管理、财务管理、资产与设备管理、行政办公管理、数字图书资料管理等全方位的管理信息平台与信息服务平台。', 'system/index.swf', null, '2011-05-06 11:50:32', '2011-05-06 11:50:32');
INSERT INTO `wlzx_system` VALUES ('2', 'basic', '0', '基础数据系统', '基础数据系统是数字化校园所有业务应用系统的公共数据库，处于中心位置，基础数据库保持最完整、最准确的数据，提供其他业务系统使用。基础数据库管理系统实现对基础数据库所有信息库的维护管理。', 'basic/index.swf', null, '2011-05-06 11:50:32', '2011-05-06 11:50:32');
INSERT INTO `wlzx_system` VALUES ('3', 'oa', '0', '办公自动化系统', '办公自动化系统以公文流转为核心，实现办公流程的快速高效；同时提供多种部门间的信息交流的手段和渠道，加强部门间的沟通协作；提供信息共享的平台，实现公共资源的共享；提供辅助办公功能，为每一项业务提供相关信息，促进学校办公的成熟和规范化；提供强大的搜索查询功能，便于用户在日积月累的海量信息中快速的查找需要的内容', 'oa/index.swf', null, '2011-05-06 11:50:32', '2011-05-06 11:50:32');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('8', '所有部门公告', 'department_notice_read_main@defaultVisit@@noFilter@', '0', null, '', '2011-05-09 00:00:00', '2011-07-28 16:52:42', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('9', '全部数据', 'notice_list_main@defaultVisit@@noFilter@', '0', null, null, '2011-05-09 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('12', '所有日程', 'public_schedule_main@defaultVisit@@noFilter@', '0', null, '', '2011-05-14 00:00:00', '2011-07-29 10:30:52', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('13', '全部数据', 'person_schedule_main@defaultVisit@@noFilter@', '0', null, null, '2011-05-14 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('15', '全部数据', 'staff_work_assign_main@defaultVisit@@noFilter@', '0', null, null, '2011-05-14 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('16', '全部数据', 'public_address_book_main@defaultVisit@@noFilter@', '0', null, null, '2011-05-14 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('19', '所有教师数据', 'staff_file_main@defaultVisit@@noFilter@', '0', null, '', '2011-05-21 00:00:00', '2011-07-28 17:29:11', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('20', '全部数据', 'system_account_main@defaultVisit@@noFilter@', '0', null, null, '2011-05-21 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('21', '全部数据', 'oa_department_set_main@defaultVisit@@noFilter@', '0', null, null, '2011-05-21 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('22', '全部数据', 'oa_role_set_main@defaultVisit@@noFilter@', '0', null, null, '2011-05-21 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('24', '全部数据', 'oa_role_authorization_main@defaultVisit@@noFilter@', '0', null, null, '2011-05-21 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('25', '全部数据', 'oa_pw_change_main@defaultVisit@@noFilter@', '0', null, null, '2011-05-23 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('27', '全部数据', 'places_manage_main@defaultVisit@@noFilter@', '0', null, null, '2011-05-25 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('28', '全部数据', 'basic_directory_main@defaultVisit@@noFilter@', '0', null, null, '2011-05-26 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('30', '全部数据', '@defaultVisit@@noFilter@', '0', null, null, '2011-05-26 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('31', '全部数据', 'staff_input_main@defaultVisit@@noFilter@', '0', null, null, '2011-05-26 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('32', '全部数据', 'adjust_class_apply_main@defaultVisit@@noFilter@', '0', null, null, '2011-05-27 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('33', '全部数据', 'adjust_class_apply_approve_main@defaultVisit@@noFilter@', '0', null, null, '2011-05-27 00:00:00', '2011-09-04 14:46:16', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('34', '全部数据', 'personal_message_main@defaultVisit@@noFilter@', '0', null, null, '2011-06-06 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('35', '全部数据', 'takeLeaveApply_main@defaultVisit@@noFilter@', '0', null, null, '2011-06-06 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('36', '全部数据', 'overWorkApply_main@defaultVisit@@noFilter@', '0', null, null, '2011-06-06 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('37', '全部数据', 'selfCanculateAttendance_main@defaultVisit@@noFilter@', '0', null, null, '2011-06-06 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('38', '全部数据', 'takeLeaveApprove_main@defaultVisit@@noFilter@', '0', null, null, '2011-06-08 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('39', '全部数据', 'takeLeaveWorkDeal@noFilter@', '0', null, null, '2011-06-08 00:00:00', '2011-06-08 15:27:48', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('40', '全部数据', 'takeLeaveOfficeApprove@noFilter@', '0', null, null, '2011-06-08 00:00:00', '2011-07-26 16:01:20', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('41', '全部数据', 'takeLeaveVicePrincipalApprove@noFilter@', '0', null, null, '2011-06-08 00:00:00', '2011-07-26 16:01:43', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('42', '全部数据', 'takeLeavePrincipalApprove@noFilter@', '0', null, null, '2011-06-08 00:00:00', '2011-07-26 16:02:54', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('43', '本处室请假出差数据（处室领导级别有效）', 'takeLeaveApprove_main@defaultVisit@@notSelfOfficeFilter@', '1', null, '', '2011-06-09 00:00:00', '2011-07-22 10:06:43', '0');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('44', '分管处室请假出差数据（副校长级别有效）', 'takeLeaveApprove_main@defaultVisit@@notSelfManagerFilter@', '2', null, '', '2011-06-09 00:00:00', '2011-07-22 10:06:59', '0');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('45', '全部数据', 'moveRestDay_apply_main@defaultVisit@@noFilter@', '0', null, null, '2011-06-10 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('46', '全部数据', 'overWork_approve_main@defaultVisit@@noFilter@', '1', null, '', '2011-06-10 00:00:00', '2011-08-25 23:12:33', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('47', '全部数据', 'moveRestDay_approve_main@defaultVisit@@noFilter@', '1', null, '', '2011-06-10 00:00:00', '2011-08-25 23:13:25', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('48', '全部数据', 'staffCanculateAttendance_main@defaultVisit@@noFilter@', '0', null, null, '2011-06-10 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('49', '全部数据', 'person_notice_main@defaultVisit@@noFilter@', '0', null, null, '2011-06-16 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('50', '全部数据', 'school_notice_read_main@defaultVisit@@noFilter@', '0', null, null, '2011-06-16 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('52', '全部数据', 'person_office_workToDeal_main@defaultVisit@@noFilter@', '0', null, null, '2011-07-01 00:00:00', '2011-07-28 13:52:23', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('53', '全部数据', 'receipt_register_main@defaultVisit@@noFilter@', '0', null, null, '2011-07-02 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('54', '全部数据', 'receipt_devise_main@defaultVisit@@noFilter@', '0', null, null, '2011-07-02 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('55', '全部数据', 'receipt_ratify_main@defaultVisit@@noFilter@', '0', null, null, '2011-07-02 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('56', '全部数据', 'receipt_undertake_main@defaultVisit@@noFilter@', '0', null, null, '2011-07-02 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('57', '全部数据', 'receipt_circulate_main@defaultVisit@@noFilter@', '0', null, null, '2011-07-02 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('58', '全部数据', 'receipt_manage_main@defaultVisit@@noFilter@', '0', null, null, '2011-07-02 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('59', '全部数据', 'conferenceApply_main@defaultVisit@@noFilter@', '0', null, null, '2011-07-06 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('60', '全部数据', 'conferenceRoomCheck_main@defaultVisit@@noFilter@', '0', null, null, '2011-07-06 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('61', '全部数据', 'conferenceSummary_main@defaultVisit@@noFilter@', '0', null, null, '2011-07-06 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('62', '全部数据', 'conferenceArrange_main@defaultVisit@@noFilter@', '0', null, null, '2011-07-06 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('64', '全部数据', 'person_conferenceAttending_main@defaultVisit@@noFilter@', '0', null, null, '2011-07-06 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('65', '全部数据', 'system_oa_setting_main@defaultVisit@@noFilter@', '0', null, null, '2011-07-06 00:00:00', '2011-08-09 17:08:07', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('66', '全部数据', 'postSelfDepartmentSchoolScopeNotice@noFilter@', '0', null, null, '2011-07-22 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('68', '全部数据', 'postAnyNotice@noFilter@', '0', null, null, '2011-07-22 00:00:00', '2011-07-22 09:45:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('70', '全部数据', 'editSelfDepartmentSchoolScopeNotice@noFilter@', '0', null, null, '2011-07-22 00:00:00', '2011-07-22 10:51:44', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('71', '全部数据', 'editAnyNotice@noFilter@', '0', null, null, '2011-07-22 00:00:00', '2011-07-22 10:52:51', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('72', '全部数据', 'documentDrafting_main@defaultVisit@@noFilter@', '0', null, null, '2011-07-22 00:00:00', '2011-07-22 16:40:11', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('73', '全部数据', 'documentCheckDraft_main@defaultVisit@@noFilter@', '0', null, null, '2011-07-22 00:00:00', '2011-07-22 16:39:43', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('74', '全部数据', 'documentCountersign_main@defaultVisit@@noFilter@', '0', null, null, '2011-07-22 00:00:00', '2011-07-22 16:41:32', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('75', '全部数据', 'documentIssue_main@defaultVisit@@noFilter@', '0', null, null, '2011-07-22 00:00:00', '2011-07-22 16:42:27', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('76', '全部数据', 'documentCirculate_main@defaultVisit@@noFilter@', '0', null, null, '2011-07-22 00:00:00', '2011-07-22 16:43:19', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('77', '全部数据', 'documentManage_main@defaultVisit@@noFilter@', '0', null, null, '2011-07-22 00:00:00', '2011-07-22 16:43:57', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('80', '全部数据', 'moveRestDayOfficeApprove@noFilter@', '0', null, '', '2011-07-26 00:00:00', '2011-07-27 09:36:37', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('81', '全部数据', 'moveRestDayVicePrincipalApprove@noFilter@', '0', null, null, '2011-07-26 00:00:00', '2011-07-26 16:03:36', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('83', '全部数据', 'moveRestDayAllApprove@noFilter@', '0', null, null, '2011-07-26 00:00:00', '2011-07-26 16:04:47', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('84', '全部数据', 'takeLeaveTerminateApprove@noFilter@', '0', null, null, '2011-07-27 00:00:00', '2011-07-27 14:40:59', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('85', '所属部门公告', 'department_notice_read_main@defaultVisit@@departmentFilter@', '1', null, '', '2011-07-28 00:00:00', '2011-07-28 16:53:22', '0');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('86', '全部数据', 'staff_edit_delete_so_on@noFilter@', '0', null, null, '2011-07-28 00:00:00', '2011-07-28 17:47:33', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('87', '全部数据', 'canShareInSchool@noFilter@', '0', null, null, '2011-07-29 00:00:00', '2011-07-29 10:03:17', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('88', '全部数据', 'canShareInDepartment@noFilter@', '0', null, null, '2011-07-29 00:00:00', '2011-07-29 10:03:44', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('89', '学校日程', 'public_schedule_main@defaultVisit@@notSchoolFilter@', '1', null, '', '2011-07-29 00:00:00', '2011-07-29 10:32:52', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('90', '所在部门日程', 'public_schedule_main@defaultVisit@@notselfDepartmentFilter@', '1', null, '', '2011-07-29 00:00:00', '2011-07-29 10:32:32', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('91', '全部数据', 'publicScheduleEditAndDelete@noFilter@', '0', null, null, '2011-07-29 00:00:00', '2011-07-29 10:34:37', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('92', '本处室加班数据', 'overWork_approve_main@defaultVisit@@notSelfOfficeFilter@', '0', null, '', '2011-08-25 00:00:00', '2011-08-25 23:12:14', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('93', '本处室调休数据', 'moveRestDay_approve_main@defaultVisit@@notSelfOfficeFilter@', '0', null, '', '2011-08-25 00:00:00', '2011-08-25 23:13:51', '1');
INSERT INTO `wlzx_system_data_access_mode` VALUES ('94', '全部数据', 'adjust_class_apply_arrange_main@defaultVisit@@noFilter@', '0', null, null, '2011-09-04 00:00:00', '2011-09-04 14:46:35', '1');
INSERT INTO `wlzx_system_department` VALUES ('1', '0', '行政组', 'root', null, '0', '', '2011-05-06 00:00:00', '2011-08-26 09:51:06');
INSERT INTO `wlzx_system_department` VALUES ('3', '1', '德育处', 'moral_education_office', null, '2', '', '2011-05-10 00:00:00', '2011-08-30 16:28:56');
INSERT INTO `wlzx_system_department` VALUES ('6', '1', '校长办公室', 'headmaster_office', null, '1', '', '2011-05-18 00:00:00', '2011-08-30 16:28:44');
INSERT INTO `wlzx_system_department` VALUES ('10', '1', '综践处', 'practice_education_office', '', '4', '', '2011-05-19 00:00:00', '2011-08-30 16:29:19');
INSERT INTO `wlzx_system_department` VALUES ('11', '1', '资源处', 'resources_office', '', '5', '', '2011-05-19 00:00:00', '2011-08-30 16:09:15');
INSERT INTO `wlzx_system_department` VALUES ('12', '1', '课程处', 'course_office', '', '3', '', '2011-05-20 00:00:00', '2011-08-30 16:29:09');
INSERT INTO `wlzx_system_department` VALUES ('13', '2', '语文组', 'course_yuwen', '', '1', '', '2011-07-04 00:00:00', '2011-08-30 17:05:53');
INSERT INTO `wlzx_system_department` VALUES ('14', '2', '英语组', 'course_yingyu', '', '2', '', '2011-07-04 00:00:00', '2011-08-30 17:06:01');
INSERT INTO `wlzx_system_department` VALUES ('15', '2', '数学组', 'course_shuxue', '', '3', '', '2011-07-04 00:00:00', '2011-08-30 17:06:11');
INSERT INTO `wlzx_system_department` VALUES ('16', '2', '物理组', 'course_wuli', '', '4', '', '2011-07-04 00:00:00', '2011-08-30 17:06:24');
INSERT INTO `wlzx_system_department` VALUES ('17', '2', '化学组', 'course_huaxue', '', '5', '', '2011-07-04 00:00:00', '2011-08-30 17:06:33');
INSERT INTO `wlzx_system_department` VALUES ('18', '2', '生物组', 'course_shengwu', '', '6', '', '2011-07-04 00:00:00', '2011-08-30 17:06:42');
INSERT INTO `wlzx_system_department` VALUES ('19', '2', '政治组', 'course_zhengzhi', '', '7', '', '2011-07-04 00:00:00', '2011-08-30 17:06:50');
INSERT INTO `wlzx_system_department` VALUES ('20', '2', '历史组', 'course_lishi', '', '8', '', '2011-07-04 00:00:00', '2011-08-30 17:06:59');
INSERT INTO `wlzx_system_department` VALUES ('21', '2', '地理组', 'course_dili', '', '9', '', '2011-07-04 00:00:00', '2011-08-30 17:07:09');
INSERT INTO `wlzx_system_department` VALUES ('22', '2', '文书室', 'wenshu_office', '', '4', '', '2011-07-04 00:00:00', '2011-08-30 17:04:40');
INSERT INTO `wlzx_system_department` VALUES ('23', '2', '宣传科', 'xuanchuan_office', '', '2', '', '2011-07-04 00:00:00', '2011-08-30 17:04:02');
INSERT INTO `wlzx_system_department` VALUES ('24', '2', '督导科', 'dudao_office', '', '1', '', '2011-07-04 00:00:00', '2011-08-30 17:04:09');
INSERT INTO `wlzx_system_department` VALUES ('25', '2', '档案室', 'dangan_office', '', '3', '', '2011-07-04 00:00:00', '2011-08-30 17:04:24');
INSERT INTO `wlzx_system_department` VALUES ('26', '2', '学生科', 'students_office', '', '1', '', '2011-07-04 00:00:00', '2011-08-30 17:04:49');
INSERT INTO `wlzx_system_department` VALUES ('27', '2', '安保科', 'anbao_office', '', '2', '', '2011-07-04 00:00:00', '2011-08-30 17:04:56');
INSERT INTO `wlzx_system_department` VALUES ('28', '2', '医务室', 'hospital_office', '', '3', '', '2011-07-04 00:00:00', '2011-08-30 17:05:02');
INSERT INTO `wlzx_system_department` VALUES ('29', '2', '心理室', 'xinli_office', '', '4', '', '2011-07-04 00:00:00', '2011-08-30 17:05:10');
INSERT INTO `wlzx_system_department` VALUES ('33', '2', '体育组', 'tiyu_office', '', '3', '', '2011-07-04 00:00:00', '2011-08-30 17:08:03');
INSERT INTO `wlzx_system_department` VALUES ('34', '2', '信息组', 'information_office', '', '4', '', '2011-07-04 00:00:00', '2011-08-30 17:08:10');
INSERT INTO `wlzx_system_department` VALUES ('35', '2', '劳艺组', 'laoyi_office', '', '1', '', '2011-07-04 00:00:00', '2011-08-30 17:07:48');
INSERT INTO `wlzx_system_department` VALUES ('36', '2', '图书馆', 'liberary_office', '', '2', '', '2011-07-04 00:00:00', '2011-08-30 17:07:56');
INSERT INTO `wlzx_system_department` VALUES ('37', '2', '网络中心', 'network_center', '', '5', '', '2011-07-04 00:00:00', '2011-08-30 17:08:16');
INSERT INTO `wlzx_system_department` VALUES ('38', '2', '电视台', 'television_center', '', '6', '', '2011-07-04 00:00:00', '2011-08-30 17:08:25');
INSERT INTO `wlzx_system_department` VALUES ('39', '2', '总务科', 'zongwu_office', '', '1', '', '2011-07-04 00:00:00', '2011-08-30 17:08:48');
INSERT INTO `wlzx_system_department` VALUES ('40', '2', '财务科', 'caiwu_office', '', '2', '', '2011-07-04 00:00:00', '2011-08-30 17:08:59');
INSERT INTO `wlzx_system_department` VALUES ('41', '2', '维修科', 'weixiu_office', '', '3', '', '2011-07-04 00:00:00', '2011-08-30 17:09:07');
INSERT INTO `wlzx_system_department` VALUES ('42', '2', '膳食科', 'shanshi_office', '', '4', '', '2011-07-04 00:00:00', '2011-08-30 17:09:16');
INSERT INTO `wlzx_system_department` VALUES ('43', '2', '教务科', 'jiaowu_office', '', '0', '', '2011-07-04 00:00:00', '2011-08-30 17:07:35');
INSERT INTO `wlzx_system_department` VALUES ('44', '1', '高一年级段管理委员会', 'grade_1_committee', '', '6', '', '2011-08-01 00:00:00', '2011-08-30 16:28:19');
INSERT INTO `wlzx_system_department` VALUES ('45', '1', '高二年级段管理委员会', 'grade_2_committee', '', '7', '', '2011-08-01 00:00:00', '2011-08-30 16:26:33');
INSERT INTO `wlzx_system_department` VALUES ('46', '1', '高三年级段管理委员会', 'grade_3_committee', '', '8', '', '2011-08-01 00:00:00', '2011-08-30 16:27:55');
INSERT INTO `wlzx_system_department` VALUES ('47', '2', '通技组', 'tongji_group', '', '0', '', '2011-09-01 00:00:00', '2011-09-05 08:29:08');
INSERT INTO `wlzx_system_department_dam_relationship` VALUES ('29', '1', '16');
INSERT INTO `wlzx_system_department_dam_relationship` VALUES ('32', '1', '19');
INSERT INTO `wlzx_system_department_dam_relationship` VALUES ('33', '1', '22');
INSERT INTO `wlzx_system_department_dam_relationship` VALUES ('35', '1', '24');
INSERT INTO `wlzx_system_department_dam_relationship` VALUES ('36', '1', '15');
INSERT INTO `wlzx_system_department_dam_relationship` VALUES ('37', '1', '13');
INSERT INTO `wlzx_system_department_dam_relationship` VALUES ('40', '1', '12');
INSERT INTO `wlzx_system_department_dam_relationship` VALUES ('41', '1', '21');
INSERT INTO `wlzx_system_department_dam_relationship` VALUES ('42', '1', '20');
INSERT INTO `wlzx_system_department_dam_relationship` VALUES ('45', '1', '9');
INSERT INTO `wlzx_system_department_dam_relationship` VALUES ('46', '1', '8');
INSERT INTO `wlzx_system_department_leadship` VALUES ('2', '1', '3');
INSERT INTO `wlzx_system_department_leadship` VALUES ('5', '1', '6');
INSERT INTO `wlzx_system_department_leadship` VALUES ('9', '1', '10');
INSERT INTO `wlzx_system_department_leadship` VALUES ('10', '1', '11');
INSERT INTO `wlzx_system_department_leadship` VALUES ('11', '1', '12');
INSERT INTO `wlzx_system_department_leadship` VALUES ('12', '12', '13');
INSERT INTO `wlzx_system_department_leadship` VALUES ('13', '12', '14');
INSERT INTO `wlzx_system_department_leadship` VALUES ('14', '12', '15');
INSERT INTO `wlzx_system_department_leadship` VALUES ('15', '12', '16');
INSERT INTO `wlzx_system_department_leadship` VALUES ('16', '12', '17');
INSERT INTO `wlzx_system_department_leadship` VALUES ('17', '12', '18');
INSERT INTO `wlzx_system_department_leadship` VALUES ('18', '12', '19');
INSERT INTO `wlzx_system_department_leadship` VALUES ('19', '12', '20');
INSERT INTO `wlzx_system_department_leadship` VALUES ('20', '12', '21');
INSERT INTO `wlzx_system_department_leadship` VALUES ('21', '6', '22');
INSERT INTO `wlzx_system_department_leadship` VALUES ('22', '6', '23');
INSERT INTO `wlzx_system_department_leadship` VALUES ('23', '6', '24');
INSERT INTO `wlzx_system_department_leadship` VALUES ('24', '6', '25');
INSERT INTO `wlzx_system_department_leadship` VALUES ('25', '3', '26');
INSERT INTO `wlzx_system_department_leadship` VALUES ('26', '3', '27');
INSERT INTO `wlzx_system_department_leadship` VALUES ('27', '3', '28');
INSERT INTO `wlzx_system_department_leadship` VALUES ('28', '3', '29');
INSERT INTO `wlzx_system_department_leadship` VALUES ('32', '10', '33');
INSERT INTO `wlzx_system_department_leadship` VALUES ('33', '10', '34');
INSERT INTO `wlzx_system_department_leadship` VALUES ('34', '10', '35');
INSERT INTO `wlzx_system_department_leadship` VALUES ('35', '10', '36');
INSERT INTO `wlzx_system_department_leadship` VALUES ('36', '10', '37');
INSERT INTO `wlzx_system_department_leadship` VALUES ('37', '10', '38');
INSERT INTO `wlzx_system_department_leadship` VALUES ('38', '11', '39');
INSERT INTO `wlzx_system_department_leadship` VALUES ('39', '11', '40');
INSERT INTO `wlzx_system_department_leadship` VALUES ('40', '11', '41');
INSERT INTO `wlzx_system_department_leadship` VALUES ('41', '11', '42');
INSERT INTO `wlzx_system_department_leadship` VALUES ('42', '12', '43');
INSERT INTO `wlzx_system_department_leadship` VALUES ('43', '1', '44');
INSERT INTO `wlzx_system_department_leadship` VALUES ('44', '1', '45');
INSERT INTO `wlzx_system_department_leadship` VALUES ('45', '1', '46');
INSERT INTO `wlzx_system_department_leadship` VALUES ('46', '10', '47');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('1', '1', '1');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('3', '3', '3');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('6', '6', '6');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('10', '10', '16');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('11', '11', '17');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('12', '12', '22');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('13', '13', '23');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('14', '14', '24');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('15', '15', '25');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('16', '16', '26');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('17', '17', '27');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('18', '18', '28');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('19', '19', '29');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('20', '20', '30');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('21', '21', '31');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('22', '22', '32');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('23', '23', '33');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('24', '24', '34');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('25', '25', '35');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('26', '26', '36');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('27', '27', '37');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('28', '28', '38');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('29', '29', '39');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('33', '33', '43');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('34', '34', '44');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('35', '35', '45');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('36', '36', '46');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('37', '37', '47');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('38', '38', '48');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('39', '39', '49');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('40', '40', '50');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('41', '41', '51');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('42', '42', '52');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('43', '43', '53');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('44', '44', '71');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('45', '45', '72');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('46', '46', '73');
INSERT INTO `wlzx_system_department_role_relationship` VALUES ('47', '47', '114');
INSERT INTO `wlzx_system_menu` VALUES ('9', '我的申请', 'person_apply', '3', '', null, '2011-05-06 00:00:00', '2011-07-28 13:37:47');
INSERT INTO `wlzx_system_menu` VALUES ('10', '行政办公', 'oa_official_document', '1', null, 'resources/oa/menuIcon/oa_official_document.png', '2011-05-06 00:00:00', '2011-09-02 12:07:24');
INSERT INTO `wlzx_system_menu` VALUES ('11', '教学管理', 'oa_public_affair', '2', '', 'resources/oa/menuIcon/oa_public_affair.png', '2011-05-06 00:00:00', '2011-09-02 12:07:24');
INSERT INTO `wlzx_system_menu` VALUES ('12', '公告管理', 'notice_manage', '1', '', null, '2011-05-06 00:00:00', '2011-05-06 11:50:32');
INSERT INTO `wlzx_system_menu` VALUES ('13', '公告管理', 'notice_list', '4', '', null, '2011-05-06 00:00:00', '2011-05-06 11:50:32');
INSERT INTO `wlzx_system_menu` VALUES ('16', '日程安排', 'scheduleManage', '1', '', null, '2011-05-06 00:00:00', '2011-07-28 13:33:56');
INSERT INTO `wlzx_system_menu` VALUES ('17', '学校管理', 'oa_school_affair', '4', '', 'resources/oa/menuIcon/oa_school_affair.png', '2011-05-06 00:00:00', '2011-09-02 12:07:24');
INSERT INTO `wlzx_system_menu` VALUES ('18', '系统管理', 'oa_system_management', '6', '', 'resources/oa/menuIcon/oa_system_management.png', '2011-05-06 00:00:00', '2011-09-02 12:07:24');
INSERT INTO `wlzx_system_menu` VALUES ('19', '部门与岗位', 'oa_school_affair_department_role', '0', null, null, '2011-05-06 11:50:33', '2011-05-06 11:50:33');
INSERT INTO `wlzx_system_menu` VALUES ('20', '部门公告', 'department_notice_read', '2', '', '', '2011-05-07 00:00:00', '2011-05-07 11:06:17');
INSERT INTO `wlzx_system_menu` VALUES ('21', '公共日程', 'public_schedule', '0', '', '', '2011-05-10 00:00:00', '2011-05-10 11:18:04');
INSERT INTO `wlzx_system_menu` VALUES ('22', '个人日程', 'person_schedule', '1', '', '', '2011-05-10 00:00:00', '2011-05-10 11:18:26');
INSERT INTO `wlzx_system_menu` VALUES ('23', '工作管理', 'work_management', '0', '', '', '2011-05-10 00:00:00', '2011-05-10 11:20:13');
INSERT INTO `wlzx_system_menu` VALUES ('24', '通讯录', 'address_book', '4', '', '', '2011-05-10 00:00:00', '2011-05-10 11:21:13');
INSERT INTO `wlzx_system_menu` VALUES ('28', '工作指派', 'staff_work_assign', '3', '', '', '2011-05-10 00:00:00', '2011-05-10 11:26:18');
INSERT INTO `wlzx_system_menu` VALUES ('29', '公共通讯录', 'public_address_book', '0', '', '', '2011-05-10 00:00:00', '2011-05-10 11:28:18');
INSERT INTO `wlzx_system_menu` VALUES ('31', '人事管理', 'human_resource', '3', '', 'resources/oa/menuIcon/human_resource.png', '2011-05-21 00:00:00', '2011-09-02 12:07:24');
INSERT INTO `wlzx_system_menu` VALUES ('32', '教师档案', 'staff_file', '1', '', '', '2011-05-21 00:00:00', '2011-05-21 09:44:43');
INSERT INTO `wlzx_system_menu` VALUES ('33', '帐号管理', 'system_account', '1', '', '', '2011-05-21 00:00:00', '2011-05-21 09:46:20');
INSERT INTO `wlzx_system_menu` VALUES ('34', '收文管理', 'document_receipt', '1', '', '', '2011-05-21 00:00:00', '2011-05-21 09:48:55');
INSERT INTO `wlzx_system_menu` VALUES ('35', '发文管理', 'document_dispatch ', '2', '', '', '2011-05-21 00:00:00', '2011-05-21 09:49:28');
INSERT INTO `wlzx_system_menu` VALUES ('36', '部门设置', 'oa_department_set', '1', '', '', '2011-05-21 00:00:00', '2011-05-21 10:05:48');
INSERT INTO `wlzx_system_menu` VALUES ('37', '岗位设置', 'oa_role_set', '2', '', '', '2011-05-21 00:00:00', '2011-05-21 10:06:23');
INSERT INTO `wlzx_system_menu` VALUES ('39', '岗位授权', 'oa_role_authorization', '3', '', '', '2011-05-21 00:00:00', '2011-05-21 11:20:42');
INSERT INTO `wlzx_system_menu` VALUES ('40', '密码修改', 'oa_pw_change', '0', '', '', '2011-05-23 00:00:00', '2011-05-23 22:45:32');
INSERT INTO `wlzx_system_menu` VALUES ('41', '场所管理', 'places_manage', '0', '', '', '2011-05-25 00:00:00', '2011-05-25 10:16:25');
INSERT INTO `wlzx_system_menu` VALUES ('42', '数据字典', 'basic_directory', '0', '', '', '2011-05-26 00:00:00', '2011-05-26 09:50:57');
INSERT INTO `wlzx_system_menu` VALUES ('43', '教师录入', 'staff_input_menu', '0', '', '', '2011-05-26 00:00:00', '2011-05-26 22:58:28');
INSERT INTO `wlzx_system_menu` VALUES ('44', '调课管理', 'adjust_class', '0', '', '', '2011-05-27 00:00:00', '2011-05-27 22:28:44');
INSERT INTO `wlzx_system_menu` VALUES ('46', '考勤管理', 'attendance_manager', '4', '', '', '2011-05-27 00:00:00', '2011-05-27 22:30:15');
INSERT INTO `wlzx_system_menu` VALUES ('47', '调课申请', 'adjust_class_apply', '0', '', '', '2011-05-27 00:00:00', '2011-05-27 22:32:02');
INSERT INTO `wlzx_system_menu` VALUES ('48', '调课审批', 'adjust_class_apply_approve', '2', '', '', '2011-05-27 00:00:00', '2011-05-27 22:33:09');
INSERT INTO `wlzx_system_menu` VALUES ('49', '教师管理', 'teacher_manager', '0', '', '', '2011-05-27 00:00:00', '2011-05-27 22:38:31');
INSERT INTO `wlzx_system_menu` VALUES ('50', '我的办公桌', 'personal_office', '0', '', 'resources/oa/menuIcon/personal_office.png', '2011-06-03 00:00:00', '2011-09-02 12:07:24');
INSERT INTO `wlzx_system_menu` VALUES ('51', '请假出差', 'personal_office_takeLeaveApply', '4', '', '', '2011-06-03 00:00:00', '2011-06-03 11:28:47');
INSERT INTO `wlzx_system_menu` VALUES ('52', '加班申请', 'personal_office_overWork Apply', '5', '', '', '2011-06-03 00:00:00', '2011-06-03 11:29:51');
INSERT INTO `wlzx_system_menu` VALUES ('53', '个人考勤', 'personal_office_canculateAttendance', '5', '', '', '2011-06-03 00:00:00', '2011-06-03 11:31:08');
INSERT INTO `wlzx_system_menu` VALUES ('55', '请假出差审批', 'attendance_manager_takeLeaveApprove', '0', '', '', '2011-06-03 00:00:00', '2011-06-03 11:33:25');
INSERT INTO `wlzx_system_menu` VALUES ('56', '加班审批', 'attendance_manager_overWorkApprove', '1', '', '', '2011-06-03 00:00:00', '2011-06-03 11:34:01');
INSERT INTO `wlzx_system_menu` VALUES ('57', '考勤统计', 'attendance_manager_canculateAttendance', '3', '', '', '2011-06-03 00:00:00', '2011-06-03 11:34:50');
INSERT INTO `wlzx_system_menu` VALUES ('58', '我的消息', 'personal_office_messageDeal', '0', '', '', '2011-06-03 00:00:00', '2011-06-03 11:36:28');
INSERT INTO `wlzx_system_menu` VALUES ('59', '调休申请', 'moveRestDay_apply', '6', '', '', '2011-06-10 00:00:00', '2011-06-10 16:10:32');
INSERT INTO `wlzx_system_menu` VALUES ('60', '调休审批', 'moveRestDay_approve', '2', '', '', '2011-06-10 00:00:00', '2011-06-10 21:14:42');
INSERT INTO `wlzx_system_menu` VALUES ('61', '公告发布', 'person_notice', '1', '', '', '2011-06-16 00:00:00', '2011-06-16 00:01:41');
INSERT INTO `wlzx_system_menu` VALUES ('62', '学校公告', 'school_notice_read', '3', '', '', '2011-06-16 00:00:00', '2011-06-16 00:02:52');
INSERT INTO `wlzx_system_menu` VALUES ('63', '我的工作', 'person_office_workToDeal', '2', '', '', '2011-07-01 00:00:00', '2011-07-01 09:46:03');
INSERT INTO `wlzx_system_menu` VALUES ('64', '收文登记', 'receipt_register_menu', '0', '', '', '2011-07-02 00:00:00', '2011-07-02 10:38:04');
INSERT INTO `wlzx_system_menu` VALUES ('66', '收文拟办', 'receipt_devise', '1', '', '', '2011-07-02 00:00:00', '2011-07-02 16:35:44');
INSERT INTO `wlzx_system_menu` VALUES ('67', '收文批示', 'receipt_ratify', '2', '', '', '2011-07-01 00:00:00', '2011-07-02 16:36:17');
INSERT INTO `wlzx_system_menu` VALUES ('68', '收文承办', 'receipt_undertake', '3', '', '', '2011-07-02 00:00:00', '2011-07-02 16:36:59');
INSERT INTO `wlzx_system_menu` VALUES ('69', '收文传阅', 'receipt_circulate', '4', '', '', '2011-07-02 00:00:00', '2011-07-02 16:37:37');
INSERT INTO `wlzx_system_menu` VALUES ('70', '收文管理', 'receipt_manage', '5', '', '', '2011-07-02 00:00:00', '2011-07-02 16:38:27');
INSERT INTO `wlzx_system_menu` VALUES ('71', '会议管理', 'conferenceManage', '3', '', '', '2011-07-06 00:00:00', '2011-07-06 12:00:26');
INSERT INTO `wlzx_system_menu` VALUES ('72', '会议申请', 'conferenceApply', '0', '', '', '2011-07-06 00:00:00', '2011-07-06 12:01:22');
INSERT INTO `wlzx_system_menu` VALUES ('73', '会议室查看', 'conferenceRoomCheck', '3', '', '', '2011-07-06 00:00:00', '2011-07-06 12:02:22');
INSERT INTO `wlzx_system_menu` VALUES ('74', '会议总结', 'conferenceSummary', '1', '', '', '2011-07-06 00:00:00', '2011-07-06 12:03:32');
INSERT INTO `wlzx_system_menu` VALUES ('75', '会议调整', 'conferenceArrange', '2', '', '', '2011-07-06 00:00:00', '2011-07-06 12:04:16');
INSERT INTO `wlzx_system_menu` VALUES ('77', '我参与的会议', 'person_conferenceAttending', '6', '', '', '2011-07-06 00:00:00', '2011-07-06 12:14:50');
INSERT INTO `wlzx_system_menu` VALUES ('78', '系统设置', 'system_oa_setting', '0', '', '', '2011-07-06 00:00:00', '2011-08-09 17:06:08');
INSERT INTO `wlzx_system_menu` VALUES ('79', '发文拟稿', 'documentDrafting', '0', '', '', '2011-07-22 00:00:00', '2011-07-22 16:27:26');
INSERT INTO `wlzx_system_menu` VALUES ('80', '发文核稿', 'documentCheckDraft', '1', '', '', '2011-07-22 00:00:00', '2011-07-22 16:31:33');
INSERT INTO `wlzx_system_menu` VALUES ('81', '发文会签', 'documentCountersign', '2', '', '', '2011-07-22 00:00:00', '2011-07-22 16:32:33');
INSERT INTO `wlzx_system_menu` VALUES ('82', '发文签发', 'documentIssue', '3', '', '', '2011-07-22 00:00:00', '2011-07-22 16:34:13');
INSERT INTO `wlzx_system_menu` VALUES ('83', '发文传阅', 'documentCirculation ', '4', '', '', '2011-07-22 00:00:00', '2011-07-22 16:35:03');
INSERT INTO `wlzx_system_menu` VALUES ('84', '发文管理', 'documentManage', '5', '', '', '2011-07-22 00:00:00', '2011-07-22 16:35:41');
INSERT INTO `wlzx_system_menu` VALUES ('85', '公文管理', 'oa_document_manager', '2', null, null, '2011-07-28 13:56:29', '2011-07-28 13:57:18');
INSERT INTO `wlzx_system_menu` VALUES ('86', '调课安排', 'adjust_class_apply_arrange', '1', '', '', '2011-09-04 00:00:00', '2011-09-04 13:26:57');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('6', '20', '6');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('7', '13', '7');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('11', '21', '11');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('12', '22', '12');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('14', '28', '14');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('15', '29', '15');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('18', '32', '18');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('19', '33', '19');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('20', '36', '20');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('21', '37', '21');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('23', '39', '23');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('24', '40', '28');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('26', '41', '30');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('27', '42', '31');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('30', '43', '34');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('31', '47', '35');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('32', '48', '36');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('33', '58', '37');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('34', '51', '38');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('35', '52', '39');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('36', '53', '40');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('37', '55', '41');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('38', '59', '42');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('39', '56', '43');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('40', '60', '44');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('41', '57', '45');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('42', '61', '46');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('43', '62', '47');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('45', '63', '49');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('46', '64', '50');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('47', '66', '51');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('48', '67', '52');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('49', '68', '53');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('50', '69', '54');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('51', '70', '55');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('52', '72', '56');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('53', '73', '57');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('54', '74', '58');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('55', '75', '59');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('57', '77', '61');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('58', '78', '62');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('59', '79', '63');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('60', '80', '64');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('61', '81', '65');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('62', '82', '66');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('63', '83', '67');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('64', '84', '68');
INSERT INTO `wlzx_system_menu_module_relationship` VALUES ('65', '86', '69');
INSERT INTO `wlzx_system_menu_relationship` VALUES ('5', '3', '10');
INSERT INTO `wlzx_system_menu_relationship` VALUES ('6', '3', '11');
INSERT INTO `wlzx_system_menu_relationship` VALUES ('7', '3', '17');
INSERT INTO `wlzx_system_menu_relationship` VALUES ('8', '3', '18');
INSERT INTO `wlzx_system_menu_relationship` VALUES ('9', '3', '31');
INSERT INTO `wlzx_system_menu_relationship` VALUES ('10', '3', '50');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('6', '10', '12');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('7', '50', '16');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('8', '12', '13');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('16', '12', '20');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('17', '16', '21');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('18', '16', '22');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('19', '10', '23');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('20', '50', '24');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('24', '23', '28');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('25', '24', '29');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('27', '49', '32');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('28', '18', '33');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('29', '85', '34');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('30', '85', '35');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('31', '17', '36');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('32', '17', '37');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('34', '17', '39');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('35', '18', '40');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('36', '17', '41');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('37', '18', '42');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('38', '49', '43');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('39', '11', '44');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('41', '10', '46');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('42', '44', '47');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('43', '44', '48');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('44', '31', '49');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('45', '9', '51');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('46', '9', '52');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('47', '50', '53');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('49', '46', '55');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('50', '46', '56');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('51', '46', '57');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('52', '50', '58');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('53', '9', '59');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('54', '46', '60');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('55', '12', '61');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('56', '12', '62');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('57', '50', '63');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('58', '34', '64');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('60', '34', '66');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('61', '34', '67');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('62', '34', '68');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('63', '34', '69');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('64', '34', '70');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('65', '10', '71');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('66', '71', '72');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('67', '71', '73');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('68', '71', '74');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('69', '71', '75');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('71', '50', '77');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('72', '18', '78');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('73', '35', '79');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('74', '35', '80');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('75', '35', '81');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('76', '35', '82');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('77', '35', '83');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('78', '35', '84');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('79', '50', '9');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('80', '10', '85');
INSERT INTO `wlzx_system_menu_treeship` VALUES ('81', '44', '86');
INSERT INTO `wlzx_system_message` VALUES ('1', '0', '1;', '1', '1', '2011-07-29 15:49:49', '0;', 'Null;', '0', '0;');
INSERT INTO `wlzx_system_message` VALUES ('3', '708', '840;864;708;', '1', '我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew我国巍峨各位iguewgew', '2011-07-29 17:19:31', '0;0;0;', 'Null;Null;Null;', '0', '0;0;1;');
INSERT INTO `wlzx_system_message` VALUES ('4', '708', '708;1;', '1', '111111111', '2011-07-30 10:17:37', '1;1;', '2011-07-30;2011-07-30;', '1', '1;0;');
INSERT INTO `wlzx_system_message` VALUES ('5', '708', '708;', '1', '11111', '2011-07-30 10:42:23', '1;', '2011-07-30;', '0', '0;');
INSERT INTO `wlzx_system_message` VALUES ('6', '708', '840;864;708;', '1', '12', '2011-07-30 11:47:49', '0;0;0;', 'NULL;NULL;NULL;', '0', '0;0;0;');
INSERT INTO `wlzx_system_message` VALUES ('7', '708', '708;1;', '1', '111111111', '2011-07-30 11:58:12', '0;0;', 'NULL;NULL;', '0', '0;0;');
INSERT INTO `wlzx_system_message` VALUES ('8', '708', '708;', '1', '222222222222222222222222', '2011-07-30 11:58:31', '1;', '2011-07-30 17:51:36;', '0', '0;');
INSERT INTO `wlzx_system_message` VALUES ('9', '0', '', '0', '请课程处落实申请编号为20110904225422的请假/出差申请期间教学工作', '2011-09-04 22:54:22', '0;', 'NULL;', '0', '0;');
INSERT INTO `wlzx_system_message` VALUES ('10', '0', '984', '0', '您申请的编号为20110904225422的请假/出差审批已经通过', '2011-09-04 22:57:18', '0;', 'NULL;', '0', '0;');
INSERT INTO `wlzx_system_message` VALUES ('11', '0', '', '0', '请课程处落实申请编号为20110904230020的请假/出差申请期间教学工作', '2011-09-04 23:00:21', '0;', 'NULL;', '0', '0;');
INSERT INTO `wlzx_system_message` VALUES ('12', '0', '708', '0', 'null老师申请与您调课已经审批通过，上课班级为11，课时2011-09-04  第一节 第三节 ,调整为课时2011-09-07  第三节 第五节 ，请准时上课', '2011-09-04 23:04:10', '0;', 'NULL;', '0', '0;');
INSERT INTO `wlzx_system_message` VALUES ('13', '0', '1', '0', '您申请的调课审批已经通过，调课教师为陈才锜/，上课班级为11/，原课时间为2011-09-04  第一节 第三节 /，调整为2011-09-07  第三节 第五节 /，请准时上课', '2011-09-04 23:04:10', '0;', 'NULL;', '0', '0;');
INSERT INTO `wlzx_system_message` VALUES ('14', '0', '736', '0', '您申请的编号为20110904230020的请假/出差审批已经通过', '2011-09-04 23:06:03', '0;', 'NULL;', '0', '0;');
INSERT INTO `wlzx_system_module` VALUES ('6', '部门公告阅读主模块', 'department_notice_read_main', '0', '', '2011-05-09 00:00:00', '2011-06-16 00:05:21', 'oa/notice/noticeList.swf', 'department');
INSERT INTO `wlzx_system_module` VALUES ('7', '公告管理主模块', 'notice_list_main', '0', '', '2011-05-09 00:00:00', '2011-06-15 21:51:54', 'oa/notice/noticeManage.swf', 'list');
INSERT INTO `wlzx_system_module` VALUES ('11', '公共日程主模块', 'public_schedule_main', '0', '', '2011-05-14 00:00:00', '2011-06-16 10:38:11', 'oa/schedule/publicSchedule.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('12', '个人日程主模块', 'person_schedule_main', '0', '', '2011-05-14 00:00:00', '2011-06-16 10:38:57', 'oa/schedule/personSchedule.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('14', '工作指派主模块', 'staff_work_assign_main', '0', '', '2011-05-14 00:00:00', '2011-06-16 10:47:07', 'oa/task/taskManager.swf', 'add');
INSERT INTO `wlzx_system_module` VALUES ('15', '公共通讯录主模块', 'public_address_book_main', '0', '', '2011-05-14 00:00:00', '2011-05-14 15:05:56', 'oa/communication/publicAddressBook.swf', null);
INSERT INTO `wlzx_system_module` VALUES ('18', '教师档案主模块', 'staff_file_main', '0', '', '2011-05-21 00:00:00', '2011-05-21 09:47:23', 'basic/staff/staffList.swf', null);
INSERT INTO `wlzx_system_module` VALUES ('19', '帐号管理主模块', 'system_account_main', '0', '', '2011-05-21 00:00:00', '2011-05-21 09:48:08', 'basic/account/accountList.swf', null);
INSERT INTO `wlzx_system_module` VALUES ('20', '部门设置主模块', 'oa_department_set_main', '0', '', '2011-05-21 00:00:00', '2011-05-21 14:06:34', 'basic/setting/departmentSetting.swf', null);
INSERT INTO `wlzx_system_module` VALUES ('21', '岗位设置主模块', 'oa_role_set_main', '0', '', '2011-05-21 00:00:00', '2011-05-21 10:09:11', 'basic/setting/roleSetting.swf', null);
INSERT INTO `wlzx_system_module` VALUES ('23', '岗位授权主模块', 'oa_role_authorization_main', '0', '', '2011-05-21 00:00:00', '2011-05-21 14:04:54', 'basic/authorization/roleAuthorization.swf', null);
INSERT INTO `wlzx_system_module` VALUES ('28', '密码修改主模块', 'oa_pw_change_main', '0', '', '2011-05-23 00:00:00', '2011-05-23 23:11:11', 'basic/account/accountPw.swf', null);
INSERT INTO `wlzx_system_module` VALUES ('30', '场所管理主模块', 'places_manage_main', '0', '', '2011-05-25 00:00:00', '2011-05-25 16:19:12', 'basic/place/placeList.swf', null);
INSERT INTO `wlzx_system_module` VALUES ('31', '数据字典主模块', 'basic_directory_main', '0', '', '2011-05-26 00:00:00', '2011-05-26 09:51:43', 'basic/directory/directoryList.swf', null);
INSERT INTO `wlzx_system_module` VALUES ('34', '教师录入主模块', 'staff_input_main', '0', '', '2011-05-26 00:00:00', '2011-05-26 23:03:14', 'basic/staff/staffInput.swf', null);
INSERT INTO `wlzx_system_module` VALUES ('35', '调课申请主模块', 'adjust_class_apply_main', '0', '', '2011-05-27 00:00:00', '2011-05-27 22:36:32', 'oa/course/adjust/adjustApply.swf', null);
INSERT INTO `wlzx_system_module` VALUES ('36', '调课审批主模块', 'adjust_class_apply_approve_main', '0', '', '2011-05-27 00:00:00', '2011-09-04 14:46:16', 'oa/course/adjust/adjustApprove.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('37', '我的消息主模块', 'personal_message_main', '0', '', '2011-06-06 00:00:00', '2011-06-06 17:19:37', 'system/message/messageList.swf', null);
INSERT INTO `wlzx_system_module` VALUES ('38', '请假出差主模块', 'takeLeaveApply_main', '0', '', '2011-06-06 00:00:00', '2011-06-06 17:21:58', 'oa/attendance/takeLeaveApply.swf', null);
INSERT INTO `wlzx_system_module` VALUES ('39', '加班申请主模块', 'overWorkApply_main', '0', '', '2011-06-06 00:00:00', '2011-06-10 16:09:35', 'oa/attendance/overWorkApply.swf', null);
INSERT INTO `wlzx_system_module` VALUES ('40', '考勤统计主模块', 'selfCanculateAttendance_main', '0', '', '2011-06-06 00:00:00', '2011-06-10 21:22:21', 'oa/attendance/selfCanculateAttendance.swf', null);
INSERT INTO `wlzx_system_module` VALUES ('41', '请假出差审批主模块', 'takeLeaveApprove_main', '0', '', '2011-06-08 00:00:00', '2011-06-08 11:45:47', 'oa/attendance/takeLeaveApprove.swf', null);
INSERT INTO `wlzx_system_module` VALUES ('42', '调休申请主模块', 'moveRestDay_apply_main', '0', '', '2011-06-10 00:00:00', '2011-06-10 16:11:49', 'oa/attendance/moveRestDayApply.swf', null);
INSERT INTO `wlzx_system_module` VALUES ('43', '加班审批主模块', 'overWork_approve_main', '0', '', '2011-06-10 00:00:00', '2011-06-10 21:15:45', 'oa/attendance/overWorkApprove.swf', null);
INSERT INTO `wlzx_system_module` VALUES ('44', '调休审批主模块', 'moveRestDay_approve_main', '0', '', '2011-06-10 00:00:00', '2011-06-10 21:16:34', 'oa/attendance/moveRestDayApprove.swf', null);
INSERT INTO `wlzx_system_module` VALUES ('45', '员工考勤统计主模块', 'staffCanculateAttendance_main', '0', '', '2011-06-10 00:00:00', '2011-06-10 21:23:26', 'oa/attendance/canculateAttendance.swf', null);
INSERT INTO `wlzx_system_module` VALUES ('46', '公告发布主模块', 'person_notice_main', '0', '', '2011-06-16 00:00:00', '2011-07-15 17:10:51', 'oa/notice/personNotice.swf', 'list');
INSERT INTO `wlzx_system_module` VALUES ('47', '学校公告主模块', 'school_notice_read_main', '0', '', '2011-06-16 00:00:00', '2011-06-16 00:04:50', 'oa/notice/noticeList.swf', 'school');
INSERT INTO `wlzx_system_module` VALUES ('49', '我的工作主模块', 'person_office_workToDeal_main', '0', '', '2011-07-01 00:00:00', '2011-07-28 13:52:23', 'oa/task/waittingTask.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('50', '收文登记主模块', 'receipt_register_main', '0', '', '2011-07-02 00:00:00', '2011-07-02 12:21:05', 'oa/receipt/registerList.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('51', '收文拟办主模块', 'receipt_devise_main', '0', '', '2011-07-02 00:00:00', '2011-07-02 16:41:01', 'oa/receipt/deviseList.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('52', '收文批示主模块', 'receipt_ratify_main', '0', '', '2011-07-02 00:00:00', '2011-07-02 16:42:12', 'oa/receipt/ratifyList.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('53', '收文承办主模块', 'receipt_undertake_main', '0', '', '2011-07-02 00:00:00', '2011-07-02 16:43:22', 'oa/receipt/undertakeList.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('54', '收文传阅主模块', 'receipt_circulate_main', '0', '', '2011-07-02 00:00:00', '2011-07-02 16:44:14', 'oa/receipt/circulateList.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('55', '收文管理主模块', 'receipt_manage_main', '0', '', '2011-07-02 00:00:00', '2011-07-02 16:45:20', 'oa/receipt/manageList.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('56', '会议申请主模块', 'conferenceApply_main', '0', '', '2011-07-06 00:00:00', '2011-07-06 12:10:25', 'oa/conference/conferenceList.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('57', '会议室查看主模块', 'conferenceRoomCheck_main', '0', '', '2011-07-06 00:00:00', '2011-07-06 12:10:11', 'oa/conference/conferenceRoomCheck.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('58', '会议总结主模块', 'conferenceSummary_main', '0', '', '2011-07-06 00:00:00', '2011-07-06 12:09:24', 'oa/conference/conferenceSummary.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('59', '会议调整主模块', 'conferenceArrange_main', '0', '', '2011-07-06 00:00:00', '2011-07-07 10:43:58', 'oa/conference/conferenceArrange.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('61', '我参与的会议主模块', 'person_conferenceAttending_main', '0', '', '2011-07-06 00:00:00', '2011-07-06 12:15:47', 'oa/conference/conferenceSelfAttending.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('62', '系统设置主模块', 'system_oa_setting_main', '0', '', '2011-07-06 00:00:00', '2011-08-09 17:40:45', 'oa/setting/oaSetting.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('63', '发文拟稿主模块', 'documentDrafting_main', '0', '', '2011-07-22 00:00:00', '2011-07-22 16:40:11', 'oa/sendingFiles/documentDrafting.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('64', '发文核稿主模块', 'documentCheckDraft_main', '0', '', '2011-07-22 00:00:00', '2011-07-22 16:39:43', 'oa/sendingFiles/documentCheckDraft.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('65', '发文会签主模块', 'documentCountersign_main', '0', '', '2011-07-22 00:00:00', '2011-07-22 16:41:32', 'oa/sendingFiles/documentCountersign.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('66', '发文签发主模块', 'documentIssue_main', '0', '', '2011-07-22 00:00:00', '2011-07-22 16:42:27', 'oa/sendingFiles/documentIssue.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('67', '发文传阅主模块', 'documentCirculate_main', '0', '', '2011-07-22 00:00:00', '2011-07-22 16:43:19', 'oa/sendingFiles/documentCirculate.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('68', '发文管理主模块', 'documentManage_main', '0', '', '2011-07-22 00:00:00', '2011-07-22 16:43:57', 'oa/sendingFiles/documentManage.swf', '');
INSERT INTO `wlzx_system_module` VALUES ('69', '调课安排主模块', 'adjust_class_apply_arrange_main', '0', '', '2011-09-04 00:00:00', '2011-09-04 14:46:35', 'oa/course/adjust/adjustArrange.swf', '');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('8', '6', '8');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('9', '7', '9');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('12', '11', '12');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('13', '12', '13');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('15', '14', '15');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('16', '15', '16');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('19', '18', '19');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('20', '19', '20');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('21', '20', '21');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('22', '21', '22');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('24', '23', '24');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('25', '28', '25');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('27', '30', '27');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('28', '31', '28');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('31', '34', '31');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('32', '35', '32');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('33', '36', '33');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('34', '37', '34');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('35', '38', '35');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('36', '39', '36');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('37', '40', '37');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('38', '41', '38');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('39', '41', '39');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('40', '41', '40');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('41', '41', '41');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('42', '41', '42');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('43', '42', '43');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('44', '43', '44');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('45', '44', '45');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('46', '45', '46');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('47', '46', '47');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('48', '47', '48');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('50', '49', '50');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('57', '56', '57');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('58', '57', '58');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('59', '58', '59');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('60', '59', '60');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('62', '61', '62');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('63', '62', '63');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('64', '46', '64');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('65', '46', '65');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('66', '7', '66');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('67', '7', '67');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('68', '63', '68');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('69', '64', '69');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('70', '65', '70');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('71', '66', '71');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('72', '67', '72');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('73', '68', '73');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('74', '50', '51');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('75', '51', '52');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('76', '52', '53');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('77', '53', '54');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('78', '54', '55');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('79', '55', '56');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('82', '44', '76');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('83', '44', '77');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('85', '44', '79');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('86', '41', '80');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('87', '18', '81');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('88', '12', '82');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('89', '12', '83');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('90', '11', '84');
INSERT INTO `wlzx_system_module_operation_relationship` VALUES ('91', '69', '85');
INSERT INTO `wlzx_system_operation` VALUES ('8', '页面访问', 'department_notice_read_main@defaultVisit@', '0', 'URL', '/oa/notice/noticeList.swf*', null, '2011-05-09 00:00:00', '2011-06-16 00:05:21');
INSERT INTO `wlzx_system_operation` VALUES ('9', '页面访问', 'notice_list_main@defaultVisit@', '0', 'URL', '/oa/notice/noticeManage.swf*', null, '2011-05-09 00:00:00', '2011-06-15 21:51:54');
INSERT INTO `wlzx_system_operation` VALUES ('12', '页面访问', 'public_schedule_main@defaultVisit@', '0', 'URL', '/oa/schedule/publicSchedule.swf*', null, '2011-05-14 00:00:00', '2011-06-16 10:38:11');
INSERT INTO `wlzx_system_operation` VALUES ('13', '页面访问', 'person_schedule_main@defaultVisit@', '0', 'URL', '/oa/schedule/personSchedule.swf*', null, '2011-05-14 00:00:00', '2011-06-16 10:38:57');
INSERT INTO `wlzx_system_operation` VALUES ('15', '页面访问', 'staff_work_assign_main@defaultVisit@', '0', 'URL', '/oa/task/taskManager.swf*', null, '2011-05-14 00:00:00', '2011-06-16 10:47:07');
INSERT INTO `wlzx_system_operation` VALUES ('16', '页面访问', 'public_address_book_main@defaultVisit@', '0', 'URL', '/oa/communication/publicAddressBook.swf*', null, '2011-05-14 00:00:00', '2011-05-22 15:06:06');
INSERT INTO `wlzx_system_operation` VALUES ('19', '页面访问', 'staff_file_main@defaultVisit@', '0', 'URL', '/basic/staff/staffList.swf*', null, '2011-05-21 00:00:00', '2011-05-22 15:06:06');
INSERT INTO `wlzx_system_operation` VALUES ('20', '页面访问', 'system_account_main@defaultVisit@', '0', 'URL', '/basic/account/accountList.swf*', null, '2011-05-21 00:00:00', '2011-05-22 15:06:06');
INSERT INTO `wlzx_system_operation` VALUES ('21', '页面访问', 'oa_department_set_main@defaultVisit@', '0', 'URL', '/basic/setting/departmentSetting.swf*', null, '2011-05-21 00:00:00', '2011-05-22 15:06:06');
INSERT INTO `wlzx_system_operation` VALUES ('22', '页面访问', 'oa_role_set_main@defaultVisit@', '0', 'URL', '/basic/setting/roleSetting.swf*', null, '2011-05-21 00:00:00', '2011-05-22 15:06:06');
INSERT INTO `wlzx_system_operation` VALUES ('24', '页面访问', 'oa_role_authorization_main@defaultVisit@', '0', 'URL', '/basic/authorization/roleAuthorization.swf*', null, '2011-05-21 00:00:00', '2011-05-22 15:06:06');
INSERT INTO `wlzx_system_operation` VALUES ('25', '页面访问', 'oa_pw_change_main@defaultVisit@', '0', 'URL', '/basic/account/accountPw.swf*', null, '2011-05-23 00:00:00', '2011-05-23 23:11:11');
INSERT INTO `wlzx_system_operation` VALUES ('27', '页面访问', 'places_manage_main@defaultVisit@', '0', 'URL', '/basic/place/placeList.swf*', null, '2011-05-25 00:00:00', '2011-05-25 16:19:12');
INSERT INTO `wlzx_system_operation` VALUES ('28', '页面访问', 'basic_directory_main@defaultVisit@', '0', 'URL', '/basic/directory/directoryList.swf*', null, '2011-05-26 00:00:00', '2011-05-26 09:51:43');
INSERT INTO `wlzx_system_operation` VALUES ('30', '页面访问', '@defaultVisit@', '0', 'URL', '/basic/staff/staffInput.swf*', null, '2011-05-26 00:00:00', '2011-05-26 23:00:03');
INSERT INTO `wlzx_system_operation` VALUES ('31', '页面访问', 'staff_input_main@defaultVisit@', '0', 'URL', '/basic/staff/staffInput.swf*', null, '2011-05-26 00:00:00', '2011-05-26 23:03:14');
INSERT INTO `wlzx_system_operation` VALUES ('32', '页面访问', 'adjust_class_apply_main@defaultVisit@', '0', 'URL', '/oa/course/adjust/adjustApply.swf*', null, '2011-05-27 00:00:00', '2011-05-27 22:36:32');
INSERT INTO `wlzx_system_operation` VALUES ('33', '页面访问', 'adjust_class_apply_approve_main@defaultVisit@', '0', 'URL', '/oa/course/adjust/adjustApprove.swf*', null, '2011-05-27 00:00:00', '2011-09-04 14:46:16');
INSERT INTO `wlzx_system_operation` VALUES ('34', '页面访问', 'personal_message_main@defaultVisit@', '0', 'URL', '/system/message/messageList.swf*', null, '2011-06-06 00:00:00', '2011-06-06 17:19:37');
INSERT INTO `wlzx_system_operation` VALUES ('35', '页面访问', 'takeLeaveApply_main@defaultVisit@', '0', 'URL', '/oa/attendance/takeLeaveApply.swf*', null, '2011-06-06 00:00:00', '2011-06-06 17:21:58');
INSERT INTO `wlzx_system_operation` VALUES ('36', '页面访问', 'overWorkApply_main@defaultVisit@', '0', 'URL', '/oa/attendance/overWorkApply.swf*', null, '2011-06-06 00:00:00', '2011-06-10 16:09:35');
INSERT INTO `wlzx_system_operation` VALUES ('37', '页面访问', 'selfCanculateAttendance_main@defaultVisit@', '0', 'URL', '/oa/attendance/selfCanculateAttendance.swf*', null, '2011-06-06 00:00:00', '2011-06-10 21:22:21');
INSERT INTO `wlzx_system_operation` VALUES ('38', '页面访问', 'takeLeaveApprove_main@defaultVisit@', '0', 'URL', '/oa/attendance/takeLeaveApprove.swf*', null, '2011-06-08 00:00:00', '2011-06-08 11:45:47');
INSERT INTO `wlzx_system_operation` VALUES ('39', '请假出差工作落实', 'takeLeaveWorkDeal', '1', 'METHOD', 'takeLeaveWorkDeal()', '', '2011-06-08 00:00:00', '2011-07-27 14:38:57');
INSERT INTO `wlzx_system_operation` VALUES ('40', '分管下属请假出差1天以内[含1天]审批权限', 'takeLeaveOfficeApprove', '2', 'METHOD', 'takeLeaveOfficeApprove()', '', '2011-06-08 00:00:00', '2011-07-27 14:39:03');
INSERT INTO `wlzx_system_operation` VALUES ('41', '分管下属请假出差3天以内[含3天]审批权限', 'takeLeaveVicePrincipalApprove', '3', 'METHOD', 'takeLeaveVicePrincipalApprove()', '', '2011-06-08 00:00:00', '2011-07-27 14:39:08');
INSERT INTO `wlzx_system_operation` VALUES ('42', '所有审批权限', 'takeLeavePrincipalApprove', '5', 'METHOD', 'takeLeavePrincipalApprove()', '', '2011-06-08 00:00:00', '2011-07-27 14:39:15');
INSERT INTO `wlzx_system_operation` VALUES ('43', '页面访问', 'moveRestDay_apply_main@defaultVisit@', '0', 'URL', '/oa/attendance/moveRestDay.swf*', null, '2011-06-10 00:00:00', '2011-06-10 16:11:49');
INSERT INTO `wlzx_system_operation` VALUES ('44', '页面访问', 'overWork_approve_main@defaultVisit@', '0', 'URL', '/oa/attendance/overWorkApprove.swf*', null, '2011-06-10 00:00:00', '2011-06-10 21:15:45');
INSERT INTO `wlzx_system_operation` VALUES ('45', '页面访问', 'moveRestDay_approve_main@defaultVisit@', '0', 'URL', '/oa/attendance/moveRestDayApprove.swf*', null, '2011-06-10 00:00:00', '2011-06-10 21:16:34');
INSERT INTO `wlzx_system_operation` VALUES ('46', '页面访问', 'staffCanculateAttendance_main@defaultVisit@', '0', 'URL', '/oa/attendance/canculateAttendance.swf*', null, '2011-06-10 00:00:00', '2011-06-10 21:23:26');
INSERT INTO `wlzx_system_operation` VALUES ('47', '页面访问', 'person_notice_main@defaultVisit@', '0', 'URL', '/oa/notice/personNotice.swf*', null, '2011-06-16 00:00:00', '2011-07-15 17:10:51');
INSERT INTO `wlzx_system_operation` VALUES ('48', '页面访问', 'school_notice_read_main@defaultVisit@', '0', 'URL', '/oa/notice/noticeList.swf*', null, '2011-06-16 00:00:00', '2011-06-16 00:04:50');
INSERT INTO `wlzx_system_operation` VALUES ('50', '页面访问', 'person_office_workToDeal_main@defaultVisit@', '0', 'URL', '/oa/task/waittingTask.swf*', null, '2011-07-01 00:00:00', '2011-07-28 13:52:23');
INSERT INTO `wlzx_system_operation` VALUES ('51', '页面访问', 'receipt_register_main@defaultVisit@', '0', 'URL', '/oa/receipt/registerList.swf*', null, '2011-07-02 00:00:00', '2011-07-02 12:21:05');
INSERT INTO `wlzx_system_operation` VALUES ('52', '页面访问', 'receipt_devise_main@defaultVisit@', '0', 'URL', '/oa/receipt/deviseList.swf*', null, '2011-07-02 00:00:00', '2011-07-02 16:41:01');
INSERT INTO `wlzx_system_operation` VALUES ('53', '页面访问', 'receipt_ratify_main@defaultVisit@', '0', 'URL', '/oa/receipt/ratifyList.swf*', null, '2011-07-02 00:00:00', '2011-07-02 16:42:12');
INSERT INTO `wlzx_system_operation` VALUES ('54', '页面访问', 'receipt_undertake_main@defaultVisit@', '0', 'URL', '/oa/receipt/undertakeList.swf*', null, '2011-07-02 00:00:00', '2011-07-02 16:43:22');
INSERT INTO `wlzx_system_operation` VALUES ('55', '页面访问', 'receipt_circulate_main@defaultVisit@', '0', 'URL', '/oa/receipt/circulateList.swf*', null, '2011-07-02 00:00:00', '2011-07-02 16:44:14');
INSERT INTO `wlzx_system_operation` VALUES ('56', '页面访问', 'receipt_manage_main@defaultVisit@', '0', 'URL', '/oa/receipt/manageList.swf*', null, '2011-07-02 00:00:00', '2011-07-02 16:45:20');
INSERT INTO `wlzx_system_operation` VALUES ('57', '页面访问', 'conferenceApply_main@defaultVisit@', '0', 'URL', '/oa/conference/conferenceList.swf*', null, '2011-07-06 00:00:00', '2011-07-06 12:10:25');
INSERT INTO `wlzx_system_operation` VALUES ('58', '页面访问', 'conferenceRoomCheck_main@defaultVisit@', '0', 'URL', '/oa/conference/conferenceRoomCheck.swf*', null, '2011-07-06 00:00:00', '2011-07-06 12:10:11');
INSERT INTO `wlzx_system_operation` VALUES ('59', '页面访问', 'conferenceSummary_main@defaultVisit@', '0', 'URL', '/oa/conference/conferenceSummary.swf*', null, '2011-07-06 00:00:00', '2011-07-06 12:09:24');
INSERT INTO `wlzx_system_operation` VALUES ('60', '页面访问', 'conferenceArrange_main@defaultVisit@', '0', 'URL', '/oa/conference/conferenceArrange.swf*', null, '2011-07-06 00:00:00', '2011-07-07 10:43:58');
INSERT INTO `wlzx_system_operation` VALUES ('62', '页面访问', 'person_conferenceAttending_main@defaultVisit@', '0', 'URL', '/oa/conference/conferenceSelfAttending.swf*', null, '2011-07-06 00:00:00', '2011-07-06 12:15:47');
INSERT INTO `wlzx_system_operation` VALUES ('63', '页面访问', 'system_oa_setting_main@defaultVisit@', '0', 'URL', '/oa/setting/oaSetting.swf*', null, '2011-07-06 00:00:00', '2011-08-09 17:41:30');
INSERT INTO `wlzx_system_operation` VALUES ('64', '发布本部门校级公告', 'postSelfDepartmentSchoolScopeNotice', '1', 'METHOD', 'addNotice()', '', '2011-07-22 00:00:00', '2011-07-22 10:53:14');
INSERT INTO `wlzx_system_operation` VALUES ('65', '发布任意公告', 'postAnyNotice', '1', 'METHOD', 'addNotice()', '', '2011-07-22 00:00:00', '2011-07-22 10:53:14');
INSERT INTO `wlzx_system_operation` VALUES ('66', '编辑删除本部门校级公告', 'editSelfDepartmentSchoolScopeNotice', '0', 'METHOD', 'updateNotice()', '', '2011-07-22 00:00:00', '2011-07-22 10:51:44');
INSERT INTO `wlzx_system_operation` VALUES ('67', '编辑删除所有公告', 'editAnyNotice', '0', 'METHOD', 'updateNotice()', '', '2011-07-22 00:00:00', '2011-07-22 10:52:51');
INSERT INTO `wlzx_system_operation` VALUES ('68', '页面访问', 'documentDrafting_main@defaultVisit@', '0', 'URL', '/oa/sendingFiles/documentDrafting.swf*', null, '2011-07-22 00:00:00', '2011-07-22 16:40:11');
INSERT INTO `wlzx_system_operation` VALUES ('69', '页面访问', 'documentCheckDraft_main@defaultVisit@', '0', 'URL', '/oa/sendingFiles/documentCheckDraft.swf*', null, '2011-07-22 00:00:00', '2011-07-22 16:39:43');
INSERT INTO `wlzx_system_operation` VALUES ('70', '页面访问', 'documentCountersign_main@defaultVisit@', '0', 'URL', '/oa/sendingFiles/documentCountersign.swf*', null, '2011-07-22 00:00:00', '2011-07-22 16:41:32');
INSERT INTO `wlzx_system_operation` VALUES ('71', '页面访问', 'documentIssue_main@defaultVisit@', '0', 'URL', '/oa/sendingFiles/documentIssue.swf*', null, '2011-07-22 00:00:00', '2011-07-22 16:42:27');
INSERT INTO `wlzx_system_operation` VALUES ('72', '页面访问', 'documentCirculate_main@defaultVisit@', '0', 'URL', '/oa/sendingFiles/documentCirculate.swf*', null, '2011-07-22 00:00:00', '2011-07-22 16:43:19');
INSERT INTO `wlzx_system_operation` VALUES ('73', '页面访问', 'documentManage_main@defaultVisit@', '0', 'URL', '/oa/sendingFiles/documentManage.swf*', null, '2011-07-22 00:00:00', '2011-07-22 16:43:57');
INSERT INTO `wlzx_system_operation` VALUES ('76', '分管下属调休1天以内[含1天]审批权限', 'moveRestDayOfficeApprove', '1', 'METHOD', 'moveRestDayOfficeApprove()', '', '2011-07-26 00:00:00', '2011-07-27 09:37:43');
INSERT INTO `wlzx_system_operation` VALUES ('77', '分管下属调休1天以上审批权限', 'moveRestDayVicePrincipalApprove', '2', 'METHOD', 'moveRestDayVicePrincipalApprove()', '', '2011-07-26 00:00:00', '2011-07-27 09:37:28');
INSERT INTO `wlzx_system_operation` VALUES ('79', '所有审批权限', 'moveRestDayAllApprove', '3', 'METHOD', 'moveRestDayAllApprove()', '', '2011-07-26 00:00:00', '2011-07-27 09:37:57');
INSERT INTO `wlzx_system_operation` VALUES ('80', '销假审批权限', 'takeLeaveTerminateApprove', '4', 'METHOD', 'takeLeaveTerminateApprove()', '', '2011-07-27 00:00:00', '2011-07-27 14:40:59');
INSERT INTO `wlzx_system_operation` VALUES ('81', '教师信息修改_转正、离职、退休、删除操作', 'staff_edit_delete_so_on', '0', 'METHOD', 'staffEdit()', '', '2011-07-28 00:00:00', '2011-07-28 17:47:33');
INSERT INTO `wlzx_system_operation` VALUES ('82', '共享为学校日程权限', 'canShareInSchool', '2', 'METHOD', 'canShareInSchool()', '', '2011-07-29 00:00:00', '2011-07-29 10:03:17');
INSERT INTO `wlzx_system_operation` VALUES ('83', '共享为部门日程权限', 'canShareInDepartment', '1', 'METHOD', 'canShareInDepartment()', '', '2011-07-29 00:00:00', '2011-07-29 10:03:44');
INSERT INTO `wlzx_system_operation` VALUES ('84', '公共日程修改删除', 'publicScheduleEditAndDelete', '1', 'METHOD', 'publicScheduleEditAndDelete()', '', '2011-07-29 00:00:00', '2011-07-29 10:34:37');
INSERT INTO `wlzx_system_operation` VALUES ('85', '页面访问', 'adjust_class_apply_arrange_main@defaultVisit@', '0', 'URL', '/oa/course/adjust/adjustArrange.swf*', null, '2011-09-04 00:00:00', '2011-09-04 14:46:35');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('8', '8', '8');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('9', '9', '9');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('12', '12', '12');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('13', '13', '13');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('15', '15', '15');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('16', '16', '16');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('19', '19', '19');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('20', '20', '20');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('21', '21', '21');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('22', '22', '22');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('24', '24', '24');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('25', '25', '25');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('27', '27', '27');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('28', '28', '28');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('30', '30', '30');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('31', '31', '31');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('32', '32', '32');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('33', '33', '33');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('34', '34', '34');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('35', '35', '35');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('36', '36', '36');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('37', '37', '37');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('38', '38', '38');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('39', '39', '39');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('40', '40', '40');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('41', '41', '41');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('42', '42', '42');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('43', '38', '43');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('44', '38', '44');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('45', '43', '45');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('46', '44', '46');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('47', '45', '47');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('48', '46', '48');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('49', '47', '49');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('50', '48', '50');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('52', '50', '52');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('53', '51', '53');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('54', '52', '54');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('55', '53', '55');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('56', '54', '56');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('57', '55', '57');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('58', '56', '58');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('59', '57', '59');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('60', '58', '60');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('61', '59', '61');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('62', '60', '62');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('64', '62', '64');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('65', '63', '65');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('66', '64', '66');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('68', '65', '68');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('70', '66', '70');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('71', '67', '71');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('72', '68', '72');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('73', '69', '73');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('74', '70', '74');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('75', '71', '75');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('76', '72', '76');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('77', '73', '77');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('80', '76', '80');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('81', '77', '81');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('83', '79', '83');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('84', '80', '84');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('85', '8', '85');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('86', '81', '86');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('87', '82', '87');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('88', '83', '88');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('89', '12', '89');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('90', '12', '90');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('91', '84', '91');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('92', '44', '92');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('93', '45', '93');
INSERT INTO `wlzx_system_operation_dam_relationship` VALUES ('94', '85', '94');
INSERT INTO `wlzx_system_role` VALUES ('1', 'root_supervisor', '0', '校长', '1', '', '2011-05-06 00:00:00', '2011-08-30 19:29:22', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('2', 'basic_role', '0', '普通用户', '1', '', '2011-05-06 00:00:00', '2011-07-05 12:11:13', '0', '1');
INSERT INTO `wlzx_system_role` VALUES ('3', 'moral_education_office_supervisor', '0', '德育处处长', '3', '', '2011-05-10 00:00:00', '2011-08-30 20:22:11', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('6', 'headmaster_office_supervisor', '0', '校长办公室主任', '3', '', '2011-05-18 00:00:00', '2011-09-04 13:57:34', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('16', 'practice_education_office_supervisor', '0', '综践处处长', '3', '', '2011-05-19 00:00:00', '2011-08-30 20:37:51', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('17', 'resources_office_supervisor', '0', '资源处主任', '3', '', '2011-05-19 00:00:00', '2011-08-30 16:09:15', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('18', 'executive_vice_president', '4', '行政副校长', '2', '', '2011-05-19 00:00:00', '2011-08-30 19:28:04', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('19', 'moral_education_vice_president', '2', '德育副校长', '2', '', '2011-05-19 00:00:00', '2011-07-25 15:43:32', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('20', 'teaching_vice_president', '1', '教学副校长', '2', '', '2011-05-19 00:00:00', '2011-08-30 19:24:39', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('21', 'logistical_vice_president', '3', '后勤副校长', '2', '', '2011-05-19 00:00:00', '2011-08-30 19:27:50', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('22', 'course_office_supervisor', '0', '课程处处长', '3', '', '2011-05-20 00:00:00', '2011-08-30 20:28:07', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('23', 'course_yuwen_supervisor', '0', '语文组组长', '4', '', '2011-07-04 00:00:00', '2011-08-30 20:32:01', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('24', 'course_yingyu_supervisor', '0', '英语组组长', '4', '', '2011-07-04 00:00:00', '2011-08-30 20:33:34', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('25', 'course_shuxue_supervisor', '0', '数学组组长', '4', '', '2011-07-04 00:00:00', '2011-08-30 20:33:42', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('26', 'course_wuli_supervisor', '0', '物理组组长', '4', '', '2011-07-04 00:00:00', '2011-08-30 20:33:51', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('27', 'course_huaxue_supervisor', '0', '化学组组长', '4', '', '2011-07-04 00:00:00', '2011-08-30 20:33:59', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('28', 'course_shengwu_supervisor', '0', '生物组组长', '4', '', '2011-07-04 00:00:00', '2011-08-30 20:34:08', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('29', 'course_zhengzhi_supervisor', '0', '政治组组长', '4', '', '2011-07-04 00:00:00', '2011-08-30 20:34:16', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('30', 'course_lishi_supervisor', '0', '历史组组长', '4', '', '2011-07-04 00:00:00', '2011-08-30 20:34:24', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('31', 'course_dili_supervisor', '0', '地理组组长', '4', '', '2011-07-04 00:00:00', '2011-08-30 20:34:31', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('32', 'wenshu_office_supervisor', '0', '文书', '5', '', '2011-07-04 00:00:00', '2011-08-30 19:32:26', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('33', 'xuanchuan_office_supervisor', '0', '宣传科科长', '4', '', '2011-07-04 00:00:00', '2011-08-30 19:31:54', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('34', 'dudao_office_supervisor', '0', '督导科科长', '4', '', '2011-07-04 00:00:00', '2011-08-30 19:31:43', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('35', 'dangan_office_supervisor', '0', '档案员', '5', '', '2011-07-04 00:00:00', '2011-08-30 19:32:15', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('36', 'students_office_supervisor', '0', '学生科科长', '4', '', '2011-07-04 00:00:00', '2011-08-30 20:24:23', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('37', 'anbao_office_supervisor', '0', '安保科科长', '4', '', '2011-07-04 00:00:00', '2011-08-30 17:04:56', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('38', 'hospital_office_supervisor', '0', '医务室主管', '4', '', '2011-07-04 00:00:00', '2011-08-30 20:26:28', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('39', 'xinli_office_supervisor', '0', '心理室主管', '4', '', '2011-07-04 00:00:00', '2011-08-30 20:26:53', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('43', 'tiyu_office_supervisor', '0', '体育组主管', '4', '', '2011-07-04 00:00:00', '2011-08-30 20:41:54', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('44', 'information_office_supervisor', '0', '信息组主管', '4', '', '2011-07-04 00:00:00', '2011-08-30 20:42:02', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('45', 'laoyi_office_supervisor', '0', '劳艺组组长', '4', '', '2011-07-04 00:00:00', '2011-08-30 20:41:39', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('46', 'liberary_office_supervisor', '0', '图书馆主管', '4', '', '2011-07-04 00:00:00', '2011-08-30 20:41:47', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('47', 'network_center_supervisor', '0', '网络中心主管', '4', '', '2011-07-04 00:00:00', '2011-08-30 20:42:09', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('48', 'television_center_supervisor', '0', '电视台主管', '4', '', '2011-07-04 00:00:00', '2011-08-30 20:42:17', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('49', 'zongwu_office_supervisor', '0', '总务科科长', '4', '', '2011-07-04 00:00:00', '2011-09-04 16:33:15', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('50', 'caiwu_office_supervisor', '0', '财务科科长', '4', '', '2011-07-04 00:00:00', '2011-08-30 20:46:56', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('51', 'weixiu_office_supervisor', '0', '维修科科长', '4', '', '2011-07-04 00:00:00', '2011-08-30 17:09:07', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('52', 'shanshi_office_supervisor', '0', '膳食科科长', '4', '', '2011-07-04 00:00:00', '2011-09-04 14:47:03', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('53', 'jiaowu_office_supervisor', '0', '教务科科长', '4', '', '2011-07-04 00:00:00', '2011-08-30 20:31:20', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('58', 'headmaster_office_vice_superviser', '0', '校长办公室副主任', '4', '', '2011-07-05 00:00:00', '2011-09-04 13:57:53', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('59', 'moral_education_office_vice_supervisor', '0', '德育处副处长', '4', '', '2011-07-05 00:00:00', '2011-08-30 20:22:22', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('60', 'courses_office_vice_supervisor', '0', '课程处副处长', '4', '', '2011-07-05 00:00:00', '2011-08-30 20:29:19', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('61', 'practice_education_office_vise_supervisor', '0', '综践处副处长', '4', '', '2011-07-05 00:00:00', '2011-08-30 20:38:04', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('62', 'resources_office_vise_supervisor', '0', '资源处副主任', '4', '', '2011-07-05 00:00:00', '2011-09-04 16:32:44', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('65', 'party_secretary', '0', '党总支书记', '1', '', '2011-07-01 00:00:00', '2011-08-30 19:29:05', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('66', 'party_deputy_secretary', '0', '党总支副书记', '2', '', '2011-07-01 00:00:00', '2011-09-04 13:48:45', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('69', 'labor_union_supervisor', '0', '工会主席', '2', '', '2011-07-01 00:00:00', '2011-07-25 16:07:02', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('70', 'Class_arrangement', '0', '课务安排', '5', '', '2011-07-01 00:00:00', '2011-08-30 20:30:14', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('71', 'grade_1_committee_supervisor', '0', '高一年级段段长', '3', '', '2011-08-01 00:00:00', '2011-08-30 23:19:04', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('72', 'grade_2_committee_supervisor', '0', '高二年级段段长', '3', '', '2011-08-01 00:00:00', '2011-08-30 23:19:17', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('73', 'grade_3_committee_supervisor', '0', '高三年级段段长', '3', '', '2011-08-01 00:00:00', '2011-08-30 23:19:27', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('75', '-', '8', '--', '3', '', '2011-09-04 00:00:00', '2011-09-04 15:32:57', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('77', 'keyuan_1', '0', '科员', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:25:54', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('78', 'keyuan_2', '0', '科员', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:26:30', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('79', 'keyuan_3', '0', '科员', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:26:58', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('80', 'keyuan_4', '0', '科员', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:27:33', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('81', 'keyuan_5', '0', '科员', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:27:57', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('82', 'keyuan_6', '0', '科员', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:28:37', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('83', 'yisheng', '0', '医生', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:32:33', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('84', 'yisheng_2', '0', '医生', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:33:32', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('85', 'keyuan_7', '0', '科员', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:34:16', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('86', 'keyuan_8', '0', '科员', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:34:35', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('87', 'teacher_1', '0', '教师', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:38:09', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('88', 'teacher_2', '0', '教师', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:37:46', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('89', 'teacher_3', '0', '教师', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:37:28', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('90', 'teacher_4', '0', '教师', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:38:38', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('91', 'teacher_5', '0', '教师', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:38:59', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('92', 'teacher_6', '0', '教师', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:39:22', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('93', 'teacher_7', '0', '教师', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:39:51', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('94', 'teacher_8', '0', '教师', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:40:15', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('95', 'teacher_9', '0', '教师', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:40:49', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('96', 'keyuan_9', '0', '科员', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:41:58', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('97', 'teacher_10', '0', '教师', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:42:30', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('98', 'teacher_11', '0', '科员', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:42:55', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('99', 'teacher_12', '0', '教师', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:43:13', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('100', 'teacher_13', '0', '教师', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:43:34', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('101', 'teacher_15', '0', '教师', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:43:52', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('102', 'teacher_16', '0', '教师', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:44:10', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('103', 'keyuan_10', '0', '科员', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:44:51', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('104', 'keyuan_11', '0', '科员', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:45:22', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('105', 'keyuan_13', '0', '科员', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:45:47', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('106', 'keyuan_14', '0', '科员', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:45:51', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('107', 'keyuan_15', '0', '科员', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:46:19', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('108', 'keyuan_16', '0', '科员', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:46:45', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('109', 'keyuan_17', '0', '科员', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:47:40', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('110', 'teacher_17', '0', '教师', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:48:23', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('111', 'teacher_18', '0', '教师', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:48:43', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('112', 'teacher_19', '0', '教师', '5', '', '2011-09-01 00:00:00', '2011-09-04 14:49:03', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('113', 'gonghui_chairman', '7', '工会主席', '2', '', '2011-09-01 00:00:00', '2011-09-05 08:00:34', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('114', 'tongji_group_supervisor', '0', '通技组组长', '4', '', '2011-09-01 00:00:00', '2011-09-05 09:52:46', '1', '0');
INSERT INTO `wlzx_system_role` VALUES ('115', 'teacher_tongji', '0', '教师', '5', '', '2011-09-01 00:00:00', '2011-09-05 08:32:04', '0', '0');
INSERT INTO `wlzx_system_role` VALUES ('116', 'tuanwei_sj', '0', '团委书记', '4', '', '2011-09-01 00:00:00', '2011-09-05 08:42:44', '0', '0');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('4', '1', '24');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('12', '1', '20');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('25', '1', '19');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('27', '1', '25');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('34', '1', '21');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('35', '1', '22');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('57', '1', '15');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('58', '1', '16');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('59', '1', '13');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('66', '1', '9');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('68', '1', '28');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('70', '1', '27');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('71', '1', '33');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('72', '1', '32');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('73', '1', '35');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('74', '1', '36');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('75', '1', '34');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('76', '1', '37');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('77', '1', '39');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('78', '1', '38');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('82', '1', '43');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('83', '1', '42');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('84', '1', '45');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('85', '1', '44');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('86', '1', '47');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('87', '1', '46');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('88', '1', '48');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('89', '1', '49');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('90', '1', '50');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('92', '1', '52');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('93', '3', '45');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('94', '3', '35');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('95', '3', '36');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('96', '3', '34');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('97', '3', '16');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('98', '3', '25');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('99', '3', '13');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('101', '3', '37');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('103', '3', '32');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('105', '3', '52');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('106', '23', '45');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('107', '23', '35');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('108', '23', '36');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('109', '23', '15');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('110', '23', '25');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('111', '23', '16');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('112', '23', '34');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('113', '23', '13');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('115', '23', '37');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('117', '23', '12');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('118', '23', '32');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('120', '23', '52');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('121', '23', '8');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('122', '23', '50');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('123', '24', '45');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('124', '24', '35');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('125', '24', '36');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('126', '24', '15');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('127', '24', '25');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('128', '24', '16');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('129', '24', '34');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('130', '24', '13');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('132', '24', '37');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('134', '24', '12');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('135', '24', '32');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('137', '24', '52');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('138', '24', '8');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('139', '24', '50');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('140', '25', '45');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('141', '25', '35');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('142', '25', '36');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('143', '25', '15');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('144', '25', '25');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('145', '25', '16');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('146', '25', '34');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('147', '25', '13');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('149', '25', '37');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('151', '25', '12');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('152', '25', '32');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('154', '25', '52');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('155', '25', '8');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('156', '25', '50');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('157', '26', '45');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('158', '26', '32');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('160', '26', '35');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('161', '26', '52');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('162', '26', '36');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('163', '26', '34');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('164', '26', '8');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('165', '26', '25');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('166', '26', '37');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('167', '26', '50');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('179', '34', '19');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('180', '34', '35');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('181', '34', '36');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('183', '34', '15');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('184', '34', '16');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('185', '34', '34');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('186', '34', '13');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('190', '34', '37');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('193', '34', '21');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('194', '34', '20');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('199', '34', '49');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('200', '34', '48');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('201', '34', '45');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('205', '34', '22');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('206', '34', '24');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('207', '34', '25');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('208', '34', '27');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('209', '34', '28');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('211', '34', '32');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('212', '34', '31');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('214', '34', '52');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('215', '34', '9');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('217', '34', '50');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('218', '2', '45');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('219', '2', '32');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('221', '2', '35');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('222', '2', '52');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('223', '2', '36');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('224', '2', '34');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('226', '2', '25');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('227', '2', '37');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('228', '2', '50');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('229', '1', '59');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('230', '1', '64');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('231', '1', '65');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('232', '1', '62');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('234', '1', '60');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('235', '1', '61');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('236', '1', '66');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('237', '1', '58');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('238', '1', '57');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('239', '1', '56');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('240', '1', '55');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('241', '1', '53');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('242', '1', '54');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('243', '20', '59');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('244', '20', '57');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('245', '20', '56');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('246', '20', '19');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('247', '20', '55');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('248', '20', '35');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('249', '20', '36');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('250', '20', '15');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('251', '20', '34');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('252', '20', '16');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('253', '20', '13');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('255', '20', '37');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('258', '20', '41');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('259', '20', '64');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('262', '20', '60');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('263', '20', '61');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('264', '20', '49');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('266', '20', '66');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('268', '20', '45');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('269', '20', '44');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('272', '20', '25');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('273', '20', '32');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('275', '20', '70');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('276', '20', '52');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('278', '20', '9');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('280', '20', '54');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('281', '20', '50');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('282', '22', '59');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('283', '22', '57');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('284', '22', '56');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('285', '22', '55');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('286', '22', '35');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('287', '22', '36');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('288', '22', '33');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('289', '22', '15');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('290', '22', '16');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('291', '22', '34');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('292', '22', '13');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('293', '22', '39');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('295', '22', '37');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('298', '22', '43');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('299', '22', '40');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('300', '22', '64');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('302', '22', '60');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('303', '22', '61');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('304', '22', '49');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('305', '22', '48');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('306', '22', '66');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('307', '22', '45');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('310', '22', '25');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('311', '22', '32');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('313', '22', '70');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('314', '22', '52');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('315', '22', '9');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('317', '22', '54');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('318', '22', '50');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('319', '18', '59');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('320', '18', '57');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('321', '18', '56');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('322', '18', '55');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('323', '18', '35');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('324', '18', '36');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('325', '18', '15');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('327', '18', '16');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('328', '18', '34');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('329', '18', '13');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('331', '18', '37');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('334', '18', '41');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('335', '18', '64');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('337', '18', '60');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('338', '18', '61');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('339', '18', '49');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('341', '18', '66');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('343', '18', '45');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('344', '18', '44');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('345', '18', '47');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('346', '18', '46');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('347', '18', '25');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('348', '18', '32');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('350', '18', '70');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('351', '18', '52');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('352', '18', '9');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('354', '18', '54');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('355', '18', '50');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('356', '1', '85');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('357', '1', '8');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('359', '1', '87');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('360', '1', '90');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('361', '1', '88');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('362', '1', '77');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('363', '1', '41');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('364', '1', '40');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('365', '1', '83');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('366', '1', '80');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('367', '1', '81');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('368', '1', '86');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('369', '1', '84');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('370', '1', '68');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('371', '1', '31');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('372', '1', '70');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('373', '1', '71');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('374', '1', '72');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('375', '1', '73');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('376', '1', '74');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('377', '1', '75');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('378', '1', '76');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('379', '1', '12');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('380', '1', '91');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('381', '1', '89');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('385', '20', '73');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('386', '20', '74');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('387', '20', '75');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('388', '20', '76');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('389', '34', '66');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('390', '34', '68');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('391', '34', '87');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('392', '34', '88');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('393', '2', '57');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('394', '2', '90');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('395', '2', '16');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('396', '2', '13');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('397', '2', '64');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('398', '2', '89');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('399', '2', '85');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('400', '2', '76');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('401', '1', '93');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('402', '1', '92');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('403', '18', '19');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('404', '18', '81');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('405', '18', '87');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('406', '18', '85');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('407', '18', '91');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('408', '18', '90');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('409', '18', '73');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('410', '18', '74');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('411', '18', '88');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('412', '18', '75');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('413', '18', '89');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('414', '18', '76');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('415', '18', '22');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('416', '18', '24');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('417', '18', '27');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('418', '18', '21');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('419', '18', '48');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('420', '19', '59');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('421', '19', '57');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('422', '19', '56');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('423', '19', '19');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('424', '19', '55');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('425', '19', '35');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('426', '19', '36');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('427', '19', '15');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('428', '19', '34');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('429', '19', '16');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('430', '19', '13');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('431', '19', '37');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('432', '19', '41');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('433', '19', '64');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('434', '19', '81');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('435', '19', '60');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('436', '19', '61');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('437', '19', '87');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('438', '19', '85');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('439', '19', '49');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('440', '19', '66');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('441', '19', '45');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('442', '19', '93');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('443', '19', '44');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('444', '19', '92');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('445', '19', '91');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('446', '19', '90');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('447', '19', '25');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('448', '19', '32');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('449', '19', '70');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('450', '19', '52');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('451', '19', '9');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('452', '19', '54');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('453', '19', '73');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('454', '19', '74');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('455', '19', '88');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('456', '19', '75');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('457', '19', '50');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('458', '19', '89');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('459', '19', '76');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('460', '20', '33');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('461', '20', '81');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('462', '20', '87');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('463', '20', '85');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('464', '20', '93');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('465', '20', '92');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('466', '20', '91');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('467', '20', '90');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('468', '20', '88');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('469', '20', '89');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('470', '21', '59');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('471', '21', '57');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('472', '21', '56');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('473', '21', '19');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('474', '21', '55');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('475', '21', '35');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('476', '21', '36');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('477', '21', '15');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('478', '21', '34');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('479', '21', '16');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('480', '21', '13');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('481', '21', '37');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('482', '21', '41');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('483', '21', '64');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('484', '21', '81');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('485', '21', '60');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('486', '21', '61');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('487', '21', '87');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('488', '21', '85');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('489', '21', '49');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('490', '21', '66');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('491', '21', '45');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('492', '21', '93');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('493', '21', '44');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('494', '21', '92');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('495', '21', '91');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('496', '21', '90');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('497', '21', '25');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('498', '21', '32');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('499', '21', '70');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('500', '21', '52');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('501', '21', '9');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('502', '21', '54');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('503', '21', '73');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('504', '21', '74');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('505', '21', '88');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('506', '21', '75');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('507', '21', '50');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('508', '21', '89');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('509', '21', '76');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('510', '3', '59');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('511', '3', '57');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('512', '3', '56');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('513', '3', '55');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('514', '3', '15');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('515', '3', '43');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('516', '3', '40');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('517', '3', '64');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('518', '3', '80');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('519', '3', '60');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('520', '3', '61');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('521', '3', '87');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('522', '3', '84');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('523', '3', '85');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('524', '3', '49');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('525', '3', '66');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('526', '3', '93');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('527', '3', '92');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('528', '3', '91');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('529', '3', '90');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('530', '3', '70');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('531', '3', '9');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('532', '3', '54');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('533', '3', '73');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('534', '3', '74');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('535', '3', '88');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('536', '3', '75');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('537', '3', '50');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('538', '3', '89');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('539', '3', '76');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('540', '6', '59');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('541', '6', '57');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('542', '6', '56');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('543', '6', '19');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('544', '6', '55');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('545', '6', '35');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('546', '6', '36');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('547', '6', '15');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('548', '6', '34');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('549', '6', '16');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('550', '6', '13');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('551', '6', '37');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('552', '6', '43');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('553', '6', '40');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('554', '6', '64');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('555', '6', '80');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('556', '6', '60');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('557', '6', '61');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('558', '6', '87');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('559', '6', '84');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('560', '6', '85');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('561', '6', '49');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('562', '6', '48');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('563', '6', '66');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('564', '6', '45');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('565', '6', '93');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('566', '6', '92');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('567', '6', '91');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('568', '6', '90');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('569', '6', '25');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('570', '6', '32');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('571', '6', '70');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('572', '6', '52');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('573', '6', '53');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('574', '6', '9');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('575', '6', '54');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('576', '6', '72');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('577', '6', '73');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('578', '6', '74');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('579', '6', '88');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('580', '6', '75');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('581', '6', '50');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('582', '6', '89');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('583', '6', '76');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('584', '16', '59');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('585', '16', '57');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('586', '16', '56');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('587', '16', '55');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('588', '16', '35');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('589', '16', '36');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('590', '16', '15');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('591', '16', '34');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('592', '16', '16');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('593', '16', '13');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('594', '16', '37');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('595', '16', '43');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('596', '16', '40');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('597', '16', '64');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('598', '16', '80');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('599', '16', '60');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('600', '16', '61');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('601', '16', '87');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('602', '16', '84');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('603', '16', '85');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('604', '16', '49');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('605', '16', '66');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('606', '16', '45');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('607', '16', '93');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('608', '16', '92');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('609', '16', '91');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('610', '16', '90');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('611', '16', '25');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('612', '16', '32');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('613', '16', '70');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('614', '16', '52');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('615', '16', '9');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('616', '16', '54');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('617', '16', '73');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('618', '16', '74');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('619', '16', '88');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('620', '16', '75');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('621', '16', '50');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('622', '16', '89');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('623', '16', '76');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('624', '17', '59');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('625', '17', '57');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('626', '17', '56');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('627', '17', '55');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('628', '17', '35');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('629', '17', '36');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('630', '17', '15');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('631', '17', '34');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('632', '17', '16');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('633', '17', '13');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('634', '17', '37');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('635', '17', '43');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('636', '17', '40');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('637', '17', '64');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('638', '17', '80');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('639', '17', '62');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('640', '17', '60');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('641', '17', '61');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('642', '17', '87');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('643', '17', '84');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('644', '17', '85');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('645', '17', '49');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('646', '17', '66');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('647', '17', '45');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('648', '17', '93');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('649', '17', '92');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('650', '17', '91');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('651', '17', '90');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('652', '17', '25');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('653', '17', '32');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('654', '17', '70');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('655', '17', '52');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('656', '17', '9');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('657', '17', '54');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('658', '17', '73');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('659', '17', '74');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('660', '17', '88');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('661', '17', '75');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('662', '17', '50');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('663', '17', '89');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('664', '17', '76');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('665', '22', '80');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('666', '22', '87');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('667', '22', '84');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('668', '22', '85');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('669', '22', '93');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('670', '22', '92');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('671', '22', '91');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('672', '22', '90');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('673', '22', '73');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('674', '22', '74');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('675', '22', '88');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('676', '22', '75');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('677', '22', '89');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('678', '22', '76');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('679', '34', '77');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('680', '34', '86');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('681', '34', '85');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('682', '34', '72');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('683', '34', '73');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('684', '34', '74');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('685', '34', '75');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('686', '34', '76');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('687', '34', '59');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('688', '34', '58');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('689', '34', '57');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('690', '34', '56');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('691', '34', '55');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('692', '34', '64');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('693', '34', '60');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('694', '34', '61');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('695', '34', '90');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('696', '34', '53');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('697', '34', '54');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('698', '34', '89');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('699', '35', '19');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('700', '35', '31');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('701', '35', '86');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('702', '32', '77');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('703', '32', '58');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('704', '32', '57');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('705', '32', '56');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('706', '32', '55');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('707', '32', '53');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('708', '32', '54');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('709', '32', '72');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('710', '32', '73');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('711', '32', '74');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('712', '32', '75');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('713', '32', '76');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('714', '70', '32');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('717', '2', '91');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('718', '70', '94');
INSERT INTO `wlzx_system_role_dam_relationship` VALUES ('719', '1', '94');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('48', '21', '11');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('51', '20', '45');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('54', '20', '46');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('55', '20', '44');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('56', '18', '6');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('57', '19', '3');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('58', '20', '12');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('59', '20', '10');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('78', '6', '23');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('79', '6', '24');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('80', '6', '25');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('81', '6', '22');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('82', '3', '26');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('83', '3', '27');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('84', '3', '28');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('85', '3', '29');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('87', '22', '13');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('88', '22', '14');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('89', '22', '15');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('90', '22', '16');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('91', '22', '17');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('92', '22', '18');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('93', '22', '19');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('94', '22', '20');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('95', '22', '21');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('97', '22', '43');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('98', '16', '35');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('99', '16', '36');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('100', '16', '33');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('101', '16', '34');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('102', '16', '37');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('103', '16', '38');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('104', '17', '39');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('105', '17', '40');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('106', '17', '41');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('107', '17', '42');
INSERT INTO `wlzx_system_role_department_leadership` VALUES ('108', '16', '47');
INSERT INTO `wlzx_system_role_leadship` VALUES ('7', '1', '18');
INSERT INTO `wlzx_system_role_leadship` VALUES ('8', '1', '19');
INSERT INTO `wlzx_system_role_leadship` VALUES ('9', '1', '20');
INSERT INTO `wlzx_system_role_leadship` VALUES ('10', '1', '21');
INSERT INTO `wlzx_system_role_leadship` VALUES ('15', '6', '58');
INSERT INTO `wlzx_system_role_leadship` VALUES ('16', '3', '59');
INSERT INTO `wlzx_system_role_leadship` VALUES ('17', '22', '60');
INSERT INTO `wlzx_system_role_leadship` VALUES ('18', '16', '61');
INSERT INTO `wlzx_system_role_leadship` VALUES ('19', '17', '62');
INSERT INTO `wlzx_system_role_leadship` VALUES ('22', '1', '65');
INSERT INTO `wlzx_system_role_leadship` VALUES ('23', '1', '66');
INSERT INTO `wlzx_system_role_leadship` VALUES ('26', '22', '70');
INSERT INTO `wlzx_system_role_leadship` VALUES ('28', '1', '75');
INSERT INTO `wlzx_system_role_leadship` VALUES ('30', '6', '77');
INSERT INTO `wlzx_system_role_leadship` VALUES ('31', '34', '78');
INSERT INTO `wlzx_system_role_leadship` VALUES ('32', '33', '79');
INSERT INTO `wlzx_system_role_leadship` VALUES ('33', '3', '80');
INSERT INTO `wlzx_system_role_leadship` VALUES ('34', '36', '81');
INSERT INTO `wlzx_system_role_leadship` VALUES ('35', '37', '82');
INSERT INTO `wlzx_system_role_leadship` VALUES ('36', '38', '83');
INSERT INTO `wlzx_system_role_leadship` VALUES ('37', '39', '84');
INSERT INTO `wlzx_system_role_leadship` VALUES ('38', '22', '85');
INSERT INTO `wlzx_system_role_leadship` VALUES ('39', '53', '86');
INSERT INTO `wlzx_system_role_leadship` VALUES ('40', '23', '87');
INSERT INTO `wlzx_system_role_leadship` VALUES ('41', '24', '88');
INSERT INTO `wlzx_system_role_leadship` VALUES ('42', '25', '89');
INSERT INTO `wlzx_system_role_leadship` VALUES ('43', '26', '90');
INSERT INTO `wlzx_system_role_leadship` VALUES ('44', '27', '91');
INSERT INTO `wlzx_system_role_leadship` VALUES ('45', '28', '92');
INSERT INTO `wlzx_system_role_leadship` VALUES ('46', '29', '93');
INSERT INTO `wlzx_system_role_leadship` VALUES ('47', '30', '94');
INSERT INTO `wlzx_system_role_leadship` VALUES ('48', '31', '95');
INSERT INTO `wlzx_system_role_leadship` VALUES ('49', '16', '96');
INSERT INTO `wlzx_system_role_leadship` VALUES ('50', '45', '97');
INSERT INTO `wlzx_system_role_leadship` VALUES ('51', '46', '98');
INSERT INTO `wlzx_system_role_leadship` VALUES ('52', '43', '99');
INSERT INTO `wlzx_system_role_leadship` VALUES ('53', '44', '100');
INSERT INTO `wlzx_system_role_leadship` VALUES ('54', '47', '101');
INSERT INTO `wlzx_system_role_leadship` VALUES ('55', '48', '102');
INSERT INTO `wlzx_system_role_leadship` VALUES ('56', '17', '103');
INSERT INTO `wlzx_system_role_leadship` VALUES ('57', '49', '104');
INSERT INTO `wlzx_system_role_leadship` VALUES ('58', '50', '105');
INSERT INTO `wlzx_system_role_leadship` VALUES ('59', '50', '106');
INSERT INTO `wlzx_system_role_leadship` VALUES ('60', '51', '107');
INSERT INTO `wlzx_system_role_leadship` VALUES ('61', '52', '108');
INSERT INTO `wlzx_system_role_leadship` VALUES ('62', '52', '109');
INSERT INTO `wlzx_system_role_leadship` VALUES ('63', '71', '110');
INSERT INTO `wlzx_system_role_leadship` VALUES ('64', '72', '111');
INSERT INTO `wlzx_system_role_leadship` VALUES ('65', '73', '112');
INSERT INTO `wlzx_system_role_leadship` VALUES ('66', '1', '113');
INSERT INTO `wlzx_system_role_leadship` VALUES ('67', '114', '115');
INSERT INTO `wlzx_system_role_leadship` VALUES ('68', '3', '116');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('2', '21', '711');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('3', '18', '712');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('4', '20', '709');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('5', '19', '713');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('7', '65', '708');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('12', '58', '717');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('14', '32', '719');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('15', '35', '720');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('16', '3', '722');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('17', '59', '723');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('18', '37', '998');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('19', '60', '734');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('20', '70', '736');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('21', '17', '983');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('23', '51', '986');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('26', '61', '735');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('28', '22', '733');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('29', '1', '708');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('31', '75', '715');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('32', '75', '710');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('34', '6', '716');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('38', '94', '1008');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('46', '62', '986');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('47', '113', '1007');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('48', '91', '708');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('49', '90', '709');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('50', '89', '711');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('51', '91', '712');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('52', '92', '713');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('53', '88', '715');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('54', '95', '716');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('55', '87', '717');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('56', '115', '721');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('57', '88', '722');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('58', '99', '723');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('59', '116', '868');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('60', '90', '868');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('61', '93', '727');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('62', '100', '729');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('63', '91', '733');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('64', '88', '734');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('65', '89', '736');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('66', '100', '737');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('67', '115', '946');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('68', '92', '735');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('69', '89', '945');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('70', '115', '947');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('71', '115', '948');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('72', '114', '949');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('73', '91', '983');
INSERT INTO `wlzx_system_role_user_relationship` VALUES ('74', '50', '990');
INSERT INTO `wlzx_system_treeship` VALUES ('1', '1', '2');
INSERT INTO `wlzx_system_treeship` VALUES ('2', '1', '3');
INSERT INTO `wlzx_system_user` VALUES ('1', 'super_root', '0', 'super_root', '134bca5421a15476a1e5ebaebdba1ede', '2011-08-25 23:08:12', '127.0.0.1', '-1', null, null, null, '2011-05-07 11:04:22', '2011-07-05 17:33:02', '1', null, null);
INSERT INTO `wlzx_system_user` VALUES ('708', '666888', '0', '666888', '75e266f182b4fa3625d4a4f4f779af54', '2011-08-26 10:36:06', '127.0.0.1', '0', null, null, '', '2011-07-05 12:57:49', '2011-07-05 12:57:51', '1', '1', '1');
INSERT INTO `wlzx_system_user` VALUES ('709', '666900', '0', '666900', '2e6d1125057ec7c4402a5a2ad84f6601', '2011-08-26 10:24:06', '127.0.0.1', '0', null, null, '', '2011-07-05 12:57:51', '2011-07-05 12:57:52', '1', '20', '1');
INSERT INTO `wlzx_system_user` VALUES ('710', '666988', '0', '666988', 'cb3d82f7133330c48bee639908125906', null, '', '0', null, null, '', '2011-07-05 12:57:52', '2011-07-05 12:57:53', '1', '75', '1');
INSERT INTO `wlzx_system_user` VALUES ('711', '666898', '0', '666898', '25eb84aab86275ed44073ce95057b9c4', null, '', '0', null, null, '', '2011-07-05 12:57:53', '2011-07-05 12:57:55', '1', '21', '1');
INSERT INTO `wlzx_system_user` VALUES ('712', '668555', '0', '668555', '22df6af3d0353199f97000559339f2d1', '2011-07-26 12:37:42', '127.0.0.1', '0', null, null, '', '2011-07-05 12:57:55', '2011-07-05 12:57:56', '1', '18', '1');
INSERT INTO `wlzx_system_user` VALUES ('713', '666868', '0', '666868', '239769a1581c479c643631999889d5fd', null, '', '0', null, null, '', '2011-07-05 12:57:56', '2011-07-05 12:57:58', '1', '19', '1');
INSERT INTO `wlzx_system_user` VALUES ('715', '666858', '0', '666858', '12a9fd862f0759c848b616fda835321a', null, '', '0', null, null, '', '2011-07-05 12:57:59', '2011-07-05 12:58:01', '1', '75', '1');
INSERT INTO `wlzx_system_user` VALUES ('716', '666810', '0', '666810', 'eacb8b263925b90441949f215ffa7583', null, '', '0', null, null, '', '2011-07-05 12:58:01', '2011-07-05 12:58:02', '1', '6', '6');
INSERT INTO `wlzx_system_user` VALUES ('717', '665305', '0', '665305', 'b450b24e02a13f8a2f6a3f6a1599c914', null, '', '0', null, null, '', '2011-07-05 12:58:02', '2011-07-05 12:58:04', '1', null, '6');
INSERT INTO `wlzx_system_user` VALUES ('718', '660001', '0', '660001', '24e0b74e1411efc7ef92ab8e879a0ee9', '2011-08-26 10:56:16', '127.0.0.1', '0', null, null, '', '2011-07-05 12:58:04', '2011-07-05 12:58:05', '1', '34', '24');
INSERT INTO `wlzx_system_user` VALUES ('719', '666995', '0', '666995', 'ef053b16349a72abd90acb084ae1e007', null, '', '0', null, null, '', '2011-07-05 12:58:05', '2011-07-05 12:58:06', '1', '77', '6');
INSERT INTO `wlzx_system_user` VALUES ('720', '666966', '0', '666966', '36ef0194bf0abb102fbcfd27595a9bf8', null, '', '0', null, null, '', '2011-07-05 12:58:07', '2011-07-05 12:58:08', '1', '77', '6');
INSERT INTO `wlzx_system_user` VALUES ('721', '666288', '0', '666288', '3eb3029563c6c602adcf5d7463cfcd0c', null, '', '0', null, null, '', '2011-07-05 12:58:08', '2011-07-05 12:58:09', '1', '77', '6');
INSERT INTO `wlzx_system_user` VALUES ('722', '666680', '0', '666680', '02e5e3e68013b91ad956ff1387d31ea6', null, '', '0', null, null, '', '2011-07-05 12:58:09', '2011-07-05 12:58:11', '1', '3', '3');
INSERT INTO `wlzx_system_user` VALUES ('723', '666833', '0', '666833', '3d1889993e51639cdecddae4a3688d63', null, '', '0', null, null, '', '2011-07-05 12:58:11', '2011-07-05 12:58:12', '1', '59', '3');
INSERT INTO `wlzx_system_user` VALUES ('725', '666776', '0', '666776', '4140e459d7a19475f6547eb0f618202c', null, '', '0', null, null, '', '2011-07-05 12:58:14', '2011-07-05 12:58:15', '1', '92', '18');
INSERT INTO `wlzx_system_user` VALUES ('726', '665151', '0', '665151', '4af6f2078f83838322d1c852de096678', null, '', '0', null, null, '', '2011-07-05 12:58:15', '2011-07-05 12:58:17', '1', '83', '28');
INSERT INTO `wlzx_system_user` VALUES ('727', '666863', '0', '666863', '611630c42d0b21b64e7e4524c8cb724c', null, '', '0', null, null, '', '2011-07-05 12:58:17', '2011-07-05 12:58:18', '1', '80', '3');
INSERT INTO `wlzx_system_user` VALUES ('728', '668165', '0', '668165', '26b706d4b0123b5b544fe335b117cfdd', null, '', '0', null, null, '', '2011-07-05 12:58:18', '2011-07-05 12:58:19', '1', '80', '3');
INSERT INTO `wlzx_system_user` VALUES ('729', '668068', '0', '668068', '7fa99daa9a13afbd1c263a7b211ebf09', null, '', '0', null, null, '', '2011-07-05 12:58:19', '2011-07-05 12:58:21', '1', null, '3');
INSERT INTO `wlzx_system_user` VALUES ('730', '669898', '0', '669898', 'a079523553405078bf2e54afba59a95f', null, '', '0', null, null, '', '2011-07-05 12:58:21', '2011-07-05 12:58:22', '1', '83', '28');
INSERT INTO `wlzx_system_user` VALUES ('731', '666861', '0', '666861', 'b1b2e8b0f2783f48db9147fa041ea897', null, '', '0', null, null, '', '2011-07-05 12:58:22', '2011-07-05 12:58:24', '1', '80', '3');
INSERT INTO `wlzx_system_user` VALUES ('732', '666993', '0', '666993', 'd3b86da2df2761c1cd78abc06010bc4c', null, '', '0', null, null, '', '2011-07-05 12:58:24', '2011-07-05 12:58:25', '1', '80', '3');
INSERT INTO `wlzx_system_user` VALUES ('733', '666756', '0', '666756', '6e21390593b2b2a56159614854a98104', '2011-07-26 14:31:10', '127.0.0.1', '0', null, null, '', '2011-07-05 12:58:25', '2011-07-05 12:58:26', '1', '22', '12');
INSERT INTO `wlzx_system_user` VALUES ('734', '666651', '0', '666651', 'e03a04401774ce1b57ec24ddb619e8d8', null, '', '0', null, null, '', '2011-07-05 12:58:26', '2011-07-05 12:58:28', '1', null, '12');
INSERT INTO `wlzx_system_user` VALUES ('735', '666869', '0', '666869', '5193520e534dbe6cda7bcd5c9e62e7c5', null, '', '0', null, null, '', '2011-07-05 12:58:28', '2011-07-05 12:58:29', '1', null, '12');
INSERT INTO `wlzx_system_user` VALUES ('736', '666870', '0', '666870', '339bc6c12dc2f145935bbbbeb6190496', '2011-07-26 11:57:26', '127.0.0.1', '0', null, null, '', '2011-07-05 12:58:29', '2011-07-05 12:58:30', '1', '85', '12');
INSERT INTO `wlzx_system_user` VALUES ('737', '666871', '0', '666871', 'bb529254f51e8cbc00cd7f109fd885bc', null, '', '0', null, null, '', '2011-07-05 12:58:30', '2011-07-05 12:58:32', '1', null, '12');
INSERT INTO `wlzx_system_user` VALUES ('738', '666872', '0', '666872', 'b0eba03d0cfdb1ab7c9c90dfea2c4ba4', null, '', '0', null, null, '', '2011-07-05 12:58:32', '2011-07-05 12:58:34', '1', '85', '12');
INSERT INTO `wlzx_system_user` VALUES ('739', '666873', '0', '666873', 'aeddb53c4cf46a3b32db579dd28205e1', null, '', '0', null, null, '', '2011-07-05 12:58:34', '2011-07-05 12:58:35', '1', '85', '12');
INSERT INTO `wlzx_system_user` VALUES ('741', '666922', '0', '666922', 'e6e0814a0df9f9e6bd73aac4cead46de', null, '', '0', null, null, '', '2011-07-05 12:58:37', '2011-07-05 12:58:38', '1', '85', '12');
INSERT INTO `wlzx_system_user` VALUES ('742', '666611', '0', '666611', '097b0b8babdb475bda01d83e0d784b44', null, '', '0', null, null, '', '2011-07-05 12:58:38', '2011-07-05 12:58:40', '1', '23', '13');
INSERT INTO `wlzx_system_user` VALUES ('743', '666602', '0', '666602', '13c5265a33ab2a8262619397f0b4fa22', null, '', '0', null, null, '', '2011-07-05 12:58:40', '2011-07-05 12:58:41', '1', '87', '13');
INSERT INTO `wlzx_system_user` VALUES ('744', '666603', '0', '666603', '420897da27850742d9f69e97f0c2f4a5', null, '', '0', null, null, '', '2011-07-05 12:58:41', '2011-07-05 12:58:42', '1', '87', '13');
INSERT INTO `wlzx_system_user` VALUES ('745', '666606', '0', '666606', '2440d27e314166a05a3694413fc69155', null, '', '0', null, null, '', '2011-07-05 12:58:42', '2011-07-05 12:58:44', '1', '87', '13');
INSERT INTO `wlzx_system_user` VALUES ('746', '666608', '0', '666608', '3d2a390af9909bd32230739a323dd9ef', null, '', '0', null, null, '', '2011-07-05 12:58:44', '2011-07-05 12:58:45', '1', '87', '13');
INSERT INTO `wlzx_system_user` VALUES ('747', '666609', '0', '666609', 'b3d3dab0b398e9ba7a86ef5f224ab920', null, '', '0', null, null, '', '2011-07-05 12:58:45', '2011-07-05 12:58:46', '1', '87', '13');
INSERT INTO `wlzx_system_user` VALUES ('748', '666610', '0', '666610', '44de43ba9c5bfe5dfeb536a4e8c331d3', null, '', '0', null, null, '', '2011-07-05 12:58:46', '2011-07-05 12:58:48', '1', '87', '13');
INSERT INTO `wlzx_system_user` VALUES ('749', '666612', '0', '666612', 'e989decdf34be9b46559010eec6d40ca', null, '', '0', null, null, '', '2011-07-05 12:58:48', '2011-07-05 12:58:49', '1', '87', '13');
INSERT INTO `wlzx_system_user` VALUES ('750', '666613', '0', '666613', '83924f309134ad8893e691ba9bad95c0', null, '', '0', null, null, '', '2011-07-05 12:58:49', '2011-07-05 12:58:50', '1', '87', '13');
INSERT INTO `wlzx_system_user` VALUES ('751', '666615', '0', '666615', '6b7d132d9ea23205c48128f2f351c024', null, '', '0', null, null, '', '2011-07-05 12:58:50', '2011-07-05 12:58:52', '1', '87', '13');
INSERT INTO `wlzx_system_user` VALUES ('752', '666616', '0', '666616', '5978a945bc0888986e7e43ff2ead8a8c', null, '', '0', null, null, '', '2011-07-05 12:58:52', '2011-07-05 12:58:54', '1', '87', '13');
INSERT INTO `wlzx_system_user` VALUES ('753', '666617', '0', '666617', '502e1777e35e3725dafd50c650887e0a', null, '', '0', null, null, '', '2011-07-05 12:58:54', '2011-07-05 12:58:55', '1', '87', '13');
INSERT INTO `wlzx_system_user` VALUES ('754', '600899', '0', '600899', '6296e869cf654e8ff2da68ef6a6f9f7c', null, '', '0', null, null, '', '2011-07-05 12:58:55', '2011-07-05 12:58:56', '1', '87', '13');
INSERT INTO `wlzx_system_user` VALUES ('755', '666620', '0', '666620', 'e1261de07a6f57801bbfc167df0a1134', null, '', '0', null, null, '', '2011-07-05 12:58:56', '2011-07-05 12:58:58', '1', '87', '13');
INSERT INTO `wlzx_system_user` VALUES ('756', '666621', '0', '666621', '208e7ee7edaea57f14eb6bfb7eedd639', null, '', '0', null, null, '', '2011-07-05 12:58:58', '2011-07-05 12:59:00', '1', '87', '13');
INSERT INTO `wlzx_system_user` VALUES ('757', '666622', '0', '666622', '068d57889f3893e9c3823949ef7cbb85', null, '', '0', null, null, '', '2011-07-05 12:59:00', '2011-07-05 12:59:01', '1', '87', '13');
INSERT INTO `wlzx_system_user` VALUES ('758', '666623', '0', '666623', 'd0f1903013174824230464e4da2bc389', null, '', '0', null, null, '', '2011-07-05 12:59:01', '2011-07-05 12:59:02', '1', '87', '13');
INSERT INTO `wlzx_system_user` VALUES ('759', '666626', '0', '666626', 'fa5c1db29a4a8b3846e22b57cdd8fad5', null, '', '0', null, null, '', '2011-07-05 12:59:02', '2011-07-05 12:59:04', '1', null, '13');
INSERT INTO `wlzx_system_user` VALUES ('760', '666627', '0', '666627', '010609503945a45056ae180c133c5af2', null, '', '0', null, null, '', '2011-07-05 12:59:04', '2011-07-05 12:59:05', '1', null, '13');
INSERT INTO `wlzx_system_user` VALUES ('761', '666629', '0', '666629', '3ab6f08d32574fd25c1fcebc7db31f6b', null, '', '0', null, null, '', '2011-07-05 12:59:05', '2011-07-05 12:59:06', '1', null, '13');
INSERT INTO `wlzx_system_user` VALUES ('762', '666631', '0', '666631', '1be105f8d11b97d25b4bee26cdef5939', null, '', '0', null, null, '', '2011-07-05 12:59:06', '2011-07-05 12:59:08', '1', null, '13');
INSERT INTO `wlzx_system_user` VALUES ('763', '666632', '0', '666632', '24fbba13bc474d4a342531d9415ce06c', null, '', '0', null, null, '', '2011-07-05 12:59:08', '2011-07-05 12:59:09', '1', null, '13');
INSERT INTO `wlzx_system_user` VALUES ('764', '666633', '0', '666633', '00a8f0f8232a1cd674c4a665af36719a', null, '', '0', null, null, '', '2011-07-05 12:59:09', '2011-07-05 12:59:11', '1', null, '13');
INSERT INTO `wlzx_system_user` VALUES ('765', '666635', '0', '666635', '348f401a30c3f61b0ea95ff3a9d2fa82', null, '', '0', null, null, '', '2011-07-05 12:59:11', '2011-07-05 12:59:12', '1', null, '13');
INSERT INTO `wlzx_system_user` VALUES ('766', '666637', '0', '666637', '56989d2597cb6591814ef72dd6ff97c7', null, '', '0', null, null, '', '2011-07-05 12:59:12', '2011-07-05 12:59:14', '1', null, '13');
INSERT INTO `wlzx_system_user` VALUES ('767', '666258', '0', '666258', '975a713d1efda7d7cd30452a5d57e4b4', null, '', '0', null, null, '', '2011-07-05 12:59:14', '2011-07-05 12:59:15', '1', null, '13');
INSERT INTO `wlzx_system_user` VALUES ('768', '666558', '0', '666558', '219be5610ada1495136a83f654f7e31e', null, '', '0', null, null, '', '2011-07-05 12:59:15', '2011-07-05 12:59:17', '1', null, '13');
INSERT INTO `wlzx_system_user` VALUES ('769', '666256', '0', '666256', '07c0d1070b834d7ee3e3e7e59c6a55bc', null, '', '0', null, null, '', '2011-07-05 12:59:17', '2011-07-05 12:59:18', '1', null, '13');
INSERT INTO `wlzx_system_user` VALUES ('770', '666607', '0', '666607', '794f9aa57185cdd5bd8048c4de37a201', null, '', '0', null, null, '', '2011-07-05 12:59:18', '2011-07-05 12:59:20', '1', null, '13');
INSERT INTO `wlzx_system_user` VALUES ('771', '668961', '0', '668961', '9afcb8f294d28bb42a17b3e7769f1c8a', null, '', '0', null, null, '', '2011-07-05 12:59:20', '2011-07-05 12:59:21', '1', null, '13');
INSERT INTO `wlzx_system_user` VALUES ('773', '669261', '0', '669261', 'ca36e620ddb7fbbad2e9a5426b40b97a', null, '', '0', null, null, '', '2011-07-05 12:59:22', '2011-07-05 12:59:24', '1', null, '13');
INSERT INTO `wlzx_system_user` VALUES ('774', '661717', '0', '661717', 'cc43d0750d1ec8ea27d2d866cb4aa943', null, '', '0', null, null, '', '2011-07-05 12:59:24', '2011-07-05 12:59:25', '1', null, '13');
INSERT INTO `wlzx_system_user` VALUES ('775', '668870', '0', '668870', '158fa6688f8e4785edf2f97f23fe2488', null, '', '0', null, null, '', '2011-07-05 12:59:25', '2011-07-05 12:59:27', '1', null, '13');
INSERT INTO `wlzx_system_user` VALUES ('777', '666652', '0', '666652', 'e760d1e5173489ee13326385843ffb2b', null, '', '0', null, null, '', '2011-07-05 12:59:28', '2011-07-05 12:59:30', '1', '24', '14');
INSERT INTO `wlzx_system_user` VALUES ('778', '666500', '0', '666500', '8b2e3ee417d19babd86a5c62d6501aaf', null, '', '0', null, null, '', '2011-07-05 12:59:30', '2011-07-05 12:59:31', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('779', '666653', '0', '666653', '128bb15d8c19447dedce5dc7179a17f7', null, '', '0', null, null, '', '2011-07-05 12:59:31', '2011-07-05 12:59:32', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('780', '666655', '0', '666655', '89211b8e5e1a72bc917bfaa935bef863', null, '', '0', null, null, '', '2011-07-05 12:59:32', '2011-07-05 12:59:34', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('781', '666656', '0', '666656', '98da0a7463d0ca482b5e71b404dec7d5', null, '', '0', null, null, '', '2011-07-05 12:59:34', '2011-07-05 12:59:35', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('782', '666658', '0', '666658', '265a281ec700d5c7bc01178dc1d5395b', null, '', '0', null, null, '', '2011-07-05 12:59:35', '2011-07-05 12:59:37', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('783', '666659', '0', '666659', '2dd6b376a7dd640724cbb2bc7bf3d782', null, '', '0', null, null, '', '2011-07-05 12:59:37', '2011-07-05 12:59:38', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('784', '666660', '0', '666660', 'ef79629dc0e3114b151e9311e19d85e3', null, '', '0', null, null, '', '2011-07-05 12:59:38', '2011-07-05 12:59:39', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('785', '666662', '0', '666662', 'e13eaddfaf7fbb5a372ac4ba0b122e16', null, '', '0', null, null, '', '2011-07-05 12:59:39', '2011-07-05 12:59:41', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('786', '666663', '0', '666663', 'd4ebd6132396417b8eef36ddda351428', null, '', '0', null, null, '', '2011-07-05 12:59:41', '2011-07-05 12:59:42', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('787', '666668', '0', '666668', 'b2ac80ce504a1c1931ecec1ca381fe7b', null, '', '0', null, null, '', '2011-07-05 12:59:42', '2011-07-05 12:59:43', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('788', '666669', '0', '666669', 'c48ce60ae7a16403f3f039e9629ae42f', null, '', '0', null, null, '', '2011-07-05 12:59:43', '2011-07-05 12:59:45', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('789', '666667', '0', '666667', '28b19b01f749a6c0addc991d4c73eacf', null, '', '0', null, null, '', '2011-07-05 12:59:45', '2011-07-05 12:59:46', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('790', '666670', '0', '666670', 'e2881cc0b34cadd014f3d56e4df5735d', null, '', '0', null, null, '', '2011-07-05 12:59:46', '2011-07-05 12:59:47', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('791', '666671', '0', '666671', 'edb39a5bef372edca9153470b932a397', null, '', '0', null, null, '', '2011-07-05 12:59:47', '2011-07-05 12:59:49', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('792', '661540', '0', '661540', 'edab14f622b0476894ac844cf5307839', null, '', '0', null, null, '', '2011-07-05 12:59:49', '2011-07-05 12:59:51', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('793', '666676', '0', '666676', '68c4c4a8db05832912cff696eb36cc90', null, '', '0', null, null, '', '2011-07-05 12:59:51', '2011-07-05 12:59:52', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('794', '666677', '0', '666677', '51ad46d7af90a8778af37ff6c8413429', null, '', '0', null, null, '', '2011-07-05 12:59:52', '2011-07-05 12:59:53', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('795', '666678', '0', '666678', '30465e1d9f7434f27282a295052da335', null, '', '0', null, null, '', '2011-07-05 12:59:53', '2011-07-05 12:59:55', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('796', '666679', '0', '666679', 'ca72fb2e454b15e5f9c739b8facd7b29', null, '', '0', null, null, '', '2011-07-05 12:59:55', '2011-07-05 12:59:56', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('797', '666681', '0', '666681', '90658cfa0a7e598294c329b5bbee20d8', null, '', '0', null, null, '', '2011-07-05 12:59:56', '2011-07-05 12:59:57', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('798', '666682', '0', '666682', '1ed4092f2c24efbbfd6870c1a88c3c22', null, '', '0', null, null, '', '2011-07-05 12:59:57', '2011-07-05 12:59:59', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('799', '666568', '0', '666568', 'f3a6a18840c5f0cce535dc3cb2d4c9ef', null, '', '0', null, null, '', '2011-07-05 12:59:59', '2011-07-05 13:00:00', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('800', '666518', '0', '666518', 'fdeb446e7ccee83ad3d64a826c1d2c58', null, '', '0', null, null, '', '2011-07-05 13:00:00', '2011-07-05 13:00:02', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('801', '666605', '0', '666605', '81cfd8da360b402c59ac5466fbce5112', null, '', '0', null, null, '', '2011-07-05 13:00:02', '2011-07-05 13:00:03', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('802', '666625', '0', '666625', '6516c5ee0bae0685d8e05b297d2e2acf', null, '', '0', null, null, '', '2011-07-05 13:00:03', '2011-07-05 13:00:04', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('803', '669771', '0', '669771', 'f1eb5849fc6891eb25d694daf60ca97b', null, '', '0', null, null, '', '2011-07-05 13:00:04', '2011-07-05 13:00:06', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('804', '666657', '0', '666657', '6908bae351c4c31f51076214cc6b631e', null, '', '0', null, null, '', '2011-07-05 13:00:06', '2011-07-05 13:00:07', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('805', '666927', '0', '666927', '78eeb65c91dad4db2e2ee6d9a8998cab', null, '', '0', null, null, '', '2011-07-05 13:00:07', '2011-07-05 13:00:09', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('806', '666638', '0', '666638', '01d47dc23031c881e7223d0f0bbdf08c', null, '', '0', null, null, '', '2011-07-05 13:00:09', '2011-07-05 13:00:11', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('807', '660383', '0', '660383', '44706fab399b97cacb44f2c2bca516a7', null, '', '0', null, null, '', '2011-07-05 13:00:11', '2011-07-05 13:00:13', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('808', '665589', '0', '665589', '2f9a03bca9d6f65e3847f7d167c86520', null, '', '0', null, null, '', '2011-07-05 13:00:13', '2011-07-05 13:00:14', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('809', '668805', '0', '668805', '2924104487fabfec203d6262dd62eb4c', null, '', '0', null, null, '', '2011-07-05 13:00:15', '2011-07-05 13:00:16', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('810', '661858', '0', '661858', '0a1a2f8e39809efe11cd5668382d5a73', null, '', '0', null, null, '', '2011-07-05 13:00:16', '2011-07-05 13:00:18', '1', null, '14');
INSERT INTO `wlzx_system_user` VALUES ('812', '666691', '0', '666691', 'd9b5cf557ffbe7cb3041369323842381', null, '', '0', null, null, '', '2011-07-05 13:00:19', '2011-07-05 13:00:21', '1', '25', '15');
INSERT INTO `wlzx_system_user` VALUES ('813', '666690', '0', '666690', '047477f4513b822bf8ea2e90e3ae6c23', null, '', '0', null, null, '', '2011-07-05 13:00:21', '2011-07-05 13:00:22', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('814', '666686', '0', '666686', '52d5b1291a6f0dca42c5c1e97969e103', null, '', '0', null, null, '', '2011-07-05 13:00:22', '2011-07-05 13:00:24', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('815', '666687', '0', '666687', 'bedfa863cd8426b7e2a83183161ff38e', null, '', '0', null, null, '', '2011-07-05 13:00:24', '2011-07-05 13:00:26', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('816', '666688', '0', '666688', 'b7012387cdcb5d3d62a967435d604740', null, '', '0', null, null, '', '2011-07-05 13:00:26', '2011-07-05 13:00:27', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('817', '666689', '0', '666689', 'af6409024db851f70735990bf4689dfa', null, '', '0', null, null, '', '2011-07-05 13:00:27', '2011-07-05 13:00:29', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('818', '660576', '0', '660576', 'bac5e54e42b3cb4d648601458cd8d908', null, '', '0', null, null, '', '2011-07-05 13:00:29', '2011-07-05 13:00:30', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('819', '666695', '0', '666695', '688cef06c23b60f80450ed93af65180d', null, '', '0', null, null, '', '2011-07-05 13:00:30', '2011-07-05 13:00:32', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('820', '666697', '0', '666697', 'ce0cb7d4c52e8af7605bc493ff2f2a9d', null, '', '0', null, null, '', '2011-07-05 13:00:32', '2011-07-05 13:00:33', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('821', '666698', '0', '666698', '567e8005b249567560894242024b91fc', null, '', '0', null, null, '', '2011-07-05 13:00:33', '2011-07-05 13:00:35', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('822', '666700', '0', '666700', '8fa6d796827800a2520959cc741b98f1', null, '', '0', null, null, '', '2011-07-05 13:00:35', '2011-07-05 13:00:36', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('823', '666701', '0', '666701', '4bc8d8af49a3ea3df417597a6b32c7c8', null, '', '0', null, null, '', '2011-07-05 13:00:36', '2011-07-05 13:00:38', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('824', '666702', '0', '666702', 'b6bf96870fdb895f7ce72127c4879411', null, '', '0', null, null, '', '2011-07-05 13:00:38', '2011-07-05 13:00:39', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('825', '666703', '0', '666703', '49e560ac28ace682bd8209ce7c1ae1f0', null, '', '0', null, null, '', '2011-07-05 13:00:39', '2011-07-05 13:00:41', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('826', '668066', '0', '668066', '38f520256d2a23adca69d76cac0bfb8a', null, '', '0', null, null, '', '2011-07-05 13:00:41', '2011-07-05 13:00:43', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('827', '666706', '0', '666706', '5ef5c5aac0aa3f553eba54303da141c1', null, '', '0', null, null, '', '2011-07-05 13:00:43', '2011-07-05 13:00:44', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('828', '666708', '0', '666708', '4cf798a071974951c9ce0d2b3b9aa9d6', null, '', '0', null, null, '', '2011-07-05 13:00:44', '2011-07-05 13:00:46', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('829', '666709', '0', '666709', 'c56e3c67295b62268b3d504055922a17', null, '', '0', null, null, '', '2011-07-05 13:00:46', '2011-07-05 13:00:47', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('830', '666710', '0', '666710', '09a6201db9c73ac3a0e3907505c6a694', null, '', '0', null, null, '', '2011-07-05 13:00:47', '2011-07-05 13:00:49', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('831', '666711', '0', '666711', 'd97efb2796e6f2641f34ddc15430f17c', null, '', '0', null, null, '', '2011-07-05 13:00:49', '2011-07-05 13:00:50', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('832', '666712', '0', '666712', '39dbbb885ea260b1bfbcab1780da6d9b', null, '', '0', null, null, '', '2011-07-05 13:00:50', '2011-07-05 13:00:52', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('833', '666713', '0', '666713', '1d50e5ab6bd2f7d80eb305c64713fc1d', null, '', '0', null, null, '', '2011-07-05 13:00:52', '2011-07-05 13:00:54', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('834', '666715', '0', '666715', '87f009ad99b6c0494b53f9c6e27443ee', null, '', '0', null, null, '', '2011-07-05 13:00:54', '2011-07-05 13:00:56', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('835', '666716', '0', '666716', '50145c3878b8d46767122676aee8b8e3', null, '', '0', null, null, '', '2011-07-05 13:00:56', '2011-07-05 13:00:57', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('836', '666717', '0', '666717', 'c35eefed680724e81583ea79c78827bb', null, '', '0', null, null, '', '2011-07-05 13:00:57', '2011-07-05 13:00:59', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('837', '666718', '0', '666718', '97f763db6aba176e17573b172edc6db4', null, '', '0', null, null, '', '2011-07-05 13:00:59', '2011-07-05 13:01:00', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('838', '666719', '0', '666719', '65efbc0f7fafc86c80224b65451349fd', null, '', '0', null, null, '', '2011-07-05 13:01:00', '2011-07-05 13:01:02', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('839', '666261', '0', '666261', '34f18be4f73b5a646d7c186aa6d0a0d0', null, '', '0', null, null, '', '2011-07-05 13:01:02', '2011-07-05 13:01:03', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('840', '666262', '0', '666262', '3ebb1b385e461cfb8954b334b11f3e08', null, '', '0', null, null, '', '2011-07-05 13:01:03', '2011-07-05 13:01:04', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('841', '666263', '0', '666263', '89a7b57bc7cb4d35d06813c0b4934b02', null, '', '0', null, null, '', '2011-07-05 13:01:04', '2011-07-05 13:01:06', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('842', '666265', '0', '666265', '03f28246289fccac3bf782d23fc5619c', null, '', '0', null, null, '', '2011-07-05 13:01:06', '2011-07-05 13:01:08', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('843', '666707', '0', '666707', 'c0e3c0da32025ed848a60e5b513da4ee', null, '', '0', null, null, '', '2011-07-05 13:01:08', '2011-07-05 13:01:10', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('844', '669270', '0', '669270', 'f854bd16ede1deff005e84470fef5377', null, '', '0', null, null, '', '2011-07-05 13:01:10', '2011-07-05 13:01:11', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('845', '669123', '0', '669123', '478331422bf891b4eeb331114468750a', null, '', '0', null, null, '', '2011-07-05 13:01:11', '2011-07-05 13:01:12', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('846', '668818', '0', '668818', 'ede9a0e6bb4233ee7e4ec89b09fe4d8a', null, '', '0', null, null, '', '2011-07-05 13:01:12', '2011-07-05 13:01:14', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('847', '660560', '0', '660560', 'b550b09e83026f8a11a0354dfc503974', null, '', '0', null, null, '', '2011-07-05 13:01:14', '2011-07-05 13:01:16', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('848', '663331', '0', '663331', '507b2f62773fc93400dbe120ef00fdc9', null, '', '0', null, null, '', '2011-07-05 13:01:16', '2011-07-05 13:01:17', '1', null, '15');
INSERT INTO `wlzx_system_user` VALUES ('849', '666720', '0', '666720', '1de9fcac97cf5e2e16bdd74797a7fbc9', null, '', '0', null, null, '', '2011-07-05 13:01:17', '2011-07-05 13:01:19', '1', '26', '16');
INSERT INTO `wlzx_system_user` VALUES ('850', '666722', '0', '666722', '357b565918a9342564f4bf044e8fba48', null, '', '0', null, null, '', '2011-07-05 13:01:19', '2011-07-05 13:01:21', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('851', '666723', '0', '666723', '869db5d4acb6cd086d1132e3f54380a3', null, '', '0', null, null, '', '2011-07-05 13:01:21', '2011-07-05 13:01:22', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('852', '666726', '0', '666726', '1e978fae39a31c3650901799a99affe8', null, '', '0', null, null, '', '2011-07-05 13:01:22', '2011-07-05 13:01:24', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('853', '666727', '0', '666727', 'a1a520fe9fecc59837e578e79902b60b', null, '', '0', null, null, '', '2011-07-05 13:01:24', '2011-07-05 13:01:26', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('854', '660336', '0', '660336', '087aa3ce6a8a6b0954443b69ff805705', null, '', '0', null, null, '', '2011-07-05 13:01:26', '2011-07-05 13:01:27', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('855', '666730', '0', '666730', '228016c51153a3a226f19d2864c9aa9b', null, '', '0', null, null, '', '2011-07-05 13:01:27', '2011-07-05 13:01:29', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('856', '666731', '0', '666731', '07ec7887dfa2495a5cb0f0de2531e594', null, '', '0', null, null, '', '2011-07-05 13:01:29', '2011-07-05 13:01:30', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('857', '666732', '0', '666732', '0afd21d73dc03f1f867a5a753edf890f', null, '', '0', null, null, '', '2011-07-05 13:01:30', '2011-07-05 13:01:32', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('858', '666733', '0', '666733', '3fcd1bdc9a6e93f44e205fffa88da92b', null, '', '0', null, null, '', '2011-07-05 13:01:32', '2011-07-05 13:01:33', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('859', '666735', '0', '666735', '158275d539c622674d616766bc5ca2ce', null, '', '0', null, null, '', '2011-07-05 13:01:33', '2011-07-05 13:01:35', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('860', '667398', '0', '667398', '9888a1d35678f39781f27b949801b273', null, '', '0', null, null, '', '2011-07-05 13:01:35', '2011-07-05 13:01:36', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('861', '666737', '0', '666737', 'b24c34910ea4462bf332aab0a0d97c01', null, '', '0', null, null, '', '2011-07-05 13:01:36', '2011-07-05 13:01:38', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('862', '666738', '0', '666738', '5b771626b0ddb46b8d0613ef019fecff', null, '', '0', null, null, '', '2011-07-05 13:01:38', '2011-07-05 13:01:40', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('863', '666739', '0', '666739', 'a6f1937872ec9e99a3be1b0f395be373', null, '', '0', null, null, '', '2011-07-05 13:01:40', '2011-07-05 13:01:41', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('864', '666883', '0', '666883', '0eb698d135bd44c097182db6eb765d88', null, '', '0', null, null, '', '2011-07-05 13:01:41', '2011-07-05 13:01:43', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('865', '666266', '0', '666266', 'bf85730f2b414e1b5e9e49f101a70644', null, '', '0', null, null, '', '2011-07-05 13:01:43', '2011-07-05 13:01:44', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('866', '666463', '0', '666463', 'ab10be5b944601f220a35a0aea6173ab', null, '', '0', null, null, '', '2011-07-05 13:01:44', '2011-07-05 13:01:46', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('867', '666867', '0', '666867', 'a6a5ecd5b3003cac34a07c610f114b75', null, '', '0', null, null, '', '2011-07-05 13:01:46', '2011-07-05 13:01:47', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('868', '667720', '0', '667720', '2a00f4643fdf98740b32ee8f4428d07d', null, '', '0', null, null, '', '2011-07-05 13:01:47', '2011-07-05 13:01:49', '1', '116', '3');
INSERT INTO `wlzx_system_user` VALUES ('869', '666929', '0', '666929', 'e7772bed89c2f58fe5356e11e7040b7c', null, '', '0', null, null, '', '2011-07-05 13:01:49', '2011-07-05 13:01:50', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('870', '666750', '0', '666750', 'b1e098e0011db39e3ad0f5f9349da82d', null, '', '0', null, null, '', '2011-07-05 13:01:50', '2011-07-05 13:01:52', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('871', '666362', '0', '666362', '214eb0e688e7a5ab948d4a6696837827', null, '', '0', null, null, '', '2011-07-05 13:01:52', '2011-07-05 13:01:53', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('872', '667678', '0', '667678', 'c992c7a0e29fd849531e2fc8c2547e41', null, '', '0', null, null, '', '2011-07-05 13:01:53', '2011-07-05 13:01:54', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('873', '665328', '0', '665328', '789ed0ce0b5417f3cc28cbeda55143f9', null, '', '0', null, null, '', '2011-07-05 13:01:54', '2011-07-05 13:01:56', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('874', '669695', '0', '669695', '896396cbedd276fbd880f3310b06d244', null, '', '0', null, null, '', '2011-07-05 13:01:56', '2011-07-05 13:01:57', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('875', '666058', '0', '666058', '30b5f76e8c724deef2d6b8625a6b1067', null, '', '0', null, null, '', '2011-07-05 13:01:57', '2011-07-05 13:01:58', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('876', '667322', '0', '667322', '38d7a352fc54f83f5600a5c13f15ff9c', null, '', '0', null, null, '', '2011-07-05 13:01:58', '2011-07-05 13:02:00', '1', null, '16');
INSERT INTO `wlzx_system_user` VALUES ('877', '666751', '0', '666751', 'f62a7f241ccaa1adbe7e7d6571a93f34', null, '', '0', null, null, '', '2011-07-05 13:02:00', '2011-07-05 13:02:01', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('878', '666752', '0', '666752', '39f38b82a2740ea8ed97ca5042d22d66', null, '', '0', null, null, '', '2011-07-05 13:02:01', '2011-07-05 13:02:03', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('879', '666753', '0', '666753', 'b3a32391a097db5cb30e75fa5f2171f5', null, '', '0', null, null, '', '2011-07-05 13:02:03', '2011-07-05 13:02:04', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('881', '666757', '0', '666757', '998424e2d57e3fe59f28f25a1bef4ae1', null, '', '0', null, null, '', '2011-07-05 13:02:05', '2011-07-05 13:02:07', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('882', '666760', '0', '666760', 'd0c71e1059907102bb506dbe09c8a986', null, '', '0', null, null, '', '2011-07-05 13:02:07', '2011-07-05 13:02:08', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('883', '666761', '0', '666761', 'fdf560d004977c563551bbe2ce3ab8c4', null, '', '0', null, null, '', '2011-07-05 13:02:08', '2011-07-05 13:02:10', '1', '27', '17');
INSERT INTO `wlzx_system_user` VALUES ('884', '666763', '0', '666763', '48e05f4881522dd939c24cfcebfdde3f', null, '', '0', null, null, '', '2011-07-05 13:02:10', '2011-07-05 13:02:11', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('885', '666766', '0', '666766', 'b8259f019bd905d53160d9a58504c7a0', null, '', '0', null, null, '', '2011-07-05 13:02:11', '2011-07-05 13:02:12', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('886', '666767', '0', '666767', '4b264d771f35ce067c1fa5dc5d836662', null, '', '0', null, null, '', '2011-07-05 13:02:12', '2011-07-05 13:02:14', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('887', '666768', '0', '666768', '0d8d4659ee015bbc2b780dcfe63c858c', null, '', '0', null, null, '', '2011-07-05 13:02:14', '2011-07-05 13:02:15', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('888', '666769', '0', '666769', 'b5511431fb9b6ac6aa7968976eee6483', null, '', '0', null, null, '', '2011-07-05 13:02:15', '2011-07-05 13:02:17', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('889', '666770', '0', '666770', '64c4b6f80c85e5e6223c6f5b69c69b7e', null, '', '0', null, null, '', '2011-07-05 13:02:17', '2011-07-05 13:02:18', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('890', '666969', '0', '666969', 'da3b1634ee7e02c10a338bb49c816640', null, '', '0', null, null, '', '2011-07-05 13:02:18', '2011-07-05 13:02:20', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('891', '666772', '0', '666772', '3de22634f8501d3dddd72713c91cbfc1', null, '', '0', null, null, '', '2011-07-05 13:02:20', '2011-07-05 13:02:21', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('892', '661723', '0', '661723', 'ad63800a1cdbbe9321765e3206a60238', null, '', '0', null, null, '', '2011-07-05 13:02:21', '2011-07-05 13:02:23', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('893', '666773', '0', '666773', '82886ebb41f1d08391c666e043e8ca9c', null, '', '0', null, null, '', '2011-07-05 13:02:23', '2011-07-05 13:02:24', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('894', '664159', '0', '664159', 'bd119f64a73a7868e9fa3c9c54a98f56', null, '', '0', null, null, '', '2011-07-05 13:02:24', '2011-07-05 13:02:25', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('895', '662662', '0', '662662', 'b92f07565386fee31ed3cb8f818ab842', null, '', '0', null, null, '', '2011-07-05 13:02:25', '2011-07-05 13:02:27', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('896', '660922', '0', '660922', '593336512cf95a28d8e791b2b2dcc114', null, '', '0', null, null, '', '2011-07-05 13:02:27', '2011-07-05 13:02:28', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('897', '667186', '0', '667186', '0dea81ba92fa7744e479b5fd20c86f93', null, '', '0', null, null, '', '2011-07-05 13:02:28', '2011-07-05 13:02:29', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('898', '668807', '0', '668807', '1209a4eb16781173c81980bc7189efb1', null, '', '0', null, null, '', '2011-07-05 13:02:30', '2011-07-05 13:02:31', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('899', '667977', '0', '667977', 'fae86a851770e826879a260e3f742912', null, '', '0', null, null, '', '2011-07-05 13:02:31', '2011-07-05 13:02:32', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('900', '669167', '0', '669167', '46624d2b92aae0889b5ad886c7b13fdb', null, '', '0', null, null, '', '2011-07-05 13:02:32', '2011-07-05 13:02:34', '1', null, '17');
INSERT INTO `wlzx_system_user` VALUES ('901', '666779', '0', '666779', '0291746d359af028fdc9d79984e432ce', null, '', '0', null, null, '', '2011-07-05 13:02:34', '2011-07-05 13:02:35', '1', '28', '18');
INSERT INTO `wlzx_system_user` VALUES ('902', '660775', '0', '660775', 'c64ba91e2ea8f7ecd61a38fca7c2f248', null, '', '0', null, null, '', '2011-07-05 13:02:35', '2011-07-05 13:02:37', '1', '92', '18');
INSERT INTO `wlzx_system_user` VALUES ('903', '666778', '0', '666778', '4a3fb13eea81d5769cc0db1ad4e66f38', null, '', '0', null, null, '', '2011-07-05 13:02:37', '2011-07-05 13:02:38', '1', '92', '18');
INSERT INTO `wlzx_system_user` VALUES ('904', '666780', '0', '666780', 'fb8d3d7877712275e9cce6065f73ba93', null, '', '0', null, null, '', '2011-07-05 13:02:38', '2011-07-05 13:02:40', '1', '92', '18');
INSERT INTO `wlzx_system_user` VALUES ('905', '666781', '0', '666781', '79fbb7fa662695f2f32152ed86b5b422', null, '', '0', null, null, '', '2011-07-05 13:02:40', '2011-07-05 13:02:41', '1', '92', '18');
INSERT INTO `wlzx_system_user` VALUES ('906', '666783', '0', '666783', 'edda967941c89c57d11cd1638dce2007', null, '', '0', null, null, '', '2011-07-05 13:02:41', '2011-07-05 13:02:43', '1', '92', '18');
INSERT INTO `wlzx_system_user` VALUES ('907', '666268', '0', '666268', '09411566e37a9c7494caeb674e72e131', null, '', '0', null, null, '', '2011-07-05 13:02:43', '2011-07-05 13:02:44', '1', '92', '18');
INSERT INTO `wlzx_system_user` VALUES ('908', '666759', '0', '666759', '531a0d0c18d2fc08ef3bac0a03e83cd6', null, '', '0', null, null, '', '2011-07-05 13:02:44', '2011-07-05 13:02:46', '1', '92', '18');
INSERT INTO `wlzx_system_user` VALUES ('909', '666800', '0', '666800', '980a8c90582002c16a0d9af460329dac', null, '', '0', null, null, '', '2011-07-05 13:02:46', '2011-07-05 13:02:47', '1', '92', '18');
INSERT INTO `wlzx_system_user` VALUES ('910', '661686', '0', '661686', 'c28629b50382b8a92068077a2cb41f52', null, '', '0', null, null, '', '2011-07-05 13:02:47', '2011-07-05 13:02:49', '1', '92', '18');
INSERT INTO `wlzx_system_user` VALUES ('911', '665185', '0', '665185', '5efa1616f10dbf3f54e4998c571d3235', null, '', '0', null, null, '', '2011-07-05 13:02:49', '2011-07-05 13:02:50', '1', '92', '18');
INSERT INTO `wlzx_system_user` VALUES ('912', '661848', '0', '661848', '47167852521a28310f0a18a97a6471b4', null, '', '0', null, null, '', '2011-07-05 13:02:50', '2011-07-05 13:02:52', '1', '92', '18');
INSERT INTO `wlzx_system_user` VALUES ('913', '660586', '0', '660586', 'b4bd5bbcc7db3fa7a5d08ce44d142b4e', null, '', '0', null, null, '', '2011-07-05 13:02:52', '2011-07-05 13:02:53', '1', '92', '18');
INSERT INTO `wlzx_system_user` VALUES ('914', '667930', '0', '667930', 'a7651768a65cfa88eeecdba2cdcfbc54', null, '', '0', null, null, '', '2011-07-05 13:02:53', '2011-07-05 13:02:55', '1', '92', '18');
INSERT INTO `wlzx_system_user` VALUES ('915', '669286', '0', '669286', 'd2eefba10368092c64a686bc6402f145', null, '', '0', null, null, '', '2011-07-05 13:02:55', '2011-07-05 13:02:56', '1', '92', '18');
INSERT INTO `wlzx_system_user` VALUES ('916', '666788', '0', '666788', 'e175f9b1f95e0ab2ab688137ae1c4573', null, '', '0', null, null, '', '2011-07-05 13:02:56', '2011-07-05 13:02:57', '1', '29', '19');
INSERT INTO `wlzx_system_user` VALUES ('917', '666786', '0', '666786', '0162d852282df3648b1974c16d46fff1', null, '', '0', null, null, '', '2011-07-05 13:02:58', '2011-07-05 13:02:59', '1', null, '19');
INSERT INTO `wlzx_system_user` VALUES ('918', '666787', '0', '666787', '5f8997fde822fa3b2280c6245fd961c7', null, '', '0', null, null, '', '2011-07-05 13:02:59', '2011-07-05 13:03:00', '1', null, '19');
INSERT INTO `wlzx_system_user` VALUES ('919', '662841', '0', '662841', 'cd97ff4b71aeee0322ab14690d6d2ef4', null, '', '0', null, null, '', '2011-07-05 13:03:00', '2011-07-05 13:03:02', '1', null, '19');
INSERT INTO `wlzx_system_user` VALUES ('920', '666790', '0', '666790', '5882c0e4e08cd53837d514f9889b78ce', null, '', '0', null, null, '', '2011-07-05 13:03:02', '2011-07-05 13:03:03', '1', null, '19');
INSERT INTO `wlzx_system_user` VALUES ('921', '666792', '0', '666792', 'bd9e7066981c836973ced77c249f21ca', null, '', '0', null, null, '', '2011-07-05 13:03:03', '2011-07-05 13:03:05', '1', null, '19');
INSERT INTO `wlzx_system_user` VALUES ('922', '666789', '0', '666789', 'ad91c48bab41c40171efbe22239fd732', null, '', '0', null, null, '', '2011-07-05 13:03:05', '2011-07-05 13:03:06', '1', null, '19');
INSERT INTO `wlzx_system_user` VALUES ('923', '666791', '0', '666791', 'bba9ece82068db155c92bf5981d275e2', null, '', '0', null, null, '', '2011-07-05 13:03:06', '2011-07-05 13:03:08', '1', null, '19');
INSERT INTO `wlzx_system_user` VALUES ('924', '600608', '0', '600608', 'c7fe81e3d3631c865e6ffe3f4eb739be', null, '', '0', null, null, '', '2011-07-05 13:03:08', '2011-07-05 13:03:09', '1', null, '19');
INSERT INTO `wlzx_system_user` VALUES ('925', '666269', '0', '666269', '3b8f836a970784f763d9433d3554dfcd', null, '', '0', null, null, '', '2011-07-05 13:03:09', '2011-07-05 13:03:11', '1', '30', '20');
INSERT INTO `wlzx_system_user` VALUES ('926', '666815', '0', '666815', '23f2dfffaefff249b46fe6fd7edeaf07', null, '', '0', null, null, '', '2011-07-05 13:03:11', '2011-07-05 13:03:12', '1', null, '20');
INSERT INTO `wlzx_system_user` VALUES ('927', '666798', '0', '666798', '136363e75e45bd21ac8da83e792b1416', null, '', '0', null, null, '', '2011-07-05 13:03:12', '2011-07-05 13:03:14', '1', null, '20');
INSERT INTO `wlzx_system_user` VALUES ('928', '666799', '0', '666799', '3ba08717c9c39b12a948b1e37cce9fcc', null, '', '0', null, null, '', '2011-07-05 13:03:14', '2011-07-05 13:03:15', '1', null, '20');
INSERT INTO `wlzx_system_user` VALUES ('929', '666801', '0', '666801', '14b948f0699c1c7f12158a856699a439', null, '', '0', null, null, '', '2011-07-05 13:03:15', '2011-07-05 13:03:16', '1', null, '20');
INSERT INTO `wlzx_system_user` VALUES ('930', '666802', '0', '666802', '8e24eb85dd712538cc0a66d81190a679', null, '', '0', null, null, '', '2011-07-05 13:03:16', '2011-07-05 13:03:18', '1', null, '20');
INSERT INTO `wlzx_system_user` VALUES ('931', '666803', '0', '666803', '6f677eec2479566932540b6ed46bb929', null, '', '0', null, null, '', '2011-07-05 13:03:18', '2011-07-05 13:03:19', '1', null, '20');
INSERT INTO `wlzx_system_user` VALUES ('932', '666805', '0', '666805', 'e55e4e55755cfbb01cf36783135796a5', null, '', '0', null, null, '', '2011-07-05 13:03:19', '2011-07-05 13:03:21', '1', null, '20');
INSERT INTO `wlzx_system_user` VALUES ('933', '666806', '0', '666806', 'b287decaa5f3fe323fe9a8776e49de68', null, '', '0', null, null, '', '2011-07-05 13:03:21', '2011-07-05 13:03:22', '1', null, '20');
INSERT INTO `wlzx_system_user` VALUES ('934', '666813', '0', '666813', 'fbe36575c0fa8d5d0b77831bc9baed39', null, '', '0', null, null, '', '2011-07-05 13:03:22', '2011-07-05 13:03:23', '1', null, '20');
INSERT INTO `wlzx_system_user` VALUES ('935', '666816', '0', '666816', '74e4393056492e1beac9b33832fd6a18', null, '', '0', null, null, '', '2011-07-05 13:03:23', '2011-07-05 13:03:25', '1', '31', '21');
INSERT INTO `wlzx_system_user` VALUES ('936', '666808', '0', '666808', 'b9e80e10bc2f5df984a9974d2f0cf92a', null, '', '0', null, null, '', '2011-07-05 13:03:25', '2011-07-05 13:03:26', '1', null, '21');
INSERT INTO `wlzx_system_user` VALUES ('937', '666809', '0', '666809', 'c60f7d9af1d23cec3f259502ef230ae0', null, '', '0', null, null, '', '2011-07-05 13:03:26', '2011-07-05 13:03:28', '1', null, '21');
INSERT INTO `wlzx_system_user` VALUES ('938', '666811', '0', '666811', '3d468862e7a8e101b70867072d9ed512', null, '', '0', null, null, '', '2011-07-05 13:03:28', '2011-07-05 13:03:29', '1', null, '21');
INSERT INTO `wlzx_system_user` VALUES ('939', '666812', '0', '666812', '6127bb2d30bfe18ab8068e138bd920e6', null, '', '0', null, null, '', '2011-07-05 13:03:29', '2011-07-05 13:03:31', '1', null, '21');
INSERT INTO `wlzx_system_user` VALUES ('940', '600603', '0', '600603', '31042fbad2e07741de1a0c3c9a2ec907', null, '', '0', null, null, '', '2011-07-05 13:03:31', '2011-07-05 13:03:32', '1', null, '21');
INSERT INTO `wlzx_system_user` VALUES ('941', '664954', '0', '664954', '62aaf972f319daa696422973be76d66c', null, '', '0', null, null, '', '2011-07-05 13:03:32', '2011-07-05 13:03:34', '1', null, '21');
INSERT INTO `wlzx_system_user` VALUES ('942', '660961', '0', '660961', '124d7d14f7b97e1f6464c59a1afbb34c', null, '', '0', null, null, '', '2011-07-05 13:03:34', '2011-07-05 13:03:35', '1', null, '21');
INSERT INTO `wlzx_system_user` VALUES ('943', '669186', '0', '669186', 'ed4e6500033f8cfab9e94649777df81f', null, '', '0', null, null, '', '2011-07-05 13:03:35', '2011-07-05 13:03:37', '1', null, '21');
INSERT INTO `wlzx_system_user` VALUES ('944', '665716', '0', '665716', '9bc49193f8ef61f947ba5503f1d54b0b', null, '', '0', null, null, '', '2011-07-05 13:03:37', '2011-07-05 13:03:39', '1', null, '21');
INSERT INTO `wlzx_system_user` VALUES ('945', '666889', '0', '666889', 'c5f616e17eadeb553833b09e2b0d4b74', null, '', '0', null, null, '', '2011-07-05 13:03:39', '2011-07-05 13:03:40', '1', '96', '10');
INSERT INTO `wlzx_system_user` VALUES ('946', '666877', '0', '666877', 'cbcde84f25ed57ea80995d532c2b6c26', null, '', '0', null, null, '', '2011-07-05 13:03:40', '2011-07-05 13:03:42', '1', '16', '10');
INSERT INTO `wlzx_system_user` VALUES ('947', '666878', '0', '666878', '1f51fc04432be002747e295ed8d070de', null, '', '0', null, null, '', '2011-07-05 13:03:42', '2011-07-05 13:03:43', '1', '96', '10');
INSERT INTO `wlzx_system_user` VALUES ('948', '666855', '0', '666855', '2701e548411c98d8be155057144c37e0', null, '', '0', null, null, '', '2011-07-05 13:03:43', '2011-07-05 13:03:46', '1', null, '10');
INSERT INTO `wlzx_system_user` VALUES ('949', '666853', '0', '666853', 'f6439b75441f5f18767c3ded55430da6', null, '', '0', null, null, '', '2011-07-05 13:03:46', '2011-07-05 13:03:47', '1', null, '10');
INSERT INTO `wlzx_system_user` VALUES ('950', '667982', '0', '667982', '382242e1729c3e457ca17d9e3bdd6672', null, '', '0', null, null, '', '2011-07-05 13:03:47', '2011-07-05 13:03:49', '1', null, '10');
INSERT INTO `wlzx_system_user` VALUES ('951', '666831', '0', '666831', 'f7feb1918d3decebaf66c1c33559967c', null, '', '0', null, null, '', '2011-07-05 13:03:49', '2011-07-05 13:03:50', '1', '43', '33');
INSERT INTO `wlzx_system_user` VALUES ('952', '666823', '0', '666823', '1240af99915f23a52282b13e0efb78e5', null, '', '0', null, null, '', '2011-07-05 13:03:50', '2011-07-05 13:03:52', '1', null, '33');
INSERT INTO `wlzx_system_user` VALUES ('953', '662638', '0', '662638', 'b207367a204604ed1a45161c99bd9d3c', null, '', '0', null, null, '', '2011-07-05 13:03:52', '2011-07-05 13:03:53', '1', null, '33');
INSERT INTO `wlzx_system_user` VALUES ('954', '666821', '0', '666821', 'e60577533070cc4fb9146ae76c892843', null, '', '0', null, null, '', '2011-07-05 13:03:54', '2011-07-05 13:03:55', '1', null, '33');
INSERT INTO `wlzx_system_user` VALUES ('955', '666822', '0', '666822', '5ed90383b89920ca394e3f786a1b36bf', null, '', '0', null, null, '', '2011-07-05 13:03:55', '2011-07-05 13:03:56', '1', null, '33');
INSERT INTO `wlzx_system_user` VALUES ('956', '666825', '0', '666825', '003527a0b94cdb8284e7a57953a77a1f', null, '', '0', null, null, '', '2011-07-05 13:03:56', '2011-07-05 13:03:58', '1', null, '33');
INSERT INTO `wlzx_system_user` VALUES ('957', '666826', '0', '666826', '36502fc05e417c7dc37d375e715fd82f', null, '', '0', null, null, '', '2011-07-05 13:03:58', '2011-07-05 13:03:59', '1', null, '33');
INSERT INTO `wlzx_system_user` VALUES ('958', '666827', '0', '666827', '0b193aa6781193f73614b602e2dc372b', null, '', '0', null, null, '', '2011-07-05 13:03:59', '2011-07-05 13:04:01', '1', null, '33');
INSERT INTO `wlzx_system_user` VALUES ('959', '666828', '0', '666828', '6c718755c5bdcf93a1a5b3a72abd32a1', null, '', '0', null, null, '', '2011-07-05 13:04:01', '2011-07-05 13:04:02', '1', null, '33');
INSERT INTO `wlzx_system_user` VALUES ('960', '666829', '0', '666829', 'e499d26ddca89e0f7cb599a2f3a75eea', null, '', '0', null, null, '', '2011-07-05 13:04:02', '2011-07-05 13:04:04', '1', null, '33');
INSERT INTO `wlzx_system_user` VALUES ('961', '666830', '0', '666830', '364f77195215104cb9861c98d983d2c6', null, '', '0', null, null, '', '2011-07-05 13:04:04', '2011-07-05 13:04:05', '1', null, '33');
INSERT INTO `wlzx_system_user` VALUES ('962', '666832', '0', '666832', '9f02a502a173630e22711e9821cd837c', null, '', '0', null, null, '', '2011-07-05 13:04:05', '2011-07-05 13:04:07', '1', null, '33');
INSERT INTO `wlzx_system_user` VALUES ('963', '666835', '0', '666835', '270a6ca3a94fb6c327e4579548e034e0', null, '', '0', null, null, '', '2011-07-05 13:04:07', '2011-07-05 13:04:08', '1', null, '33');
INSERT INTO `wlzx_system_user` VALUES ('964', '666836', '0', '666836', 'b619718f71b9e79012e5a4181ba1a847', null, '', '0', null, null, '', '2011-07-05 13:04:08', '2011-07-05 13:04:09', '1', null, '33');
INSERT INTO `wlzx_system_user` VALUES ('965', '666837', '0', '666837', 'eabb8a6853ca429dd9a0229c70c326c2', null, '', '0', null, null, '', '2011-07-05 13:04:09', '2011-07-05 13:04:11', '1', null, '33');
INSERT INTO `wlzx_system_user` VALUES ('966', '666838', '0', '666838', '9e5012bbbf2462e311d54d00e717ccf6', null, '', '0', null, null, '', '2011-07-05 13:04:11', '2011-07-05 13:04:12', '1', null, '33');
INSERT INTO `wlzx_system_user` VALUES ('967', '668996', '0', '668996', '719740691d03b352a0b2df76e14c5ccf', null, '', '0', null, null, '', '2011-07-05 13:04:12', '2011-07-05 13:04:14', '1', null, '33');
INSERT INTO `wlzx_system_user` VALUES ('968', '669588', '0', '669588', '7bb1361cf8577bc2751c7926bc785efc', null, '', '0', null, null, '', '2011-07-05 13:04:14', '2011-07-05 13:04:15', '1', '45', '35');
INSERT INTO `wlzx_system_user` VALUES ('969', '666851', '0', '666851', 'ea15f92460b74da94151362e24ccc36d', null, '', '0', null, null, '', '2011-07-05 13:04:15', '2011-07-05 13:04:17', '1', null, '35');
INSERT INTO `wlzx_system_user` VALUES ('970', '666852', '0', '666852', '8e9c52151632702abffef4bf28f3f8c6', null, '', '0', null, null, '', '2011-07-05 13:04:17', '2011-07-05 13:04:18', '1', null, '35');
INSERT INTO `wlzx_system_user` VALUES ('971', '669168', '0', '669168', '0b9b0d8354f74b2e3488b172949666a2', null, '', '0', null, null, '', '2011-07-05 13:04:18', '2011-07-05 13:04:19', '1', null, '35');
INSERT INTO `wlzx_system_user` VALUES ('972', '666879', '0', '666879', '913fb7e4402ad6ecca2776ba4ae0f4a4', null, '', '0', null, null, '', '2011-07-05 13:04:19', '2011-07-05 13:04:21', '1', '44', '34');
INSERT INTO `wlzx_system_user` VALUES ('973', '666881', '0', '666881', 'ab330c3219a2398b2b6db3055a3d54f6', null, '', '0', null, null, '', '2011-07-05 13:04:21', '2011-07-05 13:04:22', '1', null, '34');
INSERT INTO `wlzx_system_user` VALUES ('974', '666885', '0', '666885', '93c76650cae85bb3d2288478458ee0c9', null, '', '0', null, null, '', '2011-07-05 13:04:22', '2011-07-05 13:04:24', '1', null, '34');
INSERT INTO `wlzx_system_user` VALUES ('975', '666886', '0', '666886', '513c9b529a313386a8e281219644182e', null, '', '0', null, null, '', '2011-07-05 13:04:24', '2011-07-05 13:04:25', '1', null, '34');
INSERT INTO `wlzx_system_user` VALUES ('976', '666588', '0', '666588', 'c3335ae4f5a6478c80e0f58f1efe98f9', null, '', '0', null, null, '', '2011-07-05 13:04:25', '2011-07-05 13:04:27', '1', null, '34');
INSERT INTO `wlzx_system_user` VALUES ('977', '666990', '0', '666990', 'ddf288b8fb5862b42686e9f346658c61', null, '', '0', null, null, '', '2011-07-05 13:04:27', '2011-07-05 13:04:28', '1', '46', '36');
INSERT INTO `wlzx_system_user` VALUES ('978', '666890', '0', '666890', 'd912a5a6bd06f24de4051651d8ffa78f', null, '', '0', null, null, '', '2011-07-05 13:04:28', '2011-07-05 13:04:30', '1', null, '36');
INSERT INTO `wlzx_system_user` VALUES ('979', '666891', '0', '666891', 'a3c41abe94475b90a7c5872ff3a9df3a', null, '', '0', null, null, '', '2011-07-05 13:04:30', '2011-07-05 13:04:31', '1', null, '36');
INSERT INTO `wlzx_system_user` VALUES ('980', '666892', '0', '666892', 'd984012f8946573d163ad28dc5e9b964', null, '', '0', null, null, '', '2011-07-05 13:04:31', '2011-07-05 13:04:32', '1', null, '36');
INSERT INTO `wlzx_system_user` VALUES ('981', '666893', '0', '666893', '932e91385727cc4acd28abccb1f3258a', null, '', '0', null, null, '', '2011-07-05 13:04:32', '2011-07-05 13:04:34', '1', null, '36');
INSERT INTO `wlzx_system_user` VALUES ('982', '666895', '0', '666895', 'a9ce0daef228ba9d5c90fff3e6552abb', null, '', '0', null, null, '', '2011-07-05 13:04:34', '2011-07-05 13:04:35', '1', null, '36');
INSERT INTO `wlzx_system_user` VALUES ('983', '665558', '0', '665558', '635bdf30a0501c6f380bc6a38d628de5', null, '', '0', null, null, '', '2011-07-05 13:04:35', '2011-07-05 13:04:37', '1', null, '11');
INSERT INTO `wlzx_system_user` VALUES ('984', '666912', '0', '666912', '7ffc18cef0484eb296fa072616a06752', null, '', '0', null, null, '', '2011-07-05 13:04:37', '2011-07-05 13:04:38', '1', null, '11');
INSERT INTO `wlzx_system_user` VALUES ('985', '662000', '0', '662000', 'bb493c92fc8e842054122ba90ed9b953', null, '', '0', null, null, '', '2011-07-05 13:04:38', '2011-07-05 13:04:39', '1', null, '11');
INSERT INTO `wlzx_system_user` VALUES ('986', '666901', '0', '666901', '19ecc9b920d56cf09ae35df835fc300a', null, '', '0', null, null, '', '2011-07-05 13:04:39', '2011-07-05 13:04:41', '1', '62', '11');
INSERT INTO `wlzx_system_user` VALUES ('987', '660605', '0', '660605', 'c3742a4baffd3441547154a17dc9f00d', null, '', '0', null, null, '', '2011-07-05 13:04:41', '2011-07-05 13:04:42', '1', null, '11');
INSERT INTO `wlzx_system_user` VALUES ('988', '666253', '0', '666253', '00b44f0f5c7cf3f42c90234096cff414', null, '', '0', null, null, '', '2011-07-05 13:04:42', '2011-07-05 13:04:44', '1', null, '11');
INSERT INTO `wlzx_system_user` VALUES ('989', '666906', '0', '666906', '4bf27d2965096dff968feab07a4bfba7', null, '', '0', null, null, '', '2011-07-05 13:04:44', '2011-07-05 13:04:45', '1', null, '11');
INSERT INTO `wlzx_system_user` VALUES ('990', '666907', '0', '666907', '1bb56dda429f89ba1a3019ab9c79fc2e', null, '', '0', null, null, '', '2011-07-05 13:04:45', '2011-07-05 13:04:46', '1', null, '11');
INSERT INTO `wlzx_system_user` VALUES ('991', '666908', '0', '666908', 'c327dde84f81fa348a5de1cf5dad12d9', null, '', '0', null, null, '', '2011-07-05 13:04:46', '2011-07-05 13:04:48', '1', null, '11');
INSERT INTO `wlzx_system_user` VALUES ('992', '666909', '0', '666909', 'c98ac20d78c01ed3f9b9c1606bd0669b', null, '', '0', null, null, '', '2011-07-05 13:04:48', '2011-07-05 13:04:49', '1', null, '11');
INSERT INTO `wlzx_system_user` VALUES ('993', '666910', '0', '666910', 'f92e655a3a73680a37a45596bcfec0b7', null, '', '0', null, null, '', '2011-07-05 13:04:49', '2011-07-05 13:04:51', '1', null, '11');
INSERT INTO `wlzx_system_user` VALUES ('994', '666913', '0', '666913', 'b1cf62af8e209d05a0fdafcddaee2251', null, '', '0', null, null, '', '2011-07-05 13:04:51', '2011-07-05 13:04:53', '1', null, '11');
INSERT INTO `wlzx_system_user` VALUES ('995', '666797', '0', '666797', '20b73aaeac6188926efdc908631cf4ef', null, '', '0', null, null, '', '2011-07-05 13:04:53', '2011-07-05 13:04:54', '1', null, '11');
INSERT INTO `wlzx_system_user` VALUES ('996', '666992', '0', '666992', 'e0fc7fd92fb58effd58afb6834d2450c', null, '', '0', null, null, '', '2011-07-05 13:04:54', '2011-07-05 13:04:56', '1', null, '11');
INSERT INTO `wlzx_system_user` VALUES ('997', '663611', '0', '663611', 'c593a1a7eb33244e9baef66c8769eef6', null, '', '0', null, null, '', '2011-07-05 13:04:56', '2011-07-05 13:04:57', '1', null, '11');
INSERT INTO `wlzx_system_user` VALUES ('998', '665316', '0', '665316', 'e0c1b1c918bf32fd86bf4b249b784999', null, '', '0', null, null, '', '2011-07-05 13:04:57', '2011-07-05 13:04:59', '1', null, '11');
INSERT INTO `wlzx_system_user` VALUES ('999', '666928', '0', '666928', '0a1f23905bc89c3ce5f7627588aa5506', null, '', '0', null, null, '', '2011-07-05 13:04:59', '2011-07-05 13:05:00', '1', '80', '3');
INSERT INTO `wlzx_system_user` VALUES ('1000', '666915', '0', '666915', '27227d807496fdfecf34396ea708d55d', null, '', '0', null, null, '', '2011-07-05 13:05:00', '2011-07-05 13:05:02', '1', null, '11');
INSERT INTO `wlzx_system_user` VALUES ('1001', '666921', '0', '666921', '8f6c53e4a8b097b556eeae5ba98f9472', null, '', '0', null, null, '', '2011-07-05 13:05:02', '2011-07-05 13:05:04', '1', null, '11');
INSERT INTO `wlzx_system_user` VALUES ('1002', '666920', '0', '666920', 'c3f477b4403cf76b200daead6b9adda2', null, '', '0', null, null, '', '2011-07-05 13:05:04', '2011-07-05 13:05:05', '1', null, '11');
INSERT INTO `wlzx_system_user` VALUES ('1003', '666919', '0', '666919', '293567d725ba8399ed93e46ba0bda193', null, '', '0', null, null, '', '2011-07-05 13:05:05', '2011-07-05 13:05:07', '1', null, '11');
INSERT INTO `wlzx_system_user` VALUES ('1004', '561963', '0', '561963', 'dbac5d7ccc16692c49ff7908bb3f7b70', null, '', '0', null, null, 'yufeng@126.com', '2011-07-21 09:27:33', '2011-07-21 09:27:33', '1', '1', '1');
INSERT INTO `wlzx_system_user` VALUES ('1005', '561997', '0', '561997', '82972ecd5fa6a0c5d278e47255bdc3e4', null, '', '0', null, null, 'wuyuyue@126.com', '2011-07-21 09:27:33', '2011-07-21 09:27:34', '1', '15', '9');
INSERT INTO `wlzx_system_user` VALUES ('1007', '666866', '0', '666866', '4dc20b83496587d5a768d570c2a77288', null, '', '0', null, null, '', '2011-09-05 07:41:46', '2011-09-05 07:41:46', '1', '74', '1');
INSERT INTO `wlzx_system_user` VALUES ('1008', '665785', '0', '665785', '746ef56a8328645a180399206cf5fc1b', null, '', '0', null, null, '', '2011-09-05 10:36:01', '2011-09-05 10:36:01', '1', '77', '6');
INSERT INTO `wlzx_system_user` VALUES ('1009', '665311', '0', '665311', '7e6b11e3d03e1a4eb5ff690760b41ca2', null, '', '0', null, null, '', '2011-09-05 10:39:36', '2011-09-05 10:39:41', '1', '80', '3');
INSERT INTO `wlzx_system_user` VALUES ('1010', '661856', '0', '661856', '3b3f37c5dba5e75de730901c12ed75ad', null, '', '0', null, null, '', '2011-09-05 10:41:58', '2011-09-05 10:42:03', '1', '87', '13');
INSERT INTO `wlzx_system_user` VALUES ('1011', '661885', '0', '661885', '3599d81e9c55bb5bad0784ae4ac559c3', null, '', '0', null, null, '', '2011-09-05 10:43:03', '2011-09-05 10:43:04', '1', '88', '14');
INSERT INTO `wlzx_system_user` VALUES ('1012', '667111', '0', '667111', '9396482f1236888a7eb7b7825f030b82', null, '', '0', null, null, '', '2011-09-05 10:43:42', '2011-09-05 10:43:42', '1', '88', '14');
INSERT INTO `wlzx_system_user` VALUES ('1013', '662320', '0', '662320', '4c812163da8354ebbecbf4150d84f54d', null, '', '0', null, null, '', '2011-09-05 10:44:29', '2011-09-05 10:44:34', '1', '91', '17');
INSERT INTO `wlzx_system_user` VALUES ('1014', '661591', '0', '661591', 'f735dc340556e8c226b5811b250796c7', null, '', '0', null, null, '', '2011-09-05 10:45:06', '2011-09-05 10:45:06', '1', '91', '17');
INSERT INTO `wlzx_system_user` VALUES ('1015', '663010', '0', '663010', '0ca331488c8ba515c21b869a29bc79d5', null, '', '0', null, null, '', '2011-09-05 10:45:48', '2011-09-05 10:45:48', '1', '93', '19');
