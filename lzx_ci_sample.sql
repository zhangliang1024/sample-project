/*
 Navicat Premium Data Transfer

 Source Server         : lzx-ci-sample_ON_101.89.91.168
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 101.89.91.168:8806
 Source Schema         : lzx_ci_sample

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 06/03/2019 10:52:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `count` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES (1, 1, '测试订单', '2', '3', '1', '2019-03-06 10:49:43', '2019-03-06 10:49:46');
INSERT INTO `order_item` VALUES (2, 1, '测试订单', '3', '2', '1', '2019-03-06 10:50:05', '2019-03-06 10:50:08');
INSERT INTO `order_item` VALUES (3, 3, '测试订单', '1', '6', '1', '2019-03-06 10:50:21', '2019-03-06 10:50:24');
INSERT INTO `order_item` VALUES (4, 4, '测试订单', '6', '1', '1', '2019-03-06 10:50:39', '2019-03-06 10:50:43');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` int(11) NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `status` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (1, '订单1', '测试订单1', '2019-03-06 10:47:38', '1', 1);
INSERT INTO `t_order` VALUES (2, '订单2', '测试订单2', '2019-03-06 10:47:54', '1', 1);
INSERT INTO `t_order` VALUES (3, '订单3', '测试订单3', '2019-03-06 10:48:22', '1', 2);
INSERT INTO `t_order` VALUES (4, '订单4', '测试订4', '2019-03-06 10:48:32', '1', 2);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '郭靖', 'MALE', '18600001001', 'abcdefg');
INSERT INTO `user` VALUES (2, '黄蓉', 'FEMALE', '18600001002', 'abcdefg1');
INSERT INTO `user` VALUES (3, 'admin', 'MALE', '18888888888', 'abcd1234');

SET FOREIGN_KEY_CHECKS = 1;
