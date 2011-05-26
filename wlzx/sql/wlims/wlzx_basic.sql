-- phpMyAdmin SQL Dump
-- version 3.3.3
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2011 年 05 月 26 日 17:24
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- 转存表中的数据 `wlzx_basic_directory`
--

INSERT INTO `wlzx_basic_directory` (`id`, `name`, `value`, `type`, `sequence`, `extra_value`, `creation_date`, `modified_date`) VALUES
(5, '1111', '1111', '教学楼', 0, NULL, '2011-05-26 16:56:57', '2011-05-26 16:56:57'),
(6, '2222222', '2222222', '场所类型', 1, NULL, '2011-05-26 16:57:02', '2011-05-26 16:57:02');
