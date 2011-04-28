-- phpMyAdmin SQL Dump
-- version 3.3.3
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2011 年 04 月 28 日 00:15
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
(1, 'root', 0, '温岭数字化校园系列', '数字化校园信息平台是以学校现有网络为基础，以服务于全校师生的教学、科研、生活为目的，建立在学校数据中心平台之上，涵盖了学校的信息化标准管理、学校管理、学生管理、教学管理、教职工管理、科研管理、财务管理、资产与设备管理、行政办公管理、数字图书资料管理等全方位的管理信息平台与信息服务平台。', 'system/index.swf', NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(2, 'basic', 0, '基础数据系统', '基础数据系统是数字化校园所有业务应用系统的公共数据库，处于中心位置，基础数据库保持最完整、最准确的数据，提供其他业务系统使用。基础数据库管理系统实现对基础数据库所有信息库的维护管理。', 'basic/index.swf', NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(3, 'oa', 0, '办公自动化系统', '办公自动化系统以公文流转为核心，实现办公流程的快速高效；同时提供多种部门间的信息交流的手段和渠道，加强部门间的沟通协作；提供信息共享的平台，实现公共资源的共享；提供辅助办公功能，为每一项业务提供相关信息，促进学校办公的成熟和规范化；提供强大的搜索查询功能，便于用户在日积月累的海量信息中快速的查找需要的内容', 'oa/index.swf', NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04');

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `wlzx_system_data_access_mode`
--

INSERT INTO `wlzx_system_data_access_mode` (`id`, `name`, `symbol`, `sequence`, `value`, `detail`, `creation_date`, `modified_date`) VALUES
(1, '全部', 'basic_authorization_department_main_edit_deafultFilter', 0, 'NULL', NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(2, '全部', 'basic_authorization_department_main_search_deafultFilter', 0, 'NULL', NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04');

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_department`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_department` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `symbol` varchar(100) NOT NULL,
  `sequence` bigint(20) default '0',
  `detail` text,
  `creation_date` datetime NOT NULL,
  `modified_date` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `symbol` (`symbol`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='系统部门' AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `wlzx_system_department`
--

INSERT INTO `wlzx_system_department` (`id`, `name`, `symbol`, `sequence`, `detail`, `creation_date`, `modified_date`) VALUES
(1, '温岭中学', 'root', 0, NULL, '2011-04-28 00:14:05', '2011-04-28 00:14:05');

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_department_dam_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_department_dam_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `department_id` bigint(20) NOT NULL,
  `dam_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_system_department_dam_relationship`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_department_leadship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_department_leadship` (
  `id` bigint(20) NOT NULL auto_increment,
  `leader_id` bigint(20) NOT NULL,
  `subordinate_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_system_department_leadship`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_department_role_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_department_role_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `department_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_system_department_role_relationship`
--


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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=19 ;

--
-- 转存表中的数据 `wlzx_system_menu`
--

INSERT INTO `wlzx_system_menu` (`id`, `name`, `symbol`, `sequence`, `detail`, `menu_icon`, `creation_date`, `modified_date`) VALUES
(1, '系统授权', 'basic_authorization', 0, NULL, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(2, '部门授权', 'basic_authorization_department', 0, NULL, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(3, '部门角色授权', 'basic_authorization_role', 0, NULL, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(4, '基础数据', 'basic_data', 0, NULL, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(5, '员工基础数据', 'basic_data_staff', 0, NULL, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(6, '系统设置', 'basic_setting', 0, NULL, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(7, '部门设置', 'basic_setting_department', 0, NULL, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(8, '岗位设置', 'basic_setting_role', 0, NULL, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(9, '内部事务管理', 'oa_inside_affair', 0, NULL, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(10, '公文管理', 'oa_official_document', 0, NULL, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(11, '公共事务管理', 'oa_public_affair', 0, NULL, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(12, '公告管理', 'notice_manage', 0, NULL, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(13, '公告管理', 'notice_list', 0, NULL, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(14, '公告发布', 'notice_post', 0, NULL, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(15, '公告签批', 'notice_sign', 0, NULL, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(16, '日程管理', 'scheduleManage', 0, NULL, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(17, '学校管理', 'oa_school_affair', 0, NULL, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(18, '系统管理', 'oa_system_management', 0, NULL, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04');

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_menu_module_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_menu_module_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `menu_id` bigint(20) NOT NULL,
  `module_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `wlzx_system_menu_module_relationship`
--

INSERT INTO `wlzx_system_menu_module_relationship` (`id`, `menu_id`, `module_id`) VALUES
(1, 2, 1),
(2, 7, 2),
(3, 8, 3);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_menu_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_menu_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `system_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

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
(8, 3, 18);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_menu_treeship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_menu_treeship` (
  `id` bigint(20) NOT NULL auto_increment,
  `parent_id` bigint(20) NOT NULL,
  `child_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

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
(10, 12, 15);

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
  PRIMARY KEY  (`id`),
  UNIQUE KEY `symbol` (`symbol`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `wlzx_system_module`
--

INSERT INTO `wlzx_system_module` (`id`, `name`, `symbol`, `sequence`, `detail`, `creation_date`, `modified_date`, `url`) VALUES
(1, '部门授权主模块', 'basic_authorization_department_main', 0, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04', ''),
(2, '部门设置主模块', 'basic_setting_department_main', 0, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04', 'basic/setting/departmentSetting.swf'),
(3, '岗位设置主模块', 'basic_setting_role_main', 0, NULL, '2011-04-28 00:14:04', '2011-04-28 00:14:04', 'basic/setting/roleSetting.swf');

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_module_operation_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_module_operation_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `module_id` bigint(20) NOT NULL,
  `operation_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `wlzx_system_module_operation_relationship`
--

INSERT INTO `wlzx_system_module_operation_relationship` (`id`, `module_id`, `operation_id`) VALUES
(1, 1, 1),
(2, 1, 2);

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
  `detail` text,
  `url` varchar(500) NOT NULL,
  `creation_date` datetime NOT NULL,
  `modified_date` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `symbol` (`symbol`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `wlzx_system_operation`
--

INSERT INTO `wlzx_system_operation` (`id`, `name`, `symbol`, `sequence`, `detail`, `url`, `creation_date`, `modified_date`) VALUES
(1, '编辑', 'basic_authorization_department_main_edit', 0, NULL, '', '2011-04-28 00:14:04', '2011-04-28 00:14:04'),
(2, '查询', 'basic_authorization_department_main_search', 0, NULL, '', '2011-04-28 00:14:04', '2011-04-28 00:14:04');

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_operation_dam_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_operation_dam_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `operation_id` bigint(20) NOT NULL,
  `dam_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `wlzx_system_operation_dam_relationship`
--

INSERT INTO `wlzx_system_operation_dam_relationship` (`id`, `operation_id`, `dam_id`) VALUES
(1, 1, 1),
(2, 2, 2);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_role`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_role` (
  `id` bigint(20) NOT NULL auto_increment,
  `symbol` varchar(100) NOT NULL,
  `sequence` bigint(20) default '0',
  `name` varchar(50) NOT NULL,
  `detail` text,
  `creation_date` datetime NOT NULL,
  `modified_date` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  `supervisor_flag` tinyint(1) NOT NULL default '0',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `symbol` (`symbol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色' AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_system_role`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_role_dam_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_role_dam_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `role_id` bigint(20) NOT NULL,
  `dam_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_system_role_dam_relationship`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_role_leadship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_role_leadship` (
  `id` bigint(20) NOT NULL auto_increment,
  `leader_id` bigint(20) NOT NULL,
  `subordinate_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_system_role_leadship`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_system_role_user_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_system_role_user_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `role_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_system_role_user_relationship`
--


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
  `person_id` bigint(20) default NULL,
  `email` varchar(50) default NULL,
  `creation_date` datetime NOT NULL,
  `modified_date` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `symbol` (`symbol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户' AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_system_user`
--


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

