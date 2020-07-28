drop table if exists qdh_auth_user;
create table qdh_auth_user
(
   id                   varchar(64) NOT NULL primary key comment '主键id',
   tenant_id            varchar(64) NULL COMMENT '租户id',
   account              varchar(64) NOT NULL comment '用户账号',
   mobile               varchar(20) NOT NULL default '' comment '手机号',
   email                varchar(64) NOT NULL default '' comment '邮箱',
   password             varchar(256) NOT NULL comment '密码',
   salt                 varchar(32) NOT NULL comment '密码盐值',
   real_name            varchar(20) NOT NULL default '' comment '真实姓名',
   nick_name            varchar(20) NOT NULL comment '用户昵称',
   account_type			varchar(2) NOT NULL comment '账号类型：0普通账号，1超级管理员，2租户管理员，3项目管理员',
   `version`            int not null default 1 comment '版本号字段，用于乐观锁',
   `creator`            varchar(64) null comment '创建人',
   `create_time`        timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   `updator`            varchar(64) null default '' comment '修改人',
   `update_time`        timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
	UNIQUE INDEX `UK_ACCOUNT` (`account` ASC),
	UNIQUE INDEX `UK_MOBILE` (`mobile` ASC),
	INDEX `tenant_id` (`tenant_id` ASC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment 'qdh_用户表';

drop table if exists qdh_auth_tenant_info;
CREATE TABLE `qdh_auth_tenant_info` (
   id                    varchar(64) NOT NULL primary key comment '主键id',
   `tenant_name`         varchar(50) NOT NULL COMMENT '租户名称',
   `province_code`       varchar(44) NOT NULL COMMENT '所在省',
   `province_name`       varchar(44) NOT NULL COMMENT '省名称',
   `city_code`           varchar(44) NOT NULL COMMENT '所在市',
   `city_name`           varchar(44) NOT NULL COMMENT '市名称',
   `address`             varchar(500) NOT NULL COMMENT '租户地址',
   `link_man`            varchar(20) NOT NULL COMMENT '联系人',
   `phone`               varchar(20) NOT NULL COMMENT '联系电话',
   `description`         varchar(500) NOT NULL default '' COMMENT '租户描述',
   `parent_id`           varchar(20) NOT NULL DEFAULT '-1' COMMENT '父节点id（-1为顶层）',
   `status`              char(2) NOT NULL DEFAULT '1' COMMENT '是否可用(0 不可用 1 可用)',
   `version`             int not null default 1 comment '版本号字段，用于乐观锁',
   `creator`             varchar(64) not null comment '创建人',
   `create_time`         timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   `updator`             varchar(64) not null default '' comment '修改人',
   `update_time`         timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment 'qdh_租户表';

drop table if exists qdh_auth_project;
create table qdh_auth_project
(
   id                    varchar(64) NOT NULL primary key comment '主键id',
   `tenant_id`           varchar(64) NOT NULL COMMENT '租户id',
   `project_name`        varchar(64) NOT NULL comment '项目名称',
   `province_code`       varchar(44) NOT NULL COMMENT '所在省',
   `province_name`       varchar(44) NOT NULL COMMENT '省名称',
   `city_code`           varchar(44) NOT NULL COMMENT '所在市',
   `city_name`           varchar(44) NOT NULL COMMENT '市名称',
   `street_code`         varchar(44) DEFAULT NULL COMMENT '所在街道',
   `street_name`         varchar(44) DEFAULT NULL COMMENT '街道名称',
   `address`             varchar(500) NOT NULL COMMENT '项目详细地址',
   `version`             int not null default 1 comment '版本号字段，用于乐观锁',
   `creator`             varchar(64) not null comment '创建人',
   `create_time`         timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   `updator`             varchar(64) not null default '' comment '修改人',
   `update_time`         timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
	INDEX `tenant_id` (`tenant_id` ASC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment 'qdh_项目表';

drop table if exists qdh_auth_user_project;
create table qdh_auth_user_project
(
   id                   varchar(64) NOT NULL primary key comment '主键id',
   tenant_id            varchar(64) NOT NULL comment '租户id',
   user_id              varchar(64) NOT NULL comment '用户id',
   project_id           varchar(64) NOT NULL comment '项目id',
   `version`            int not null default 1 comment '版本号字段，用于乐观锁',
   `creator`            varchar(64) comment '创建人',
   `create_time`        timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   `updator`            varchar(64) comment '修改人',
   `update_time`        timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
	INDEX `tenant_id` (`tenant_id` ASC),
	INDEX `user_id` (`user_id` ASC),
	INDEX `project_id` (`project_id` ASC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment 'qdh_用户项目表';

drop table if exists qdh_auth_role;
create table qdh_auth_role
(
   id                   varchar(64) NOT NULL primary key comment '主键id',
   tenant_id            varchar(64) NOT NULL comment '租户id',
   project_id           varchar(64) NOT NULL comment '项目id',
   role_name            varchar(64) NOT NULL comment '角色名称',
   role_code            varchar(64) NOT NULL comment '角色code',
   role_sort            int NOT NULL default 0 comment '排序字段，值越大越靠前',
   `version`            int not null default 1 comment '版本号字段，用于乐观锁',
   `creator`            varchar(64) comment '创建人',
   `create_time`        timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   `updator`            varchar(64) comment '修改人',
   `update_time`        timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
	INDEX `tenant_id` (`tenant_id` ASC),
	INDEX `project_id` (`project_id` ASC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment 'qdh_角色表';

drop table if exists qdh_auth_user_role;
create table qdh_auth_user_role
(
   id                   varchar(64) NOT NULL primary key comment '主键id',
   tenant_id            varchar(64) NOT NULL comment '租户id',
   project_id           varchar(64) NOT NULL comment '项目id',
   user_id              varchar(64) NOT NULL comment '用户id',
   role_id              varchar(64) NOT NULL comment '角色id',
   `version`            int not null default 1 comment '版本号字段，用于乐观锁',
   `creator`            varchar(64) comment '创建人',
   `create_time`        timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   `updator`            varchar(64) comment '修改人',
   `update_time`        timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
	INDEX `tenant_id` (`tenant_id` ASC),
	INDEX `project_id` (`project_id` ASC),
	INDEX `user_id` (`user_id` ASC),
	INDEX `role_id` (`role_id` ASC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment 'qdh_用户角色表';

drop table if exists qdh_auth_menu;
create table qdh_auth_menu
(
   id                   varchar(64) NOT NULL primary key comment '主键id',
   menu_name            varchar(64) NOT NULL comment '菜单名称',
   menu_code            varchar(64) NOT NULL comment '菜单code',
   menu_url             varchar(64) NOT NULL comment '菜单url',
   menu_icon            varchar(64) NOT NULL comment '菜单图标',
   menu_sort            int NOT NULL default 0 comment '排序字段，值越大越靠前',
   plat_code            varchar(64) NOT NULL comment '平台类型，用来进行多个平台见的权限转换',
   parent_menu_id       varchar(64) NOT NULL default '-1' comment '-1为顶层菜单',
   `version`            int not null default 1 comment '版本号字段，用于乐观锁',
   `creator`            varchar(64) comment '创建人',
   `create_time`        timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   `updator`            varchar(64) comment '修改人',
   `update_time`        timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment 'qdh_菜单表';

drop table if exists qdh_auth_role_menu;
create table qdh_auth_role_menu
(
   id                   varchar(64) NOT NULL primary key comment '主键id',
   tenant_id            varchar(64) NOT NULL comment '租户id',
   project_id           varchar(64) NOT NULL comment '项目id',
   role_id              varchar(64) NOT NULL comment '角色id',
   menu_id              varchar(64) NOT NULL comment '菜单id',
   `version`            int not null default 1 comment '版本号字段，用于乐观锁',
   `creator`            varchar(64) comment '创建人',
   `create_time`        timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   `updator`            varchar(64) comment '修改人',
   `update_time`        timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
	INDEX `tenant_id` (`tenant_id` ASC),
	INDEX `project_id` (`project_id` ASC),
	INDEX `role_id` (`role_id` ASC),
	INDEX `menu_id` (`menu_id` ASC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment 'qdh_角色菜单表';


drop table if exists qdh_auth_menu_operate;
create table qdh_auth_menu_operate
(
   id                   varchar(64) NOT NULL primary key comment '主键id',
   tenant_id            varchar(64) NOT NULL comment '租户id',
   project_id           varchar(64) NOT NULL comment '项目id',
   menu_id              varchar(64) NOT NULL comment '菜单id',
   operate_name         varchar(64) NOT NULL comment '操作名称',
   operate_code         varchar(64) NOT NULL comment '操作code',
   operate_remark       varchar(64) NOT NULL DEFAULT '' comment '操作说明',
   `version`            int not null default 1 comment '版本号字段，用于乐观锁',
   `creator`            varchar(64) comment '创建人',
   `create_time`        timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   `updator`            varchar(64) comment '修改人',
   `update_time`        timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
	INDEX `tenant_id` (`tenant_id` ASC),
	INDEX `project_id` (`project_id` ASC),
	INDEX `menu_id` (`menu_id` ASC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment 'qdh_操作表';


CREATE TABLE `qdh_base_product` (
  `id` varchar(64) NOT NULL,
  `product_id` varchar(64) NOT NULL COMMENT '产品id',
  `product_name` varchar(64) NOT NULL COMMENT '产品名称',
  `identifier` varchar(64) NOT NULL COMMENT '产品代号',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updator` varchar(64) DEFAULT NULL COMMENT '修改人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_product_id` (`product_id`),
  KEY `ix_product_id` (`product_id`),
  KEY `ix_identifier` (`identifier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='RBA-物模型-产品定义表';


CREATE TABLE `qdh_base_product_property` (
  `id` varchar(64) NOT NULL,
  `product_id` varchar(64) NOT NULL COMMENT '产品id',
  `property_id` varchar(64) NOT NULL COMMENT '属性id',
  `identifier` varchar(64) NOT NULL COMMENT '属性代号',
  `property_name` varchar(255) DEFAULT NULL COMMENT '属性名称',
  `data_type` varchar(64) DEFAULT NULL COMMENT '属性字段类型',
  `data_schema` varchar(64) DEFAULT NULL COMMENT '属性内容',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updator` varchar(64) DEFAULT NULL COMMENT '修改人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_product_property_id` (`product_id`,`property_id`),
  KEY `ix_property_id` (`property_id`),
  KEY `ix_identifier` (`identifier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='RBA-物模型-产品属性表';



CREATE TABLE `qdh_base_product_service` (
  `id` varchar(64) NOT NULL,
  `service_id` varchar(64) DEFAULT NULL COMMENT '服务id',
  `product_id` varchar(64) NOT NULL COMMENT '产品id',
  `service_name` varchar(64) NOT NULL COMMENT '服务名称',
  `service_code` varchar(64) NOT NULL COMMENT '服务code',
  `identifier` varchar(64) NOT NULL COMMENT '服务代号',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updator` varchar(64) DEFAULT NULL COMMENT '修改人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `ix_product_id` (`product_id`),
  KEY `ix_identifier` (`identifier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='RBA-物模型-服务定义表';


CREATE TABLE `qdh_base_service_property_relation` (
  `id` varchar(64) NOT NULL,
  `service_id` varchar(64) DEFAULT NULL COMMENT '服务id',
  `product_id` varchar(64) NOT NULL COMMENT '产品id',
  `property_id` varchar(64) NOT NULL COMMENT '属性id',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updator` varchar(64) DEFAULT NULL COMMENT '修改人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_property_id` (`property_id`),
  KEY `ix_property_id` (`property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='RBA-物模型-服务属性关联表';