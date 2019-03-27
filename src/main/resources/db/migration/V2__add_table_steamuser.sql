-- ----------------------------
-- steam用户表
-- ----------------------------
CREATE TABLE `steam_user` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `create_time` datetime NOT NULL,
  `modify_time` datetime NOT NULL,
  `is_delete` bit(1) NOT NULL default false COMMENT '是否删除 0:否 1:是',
  `steam_id` bigint NOT NULL COMMENT 'steamId',
  `community_visibility_state` int(2) NOT NULL COMMENT 'profile是否可见 1:不可见 3:可见',
  `profile_state` int(2) COMMENT '用户是否配置profile 1:已配置',
  `name` varchar(128) COMMENT '',
  `last_log_off` int(32) COMMENT '最后登录时间(时间戳)',
  `profile_url` varchar(512) COMMENT '',
  `avatar_url` varchar(512) COMMENT '头像地址',
  `avatar_medium_url` varchar(512) COMMENT '中头像地址',
  `avatar_full_url` varchar(512) COMMENT 'full头像地址',
  `persona_state` int(2) COMMENT '用户状态 0:不在线 1:在线 2:忙碌 3:离开 4:打盹 5:寻求交易 6:寻求play (如果用户profile不可见 则用户状态总为0)',
  `primary_group_id` bigint COMMENT '',
  `time_created` int(32) COMMENT '建立账号的时间',
  `persona_state_flags` int(32) COMMENT '',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;