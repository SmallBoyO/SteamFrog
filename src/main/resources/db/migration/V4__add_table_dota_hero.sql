-- ----------------------------
-- dota英雄表
-- ----------------------------
CREATE TABLE `dota_hero` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `create_time` datetime NOT NULL,
  `modify_time` datetime NOT NULL,
  `is_delete` bit(1) NOT NULL default false COMMENT '是否删除 0:否 1:是',
  `hero_id` int(32) COMMENT '对应id',
  `name` varchar(64) COMMENT '英雄名',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- dota 物品表
-- ----------------------------
CREATE TABLE `dota_item` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `create_time` datetime NOT NULL,
  `modify_time` datetime NOT NULL,
  `is_delete` bit(1) NOT NULL default false COMMENT '是否删除 0:否 1:是',
  `item_id` int(32) COMMENT '对应id',
  `name` varchar(64) COMMENT '物品名',
  `cost` int(32) COMMENT '价格',
  `secret_shop` int(32) COMMENT '是否在神秘商店',
  `side_shop` int(32) COMMENT '是否在边路商店',
  `recipe` int(32) COMMENT '是否是卷轴',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;