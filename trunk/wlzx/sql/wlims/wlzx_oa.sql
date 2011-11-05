-- phpMyAdmin SQL Dump
-- version 3.3.3
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2011 年 11 月 05 日 13:15
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
  `belong_object` varchar(200) default NULL,
  `belong_object_id` bigint(20) default NULL,
  `name` varchar(100) NOT NULL,
  `path` varchar(100) NOT NULL,
  `type` varchar(10) NOT NULL,
  `size` bigint(20) NOT NULL,
  `upload_date` datetime default NULL,
  PRIMARY KEY  (`id`),
  KEY `belong_object` (`belong_object`,`belong_object_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=18 ;

--
-- 转存表中的数据 `wlzx_oa_attachment`
--

INSERT INTO `wlzx_oa_attachment` (`id`, `belong_object`, `belong_object_id`, `name`, `path`, `type`, `size`, `upload_date`) VALUES
(7, 'NoticeModel', 36, '附件1.doc', 'attach_111019044237.doc', 'doc', 34816, '2011-10-19 16:42:37'),
(8, 'NoticeModel', 36, '附件2.doc', 'attach_111019044240.doc', 'doc', 35328, '2011-10-19 16:42:40'),
(11, NULL, NULL, '附件1.doc', 'attach_111019051618.doc', 'doc', 34816, '2011-10-19 17:16:18'),
(12, NULL, NULL, '附件1.doc', 'attach_111019052300.doc', 'doc', 34816, '2011-10-19 17:23:00'),
(13, NULL, NULL, '附件2.doc', 'attach_111019052302.doc', 'doc', 35328, '2011-10-19 17:23:02'),
(14, NULL, NULL, 'course_mids_left_top.png', 'attach_111019052336.png', 'png', 84577, '2011-10-19 17:23:36'),
(15, NULL, NULL, 'index-V2_25.png', 'attach_111019052411.png', 'png', 2065, '2011-10-19 17:24:11'),
(16, NULL, NULL, '温教办人〔2011〕107号 关于做好各类名师工作室成员及名师名校长师徒结对意向申报的通知.doc', 'attach_111028044300.doc', 'doc', 142848, '2011-10-28 16:43:00'),
(17, 'NoticeModel', 43, '温教办人〔2011〕107号 关于做好各类名师工作室成员及名师名校长师徒结对意向申报的通知.doc', 'attach_111028044442.doc', 'doc', 142848, '2011-10-28 16:44:42');

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `wlzx_oa_conference`
--

INSERT INTO `wlzx_oa_conference` (`id`, `name`, `date`, `time_begin`, `time_end`, `attend_num`, `teacher_attend_ids`, `department_id`, `place_id`, `contact_user_id`, `contact_phone_number`, `service_needed`, `description`, `apply_user_id`, `apply_time`, `apply_status`) VALUES
(1, '会议1', '2011-09-30', '07:00', '08:00', 10, '708;710;', 12, 1, 733, '666756', '', '', 733, '2011-09-30 18:22:55', 1),
(2, 'fasf', '2011-10-19', '07:00', '08:00', 0, '708;', 1, 1, 708, '222', '', 'ewq', 1, '2011-10-22 10:17:41', 2);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `wlzx_oa_course_adjust_apply`
--

INSERT INTO `wlzx_oa_course_adjust_apply` (`id`, `apply_no`, `apply_type`, `apply_teacher_id`, `apply_reason`, `apply_status`, `approve_teacher_id`, `approve_remark`, `approve_date`, `apply_creation_date`) VALUES
(1, '20110930181403', 0, 743, '请假', 1, 733, '通过', '2011-09-30 18:24:56', '2011-09-30 18:14:03'),
(2, '20111017121135', 0, 972, '调试', 1, 733, '同意', '2011-10-20 14:35:42', '2011-10-17 12:11:35');

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
  `adjust_mean_time` varchar(200) default NULL,
  `adjust_mean_teacher_id` bigint(20) NOT NULL,
  `adjust_actual_date` datetime default NULL,
  `adjust_actual_time` varchar(200) default NULL,
  `adjust_actual_teacher_id` bigint(20) default NULL,
  `adjust_arrange_already` smallint(6) default NULL,
  `adjust_arrange_date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `wlzx_oa_course_adjust_apply_item`
--

INSERT INTO `wlzx_oa_course_adjust_apply_item` (`id`, `apply_id`, `apply_class`, `apply_course`, `apply_course_date`, `apply_course_time`, `adjust_mean_date`, `adjust_mean_time`, `adjust_mean_teacher_id`, `adjust_actual_date`, `adjust_actual_time`, `adjust_actual_teacher_id`, `adjust_arrange_already`, `adjust_arrange_date`) VALUES
(1, 1, '1', '语文', '2011-09-30 00:00:00', '第二节 第三节 ', '2011-09-30 00:00:00', '第三节 第四节 ', 708, '2011-09-30 00:00:00', '第三节 第四节 ', 708, 1, '2011-09-30 18:24:28'),
(2, 2, '1', '电脑', '2011-10-02 00:00:00', '第一节 ', '2011-10-02 00:00:00', '第一节 ', 972, '2011-10-19 00:00:00', '第一节 第二节 第三节 第四节 第五节 第六节 第七节 第八节 第九节 ', 976, 1, '2011-10-19 12:57:57');

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
  `read_nums` int(11) default '0' COMMENT '阅读数',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=51 ;

--
-- 转存表中的数据 `wlzx_oa_notice`
--

INSERT INTO `wlzx_oa_notice` (`id`, `scope`, `type`, `post_department_id`, `poster_id`, `emergence_flag`, `title`, `content`, `postTime`, `last_edit_time`, `last_editor_id`, `status`, `read_nums`) VALUES
(4, 0, '考勤信息', 6, 718, 0, ' 9月20日教工大会出勤', ' 请假：杨华 李迅若 王茜 陈军红 陈兆明 王华君 江丽芳 应崇杨 郭仁勇 余卜秋 梁瑞阳 徐根玲 叶理富\r 缺席：金伟飞 将照明 徐敏燕', '2011-09-28 05:26:26', '2011-09-28 05:26:26', 718, 1, 59),
(5, 1, '其他', 6, 718, 0, ' 督导评估指导会议', ' 明天（周五）第二节课邀请市教育局督导室陈和平老师对我校督导评估准备工作进行指导，请大家准时参加。', '2011-09-29 15:16:26', '2011-09-29 15:16:26', 718, 1, 15),
(6, 1, '其他', 6, 716, 0, ' 工作量清单。', '工作量清单。肖健周四（9月29日）下午前完成并列出名单。', '2011-09-29 15:26:49', '2011-09-29 15:26:49', 716, 1, 20),
(8, 1, '考勤信息', 6, 716, 0, ' 校报初稿', '校报初稿。毛丽丽具办2011秋季版，要在10月中旬拿出样稿。', '2011-09-29 15:30:07', '2011-09-29 15:30:07', 716, 1, 20),
(12, 0, '考勤信息', 6, 716, 0, '补办党员证拍照', ' 10月12日开始到10月13日晚上7：00之前，请上个月月底前已经报名补办党员证但尚未拍照的28名党员自行到太平摄影（人民中路195号）拍照，并在《温岭中学补办党员证的名单》上签字予以确认，谢谢！', '2011-10-12 09:36:49', '2011-10-12 09:36:49', 716, 1, 17),
(13, 1, '其他', 6, 716, 0, ' 会议记录整理分工', '2011年9月开始，各类会议记录分工：校务会议记录，李俊成整理；行政会议纪要，林向荣整理；教工大会的会议纪要，毛丽丽整理。均固定一个小册子，按照年份记录，一年归档案室一次。', '2011-10-12 09:41:19', '2011-10-12 09:41:19', 716, 1, 3),
(14, 1, '其他', 6, 716, 0, ' 五件大事启动等', '王茜老师在本周初列出时间安排表初稿，经江校长审阅后交陈校长批示并注意落实；完成学校宣传小册子；电话提醒个别已经报名补办党员证但忘记拍照的党员。王波老师进行党员微博帐号汇总，落实日常的电子屏幕投影宣传和各处室周工作计划汇总 。', '2011-10-12 09:47:40', '2011-10-12 09:47:40', 716, 1, 3),
(15, 0, '其他', 10, 946, 0, ' 综践处工作分配方案', ' 综践处工作分配方案\r\r为了促进综践处工作的顺利进行，切实为学校做好服务工作，尽量解决老师使用各种设备的后顾之忧，我们综践处现在将工作重新分配，让各位老师放心工作。现将综践处工作方案公布于众，希望各位老师配合。\r工作分配方案： \r信息组人员：\r电子阅览室维护为信息组集体工作（各人分一组，每人约30台，下述已计入，要计时），由柯老师为主管协调。\r柯慧荣：自己机房维修（约60台）、行政组（约8台）、生物组（约16台）、地理组（约10台）、课程处（约6台）、电子阅览室一组（约30台）电脑维修。主管网线电话线维修（折算为50台电脑维修，教学楼由江勇负责，特殊情况除外，如高考、会考接线、模块接线等）。共约180台。\r谢理琦：自己机房维修（约60台电脑）、语数英高三年级组（约35台）、历史组（约10台）、政治组（约11台）、德育处（约9台）、体育组（约17台）、电子阅览室一组（约30台）电脑维修，主管服务器管理工作（折算为10台电脑维修）。共约182台。\r黄玲利：自己机房维修（约60台）、语数英高二年级组（约35台）、物理组（约27台）、物理数字实验室（约13台）、图书馆（约7台）、电子阅览室一组（约30台）电脑维修。处室信息员、处室档案管理、综合实践课程相关工作、各种统计工作（折算成10台电脑维修）。共约182台。\r蔡剑菊：自己机房维修（约60台）、语数英高一年级组（约35台）、化学组（约25台）、化学数字实验室（约9台）、办公室（约7台）、艺术组（约4台）、资源处（约11台）、电子阅览室一组（约30台）电脑维修。共约181台。\r陈军辉：计算机竞赛辅导（由课程处处理），自己机房维修，要参与各种处室集体性等工作。\r通用技术组：\r邵云强：学生电视台工作，学校会议、客访、课堂实录等拍摄、编辑等。\r李国庆：学生广播台工作，协助学校各会议室使用，音响设备安装维修，广播系统维修等。\r处室人员：\r李林岳：对处室工作进行监督和指导。\r江勇：主持处室工作，协调、协助、分配处室工作，通用技术教研组长工作，教室电教设备和教学楼网线电话维修管理。\r张雯菁：协助处长做好工作，研究性学习、选修课等工作安排和分配。\r\r说明：\r1、	上述分配只对台式机进行了初步分配，事实上工作量远非如此，比如教师自备的教学用笔记本，就未计算在内。综践处老师工作量大较忙，请老师多多体谅。\r2、	综践处老师维修要记时间，各位老师要诚实签名，请多多配合，谢谢！有什么问题和建议请向综践处反映。\r', '2011-10-17 12:23:17', '2011-10-17 12:23:17', 946, 1, 1),
(18, 0, '其他', 10, 946, 0, ' 高一也加入了新监控', ' 各位老师：昨天综践处对高一的监控也进行了改造，加入了新的监控系统（老系统失效），教师可到FTP下载中心（地址：FTP://any@172.16.2.66/综践处/监控）下载“全部新监控Pro Surveillance System公开”这整个文件夹，运行其中的“PSSProject.exe”程序文件即可。具体操作见这“监控”文件夹下的“关于新硬盘录象机的使用方法.doc”。', '2011-10-17 12:27:37', '2011-10-17 12:27:37', 946, 1, 5),
(19, 0, '其他', 10, 946, 0, ' 卸载增霸卡', ' 许多老师无法安装软件，是增霸卡的缘故，卸载即可。方法：1、开机，显示“OS1”时按F10键进入（无密码），点“版本信息”“开始卸载”。2、机重启动时又按F10键进入BIOS设置，在“Advanced”页面下将“Onboard LAN Boot ROM”的选项选为“None”，再按F10保存退出。3、重启进入windows后，“控制面板”“添加删除程序”中卸载“ZengBaKaII Application”即可。至此完成。', '2011-10-17 12:30:28', '2011-10-17 12:30:28', 946, 1, 6),
(20, 0, '通知', 6, 718, 0, ' 关于组织对申报中学高级对象进行教学水平考核的通知', ' 台州市教育局\r\r\r\r关于组织对申报中学高级对象进行教学水平考核的通知\r\r各县（市、区）教育局人事科、市直中小学（单位）：\r   根据我局《关于做好2011年中专及中小学教师职务评审工作的通知》精神，凡晋升中学高级教师（教研员）的对象均须参加全市统一组织的课堂教学考核和面试。为做好此项工作，现将有关事项通知如下：\r一、课堂教学考核采用模拟上课与面试相结合的形式进行，上课内容为相应学科初中、普通高中、职业高中现学生使用的教材（教学计划规定的所有册数），具体内容临时确定（由市教育局提供教材复印件）。\r二、模拟上课准备时间为1小时，上课时间为15分钟。上课结束后须回答专家的面试提问，面试时间为5分钟。\r三、考核时间、地点：考核定于10月22日进行，申报人员请在考核当天上午6：30前凭身份证到台州市实验中学体育馆报到、抽签，逾期作自动放弃处理。\r四、考核对象进入准备室时不准带任何教材或参考资料，进入上课教室时只准带在准备室准备的教案和教材,不得带其它参考资料；模拟上课时不得自我介绍县（市、区）、学校及个人姓名等信息；模拟上课结束后须上交教案和教材。违规者将影响考核成绩。\r五、请各县、市、区教育局（分局）及时通知有关对象。\r\r\r\r                                                                             台州市教育局人事处  \r\r                                                                                 二0一一年十月十七日\r', '2011-10-17 15:12:08', '2011-10-17 15:12:08', 718, 1, 16),
(27, 0, '通知', 6, NULL, 0, ' 关于推荐普通高中校本培训指导教师的通知', ' 关于推荐普通高中校本培训指导教师的通知\r \r各普通高中：\r为全面整合市内普通高中教师培训资源，整体推动我市普通高中校本培训工作。根据10月10日全市普通高中校本培训工作会议精神，市教育局决定建立“十二五”普通高中校本培训指导教师团。请各校按照会议要求推荐指导教师，并填写好相关表格。于10月27日前交教育局人事科。\r \r \r                                                                                              温岭市教育局人事科\r                                                                                                2011年10月13日\r', NULL, '2011-10-18 21:18:48', 718, 1, 0),
(30, 0, '通知', 6, 716, 0, ' 创园迎检期间的车辆停放', ' 为更好地做好我市创园迎检工作，减少太平区域内路面车辆，保证交通畅通，根据上级部门要求，在太平区域内开私家车上班的我校教职工，建议在10月21日至23日期间将车辆有序停放在我校校内的停车位置上，提倡步行、骑自行车或乘坐公交车等方式上下班。', '2011-10-19 09:39:12', '2011-10-19 09:39:12', 716, 1, 10),
(36, 0, '通知', 6, 718, 0, ' 关于推荐普通高中校本培训指导教师的通知', '关于推荐普通高中校本培训指导教师的通知\r \r各普通高中：\r为全面整合市内普通高中教师培训资源，整体推动我市普通高中校本培训工作。根据10月10日全市普通高中校本培训工作会议精神，市教育局决定建立“十二五”普通高中校本培训指导教师团。请各校按照会议要求推荐指导教师，并填写好相关表格。于10月27日前交教育局人事科。\r \r \r                                                                                                                                 温岭市教育局人事科\r                                                                                                                                   2011年10月13日\r推荐表请在附件区下载\r\r', '2011-10-19 17:00:22', '2011-10-19 17:00:22', 718, 1, 31),
(37, 0, '考勤信息', 6, 718, 0, ' 10月18日教工大会出勤', ' 请假：林晓滨 蒋晓楠 郭定吉 李荣华 王增松 朱海平 金巧萍 陈兆明 张诚达 闫大贵 钟加增 施仁贵 林崇军 陈成 潘晓斐 吴娴静 叶妙水 李菊清 林仁明 金蕴 梁瑞阳 黄玲利 林慧 叶勤 \r       杨友明 陈胜男 陈福初\r 缺席：王同光  \r 外出：郑晓萍 梁茶夫 钟克亚 毛灵芝 林君 李欢欢 张友良 颜斌 季华辉 赵阳 郑建荣 周夏芬 李煜霞 张卫 赵丽红', '2011-10-20 10:33:09', '2011-10-20 10:33:09', 718, 1, 34),
(38, 0, '其他', 3, 722, 0, '重发:2011学年十月份主题教育活动', ' 高一爱校教育\r1、	利用国旗下讲话，宣传栏等形式，宣传“知我温中、爱我温中、美我温中”的活动主题，培养同学学会尊重老师、热爱学校、热爱班级的优良品质。\r2、	要求各班级以“爱我温中”或“爱国教育”为主题出一期黑板报，德育处将组织评比。检查时间：10月17日。\r3、	组织各班根据本班实际情况，讨论制定班级文明公约，切实提高学生素质，严格规范个人行为，创造和谐的成长环境。\r4、	组织安排参观校史陈列室与校庆展厅，树立同学“今天我以学校为荣，将来母校以我为荣”的爱校意识。（10月17号---21号）。\r5、	组织召开以“爱校、爱师、爱同学”为主题的主题班会。检查时间：10月21日（周五）下午第四节。\r6、	与艺术组联系开展唱校歌活动，使广大同学更加热爱自己的学校，热爱自己的老师。\r高二爱国教育\r1、	进一步规范升旗仪式，做好“国旗下的讲话”。\r2、	利用班会课，以爱国主义教育为红线，以“五爱”（爱自己、爱他人、爱家、爱校、爱国家）教育为基本内容，加强对学生进行规范养成教育、道德品质教育和集体主义教育等。\r3、	组织出一期“爱国主义”教育主题黑板报专栏。检查时间：10月17日。\r4、	观看一部有关爱国主义教育的影片。观看之后写一篇观后感，推荐优秀作品报学校团委。\r高三责任教育\r1、利用升旗仪式和高三段全体学生集会向同学宣传责任教育的意义，责任教育的内容，让同学明确自己的责任。\r2、创设责任教育氛围。利用黑板报、宣传橱窗等，宣传责任意识，创造校园的“责任”氛围。其中班级黑板报的检查时间为10月17日。\r3、开展“对自己、对父母、对集体、对祖国负责”教育活动。各班自行利用班会课，加强对学生进行责任教育，要求做到：爱自己，对自己负责，做一名全面发展的人；爱父母，对父母负责，做一名孝敬父母的人；爱集体，对集体负责，做一名有益于集体的人；爱祖国，对祖国负责，做一名立志报国的人。每位同学要从我做起，敢于剖析自己，深刻反省自己：那些地方做的不好，今后如何对自己应当负起的责任负责。\r\r\r                                               德育处\r                                              2011/9/30\r\r', '2011-10-20 15:51:51', '2011-10-20 15:51:51', 722, 1, 17),
(39, 0, '考勤信息', 6, 718, 0, ' 10月25日教工大会出勤', ' 请假：郭定吉 王茜 江丽云 陈兆明 邹丽平 余卜秋 钟永勇 郭春莲\r 缺席：王同光 金海华 陈军辉 陈福初\r 外出：张友良 颜斌 季华辉 赵阳 江志云 郑建荣 周夏芬 李煜霞', '2011-10-26 08:32:06', '2011-10-26 08:32:06', 718, 1, 18),
(40, 0, '其他', 6, 716, 0, '2011年12月十届三次教代会报告的初步框架', '初步文稿要在11月底前完成', '2011-10-27 10:38:35', '2011-10-27 10:38:35', 716, 1, 4),
(41, 1, '其他', 6, 716, 0, ' 师德学时', '在10月30前，王波完成2011年暑期师德培训学时登记工作。', '2011-10-28 08:46:53', '2011-10-28 08:46:53', 716, 1, 1),
(42, 1, '其他', 6, 716, 0, ' 数据校核', ' 对省教师培训管理平台和温岭教师教育网上数据进行校核，王波本周完成。', '2011-10-28 08:52:43', '2011-10-28 08:52:43', 716, 1, 4),
(43, 0, '通知', 6, 718, 0, ' 关于做好各类名师工作室成员及名师名校长师徒结对意向申报的通知', ' 关于做好各类名师工作室成员及名师名校长师徒结对意向申报的通知\r\r各镇（街道）中小学、市直属学校、民办学校：\r为了更好地发挥名师名校长的传、帮、带作用，使师徒结对活动更有针对性。现将2011-2012年各类名师工作室成员及名师名校长师徒结对意向申报活动通知如下：\r一、台州市首批名师工作室成员\r1、选拔条件：原则上年龄40周岁以下，在本学科领域具有一定知名度和培养前途的中青年骨干教师。\r2、温岭市内推荐给每个工作室2-3位符合条件的人员。\r3、工作室活动周期三年。\r二、温岭市名家工作室成员\r1、选拔条件：年龄40周岁以下，教龄5年以上的校级以上骨干教师。市骨干教师、市教学大比武获奖者优先推荐。\r2、每个工作室确定6位成员。\r3、工作室活动周期2年。\r三、温岭市教育局名师工作室\r1、选拔条件：年龄40周岁以下，教龄3年以上的校级以上骨干教师。市骨干教师、市教学大比武获奖者优先推荐。\r2、管理类工作室成员必须是正职校长。\r3、每个工作室确定6位成员。\r4、工作室活动周期2年。\r四、名师名校长结对成员\r1、选拔条件：年龄在40周岁以下教龄3年以上的校级以上骨干教师。市骨干教师、市教学大比武获奖者优先。\r2、结对成员面向农村。\r3、名师名校长带徒2位。 \r各类名师工作室领衔人、名师名校长名单见附件1.\r五、相关要求\r1、结对成员填写意向申报表（附件2），学校汇总签署意见后于2011年10月30日前将意向申报表报教育局人事科。成员的选拔采用教师自荐、学校推荐、名师选择、教育局确认形式进行。\r2、已参加过温岭市级名师工作室学习成员不能报名参加此次温岭市级名师工作室学习。 \r\r附件：1．各类名师工作室领衔人、名师名校长名单\r2．名师工作室成员、名师名校长带徒意向申报表。\r\r\r\r\r                                                                                                                                    温岭市教育局办公室   \r                                                                                                                                   二〇一一年十月二十六日\r', '2011-10-28 16:42:56', '2011-10-28 16:42:56', 718, 1, 8),
(44, 0, '考勤信息', 6, 718, 0, ' 10.31日升旗仪式出勤', '  请假：朱小荣\r未打卡：陈军辉 陈兆明 管彦斌 季华辉 蒋晓南 王文卿 金伟飞 柯慧荣 李清娟 李淑华 吕娅 王敏杰 王同光 颜小敏 杨华 朱海平', '2011-10-31 14:47:34', '2011-10-31 14:47:34', 718, 1, 7),
(45, 0, '其他', 6, 716, 0, ' 教代会报告的初步框架', '十届三次教代会的主题是：实施精细化管理，争创一类特色高中。初步文稿要在11月底前完成。校办起草。', '2011-10-31 15:36:40', '2011-10-31 15:36:40', 716, 1, 5),
(46, 0, '其他', 6, 716, 0, ' 招临时工', '本周开始拟招聘化学实验员和校医各一人，确定人选，报校务会议商定。', '2011-10-31 15:37:45', '2011-10-31 15:37:45', 716, 1, 12),
(47, 0, '其他', 6, 716, 0, '两个会议安排', '上周一下午在11楼会议室从3：30开始分别完成了由赵海勇校长召集的优质特色学校创建会议、由江正玲校长召集的教学现代化发展会议和、由郑晓萍校长召集的校园环境文化建设会议。拟本周完成由徐跃文主席召集召开“五龙小区分房”项目启动工作会议和由马之骏校长召集召开“三期工程征地”项目启动工作会议。', '2011-10-31 15:44:33', '2011-10-31 15:44:33', 716, 1, 7),
(48, 1, '其他', 6, 716, 0, '  学校宣传小册子', '本周修改第2稿，争取在11月中旬定稿付印。', '2011-10-31 15:45:50', '2011-10-31 15:45:50', 716, 1, 2),
(49, 0, '其他', 6, 716, 0, ' 增添友好学校', '2011年10月30日，泉州五中和我校结为友好合作学校，落实后学的干部挂职交流、师资访学交流和课题合作研究等项目。', '2011-10-31 15:46:59', '2011-10-31 15:46:59', 716, 1, 8),
(50, 0, '其他', 6, 716, 0, ' 课题研究', '本周参加中国艺术研究院主持的国家级课题“非物质文化遗产校园传承研究”的开题会。', '2011-10-31 15:47:51', '2011-10-31 15:47:51', 716, 1, 11);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_option`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_option` (
  `option_id` bigint(20) NOT NULL auto_increment COMMENT '系统自增编号',
  `option_name` varchar(50) character set utf8 NOT NULL COMMENT '字典名称',
  `option_value` varchar(120) character set utf8 NOT NULL COMMENT '字典值',
  `option_slug` varchar(50) character set utf8 NOT NULL COMMENT '字典类型',
  `option_description` varchar(120) character set utf8 default NULL COMMENT '字典描述',
  `option_extra_value` varchar(30) character set utf8 default NULL COMMENT '字典额外值',
  PRIMARY KEY  (`option_id`),
  KEY `option_slug` (`option_slug`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='数据字典表' AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_oa_option`
--


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_oa_overwork_apply`
--


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
  `registed_date` datetime default NULL,
  `receiver_id` bigint(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_oa_receipt`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_receipt_flow`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_receipt_flow` (
  `id` bigint(20) NOT NULL auto_increment,
  `type` smallint(6) NOT NULL,
  `is_completed` smallint(6) default NULL,
  `text` text,
  `user_id` bigint(20) NOT NULL,
  `receipt_id` bigint(20) NOT NULL,
  `completed_date` datetime default NULL,
  `creation_date` datetime NOT NULL,
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=98 ;

--
-- 转存表中的数据 `wlzx_oa_schedule`
--

INSERT INTO `wlzx_oa_schedule` (`id`, `title`, `content`, `begin_time`, `end_time`, `poster_id`, `type`, `department_share`, `school_share`, `department_id`, `emergence`, `finish_status`, `submit_status`, `repeat_status`, `repeat_type`, `repeat_interval`, `repeat_on_days`, `repeat_end_time`) VALUES
(7, '教工宿舍天井美化', NULL, '2011-09-26 08:31:00', '2011-09-30 17:31:00', 983, 1, 1, 1, 11, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(8, '劳保发放', NULL, '2011-09-27 08:32:00', '2011-09-27 17:00:00', 983, 1, 0, 1, 11, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(9, '回收学生宿舍饮水机', NULL, '2011-09-26 08:33:00', '2011-09-29 17:33:00', 983, 1, 0, 1, 11, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(10, '食堂圆桌和酒柜采购', NULL, '2011-09-26 08:34:00', '2011-09-29 17:00:00', 983, 1, 0, 1, 11, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(11, '高三第一次月考', NULL, '2011-09-29 08:49:00', '2011-09-30 16:49:00', 733, 1, 0, 1, 12, 1, 1, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(13, '各教研组推荐参加本学期的“解题、命题、析题”的老师，要求被推荐的老师提前对三年高考五年模拟进行强化训练', NULL, '2011-09-26 08:51:00', '2011-09-30 09:51:00', 733, 1, 0, 1, 12, 3, 1, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(14, '教学常规检查(作业管理,提高作业效率)', NULL, '2011-09-26 08:52:00', '2011-09-30 09:52:00', 733, 1, 0, 1, 12, 3, 1, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(15, '综合实践活动课程平台建设', NULL, '2011-09-26 08:52:00', '2011-09-30 09:52:00', 733, 1, 0, 1, 12, 3, 1, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(16, '周日晚（25号）在6302举行高一高二演讲赛', NULL, '2011-09-25 18:54:00', '2011-09-25 20:54:00', 722, 1, 0, 1, 3, 1, 1, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(18, '各班班委、团支委名单统计上报', NULL, '2011-09-26 08:56:00', '2011-09-30 09:56:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(19, '部署国庆系列活动', NULL, '2011-09-26 08:56:00', '2011-09-30 09:56:00', 722, 1, 0, 1, 3, 1, 1, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(20, '周四中午清泉助学基金资助生座谈会', NULL, '2011-09-29 08:57:00', '2011-09-29 17:57:00', 722, 1, 0, 1, 3, 1, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(21, '周五安全检查', NULL, '2011-09-30 08:57:00', '2011-09-30 09:57:00', 722, 1, 0, 1, 3, 1, 1, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(22, 'OA系统调试', NULL, '2011-09-28 08:58:00', '2011-09-28 10:58:00', 718, 1, 0, 0, 6, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(24, '电影安排 周日晚高三（1-12）及教师', NULL, '2011-09-25 19:20:00', '2011-09-25 21:16:00', 722, 1, 0, 1, 3, 3, 1, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(25, '电影：周一晚高三（13-24）及教师', NULL, '2011-09-26 19:35:00', '2011-09-26 21:35:00', 722, 1, 0, 1, 3, 3, 1, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(26, '电影：周二晚高二', NULL, '2011-09-27 19:36:00', '2011-09-27 21:36:00', 722, 1, 0, 1, 3, 3, 1, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(27, '电影：周四晚高一', NULL, '2011-09-29 19:36:00', '2011-09-29 21:36:00', 722, 1, 0, 1, 3, 3, 1, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(33, '组织参加信息学奥赛初赛', NULL, '2011-10-09 15:41:00', '2011-10-14 16:41:00', 946, 1, 0, 1, 10, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(34, '校体育节开始筹备，部分项目开始比赛', NULL, '2011-10-08 15:43:00', '2011-10-14 16:43:00', 946, 1, 0, 1, 10, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(35, '温岭市数学教学大比武服务工作', NULL, '2011-10-08 15:45:00', '2011-10-11 16:45:00', 946, 1, 0, 1, 10, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(36, '电子图书馆建设调查', NULL, '2011-10-08 15:47:00', '2011-10-14 16:47:00', 946, 1, 0, 1, 10, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(37, '我的日程', 'test', '2011-09-30 16:58:38', '2011-09-30 17:58:38', 708, 0, 0, 0, 1, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(38, '迎接创建园林城市的检查', NULL, '2011-10-09 07:06:00', '2011-09-09 18:06:00', 983, 1, 0, 1, 11, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(39, '两米直径圆桌的添加', NULL, '2011-10-11 07:07:00', '2011-10-11 18:07:00', 983, 1, 0, 1, 11, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(40, '教室的校产登记', NULL, '2011-10-10 07:08:00', '2011-10-14 18:08:00', 983, 1, 0, 1, 11, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(41, '十二楼的办公室构隔方案', NULL, '2011-10-13 07:08:00', '2011-10-15 18:08:00', 983, 1, 0, 1, 11, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(42, '体育馆玻璃的维修', NULL, '2011-10-15 07:09:00', '2011-10-15 18:09:00', 983, 1, 0, 1, 11, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(43, '新日程1', 'test', '2011-09-30 17:58:04', '2011-09-30 18:58:04', 1, 1, 1, 1, NULL, 0, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(45, '国庆系列活动', NULL, '2011-10-01 10:23:53', '2011-10-07 11:23:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(46, '制定十月主题教育活动方案', NULL, '2011-10-01 10:25:06', '2011-10-07 11:25:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(48, '各社团招收新成员及规范海报刊登', NULL, '2011-10-01 10:27:20', '2011-10-14 11:27:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(49, '（国庆加班）市督导评估材料准备', NULL, '2011-10-01 10:30:12', '2011-10-07 11:30:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(50, '规范温中学生广播电台', NULL, '2011-10-07 10:31:00', '2011-10-14 11:31:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(52, '7号晚在1106教室进行心理团辅（高二）', NULL, '2011-10-07 10:36:00', '2011-10-08 11:36:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(53, '网络督察用户验证方式启用', NULL, '2011-10-19 16:24:00', '2011-10-21 17:24:00', 946, 1, 0, 1, 10, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(54, '催交工上周工作情况', NULL, '2011-10-15 16:26:47', '2011-10-15 17:26:47', 946, 0, 0, 0, 10, 3, 0, 0, 1, 4, 1, '1;0;0;0;0;0;0', NULL),
(55, '上填下周工作计划（日程）', NULL, '2011-10-15 16:28:11', '2011-10-15 17:28:11', 946, 0, 0, 0, 10, 3, 0, 0, 1, 4, 1, '0;0;0;0;1;0;0', NULL),
(56, '协商安装学习发展系统和考试系统', NULL, '2011-10-17 16:31:00', '2011-10-21 17:31:00', 946, 1, 0, 1, 10, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(57, '12点20在6302各班纪律委员会议', NULL, '2011-10-18 12:20:00', '2011-10-18 17:56:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(58, '17号晚专题黑板报检查', NULL, '2011-10-17 17:00:00', '2011-10-17 18:00:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(59, '21号下午高一各班主题班会', NULL, '2011-10-21 16:02:00', '2011-10-21 17:02:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(60, '利用本周下午第四节高一各班分批参观校国学馆', NULL, '2011-10-17 17:04:00', '2011-10-21 18:04:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(61, '21号下午高一各班召开主题班会', NULL, '2011-10-21 16:07:00', '2011-10-21 17:07:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(62, '上一学期校先进/优秀班主任表彰', NULL, '2011-10-18 17:09:00', '2011-10-18 18:09:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(63, '<温中心理导报>刊出', NULL, '2011-10-15 17:11:30', '2011-10-21 18:11:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(64, '社团招新回执单回收', NULL, '2011-10-17 08:43:01', '2011-10-17 09:43:01', 868, 1, 0, 0, 3, 2, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(65, '独立孔子课堂', '完成在国外办理独立孔子课堂的申报书', '2011-10-17 10:00:00', '2011-10-21 11:00:00', 716, 1, 0, 1, 6, 1, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(66, '宣传小册子', '学校宣传小册子定稿和印制', '2011-10-17 14:20:00', '2011-10-20 16:15:00', 716, 1, 0, 1, 6, 1, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(67, '温中简介', '修改温中简介，温岭日报广告部用，属于辉煌温岭90周年的图册内容。', '2011-10-17 08:10:00', '2011-10-18 15:30:00', 716, 1, 0, 1, 6, 2, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(68, '校报初稿', '基本完成，本周内先修改2次后递交陈校长审阅', '2011-10-17 13:30:00', '2011-10-20 16:30:00', 716, 1, 0, 1, 6, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(69, '大事记', '以后每次周一上午的办公室会议罗列上周学校的主要事项，钟为文记录并在会后根据要求到各处室进行核实和完善信息。第7周的学校的三件大事：法属波利尼西亚教育考察团来校并签订协议；有效教学论坛；督导评估。', '2011-10-17 09:30:00', '2011-10-17 17:00:00', 716, 1, 0, 1, 6, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(70, '教师宣誓', '完成富有温中文化理念的《新分配教师宣誓的誓词》文稿并印制，晚上教工大会上宣读。', '2011-10-18 15:30:00', '2011-10-18 17:30:00', 716, 1, 0, 1, 6, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(71, '教工大会', '今晚6：35在7楼国际会议厅召开全校教职工大会，带笔参加。', '2011-10-18 18:35:00', '2011-10-18 20:35:00', 716, 1, 0, 1, 6, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(72, '对新疆老师的欢送会', '下午举行新疆阿克苏市农一师骨干教师学习交流欢送会', '2011-10-17 15:30:00', '2011-10-17 17:30:00', 716, 1, 0, 1, 6, 1, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(73, '2012年历日记本的样式', '2012年历日记本的样式在本周五（21号）前基本确定', '2011-10-08 13:35:00', '2011-10-21 11:10:00', 716, 1, 0, 1, 6, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(74, '信息上传', '校园网信息上传故障修好后，及时完成9-10月期间的信息上传', '2011-10-19 14:00:00', '2011-10-21 15:30:00', 716, 1, 0, 1, 6, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(75, '创园日程', '19日下午，温岭市创园办来我校最后一次预检，国家园林城市考查验收组将于10月22日下午对我校进行实地考查，为切实做好创园的迎检工作，进一步落实环境整治长效管理措施，确保顺利通过本次考核验收。', '2011-10-17 08:30:00', '2011-10-22 17:00:00', 716, 1, 0, 1, 6, 1, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(76, '申报中学高级对象进行教学水平考核', '通知我校4位今年参加申报中学高级的教师于10月22日上午6：30前凭身份证到台州市实验中学体育馆参加台州市统一组织的课堂教学考核和面试。', '2011-10-17 14:50:00', '2011-10-17 16:50:00', 716, 1, 0, 1, 6, 1, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(77, '校元旦文艺会演准备', NULL, '2011-10-24 16:38:00', '2011-10-29 17:38:00', 946, 1, 0, 1, 10, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(78, '元旦书画比赛准备', NULL, '2011-10-23 16:39:00', '2011-10-29 17:39:00', 946, 1, 0, 1, 10, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(79, '设置部分网络用户固定IP地址启用', NULL, '2011-10-23 16:40:00', '2011-10-29 17:40:00', 946, 1, 0, 1, 10, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(80, '部份班主任座谈会', NULL, '2011-10-26 15:06:00', '2011-10-26 23:06:00', 722, 1, 0, 1, 3, 3, 1, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(81, '周六上午高二,下午高一家长会', NULL, '2011-10-29 08:08:00', '2011-10-29 23:08:00', 722, 1, 0, 1, 3, 1, 1, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(82, '周一下午高一19-24参观国学馆/校史室', NULL, '2011-10-24 16:11:00', '2011-10-24 23:11:00', 722, 1, 0, 1, 3, 3, 1, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(83, '晚上在6302召开教工宿舍住校生会议', NULL, '2011-10-24 18:13:00', '2011-10-24 23:13:00', 722, 1, 0, 1, 3, 1, 1, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(84, '本周内团委负责完成学生干部的统计和造册', NULL, '2011-10-21 22:16:14', '2011-10-29 23:16:00', 722, 1, 0, 1, 3, 1, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(85, '制定十一月主题教育计划', NULL, '2011-10-21 22:18:40', '2011-10-30 23:18:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(86, '校学生田径运动会', NULL, '2011-11-04 07:02:00', '2011-11-05 15:02:00', 946, 1, 0, 1, 10, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(87, '安装数字化实验室电脑', NULL, '2011-10-31 14:14:00', '2011-11-04 15:14:00', 946, 1, 0, 1, 10, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(88, '部署运动会安全保卫等工作', NULL, '2011-10-31 20:13:00', '2011-11-04 21:13:00', 722, 1, 0, 1, 3, 1, 1, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(89, '制定运动会道德风尚奖评比制度', NULL, '2011-10-28 20:17:23', '2011-11-04 21:17:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(90, '落实志愿者服务工作', NULL, '2011-10-28 20:20:36', '2011-11-03 21:20:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(91, '公布温中十一月主题教育安排', NULL, '2011-10-28 20:21:52', '2011-10-31 21:21:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(92, '安排电影观看', NULL, '2011-11-03 20:23:00', '2011-11-04 21:23:00', 722, 1, 0, 1, 3, 3, 1, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(93, '全校十一月主题板报检查', NULL, '2011-11-10 16:53:00', '2011-11-10 21:53:00', 722, 1, 0, 1, 3, 1, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(94, '部署消防安全教育活动', NULL, '2011-11-07 20:54:00', '2011-11-08 21:54:00', 722, 1, 0, 1, 3, 1, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(95, '筹备高二法制报告会', NULL, '2011-11-06 20:56:00', '2011-11-11 21:56:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(96, '组织学生<辛亥革命>观后感/征文比赛', NULL, '2011-11-04 20:58:24', '2011-11-12 21:58:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL),
(97, '编一期红十字<安全专题>小报', NULL, '2011-11-04 21:01:21', '2011-11-11 22:01:00', 722, 1, 0, 1, 3, 3, 0, 0, 0, 0, 1, '0;0;0;0;0;0;0', NULL);

-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_sendingfiles`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_sendingfiles` (
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_oa_sendingfiles`
--


-- --------------------------------------------------------

--
-- 表的结构 `wlzx_oa_sendingfile_flow`
--

CREATE TABLE IF NOT EXISTS `wlzx_oa_sendingfile_flow` (
  `id` bigint(20) NOT NULL auto_increment,
  `type` smallint(4) NOT NULL,
  `is_completed` smallint(4) default NULL,
  `text` text,
  `user_id` bigint(20) NOT NULL,
  `sendingfile_id` bigint(20) NOT NULL,
  `completed_date` datetime default NULL,
  `creation_date` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `wlzx_oa_sendingfile_flow`
--


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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=40 ;

--
-- 转存表中的数据 `wlzx_oa_takeleave_apply`
--

INSERT INTO `wlzx_oa_takeleave_apply` (`id`, `takeLeave_applyNo`, `takeLeave_type`, `takeLeave_teacher_id`, `takeLeave_beginTime`, `takeLeave_endTime`, `takeLeave_reason`, `takeLeave_arrange_tech`, `takeLeave_arrange_tech_deal_already`, `takeLeave_arrange_service`, `takeLeave_arrange_service_deal_already`, `takeLeave_arrange_manage`, `takeLeave_arrange_manage_deal_already`, `takeLeave_officeChief_approver_id`, `takeLeave_officeChief_approve_time`, `takeLeave_officeChief_approve_option`, `takeLeave_officeChief_status`, `takeLeave_vicePrincipal_approver_id`, `takeLeave_vicePrincipal_approve_time`, `takeLeave_vicePrincipal_approve_option`, `takeLeave_vicePrincipal_status`, `takeLeave_principal_approver_id`, `takeLeave_principal_approve_time`, `takeLeave_principal_approve_option`, `takeLeave_principal_status`, `takeLeave_remark`, `takeLeave_status`) VALUES
(2, '20110928053937', 0, 952, '2011-09-27 0', '2011-09-30 0', '1', '1', 0, '1', 0, '1', 0, 946, '2011-09-27 00:00:00', '', 1, 709, '2011-09-28 00:00:00', '同意', 1, NULL, NULL, NULL, NULL, '11', 3),
(3, '20110928160320', 0, 736, '2011-09-28 0', '2011-10-03 0', 'test', 'test', 0, '', 0, '', 0, 733, '2011-09-28 00:00:00', '', 1, 709, '2011-09-28 00:00:00', '', 1, 708, '2011-09-28 00:00:00', NULL, 1, '', 3),
(4, '20110928161633', 0, 737, '2011-09-28 0', '2011-09-29 0', 'test', '1', 0, '2', 0, '3', 0, 946, '2011-09-30 00:00:00', 'test', 1, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', 3),
(5, '20110928182503', 1, 721, '2011-09-29 0', '2011-09-29 1', '参加督导评估听课', '已安排', 0, '已安排', 0, '', 0, 716, '2011-09-28 00:00:00', '', 1, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', 3),
(6, '20110930090456', 1, 1009, '2011-10-08 0', '2011-10-09 1', '培训', '', 0, '', 0, '', 0, 722, '2011-10-09 00:00:00', '', 1, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', 1),
(7, '20110930090644', 1, 1009, '2011-10-17 0', '2011-10-17 1', '培训', '', 0, '', 0, '', 0, 722, '2011-09-30 00:00:00', '', 1, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', 3),
(10, '20111008082238', 0, 775, '2011-10-08 0', '2011-11-07 1', '产假', '', 0, '', 0, '', 0, 733, '2011-10-08 00:00:00', '同意', 1, 709, '2011-10-08 00:00:00', '同意,请备课组提出课务安排建议', 1, NULL, NULL, NULL, NULL, '', 2),
(11, '20111008085615', 1, 779, '2011-10-09 0', '2011-10-10 1', '市大比武评委', '', 0, '', 0, '', 0, 733, '2011-10-08 00:00:00', '同意', 1, 709, '2011-10-08 00:00:00', '同意', 1, NULL, NULL, NULL, NULL, '', 3),
(12, '20111008085802', 1, 787, '2011-10-09 0', '2011-10-10 1', '市大比武评委', '', 0, '', 0, '', 0, 733, '2011-10-08 00:00:00', '同意', 1, 709, '2011-10-08 00:00:00', '同意', 1, NULL, NULL, NULL, NULL, '', 3),
(13, '20111008091222', 1, 737, '2011-10-09 0', '2011-10-09 1', '去松门中学参加大比武评委(教研室安维琪老师通知)', '调课', 0, '提前完成', 0, '无', 0, 733, '2011-10-09 00:00:00', '', 1, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', 3),
(14, '20111008155743', 1, 976, '2011-10-09 0', '2011-10-09 1', '参加温岭市教学大比武上课.', '', 0, '', 0, '', 0, 733, '2011-10-11 00:00:00', '', 1, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', 3),
(15, '20111009090346', 1, 959, '2011-10-10 0', '2011-10-13 1', '参加省优质课评比', '高一由徐敏燕老师代，高二由赵阳老师代', 0, '', 0, '', 0, 946, '2011-10-09 00:00:00', '同意', 1, 709, '2011-10-13 00:00:00', '同意', 1, NULL, NULL, NULL, NULL, '', 2),
(16, '20111009121219', 1, 973, '2011-10-08 0', '2011-10-08 1', '学校指派：去双语上课,上午二节，下午二节', '', 0, '', 0, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0),
(18, '20111010165303', 1, 958, '2011-10-11 0', '2011-10-13 1', '省优质课观摩', '高一由王平波代，高二由王海辉代', 0, '', 0, '', 0, 733, '2011-10-11 00:00:00', '', 1, 709, '2011-10-17 00:00:00', '', 1, NULL, NULL, NULL, NULL, '', 3),
(19, '20111012085555', 1, 727, '2011-10-11 0', '2011-10-11 1', '担任温岭市教研室组织的温岭市大比武评委工作一天', '在自修课补上', 0, '心理咨询工作已交代陈胜男老师帮忙处理', 0, '', 0, 733, '2011-10-13 00:00:00', '', 1, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', 3),
(20, '20111012191956', 1, 936, '2011-10-13 0', '2011-10-14 1', '参加在三门中学中学举行的地区高三地理复习研讨会', '已经教务处调好', 0, '', 0, '', 0, 733, '2011-10-13 00:00:00', '', 1, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', 3),
(21, '20111014094956', 0, 758, '2011-10-16 0', '2011-10-16 0', '生病', '安排学生生做讲义', 0, '', 0, '', 0, 733, '2011-10-16 00:00:00', '', 1, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', 3),
(22, '20111017075318', 1, 973, '2011-10-13 0', '2011-10-13 1', '双语上课三节', '', 0, '', 0, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0),
(23, '20111017101412', 1, 804, '2011-10-17 1', '2011-10-19 1', '参加“浙江省高中英语阅读教研现场会”', '已安排', 0, '', 0, '已安排', 0, 733, '2011-10-17 00:00:00', '', 1, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', 1),
(24, '20111017101436', 1, 791, '2011-10-17 1', '2011-10-19 1', '参加浙江省高中英语阅读教研现场会', '已安排', 0, '', 0, '已安排 ', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0),
(25, '20111017145725', 1, 845, '2011-10-18 0', '2011-10-21 1', '参加省高中数学课堂教学评比观摩', '课已调整', 0, '', 0, '', 0, 733, '2011-10-19 00:00:00', '', 1, 709, '2011-10-19 00:00:00', '', 1, NULL, NULL, NULL, NULL, '', 2),
(26, '20111017184246', 1, 823, '2011-10-18 1', '2011-10-21 1', '去丽水参加浙江省2011年高中数学课堂教学评比暨有效教学论坛活动', '安排学生自学教材，并完成作业', 0, '', 0, '', 0, 733, '2011-10-18 00:00:00', '', 1, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', 1),
(27, '20111018075801', 0, 765, '2011-10-20 0', '2011-10-21 1', '事假', '已安排', 0, '已安排', 0, '已安排', 0, 733, '2011-10-19 00:00:00', '', 1, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', 3),
(28, '20111018082450', 0, 976, '2011-10-25 0', '2011-10-25 0', '台州市高考研究小组成员会议（玉环）', '', 0, '', 0, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 5),
(29, '20111018082630', 1, 976, '2011-10-25 0', '2011-10-25 0', '台州市高考研究小组成员会议（玉环）', '', 0, '', 0, '', 0, 733, '2011-10-19 00:00:00', '', 1, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', 3),
(30, '20111019143806', 1, 923, '2011-10-20 1', '2011-10-21 1', '台州市高考政治指导小组赴三门中学调研', '已调到星期三', 0, '', 0, '', 0, 733, '2011-10-20 00:00:00', '', 1, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', 3),
(31, '20111025085232', 1, 720, '2011-11-02 0', '2011-11-03 1', '参加台州市档案继续教育', '', 0, '', 0, '', 0, 716, '2011-10-27 00:00:00', '', 1, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', 3),
(32, '20111025085408', 1, 719, '2011-11-02 0', '2011-11-03 1', '参加继续教育培训', '', 0, '', 0, '', 0, 716, '2011-10-27 00:00:00', '', 1, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', 3),
(33, '20111025110802', 1, 738, '2011-11-02 0', '2011-11-03 0', '参加台州市档案继续教育培训', '', 0, '', 0, '', 0, 733, '2011-10-25 00:00:00', '', 1, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', 3),
(34, '20111031143608', 1, 976, '2011-11-08 0', '2011-11-11 1', '参加浙江省高中信息技术教师学科能力培训会议（同时在衢州二中开设省公开课）', '已落实', 0, '已落实', 0, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0),
(35, '20111101110638', 1, 872, '2011-11-01 0', '2011-11-03 1', '到桐乡参加教研会                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       ', '由唐斌\\马成代课', 0, '', 0, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0),
(36, '20111103101718', 0, 727, '2011-11-04 0', '2011-11-06 0', '父亲在杭州动手术，需要看护', '', 0, '运动会服务工作已由陈世波老师安排', 0, '', 0, 733, '2011-11-03 00:00:00', '', 1, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', 1),
(37, '20111103160004', 0, 777, '2011-10-31 0', '2011-10-31 1', '护送母亲去杭州住院就医', '由李菊初、张萍老师代课', 0, '', 0, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0),
(38, '20111103165158', 1, 876, '2011-11-03 0', '2011-11-04 0', '非物质文化遗产课题会议', '已安排', 0, '', 0, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0),
(39, '20111103214534', 1, 1009, '2011-11-04 0', '2011-11-06 1', '参加“首届全国学校心理健康教育研讨会”', '', 0, '运动会期间保卫组工作已有张友良老师安排', 0, '', 0, 722, '2011-11-04 00:00:00', '', 1, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', 1);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

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
  PRIMARY KEY  (`id`),
  KEY `operation_object` (`operation_object_type`,`operation_object_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=89 ;

--
-- 转存表中的数据 `wlzx_oa_workflow_log`
--

INSERT INTO `wlzx_oa_workflow_log` (`id`, `operation_object_type`, `operation_object_id`, `operation_teacher_id`, `operation_time`, `operation_name`, `operation_result`) VALUES
(4, 'TakeLeaveWorkFlowLog', 2, 952, '2011-09-28 05:39:37', '发起申请', '生成编号为20110928053937的申请记录'),
(5, 'TakeLeaveWorkFlowLog', 2, 946, '2011-09-28 05:45:26', '处室审批', '处室审批编号为20110928053937的申请通过'),
(6, 'TakeLeaveWorkFlowLog', 3, 736, '2011-09-28 16:03:20', '发起申请', '生成编号为20110928160320的申请记录'),
(7, 'TakeLeaveWorkFlowLog', 3, 733, '2011-09-28 16:09:21', '处室审批', '处室审批编号为20110928160320的申请通过'),
(8, 'TakeLeaveWorkFlowLog', 3, 709, '2011-09-28 16:10:40', '分管副校长审批', '分管副校长审批编号为20110928160320的申请通过'),
(9, 'TakeLeaveWorkFlowLog', 3, 708, '2011-09-28 16:11:26', '校长审批', '校长审批编号为20110928160320的申请通过'),
(10, 'TakeLeaveWorkFlowLog', 4, 737, '2011-09-28 16:16:33', '发起申请', '生成编号为20110928161633的申请记录'),
(11, 'TakeLeaveWorkFlowLog', 5, 721, '2011-09-28 18:25:03', '发起申请', '生成编号为20110928182503的申请记录'),
(12, 'TakeLeaveWorkFlowLog', 5, 716, '2011-09-29 15:24:31', '处室审批', '处室审批编号为20110928182503的申请通过'),
(13, 'TakeLeaveWorkFlowLog', 6, 1009, '2011-09-30 09:04:56', '发起申请', '生成编号为20110930090456的申请记录'),
(14, 'TakeLeaveWorkFlowLog', 7, 1009, '2011-09-30 09:06:44', '发起申请', '生成编号为20110930090644的申请记录'),
(15, 'TakeLeaveWorkFlowLog', 6, 1009, '2011-09-30 09:06:59', '编辑申请', '编辑编号为20110930090456的申请记录'),
(16, 'TakeLeaveWorkFlowLog', 7, 722, '2011-09-30 11:27:09', '处室审批', '处室审批编号为20110930090644的申请通过'),
(17, 'TakeLeaveWorkFlowLog', 6, 722, '2011-09-30 11:27:23', '处室审批', '处室审批编号为20110930090456的申请通过'),
(18, 'TakeLeaveWorkFlowLog', 4, 946, '2011-09-30 15:34:32', '处室审批', '处室审批编号为20110928161633的申请通过'),
(21, 'ApplyWorkFlowLog', 1, 743, '2011-09-30 18:14:03', '发起申请', '生成编号为20110930181403的申请记录'),
(23, 'ApplyWorkFlowLog', 1, 733, '2011-09-30 18:24:47', '课程员安排', '课程员安排编号为20110930181403的调课申请'),
(24, 'ApplyWorkFlowLog', 1, 733, '2011-09-30 18:25:15', '课程处审批', '课程处审批编号为20110930181403的申请通过'),
(25, 'TakeLeaveWorkFlowLog', 10, 775, '2011-10-08 08:22:38', '发起申请', '生成编号为20111008082238的申请记录'),
(26, 'TakeLeaveWorkFlowLog', 10, 733, '2011-10-08 08:53:03', '处室审批', '处室审批编号为20111008082238的申请通过'),
(27, 'TakeLeaveWorkFlowLog', 11, 779, '2011-10-08 08:56:15', '发起申请', '生成编号为20111008085615的申请记录'),
(28, 'TakeLeaveWorkFlowLog', 12, 787, '2011-10-08 08:58:02', '发起申请', '生成编号为20111008085802的申请记录'),
(29, 'TakeLeaveWorkFlowLog', 12, 733, '2011-10-08 09:09:53', '处室审批', '处室审批编号为20111008085802的申请通过'),
(30, 'TakeLeaveWorkFlowLog', 11, 733, '2011-10-08 09:10:11', '处室审批', '处室审批编号为20111008085615的申请通过'),
(31, 'TakeLeaveWorkFlowLog', 13, 737, '2011-10-08 09:12:22', '发起申请', '生成编号为20111008091222的申请记录'),
(32, 'TakeLeaveWorkFlowLog', 10, 709, '2011-10-08 11:04:18', '分管副校长审批', '分管副校长审批编号为20111008082238的申请通过'),
(33, 'TakeLeaveWorkFlowLog', 12, 709, '2011-10-08 11:04:50', '分管副校长审批', '分管副校长审批编号为20111008085802的申请通过'),
(34, 'TakeLeaveWorkFlowLog', 11, 709, '2011-10-08 11:05:15', '分管副校长审批', '分管副校长审批编号为20111008085615的申请通过'),
(35, 'TakeLeaveWorkFlowLog', 14, 976, '2011-10-08 15:57:43', '发起申请', '生成编号为20111008155743的申请记录'),
(36, 'TakeLeaveWorkFlowLog', 15, 959, '2011-10-09 09:03:46', '发起申请', '生成编号为20111009090346的申请记录'),
(37, 'TakeLeaveWorkFlowLog', 16, 973, '2011-10-09 12:12:19', '发起申请', '生成编号为20111009121219的申请记录'),
(38, 'TakeLeaveWorkFlowLog', 15, 946, '2011-10-09 12:17:28', '处室审批', '处室审批编号为20111009090346的申请通过'),
(39, 'TakeLeaveWorkFlowLog', 13, 733, '2011-10-09 12:19:13', '处室审批', '处室审批编号为20111008091222的申请通过'),
(41, 'TakeLeaveWorkFlowLog', 18, 958, '2011-10-10 16:53:03', '发起申请', '生成编号为20111010165303的申请记录'),
(42, 'TakeLeaveWorkFlowLog', 14, 733, '2011-10-11 11:03:36', '课程处审批', '课程处审批编号为20111008155743的申请通过'),
(43, 'TakeLeaveWorkFlowLog', 18, 733, '2011-10-11 11:04:22', '课程处审批', '课程处审批编号为20111010165303的申请通过'),
(44, 'TakeLeaveWorkFlowLog', 19, 727, '2011-10-12 08:55:55', '发起申请', '生成编号为20111012085555的申请记录'),
(45, 'TakeLeaveWorkFlowLog', 20, 936, '2011-10-12 19:19:56', '发起申请', '生成编号为20111012191956的申请记录'),
(46, 'TakeLeaveWorkFlowLog', 19, 733, '2011-10-13 08:12:07', '课程处审批', '课程处审批编号为20111012085555的申请通过'),
(47, 'TakeLeaveWorkFlowLog', 20, 733, '2011-10-13 08:12:40', '课程处审批', '课程处审批编号为20111012191956的申请通过'),
(48, 'TakeLeaveWorkFlowLog', 15, 709, '2011-10-13 16:26:13', '分管教学副校长审批', '分管教学副校长审批编号为20111009090346的申请通过'),
(49, 'TakeLeaveWorkFlowLog', 21, 758, '2011-10-14 09:49:56', '发起申请', '生成编号为20111014094956的申请记录'),
(50, 'TakeLeaveWorkFlowLog', 22, 973, '2011-10-17 07:53:18', '发起申请', '生成编号为20111017075318的申请记录'),
(51, 'TakeLeaveWorkFlowLog', 21, 733, '2011-10-17 10:02:08', '课程处审批', '课程处审批编号为20111014094956的申请通过'),
(52, 'TakeLeaveWorkFlowLog', 23, 804, '2011-10-17 10:14:12', '发起申请', '生成编号为20111017101412的申请记录'),
(53, 'TakeLeaveWorkFlowLog', 24, 791, '2011-10-17 10:14:36', '发起申请', '生成编号为20111017101436的申请记录'),
(54, 'TakeLeaveWorkFlowLog', 18, 709, '2011-10-17 10:53:50', '分管教学副校长审批', '分管教学副校长审批编号为20111010165303的申请通过'),
(55, 'TakeLeaveWorkFlowLog', 2, 709, '2011-10-17 10:55:22', '分管教学副校长审批', '分管教学副校长审批编号为20110928053937的申请通过'),
(56, 'ApplyWorkFlowLog', 2, 972, '2011-10-17 12:11:35', '发起申请', '生成编号为20111017121135的申请记录'),
(57, 'TakeLeaveWorkFlowLog', 25, 845, '2011-10-17 14:57:25', '发起申请', '生成编号为20111017145725的申请记录'),
(58, 'TakeLeaveWorkFlowLog', 26, 823, '2011-10-17 18:42:46', '发起申请', '生成编号为20111017184246的申请记录'),
(59, 'TakeLeaveWorkFlowLog', 27, 765, '2011-10-18 07:58:01', '发起申请', '生成编号为20111018075801的申请记录'),
(60, 'TakeLeaveWorkFlowLog', 27, 765, '2011-10-18 07:58:29', '编辑申请', '编辑编号为20111018075801的申请记录'),
(61, 'TakeLeaveWorkFlowLog', 28, 976, '2011-10-18 08:24:50', '发起申请', '生成编号为20111018082450的申请记录'),
(62, 'TakeLeaveWorkFlowLog', 28, 976, '2011-10-18 08:25:29', '取消申请', '取消编号为20111018082450的申请记录'),
(63, 'TakeLeaveWorkFlowLog', 29, 976, '2011-10-18 08:26:30', '发起申请', '生成编号为20111018082630的申请记录'),
(64, 'ApplyWorkFlowLog', 2, 733, '2011-10-19 12:57:48', '课程员安排', '课程员安排编号为20111017121135的调课申请'),
(65, 'TakeLeaveWorkFlowLog', 25, 733, '2011-10-19 12:59:40', '课程处审批', '课程处审批编号为20111017145725的申请通过'),
(66, 'TakeLeaveWorkFlowLog', 27, 733, '2011-10-19 13:00:18', '课程处审批', '课程处审批编号为20111018075801的申请通过'),
(67, 'TakeLeaveWorkFlowLog', 29, 733, '2011-10-19 13:00:50', '课程处审批', '课程处审批编号为20111018082630的申请通过'),
(68, 'TakeLeaveWorkFlowLog', 30, 923, '2011-10-19 14:38:06', '发起申请', '生成编号为20111019143806的申请记录'),
(69, 'TakeLeaveWorkFlowLog', 25, 709, '2011-10-19 15:05:01', '分管教学副校长审批', '分管教学副校长审批编号为20111017145725的申请通过'),
(70, 'ApplyWorkFlowLog', 2, 733, '2011-10-20 14:35:31', '课程处审批', '课程处审批编号为20111017121135的申请通过'),
(71, 'TakeLeaveWorkFlowLog', 31, 720, '2011-10-25 08:52:32', '发起申请', '生成编号为20111025085232的申请记录'),
(72, 'TakeLeaveWorkFlowLog', 32, 719, '2011-10-25 08:54:08', '发起申请', '生成编号为20111025085408的申请记录'),
(73, 'TakeLeaveWorkFlowLog', 33, 738, '2011-10-25 11:08:02', '发起申请', '生成编号为20111025110802的申请记录'),
(74, 'TakeLeaveWorkFlowLog', 23, 733, '2011-10-25 15:26:33', '课程处审批', '课程处审批编号为20111017101412的申请通过'),
(75, 'TakeLeaveWorkFlowLog', 26, 733, '2011-10-25 15:45:21', '课程处审批', '课程处审批编号为20111017184246的申请通过'),
(76, 'TakeLeaveWorkFlowLog', 30, 733, '2011-10-25 15:46:37', '课程处审批', '课程处审批编号为20111019143806的申请通过'),
(77, 'TakeLeaveWorkFlowLog', 33, 733, '2011-10-25 15:47:00', '处室审批', '处室审批编号为20111025110802的申请通过'),
(78, 'TakeLeaveWorkFlowLog', 31, 716, '2011-10-27 10:21:48', '处室审批', '处室审批编号为20111025085232的申请通过'),
(79, 'TakeLeaveWorkFlowLog', 32, 716, '2011-10-27 10:29:46', '处室审批', '处室审批编号为20111025085408的申请通过'),
(80, 'TakeLeaveWorkFlowLog', 34, 976, '2011-10-31 14:36:08', '发起申请', '生成编号为20111031143608的申请记录'),
(81, 'TakeLeaveWorkFlowLog', 34, 976, '2011-10-31 14:38:50', '编辑申请', '编辑编号为20111031143608的申请记录'),
(82, 'TakeLeaveWorkFlowLog', 35, 872, '2011-11-01 11:06:38', '发起申请', '生成编号为20111101110638的申请记录'),
(83, 'TakeLeaveWorkFlowLog', 36, 727, '2011-11-03 10:17:18', '发起申请', '生成编号为20111103101718的申请记录'),
(84, 'TakeLeaveWorkFlowLog', 36, 733, '2011-11-03 12:03:42', '课程处审批', '课程处审批编号为20111103101718的申请通过'),
(85, 'TakeLeaveWorkFlowLog', 37, 777, '2011-11-03 16:00:04', '发起申请', '生成编号为20111103160004的申请记录'),
(86, 'TakeLeaveWorkFlowLog', 38, 876, '2011-11-03 16:51:58', '发起申请', '生成编号为20111103165158的申请记录'),
(87, 'TakeLeaveWorkFlowLog', 39, 1009, '2011-11-03 21:45:34', '发起申请', '生成编号为20111103214534的申请记录'),
(88, 'TakeLeaveWorkFlowLog', 39, 722, '2011-11-04 20:50:41', '处室审批', '处室审批编号为20111103214534的申请通过');
