SET NAMES utf8;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL comment '用户名',
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `register_date` timestamp DEFAULT CURRENT_TIMESTAMP,
  `enabled` tinyint(1) DEFAULT 1,
  `role` varchar(50) DEFAULT NULL comment '角色',
  `avatar_url` varchar(200) DEFAULT '' comment '头像',
  PRIMARY KEY (`id`)
);
ALTER TABLE `user` ADD UNIQUE (`username`);
ALTER TABLE `user` ADD UNIQUE (`email`);
ALTER TABLE `user` ADD UNIQUE (`phone`);
 DROP TABLE IF EXISTS `info`;
CREATE TABLE `info`(
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`USERNAME` VARCHAR(50) DEFAULT NULL comment '用户名',
`GRADE`  VARCHAR(50) DEFAULT NULL,
`PHONE`  VARCHAR(20) DEFAULT NULL,
`NUMBER` VARCHAR(50) DEFAULT NULL,
`avatar_url` varchar(200) DEFAULT '' comment '证件照',
  PRIMARY KEY (`id`)
 );
 ALTER TABLE `info` ADD UNIQUE (`username`);
 ALTER TABLE `info` ADD UNIQUE (`phone`);
 