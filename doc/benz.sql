/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50612
Source Host           : localhost:3306
Source Database       : benz

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2015-11-27 16:41:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `type` varchar(10) DEFAULT NULL COMMENT 'local:国内,gat:港澳台,dny:东南亚,europe:欧洲,america:美洲',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES ('1', '国内', 'local');
INSERT INTO `country` VALUES ('2', '港澳台', 'gat');
INSERT INTO `country` VALUES ('3', '日本', 'dy');

-- ----------------------------
-- Table structure for dates
-- ----------------------------
DROP TABLE IF EXISTS `dates`;
CREATE TABLE `dates` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `member_id` int(10) unsigned NOT NULL,
  `start_date` date NOT NULL,
  `start_place` int(10) unsigned DEFAULT NULL,
  `days` tinyint(3) unsigned NOT NULL,
  `budget` int(10) unsigned DEFAULT NULL,
  `member_count` tinyint(3) unsigned DEFAULT NULL,
  `travel_type` char(1) DEFAULT NULL COMMENT 'c:汽车,t:火车,p:飞机,d:自驾,b:自行车,w:徒步',
  `comments` varchar(500) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dates
-- ----------------------------

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `account` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `nick_name` varchar(30) NOT NULL,
  `image_url` varchar(30) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL COMMENT 'M/F',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `last_updated` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', 'a@a.com', '111111', 'a', null, null, '2015-08-18 17:13:40', '2015-08-18 17:13:40');
INSERT INTO `member` VALUES ('2', '1@a.com', '111111', '1', null, null, '2015-09-16 15:11:33', '2015-09-16 15:11:33');

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `country_id` tinyint(3) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES ('1', '北京', '1');
INSERT INTO `province` VALUES ('2', '上海', '1');
INSERT INTO `province` VALUES ('3', '重庆', '1');
INSERT INTO `province` VALUES ('4', '天津', '1');
INSERT INTO `province` VALUES ('5', '香港', '2');
INSERT INTO `province` VALUES ('6', '澳门', '2');
INSERT INTO `province` VALUES ('7', '河北', '1');
INSERT INTO `province` VALUES ('8', '河南', '1');
INSERT INTO `province` VALUES ('9', '辽宁', '1');
INSERT INTO `province` VALUES ('10', '吉林', '1');
INSERT INTO `province` VALUES ('11', '黑龙江', '1');
INSERT INTO `province` VALUES ('12', '山西', '1');
INSERT INTO `province` VALUES ('13', '内蒙古', '1');
INSERT INTO `province` VALUES ('14', '江苏', '1');
INSERT INTO `province` VALUES ('15', '浙江', '1');
INSERT INTO `province` VALUES ('16', '安徽', '1');
INSERT INTO `province` VALUES ('17', '江西', '1');
INSERT INTO `province` VALUES ('18', '福建', '1');
INSERT INTO `province` VALUES ('19', '山东', '1');
INSERT INTO `province` VALUES ('20', '台湾', '2');
INSERT INTO `province` VALUES ('21', '湖北', '1');
INSERT INTO `province` VALUES ('22', '湖南', '1');
INSERT INTO `province` VALUES ('23', '广东', '1');
INSERT INTO `province` VALUES ('24', '广西', '1');
INSERT INTO `province` VALUES ('25', '海南', '1');
INSERT INTO `province` VALUES ('26', '四川', '1');
INSERT INTO `province` VALUES ('27', '云南', '1');
INSERT INTO `province` VALUES ('28', '西藏', '1');
INSERT INTO `province` VALUES ('29', '贵州', '1');
INSERT INTO `province` VALUES ('30', '陕西', '1');
INSERT INTO `province` VALUES ('31', '甘肃', '1');
INSERT INTO `province` VALUES ('32', '青海', '1');
INSERT INTO `province` VALUES ('33', '宁夏', '1');
INSERT INTO `province` VALUES ('34', '新疆', '1');

-- ----------------------------
-- Table structure for routes
-- ----------------------------
DROP TABLE IF EXISTS `routes`;
CREATE TABLE `routes` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `date_id` int(10) unsigned NOT NULL,
  `viewspot_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of routes
-- ----------------------------

-- ----------------------------
-- Table structure for viewspot
-- ----------------------------
DROP TABLE IF EXISTS `viewspot`;
CREATE TABLE `viewspot` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `type` char(1) DEFAULT 'c',
  `province_id` tinyint(3) unsigned DEFAULT NULL,
  `parent_id` int(10) unsigned DEFAULT NULL,
  `comments` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of viewspot
-- ----------------------------
