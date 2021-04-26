
CREATE TABLE `carrot` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `short_name` varchar(45) DEFAULT NULL,
  `district_level` tinyint(3) NOT NULL COMMENT '单位层级',
  `is_enabled` tinyint(1) DEFAULT '0',
  `is_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='胡萝卜';

CREATE TABLE `district` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT '名称',
  `code` int(11) unsigned NOT NULL COMMENT '编码',
  `level` tinyint(4) unsigned NOT NULL COMMENT '查询层级',
  `lft` int(11) NOT NULL COMMENT '查询左边界',
  `rgt` int(11) NOT NULL COMMENT '查询左边界',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ethnicity` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `party` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `short_name` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `person` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `portrait` varchar(45) DEFAULT NULL COMMENT '肖像',
  `gender` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `ethnicity_id` tinyint(3) unsigned DEFAULT NULL,
  `party_id` tinyint(3) unsigned DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `death_date` date DEFAULT NULL,
  `work_date` date DEFAULT NULL,
  `party_date` date DEFAULT NULL,
  `retire_date` date DEFAULT NULL,
  `birth_place` int(11) DEFAULT NULL,
  `ancestral_home` int(11) DEFAULT NULL,
  `work_place` int(11) unsigned DEFAULT NULL,
  `university` varchar(45) DEFAULT NULL,
  `major` varchar(45) DEFAULT NULL,
  `education` varchar(45) DEFAULT NULL,
  `degree` varchar(45) DEFAULT NULL,
  `ranking` tinyint(3) unsigned DEFAULT NULL,
  `create_time` date NOT NULL,
  `update_time` date NOT NULL,
  `is_enabled` tinyint(1) DEFAULT '1',
  `is_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pit` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pid` int(10) NOT NULL DEFAULT '0',
  `name` varchar(45) NOT NULL,
  `short_name` varchar(45) DEFAULT NULL,
  `level` tinyint(3) unsigned NOT NULL COMMENT '查询层级',
  `ranking` tinyint(4) NOT NULL DEFAULT '0' COMMENT '行政级别',
  `district_level` tinyint(3) DEFAULT NULL,
  `lft` int(11) unsigned NOT NULL,
  `rgt` int(11) unsigned NOT NULL,
  `is_enabled` tinyint(1) DEFAULT '1',
  `is_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单位';

CREATE TABLE `profile` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `start_time` date NOT NULL,
  `end_time` date DEFAULT NULL,
  `person_id` int unsigned NOT NULL,
  `district_id` int unsigned NOT NULL,
  `pit_id` int unsigned NOT NULL,
  `carrot_id` int unsigned NOT NULL,
  `remark` varchar(45) DEFAULT NULL,
  `summary` varchar(45) DEFAULT NULL,
  `priority` tinyint unsigned DEFAULT '1',
  `is_enabled` tinyint(1) DEFAULT '1',
  `is_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_profile_carrot_id_idx` (`carrot_id`),
  KEY `fk_profile_pit_id_idx` (`pit_id`),
  KEY `fk_profile_district_id_idx` (`district_id`),
  KEY `fk_profile_person_id_idx` (`person_id`),
  CONSTRAINT `fk_profile_carrot_id` FOREIGN KEY (`carrot_id`) REFERENCES `carrot` (`id`),
  CONSTRAINT `fk_profile_district_id` FOREIGN KEY (`district_id`) REFERENCES `district` (`id`),
  CONSTRAINT `fk_profile_person_id` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_profile_pit_id` FOREIGN KEY (`pit_id`) REFERENCES `pit` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `z_cccpc` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `number` int(2) unsigned zerofill NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `z_falmily` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `z_rotten` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
