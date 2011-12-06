/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50091
Source Host           : localhost:3306
Source Database       : wlzx_basic

Target Server Type    : MYSQL
Target Server Version : 50091
File Encoding         : 65001

Date: 2011-12-06 22:38:31
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `basic_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `basic_teacher`;
CREATE TABLE `basic_teacher` (
  `teacher_id` int(20) NOT NULL auto_increment COMMENT '系统自增编号',
  `user_id` bigint(20) NOT NULL COMMENT '账号外键',
  `teacher_cname` varchar(50) NOT NULL COMMENT '中文名',
  `teacher_sex` smallint(2) default NULL COMMENT '性别',
  `teacher_birthday` date default NULL COMMENT '出生日期',
  `teacher_marrage` smallint(2) default NULL COMMENT '婚姻',
  `teacher_nation` varchar(10) default NULL COMMENT '民族',
  `teacher_politics_status` smallint(2) default NULL COMMENT '政治面貌',
  `teacher_identify` char(20) default NULL COMMENT '身份证',
  `teacher_native_place` varchar(50) default NULL COMMENT '籍贯',
  `teacher_email` varchar(50) default NULL COMMENT '邮箱',
  `teacher_home_phone` varchar(20) default NULL COMMENT '家庭电话',
  `teacher_address` varchar(200) default NULL COMMENT '家庭地址',
  `teacher_mobile_phone` varchar(20) default NULL COMMENT '手机',
  `teacher_no` varchar(20) NOT NULL COMMENT '短号',
  `teacher_education` varchar(10) default NULL COMMENT '最高学历',
  `teacher_profession` varchar(50) default NULL COMMENT '专业',
  `teacher_graduate_school` varchar(100) default NULL COMMENT '毕业院校',
  `teacher_professional_title` varchar(50) default NULL COMMENT '职称',
  `teacher_skill_level` varchar(20) default NULL COMMENT '技能等级',
  `teacher_skill_level_date` date default NULL COMMENT '技能鉴定时间',
  `teacher_department` varchar(50) default NULL COMMENT '部门',
  `teacher_position` varchar(50) default NULL COMMENT '职务',
  `teacher_office_phone` varchar(20) default NULL COMMENT '办公电话',
  `teacher_contact_phone` varchar(50) default NULL COMMENT '紧要联络电话',
  `teacher_work_date` date default NULL COMMENT '何时工作',
  `teacher_attend_date` date default NULL COMMENT '入校时间',
  `teacher_status` tinyint(4) NOT NULL COMMENT '员工状态',
  `teacher_photo_src` varchar(200) default NULL COMMENT '照片地址',
  `teacher_create_date` date NOT NULL COMMENT '创建日期',
  `teacher_modified_date` date NOT NULL COMMENT '修改日期',
  PRIMARY KEY  (`teacher_id`),
  KEY `teacher_no` (`teacher_no`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=313 DEFAULT CHARSET=utf8 COMMENT='教师记录';

-- ----------------------------
-- Records of basic_teacher
-- ----------------------------
INSERT INTO `basic_teacher` VALUES ('3', '708', '陈才锜', '0', '1965-06-30', '1', '汉', '0', '', '温岭', '', '', '', '13906560909', '666888', '3', '', '', '', '', null, '1', '1', '86026888', '', '2011-07-31', '2011-07-05', '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-10-10');
INSERT INTO `basic_teacher` VALUES ('4', '709', '赵海勇', '0', '1976-07-07', '1', '汉', '0', '', '汉', '', '', '', '13505860965', '666900', '3', '', '', '', '', null, '1', '20', '86026900', '', '2009-07-08', '2007-07-04', '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('5', '710', '莫勇军', '0', null, '1', '', '2', '', '', '', '', '', '13606862399', '666988', '3', '', '', '', '', null, '1', '120', '86026988', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('6', '711', '马之骏', '0', null, '1', '', '0', '', '', '', '', '', '13606864810', '666898', '3', '', '', '', '', null, '1', '21', '86026898', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('7', '712', '江正玲', '0', '1965-07-01', '1', '汉', '0', '', '温岭', '', '', '', '13758699555', '668555', '3', '', '', '', '', null, '1', '18', '86026555', '', '2011-07-01', '2011-07-06', '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('8', '713', '郑晓萍', '1', null, '1', '', '2', '', '', '', '', '', '13705865896', '666868', '3', '', '', '', '', null, '1', '19', '86026868', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('10', '715', '林金法', '0', null, '1', '', '2', '', '', '', '', '', '13605862067', '666858', '3', '', '', '', '', null, '1', '120', '86026858', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('11', '716', '李俊成', '0', null, '1', '', '2', '', '', '', '', '', '13758699810', '666810', '3', '', '', '', '', null, '6', '121', '86026999', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-12-02');
INSERT INTO `basic_teacher` VALUES ('12', '717', '林向荣', '0', null, '1', '', '2', '', '', '', '', '', '13958676629', '665305', '3', '', '', '', '', null, '6', '122', '86026999', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('13', '718', '肖健', '0', '1971-05-10', '1', '汉', '2', '', '温岭', '', '', '', '13600588110', '660001', '3', '', '', '', '', null, '6', '123', '86026001', '', '1992-02-05', '1992-02-05', '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('14', '719', '王茜', '1', null, '1', '', '2', '', '', '', '', '', '13958675131', '666995', '3', '', '', '', '', null, '6', '131', '86026000', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('15', '720', '钟为文', '1', null, '1', '', '2', '', '', '', '', '', '13758699966', '666966', '0', '', '', '', '', null, '6', '130', '86026966', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('16', '721', '王波', '1', null, '1', '', '2', '', '', '', '', '', '13758693228', '666288', '3', '', '', '', '', null, '6', '127', '86026001', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('17', '722', '陈世波', '0', null, '1', '', '2', '', '', '', '', '', '13758699680', '666680', '3', '', '', '', '', null, '3', '121', '86026002', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('18', '723', '张友良', '0', null, '1', '', '2', '', '', '', '', '', '13906864598', '666833', '3', '', '', '', '', null, '3', '122', '86026002', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-15');
INSERT INTO `basic_teacher` VALUES ('20', '725', '毛雪芬', '1', null, '1', '', '2', '', '', '', '', '', '13758699776', '666776', '3', '', '', '', '', null, '18', '128', '86026776', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('21', '726', '沈林丽', '1', null, '1', '', '2', '', '', '', '', '', '13958675151', '665151', '3', '', '', '', '', null, '28', '129', '86026857', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('22', '727', '陈晓丽', '1', null, '1', '', '2', '', '', '', '', '', '13758699863', '666863', '3', '', '', '', '', null, '3', '128', '86026863', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-10-13');
INSERT INTO `basic_teacher` VALUES ('23', '728', '孙韶红', '1', null, '1', '', '2', '', '', '', '', '', '13819608165', '668165', '3', '', '', '', '', null, '3', '127', '86026027', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('24', '729', '陶腾江', '0', null, '1', '', '2', '', '', '', '', '', '13858688068', '668068', '3', '', '', '', '', null, '3', '128', '86026022', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-10-13');
INSERT INTO `basic_teacher` VALUES ('25', '730', '郭修根', '1', null, '1', '', '2', '', '', '', '', '', '13958666655', '669898', '3', '', '', '', '', null, '28', '129', '28056121', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('26', '731', '周信中', '0', null, '1', '', '2', '', '', '', '', '', '13758699861', '666861', '3', '', '', '', '', null, '3', '127', '86026861', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-10-10');
INSERT INTO `basic_teacher` VALUES ('27', '732', '李小平', '0', null, '1', '', '2', '', '', '', '', '', '13958676080', '666993', '3', '', '', '', '', null, '3', '127', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('28', '733', '江敏', '0', '1967-07-01', '1', '汉', '0', '', '温岭', '', '', '', '13958675138', '666756', '3', '', '', '', '', null, '12', '121', '86026003', '', '2002-07-01', '2011-07-01', '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('29', '734', '何小怡', '1', null, '1', '', '2', '', '', '', '', '', '13958649229', '666651', '3', '', '', '', '', null, '12', '122', '86026651', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('30', '735', '张雯菁', '1', null, '1', '', '2', '', '', '', '', '', '13758699869', '666869', '3', '', '', '', '', null, '10', '122', '86026869', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('31', '736', '江维荣', '0', null, '1', '', '2', '', '', '', '', '', '13958675196', '666870', '3', '', '', '', '', null, '12', '132', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('32', '737', '江艳萍', '1', null, '1', '', '2', '', '', '', '', '', '13758699871', '666871', '3', '', '', '', '', null, '12', '127', '86026871', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('33', '738', '孙玲君', '1', null, '1', '', '2', '', '', '', '', '', '13758699872', '666872', '3', '', '', '', '', null, '12', '127', '86026872', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('34', '739', '陈正康', '0', null, '1', '', '2', '', '', '', '', '', '13758699873', '666873', '3', '', '', '', '', null, '12', '127', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('36', '741', '柳相庆', '0', null, '1', '', '2', '', '', '', '', '', '13758699922', '666922', '3', '', '', '', '', null, '12', '127', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('37', '742', '林晓滨', '0', null, '1', '', '2', '', '', '', '', '', '13758699611', '666611', '3', '', '', '', '', null, '13', '133', '86026611', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('38', '743', '蒋晓南', '0', null, '1', '', '2', '', '', '', '', '', '13958675122', '666602', '3', '', '', '', '', null, '13', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('39', '744', '陈子田', '0', null, '1', '', '2', '', '', '', '', '', '13758699603', '666603', '3', '', '', '', '', null, '13', '128', '86026603', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('40', '745', '钟春晓', '1', null, '1', '', '2', '', '', '', '', '', '13758699606', '666606', '3', '', '', '', '', null, '13', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('41', '746', '管彦斌', '0', null, '1', '', '2', '', '', '', '', '', '13758699608', '666608', '3', '', '', '', '', null, '13', '128', '86026608', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('42', '747', '郭定吉', '0', null, '1', '', '2', '', '', '', '', '', '13758699609', '666609', '3', '', '', '', '', null, '13', '128', '86026609', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('43', '748', '王玉琴', '1', null, '1', '', '2', '', '', '', '', '', '13758699610', '666610', '3', '', '', '', '', null, '13', '128', '86026610', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('44', '749', '王灵萍', '1', null, '1', '', '2', '', '', '', '', '', '13505861082', '666612', '3', '', '', '', '', null, '13', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('45', '750', '杨华', '1', null, '1', '', '2', '', '', '', '', '', '13758699613', '666613', '3', '', '', '', '', null, '13', '128', '86026613', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('46', '751', '田继松', '0', null, '1', '', '2', '', '', '', '', '', '13758699615', '666615', '3', '', '', '', '', null, '13', '128', '86026615', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('47', '752', '张菁强', '0', null, '1', '', '2', '', '', '', '', '', '13758699616', '666616', '3', '', '', '', '', null, '13', '128', '86026616', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('48', '753', '李荣华', '0', null, '1', '', '2', '', '', '', '', '', '13758699617', '666617', '3', '', '', '', '', null, '13', '128', '86026617', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('49', '754', '王增松', '0', null, '1', '', '2', '', '', '', '', '', '13705867899', '600899', '3', '', '', '', '', null, '13', '128', '86026619', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('50', '755', '王赛云', '0', null, '1', '', '2', '', '', '', '', '', '13758699620', '666620', '3', '', '', '', '', null, '13', '128', '86026620', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('51', '756', '李迅若', '1', null, '1', '', '2', '', '', '', '', '', '13958667266', '666621', '3', '', '', '', '', null, '13', '128', '86026621', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('52', '757', '王同光', '1', null, '1', '', '2', '', '', '', '', '', '13758699622', '666622', '3', '', '', '', '', null, '13', '128', '86026622', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('53', '758', '李淑华', '1', null, '1', '', '2', '', '', '', '', '', '13758699623', '666623', '3', '', '', '', '', null, '13', '128', '86026623', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('54', '759', '王新娟', '1', null, '1', '', '2', '', '', '', '', '', '13758699626', '666626', '3', '', '', '', '', null, '13', '128', '86026626', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('55', '760', '郑丽霞', '1', null, '1', '', '2', '', '', '', '', '', '13758699627', '666627', '3', '', '', '', '', null, '13', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('56', '761', '胡素娥', '1', null, '1', '', '2', '', '', '', '', '', '13758699639', '666629', '3', '', '', '', '', null, '13', '128', '86026629', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('57', '762', '张莹', '1', null, '1', '', '2', '', '', '', '', '', '13958676163', '666631', '3', '', '', '', '', null, '13', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('58', '763', '江永夫', '1', null, '1', '', '2', '', '', '', '', '', '13758699632', '666632', '3', '', '', '', '', null, '13', '128', '86026632', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('59', '764', '管希文', '1', null, '1', '', '2', '', '', '', '', '', '13566681439', '666633', '3', '', '', '', '', null, '13', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('60', '765', '朱海平', '1', null, '1', '', '2', '', '', '', '', '', '13705866622', '666635', '3', '', '', '', '', null, '13', '128', '86026635', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('61', '766', '刘凤岭', '1', null, '1', '', '2', '', '', '', '', '', '13758699637', '666637', '3', '', '', '', '', null, '13', '128', '86026637', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('62', '767', '梁斌', '1', null, '1', '', '2', '', '', '', '', '', '13758655209', '666258', '3', '', '', '', '', null, '13', '128', '86026258', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('63', '768', '潘玲斐', '1', null, '1', '', '2', '', '', '', '', '', '13758690558', '666558', '3', '', '', '', '', null, '13', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('64', '769', '朱慧', '1', null, '1', '', '2', '', '', '', '', '', '13858681010', '666256', '3', '', '', '', '', null, '13', '128', '86026256', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('65', '770', '林芝', '1', null, '1', '', '2', '', '', '', '', '', '13758699607', '666607', '3', '', '', '', '', null, '13', '128', '86026607', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('66', '771', '郑伟荣', '1', null, '1', '', '2', '', '', '', '', '', '13586228961', '668961', '3', '', '', '', '', null, '13', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('68', '773', '张亦锋', '1', null, '1', '', '2', '', '', '', '', '', '13758699705', '669261', '3', '', '', '', '', null, '13', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('69', '774', '钟可慧', '1', null, '1', '', '2', '', '', '', '', '', '15958651717', '661717', '3', '', '', '', '', null, '13', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('70', '775', '戴玲斐', '1', null, '1', '', '2', '', '', '', '', '', '13906868870', '668870', '3', '', '', '', '', null, '13', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('72', '777', '吕娅', '1', null, '1', '', '2', '', '', '', '', '', '13958675110', '666652', '3', '', '', '', '', null, '14', '133', '86026652', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-10-08');
INSERT INTO `basic_teacher` VALUES ('73', '778', '梁襄军', '1', null, '1', '', '2', '', '', '', '', '', '13758699500', '666500', '3', '', '', '', '', null, '14', '128', '86026500', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('74', '779', '管菊花', '1', null, '1', '', '2', '', '', '', '', '', '13758699653', '666653', '3', '', '', '', '', null, '14', '128', '86026653', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('75', '780', '陈彩霞', '1', null, '1', '', '2', '', '', '', '', '', '13758699655', '666655', '3', '', '', '', '', null, '14', '128', '86026655', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('76', '781', '金智明', '1', null, '1', '', '2', '', '', '', '', '', '13605862066', '666656', '3', '', '', '', '', null, '14', '128', '86026656', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('77', '782', '林萍', '1', null, '1', '', '2', '', '', '', '', '', '13758699658', '666658', '3', '', '', '', '', null, '14', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('78', '783', '李建华', '0', null, '1', '', '2', '', '', '', '', '', '13758699659', '666659', '3', '', '', '', '', null, '14', '128', '86026659', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('79', '784', '徐佩华', '1', null, '1', '', '2', '', '', '', '', '', '13758699660', '666660', '3', '', '', '', '', null, '14', '128', '86026660', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('80', '785', '李菊初', '1', null, '1', '', '2', '', '', '', '', '', '13758699662', '666662', '3', '', '', '', '', null, '14', '128', '86026662', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('81', '786', '陈颖颖', '1', null, '1', '', '2', '', '', '', '', '', '13758699663', '666663', '3', '', '', '', '', null, '14', '128', '86026663', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('82', '787', '金巧萍', '1', null, '1', '', '2', '', '', '', '', '', '13758699668', '666668', '3', '', '', '', '', null, '14', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('83', '788', '陈华', '1', null, '1', '', '2', '', '', '', '', '', '13758699669', '666669', '3', '', '', '', '', null, '14', '128', '86026669', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('84', '789', '唐娟', '1', null, '1', '', '2', '', '', '', '', '', '13958675120', '666667', '3', '', '', '', '', null, '14', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('85', '790', '葛扬春', '1', null, '1', '', '2', '', '', '', '', '', '13758699670', '666670', '3', '', '', '', '', null, '14', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('86', '791', '赵丽红', '1', null, '1', '', '2', '', '', '', '', '', '13758699671', '666671', '3', '', '', '', '', null, '14', '128', '86026671', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('87', '792', '马鸣', '1', null, '1', '', '2', '', '', '', '', '', '13605861540', '661540', '3', '', '', '', '', null, '14', '128', '86026673', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('88', '793', '叶丽娜', '1', null, '1', '', '2', '', '', '', '', '', '13758699676', '666676', '3', '', '', '', '', null, '14', '128', '86026676', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('89', '794', '张琴', '1', null, '1', '', '2', '', '', '', '', '', '13758699677', '666677', '3', '', '', '', '', null, '14', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('90', '795', '颜素芬', '1', null, '1', '', '2', '', '', '', '', '', '13758699678', '666678', '3', '', '', '', '', null, '14', '128', '86026678', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('91', '796', '陈子祥', '0', null, '1', '', '2', '', '', '', '', '', '13566682711', '666679', '3', '', '', '', '', null, '14', '128', '86026679', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('92', '797', '江丽云', '1', null, '1', '', '2', '', '', '', '', '', '13758699681', '666681', '3', '', '', '', '', null, '14', '128', '86026681', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('93', '798', '陈军红', '1', null, '1', '', '2', '', '', '', '', '', '13758699682', '666682', '3', '', '', '', '', null, '14', '128', '86026682', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('94', '799', '金小微', '1', null, '1', '', '2', '', '', '', '', '', '13958658568', '666568', '3', '', '', '', '', null, '14', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('95', '800', '林中华', '0', null, '1', '', '2', '', '', '', '', '', '13858646755', '666518', '3', '', '', '', '', null, '14', '128', '86026518', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('96', '801', '洪峰', '1', null, '1', '', '2', '', '', '', '', '', '13758699605', '666605', '3', '', '', '', '', null, '14', '128', '86026605', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('97', '802', '马君', '1', null, '1', '', '2', '', '', '', '', '', '13758699625', '666625', '3', '', '', '', '', null, '14', '128', '86026625', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('98', '803', '阮慧健', '0', null, '1', '', '2', '', '', '', '', '', '13758699771', '669771', '3', '', '', '', '', null, '14', '128', '86026958', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('99', '804', '张卫', '1', null, '1', '', '2', '', '', '', '', '', '13758699657', '666657', '3', '', '', '', '', null, '14', '128', '86026657', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('100', '805', '张萍', '1', null, '1', '', '2', '', '', '', '', '', '13758670369', '666927', '3', '', '', '', '', null, '14', '128', '86026927', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('101', '806', '郑丽', '1', null, '1', '', '2', '', '', '', '', '', '13758699638', '666638', '3', '', '', '', '', null, '14', '128', '86026638', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('102', '807', '陈牡丹', '1', null, '1', '', '2', '', '', '', '', '', '13586240383', '660383', '3', '', '', '', '', null, '14', '128', '86026675', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('103', '808', '陈星', '1', null, '1', '', '2', '', '', '', '', '', '13758699300', '665589', '3', '', '', '', '', null, '14', '128', '86026665', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('104', '809', '陈玲', '1', null, '1', '', '2', '', '', '', '', '', '13758638805', '668805', '3', '', '', '', '', null, '14', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('105', '810', '莫晓宇', '1', null, '1', '', '2', '', '', '', '', '', '13958621858', '661858', '3', '', '', '', '', null, '14', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('107', '812', '陈恩祥', '0', null, '1', '', '2', '', '', '', '', '', '13758699691', '666691', '3', '', '', '', '', null, '15', '133', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('108', '813', '陈兆明', '0', null, '1', '', '2', '', '', '', '', '', '13958663163', '666690', '3', '', '', '', '', null, '15', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('109', '814', '张仁达', '0', null, '1', '', '2', '', '', '', '', '', '13758699686', '666686', '3', '', '', '', '', null, '15', '128', '86026686', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('110', '815', '叶国池', '0', null, '1', '', '2', '', '', '', '', '', '13758699687', '666687', '3', '', '', '', '', null, '15', '128', '86026687', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('111', '816', '施崇友', '0', null, '1', '', '2', '', '', '', '', '', '13758699688', '666688', '3', '', '', '', '', null, '15', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('112', '817', '戴素芬', '1', null, '1', '', '2', '', '', '', '', '', '13758699689', '666689', '3', '', '', '', '', null, '15', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('113', '818', '金海华', '0', null, '1', '', '2', '', '', '', '', '', '13758660576', '660576', '3', '', '', '', '', null, '15', '128', '86026693', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('114', '819', '王旭媚', '1', null, '1', '', '2', '', '', '', '', '', '13575859159', '666695', '3', '', '', '', '', null, '15', '128', '86026695', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('115', '820', '陈国华', '0', null, '1', '', '2', '', '', '', '', '', '13606677671', '666697', '3', '', '', '', '', null, '15', '128', '86026697', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('116', '821', '阎大贵', '0', null, '1', '', '2', '', '', '', '', '', '13758699698', '666698', '3', '', '', '', '', null, '15', '128', '86026698', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('117', '822', '林新华', '0', null, '1', '', '2', '', '', '', '', '', '13758699700', '666700', '3', '', '', '', '', null, '15', '128', '86026700', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('118', '823', '陈军杰', '0', null, '1', '', '2', '', '', '', '', '', '13867687195', '666701', '3', '', '', '', '', null, '15', '128', '86026701', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('119', '824', '陈素凤', '1', null, '1', '', '2', '', '', '', '', '', '13758699702', '666702', '3', '', '', '', '', null, '15', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('120', '825', '王文杰', '0', null, '1', '', '2', '', '', '', '', '', '13758699703', '666703', '3', '', '', '', '', null, '15', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('121', '826', '周维永', '0', null, '1', '', '2', '', '', '', '', '', '13586278066', '668066', '3', '', '', '', '', null, '15', '128', '86026705', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('122', '827', '朱东明', '0', null, '1', '', '2', '', '', '', '', '', '13958675112', '666706', '3', '', '', '', '', null, '15', '128', '86026706', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('123', '828', '钟加增', '0', null, '1', '', '2', '', '', '', '', '', '13586297112', '666708', '3', '', '', '', '', null, '15', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('124', '829', '蒋招礼', '0', null, '1', '', '2', '', '', '', '', '', '13758699709', '666709', '3', '', '', '', '', null, '15', '128', '86026709', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('125', '830', '王玉龙', '0', null, '1', '', '2', '', '', '', '', '', '13575888097', '666710', '3', '', '', '', '', null, '15', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('126', '831', '莫子清', '0', null, '1', '', '2', '', '', '', '', '', '13806566297', '666711', '3', '', '', '', '', null, '15', '128', '86026711', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('127', '832', '王文卿', '0', null, '1', '', '2', '', '', '', '', '', '13758699712', '666712', '3', '', '', '', '', null, '15', '128', '86026712', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('128', '833', '郭丽云', '1', null, '1', '', '2', '', '', '', '', '', '13758699713', '666713', '3', '', '', '', '', null, '15', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('129', '834', '王林祥', '0', null, '1', '', '2', '', '', '', '', '', '13989646855', '666715', '3', '', '', '', '', null, '15', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('130', '835', '王华君', '0', null, '1', '', '2', '', '', '', '', '', '13758699716', '666716', '3', '', '', '', '', null, '15', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('131', '836', '王柯山', '0', null, '1', '', '2', '', '', '', '', '', '13758699717', '666717', '3', '', '', '', '', null, '15', '128', '86026717', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('132', '837', '陈丽华', '1', null, '1', '', '2', '', '', '', '', '', '13758699718', '666718', '3', '', '', '', '', null, '15', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('133', '838', '狄理磊', '0', null, '1', '', '2', '', '', '', '', '', '13758699719', '666719', '3', '', '', '', '', null, '15', '128', '86026719', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('134', '839', '王才岳', '0', null, '1', '', '2', '', '', '', '', '', '13758699261', '666261', '3', '', '', '', '', null, '15', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('135', '840', '吴颖微', '1', null, '1', '', '2', '', '', '', '', '', '13758699262', '666262', '3', '', '', '', '', null, '15', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('136', '841', '李清娟', '1', null, '1', '', '2', '', '', '', '', '', '13858660126', '666263', '3', '', '', '', '', null, '15', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('137', '842', '杨兴', '1', null, '1', '', '2', '', '', '', '', '', '13758699265', '666265', '3', '', '', '', '', null, '15', '128', '86026265', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('138', '843', '孙海琴', '1', null, '1', '', '2', '', '', '', '', '', '13600588666', '666707', '3', '', '', '', '', null, '15', '128', '86026707', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('139', '844', '瞿永刚', '0', null, '1', '', '2', '', '', '', '', '', '13758699270', '669270', '3', '', '', '', '', null, '15', '128', '86026270', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('140', '845', '毛永斌', '0', null, '1', '', '2', '', '', '', '', '', '13575859123', '669123', '3', '', '', '', '', null, '15', '128', '86026820', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('141', '846', '林丽卫', '1', null, '1', '', '2', '', '', '', '', '', '13758697818', '668818', '3', '', '', '', '', null, '15', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('142', '847', '闻丹', '1', null, '1', '', '2', '', '', '', '', '', '13758650560', '660560', '3', '', '', '', '', null, '15', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('143', '848', '叶灵娅', '1', null, '1', '', '2', '', '', '', '', '', '13958663331', '663331', '3', '', '', '', '', null, '15', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('144', '849', '陈宏', '0', null, '1', '', '2', '', '', '', '', '', '13758699720', '666720', '3', '', '', '', '', null, '16', '133', '86026720', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('145', '850', '李晨康', '0', null, '1', '', '2', '', '', '', '', '', '13758699722', '666722', '3', '', '', '', '', null, '16', '128', '86026722', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('146', '851', '金素娥', '1', null, '1', '', '2', '', '', '', '', '', '13505866466', '666723', '3', '', '', '', '', null, '16', '128', '86026723', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('147', '852', '金云地', '0', null, '1', '', '2', '', '', '', '', '', '13758699726', '666726', '3', '', '', '', '', null, '16', '128', '86026726', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('148', '853', '张勇勤', '1', null, '1', '', '2', '', '', '', '', '', '13758699727', '666727', '3', '', '', '', '', null, '16', '128', '86026727', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('149', '854', '林明志', '1', null, '1', '', '2', '', '', '', '', '', '13705860336', '660336', '3', '', '', '', '', null, '16', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('150', '855', '刘岳球', '0', null, '1', '', '2', '', '', '', '', '', '13758699730', '666730', '3', '', '', '', '', null, '16', '128', '86026730', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('151', '856', '杨小平', '0', null, '1', '', '2', '', '', '', '', '', '13758699731', '666731', '3', '', '', '', '', null, '16', '128', '86026731', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('152', '857', '潘建军', '0', null, '1', '', '2', '', '', '', '', '', '13958675127', '666732', '3', '', '', '', '', null, '16', '128', '86026732', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('153', '858', '毛伟', '0', null, '1', '', '2', '', '', '', '', '', '13758699733', '666733', '3', '', '', '', '', null, '16', '128', '86026733', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('154', '859', '徐锦忠', '0', null, '1', '', '2', '', '', '', '', '', '13606678282', '666735', '3', '', '', '', '', null, '16', '128', '86026735', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('155', '860', '陈云晨', '0', null, '1', '', '2', '', '', '', '', '', '13676667398', '667398', '3', '', '', '', '', null, '16', '128', '86026736', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('156', '861', '陈林龙', '0', null, '1', '', '2', '', '', '', '', '', '13758699737', '666737', '3', '', '', '', '', null, '16', '128', '86026737', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('157', '862', '蔡海勇', '0', null, '1', '', '2', '', '', '', '', '', '13758699738', '666738', '3', '', '', '', '', null, '16', '128', '86026738', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('158', '863', '马成', '0', null, '1', '', '2', '', '', '', '', '', '13758699739', '666739', '3', '', '', '', '', null, '16', '128', '86026739', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('159', '864', '吴宇', '0', null, '1', '', '2', '', '', '', '', '', '13867612868', '666883', '3', '', '', '', '', null, '16', '128', '86026883', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('160', '865', '唐斌', '0', null, '1', '', '2', '', '', '', '', '', '13758699266', '666266', '3', '', '', '', '', null, '16', '128', '86026266', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('161', '866', '周韬', '0', null, '1', '', '2', '', '', '', '', '', '13758699463', '666463', '3', '', '', '', '', null, '16', '128', '86026463', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('162', '867', '施仁贵', '0', null, '1', '', '2', '', '', '', '', '', '13605864570', '666867', '3', '', '', '', '', null, '16', '128', '86026867', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('163', '868', '江志云', '0', null, '1', '', '2', '', '', '', '', '', '13819667720', '667720', '3', '', '', '', '', null, '3', '125', '86026267', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('164', '869', '刘同正', '0', null, '1', '', '2', '', '', '', '', '', '13906868043', '666929', '3', '', '', '', '', null, '16', '128', '86026929', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('165', '870', '王彩清', '1', null, '1', '', '2', '', '', '', '', '', '13758699750', '666750', '3', '', '', '', '', null, '16', '128', '86026750', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('166', '871', '林崇军', '0', null, '1', '', '2', '', '', '', '', '', '13606866362', '666362', '3', '', '', '', '', null, '16', '128', '86026725', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('167', '872', '江丽芳', '1', null, '1', '', '2', '', '', '', '', '', '13758686678', '667678', '3', '', '', '', '', null, '16', '128', '86198610', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('168', '873', '叶贤青', '1', null, '1', '', '2', '', '', '', '', '', '13758635328', '665328', '3', '', '', '', '', null, '16', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('169', '874', '应崇杨', '0', null, '1', '', '2', '', '', '', '', '', '13676699695', '669695', '3', '', '', '', '', null, '16', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('170', '875', '郭仁勇', '0', null, '1', '', '2', '', '', '', '', '', '13586266058', '666058', '3', '', '', '', '', null, '16', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('171', '876', '杨丫男', '1', null, '1', '', '2', '', '', '', '', '', '15967667322', '667322', '3', '', '', '', '', null, '16', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('172', '877', '沈中河', '0', null, '1', '', '2', '', '', '', '', '', '13758699751', '666751', '3', '', '', '', '', null, '17', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('173', '878', '赵坚志', '0', null, '1', '', '2', '', '', '', '', '', '13758699752', '666752', '3', '', '', '', '', null, '17', '128', '86026752', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('174', '879', '梁宗清', '0', null, '1', '', '2', '', '', '', '', '', '13758699753', '666753', '3', '', '', '', '', null, '17', '128', '86026753', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('176', '881', '张军富', '1', null, '1', '', '2', '', '', '', '', '', '13958675137', '666757', '3', '', '', '', '', null, '17', '128', '86026757', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('177', '882', '陈成', '1', null, '1', '', '2', '', '', '', '', '', '13758699760', '666760', '3', '', '', '', '', null, '17', '128', '86026760', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('178', '883', '夏洪方', '0', null, '1', '', '2', '', '', '', '', '', '13758699761', '666761', '3', '', '', '', '', null, '17', '133', '86026761', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('179', '884', '邹丽萍', '1', null, '1', '', '2', '', '', '', '', '', '13958675105', '666763', '3', '', '', '', '', null, '17', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('180', '885', '赵剑慧', '0', null, '1', '', '2', '', '', '', '', '', '13758699766', '666766', '3', '', '', '', '', null, '17', '128', '86026766', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('181', '886', '陈均辉', '0', null, '1', '', '2', '', '', '', '', '', '13606861003', '666767', '3', '', '', '', '', null, '17', '128', '86026767', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('182', '887', '陈学海', '0', null, '1', '', '2', '', '', '', '', '', '13758699768', '666768', '3', '', '', '', '', null, '17', '128', '86026768', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('183', '888', '谢素兰', '1', null, '1', '', '2', '', '', '', '', '', '13758699769', '666769', '3', '', '', '', '', null, '17', '128', '86026769', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('184', '889', '林百飞', '1', null, '1', '', '2', '', '', '', '', '', '13858641060', '666770', '3', '', '', '', '', null, '17', '128', '86026770', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('185', '890', '姜瑞华', '1', null, '1', '', '2', '', '', '', '', '', '13566676969', '666969', '3', '', '', '', '', null, '17', '128', '86026771', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('186', '891', '林敏燕', '1', null, '1', '', '2', '', '', '', '', '', '13586226070', '666772', '3', '', '', '', '', null, '17', '128', '86198631', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('187', '892', '张达', '1', null, '1', '', '2', '', '', '', '', '', '13575881723', '661723', '3', '', '', '', '', null, '17', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('188', '893', '余卜秋', '0', null, '1', '', '2', '', '', '', '', '', '13505860199', '666773', '3', '', '', '', '', null, '17', '128', '86026773', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('189', '894', '吴君华', '1', null, '1', '', '2', '', '', '', '', '', '13738654159', '664159', '3', '', '', '', '', null, '17', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('190', '895', '金杨波', '0', null, '1', '', '2', '', '', '', '', '', '13566682662', '662662', '3', '', '', '', '', null, '17', '128', '86198615', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('191', '896', '赵希瑛', '1', null, '1', '', '2', '', '', '', '', '', '13958662290', '660922', '3', '', '', '', '', null, '17', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('192', '897', '潘晓斐', '1', null, '1', '', '2', '', '', '', '', '', '13958687186', '667186', '3', '', '', '', '', null, '17', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('193', '898', '陈永发', '0', null, '1', '', '2', '', '', '', '', '', '13758668807', '668807', '3', '', '', '', '', null, '17', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('194', '899', '朱小荣', '0', null, '1', '', '2', '', '', '', '', '', '13958617977', '667977', '3', '', '', '', '', null, '17', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('195', '900', '江永仁', '1', null, '1', '', '2', '', '', '', '', '', '13867639167', '669167', '3', '', '', '', '', null, '17', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('196', '901', '梁茶夫', '1', null, '1', '', '2', '', '', '', '', '', '13758699779', '666779', '3', '', '', '', '', null, '18', '133', '86026779', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('197', '902', '林芽夫', '0', null, '1', '', '2', '', '', '', '', '', '13758699775', '660775', '3', '', '', '', '', null, '18', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('198', '903', '冯素媛', '1', null, '1', '', '2', '', '', '', '', '', '13958676006', '666778', '3', '', '', '', '', null, '18', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('199', '904', '蒋连章', '0', null, '1', '', '2', '', '', '', '', '', '13758699780', '666780', '3', '', '', '', '', null, '18', '128', '86026780', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('200', '905', '黄建玲', '0', null, '1', '', '2', '', '', '', '', '', '13958676017', '666781', '3', '', '', '', '', null, '18', '128', '86026781', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('201', '906', '蔡海霞', '1', null, '1', '', '2', '', '', '', '', '', '13586229848', '666783', '3', '', '', '', '', null, '18', '128', '86026783', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('202', '907', '胡丹艳', '1', null, '1', '', '2', '', '', '', '', '', '13958666025', '666268', '3', '', '', '', '', null, '18', '128', '86026268', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('203', '908', '夏冰姿', '1', null, '1', '', '2', '', '', '', '', '', '13758699759', '666759', '3', '', '', '', '', null, '18', '128', '86026008', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('204', '909', '曹金真', '0', null, '1', '', '2', '', '', '', '', '', '13758699800', '666800', '3', '', '', '', '', null, '18', '128', '86026800', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('205', '910', '林君', '1', null, '1', '', '2', '', '', '', '', '', '13486869686', '661686', '3', '', '', '', '', null, '18', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('206', '911', '钟克亚', '1', null, '1', '', '2', '', '', '', '', '', '13758635185', '665185', '3', '', '', '', '', null, '18', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('207', '912', '毛灵芝', '1', null, '1', '', '2', '', '', '', '', '', '13738651848', '661848', '3', '', '', '', '', null, '18', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('208', '913', '李欢欢', '0', null, '1', '', '2', '', '', '', '', '', '13666825586', '660586', '3', '', '', '', '', null, '18', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('209', '914', '吴娴静', '1', null, '1', '', '2', '', '', '', '', '', '13958697930', '667930', '3', '', '', '', '', null, '18', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('210', '915', '叶妙水', '0', null, '1', '', '2', '', '', '', '', '', '13758699286', '669286', '3', '', '', '', '', null, '18', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('211', '916', '阮华清', '1', null, '1', '', '2', '', '', '', '', '', '13758699785', '666788', '3', '', '', '', '', null, '19', '133', '86026785', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('212', '917', '蒋法其', '0', null, '1', '', '2', '', '', '', '', '', '13958676169', '666786', '3', '', '', '', '', null, '19', '128', '86026786', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('213', '918', '李清', '0', null, '1', '', '2', '', '', '', '', '', '13758699787', '666787', '3', '', '', '', '', null, '19', '128', '86026787', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('214', '919', '胡强辉', '0', null, '1', '', '2', '', '', '', '', '', '13736552841', '662841', '3', '', '', '', '', null, '19', '128', '86026788', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('215', '920', '王玉红', '1', null, '1', '', '2', '', '', '', '', '', '13758699790', '666790', '3', '', '', '', '', null, '19', '128', '86026790', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('216', '921', '王海波', '1', null, '1', '', '2', '', '', '', '', '', '13758656777', '666792', '3', '', '', '', '', null, '19', '128', '86026792', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('217', '922', '谢艳林', '1', null, '1', '', '2', '', '', '', '', '', '13758699789', '666789', '3', '', '', '', '', null, '19', '128', '86026789', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('218', '923', '江丽君', '1', null, '1', '', '2', '', '', '', '', '', '13758699791', '666791', '3', '', '', '', '', null, '19', '128', '86026791', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('219', '924', '朱莉华', '1', null, '1', '', '2', '', '', '', '', '', '13958601608', '600608', '3', '', '', '', '', null, '19', '128', '86198620', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('220', '925', '史林杰', '0', null, '1', '', '2', '', '', '', '', '', '13958616693', '666269', '3', '', '', '', '', null, '20', '133', '86026269', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('221', '926', '林仁明', '1', null, '1', '', '2', '', '', '', '', '', '13758699815', '666815', '3', '', '', '', '', null, '20', '128', '86026815', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('222', '927', '张小丽', '1', null, '1', '', '2', '', '', '', '', '', '13758696699', '666798', '3', '', '', '', '', null, '20', '128', '86026798', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('223', '928', '闵金莲', '1', null, '1', '', '2', '', '', '', '', '', '13758699799', '666799', '3', '', '', '', '', null, '20', '128', '86026799', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('224', '929', '刘桂云', '1', null, '1', '', '2', '', '', '', '', '', '13750656576', '666801', '3', '', '', '', '', null, '20', '128', '86026801', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('225', '930', '刘智勇', '0', null, '1', '', '2', '', '', '', '', '', '13758699802', '666802', '3', '', '', '', '', null, '20', '128', '86026802', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('226', '931', '张华丽', '1', null, '1', '', '2', '', '', '', '', '', '13606676083', '666803', '3', '', '', '', '', null, '20', '128', '86026803', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('227', '932', '应金祥', '0', null, '1', '', '2', '', '', '', '', '', '13758699805', '666805', '3', '', '', '', '', null, '20', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('228', '933', '潘岳才', '0', null, '1', '', '2', '', '', '', '', '', '13758699806', '666806', '3', '', '', '', '', null, '20', '128', '86026806', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('229', '934', '彭小琴', '1', null, '1', '', '2', '', '', '', '', '', '13758699813', '666813', '3', '', '', '', '', null, '20', '128', '86026813', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('230', '935', '李倩倩', '1', null, '1', '', '2', '', '', '', '', '', '13758699816', '666816', '3', '', '', '', '', null, '21', '133', '86026816', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('231', '936', '江红燕', '1', null, '1', '', '2', '', '', '', '', '', '13867620272', '666808', '3', '', '', '', '', null, '21', '128', '86026808', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('232', '937', '赵乾坤', '0', null, '1', '', '2', '', '', '', '', '', '13758699809', '666809', '3', '', '', '', '', null, '21', '128', '86026809', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('233', '938', '郭建江', '0', null, '1', '', '2', '', '', '', '', '', '13758699811', '666811', '3', '', '', '', '', null, '21', '128', '86026811', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('234', '939', '孔海君', '1', null, '1', '', '2', '', '', '', '', '', '13958697865', '666812', '3', '', '', '', '', null, '21', '128', '86026812', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('235', '940', '金英姿', '1', null, '1', '', '2', '', '', '', '', '', '13867688603', '600603', '3', '', '', '', '', null, '21', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('236', '941', '金蕴', '0', null, '1', '', '2', '', '', '', '', '', '13738654954', '664954', '3', '', '', '', '', null, '21', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('237', '942', '冯佳虹', '1', null, '1', '', '2', '', '', '', '', '', '13586220961', '660961', '3', '', '', '', '', null, '21', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('238', '943', '李静', '1', null, '1', '', '2', '', '', '', '', '', '15868609186', '669186', '3', '', '', '', '', null, '21', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('239', '944', '梁瑞阳', '0', null, '1', '', '2', '', '', '', '', '', '13968456716', '665716', '3', '', '', '', '', null, '21', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('240', '945', '李林岳', '1', null, '1', '', '2', '', '', '', '', '', '13858699889', '666889', '3', '', '', '', '', null, '10', '127', '86026889', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('241', '946', '江勇', '0', null, '1', '', '2', '', '', '', '', '', '13958680099', '666877', '3', '', '', '', '', null, '10', '121', '86026005', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('242', '947', '邵云强', '1', null, '1', '', '2', '', '', '', '', '', '13758699878', '666878', '3', '', '', '', '', null, '10', '127', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('243', '948', '李国庆', '1', null, '1', '', '2', '', '', '', '', '', '13958671906', '666855', '3', '', '', '', '', null, '10', '127', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('244', '949', '王云琴', '1', null, '1', '', '2', '', '', '', '', '', '13958675338', '666853', '3', '', '', '', '', null, '10', '127', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('246', '951', '王敏杰', '1', null, '1', '', '2', '', '', '', '', '', '13758699831', '666831', '3', '', '', '', '', null, '33', '133', '86026831', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('247', '952', '周夏芬', '1', null, '1', '', '2', '', '', '', '', '', '13958606700', '666823', '3', '', '', '', '', null, '33', '128', '86026823', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('248', '953', '郑建荣', '0', null, '1', '', '2', '', '', '', '', '', '13958612638', '662638', '3', '', '', '', '', null, '33', '128', '86026819', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('249', '954', '徐敏燕', '1', null, '1', '', '2', '', '', '', '', '', '18957661789', '666821', '3', '', '', '', '', null, '33', '128', '86026821', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('250', '955', '刘世平', '0', null, '1', '', '2', '', '', '', '', '', '13758699822', '666822', '3', '', '', '', '', null, '33', '128', '86026822', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('251', '956', '赵阳', '0', null, '1', '', '2', '', '', '', '', '', '13606671983', '666825', '3', '', '', '', '', null, '33', '128', '86026825', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('252', '957', '谢宇红', '1', null, '1', '', '2', '', '', '', '', '', '13758699826', '666826', '3', '', '', '', '', null, '33', '128', '86026826', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('253', '958', '徐根玲', '1', null, '1', '', '2', '', '', '', '', '', '13758699827', '666827', '3', '', '', '', '', null, '33', '128', '86026827', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('254', '959', '李煜霞', '1', null, '1', '', '2', '', '', '', '', '', '13758699828', '666828', '3', '', '', '', '', null, '33', '128', '86026828', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-10-10');
INSERT INTO `basic_teacher` VALUES ('255', '960', '颜斌', '1', null, '1', '', '2', '', '', '', '', '', '13606721238', '666829', '3', '', '', '', '', null, '33', '128', '86026829', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('256', '961', '金伟飞', '1', null, '1', '', '2', '', '', '', '', '', '15968698000', '666830', '3', '', '', '', '', null, '33', '128', '86026830', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('257', '962', '季华辉', '0', null, '1', '', '2', '', '', '', '', '', '13958676005', '666832', '3', '', '', '', '', null, '33', '128', '86026832', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('258', '963', '颜小敏', '0', null, '1', '', '2', '', '', '', '', '', '13566681010', '666835', '3', '', '', '', '', null, '33', '128', '86026835', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('259', '964', '王海辉', '0', null, '1', '', '2', '', '', '', '', '', '13605861210', '666836', '3', '', '', '', '', null, '33', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('260', '965', '王平波', '0', null, '1', '', '2', '', '', '', '', '', '13758699837', '666837', '3', '', '', '', '', null, '33', '128', '86026837', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('261', '966', '钟永勇', '0', null, '1', '', '2', '', '', '', '', '', '13758699838', '666838', '3', '', '', '', '', null, '33', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('262', '967', '方敏', '0', null, '1', '', '2', '', '', '', '', '', '13906566996', '668996', '3', '', '', '', '', null, '33', '128', '86198626', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('263', '968', '蒋照明', '0', null, '1', '', '2', '', '', '', '', '', '13738599588', '669588', '3', '', '', '', '', null, '35', '133', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('264', '969', '潘濒湖', '0', null, '1', '', '2', '', '', '', '', '', '13958635885', '666851', '3', '', '', '', '', null, '35', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('265', '970', '陈清龙', '0', null, '1', '', '2', '', '', '', '', '', '13586294602', '666852', '3', '', '', '', '', null, '35', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('266', '971', '谢令冬', '0', null, '1', '', '2', '', '', '', '', '', '15168629168', '669168', '3', '', '', '', '', null, '35', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('267', '972', '柯慧荣', '1', null, '1', '', '2', '', '', '', '', '', '13758699879', '666879', '3', '', '', '', '', null, '34', '135', '86026879', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('268', '973', '谢理琦', '0', null, '1', '', '2', '', '', '', '', '', '13958680166', '666881', '3', '', '', '', '', null, '34', '128', '86026881', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('269', '974', '黄玲利', '1', null, '1', '', '2', '', '', '', '', '', '13758699885', '666885', '3', '', '', '', '', null, '34', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('270', '975', '蔡剑菊', '1', null, '1', '', '2', '', '', '', '', '', '13566682020', '666886', '3', '', '', '', '', null, '34', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('271', '976', '陈军辉', '0', null, '1', '', '2', '', '', '', '', '', '13819609001', '666588', '3', '', '', '', '', null, '34', '128', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('272', '977', '林慧', '1', null, '1', '', '2', '', '', '', '', '', '13958659990', '666990', '3', '', '', '', '', null, '36', '134', '86026990', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('273', '978', '李敏', '1', null, '1', '', '2', '', '', '', '', '', '13758699868', '666890', '3', '', '', '', '', null, '36', '135', '86026890', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('274', '979', '郭春莲', '1', null, '1', '', '2', '', '', '', '', '', '13758699891', '666891', '3', '', '', '', '', null, '36', '135', '86026891', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('275', '980', '汪晓红', '1', null, '1', '', '2', '', '', '', '', '', '13958673898', '666892', '3', '', '', '', '', null, '36', '135', '86026892', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('276', '981', '张美菊', '1', null, '1', '', '2', '', '', '', '', '', '13758699893', '666893', '3', '', '', '', '', null, '36', '135', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('277', '982', '叶勤', '1', null, '1', '', '2', '', '', '', '', '', '13606678129', '666895', '3', '', '', '', '', null, '36', '135', '86026895', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('278', '983', '叶祥利', '0', null, '1', '', '2', '', '', '', '', '', '13606675558', '665558', '3', '', '', '', '', null, '11', '121', '86026004', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('279', '984', '毛道方', '0', null, '1', '', '2', '', '', '', '', '', '13958675218', '666912', '3', '', '', '', '', null, '11', '127', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('280', '985', '陈福初', '0', null, '1', '', '2', '', '', '', '', '', '13758632000', '662000', '3', '', '', '', '', null, '11', '127', '86026704', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('281', '986', '徐云强', '0', null, '1', '', '2', '', '', '', '', '', '13906863760', '666901', '3', '', '', '', '', null, '11', '122', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('282', '987', '叶理富', '0', null, '1', '', '2', '', '', '', '', '', '13758670605', '660605', '3', '', '', '', '', null, '11', '127', '86026902', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('283', '988', '程彩娇', '1', null, '1', '', '2', '', '', '', '', '', '13758696253', '666253', '3', '', '', '', '', null, '11', '127', '86026903', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('284', '989', '蔡式军', '0', null, '1', '', '2', '', '', '', '', '', '13758699906', '666906', '3', '', '', '', '', null, '11', '127', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('285', '990', '张云明', '0', null, '1', '', '2', '', '', '', '', '', '13958675118', '666907', '3', '', '', '', '', null, '11', '123', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('286', '991', '邵新华', '1', null, '1', '', '2', '', '', '', '', '', '13958676218', '666908', '3', '', '', '', '', null, '11', '127', '86026704', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('288', '993', '潘文玮', '1', null, '1', '', '2', '', '', '', '', '', '13586225488', '666910', '3', '', '', '', '', null, '11', '127', '86026910', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('289', '994', '张海荣', '1', null, '1', '', '2', '', '', '', '', '', '13958676007', '666913', '3', '', '', '', '', null, '11', '127', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('290', '995', '王晨来', '1', null, '1', '', '2', '', '', '', '', '', '13758699797', '666797', '3', '', '', '', '', null, '11', '127', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('291', '996', '方芳', '1', null, '1', '', '2', '', '', '', '', '', '13958659992', '666992', '3', '', '', '', '', null, '11', '127', '86026992', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('292', '997', '叶吟雪', '1', null, '1', '', '2', '', '', '', '', '', '13777633611', '663611', '3', '', '', '', '', null, '11', '127', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('293', '998', '毛灯松', '1', null, '1', '', '2', '', '', '', '', '', '13586255316', '665316', '3', '', '', '', '', null, '11', '123', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('294', '999', '杨友明', '0', null, '1', '', '2', '', '', '', '', '', '13906864023', '666928', '3', '', '', '', '', null, '3', '127', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('295', '1000', '蔡灵智', '0', null, '1', '', '2', '', '', '', '', '', '13968632843', '666915', '3', '', '', '', '', null, '11', '127', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('296', '1001', '范勤刚', '0', null, '1', '', '2', '', '', '', '', '', '13758699921', '666921', '3', '', '', '', '', null, '11', '127', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('297', '1002', '连家荣', '0', null, '1', '', '2', '', '', '', '', '', '13758699920', '666920', '3', '', '', '', '', null, '11', '127', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('298', '1003', '王学能', '0', null, '1', '', '2', '', '', '', '', '', '13905862790', '666919', '3', '', '', '', '', null, '11', '127', '', '', null, null, '0', 'resources/oa/layout/default_head.jpg', '2011-07-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('300', '1007', '徐跃文', '0', null, '0', '', '0', '', '', '', '', '', '13758699866', '666866', '0', '', '', '', '', null, '1', '135', '', '', null, null, '0', 'uploads/basic/teacherProfile/default_head.jpg', '2011-09-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('301', '1008', '毛丽丽', '1', null, '0', '', '0', '', '', '', '', '', '', '665785', '3', '', '', '', '', null, '6', '127', '86026001', '', null, null, '0', 'uploads/basic/teacherProfile/default_head.jpg', '2011-09-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('302', '1009', '陈胜男', '1', null, '0', '', '0', '', '', '', '', '', '', '665311', '0', '', '', '', '', null, '3', '127', '', '', null, null, '0', 'uploads/basic/teacherProfile/default_head.jpg', '2011-09-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('303', '1010', '张华伟', '0', null, '0', '', '0', '', '', '', '', '', '', '661856', '0', '', '', '', '', null, '13', '128', '', '', null, null, '0', 'uploads/basic/teacherProfile/default_head.jpg', '2011-09-05', '2011-09-28');
INSERT INTO `basic_teacher` VALUES ('304', '1011', '陈卡利', '1', null, '0', '', '0', '', '', '', '', '', '', '661885', '0', '', '', '', '', null, '14', '128', '', '', null, null, '0', 'uploads/basic/teacherProfile/default_head.jpg', '2011-09-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('305', '1012', '李永胜', '0', null, '0', '', '0', '', '', '', '', '', '', '667111', '0', '', '', '', '', null, '14', '128', '', '', null, null, '0', 'uploads/basic/teacherProfile/default_head.jpg', '2011-09-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('306', '1013', '朱国鹏', '0', null, '0', '', '0', '', '', '', '', '', '', '662320', '0', '', '', '', '', null, '17', '128', '', '', null, null, '0', 'uploads/basic/teacherProfile/default_head.jpg', '2011-09-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('307', '1014', '蒋俊燕', '1', null, '0', '', '0', '', '', '', '', '', '', '661591', '0', '', '', '', '', null, '17', '128', '', '', null, null, '0', 'uploads/basic/teacherProfile/default_head.jpg', '2011-09-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('308', '1015', '方琰', '1', null, '0', '', '0', '', '', '', '', '', '', '663010', '0', '', '', '', '', null, '19', '128', '', '', null, null, '0', 'uploads/basic/teacherProfile/default_head.jpg', '2011-09-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('309', '1016', '陈桂花', '1', null, '1', '', '0', '', '', '', '', '', '13626688567', '668567', '0', '', '', '', '', null, '19', '128', '', '', null, null, '0', 'uploads/basic/teacherProfile/default_head.jpg', '2011-09-05', '2011-11-08');
INSERT INTO `basic_teacher` VALUES ('311', '1018', '邱晓慧', '1', null, '1', '汉族', '0', '', '', '', '', '', '15157299919', '669919', '0', '', '', '', '', null, '13', '128', '', '', null, null, '0', 'uploads/basic/teacherProfile/default_head.jpg', '2011-11-01', '2011-11-01');
INSERT INTO `basic_teacher` VALUES ('312', '1019', '林锦贤', '0', null, '0', '汉族', '0', '', '', '', '', '', '', '669690', '0', '', '', '', '', null, '6', '127', '', '', null, null, '0', 'uploads/basic/teacherProfile/default_head.jpg', '2011-12-05', '2011-12-05');

-- ----------------------------
-- Table structure for `basic_teacher_social_relation`
-- ----------------------------
DROP TABLE IF EXISTS `basic_teacher_social_relation`;
CREATE TABLE `basic_teacher_social_relation` (
  `relation_id` int(20) NOT NULL auto_increment COMMENT '系统自增编号',
  `teacher_id` bigint(20) default NULL COMMENT '教师外键',
  `relation_name` varchar(20) NOT NULL COMMENT '姓名',
  `relation_with` varchar(20) NOT NULL COMMENT '与本人关系',
  `relation_company` varchar(50) NOT NULL COMMENT '所在工作单位',
  `relation_phone` varchar(20) NOT NULL COMMENT '联系电话',
  PRIMARY KEY  (`relation_id`),
  KEY `relation_id` (`relation_id`),
  KEY `teacher_id` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='社会关系';

-- ----------------------------
-- Records of basic_teacher_social_relation
-- ----------------------------

-- ----------------------------
-- Table structure for `basic_teacher_work_experience`
-- ----------------------------
DROP TABLE IF EXISTS `basic_teacher_work_experience`;
CREATE TABLE `basic_teacher_work_experience` (
  `experience_id` int(20) NOT NULL auto_increment COMMENT '系统自增编号',
  `teacher_id` bigint(20) default NULL COMMENT '教师外键',
  `experience_start_date` date NOT NULL COMMENT '开始时间',
  `experience_end_date` date NOT NULL COMMENT '结束时间',
  `experience_company` varchar(50) NOT NULL COMMENT '工作单位',
  `experience_position` varchar(50) NOT NULL COMMENT '职务',
  PRIMARY KEY  (`experience_id`),
  KEY `experience_id` (`experience_id`),
  KEY `teacher_id` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师工作经历';

-- ----------------------------
-- Records of basic_teacher_work_experience
-- ----------------------------

-- ----------------------------
-- Table structure for `wlzx_basic_directory`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_basic_directory`;
CREATE TABLE `wlzx_basic_directory` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(200) NOT NULL,
  `value` varchar(200) NOT NULL,
  `type` varchar(200) NOT NULL,
  `sequence` int(11) NOT NULL default '0',
  `extra_value` varchar(200) default NULL,
  `creation_date` datetime NOT NULL,
  `modified_date` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_basic_directory
-- ----------------------------
INSERT INTO `wlzx_basic_directory` VALUES ('1', '通知', '通知', 'noticeType', '0', '', '2011-09-05 07:55:48', '2011-09-05 07:55:48');
INSERT INTO `wlzx_basic_directory` VALUES ('2', '考勤信息', '考勤信息', 'noticeType', '0', '', '2011-09-05 11:50:14', '2011-09-05 11:50:14');
INSERT INTO `wlzx_basic_directory` VALUES ('3', '会议室', '会议室', 'placeType', '0', '', '2011-09-30 17:03:32', '2011-09-30 17:03:32');
INSERT INTO `wlzx_basic_directory` VALUES ('4', '求是楼', '求是楼', 'building', '1', '', '2011-09-30 17:05:17', '2011-09-30 17:05:17');

-- ----------------------------
-- Table structure for `wlzx_basic_place`
-- ----------------------------
DROP TABLE IF EXISTS `wlzx_basic_place`;
CREATE TABLE `wlzx_basic_place` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(200) NOT NULL,
  `type` varchar(200) NOT NULL,
  `position` varchar(200) NOT NULL,
  `symbol` varchar(200) NOT NULL,
  `functions` varchar(200) default NULL,
  `area_begin` float default NULL,
  `area_end` float default NULL,
  `contain_begin` int(11) default NULL,
  `contain_end` int(11) default NULL,
  `remarks` text,
  `creation_date` datetime NOT NULL,
  `modified_date` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wlzx_basic_place
-- ----------------------------
INSERT INTO `wlzx_basic_place` VALUES ('1', '会议室1', '会议室', '求是楼--101', '101', '', '30', '0', '10', '0', '', '2011-09-30 17:05:55', '2011-09-30 17:05:55');
