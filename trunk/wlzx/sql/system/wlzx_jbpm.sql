-- phpMyAdmin SQL Dump
-- version 3.3.3
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2012 年 02 月 04 日 09:32
-- 服务器版本: 5.0.91
-- PHP 版本: 5.2.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `wlzx_jbpm`
--

-- --------------------------------------------------------

--
-- 表的结构 `jbpm4_deployment`
--

CREATE TABLE IF NOT EXISTS `jbpm4_deployment` (
  `DBID_` bigint(20) NOT NULL,
  `NAME_` longtext,
  `TIMESTAMP_` bigint(20) default NULL,
  `STATE_` varchar(255) default NULL,
  PRIMARY KEY  (`DBID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `jbpm4_deployment`
--


-- --------------------------------------------------------

--
-- 表的结构 `jbpm4_deployprop`
--

CREATE TABLE IF NOT EXISTS `jbpm4_deployprop` (
  `DBID_` bigint(20) NOT NULL,
  `DEPLOYMENT_` bigint(20) default NULL,
  `OBJNAME_` varchar(255) default NULL,
  `KEY_` varchar(255) default NULL,
  `STRINGVAL_` varchar(255) default NULL,
  `LONGVAL_` bigint(20) default NULL,
  PRIMARY KEY  (`DBID_`),
  KEY `IDX_DEPLPROP_DEPL` (`DEPLOYMENT_`),
  KEY `FK_DEPLPROP_DEPL` (`DEPLOYMENT_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `jbpm4_deployprop`
--


-- --------------------------------------------------------

--
-- 表的结构 `jbpm4_execution`
--

CREATE TABLE IF NOT EXISTS `jbpm4_execution` (
  `DBID_` bigint(20) NOT NULL,
  `CLASS_` varchar(255) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `ACTIVITYNAME_` varchar(255) default NULL,
  `PROCDEFID_` varchar(255) default NULL,
  `HASVARS_` bit(1) default NULL,
  `NAME_` varchar(255) default NULL,
  `KEY_` varchar(255) default NULL,
  `ID_` varchar(255) default NULL,
  `STATE_` varchar(255) default NULL,
  `SUSPHISTSTATE_` varchar(255) default NULL,
  `PRIORITY_` int(11) default NULL,
  `HISACTINST_` bigint(20) default NULL,
  `PARENT_` bigint(20) default NULL,
  `INSTANCE_` bigint(20) default NULL,
  `SUPEREXEC_` bigint(20) default NULL,
  `SUBPROCINST_` bigint(20) default NULL,
  `PARENT_IDX_` int(11) default NULL,
  PRIMARY KEY  (`DBID_`),
  UNIQUE KEY `ID_` (`ID_`),
  KEY `IDX_EXEC_SUBPI` (`SUBPROCINST_`),
  KEY `IDX_EXEC_PARENT` (`PARENT_`),
  KEY `IDX_EXEC_SUPEREXEC` (`SUPEREXEC_`),
  KEY `IDX_EXEC_INSTANCE` (`INSTANCE_`),
  KEY `FK_EXEC_SUBPI` (`SUBPROCINST_`),
  KEY `FK_EXEC_INSTANCE` (`INSTANCE_`),
  KEY `FK_EXEC_SUPEREXEC` (`SUPEREXEC_`),
  KEY `FK_EXEC_PARENT` (`PARENT_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `jbpm4_execution`
--


-- --------------------------------------------------------

--
-- 表的结构 `jbpm4_hist_actinst`
--

CREATE TABLE IF NOT EXISTS `jbpm4_hist_actinst` (
  `DBID_` bigint(20) NOT NULL,
  `CLASS_` varchar(255) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `HPROCI_` bigint(20) default NULL,
  `TYPE_` varchar(255) default NULL,
  `EXECUTION_` varchar(255) default NULL,
  `ACTIVITY_NAME_` varchar(255) default NULL,
  `START_` datetime default NULL,
  `END_` datetime default NULL,
  `DURATION_` bigint(20) default NULL,
  `TRANSITION_` varchar(255) default NULL,
  `NEXTIDX_` int(11) default NULL,
  `HTASK_` bigint(20) default NULL,
  PRIMARY KEY  (`DBID_`),
  KEY `IDX_HTI_HTASK` (`HTASK_`),
  KEY `IDX_HACTI_HPROCI` (`HPROCI_`),
  KEY `FK_HACTI_HPROCI` (`HPROCI_`),
  KEY `FK_HTI_HTASK` (`HTASK_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `jbpm4_hist_actinst`
--


-- --------------------------------------------------------

--
-- 表的结构 `jbpm4_hist_detail`
--

CREATE TABLE IF NOT EXISTS `jbpm4_hist_detail` (
  `DBID_` bigint(20) NOT NULL,
  `CLASS_` varchar(255) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `USERID_` varchar(255) default NULL,
  `TIME_` datetime default NULL,
  `HPROCI_` bigint(20) default NULL,
  `HPROCIIDX_` int(11) default NULL,
  `HACTI_` bigint(20) default NULL,
  `HACTIIDX_` int(11) default NULL,
  `HTASK_` bigint(20) default NULL,
  `HTASKIDX_` int(11) default NULL,
  `HVAR_` bigint(20) default NULL,
  `HVARIDX_` int(11) default NULL,
  `MESSAGE_` longtext,
  `OLD_STR_` varchar(255) default NULL,
  `NEW_STR_` varchar(255) default NULL,
  `OLD_INT_` int(11) default NULL,
  `NEW_INT_` int(11) default NULL,
  `OLD_TIME_` datetime default NULL,
  `NEW_TIME_` datetime default NULL,
  `PARENT_` bigint(20) default NULL,
  `PARENT_IDX_` int(11) default NULL,
  PRIMARY KEY  (`DBID_`),
  KEY `IDX_HDET_HVAR` (`HVAR_`),
  KEY `IDX_HDET_HACTI` (`HACTI_`),
  KEY `IDX_HDET_HTASK` (`HTASK_`),
  KEY `IDX_HDET_HPROCI` (`HPROCI_`),
  KEY `FK_HDETAIL_HVAR` (`HVAR_`),
  KEY `FK_HDETAIL_HPROCI` (`HPROCI_`),
  KEY `FK_HDETAIL_HTASK` (`HTASK_`),
  KEY `FK_HDETAIL_HACTI` (`HACTI_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `jbpm4_hist_detail`
--


-- --------------------------------------------------------

--
-- 表的结构 `jbpm4_hist_procinst`
--

CREATE TABLE IF NOT EXISTS `jbpm4_hist_procinst` (
  `DBID_` bigint(20) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `ID_` varchar(255) default NULL,
  `PROCDEFID_` varchar(255) default NULL,
  `KEY_` varchar(255) default NULL,
  `START_` datetime default NULL,
  `END_` datetime default NULL,
  `DURATION_` bigint(20) default NULL,
  `STATE_` varchar(255) default NULL,
  `ENDACTIVITY_` varchar(255) default NULL,
  `NEXTIDX_` int(11) default NULL,
  PRIMARY KEY  (`DBID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `jbpm4_hist_procinst`
--


-- --------------------------------------------------------

--
-- 表的结构 `jbpm4_hist_task`
--

CREATE TABLE IF NOT EXISTS `jbpm4_hist_task` (
  `DBID_` bigint(20) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `EXECUTION_` varchar(255) default NULL,
  `OUTCOME_` varchar(255) default NULL,
  `ASSIGNEE_` varchar(255) default NULL,
  `PRIORITY_` int(11) default NULL,
  `STATE_` varchar(255) default NULL,
  `CREATE_` datetime default NULL,
  `END_` datetime default NULL,
  `DURATION_` bigint(20) default NULL,
  `NEXTIDX_` int(11) default NULL,
  `SUPERTASK_` bigint(20) default NULL,
  PRIMARY KEY  (`DBID_`),
  KEY `IDX_HSUPERT_SUB` (`SUPERTASK_`),
  KEY `FK_HSUPERT_SUB` (`SUPERTASK_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `jbpm4_hist_task`
--


-- --------------------------------------------------------

--
-- 表的结构 `jbpm4_hist_var`
--

CREATE TABLE IF NOT EXISTS `jbpm4_hist_var` (
  `DBID_` bigint(20) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `PROCINSTID_` varchar(255) default NULL,
  `EXECUTIONID_` varchar(255) default NULL,
  `VARNAME_` varchar(255) default NULL,
  `VALUE_` varchar(255) default NULL,
  `HPROCI_` bigint(20) default NULL,
  `HTASK_` bigint(20) default NULL,
  PRIMARY KEY  (`DBID_`),
  KEY `IDX_HVAR_HTASK` (`HTASK_`),
  KEY `IDX_HVAR_HPROCI` (`HPROCI_`),
  KEY `FK_HVAR_HPROCI` (`HPROCI_`),
  KEY `FK_HVAR_HTASK` (`HTASK_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `jbpm4_hist_var`
--


-- --------------------------------------------------------

--
-- 表的结构 `jbpm4_id_group`
--

CREATE TABLE IF NOT EXISTS `jbpm4_id_group` (
  `DBID_` bigint(20) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `ID_` varchar(255) default NULL,
  `NAME_` varchar(255) default NULL,
  `TYPE_` varchar(255) default NULL,
  `PARENT_` bigint(20) default NULL,
  PRIMARY KEY  (`DBID_`),
  KEY `IDX_GROUP_PARENT` (`PARENT_`),
  KEY `FK_GROUP_PARENT` (`PARENT_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `jbpm4_id_group`
--


-- --------------------------------------------------------

--
-- 表的结构 `jbpm4_id_membership`
--

CREATE TABLE IF NOT EXISTS `jbpm4_id_membership` (
  `DBID_` bigint(20) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `USER_` bigint(20) default NULL,
  `GROUP_` bigint(20) default NULL,
  `NAME_` varchar(255) default NULL,
  PRIMARY KEY  (`DBID_`),
  KEY `IDX_MEM_GROUP` (`GROUP_`),
  KEY `IDX_MEM_USER` (`USER_`),
  KEY `FK_MEM_GROUP` (`GROUP_`),
  KEY `FK_MEM_USER` (`USER_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `jbpm4_id_membership`
--


-- --------------------------------------------------------

--
-- 表的结构 `jbpm4_id_user`
--

CREATE TABLE IF NOT EXISTS `jbpm4_id_user` (
  `DBID_` bigint(20) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `ID_` varchar(255) default NULL,
  `PASSWORD_` varchar(255) default NULL,
  `GIVENNAME_` varchar(255) default NULL,
  `FAMILYNAME_` varchar(255) default NULL,
  `BUSINESSEMAIL_` varchar(255) default NULL,
  PRIMARY KEY  (`DBID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `jbpm4_id_user`
--


-- --------------------------------------------------------

--
-- 表的结构 `jbpm4_job`
--

CREATE TABLE IF NOT EXISTS `jbpm4_job` (
  `DBID_` bigint(20) NOT NULL,
  `CLASS_` varchar(255) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `DUEDATE_` datetime default NULL,
  `STATE_` varchar(255) default NULL,
  `ISEXCLUSIVE_` bit(1) default NULL,
  `LOCKOWNER_` varchar(255) default NULL,
  `LOCKEXPTIME_` datetime default NULL,
  `EXCEPTION_` longtext,
  `RETRIES_` int(11) default NULL,
  `PROCESSINSTANCE_` bigint(20) default NULL,
  `EXECUTION_` bigint(20) default NULL,
  `CFG_` bigint(20) default NULL,
  `SIGNAL_` varchar(255) default NULL,
  `EVENT_` varchar(255) default NULL,
  `REPEAT_` varchar(255) default NULL,
  PRIMARY KEY  (`DBID_`),
  KEY `IDX_JOBRETRIES` (`RETRIES_`),
  KEY `IDX_JOBDUEDATE` (`DUEDATE_`),
  KEY `IDX_JOBLOCKEXP` (`LOCKEXPTIME_`),
  KEY `IDX_JOB_CFG` (`CFG_`),
  KEY `IDX_JOB_EXE` (`EXECUTION_`),
  KEY `IDX_JOB_PRINST` (`PROCESSINSTANCE_`),
  KEY `FK_JOB_CFG` (`CFG_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `jbpm4_job`
--


-- --------------------------------------------------------

--
-- 表的结构 `jbpm4_lob`
--

CREATE TABLE IF NOT EXISTS `jbpm4_lob` (
  `DBID_` bigint(20) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `BLOB_VALUE_` longblob,
  `DEPLOYMENT_` bigint(20) default NULL,
  `NAME_` longtext,
  PRIMARY KEY  (`DBID_`),
  KEY `IDX_LOB_DEPLOYMENT` (`DEPLOYMENT_`),
  KEY `FK_LOB_DEPLOYMENT` (`DEPLOYMENT_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `jbpm4_lob`
--


-- --------------------------------------------------------

--
-- 表的结构 `jbpm4_participation`
--

CREATE TABLE IF NOT EXISTS `jbpm4_participation` (
  `DBID_` bigint(20) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `GROUPID_` varchar(255) default NULL,
  `USERID_` varchar(255) default NULL,
  `TYPE_` varchar(255) default NULL,
  `TASK_` bigint(20) default NULL,
  `SWIMLANE_` bigint(20) default NULL,
  PRIMARY KEY  (`DBID_`),
  KEY `IDX_PART_TASK` (`TASK_`),
  KEY `FK_PART_SWIMLANE` (`SWIMLANE_`),
  KEY `FK_PART_TASK` (`TASK_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `jbpm4_participation`
--


-- --------------------------------------------------------

--
-- 表的结构 `jbpm4_property`
--

CREATE TABLE IF NOT EXISTS `jbpm4_property` (
  `KEY_` varchar(255) NOT NULL,
  `VERSION_` int(11) NOT NULL,
  `VALUE_` varchar(255) default NULL,
  PRIMARY KEY  (`KEY_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `jbpm4_property`
--

INSERT INTO `jbpm4_property` (`KEY_`, `VERSION_`, `VALUE_`) VALUES
('next.dbid', 1, '10001');

-- --------------------------------------------------------

--
-- 表的结构 `jbpm4_swimlane`
--

CREATE TABLE IF NOT EXISTS `jbpm4_swimlane` (
  `DBID_` bigint(20) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `NAME_` varchar(255) default NULL,
  `ASSIGNEE_` varchar(255) default NULL,
  `EXECUTION_` bigint(20) default NULL,
  PRIMARY KEY  (`DBID_`),
  KEY `IDX_SWIMLANE_EXEC` (`EXECUTION_`),
  KEY `FK_SWIMLANE_EXEC` (`EXECUTION_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `jbpm4_swimlane`
--


-- --------------------------------------------------------

--
-- 表的结构 `jbpm4_task`
--

CREATE TABLE IF NOT EXISTS `jbpm4_task` (
  `DBID_` bigint(20) NOT NULL,
  `CLASS_` char(1) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `NAME_` varchar(255) default NULL,
  `DESCR_` longtext,
  `STATE_` varchar(255) default NULL,
  `SUSPHISTSTATE_` varchar(255) default NULL,
  `ASSIGNEE_` varchar(255) default NULL,
  `FORM_` varchar(255) default NULL,
  `PRIORITY_` int(11) default NULL,
  `CREATE_` datetime default NULL,
  `DUEDATE_` datetime default NULL,
  `PROGRESS_` int(11) default NULL,
  `SIGNALLING_` bit(1) default NULL,
  `EXECUTION_ID_` varchar(255) default NULL,
  `ACTIVITY_NAME_` varchar(255) default NULL,
  `HASVARS_` bit(1) default NULL,
  `SUPERTASK_` bigint(20) default NULL,
  `EXECUTION_` bigint(20) default NULL,
  `PROCINST_` bigint(20) default NULL,
  `SWIMLANE_` bigint(20) default NULL,
  `TASKDEFNAME_` varchar(255) default NULL,
  PRIMARY KEY  (`DBID_`),
  KEY `IDX_TASK_SUPERTASK` (`SUPERTASK_`),
  KEY `FK_TASK_SWIML` (`SWIMLANE_`),
  KEY `FK_TASK_SUPERTASK` (`SUPERTASK_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `jbpm4_task`
--


-- --------------------------------------------------------

--
-- 表的结构 `jbpm4_variable`
--

CREATE TABLE IF NOT EXISTS `jbpm4_variable` (
  `DBID_` bigint(20) NOT NULL,
  `CLASS_` varchar(255) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `KEY_` varchar(255) default NULL,
  `CONVERTER_` varchar(255) default NULL,
  `HIST_` bit(1) default NULL,
  `EXECUTION_` bigint(20) default NULL,
  `TASK_` bigint(20) default NULL,
  `LOB_` bigint(20) default NULL,
  `DATE_VALUE_` datetime default NULL,
  `DOUBLE_VALUE_` double default NULL,
  `CLASSNAME_` varchar(255) default NULL,
  `LONG_VALUE_` bigint(20) default NULL,
  `STRING_VALUE_` varchar(255) default NULL,
  `TEXT_VALUE_` longtext,
  `EXESYS_` bigint(20) default NULL,
  PRIMARY KEY  (`DBID_`),
  KEY `IDX_VAR_EXESYS` (`EXESYS_`),
  KEY `IDX_VAR_TASK` (`TASK_`),
  KEY `IDX_VAR_EXECUTION` (`EXECUTION_`),
  KEY `IDX_VAR_LOB` (`LOB_`),
  KEY `FK_VAR_EXESYS` (`EXESYS_`),
  KEY `FK_VAR_LOB` (`LOB_`),
  KEY `FK_VAR_TASK` (`TASK_`),
  KEY `FK_VAR_EXECUTION` (`EXECUTION_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `jbpm4_variable`
--


--
-- 限制导出的表
--

--
-- 限制表 `jbpm4_deployprop`
--
ALTER TABLE `jbpm4_deployprop`
  ADD CONSTRAINT `FK_DEPLPROP_DEPL` FOREIGN KEY (`DEPLOYMENT_`) REFERENCES `jbpm4_deployment` (`DBID_`);

--
-- 限制表 `jbpm4_execution`
--
ALTER TABLE `jbpm4_execution`
  ADD CONSTRAINT `FK_EXEC_PARENT` FOREIGN KEY (`PARENT_`) REFERENCES `jbpm4_execution` (`DBID_`),
  ADD CONSTRAINT `FK_EXEC_INSTANCE` FOREIGN KEY (`INSTANCE_`) REFERENCES `jbpm4_execution` (`DBID_`),
  ADD CONSTRAINT `FK_EXEC_SUBPI` FOREIGN KEY (`SUBPROCINST_`) REFERENCES `jbpm4_execution` (`DBID_`),
  ADD CONSTRAINT `FK_EXEC_SUPEREXEC` FOREIGN KEY (`SUPEREXEC_`) REFERENCES `jbpm4_execution` (`DBID_`);

--
-- 限制表 `jbpm4_hist_actinst`
--
ALTER TABLE `jbpm4_hist_actinst`
  ADD CONSTRAINT `FK_HTI_HTASK` FOREIGN KEY (`HTASK_`) REFERENCES `jbpm4_hist_task` (`DBID_`),
  ADD CONSTRAINT `FK_HACTI_HPROCI` FOREIGN KEY (`HPROCI_`) REFERENCES `jbpm4_hist_procinst` (`DBID_`);

--
-- 限制表 `jbpm4_hist_detail`
--
ALTER TABLE `jbpm4_hist_detail`
  ADD CONSTRAINT `FK_HDETAIL_HACTI` FOREIGN KEY (`HACTI_`) REFERENCES `jbpm4_hist_actinst` (`DBID_`),
  ADD CONSTRAINT `FK_HDETAIL_HPROCI` FOREIGN KEY (`HPROCI_`) REFERENCES `jbpm4_hist_procinst` (`DBID_`),
  ADD CONSTRAINT `FK_HDETAIL_HTASK` FOREIGN KEY (`HTASK_`) REFERENCES `jbpm4_hist_task` (`DBID_`),
  ADD CONSTRAINT `FK_HDETAIL_HVAR` FOREIGN KEY (`HVAR_`) REFERENCES `jbpm4_hist_var` (`DBID_`);

--
-- 限制表 `jbpm4_hist_task`
--
ALTER TABLE `jbpm4_hist_task`
  ADD CONSTRAINT `FK_HSUPERT_SUB` FOREIGN KEY (`SUPERTASK_`) REFERENCES `jbpm4_hist_task` (`DBID_`);

--
-- 限制表 `jbpm4_hist_var`
--
ALTER TABLE `jbpm4_hist_var`
  ADD CONSTRAINT `FK_HVAR_HTASK` FOREIGN KEY (`HTASK_`) REFERENCES `jbpm4_hist_task` (`DBID_`),
  ADD CONSTRAINT `FK_HVAR_HPROCI` FOREIGN KEY (`HPROCI_`) REFERENCES `jbpm4_hist_procinst` (`DBID_`);

--
-- 限制表 `jbpm4_id_group`
--
ALTER TABLE `jbpm4_id_group`
  ADD CONSTRAINT `FK_GROUP_PARENT` FOREIGN KEY (`PARENT_`) REFERENCES `jbpm4_id_group` (`DBID_`);

--
-- 限制表 `jbpm4_id_membership`
--
ALTER TABLE `jbpm4_id_membership`
  ADD CONSTRAINT `FK_MEM_USER` FOREIGN KEY (`USER_`) REFERENCES `jbpm4_id_user` (`DBID_`),
  ADD CONSTRAINT `FK_MEM_GROUP` FOREIGN KEY (`GROUP_`) REFERENCES `jbpm4_id_group` (`DBID_`);

--
-- 限制表 `jbpm4_job`
--
ALTER TABLE `jbpm4_job`
  ADD CONSTRAINT `FK_JOB_CFG` FOREIGN KEY (`CFG_`) REFERENCES `jbpm4_lob` (`DBID_`);

--
-- 限制表 `jbpm4_lob`
--
ALTER TABLE `jbpm4_lob`
  ADD CONSTRAINT `FK_LOB_DEPLOYMENT` FOREIGN KEY (`DEPLOYMENT_`) REFERENCES `jbpm4_deployment` (`DBID_`);

--
-- 限制表 `jbpm4_participation`
--
ALTER TABLE `jbpm4_participation`
  ADD CONSTRAINT `FK_PART_TASK` FOREIGN KEY (`TASK_`) REFERENCES `jbpm4_task` (`DBID_`),
  ADD CONSTRAINT `FK_PART_SWIMLANE` FOREIGN KEY (`SWIMLANE_`) REFERENCES `jbpm4_swimlane` (`DBID_`);

--
-- 限制表 `jbpm4_swimlane`
--
ALTER TABLE `jbpm4_swimlane`
  ADD CONSTRAINT `FK_SWIMLANE_EXEC` FOREIGN KEY (`EXECUTION_`) REFERENCES `jbpm4_execution` (`DBID_`);

--
-- 限制表 `jbpm4_task`
--
ALTER TABLE `jbpm4_task`
  ADD CONSTRAINT `FK_TASK_SUPERTASK` FOREIGN KEY (`SUPERTASK_`) REFERENCES `jbpm4_task` (`DBID_`),
  ADD CONSTRAINT `FK_TASK_SWIML` FOREIGN KEY (`SWIMLANE_`) REFERENCES `jbpm4_swimlane` (`DBID_`);

--
-- 限制表 `jbpm4_variable`
--
ALTER TABLE `jbpm4_variable`
  ADD CONSTRAINT `FK_VAR_EXECUTION` FOREIGN KEY (`EXECUTION_`) REFERENCES `jbpm4_execution` (`DBID_`),
  ADD CONSTRAINT `FK_VAR_EXESYS` FOREIGN KEY (`EXESYS_`) REFERENCES `jbpm4_execution` (`DBID_`),
  ADD CONSTRAINT `FK_VAR_LOB` FOREIGN KEY (`LOB_`) REFERENCES `jbpm4_lob` (`DBID_`),
  ADD CONSTRAINT `FK_VAR_TASK` FOREIGN KEY (`TASK_`) REFERENCES `jbpm4_task` (`DBID_`);
