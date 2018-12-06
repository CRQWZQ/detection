CREATE TABLE `customer_info` (
  `id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `modify_time` datetime NOT NULL,
  `relation_uuid` varchar(128) NOT NULL,
  `nick` varchar(128) NOT NULL,
  `punish_count` int(11) NOT NULL,
  `no_sales_count` int(11) NOT NULL,
  `rate_delete_count` int(11) NOT NULL,
  `avg_number` int(11) NOT NULL,
  `credit` varchar(200) NOT NULL,
  `real_name_auth` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `tao_score` varchar(50) DEFAULT NULL,
  `mongodb_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uuid` (`relation_uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;