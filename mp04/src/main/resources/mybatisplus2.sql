/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : mybatisplus2

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 25/03/2025 02:01:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for powershop_user
-- ----------------------------
DROP TABLE IF EXISTS `powershop_user`;
CREATE TABLE `powershop_user`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of powershop_user
-- ----------------------------
INSERT INTO `powershop_user` VALUES (1, '李寻欢', 18, 'test1@bjpowernode.com');

SET FOREIGN_KEY_CHECKS = 1;
