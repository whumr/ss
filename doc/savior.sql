/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50612
Source Host           : localhost:3306
Source Database       : savior

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2016-01-13 15:10:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `mobile` bigint(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nick_name` varchar(30) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------

-- ----------------------------
-- Table structure for action
-- ----------------------------
DROP TABLE IF EXISTS `action`;
CREATE TABLE `action` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `creator_id` bigint(20) unsigned NOT NULL,
  `org_id` int(10) unsigned DEFAULT NULL,
  `title` varchar(50) NOT NULL,
  `start_time` datetime DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `budget` bigint(20) unsigned DEFAULT NULL,
  `province_id` tinyint(3) unsigned DEFAULT NULL,
  `city_id` smallint(5) unsigned DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `longitude` double(7,4) DEFAULT NULL,
  `latitude` double(7,4) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of action
-- ----------------------------

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `province_id` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES ('1', '中国');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) unsigned DEFAULT NULL,
  `org_id` int(10) unsigned DEFAULT NULL,
  `role` char(1) DEFAULT NULL COMMENT 'c：创建者，a：管理员，m：成员',
  `join_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `country_id` smallint(5) unsigned DEFAULT '0',
  `provice_id` tinyint(3) unsigned DEFAULT NULL,
  `city_id` smallint(5) unsigned DEFAULT NULL,
  `creator_id` bigint(20) unsigned DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of organization
-- ----------------------------

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `country_id` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES ('1', '北京', '1');
INSERT INTO `province` VALUES ('2', '上海', '1');
INSERT INTO `province` VALUES ('3', '重庆', '1');
INSERT INTO `province` VALUES ('4', '天津', '1');
INSERT INTO `province` VALUES ('5', '香港', '1');
INSERT INTO `province` VALUES ('6', '澳门', '1');
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
INSERT INTO `province` VALUES ('20', '台湾', '1');
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
-- Table structure for signup
-- ----------------------------
DROP TABLE IF EXISTS `signup`;
CREATE TABLE `signup` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) unsigned NOT NULL,
  `action_id` bigint(20) unsigned DEFAULT NULL,
  `status` char(1) DEFAULT 's' COMMENT 's：报名，c：取消',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of signup
-- ----------------------------
