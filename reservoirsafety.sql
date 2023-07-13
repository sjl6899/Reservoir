/*
Navicat MySQL Data Transfer

Source Server         : Lay
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : reservoirsafety

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2023-07-13 22:22:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for reservoir
-- ----------------------------
DROP TABLE IF EXISTS `reservoir`;
CREATE TABLE `reservoir` (
  `reservoirId` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `height` double DEFAULT NULL,
  `longer` double DEFAULT NULL,
  `width` double DEFAULT NULL,
  `maxhg` double DEFAULT NULL,
  `bulk` double DEFAULT NULL,
  `inventory` double DEFAULT NULL,
  `area` double DEFAULT NULL,
  `component` varchar(255) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `stability` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`reservoirId`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reservoir
-- ----------------------------
INSERT INTO `reservoir` VALUES ('1', '中国', '石板沟', '52.5', '450', '800', '0.07', '15', '11', '3546', '块石型', '116.457', '40.2527', '不稳定');
INSERT INTO `reservoir` VALUES ('2', '中国', '孙家院子', '50', '180', '400', '0.13', '1.6', '5.6', '1785', '混合型', '115.0026', '37.9186', '不稳定');
INSERT INTO `reservoir` VALUES ('3', '中国', '易贡', '110', '2500', '2500', '0.04', '300', '3000', '13533', '混合型', '104.4118', '30.8081', '不稳定');
INSERT INTO `reservoir` VALUES ('4', '中国', '燕子岩', '10', '40', '20', '0.5', '0.01', '0.03', '18', '块石型', '117.2282', '39.1399', '不稳定');
INSERT INTO `reservoir` VALUES ('5', '中国', '肖家桥', '62', '200', '200', '0.31', '2.42', '20', '231', '混合型', '105.8954', '29.3493', '不稳定');
INSERT INTO `reservoir` VALUES ('6', '中国', '肖家沟', '15', '500', '100', '0.15', '0.75', '0.23', '7.23', '土质型', '116.5464', '39.9795', '不稳定');
INSERT INTO `reservoir` VALUES ('7', '中国', '小岗剑下游', '30', '120', '400', '0.08', '0.45', '7', '378', '混合型', '101.7401', '27.6092', '不稳定');
INSERT INTO `reservoir` VALUES ('8', '中国', '小岗剑上游', '95', '300', '300', '0.32', '2', '12', '376', '块石型', '101.7639', '27.5706', '不稳定');
INSERT INTO `reservoir` VALUES ('9', '中国', '红松', '50', '100', '60', '0.83', '0.26', '1', '10', '土质型', '11.0401', '45.6263', '不稳定');
INSERT INTO `reservoir` VALUES ('10', '印度', 'Birehi Ganga', '274', '760', '2750', '0.1', '286', '460', '253', '混合型', '10.9967', '45.8974', '不稳定');
INSERT INTO `reservoir` VALUES ('11', '意大利', 'Valderchia', '9', '110', '160', '0.06', '0.1', '0.00595', '4.5', '土质型', '11.1701', '44.2424', '不稳定');
INSERT INTO `reservoir` VALUES ('12', '意大利', 'Val Vanoi', '40', '500', '1000', '0.04', '10', '18.2', '167', '土质型', '11.7897', '46.1731', '不稳定');
INSERT INTO `reservoir` VALUES ('13', '意大利', 'Tovel', '45', '1300', '1700', '0.03', '40', '7.37', '40.4', '块石型', '10.939', '46.3977', '稳定');
INSERT INTO `reservoir` VALUES ('14', '意大利', 'Schiazzano', '15', '40', '65', '0.23', '0.02', '0.00883', '5.6', '土质型', '14.4179', '40.6667', '不稳定');
INSERT INTO `reservoir` VALUES ('15', '意大利', 'Scanno', '33.1', '500', '2000', '0.02', '17', '26', '95', '块石型', '13.8239', '41.8678', '稳定');
INSERT INTO `reservoir` VALUES ('16', '意大利', 'Sernio', '43', '300', '930', '0.05', '2', '22', '891', '土质型', '10.1947', '46.1622', '不稳定');
INSERT INTO `reservoir` VALUES ('17', '意大利', 'Rovina', '15', '400', '900', '0.02', '2', '1.2', '17.2', '混合型', '10.8751', '45.6369', '稳定');
INSERT INTO `reservoir` VALUES ('18', '意大利', 'Ronchi', '20', '160', '190', '0.11', '0.3', '0.471', '24.5', '土质型', '11.0983', '45.9155', '稳定');
INSERT INTO `reservoir` VALUES ('19', '中国', '新街村', '20', '350', '200', '0.1', '0.7', '2', '3546', '土质型', '121.4992', '31.2322', '不稳定');
INSERT INTO `reservoir` VALUES ('20', '中国', '唐家湾', '30', '300', '600', '0.05', '4', '15.2', '1395', '土质型', '104.0816', '30.6714', '不稳定');
INSERT INTO `reservoir` VALUES ('21', '中国', '唐家山', '120', '611.8', '802', '0.15', '20.37', '316', '3550', '土质型', '121.48', '31.22', '不稳定');
INSERT INTO `reservoir` VALUES ('22', '意大利', 'Tramarecchia', '20', '200', '450', '0.04', '1.5', '0.58', '40.8', '混合型', '12.3033', '45.657', '稳定');
INSERT INTO `reservoir` VALUES ('23', '意大利', 'Tenno', '50', '900', '650', '0.08', '10', '5', '19.3', '土质型', '10.8645', '45.917', '稳定');
INSERT INTO `reservoir` VALUES ('24', '意大利', 'Signatico', '30', '450', '620', '0.05', '8.37', '8', '151.5', '土质型', '11.0787', '43.4748', '不稳定');
INSERT INTO `reservoir` VALUES ('25', '意大利', 'Prato Casarile', '40', '200', '450', '0.09', '1.75', '0.3', '1.5', '土质型', '10.9719', '44.8638', '稳定');
INSERT INTO `reservoir` VALUES ('26', '日本', 'Abe River', '30', '500', '650', '0.05', '4.88', '4.7', '19', '块石型', '137.8506', '36.1037', '稳定');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'czy', '123');
INSERT INTO `user` VALUES ('2', 'sjl', '123');
INSERT INTO `user` VALUES ('3', 'lsy', '1234');
INSERT INTO `user` VALUES ('5', 'lay', '666');
INSERT INTO `user` VALUES ('6', 'admin', '1234');
INSERT INTO `user` VALUES ('7', 'lay1', '111');
INSERT INTO `user` VALUES ('8', 'lay2', '222');
INSERT INTO `user` VALUES ('9', 'abc', '777');
INSERT INTO `user` VALUES ('10', 'ddd', 'ddd');
INSERT INTO `user` VALUES ('11', 'lay3', '123');

-- ----------------------------
-- Table structure for zjreservoir
-- ----------------------------
DROP TABLE IF EXISTS `zjreservoir`;
CREATE TABLE `zjreservoir` (
  `name` varchar(255) DEFAULT NULL,
  `nameId` int(11) NOT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  PRIMARY KEY (`nameId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjreservoir
-- ----------------------------
INSERT INTO `zjreservoir` VALUES ('余杭水库', '1', '119.9746', '30.2762');
INSERT INTO `zjreservoir` VALUES ('千岛湖水库', '2', '119.0001', '29.6157');
INSERT INTO `zjreservoir` VALUES ('牛头山水库', '3', '121.7457', '29.7874');
INSERT INTO `zjreservoir` VALUES ('老虎潭水库', '4', '119.9205', '30.6716');
INSERT INTO `zjreservoir` VALUES ('长潭水库', '5', '121.3332', '28.6222');
INSERT INTO `zjreservoir` VALUES ('珊溪水库', '6', '120.345', '27.778');
