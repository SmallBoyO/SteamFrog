-- ----------------------------
-- steam用户表
-- ----------------------------
CREATE TABLE `account` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '账户id',
  `add_time` datetime NOT NULL,
  `edit_time` datetime NOT NULL,
  `delete` bit(1) NOT NULL default false COMMENT '是否删除 0:否 1:是',
  `steamId` int(32) NOT NULL COMMENT 'steamId',
  `communityVisibilityState` int(2) NOT NULL COMMENT 'profile是否可见 1:不可见 3:可见',
  `profileState` int(2) COMMENT '用户是否配置profile 1:已配置',
  `name` varchar(128) COMMENT '',
  `lastLogOff` int(32) COMMENT '最后登录时间(时间戳)',
  `profileUrl` varchar(512) COMMENT '',
  `avatarUrl` varchar(512) COMMENT '头像地址',
  `avatarMediumUrl` varchar(512) COMMENT '中头像地址',
  `avatarFullUrl` varchar(512) COMMENT 'full头像地址',
  `personaState` int(2) COMMENT '用户状态 0:不在线 1:在线 2:忙碌 3:离开 4:打盹 5:寻求交易 6:寻求play (如果用户profle不可见 则用户状态总为0)',
  `primaryGroupId` int(32) COMMENT '',
  `timeCreated` int(32) COMMENT '建立账号的时间',
  `personaStateFlags` int(32) COMMENT '',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;