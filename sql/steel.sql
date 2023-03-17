/*
 Navicat Premium Data Transfer

 Source Server         : Connection
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : steel

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 15/12/2020 14:32:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_log_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_log_info`;
CREATE TABLE `tbl_log_info`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '进出货物日志表主键',
  `operator_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作项目名称 【1. 新增货物 2.进货 3.卖货 4.删除货物】',
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '钢材名称',
  `type` double NULL DEFAULT NULL COMMENT '钢材种类【单位】 kg',
  `ton` double NULL DEFAULT NULL COMMENT '操作吨数',
  `money` double NULL DEFAULT NULL COMMENT '进货单价/出售单价',
  `num` double NULL DEFAULT NULL COMMENT '钢材数量 【根】',
  `operator_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  `su_id` int(20) NOT NULL COMMENT '供应商或客户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_log_info
-- ----------------------------
INSERT INTO `tbl_log_info` VALUES (3, '新货物入库', '五角钢管', 20, 4, 3, 200, '2020-12-15 05:05:46', 3);
INSERT INTO `tbl_log_info` VALUES (4, '已有货物入库', '三角钢管', 30, 0.3, 6, 10, '2020-12-15 05:16:25', 1);
INSERT INTO `tbl_log_info` VALUES (5, '出售货物', '三角钢管', 30, 0.3, 7, 10, '2020-12-15 05:29:50', 5);
INSERT INTO `tbl_log_info` VALUES (6, '已有货物入库', '三角钢管', 30, 0.09, 7, 3, '2020-12-15 06:27:09', 1);
INSERT INTO `tbl_log_info` VALUES (7, '出售货物', '三角钢管', 30, 0.09, 8, 3, '2020-12-15 06:27:18', 5);
INSERT INTO `tbl_log_info` VALUES (8, '已有货物入库', '三角钢管', 30, 0.09, 8, 3, '2020-12-15 06:29:36', 1);
INSERT INTO `tbl_log_info` VALUES (9, '出售货物', '三角钢管', 30, 0.09, 8, 3, '2020-12-15 06:29:41', 5);

-- ----------------------------
-- Table structure for tbl_steel_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_steel_info`;
CREATE TABLE `tbl_steel_info`  (
  `sid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '钢材信息主键【所有信息】',
  `steel_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '钢材名称',
  `steel_type` double NULL DEFAULT NULL COMMENT '钢材的类型 【单位】kg',
  `steel_num` double NULL DEFAULT NULL COMMENT '钢材的数量【单位】 根',
  `steel_ton` double NULL DEFAULT NULL COMMENT '钢材的吨位【单位】 吨',
  `steel_in_money` double NULL DEFAULT NULL COMMENT '进货价钱 【单位】元/kg',
  `steel_status` int(11) NULL DEFAULT NULL COMMENT '货物状态【1.启用 2.未启用】',
  `steel_description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对钢材信息的详细描述',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_steel_info
-- ----------------------------
INSERT INTO `tbl_steel_info` VALUES (1, '槽钢', 53, 600, 31.8, 6, 1, NULL);
INSERT INTO `tbl_steel_info` VALUES (2, '角铁', 25, 400, 10, 6, 1, NULL);
INSERT INTO `tbl_steel_info` VALUES (3, '镀锌管', 10, 100, 1, 8, 1, NULL);
INSERT INTO `tbl_steel_info` VALUES (4, '槽铁', 52, 300, 15.6, 6, 1, NULL);
INSERT INTO `tbl_steel_info` VALUES (5, '钢板10寸', 56, 200, 11.2, 6, 1, NULL);
INSERT INTO `tbl_steel_info` VALUES (6, '四角铁', 52, 100, 5.2, 10, 1, NULL);
INSERT INTO `tbl_steel_info` VALUES (7, '方圆管', 40, 600, 24, 4, 1, NULL);
INSERT INTO `tbl_steel_info` VALUES (8, '钢板12寸', 56, 300, 16.8, 6, 1, '');
INSERT INTO `tbl_steel_info` VALUES (9, '钢管21寸', 20, 100, 2, 10, 1, NULL);
INSERT INTO `tbl_steel_info` VALUES (10, '六角钢管', 10, 200, 2, 6, 1, '');
INSERT INTO `tbl_steel_info` VALUES (11, '三角钢管', 30, 510, 15.3, 7, 1, '');
INSERT INTO `tbl_steel_info` VALUES (12, '四角钢管', 20, 200, 4, 3, 1, '');
INSERT INTO `tbl_steel_info` VALUES (14, '五角钢管', 20, 200, 4, 3, 1, '');

-- ----------------------------
-- Table structure for tbl_supplier_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_supplier_info`;
CREATE TABLE `tbl_supplier_info`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名字',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `type` int(10) NOT NULL COMMENT '0：供应商 1：客户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_supplier_info
-- ----------------------------
INSERT INTO `tbl_supplier_info` VALUES (1, '腾达钢镚厂', '13825545956', '河北省廊坊市', 0);
INSERT INTO `tbl_supplier_info` VALUES (3, '飞达钢厂', '15485691654', '河北省邢台市', 0);
INSERT INTO `tbl_supplier_info` VALUES (5, '黄达有限公司', '15484561254', '河北省唐山市', 1);
INSERT INTO `tbl_supplier_info` VALUES (6, '飞达有限公司', '15487562125', '北京市东城区', 1);

-- ----------------------------
-- Table structure for tbl_user_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_info`;
CREATE TABLE `tbl_user_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户表主键id',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_user_info
-- ----------------------------
INSERT INTO `tbl_user_info` VALUES (1, 'zhanghonglin', '123456', '2019-07-30 22:32:19');
INSERT INTO `tbl_user_info` VALUES (2, 'admin', '123456', '2020-12-14 08:39:00');

SET FOREIGN_KEY_CHECKS = 1;
