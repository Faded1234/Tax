/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50527
Source Host           : 127.0.0.1:3306
Source Database       : tax

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2017-06-22 18:58:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for complain
-- ----------------------------
DROP TABLE IF EXISTS `complain`;
CREATE TABLE `complain` (
  `comp_id` varchar(32) NOT NULL,
  `comp_company` varchar(100) DEFAULT NULL,
  `comp_name` varchar(20) DEFAULT NULL,
  `comp_mobile` varchar(20) DEFAULT NULL,
  `is_NM` tinyint(1) DEFAULT NULL,
  `comp_time` datetime DEFAULT NULL,
  `comp_title` varchar(200) NOT NULL,
  `to_comp_name` varchar(20) DEFAULT NULL,
  `to_comp_dept` varchar(100) DEFAULT NULL,
  `comp_content` text,
  `state` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`comp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of complain
-- ----------------------------
INSERT INTO `complain` VALUES ('1', '部门A', '用户1', '13276546543', '1', '2016-11-11 11:11:11', '投诉标题1', '管理员', '部门A', '投诉内容1', '1');
INSERT INTO `complain` VALUES ('2', '部门B', '用户2', '16754325416', '0', '2017-11-11 11:11:11', '投诉标题2', '管理员', '部门B', '投诉内容2', '1');
INSERT INTO `complain` VALUES ('3', '部门B', '用户2', '16754325416', '0', '2017-09-11 11:11:11', '投诉标题3', '管理员', '部门B', '投诉内容3', '1');
INSERT INTO `complain` VALUES ('4', '部门B', '用户2', '16754325416', '0', '2017-09-11 11:11:11', '投诉标题4', '管理员', '部门B', '投诉内容4', '0');
INSERT INTO `complain` VALUES ('40282a4f5b84bb57015b84c8ca980000', '部门A', 'admin', '136568544', '1', '2017-03-19 13:56:43', '123', 'xxn', '部门A', '<p>123</p>', '2');

-- ----------------------------
-- Table structure for complain_reply
-- ----------------------------
DROP TABLE IF EXISTS `complain_reply`;
CREATE TABLE `complain_reply` (
  `replay_id` varchar(32) NOT NULL,
  `comp_id` varchar(32) NOT NULL,
  `replayer` varchar(20) DEFAULT NULL,
  `replay_dept` varchar(100) DEFAULT NULL,
  `replay_time` datetime DEFAULT NULL,
  `replay_content` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`replay_id`),
  KEY `FK_comp_reply` (`comp_id`),
  CONSTRAINT `FK_comp_reply` FOREIGN KEY (`comp_id`) REFERENCES `complain` (`comp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of complain_reply
-- ----------------------------
INSERT INTO `complain_reply` VALUES ('40282a4f5b7bb6d1015b7bb7f7010000', '2', 'admin', '部门A', '2017-04-17 19:41:45', '1213');
INSERT INTO `complain_reply` VALUES ('40282a4f5b7bb6d1015b7bb9ac650001', '1', 'admin', '部门A', '2017-04-17 19:43:37', '12324');
INSERT INTO `complain_reply` VALUES ('40282a4f5b7bb6d1015b7bb9e1d90002', '3', 'admin', '部门A', '2017-04-17 19:43:51', '124124');
INSERT INTO `complain_reply` VALUES ('40282a4f5b7bb6d1015b7bba13f50003', '3', 'admin', '部门A', '2017-04-17 19:44:04', '2141242124');

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `info_id` varchar(32) NOT NULL,
  `type` varchar(10) DEFAULT NULL,
  `source` varchar(50) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `content` longtext,
  `memo` varchar(200) DEFAULT NULL,
  `creator` varchar(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `state` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES ('40282a4f5b60cade015b60cc6e2c0001', 'tzgg', '腾讯', '信息测试2', '<p>楼上<br/></p>', '楼下', 'admin', '2017-04-12 14:13:48', '1');
INSERT INTO `info` VALUES ('40282a4f5b60d05f015b60d4dc5c0000', 'tzgg', '百度推广', '信息测试1', '<p>差评<br/></p>', '完美', 'admin', '2017-04-12 14:23:10', '1');
INSERT INTO `info` VALUES ('40282a4f5b60dd5c015b60de27680000', 'tzgg', '百度', '测试', '<p>好的<br/></p>', '不行', 'admin', '2017-04-12 14:33:29', '1');
INSERT INTO `info` VALUES ('40282a4f5b60dd5c015b60e1a9c90001', 'tzgg', '345', '信息测试3', '<p>345<br/></p>', '345', 'admin', '2017-04-12 14:37:17', '1');
INSERT INTO `info` VALUES ('40282b0b5bf7394a015bf742eaf10000', 'zcsd', '百度', '通知', '<p>ssh框架<br/></p>', '123', 'admin', '2017-05-11 19:26:16', '1');
INSERT INTO `info` VALUES ('8aea96ee5b588e97015b589033a60000', 'tzgg', '谷歌', '123', '<p>好吧<img src=\"http://img.baidu.com/hi/jx2/j_0002.gif\"/></p>', '不显示', 'admin', '2017-04-10 23:51:02', '1');
INSERT INTO `info` VALUES ('8aea96ee5b5ce60e015b5ce7dae90000', 'tzgg', '好不好', '很好', '<p>你好吗<img src=\"http://img.baidu.com/hi/jx2/j_0007.gif\"/></p>', '我很好', 'admin', '2017-04-11 20:05:17', '1');
INSERT INTO `info` VALUES ('8aea96ee5b62eb3d015b62ebe4ea0000', 'tzgg', '123', '输入方式的', '<p>134<br/></p>', '4314', 'admin', '2017-04-13 00:07:47', '0');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` varchar(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('40282a4f5b1889af015b1889b0910000', '人员1');
INSERT INTO `person` VALUES ('40282a4f5b18a24e015b18a24f3b0000', '人员二');
INSERT INTO `person` VALUES ('40282a4f5b18d0c8015b18d0c97a0000', '人员二');
INSERT INTO `person` VALUES ('40282a4f5b193814015b193816050000', '人员1');
INSERT INTO `person` VALUES ('40282a4f5b193840015b193842820000', '人员2');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` varchar(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  `state` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('40282a4f5b3e513e015b3e51c8fa0000', '管理员', '1');
INSERT INTO `role` VALUES ('40282a4f5b41da90015b41de946d0000', '普通用户', '1');
INSERT INTO `role` VALUES ('40282a4f5b50ba19015b50ba8a340000', '个人', '1');
INSERT INTO `role` VALUES ('40282a4f5b66fe2c015b673432db0000', 'test', '1');
INSERT INTO `role` VALUES ('40282a4f5b66fe2c015b67346fba0001', 'gyw', '1');

-- ----------------------------
-- Table structure for role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `role_privilege`;
CREATE TABLE `role_privilege` (
  `role_id` varchar(32) NOT NULL,
  `code` varchar(20) NOT NULL,
  PRIMARY KEY (`role_id`,`code`),
  KEY `FK45FBD6281D9A0E39` (`role_id`),
  CONSTRAINT `FK45FBD6281D9A0E39` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_privilege
-- ----------------------------
INSERT INTO `role_privilege` VALUES ('40282a4f5b3e513e015b3e51c8fa0000', 'hqfw');
INSERT INTO `role_privilege` VALUES ('40282a4f5b3e513e015b3e51c8fa0000', 'nsfw');
INSERT INTO `role_privilege` VALUES ('40282a4f5b3e513e015b3e51c8fa0000', 'space');
INSERT INTO `role_privilege` VALUES ('40282a4f5b3e513e015b3e51c8fa0000', 'xzgl');
INSERT INTO `role_privilege` VALUES ('40282a4f5b3e513e015b3e51c8fa0000', 'zxxx');
INSERT INTO `role_privilege` VALUES ('40282a4f5b41da90015b41de946d0000', 'hqfw');
INSERT INTO `role_privilege` VALUES ('40282a4f5b41da90015b41de946d0000', 'zxxx');
INSERT INTO `role_privilege` VALUES ('40282a4f5b50ba19015b50ba8a340000', 'space');
INSERT INTO `role_privilege` VALUES ('40282a4f5b66fe2c015b673432db0000', 'zxxx');
INSERT INTO `role_privilege` VALUES ('40282a4f5b66fe2c015b67346fba0001', 'hqfw');
INSERT INTO `role_privilege` VALUES ('40282a4f5b66fe2c015b67346fba0001', 'nsfw');
INSERT INTO `role_privilege` VALUES ('40282a4f5b66fe2c015b67346fba0001', 'space');
INSERT INTO `role_privilege` VALUES ('40282a4f5b66fe2c015b67346fba0001', 'xzgl');
INSERT INTO `role_privilege` VALUES ('40282a4f5b66fe2c015b67346fba0001', 'zxxx');

-- ----------------------------
-- Table structure for tmonth
-- ----------------------------
DROP TABLE IF EXISTS `tmonth`;
CREATE TABLE `tmonth` (
  `imonth` tinyint(4) NOT NULL,
  PRIMARY KEY (`imonth`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tmonth
-- ----------------------------
INSERT INTO `tmonth` VALUES ('1');
INSERT INTO `tmonth` VALUES ('2');
INSERT INTO `tmonth` VALUES ('3');
INSERT INTO `tmonth` VALUES ('4');
INSERT INTO `tmonth` VALUES ('5');
INSERT INTO `tmonth` VALUES ('6');
INSERT INTO `tmonth` VALUES ('7');
INSERT INTO `tmonth` VALUES ('8');
INSERT INTO `tmonth` VALUES ('9');
INSERT INTO `tmonth` VALUES ('10');
INSERT INTO `tmonth` VALUES ('11');
INSERT INTO `tmonth` VALUES ('12');

-- ----------------------------
-- Table structure for tmonth_copy
-- ----------------------------
DROP TABLE IF EXISTS `tmonth_copy`;
CREATE TABLE `tmonth_copy` (
  `imonth` tinyint(4) NOT NULL,
  PRIMARY KEY (`imonth`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tmonth_copy
-- ----------------------------
INSERT INTO `tmonth_copy` VALUES ('1');
INSERT INTO `tmonth_copy` VALUES ('2');
INSERT INTO `tmonth_copy` VALUES ('3');
INSERT INTO `tmonth_copy` VALUES ('4');
INSERT INTO `tmonth_copy` VALUES ('5');
INSERT INTO `tmonth_copy` VALUES ('6');
INSERT INTO `tmonth_copy` VALUES ('7');
INSERT INTO `tmonth_copy` VALUES ('8');
INSERT INTO `tmonth_copy` VALUES ('9');
INSERT INTO `tmonth_copy` VALUES ('10');
INSERT INTO `tmonth_copy` VALUES ('11');
INSERT INTO `tmonth_copy` VALUES ('12');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  `dept` varchar(20) NOT NULL,
  `account` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `headImg` varchar(100) DEFAULT NULL,
  `gender` bit(1) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `state` varchar(1) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('40282a4f5b4bf0ca015b4bf216450000', 'xxn', '部门A', 'xxn', 'xxn', 'user/f6eacc05-48da-417e-9e3d-c262ebccbebd.jpg', '\0', 'xxn@.com', '123213', '2017-04-12 00:00:00', '1', '123');
INSERT INTO `user` VALUES ('40282a4f5b4c63fc015b4c84d1a30002', 'admin', '部门A', 'admin', 'admin', null, '', '7755@qq.com', '136568544', '1998-10-11 00:00:00', '1', '');
INSERT INTO `user` VALUES ('40282a4f5b4d0e67015b4d139e730000', 'user', '部门A', 'user', 'user', null, '\0', '123', '123', '2017-04-04 00:00:00', '1', '123');
INSERT INTO `user` VALUES ('40282a4f5b52a3e3015b52b4a9370000', '123', '部门A', '123', '123', null, '\0', '123', '123', '2017-04-18 00:00:00', '1', '123');
INSERT INTO `user` VALUES ('40282a4f5b94f784015b950fca430000', 'xxn', '部门A', 'xxn', '123', null, '\0', '', '', null, '1', '');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `role_id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`),
  KEY `FK143BF46A1D9A0E39` (`role_id`),
  CONSTRAINT `FK143BF46A1D9A0E39` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('40282a4f5b3e513e015b3e51c8fa0000', '40282a4f5b3dddfb015b3e165cc60000');
INSERT INTO `user_role` VALUES ('40282a4f5b3e513e015b3e51c8fa0000', '40282a4f5b4bf0ca015b4bf216450000');
INSERT INTO `user_role` VALUES ('40282a4f5b3e513e015b3e51c8fa0000', '40282a4f5b4c301d015b4c321ff20000');
INSERT INTO `user_role` VALUES ('40282a4f5b3e513e015b3e51c8fa0000', '40282a4f5b4c3e8c015b4c3f59720000');
INSERT INTO `user_role` VALUES ('40282a4f5b3e513e015b3e51c8fa0000', '40282a4f5b4c63fc015b4c84d1a30002');
INSERT INTO `user_role` VALUES ('40282a4f5b3e513e015b3e51c8fa0000', '40282a4f5b4ceb19015b4ceb80030000');
INSERT INTO `user_role` VALUES ('40282a4f5b3e513e015b3e51c8fa0000', '40282a4f5b52a3e3015b52b4a9370000');
INSERT INTO `user_role` VALUES ('40282a4f5b41da90015b41de946d0000', '40282a4f5b4bf0ca015b4bf216450000');
INSERT INTO `user_role` VALUES ('40282a4f5b41da90015b41de946d0000', '40282a4f5b4c301d015b4c321ff20000');
INSERT INTO `user_role` VALUES ('40282a4f5b41da90015b41de946d0000', '40282a4f5b4c3e8c015b4c3f59720000');
INSERT INTO `user_role` VALUES ('40282a4f5b41da90015b41de946d0000', '40282a4f5b4c63fc015b4c84d1a30002');
INSERT INTO `user_role` VALUES ('40282a4f5b41da90015b41de946d0000', '40282a4f5b4ceb19015b4ceb80030000');
INSERT INTO `user_role` VALUES ('40282a4f5b41da90015b41de946d0000', '8aea96ee5b5ce60e015b5cee2a820002');
INSERT INTO `user_role` VALUES ('40282a4f5b50ba19015b50ba8a340000', '40282a4f5b4d0e67015b4d139e730000');
INSERT INTO `user_role` VALUES ('40282a4f5b50ba19015b50ba8a340000', '8aea96ee5b5ce60e015b5cecd72d0001');
