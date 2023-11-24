/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : homework

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 31/10/2022 09:43:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author`  (
  `author_id` int(0) NOT NULL COMMENT '作者ID',
  `author_username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客标题',
  `author_password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者ID',
  `author_email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客邮箱',
  `author_bio` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者简介',
  `author_favourite_section` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`author_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES (1, 'zzz', '0fabcd34', 'assa@123.com', 'aaaaaaaaaaaaaa', 'bbbbbbbbbbbbbb');
INSERT INTO `author` VALUES (2, 'ccc', '039438d', 'ifa@163.com', 'ccccccccccccccc', 'dddddddddddd');
INSERT INTO `author` VALUES (3, 'ddd', '23ddfwg', '009@qq.com', 'eeeeeeeeeeeee', 'fffffffffffffff');

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `blog_id` int(0) NOT NULL COMMENT '博客ID',
  `blog_title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客标题',
  `blog_author_id` int(0) NOT NULL COMMENT '作者ID',
  `state` int(0) NOT NULL COMMENT '博客状态',
  PRIMARY KEY (`blog_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (1, 'Blog1', 2, 0);
INSERT INTO `blog` VALUES (2, 'Blog2', 1, 1);
INSERT INTO `blog` VALUES (3, 'Blog3', 3, 2);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(0) NOT NULL COMMENT '评论ID',
  `comment_post_id` int(0) NOT NULL COMMENT '文章ID',
  `comment_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论名',
  `comment_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, 'ddd', 'dddddddd');
INSERT INTO `comment` VALUES (2, 1, 'ccc', 'zzzzzzzzzzzdsfd');
INSERT INTO `comment` VALUES (3, 2, 'ggg', 'cvsewrfsfd');
INSERT INTO `comment` VALUES (4, 3, 'bbb', 'werbfdaafd');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `post_id` int(0) NOT NULL COMMENT '作者ID',
  `post_blog_id` int(0) NOT NULL COMMENT '博客标题',
  `post_author_id` int(0) NOT NULL COMMENT '作者ID',
  `post_created_on` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客邮箱',
  `post_section` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者简介',
  `post_subject` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章主题',
  `post_body` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章主体',
  `draft` int(0) NOT NULL,
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (1, 1, 2, '2022-12-17', 'aaaaa', 'SubjectA', 'dddddddd', 0);
INSERT INTO `post` VALUES (2, 1, 3, '2022-06-01', 'cccccc', 'SubjectB', 'ccccccccc', 1);
INSERT INTO `post` VALUES (3, 1, 1, '2022-10-28', 'dddd', 'SubjectC', 'eeeeeeee', 0);

-- ----------------------------
-- Table structure for post_tag
-- ----------------------------
DROP TABLE IF EXISTS `post_tag`;
CREATE TABLE `post_tag`  (
  `post_id` int(0) NOT NULL COMMENT '文章ID',
  `tag_id` int(0) NOT NULL COMMENT '标签ID'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post_tag
-- ----------------------------
INSERT INTO `post_tag` VALUES (1, 1);
INSERT INTO `post_tag` VALUES (1, 3);
INSERT INTO `post_tag` VALUES (1, 5);
INSERT INTO `post_tag` VALUES (2, 2);
INSERT INTO `post_tag` VALUES (2, 4);
INSERT INTO `post_tag` VALUES (3, 3);
INSERT INTO `post_tag` VALUES (3, 5);

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `tag_id` int(0) NOT NULL COMMENT '标签ID',
  `tag_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名',
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (1, 'tag1');
INSERT INTO `tag` VALUES (2, 'tag2');
INSERT INTO `tag` VALUES (3, 'tag3');
INSERT INTO `tag` VALUES (4, 'tag4');
INSERT INTO `tag` VALUES (5, 'tag5');
INSERT INTO `tag` VALUES (6, 'tag6');

SET FOREIGN_KEY_CHECKS = 1;
