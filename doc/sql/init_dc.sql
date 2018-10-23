
CREATE TABLE `car_info` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `vin` varchar(50) NOT NULL COMMENT '车架号,唯一',
   `license_plate` varchar(20) DEFAULT NULL COMMENT '车牌号',
   `moto_no` varchar(50) DEFAULT NULL COMMENT '电机号',
   `model_type` varchar(20) NOT NULL COMMENT '车型代码',
   `model_name` varchar(100) DEFAULT NULL COMMENT '车型名称',
   `prod_base_no` varchar(200) DEFAULT NULL COMMONT '生产基地代码',
   `prod_base_name` varchar(200) DEFAULT NULL COMMONT '生产基地名称',
   `tbox_no` varchar(50) DEFAULT NULL COMMENT 'TBOX设备号',
   `memo` varchar(255) DEFAULT NULL COMMONT '备注',
   `state` tinyint(2) DEFAULT NULL COMMONT '车辆状态 0-未销售，1-使用中 2-维修中 3-报废',
   `status` tinyint(1) NOT NULL COMMONT '数据逻辑状态 0-无效，1-有效',
   `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`),
   UNIQUE KEY `idx_vin` (`vin`),
   KEY `idx_license_plate` (`license_plate`),
   KEY `idx_moto_no` (`moto_no`),
   KEY `idx_tbox_no` (`tbox_no`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMONT='车辆信息表';

 
CREATE TABLE `tbox_info` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `meid` varchar(30) NOT NULL COMMENT '设备号,唯一',
   `mdn` varchar(15) DEFAULT NULL COMMENT '手机号',
   `iccid` varchar(30) DEFAULT NULL COMMENT '卡号',
   `provider_no` varchar(50) DEFAULT NULL COMMENT '供应商代码',
   `provider_name` varchar(100) NOT NULL COMMENT '供应商名称',
   `hardware_version` varchar(30) DEFAULT NULL COMMONT '硬件版本',
   `software_verion` varchar(30) DEFAULT NULL COMMONT '软件版本',
   `type` varchar(50) DEFAULT NULL COMMENT '设备型号',
   `state` tinyint(1) DEFAULT NULL COMMONT '设备状态 0-未激活，1-激活 2-废弃',
   `status` tinyint(1) NOT NULL COMMONT '数据逻辑状态 0-无效，1-有效',
   `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`),
   UNIQUE KEY `idx_meid` (`meid`),
   KEY `idx_mdn` (`mdn`),
   KEY `idx_iccid` (`iccid`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMONT='TBOX信息表';

CREATE TABLE `car_alarm` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `serial_no` varchar(100) NOT NULL COMMENT '流水号,唯一(vin + alarm_code + alarm_time(时间用long型))',
   `vin` varchar(20) DEFAULT NULL COMMENT '车架号',
   `tbox_no` varchar(50) DEFAULT NULL COMMENT 'TBOX设备号',
   `alarm_time` timestamp not NULL COMMENT '故障发生时间',
   `longitude`  varchar(20) not NULL COMMENT '故障发生经度',
   `latitude`  varchar(20) not NULL COMMENT '故障发生纬度',
   `level`  varchar(10) not NULL COMMENT '故障级别',
   `alarm_code`  varchar(20) not NULL COMMENT '故障代码',
   `car_state` varchar(20) NOT NULL COMMENT '车辆状态',
   `charge_state` varchar(100) DEFAULT NULL COMMENT '充电状态',
   `status` tinyint(1) NOT NULL COMMONT '数据逻辑状态 0-无效，1-有效',
   `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`),
   UNIQUE KEY `idx_serial_no` (`serial_no`),
   KEY `idx_vin` (`vin`),
   KEY `idx_tbox_no` (`tbox_no`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMONT='车辆报警表';


CREATE TABLE `car_fault` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `serial_no` varchar(100) NOT NULL COMMENT '流水号,唯一(vin + alarm_code + fault_time(时间用long型))',
   `vin` varchar(20) DEFAULT NULL COMMENT '车架号',
   `tbox_no` varchar(50) DEFAULT NULL COMMENT 'TBOX设备号',
   `fault_time` timestamp not NULL COMMENT '故障发生时间',
   `longitude`  varchar(20) not NULL COMMENT '故障发生经度',
   `latitude`  varchar(20) not NULL COMMENT '故障发生纬度',
   `level`  varchar(10) not NULL COMMENT '故障级别',
   `fault_code`  varchar(20) not NULL COMMENT '故障代码',
   `car_state` varchar(20) NOT NULL COMMENT '车辆状态',
   `charge_state` varchar(100) DEFAULT NULL COMMENT '充电状态',
   `relieve_time` timestamp not NULL COMMENT '故障解除时间',
   `relieve_longitude`  varchar(20) not NULL COMMENT '故障解除经度',
   `relieve_latitude`  varchar(20) not NULL COMMENT '故障解除纬度',
   `relieve_car_state` varchar(20) NOT NULL COMMENT '解除时车辆状态',
   `relieve_charge_state` varchar(100) DEFAULT NULL COMMENT '解除时充电状态',
   `status` tinyint(1) NOT NULL COMMONT '数据逻辑状态 0-无效，1-有效',
   `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`),
   UNIQUE KEY `idx_serial_no` (`serial_no`),
   KEY `idx_vin` (`vin`),
   KEY `idx_tbox_no` (`tbox_no`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMONT='车辆故障表';


CREATE TABLE `car_bounds` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `serial_no` varchar(100) NOT NULL COMMENT '流水号,唯一(vin + out_time(时间用long型))',
   `vin` varchar(20) DEFAULT NULL COMMENT '车架号',
   `tbox_no` varchar(50) DEFAULT NULL COMMENT 'TBOX设备号',
   `out_time` timestamp not NULL COMMENT '越界发生时间',
   `longitude`  varchar(20) not NULL COMMENT '越界发生经度',
   `latitude`  varchar(20) not NULL COMMENT '越界发生纬度',
   `back_time` timestamp not NULL COMMENT '越界返回时间',
   `back_longitude`  varchar(20) not NULL COMMENT '越界返回经度',
   `back_latitude`  varchar(20) not NULL COMMENT '越界返回纬度',
   `status` tinyint(1) NOT NULL COMMONT '数据逻辑状态 0-无效，1-有效',
   `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`),
   UNIQUE KEY `idx_serial_no` (`serial_no`),
   KEY `idx_vin` (`vin`),
   KEY `idx_tbox_no` (`tbox_no`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMONT='车辆越界表';


CREATE TABLE `fleet_task` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `task_name` varchar(100) NOT NULL COMMENT '任务名称',
   `license_plate` varchar(20) DEFAULT NULL COMMENT '车牌号',
   `start_time` timestamp not NULL COMMENT '开始时间',
   `end_time` timestamp not NULL COMMENT '结束时间',
   `compnay`  varchar(20) DEFAULT NULL COMMENT '所属公司',
   `fleet`  varchar(20) DEFAULT NULL COMMENT '所属车队',
   `driver`  varchar(10) not NULL COMMENT '指派司机',
   `memo` varchar(255) DEFAULT NULL COMMONT '任务内容',
   `state` tinyint(1) DEFAULT NULL COMMONT '任务状态 0-未开始，1-进行中 2-已结束',
   `status` tinyint(1) NOT NULL COMMONT '数据逻辑状态 0-无效，1-有效',
   `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`),
   KEY `idx_license_plate` (`license_plate`),
   KEY `idx_compnay` (`compnay`),
   KEY `idx_fleet` (`fleet`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMONT='车队任务表';


CREATE TABLE `message` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `vin` varchar(20) DEFAULT NULL COMMENT '车架号',
   `tbox_no` varchar(50) DEFAULT NULL COMMENT 'TBOX设备号',
   `compnay`  varchar(20) DEFAULT NULL COMMENT '所属公司',
   `fleet`  varchar(20) DEFAULT NULL COMMENT '所属车队',
   `send_time` timestamp not NULL COMMENT '发送时间',
   `msg_content` varchar(1000) NOT NULL COMMONT '消息内容',
   `msg_type` tinyint(1) NOT NULL COMMONT '消息类型 1-告警消息，2-故障信息 3-越界信息 4-违章信息 5-其他通知',
   `state` tinyint(1) NOT NULL COMMONT '消息状态 0-未发送，1-已发送',
   `status` tinyint(1) NOT NULL COMMONT '数据逻辑状态 0-无效，1-有效',
   `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`),
   KEY `idx_vin` (`vin`),
   KEY `idx_tbox_no` (`tbox_no`),
   KEY `idx_compnay` (`compnay`),
   KEY `idx_fleet` (`fleet`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMONT='消息表';
