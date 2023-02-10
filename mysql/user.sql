/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : b

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 10/02/2023 15:56:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `hobbies` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `photopath` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (5, '张三三', 22, '2023-01-11', '喝,玩', '女', 'upload/0fd772ad-6867-4df5-8cf0-290dc8df3d50.jpg');
INSERT INTO `user` VALUES (9, '乌苏', 22, '2022-12-13', '吃,乐', '男', 'upload/1d390de7-5256-41ac-a797-bb360b456b9c.jpg');
INSERT INTO `user` VALUES (10, '王五', 22, '2022-12-13', '吃,乐', '男', 'upload/4aa965f5-0ba6-4085-98c2-0429335bd284.jpg');
INSERT INTO `user` VALUES (11, '赵六', 22, '2022-12-13', '吃,乐', '男', 'upload/6e271068-243a-47fd-9b84-484f5c11ce25.jpg');
INSERT INTO `user` VALUES (12, '猴七', 22, '2022-12-13', '吃,乐', '男', 'upload/100abf97-e8b0-4df1-ae3f-8f3e5e4258d1.jpg');
INSERT INTO `user` VALUES (13, '王飞', 22, '2022-12-13', '吃,乐', '男', 'upload/9413714a-60bc-498c-8342-6081ada41a47.jpg');
INSERT INTO `user` VALUES (14, '王飞王', 22, '2022-12-13', '吃,乐', '男', 'upload/5f8fd3e1-f140-4404-8234-5f35ffe8ef5d.jpg');
INSERT INTO `user` VALUES (15, '李四思7', 22, '2022-12-13', '吃,乐,喝', '女', 'upload/a016becf-761b-404c-a2d9-36498090064b.jpg');
INSERT INTO `user` VALUES (33, '为谔谔', 12, '2023-02-25', '吃,喝', '男', 'upload/befa460c-5510-4db2-8c5c-04d45ce6f02c.png');
INSERT INTO `user` VALUES (35, '342444', 11, '2023-02-25', '玩,吃', '男', 'upload/92b6fb71-5e70-4c1c-b5b2-e4aea2572021.jpg');

SET FOREIGN_KEY_CHECKS = 1;
