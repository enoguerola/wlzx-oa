-- phpMyAdmin SQL Dump
-- version 3.3.3
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2011 年 07 月 26 日 15:13
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
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=137 ;

--
-- 转存表中的数据 `wlzx_oa_attachment`
--

INSERT INTO `wlzx_oa_attachment` (`id`, `name`, `path`, `type`, `size`) VALUES
(8, 'button_abanden_icon.png', 'button_abanden_icon_110718050315.png', 'png', 5409),
(13, '环境信息系统设计方案-20110615.pdf', '环境信息系统设计方案-20110615_110718052021.pdf', 'pdf', 832565),
(34, '杭州池墨科技有限公司_股份制度.pdf', '杭州池墨科技有限公司_股份制度_110719012530.pdf', 'pdf', 136560),
(35, '环境信息系统设计方案-20110615.pdf', '环境信息系统设计方案-20110615_110719012530.pdf', 'pdf', 832565),
(36, '火车票预订系统 Product Backlog2.xls', '火车票预订系统 Product Backlog2_110719012530.xls', 'xls', 30720),
(37, '火车票预订系统 Product Backlog.xls', '火车票预订系统 Product Backlog_110719012530.xls', 'xls', 30208),
(38, '上海动量软件技术有限公司介绍.pdf', '上海动量软件技术有限公司介绍_110719012531.pdf', 'pdf', 1810266),
(39, '通达OA教育管理解决方案.pdf', '通达OA教育管理解决方案_110719023323.pdf', 'pdf', 1280730),
(40, 'tj.jpg', 'tj_110719023410.jpg', 'jpg', 16600),
(41, 'tj.jpg', 'tj_110719025318.jpg', 'jpg', 16600),
(42, 'tj.jpg', 'tj_110719040440.jpg', 'jpg', 16600),
(43, 'tj.jpg', 'tj_110719040859.jpg', 'jpg', 16600),
(44, '杭州池墨科技有限公司_股份制度.pdf', '杭州池墨科技有限公司_股份制度_110719045104.pdf', 'pdf', 136560),
(45, '环境信息系统设计方案-20110615.pdf', '环境信息系统设计方案-20110615_110719045104.pdf', 'pdf', 832565),
(46, '火车票预订系统 Product Backlog2.xls', '火车票预订系统 Product Backlog2_110719045105.xls', 'xls', 30720),
(47, '火车票预订系统 Product Backlog.xls', '火车票预订系统 Product Backlog_110719045105.xls', 'xls', 30208),
(48, '上海动量软件技术有限公司介绍.pdf', '上海动量软件技术有限公司介绍_110719045105.pdf', 'pdf', 1810266),
(49, 'tj.jpg', 'tj_110719053814.jpg', 'jpg', 16600),
(50, 'tj.jpg', 'tj_110719054548.jpg', 'jpg', 16600),
(51, 'tj.jpg', 'tj_110719054641.jpg', 'jpg', 16600),
(52, 'head.jpg', 'head_110719054641.jpg', 'jpg', 79088),
(53, '撤销图标.png', '撤销图标_110719054642.png', 'png', 3920),
(54, '窗口形式图标.png', '窗口形式图标_110719054642.png', 'png', 2927),
(55, '关闭图标.png', '关闭图标_110719054642.png', 'png', 3683),
(56, '黄色小勾图标.png', '黄色小勾图标_110719054642.png', 'png', 3889),
(57, '闹钟图标.png', '闹钟图标_110719054642.png', 'png', 3918),
(58, '最小化图标.png', '最小化图标_110719054642.png', 'png', 2851),
(59, 'tj.jpg', 'tj_110719054711.jpg', 'jpg', 16600),
(60, 'head.jpg', 'head_110719054711.jpg', 'jpg', 79088),
(61, '撤销图标.png', '撤销图标_110719054711.png', 'png', 3920),
(62, '窗口形式图标.png', '窗口形式图标_110719054712.png', 'png', 2927),
(63, '关闭图标.png', '关闭图标_110719054712.png', 'png', 3683),
(64, '黄色小勾图标.png', '黄色小勾图标_110719054712.png', 'png', 3889),
(65, '闹钟图标.png', '闹钟图标_110719054712.png', 'png', 3918),
(66, '最小化图标.png', '最小化图标_110719054712.png', 'png', 2851),
(67, '温岭OA测试计划.docx', '温岭OA测试计划_110719054712.docx', 'docx', 36194),
(68, '温岭OA系统BUG管理表.xls', '温岭OA系统BUG管理表_110719054713.xls', 'xls', 1268224),
(69, '温岭OA系统BUG管理表[模板].xls', '温岭OA系统BUG管理表[模板]_110719054713.xls', 'xls', 30208),
(70, 'tj.jpg', 'tj_110719054808.jpg', 'jpg', 16600),
(71, 'head.jpg', 'head_110719054808.jpg', 'jpg', 79088),
(72, '撤销图标.png', '撤销图标_110719054809.png', 'png', 3920),
(73, '窗口形式图标.png', '窗口形式图标_110719054809.png', 'png', 2927),
(74, '关闭图标.png', '关闭图标_110719054809.png', 'png', 3683),
(75, '黄色小勾图标.png', '黄色小勾图标_110719054809.png', 'png', 3889),
(76, '闹钟图标.png', '闹钟图标_110719054809.png', 'png', 3918),
(77, '最小化图标.png', '最小化图标_110719054809.png', 'png', 2851),
(78, '温岭OA测试计划.docx', '温岭OA测试计划_110719054809.docx', 'docx', 36194),
(79, '温岭OA系统BUG管理表.xls', '温岭OA系统BUG管理表_110719054809.xls', 'xls', 1268224),
(80, '温岭OA系统BUG管理表[模板].xls', '温岭OA系统BUG管理表[模板]_110719054809.xls', 'xls', 30208),
(81, '杭州池墨科技有限公司_股份制度.pdf', '杭州池墨科技有限公司_股份制度_110719060433.pdf', 'pdf', 136560),
(82, '环境信息系统设计方案-20110615.pdf', '环境信息系统设计方案-20110615_110719060433.pdf', 'pdf', 832565),
(83, '火车票预订系统 Product Backlog2.xls', '火车票预订系统 Product Backlog2_110719060434.xls', 'xls', 30720),
(84, '火车票预订系统 Product Backlog.xls', '火车票预订系统 Product Backlog_110719060434.xls', 'xls', 30208),
(85, '上海动量软件技术有限公司介绍.pdf', '上海动量软件技术有限公司介绍_110719060434.pdf', 'pdf', 1810266),
(86, 'tj.jpg', 'tj_110719060522.jpg', 'jpg', 16600),
(87, 'tj.jpg', 'tj_110719061042.jpg', 'jpg', 16600),
(88, 'tj.jpg', 'tj_110719061104.jpg', 'jpg', 16600),
(89, '杭州池墨科技有限公司_股份制度.pdf', '杭州池墨科技有限公司_股份制度_110719061104.pdf', 'pdf', 136560),
(90, '环境信息系统设计方案-20110615.pdf', '环境信息系统设计方案-20110615_110719061104.pdf', 'pdf', 832565),
(91, '火车票预订系统 Product Backlog2.xls', '火车票预订系统 Product Backlog2_110719061104.xls', 'xls', 30720),
(92, '火车票预订系统 Product Backlog.xls', '火车票预订系统 Product Backlog_110719061104.xls', 'xls', 30208),
(93, '上海动量软件技术有限公司介绍.pdf', '上海动量软件技术有限公司介绍_110719061104.pdf', 'pdf', 1810266),
(94, 'download.png', 'download_110719061817.png', 'png', 1349),
(95, 'printer.png', 'printer_110719061817.png', 'png', 1485),
(96, 'tj.jpg', 'tj_110720092412.jpg', 'jpg', 16600),
(97, '环境信息系统设计方案-20110615.pdf', '环境信息系统设计方案-20110615_110720092423.pdf', 'pdf', 832565),
(98, '火车票预订系统 Product Backlog2.xls', '火车票预订系统 Product Backlog2_110720092423.xls', 'xls', 30720),
(99, '火车票预订系统 Product Backlog.xls', '火车票预订系统 Product Backlog_110720092423.xls', 'xls', 30208),
(100, '上海动量软件技术有限公司介绍.pdf', '上海动量软件技术有限公司介绍_110720092423.pdf', 'pdf', 1810266),
(101, 'tj.jpg', 'tj_110720092440.jpg', 'jpg', 16600),
(102, '环境信息系统设计方案-20110615.pdf', '环境信息系统设计方案-20110615_110720092440.pdf', 'pdf', 832565),
(103, '火车票预订系统 Product Backlog2.xls', '火车票预订系统 Product Backlog2_110720092440.xls', 'xls', 30720),
(104, '火车票预订系统 Product Backlog.xls', '火车票预订系统 Product Backlog_110720092440.xls', 'xls', 30208),
(105, '上海动量软件技术有限公司介绍.pdf', '上海动量软件技术有限公司介绍_110720092440.pdf', 'pdf', 1810266),
(106, '通达OA教育管理解决方案.pdf', '通达OA教育管理解决方案_110720092440.pdf', 'pdf', 1280730),
(107, 'tj.jpg', 'tj_110720092546.jpg', 'jpg', 16600),
(108, '环境信息系统设计方案-20110615.pdf', '环境信息系统设计方案-20110615_110720092546.pdf', 'pdf', 832565),
(109, '火车票预订系统 Product Backlog2.xls', '火车票预订系统 Product Backlog2_110720092546.xls', 'xls', 30720),
(110, '火车票预订系统 Product Backlog.xls', '火车票预订系统 Product Backlog_110720092546.xls', 'xls', 30208),
(111, '上海动量软件技术有限公司介绍.pdf', '上海动量软件技术有限公司介绍_110720092546.pdf', 'pdf', 1810266),
(112, '通达OA教育管理解决方案.pdf', '通达OA教育管理解决方案_110720092546.pdf', 'pdf', 1280730),
(113, '杭州池墨科技有限公司_股份制度.pdf', '杭州池墨科技有限公司_股份制度_110720092756.pdf', 'pdf', 136560),
(114, '环境信息系统设计方案-20110615.pdf', '环境信息系统设计方案-20110615_110720092756.pdf', 'pdf', 832565),
(115, '火车票预订系统 Product Backlog2.xls', '火车票预订系统 Product Backlog2_110720092756.xls', 'xls', 30720),
(116, '火车票预订系统 Product Backlog.xls', '火车票预订系统 Product Backlog_110720092756.xls', 'xls', 30208),
(117, '上海动量软件技术有限公司介绍.pdf', '上海动量软件技术有限公司介绍_110720092756.pdf', 'pdf', 1810266),
(118, '杭州池墨科技有限公司_股份制度.pdf', '杭州池墨科技有限公司_股份制度_110720093024.pdf', 'pdf', 136560),
(119, '环境信息系统设计方案-20110615.pdf', '环境信息系统设计方案-20110615_110720093025.pdf', 'pdf', 832565),
(120, '火车票预订系统 Product Backlog2.xls', '火车票预订系统 Product Backlog2_110720093025.xls', 'xls', 30720),
(121, '火车票预订系统 Product Backlog.xls', '火车票预订系统 Product Backlog_110720093025.xls', 'xls', 30208),
(122, '上海动量软件技术有限公司介绍.pdf', '上海动量软件技术有限公司介绍_110720093025.pdf', 'pdf', 1810266),
(123, 'tj.jpg', 'tj_110720093359.jpg', 'jpg', 16600),
(124, 'tj.jpg', 'tj_110720093441.jpg', 'jpg', 16600),
(125, '杭州池墨科技有限公司_股份制度.pdf', '杭州池墨科技有限公司_股份制度_110720093459.pdf', 'pdf', 136560),
(126, '环境信息系统设计方案-20110615.pdf', '环境信息系统设计方案-20110615_110720093459.pdf', 'pdf', 832565),
(127, '火车票预订系统 Product Backlog2.xls', '火车票预订系统 Product Backlog2_110720093459.xls', 'xls', 30720),
(128, '火车票预订系统 Product Backlog.xls', '火车票预订系统 Product Backlog_110720093459.xls', 'xls', 30208),
(129, '上海动量软件技术有限公司介绍.pdf', '上海动量软件技术有限公司介绍_110720093459.pdf', 'pdf', 1810266),
(130, '杭州池墨科技有限公司_股份制度.pdf', '杭州池墨科技有限公司_股份制度_110720093542.pdf', 'pdf', 136560),
(131, '环境信息系统设计方案-20110615.pdf', '环境信息系统设计方案-20110615_110720093543.pdf', 'pdf', 832565),
(132, '火车票预订系统 Product Backlog2.xls', '火车票预订系统 Product Backlog2_110720093543.xls', 'xls', 30720),
(133, '火车票预订系统 Product Backlog.xls', '火车票预订系统 Product Backlog_110720093543.xls', 'xls', 30208),
(134, '上海动量软件技术有限公司介绍.pdf', '上海动量软件技术有限公司介绍_110720093543.pdf', 'pdf', 1810266),
(135, 'tj.jpg', 'tj_110722121538.jpg', 'jpg', 16600),
(136, 'tj.jpg', 'tj_110722122122.jpg', 'jpg', 16600);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- 转存表中的数据 `wlzx_oa_conference`
--

INSERT INTO `wlzx_oa_conference` (`id`, `name`, `date`, `time_begin`, `time_end`, `attend_num`, `teacher_attend_ids`, `department_id`, `place_id`, `contact_user_id`, `contact_phone_number`, `service_needed`, `description`, `apply_user_id`, `apply_time`, `apply_status`) VALUES
(1, '关于90周年党庆活动', '2011-07-01', '10:00', '11:00', 10, '708;709;710;711;712;713;714;715;716;717;718;719;720;721;722;723;724;725;726;727;728;729;730;731;732;733;734;735;736;737;738;739;740;741;742;743;744;745;746;747;748;749;750;751;752;753;754;755;756;757;758;759;760;761;762;763;764;765;766;767;768;769;770;771;772;773;774;775;776;777;778;779;780;781;782;783;784;785;786;787;788;789;790;791;792;793;794;795;796;797;798;799;800;801;802;803;804;805;806;807;808;809;810;811;812;813;814;815;816;817;818;819;820;821;822;823;824;825;826;827;828;829;830;831;832;833;834;835;836;837;838;839;840;841;842;843;844;845;846;847;848;849;850;851;852;853;854;855;856;857;858;859;860;861;862;863;864;865;866;867;868;869;870;871;872;873;874;875;876;877;878;879;880;881;882;883;884;885;886;887;888;889;890;891;892;893;894;895;896;897;898;899;900;901;902;903;904;905;906;907;908;909;910;911;912;913;914;915;916;917;918;919;920;921;922;923;924;925;926;927;928;929;930;931;932;933;934;935;936;937;938;939;940;941;942;943;944;945;946;947;948;949;950;951;952;953;954;955;956;957;958;959;960;961;962;963;964;965;966;967;968;969;970;971;972;973;974;975;976;977;978;979;980;981;982;983;984;985;986;987;988;989;990;991;992;993;994;995;996;997;998;999;1000;1001;1002;1003;', 1, 1, 708, '111', '茶水，横幅', '关于90周年党庆活动行程', 1, '2011-07-08 17:15:57', 3),
(3, '333333', '2011-07-09', '18:00', '20:00', 3, '708;709;710;711;', 3, 1, 739, '333333333', '23', '3432', 1, '2011-07-09 15:01:19', 3),
(4, '1', '2011-07-09', '00:00', '10:00', 1, '708;', -1, 1, 708, '1', '1', '1', 1, '2011-07-09 16:47:46', 2),
(5, '999999999999', '2011-07-09', '13:00', '14:00', 1, '708;', -1, 1, 708, '2', '2', '2', 1, '2011-07-09 16:52:06', 3),
(6, '4', '2011-07-11', '08:00', '10:00', 4, '709;', -1, 1, 708, '4', '4', '4', 1, '2011-07-11 09:48:27', 3),
(7, '6', '2011-07-11', '07:00', '08:00', 5, '710;', -1, 1, 840, '5', '5', '5', 1, '2011-07-11 10:00:05', 3),
(8, '7', '2011-07-12', '07:00', '08:00', 7, '711;', -1, 1, 792, '7', '7', '7', 1, '2011-07-11 10:03:52', 3),
(9, '11111', '2011-07-16', '07:00', '08:00', 2, '708;709;', -1, 1, 739, '11', '111111', '2222', 1, '2011-07-16 11:35:09', 1),
(10, 'aaaaaaaa', '2011-07-15', '10:00', '13:00', 2, '710;', -1, 1, 727, '2222222222', '22222', '222222', 708, '2011-07-16 13:02:42', 3);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_conference_attachment_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_conference_attachment_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `conference_id` bigint(20) NOT NULL,
  `attachment_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=96 ;

--
-- 转存表中的数据 `wlzx_oa_conference_attachment_relationship`
--

INSERT INTO `wlzx_oa_conference_attachment_relationship` (`id`, `conference_id`, `attachment_id`) VALUES
(93, 9, 39),
(94, 9, 38),
(95, 9, 43);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `wlzx_oa_course_adjust_apply`
--

INSERT INTO `wlzx_oa_course_adjust_apply` (`id`, `apply_no`, `apply_type`, `apply_teacher_id`, `apply_reason`, `apply_status`, `approve_teacher_id`, `approve_remark`, `approve_date`, `apply_creation_date`) VALUES
(1, '20110706173203', 0, 1, '学习～～～～～～～～～', 0, NULL, NULL, NULL, '2011-07-06 17:32:03'),
(2, '20110706174315', 1, 1, '结婚', 2, 1, '不同意', '2011-07-06 18:08:56', '2011-07-06 17:43:15'),
(3, '20110706175324', 0, 1, '出差', 1, 1, '同意', '2011-07-06 18:14:35', '2011-07-06 17:53:24');

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `wlzx_oa_course_adjust_apply_item`
--

INSERT INTO `wlzx_oa_course_adjust_apply_item` (`id`, `apply_id`, `apply_class`, `apply_course`, `apply_course_date`, `apply_course_time`, `adjust_mean_date`, `adjust_mean_teacher_id`, `adjust_actual_date`, `adjust_actual_time`, `adjust_actual_teacher_id`) VALUES
(1, 1, '高二12班', '语文', '2011-07-14 00:00:00', '第一节 第二节 ', '2011-07-14 00:00:00', 722, NULL, NULL, NULL),
(2, 2, '高一1班', '物理', '2011-07-07 00:00:00', '第二节 第三节 ', '2011-07-21 00:00:00', 715, '2011-07-21 00:00:00', '第一节 第二节 ', 715),
(3, 3, '高三10班', '语文', '2011-07-14 00:00:00', '第四节 第五节 ', '2011-07-14 00:00:00', 708, '2011-07-14 00:00:00', '第四节 第五节 ', 708);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=18 ;

--
-- 转存表中的数据 `wlzx_oa_notice`
--

INSERT INTO `wlzx_oa_notice` (`id`, `scope`, `type`, `post_department_id`, `poster_id`, `emergence_flag`, `title`, `content`, `postTime`, `last_edit_time`, `last_editor_id`, `status`) VALUES
(4, 1, '重要通知', 1, 708, 0, '111111111111', '2222222222222222222', '2011-07-15 15:35:39', '2011-07-15 15:35:32', 708, 1),
(5, 1, '其他', 1, 708, 1, '1', '2', '2011-07-16 10:39:35', '2011-07-16 10:35:27', 708, 1),
(6, 0, '其他', 1, 708, 0, '鲁大师 ', '--------[ 鲁大师 ]--------------------------------------------------------------------------------\r\r  软件:             鲁大师 2.85.11.707\r  时间:             2011-7-14 23:17:33\r  网站:             http://www.ludashi.com\r\r--------[ 概览 ]----------------------------------------------------------------------------------\r\r  电脑型号          微星 MS-7512 台式电脑\r  操作系统          Windows XP 专业版 32位 SP2 ( DirectX 9.0c )\r\r  处理器            英特尔 酷睿2 四核 Q8400 @ 2.66GHz\r  主板              微星 P45 Neo2-FR (MS-7512) (英特尔 4 Series 芯片组 - ICH10R)\r  内存              4 GB ( 金士顿 DDR2 800MHz )\r  主硬盘            西数 WDC WD10EVDS-63U8B0 ( 1 TB / 7200 转/分 )\r  显卡              Nvidia GeForce GTX 460 ( 1 GB / Nvidia )\r  显示器            LG GSM5705 C222W ( 23 英寸 )\r  光驱              日立-LG DVDROM DH16NS30 DVD光驱\r  声卡              瑞昱 ALC888 @ 英特尔 ICH10 高保真音频\r  网卡              瑞昱 RTL8168C(P)/8111C(P) PCI-E Gigabit Ethernet NIC / 微星\r \r--------[ 主板 ]----------------------------------------------------------------------------------\r\r  主板型号          微星 P45 Neo2-FR (MS-7512)\r  芯片组            英特尔 4 Series 芯片组 - ICH10R\r  板载设备          视频设备 (启用)\r  BIOS              American Megatrends Inc. V3.4\r  制造日期          03/09/2009\r \r--------[ 处理器 ]--------------------------------------------------------------------------------\r\r  处理器            英特尔 酷睿2 四核 Q8400 @ 2.66GHz\r  速度              2.67 GHz (333 MHz x 8.0) / 前端总线: 1333 MHz\r  处理器数量        核心数: 4 / 线程数: 4\r  核心代号          Yorkfield\r  生产工艺          45 纳米\r  插槽/插座         Socket 775 (FC-LGA6)\r  一级数据缓存      4 x 32 KB, 8-Way, 64 byte lines\r  一级代码缓存      4 x 32 KB, 8-Way, 64 byte lines\r  二级缓存          2 x 2 MB, 8-Way, 64 byte lines (速度: 2673 MHz)\r  特征              MMX, SSE, SSE2, SSE3, SSSE3, SSE4.1, EM64T, EIST\r \r--------[ 硬盘 ]----------------------------------------------------------------------------------\r\r  产品              西数 WDC WD10EVDS-63U8B0 (绿盘)\r  大小              1 TB\r  转速              7200 转/分\r  缓存              32767 KB\r  硬盘已使用        共 554 次，累计 2909 小时\r  固件              01.00A01\r  接口              SATA Rev 2.5\r  数据传输率        300 MB/秒\r  特征              S.M.A.R.T,  APM,  48-bit LBA,  NCQ\r\r--------[ 内存 ]----------------------------------------------------------------------------------\r\r  DIMM 0:           金士顿 DDR2 800MHz 2GB\r  型号              7F98 2G-UDIMM\r  序列号:           921879D6\r  模块位宽:         64 Bits\r  模块电压:         SSTL 1.8V\r\r  DIMM 2:           金士顿 DDR2 800MHz 2GB\r  型号              7F98 2G-UDIMM\r  序列号:           500222AD\r  模块位宽:         64 Bits\r  模块电压:         SSTL 1.8V\r\r--------[ 显卡 ]----------------------------------------------------------------------------------\r\r  主显卡            Nvidia GeForce GTX 460\r  显存              1 GB\r  制造商            Nvidia\r  BIOS版本          Version 70.04.13.00.01\r  BIOS日期          07/06/10\r  驱动版本          6.14.12.5856\r  驱动日期          20100614\r\r--------[ 显示器 ]--------------------------------------------------------------------------------\r\r  产品              LG GSM5705 C222W\r  制造日期          2010 年 01 月\r  屏幕尺寸          23 英寸 (49 厘米 x 32 厘米)\r  显示比例          宽屏 16 : 10\r  分辨率            1680 x 1050 32 位真彩色\r  Gamma             2.20\r  电源管理          Standby, Suspend, Active-Off\r\r--------[ 光驱 ]----------------------------------------------------------------------------------\r\r  产品              日立-LG DVDROM DH16NS30 DVD光驱\r  缓存/固件:        198 KB / 1.00\r\r--------[ 声卡 ]----------------------------------------------------------------------------------\r\r  声卡              瑞昱 ALC888 @ 英特尔 ICH10 HD Audio Controller\r  声卡              Nvidia @ Nvidia GF104 HD Audio Controller\r \r--------[ 网卡 ]----------------------------------------------------------------------------------\r\r  网卡              瑞昱 RTL8168C(P)/8111C(P) PCI-E Gigabit Ethernet NIC\r  制造商            微星\r\r--------[ PCI设备 ]-------------------------------------------------------------------------------\r\r  设备              4 Series Chipset DRAM Controller\r  设备ID            2E20h\r  制造商            Intel\r  制造商ID          8086h\r  类别              Bridge / PCI to HOST\r  子系统制造商      Intel\r  子系统ID          2E208086h(Generic ID)\r\r  设备              4 Series Chipset PCI Express Root Port\r  设备ID            2E21h\r  制造商            Intel\r  制造商ID          8086h\r  类别              Bridge / PCI to PCI\r\r  设备              ICH10 USB Universal Host Controller #4\r  设备ID            3A37h\r  制造商            Intel\r  制造商ID          8086h\r  类别              Serial / USB (UHCI)\r  子系统制造商      MSI\r  子系统ID          75121462h\r\r  设备              ICH10 USB Universal Host Controller #5\r  设备ID            3A38h\r  制造商            Intel\r  制造商ID          8086h\r  类别              Serial / USB (UHCI)\r  子系统制造商      MSI\r  子系统ID          75121462h\r\r  设备              ICH10 USB Universal Host Controller #6\r  设备ID            3A39h\r  制造商            Intel\r  制造商ID          8086h\r  类别              Serial / USB (UHCI)\r  子系统制造商      MSI\r  子系统ID          75121462h\r\r  设备              ICH10 USB Enhanced Host Controller #2\r  设备ID            3A3Ch\r  制造商            Intel\r  制造商ID          8086h\r  类别              Serial / USB 2.0 (EHCI)\r  子系统制造商      MSI\r  子系统ID          75121462h\r\r  设备              ICH10 HD Audio Controller\r  设备ID            3A3Eh\r  制造商            Intel\r  制造商ID          8086h\r  类别              Multimedia / Hi-definition Audio\r  子系统制造商      MSI\r  子系统ID          75121462h\r\r  设备              ICH10 PCI Express Root Port 1\r  设备ID            3A40h\r  制造商            Intel\r  制造商ID          8086h\r  类别              Bridge / PCI to PCI\r\r  设备              ICH10 PCI Express Root Port 6\r  设备ID            3A4Ah\r  制造商            Intel\r  制造商ID          8086h\r  类别              Bridge / PCI to PCI\r\r  设备              ICH10 USB Universal Host Controller #1\r  设备ID            3A34h\r  制造商            Intel\r  制造商ID          8086h\r  类别              Serial / USB (UHCI)\r  子系统制造商      MSI\r  子系统ID          75121462h\r\r  设备              ICH10 USB Universal Host Controller #2\r  设备ID            3A35h\r  制造商            Intel\r  制造商ID          8086h\r  类别              Serial / USB (UHCI)\r  子系统制造商      MSI\r  子系统ID          75121462h\r\r  设备              ICH10 USB Universal Host Controller #3\r  设备ID            3A36h\r  制造商            Intel\r  制造商ID          8086h\r  类别              Serial / USB (UHCI)\r  子系统制造商      MSI\r  子系统ID          75121462h\r\r  设备              ICH10 USB Enhanced Host Controller #1\r  设备ID            3A3Ah\r  制造商            Intel\r  制造商ID          8086h\r  类别              Serial / USB 2.0 (EHCI)\r  子系统制造商      MSI\r  子系统ID          75121462h\r\r  设备              82801IB/IR/IH(ICH9 A0 step) Hub Interface to PCI Bridge\r  设备ID            244Eh\r  制造商            Intel\r  制造商ID          8086h\r  类别              Bridge / PCI to PCI (Subtractive Decode)\r\r  设备              ICH10R LPC Interface Controller\r  设备ID            3A16h\r  制造商            Intel\r  制造商ID          8086h\r  类别              Bridge / PCI to ISA\r  子系统制造商      MSI\r  子系统ID          75121462h\r\r  设备              ICH10 4 port Serial ATA Storage Controller 1\r  设备ID            3A20h\r  制造商            Intel\r  制造商ID          8086h\r  类别              Storage / IDE (ATA)\r  子系统制造商      MSI\r  子系统ID          75121462h\r\r  设备              ICH10 SMBus Controller\r  设备ID            3A30h\r  制造商            Intel\r  制造商ID          8086h\r  类别              Serial / SMBus Controller\r  子系统制造商      MSI\r  子系统ID          75121462h\r\r  设备              ICH10 2 port Serial ATA Storage Controller 2\r  设备ID            3A26h\r  制造商            Intel\r  制造商ID          8086h\r  类别              Storage / IDE (ATA)\r  子系统制造商      MSI\r  子系统ID          75121462h\r\r  设备              GeForce GTX 460\r  设备ID            0E22h\r  制造商            Nvidia\r  制造商ID          10DEh\r  类别              Display / VGA\r  子系统制造商      Nvidia\r  子系统ID          086510DEh\r\r  设备              GF104 HD Audio Controller\r  设备ID            0BEBh\r  制造商            Nvidia\r  制造商ID          10DEh\r  类别              Multimedia / Hi-definition Audio\r  子系统制造商      Nvidia\r  子系统ID          086510DEh\r\r  设备              JMB36X SATA/IDE RAID Controller\r  设备ID            2363h\r  制造商            JMicron\r  制造商ID          197Bh\r  类别              Storage / IDE (ATA)\r  子系统制造商      MSI\r  子系统ID          75121462h\r\r  设备              RTL8168C(P)/8111C(P) PCI-E Gigabit Ethernet NIC\r  设备ID            8168h\r  制造商            Realtek\r  制造商ID          10ECh\r  类别              Network / Ethernet\r  子系统制造商      MSI\r  子系统ID          512C1462h\r \r--------[ 其他 ]----------------------------------------------------------------------------------\r\r  键盘              标准 101/102 键或 Microsoft 自然 PS/2 键盘\r  鼠标              微软 PS/2 鼠标\r \r--------[ 传感器 ]--------------------------------------------------------------------------------\r\r  名称:             FINTEK F71882F\r  CPU温度:          35 ℃\r  显卡温度:         52 ℃\r  主硬盘温度:       37 ℃\r  主板温度:         32 ℃\r \r', '2011-07-16 10:42:10', '2011-07-16 10:42:10', 708, 1),
(7, 1, '重要通知', 3, NULL, 0, ' 111111111', ' 22222222222', NULL, '2011-07-19 16:51:16', 1, 0),
(8, 1, '重要通知', 3, NULL, 0, ' 啊啊', '  各位', NULL, '2011-07-19 17:45:50', 1, 0),
(9, 1, '重要通知', 3, NULL, 0, 'a', ' b', NULL, '2011-07-20 09:24:26', 1, 0),
(10, 1, '重要通知', 3, NULL, 0, ' e', ' f', NULL, '2011-07-20 09:27:58', 1, 0),
(11, 1, '重要通知', 3, NULL, 0, ' g', ' g', NULL, '2011-07-20 09:30:29', 1, 0),
(12, 1, '重要通知', 3, NULL, 0, ' r', ' r', NULL, '2011-07-20 09:34:02', 1, 0),
(13, 1, '重要通知', 3, NULL, 0, 'e', ' e', NULL, '2011-07-20 09:34:43', 1, 0),
(14, 1, '重要通知', 3, NULL, 0, 'w', 'w', NULL, '2011-07-20 09:35:17', 1, 0),
(15, 1, '-1', 1, NULL, 0, ' a', ' b', NULL, '2011-07-21 17:36:48', 1, 0),
(16, 1, '其他', 3, 1, 0, ' a', ' b', '2011-07-22 11:13:23', '2011-07-21 17:39:03', 1, 1),
(17, 1, '其他', 3, NULL, 0, ' e', ' e', NULL, '2011-07-21 17:44:51', 1, 0);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_notice_attachment_relationship`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_notice_attachment_relationship` (
  `id` bigint(20) NOT NULL auto_increment,
  `notice_id` bigint(20) NOT NULL,
  `attachment_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=124 ;

--
-- 转存表中的数据 `wlzx_oa_notice_attachment_relationship`
--

INSERT INTO `wlzx_oa_notice_attachment_relationship` (`id`, `notice_id`, `attachment_id`) VALUES
(34, 8, 63),
(35, 8, 59),
(36, 8, 67),
(37, 8, 65),
(38, 8, 62),
(39, 8, 68),
(40, 8, 60),
(41, 8, 66),
(42, 8, 50),
(43, 8, 61),
(45, 8, 69),
(76, 7, 87),
(77, 7, 88),
(78, 7, 91),
(79, 7, 93),
(80, 7, 90),
(81, 7, 92),
(82, 7, 89),
(88, 9, 101),
(89, 9, 98),
(90, 9, 99),
(91, 9, 102),
(92, 9, 103),
(93, 9, 97),
(94, 9, 96),
(95, 9, 100),
(96, 9, 106),
(97, 9, 105),
(98, 9, 104),
(99, 10, 114),
(100, 10, 113),
(101, 10, 117),
(102, 10, 115),
(103, 10, 116),
(104, 11, 118),
(105, 11, 121),
(106, 11, 120),
(107, 11, 119),
(108, 11, 122),
(109, 12, 123),
(111, 14, 127),
(112, 14, 128),
(113, 14, 129),
(114, 14, 126),
(115, 14, 125),
(116, 13, 132),
(117, 13, 124),
(118, 13, 134),
(119, 13, 133),
(120, 13, 130),
(121, 13, 131),
(123, 5, 136);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `wlzx_oa_overwork_apply`
--

INSERT INTO `wlzx_oa_overwork_apply` (`id`, `overWork_applyNo`, `overWork_teacher_id`, `overWork_times`, `overWork_reason`, `overWork_officeChief_approver_id`, `overWork_officeChief_approve_time`, `overWork_officeChief_approve_option`, `overWork_officeChief_status`, `overWork_status`) VALUES
(1, '20110714093602', 1, '2011-07-14 1-0-0;2011-07-15 0-1-0;', '1111111111111', NULL, NULL, NULL, 0, 0),
(2, '20110714093736', 1, '2011-07-13 1-1-1;2011-07-16 1-1-0;', '2222222222222222222222222222222222222222222222222222222222222222222222222222222222222', NULL, NULL, NULL, 0, 0);

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
  `registed_date` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `wlzx_oa_receipt`
--

INSERT INTO `wlzx_oa_receipt` (`id`, `do_number`, `office`, `in_number`, `in_date`, `subject`, `title`, `summary`, `status`, `is_completed`, `registed_date`) VALUES
(1, 'a+1', 'b', 'c', NULL, 'd', 'aaaaaaaa', 'bbbbbbbbbbbbbb', 1, 0, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_receipt_attachment`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_receipt_attachment` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `type` varchar(10) NOT NULL,
  `path` varchar(100) NOT NULL,
  `receipt_id` bigint(20) NOT NULL,
  `upload_date` datetime default NULL,
  PRIMARY KEY  (`id`),
  KEY `receipt_id` (`receipt_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- 转存表中的数据 `wlzx_oa_receipt_attachment`
--

INSERT INTO `wlzx_oa_receipt_attachment` (`id`, `name`, `type`, `path`, `receipt_id`, `upload_date`) VALUES
(1, '杭州池墨科技有限公司_股份制度.pdf', 'pdf', '杭州池墨科技有限公司_股份制度_110722040834.pdf', 1, '2011-07-22 00:00:00'),
(2, '环境信息系统设计方案-20110615.pdf', 'pdf', '环境信息系统设计方案-20110615_110722040835.pdf', 1, '2011-07-22 00:00:00'),
(3, '火车票预订系统 Product Backlog2.xls', 'xls', '火车票预订系统 Product Backlog2_110722040835.xls', 1, '2011-07-22 00:00:00'),
(4, '火车票预订系统 Product Backlog.xls', 'xls', '火车票预订系统 Product Backlog_110722040835.xls', 1, '2011-07-22 00:00:00'),
(5, '火车票预订系统需求分析及设计_V1.3.doc', '3.doc', '火车票预订系统需求分析及设计_V1_110722040835.3.doc', 1, '2011-07-22 00:00:00'),
(6, '上海动量软件技术有限公司介绍.pdf', 'pdf', '上海动量软件技术有限公司介绍_110722040835.pdf', 1, '2011-07-22 00:00:00');

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_receipt_flow`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_receipt_flow` (
  `id` int(11) NOT NULL auto_increment,
  `type` int(4) NOT NULL,
  `is_completed` int(4) NOT NULL,
  `text` text,
  `step` int(4) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `department_id` bigint(20) NOT NULL,
  `receipt_id` bigint(20) NOT NULL,
  `completed_date` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_oa_receipt_flow`
--


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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `wlzx_oa_schedule`
--

INSERT INTO `wlzx_oa_schedule` (`id`, `title`, `content`, `begin_time`, `end_time`, `poster_id`, `type`, `department_share`, `school_share`, `department_id`, `emergence`, `finish_status`, `submit_status`, `repeat_status`, `repeat_type`, `repeat_interval`, `repeat_on_days`, `repeat_end_time`) VALUES
(1, '新日程', '222222222', '2011-07-15 20:56:55', '2011-07-15 21:56:00', 708, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(2, '新日程', NULL, '2011-07-15 20:57:33', '2011-07-15 20:57:33', 708, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `wlzx_oa_takeleave_apply`
--

INSERT INTO `wlzx_oa_takeleave_apply` (`id`, `takeLeave_applyNo`, `takeLeave_type`, `takeLeave_teacher_id`, `takeLeave_beginTime`, `takeLeave_endTime`, `takeLeave_reason`, `takeLeave_arrange_tech`, `takeLeave_arrange_tech_deal_already`, `takeLeave_arrange_service`, `takeLeave_arrange_service_deal_already`, `takeLeave_arrange_manage`, `takeLeave_arrange_manage_deal_already`, `takeLeave_officeChief_approver_id`, `takeLeave_officeChief_approve_time`, `takeLeave_officeChief_approve_option`, `takeLeave_officeChief_status`, `takeLeave_vicePrincipal_approver_id`, `takeLeave_vicePrincipal_approve_time`, `takeLeave_vicePrincipal_approve_option`, `takeLeave_vicePrincipal_status`, `takeLeave_principal_approver_id`, `takeLeave_principal_approve_time`, `takeLeave_principal_approve_option`, `takeLeave_principal_status`, `takeLeave_remark`, `takeLeave_status`) VALUES
(1, '20110714092825', 0, 1, '2011-07-14 0', '2011-07-23 0', 'aaa', '', 0, '', 0, '', 0, 715, '2011-07-23 00:00:00', '', 2, NULL, NULL, '', 0, NULL, NULL, '', 0, NULL, 4),
(2, '20110723141108', 0, 708, '2011-07-23 0', '2011-07-27 2', '年休息', '', 1, '', 1, '', 1, 708, '2011-07-23 00:00:00', '自己测试', 1, 708, '2011-07-23 00:00:00', '自己测试', 1, 708, '2011-07-23 00:00:00', '自己测试', 1, NULL, 3);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=23 ;

--
-- 转存表中的数据 `wlzx_oa_workflow_log`
--

INSERT INTO `wlzx_oa_workflow_log` (`id`, `operation_object_type`, `operation_object_id`, `operation_teacher_id`, `operation_time`, `operation_name`, `operation_result`) VALUES
(1, 'ApplyWorkFlowLog', 1, 1, '2011-07-06 17:32:03', '发起申请', '生成编号为20110706173203的申请记录'),
(2, 'ApplyWorkFlowLog', 2, 1, '2011-07-06 17:43:15', '发起申请', '生成编号为20110706174315的申请记录'),
(3, 'ApplyWorkFlowLog', 3, 1, '2011-07-06 17:53:24', '发起申请', '生成编号为20110706175324的申请记录'),
(4, 'ApplyWorkFlowLog', 3, 1, '2011-07-06 17:54:42', '课程处审批', '课程处审批编号为20110706175324的申请通过'),
(5, 'ApplyWorkFlowLog', 2, 1, '2011-07-06 17:56:09', '课程处审批', NULL),
(6, 'ApplyWorkFlowLog', 2, 1, '2011-07-06 18:08:56', '课程处审批', '课程处审批编号为20110706174315的申请不通过'),
(7, 'ApplyWorkFlowLog', 3, 1, '2011-07-06 18:14:35', '课程处审批', '课程处审批编号为20110706175324的申请通过'),
(8, 'TakeLeaveWorkFlowLog', 1, 1, '2011-07-14 09:28:25', '发起申请', '生成编号为20110714092825的申请记录'),
(9, 'OverWorkWorkFlowLog', 1, 1, '2011-07-14 09:36:02', '发起申请', '生成编号为20110714093602的申请记录'),
(10, 'OverWorkWorkFlowLog', 2, 1, '2011-07-14 09:37:36', '发起申请', '生成编号为20110714093736的申请记录'),
(11, 'OverWorkWorkFlowLog', 2, 1, '2011-07-14 09:43:02', '编辑申请', '编辑编号为20110714093736的申请记录'),
(12, 'OverWorkWorkFlowLog', 2, 1, '2011-07-14 09:43:17', '编辑申请', '编辑编号为20110714093736的申请记录'),
(13, 'OverWorkWorkFlowLog', 2, 1, '2011-07-14 09:45:31', '编辑申请', '编辑编号为20110714093736的申请记录'),
(14, 'TakeLeaveWorkFlowLog', 1, 1, '2011-07-20 19:08:20', '编辑申请', '编辑编号为20110714092825的申请记录'),
(15, 'TakeLeaveWorkFlowLog', 1, 715, '2011-07-23 09:51:54', '处室审批', '处室审批编号为20110714092825的申请不通过'),
(16, 'TakeLeaveWorkFlowLog', 2, 708, '2011-07-23 14:11:08', '发起申请', '生成编号为20110723141108的申请记录'),
(17, 'TakeLeaveWorkFlowLog', 2, 708, '2011-07-23 14:13:07', '落实请假/出差期间教学工作', '落实编号为20110723141108的申请请假/出差期间教学工作'),
(18, 'TakeLeaveWorkFlowLog', 2, 708, '2011-07-23 14:13:07', '落实请假/出差期间管理工作', '落实编号为20110723141108的申请请假/出差期间管理工作'),
(19, 'TakeLeaveWorkFlowLog', 2, 708, '2011-07-23 14:13:07', '落实请假/出差期间服务工作', '落实编号为20110723141108的申请请假/出差期间服务工作'),
(20, 'TakeLeaveWorkFlowLog', 2, 708, '2011-07-23 14:13:07', '处室审批', '处室审批编号为20110723141108的申请通过'),
(21, 'TakeLeaveWorkFlowLog', 2, 708, '2011-07-23 14:13:07', '分管副校长审批', '分管副校长审批编号为20110723141108的申请通过'),
(22, 'TakeLeaveWorkFlowLog', 2, 708, '2011-07-23 14:13:07', '校长审批', '校长审批编号为20110723141108的申请通过');
