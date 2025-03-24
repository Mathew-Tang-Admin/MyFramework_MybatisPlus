/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : dljd_mybatisplus

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 25/03/2025 02:01:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for powershop_user
-- ----------------------------
DROP TABLE IF EXISTS `powershop_user`;
CREATE TABLE `powershop_user`  (
  `id` bigint NOT NULL COMMENT '主键 ID',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` int NULL DEFAULT 1 COMMENT '逻辑删除(1可用,0不可用)',
  `gender` int NULL DEFAULT NULL COMMENT '性别',
  `contact` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系方式',
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `version` int NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of powershop_user
-- ----------------------------
INSERT INTO `powershop_user` VALUES (1, 'Jone', 18, 'test1@baomidou.com', 1, 0, NULL, NULL, '2025-03-23 17:10:52', 1);
INSERT INTO `powershop_user` VALUES (2, 'Jack', 20, 'test2@baomidou.com', 1, 0, NULL, NULL, '2025-03-23 17:10:52', 1);
INSERT INTO `powershop_user` VALUES (3, 'Tom', 28, 'test3@baomidou.com', 1, 0, NULL, NULL, '2025-03-23 17:10:52', 1);
INSERT INTO `powershop_user` VALUES (4, 'Sandy', 21, 'test4@baomidou.com', 1, 1, NULL, NULL, '2025-03-23 17:10:52', 1);
INSERT INTO `powershop_user` VALUES (5, 'Billie', 24, 'test5@baomidou.com', 1, 0, NULL, NULL, '2025-03-23 17:10:52', 1);
INSERT INTO `powershop_user` VALUES (6, '迈克lisi', 20, 'mike@bjpowernode.com', 1, 0, NULL, NULL, '2025-03-24 20:52:03', 2);
INSERT INTO `powershop_user` VALUES (7, 'Mary', 35, 'mary@bjpowernode.com', 0, 1, NULL, NULL, NULL, 1);
INSERT INTO `powershop_user` VALUES (1902776773079228418, 'liu', 29, 'liu@bjpowernode.com', 1, 0, NULL, NULL, '2025-03-23 17:10:52', 1);
INSERT INTO `powershop_user` VALUES (1902777006995542018, 'liu', 29, 'liu@bjpowernode.com', 1, 1, NULL, NULL, '2025-03-23 17:10:52', 1);
INSERT INTO `powershop_user` VALUES (1902794590541365249, 'li', 28, 'li@bjpowernode.com', 1, 0, '{\"phone\":\"010-1234567\",\"tel\":\"13388889999\"}', NULL, '2025-03-23 17:10:52', 1);
INSERT INTO `powershop_user` VALUES (1902802121858760706, 'li', 28, 'li@bjpowernode.com', 1, 0, '{\"phone\":\"010-1234567\",\"tel\":\"13388889999\"}', NULL, '2025-03-23 17:10:52', 1);
INSERT INTO `powershop_user` VALUES (1902802681852866561, 'lisi', 35, 'lisi@bjpowernode.com', 1, 0, '{\"phone\":\"010-1234567\",\"tel\":\"13388889999\"}', '2025-03-21 03:21:26', '2025-03-23 17:10:52', 1);

SET FOREIGN_KEY_CHECKS = 1;
