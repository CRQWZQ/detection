CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `modify_time` datetime NOT NULL,
  `shop_id` bigint(20) NOT NULL COMMENT '创建活动的shopId',
  `uuid` varchar(128) NOT NULL COMMENT '活动的uuid',
  `name` varchar(256) NOT NULL COMMENT '创建的活动名字',
  `is_delete` int(10) NOT NULL COMMENT '是否删除',
  `status` varchar(50) NOT NULL COMMENT '活动状态：NORMAL,END,FREEZE',
  PRIMARY KEY (`id`),
  KEY `uuid,shop_id` (`uuid`,`shop_id`) USING BTREE,
  KEY `relationUuid` (`uuid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;
