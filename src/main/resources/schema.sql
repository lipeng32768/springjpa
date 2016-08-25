use test;
CREATE TABLE users(
`id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
`phone_number` varchar(25) NOT NULL UNIQUE COMMENT '手机号',
`name` varchar(25) COMMENT '用户名',
`email` varchar(64)   COMMENT 'Emial',
`create_time` TIMESTAMP  NOT  NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (id),
key idx_phonr(phone_number),
key idx_create_time(create_time)
)ENGINE = InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET = utf8 COMMENT '用户表';