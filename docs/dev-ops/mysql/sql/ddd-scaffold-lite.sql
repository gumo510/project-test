/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50639
 Source Host           : localhost:3306
 Source Schema         : road-map

 Target Server Type    : MySQL
 Target Server Version : 50639
 File Encoding         : 65001

 Date: 15/07/2023 09:26:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE database if NOT EXISTS `ddd-scaffold-lite` default character set utf8mb4 collate utf8mb4_0900_ai_ci;
use `ddd-scaffold-lite`;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `employee_number` varchar(16) NOT NULL DEFAULT '' COMMENT '雇员ID',
  `employee_name` varchar(32) NOT NULL DEFAULT '' COMMENT '雇员姓名',
  `employee_level` varchar(8) NOT NULL DEFAULT '' COMMENT '雇员级别',
  `employee_title` varchar(16) NOT NULL DEFAULT '' COMMENT '雇员岗位Title',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_employee_number` (`employee_number`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;