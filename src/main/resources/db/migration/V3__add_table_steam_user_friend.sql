-- ----------------------------
-- steam用户好友表
-- ----------------------------
CREATE TABLE `steam_user_friend` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `create_time` datetime NOT NULL,
  `modify_time` datetime NOT NULL,
  `is_delete` bit(1) NOT NULL default false COMMENT '是否删除 0:否 1:是',
  `user_id` int(32) NOT NULL COMMENT '用户id',
  `friend_id` int(32) NOT NULL COMMENT '好友id',
  PRIMARY KEY (`id`),
  INDEX idx_user_id_is_delete(user_id,is_delete)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;