CREATE TABLE `prd_model_configs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vin` varbinary(20) DEFAULT NULL COMMENT '车架号',
  `model` varchar(255) DEFAULT NULL COMMENT '车型',
  `config_level` varchar(255) DEFAULT NULL COMMENT '配置级别（高/中/低等）',
  `configs` varchar(3000) DEFAULT NULL COMMENT '配置',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `factory_id` int(11) DEFAULT NULL COMMENT '车厂id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车型配置信息';

/*Table structure for table `prd_part_battery` */

CREATE TABLE `prd_part_battery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vin` varchar(20) DEFAULT NULL COMMENT '车架号',
  `code` varchar(255) DEFAULT NULL COMMENT '编号',
  `model` varchar(255) DEFAULT NULL COMMENT '型号',
  `supplier_code` varchar(255) DEFAULT NULL COMMENT '供应商代码',
  `supplier` varchar(255) DEFAULT NULL COMMENT '供应商',
  `batch_no` varchar(255) DEFAULT NULL COMMENT '生产批次',
  `product_date` date DEFAULT NULL COMMENT '生产日期',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `capacity` varchar(255) DEFAULT NULL COMMENT '电池容量',
  `electric` varchar(255) DEFAULT NULL COMMENT '电池电量',
  `rated_voltage` varchar(255) DEFAULT NULL COMMENT '额定电压',
  `rated_current` varchar(255) DEFAULT NULL COMMENT '额定电流',
  `total_battery_num` varchar(255) DEFAULT NULL COMMENT '单体电池总数',
  `series_battery_num` varchar(255) DEFAULT NULL COMMENT '电池所上传的单体串联数',
  `temperature_num` varchar(255) DEFAULT NULL COMMENT '温度探针数',
  `temperature_node_num` varchar(255) DEFAULT NULL COMMENT '温度探针节点数',
  `soft_ver` varchar(255) DEFAULT NULL COMMENT '软件版本',
  `hard_ver` varchar(255) DEFAULT NULL COMMENT '硬件版本',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `factory_id` int(11) DEFAULT NULL COMMENT '车厂id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零部件-电池信息';

/*Table structure for table `prd_part_bms` */

CREATE TABLE `prd_part_bms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vin` varchar(20) DEFAULT NULL COMMENT '车架号',
  `code` varchar(255) DEFAULT NULL COMMENT '编号',
  `model` varchar(255) DEFAULT NULL COMMENT '型号',
  `supplier_code` varchar(255) DEFAULT NULL COMMENT '供应商代码',
  `supplier` varchar(255) DEFAULT NULL COMMENT '供应商',
  `batch_no` varchar(255) DEFAULT NULL COMMENT '生产批次',
  `product_date` date DEFAULT NULL COMMENT '生产日期',
  `soft_ver` varchar(255) DEFAULT NULL COMMENT '软件版本',
  `hard_ver` varchar(255) DEFAULT NULL COMMENT '硬件版本',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `factory_id` int(11) DEFAULT NULL COMMENT '车厂id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零部件-电池控制器';

/*Table structure for table `prd_part_charge_moter` */

CREATE TABLE `prd_part_charge_moter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vin` varchar(20) DEFAULT NULL COMMENT '车架号',
  `code` varchar(255) DEFAULT NULL COMMENT '编号',
  `model` varchar(255) DEFAULT NULL COMMENT '型号',
  `supplier_code` varchar(255) DEFAULT NULL COMMENT '供应商代码',
  `supplier` varchar(255) DEFAULT NULL COMMENT '供应商',
  `batch_no` varchar(255) DEFAULT NULL COMMENT '生产批次',
  `product_date` date DEFAULT NULL COMMENT '生产日期',
  `soft_ver` varchar(255) DEFAULT NULL COMMENT '软件版本',
  `hard_ver` varchar(255) DEFAULT NULL COMMENT '硬件版本',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `factory_id` int(11) DEFAULT NULL COMMENT '车厂id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零部件-充电电机';

/*Table structure for table `prd_part_ihu` */

CREATE TABLE `prd_part_ihu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vin` varchar(20) DEFAULT NULL COMMENT '车架号',
  `code` varchar(255) DEFAULT NULL COMMENT '编号',
  `model` varchar(255) DEFAULT NULL COMMENT '型号',
  `supplier_code` varchar(255) DEFAULT NULL COMMENT '供应商代码',
  `supplier` varchar(255) DEFAULT NULL COMMENT '供应商',
  `batch_no` varchar(255) DEFAULT NULL COMMENT '生产批次',
  `product_date` date DEFAULT NULL COMMENT '生产日期',
  `soft_ver` varchar(255) DEFAULT NULL COMMENT '软件版本',
  `hard_ver` varchar(255) DEFAULT NULL COMMENT '硬件版本',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `factory_id` int(11) DEFAULT NULL COMMENT '车厂id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零部件-车载娱乐主机';

/*Table structure for table `prd_part_mcu` */

CREATE TABLE `prd_part_mcu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vin` varchar(20) DEFAULT NULL COMMENT '车架号',
  `code` varchar(255) DEFAULT NULL COMMENT '编号',
  `model` varchar(255) DEFAULT NULL COMMENT '型号',
  `supplier_code` varchar(255) DEFAULT NULL COMMENT '供应商代码',
  `supplier` varchar(255) DEFAULT NULL COMMENT '供应商',
  `batch_no` varchar(255) DEFAULT NULL COMMENT '生产批次',
  `product_date` date DEFAULT NULL COMMENT '生产日期',
  `soft_ver` varchar(255) DEFAULT NULL COMMENT '软件版本',
  `hard_ver` varchar(255) DEFAULT NULL COMMENT '硬件版本',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `factory_id` int(11) DEFAULT NULL COMMENT '车厂id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零部件-驱动电机控制器';

/*Table structure for table `prd_part_motor` */

CREATE TABLE `prd_part_motor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vin` varchar(20) DEFAULT NULL COMMENT '车架号',
  `code` varchar(255) DEFAULT NULL COMMENT '编号',
  `model` varchar(255) DEFAULT NULL COMMENT '型号',
  `supplier_code` varchar(255) DEFAULT NULL COMMENT '供应商代码',
  `supplier` varchar(255) DEFAULT NULL COMMENT '供应商',
  `batch_no` varchar(255) DEFAULT NULL COMMENT '生产批次',
  `product_date` date DEFAULT NULL COMMENT '生产日期',
  `rated_power` varchar(255) DEFAULT NULL COMMENT '额定功率',
  `peak_power` varchar(255) DEFAULT NULL COMMENT '峰值功率',
  `soft_ver` varchar(255) DEFAULT NULL COMMENT '软件版本',
  `hard_ver` varchar(255) DEFAULT NULL COMMENT '硬件版本',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `factory_id` int(11) DEFAULT NULL COMMENT '车主id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零部件-驱动电机';

/*Table structure for table `prd_part_tbox` */

CREATE TABLE `prd_part_tbox` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vin` varchar(20) DEFAULT NULL COMMENT '车架号',
  `code` varchar(255) DEFAULT NULL COMMENT '编号',
  `model` varchar(255) DEFAULT NULL COMMENT '型号',
  `supplier_code` varchar(255) DEFAULT NULL COMMENT '供应商代码',
  `supplier` varchar(255) DEFAULT NULL COMMENT '供应商',
  `batch_no` varchar(255) DEFAULT NULL COMMENT '生产批次',
  `product_date` date DEFAULT NULL COMMENT '生产日期',
  `soft_ver` varchar(255) DEFAULT NULL COMMENT '软件版本',
  `hard_ver` varchar(255) DEFAULT NULL COMMENT '硬件版本',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `factory_id` int(11) DEFAULT NULL COMMENT '车厂id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零部件-车载终端';

/*Table structure for table `prd_part_vcu` */

CREATE TABLE `prd_part_vcu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vin` varchar(20) DEFAULT NULL COMMENT '车架号',
  `code` varchar(255) DEFAULT NULL COMMENT '编号',
  `model` varchar(255) DEFAULT NULL COMMENT '型号',
  `supplier_code` varchar(255) DEFAULT NULL COMMENT '供应商代码',
  `supplier` varchar(255) DEFAULT NULL COMMENT '供应商',
  `batch_no` varchar(255) DEFAULT NULL COMMENT '生产批次',
  `product_date` date DEFAULT NULL COMMENT '生产日期',
  `soft_ver` varchar(255) DEFAULT NULL COMMENT '软件版本',
  `hard_ver` varchar(255) DEFAULT NULL COMMENT '硬件版本',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `factory_id` int(11) DEFAULT NULL COMMENT '车厂id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零部件-整车控制器';


