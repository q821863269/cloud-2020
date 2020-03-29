/*
 Navicat Premium Data Transfer

 Source Server         : 120.78.211.28
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : 120.78.211.28:3306
 Source Schema         : seata_storage

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 29/03/2020 20:39:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_storage
-- ----------------------------
DROP TABLE IF EXISTS `t_storage`;
CREATE TABLE `t_storage`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(0) NULL DEFAULT NULL COMMENT '产品id',
  `total` int(0) NULL DEFAULT NULL COMMENT '总库存',
  `used` int(0) NULL DEFAULT NULL COMMENT '已用库存',
  `residue` int(0) NULL DEFAULT NULL COMMENT '剩余库存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_storage
-- ----------------------------
INSERT INTO `t_storage` VALUES (1, 1, 100, 0, 100);

SET FOREIGN_KEY_CHECKS = 1;
