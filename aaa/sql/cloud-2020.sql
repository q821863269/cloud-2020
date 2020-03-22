SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `serial` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES (1, '001');
INSERT INTO `payment` VALUES (2, '002');
INSERT INTO `payment` VALUES (3, '003');
INSERT INTO `payment` VALUES (4, '004');
INSERT INTO `payment` VALUES (5, '005');

SET FOREIGN_KEY_CHECKS = 1;
