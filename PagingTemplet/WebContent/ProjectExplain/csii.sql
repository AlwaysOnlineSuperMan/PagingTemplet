/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : csii

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2016-03-23 11:06:19
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `mcutilitiesexpenseitem`
-- ----------------------------
DROP TABLE IF EXISTS `mcutilitiesexpenseitem`;
CREATE TABLE `mcutilitiesexpenseitem` (
  `UTILITIES_CODE` varchar(50) NOT NULL,
  `UTILITIES_NAME` varchar(50) NOT NULL,
  `CHANNEL_ID` varchar(50) NOT NULL,
  `TRANS_CODE` varchar(50) NOT NULL,
  `IMAGE_PATH` varchar(50) NOT NULL,
  `SORT` varchar(50) NOT NULL,
  PRIMARY KEY  (`UTILITIES_CODE`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mcutilitiesexpenseitem
-- ----------------------------
INSERT INTO mcutilitiesexpenseitem VALUES ('1', '水费', 'PBOP', 'UtilitiesPreForWater', 'UtilitiesPreForWater.png', '1');
INSERT INTO mcutilitiesexpenseitem VALUES ('2', '电费', 'PBOP', 'UtilitiesPreForEle', 'UtilitiesPreForEle.png', '2');
INSERT INTO mcutilitiesexpenseitem VALUES ('3', '燃气费', 'PBOP', 'UtilitiesPreForGas', 'UtilitiesPreForGas.png', '3');
INSERT INTO mcutilitiesexpenseitem VALUES ('4', '有线电视', 'PBOP', 'UtilitiesPreForDTV', 'UtilitiesPreForDTV.png', '5');
INSERT INTO mcutilitiesexpenseitem VALUES ('5', '学费代缴', 'PBOP', 'UtilitiesPreForTuition', 'UtilitiesPreForTuition.png', '7');
INSERT INTO mcutilitiesexpenseitem VALUES ('6', '买汽车票', 'PBOP', 'UtilitiesPreForTrain', 'UtilitiesPreForTrain.png', '8');
INSERT INTO mcutilitiesexpenseitem VALUES ('7', '医疗缴费', 'PBOP', 'UtilitiesPreForHospital', 'UtilitiesPreForHospital.png', '9');
INSERT INTO mcutilitiesexpenseitem VALUES ('8', '联通缴费', 'PBOP', 'UtilitiesPreUnicomPhone', 'UtilitiesPreUnicomPhone.png', '10');
INSERT INTO mcutilitiesexpenseitem VALUES ('9', '移动缴费', 'PBOP', 'UtilitiesPreMovePhone', 'UtilitiesPreMovePhone.png', '11');
INSERT INTO mcutilitiesexpenseitem VALUES ('10', '电信缴费', 'PBOP', 'UtilitiesPreTelePhone', 'UtilitiesPreTelePhone.png', '12');
INSERT INTO mcutilitiesexpenseitem VALUES ('11', '数字电视', 'PBOP', 'UtilitiesPreForFigureDTV', 'UtilitiesPreForFigureDTV.png', '6');
INSERT INTO mcutilitiesexpenseitem VALUES ('12', '特色缴费', 'PBOP', 'UtilitiesPreForChara', 'UtilitiesPreForChara.png', '13');
INSERT INTO mcutilitiesexpenseitem VALUES ('13', '手机充值', 'PBOP', 'UtilitiesPreForPhone', 'UtilitiesPreForPhone.png', '4');

-- ----------------------------
-- Table structure for `mcutilitiesexpunit`
-- ----------------------------
DROP TABLE IF EXISTS `mcutilitiesexpunit`;
CREATE TABLE `mcutilitiesexpunit` (
  `UNITCODE` varchar(26) default NULL,
  `UNITNAME` varchar(64) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mcutilitiesexpunit
-- ----------------------------
