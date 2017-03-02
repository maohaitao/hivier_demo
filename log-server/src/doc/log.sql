drop table IF EXISTS `bike_banana`.`hi_product`;
CREATE TABLE `hi_product` (
  `code` varchar(64) NOT NULL COMMENT '统计标示',
  `device_no` varchar(128) DEFAULT NULL COMMENT '设备号',
  `imei` varchar(128) DEFAULT NULL COMMENT 'imei',
  `imsi` varchar(128) DEFAULT NULL COMMENT 'imsi',
  `channel` varchar(128) DEFAULT NULL COMMENT 'channel 渠道',
  `locals` varchar(128) DEFAULT NULL COMMENT 'locals 国家',
  `lang` varchar(128) DEFAULT NULL COMMENT 'lang 语言',
  `sdk` varchar(128) DEFAULT NULL COMMENT 'sdk',
  `models` varchar(128) DEFAULT NULL COMMENT 'models',
  `dpi` varchar(128) DEFAULT NULL COMMENT 'dpi',
  `net` varchar(128) DEFAULT NULL COMMENT '网络',
  `timestamps` varchar(128) DEFAULT NULL COMMENT '时间',
  `device_type` int(11) DEFAULT '0' COMMENT '活动类型 2 IOS 1 ANDROID',
  `account_id` varchar(128) DEFAULT NULL COMMENT '用户ID',
  `count_id` varchar(200) DEFAULT NULL COMMENT '统计Id',
  `ra_id` varchar(200) DEFAULT NULL COMMENT '统计Id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息表';


drop table IF EXISTS `bike_banana`.`hi_user_info`;
CREATE TABLE `hi_user_info` (
  `code` varchar(64) NOT NULL COMMENT '统计标示',
  `device_no` varchar(128) DEFAULT NULL COMMENT '设备号',
  `imei` varchar(128) DEFAULT NULL COMMENT 'imei',
  `imsi` varchar(128) DEFAULT NULL COMMENT 'imsi',
  `channel` varchar(128) DEFAULT NULL COMMENT 'channel 渠道',
  `locals` varchar(128) DEFAULT NULL COMMENT 'locals 国家',
  `lang` varchar(128) DEFAULT NULL COMMENT 'lang 语言',
  `sdk` varchar(128) DEFAULT NULL COMMENT 'sdk',
  `models` varchar(128) DEFAULT NULL COMMENT 'models',
  `dpi` varchar(128) DEFAULT NULL COMMENT 'dpi',
  `net` varchar(128) DEFAULT NULL COMMENT '网络',
  `timestamps` varchar(128) DEFAULT NULL COMMENT '时间',
  `device_type` int(11) DEFAULT '0' COMMENT '活动类型 2 IOS 1 ANDROID',
  `account_id` varchar(128) DEFAULT NULL COMMENT '用户ID',
  `count_id` varchar(200) DEFAULT NULL COMMENT '统计Id',
  `ra_id` varchar(200) DEFAULT NULL COMMENT '统计Id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息';


drop table IF EXISTS `bike_banana`.`hi_blog`;
CREATE TABLE `hi_blog` (
  `code` varchar(64) NOT NULL COMMENT '统计标示',
  `device_no` varchar(128) DEFAULT NULL COMMENT '设备号',
  `imei` varchar(128) DEFAULT NULL COMMENT 'imei',
  `imsi` varchar(128) DEFAULT NULL COMMENT 'imsi',
  `channel` varchar(128) DEFAULT NULL COMMENT 'channel 渠道',
  `locals` varchar(128) DEFAULT NULL COMMENT 'locals 国家',
  `lang` varchar(128) DEFAULT NULL COMMENT 'lang 语言',
  `sdk` varchar(128) DEFAULT NULL COMMENT 'sdk',
  `models` varchar(128) DEFAULT NULL COMMENT 'models',
  `dpi` varchar(128) DEFAULT NULL COMMENT 'dpi',
  `net` varchar(128) DEFAULT NULL COMMENT '网络',
  `timestamps` varchar(128) DEFAULT NULL COMMENT '时间',
  `device_type` int(11) DEFAULT '0' COMMENT '活动类型 2 IOS 1 ANDROID',
  `account_id` varchar(128) DEFAULT NULL COMMENT '用户ID',
  `count_id` varchar(200) DEFAULT NULL COMMENT '统计Id',
  `ra_id` varchar(200) DEFAULT NULL COMMENT '统计Id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客文章';


drop table IF EXISTS `bike_banana`.`log_server_info`;
CREATE TABLE `log_server_info` (
  `code` varchar(64) NOT NULL COMMENT '统计标示',
  `device_no` varchar(128) DEFAULT NULL COMMENT '设备号',
  `imei` varchar(128) DEFAULT NULL COMMENT 'imei',
  `imsi` varchar(128) DEFAULT NULL COMMENT 'imsi',
  `channel` varchar(128) DEFAULT NULL COMMENT 'channel 渠道',
  `locals` varchar(128) DEFAULT NULL COMMENT 'locals 国家',
  `lang` varchar(128) DEFAULT NULL COMMENT 'lang 语言',
  `sdk` varchar(128) DEFAULT NULL COMMENT 'sdk',
  `models` varchar(128) DEFAULT NULL COMMENT 'models',
  `dpi` varchar(128) DEFAULT NULL COMMENT 'dpi',
  `net` varchar(128) DEFAULT NULL COMMENT '网络',
  `timestamps` varchar(128) DEFAULT NULL COMMENT '时间',
  `device_type` int(11) DEFAULT '0' COMMENT '活动类型 2 IOS 1 ANDROID',
  `account_id` varchar(128) DEFAULT NULL COMMENT '用户ID',
  `count_id` varchar(200) DEFAULT NULL COMMENT '统计Id',
  `ra_id` varchar(200) DEFAULT NULL COMMENT '统计Id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='统计基础信息表';

SET SQL_SAFE_UPDATES=0;
update log_server_info set code='2017-02-22 00:000:00' where code<'2017-02-23 00:000:00';

load data local infile '/data/mysqlLog/info.countserver.2017-02-23.0' into table log_server_info fields terminated by '||';

select count_id, count(account_id) as '次数',count(distinct(account_id)) as '人数' from log_server_info group by count_id;

select code,count_id,ra_id as '业务ID', count(account_id) as '次数',
count(distinct(account_id)) as '人数' from log_server_info group by count_id,ra_id;


load data local infile '/data/mysqlLog/info.countserver.2017-02-20.0' into table log_server_info fields terminated by '||';
load data local infile '/data/mysqlLog/info.countserver.2017-02-20.1' into table log_server_info fields terminated by '||';
SET SQL_SAFE_UPDATES=0;
update log_server_info set code='2017-02-20 00:000:00' where code<'2017-02-21 00:000:00';


load data local infile '/data/mysqlLog/info.countserver.2017-02-19.0' into table log_server_info fields terminated by '||';
load data local infile '/data/mysqlLog/info.countserver.2017-02-19.1' into table log_server_info fields terminated by '||';
SET SQL_SAFE_UPDATES=0;
update log_server_info set code='2017-02-19 00:000:00' where code<'2017-02-20 00:000:00';

load data local infile '/data/mysqlLog/info.countserver.2017-02-18.0' into table log_server_info fields terminated by '||';
load data local infile '/data/mysqlLog/info.countserver.2017-02-18.1' into table log_server_info fields terminated by '||';
SET SQL_SAFE_UPDATES=0;
update log_server_info set code='2017-02-18 00:000:00' where code<'2017-02-19 00:000:00';

load data local infile '/data/mysqlLog/info.countserver.2017-02-17.0' into table log_server_info fields terminated by '||';
load data local infile '/data/mysqlLog/info.countserver.2017-02-17.1' into table log_server_info fields terminated by '||';
SET SQL_SAFE_UPDATES=0;
update log_server_info set code='2017-02-17 00:000:00' where code<'2017-02-18 00:000:00';

load data local infile '/data/mysqlLog/info.countserver.2017-02-26.0' into table log_server_info fields terminated by '||';
load data local infile '/data/mysqlLog/info.countserver.2017-02-26.1' into table log_server_info fields terminated by '||';
SET SQL_SAFE_UPDATES=0;

update log_server_info set code='2017-02-26 00:000:00' where code>'2017-02-26 00:000:00' and code<'2017-02-27 00:000:00';


select code,device_type as '设备',count_id,ra_id as '业务ID', count(account_id) as '次数',
count(distinct(account_id)) as '人数' from log_server_info group by count_id,ra_id,device_type,code ORDER BY CODE;