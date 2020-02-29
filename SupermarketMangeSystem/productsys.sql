/*
Navicat MySQL Data Transfer

Source Server         : zhupengdou
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : productsys

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2018-06-05 19:16:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bases`
-- ----------------------------
DROP TABLE IF EXISTS `bases`;
CREATE TABLE `bases` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bname` varchar(255) DEFAULT NULL,
  `baddrs` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bases
-- ----------------------------
INSERT INTO `bases` VALUES ('1', '北一号仓库', '...');
INSERT INTO `bases` VALUES ('2', '北二号仓库', '...');
INSERT INTO `bases` VALUES ('3', '南一号仓库', '...');

-- ----------------------------
-- Table structure for `gysxx`
-- ----------------------------
DROP TABLE IF EXISTS `gysxx`;
CREATE TABLE `gysxx` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(500) DEFAULT NULL,
  `gno` varchar(500) DEFAULT NULL,
  `lxr` varchar(500) DEFAULT NULL,
  `lxtel` varchar(500) DEFAULT NULL,
  `addrs` varchar(500) DEFAULT NULL,
  `zy` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gysxx
-- ----------------------------
INSERT INTO `gysxx` VALUES ('6', '武汉打印机公司', 'fa.001', '阿汤', '02788888888', '北京中北三路346', '打印机');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderno` varchar(500) DEFAULT NULL,
  `memberno` varchar(500) DEFAULT NULL,
  `pinfo` varchar(500) DEFAULT NULL,
  `ywy` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', 'jd.001', '大发彩印公司', '要十五台打印机', 'ywy.01');
INSERT INTO `orders` VALUES ('2', 'jd.002', '大发彩印公司', '要十台打印机', 'ywy.01');

-- ----------------------------
-- Table structure for `sysuser`
-- ----------------------------
DROP TABLE IF EXISTS `sysuser`;
CREATE TABLE `sysuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) DEFAULT NULL,
  `upass` varchar(255) DEFAULT NULL,
  `utype` varchar(255) DEFAULT NULL,
  `tname` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `addrs` varchar(255) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `savetime` varchar(255) DEFAULT NULL,
  `zyfw` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysuser
-- ----------------------------
INSERT INTO `sysuser` VALUES ('1', 'admin', '123', '系统管理员', '小王', '女', '02711111112', '51889090@QQ.com', '苏州', '201412261120550001.gif', '2018-05-21 00:00:00', null);
INSERT INTO `sysuser` VALUES ('6', 'kc01', '123', '库存管理员', '阿张', '女', '02788888888', '213@21.com', '山东济南友谊大道', '201304211512140001.jpg', '2018-05-21 19:55:08', null);
INSERT INTO `sysuser` VALUES ('9', 'yw01', '123', '业务管理员', '小王', '女', '02711111111', '123@qq.com', '北京中北三路346', '201412261121160002.jpg', '2018-05-21 09:39:52', null);
INSERT INTO `sysuser` VALUES ('10', '大发彩印公司', '123', '客户', '老王', '女', '02711111111', '1123111@qq.com', '...', '201412221615270007.jpg', '2018-05-21 15:15:24', '打印机');
INSERT INTO `sysuser` VALUES ('11', '武汉办公器材厂', '123', '供应商', '王小姐', '女', '02711111111', '1123111@qq.com', '武汉', '', '2018-05-21 11:32:36', '办公器材');

-- ----------------------------
-- Table structure for `wpcrinfo`
-- ----------------------------
DROP TABLE IF EXISTS `wpcrinfo`;
CREATE TABLE `wpcrinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `optype` varchar(500) DEFAULT NULL,
  `opdate` varchar(500) DEFAULT NULL,
  `member` varchar(500) DEFAULT NULL,
  `pchi` varchar(500) DEFAULT NULL,
  `wpno` varchar(255) DEFAULT NULL,
  `spname` varchar(500) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `yprice` varchar(255) DEFAULT NULL,
  `tnum` varchar(500) DEFAULT NULL,
  `nnum` varchar(500) DEFAULT NULL,
  `jcontent` varchar(255) DEFAULT NULL,
  `je` varchar(255) DEFAULT NULL,
  `guig` varchar(500) DEFAULT NULL,
  `gys` varchar(500) DEFAULT NULL,
  `scdate` varchar(500) DEFAULT NULL,
  `yxdate` varchar(500) DEFAULT NULL,
  `cfwz` varchar(500) DEFAULT NULL,
  `uname` varchar(500) DEFAULT NULL,
  `savetime` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wpcrinfo
-- ----------------------------
INSERT INTO `wpcrinfo` VALUES ('38', '入库', '2018-05-21', '', 'rk.001', 'no.001', '打印机', '1000', '2000', '100', '100', null, '100000', 'G0020', '武汉办公器材厂', '2018-05-21', '2018-05-29', '南一号仓库', 'admin', '2018-05-21 16:33:56');
INSERT INTO `wpcrinfo` VALUES ('39', '入库', '2018-05-21', '', 'rk.002', 'no.002', '传真机', '2000', '4000', '50', '35', null, '100000', 'G0010', '武汉办公器材厂', '2018-05-21', '2018-05-29', '南一号仓库', 'admin', '2018-05-21 16:34:56');
INSERT INTO `wpcrinfo` VALUES ('50', '报损', '2018-05-21', '', 'rk.002', 'no.002', '传真机', '2000', '', '10', '35', '坏了，返修', '20000', '', '武汉办公器材厂', '', '', '', 'admin', '2018-05-21 09:44:44');
INSERT INTO `wpcrinfo` VALUES ('51', '出库', '2018-05-21', '大发彩印公司', 'rk.002', 'no.002', '传真机', '', '4000', '10', '35', '', '40000', '', '武汉办公器材厂', '', '', '', 'admin', '2018-05-21 09:45:23');
INSERT INTO `wpcrinfo` VALUES ('52', '退货', '2018-05-21', '大发彩印公司', 'rk.002', 'no.002', '传真机', '', '4000', '5', '', '质量不行', '20000', '51', '武汉办公器材厂', '', '', '', 'admin', '2018-05-21 09:46:31');
INSERT INTO `wpcrinfo` VALUES ('53', '入库', '2018-05-21', '', 'rk.003', 'no.001', '打印机', '1000', '3000', '100', '100', '', '100000', 'G0010', '武汉办公器材厂', '2018-05-21', '2018-05-29', '南一号仓库', 'admin', '2018-05-21 09:49:41');

-- ----------------------------
-- Table structure for `wpjbxx`
-- ----------------------------
DROP TABLE IF EXISTS `wpjbxx`;
CREATE TABLE `wpjbxx` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wpno` varchar(500) DEFAULT NULL,
  `wpname` varchar(500) DEFAULT NULL,
  `danwei` varchar(500) DEFAULT NULL,
  `wptype` varchar(500) DEFAULT NULL,
  `maxnum` varchar(255) DEFAULT NULL,
  `minum` varchar(255) DEFAULT NULL,
  `bei` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wpjbxx
-- ----------------------------
INSERT INTO `wpjbxx` VALUES ('1', 'no.002', '传真机', '台', '办公器材类', '100', '10', '...');
INSERT INTO `wpjbxx` VALUES ('2', 'no.001', '打印机', '台', '办公器材类', '100', '10', '...');

-- ----------------------------
-- Table structure for `wptypes`
-- ----------------------------
DROP TABLE IF EXISTS `wptypes`;
CREATE TABLE `wptypes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wptypes
-- ----------------------------
INSERT INTO `wptypes` VALUES ('1', '办公器材类');
INSERT INTO `wptypes` VALUES ('2', '办公耗材类');
