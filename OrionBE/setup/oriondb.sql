# Host: localhost  (Version: 5.6.26-log)
# Date: 2016-01-20 20:50:15
# Generator: MySQL-Front 5.3  (Build 4.224)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "grosserygroups"
#

DROP TABLE IF EXISTS `grosserygroups`;
CREATE TABLE `grosserygroups` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "grossiers"
#

DROP TABLE IF EXISTS `grossiers`;
CREATE TABLE `grossiers` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `group_id` int(11) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "shoppinglist"
#

DROP TABLE IF EXISTS `shoppinglist`;
CREATE TABLE `shoppinglist` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `status` smallint(6) NOT NULL DEFAULT '0',
  `owner` smallint(6) DEFAULT '0',
  `name` varchar(255) NOT NULL DEFAULT '',
  `created` varchar(20) DEFAULT NULL,
  `reminder` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

#
# Structure for table "shoppinglist_grosseries"
#

DROP TABLE IF EXISTS `shoppinglist_grosseries`;
CREATE TABLE `shoppinglist_grosseries` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `listId` int(11) DEFAULT '0',
  `grosseryId` int(11) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Structure for table "shoppinglist_user"
#

DROP TABLE IF EXISTS `shoppinglist_user`;
CREATE TABLE `shoppinglist_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT '0',
  `listId` int(11) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Structure for table "store"
#

DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `xcoord` varchar(255) DEFAULT NULL,
  `ycoord` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "stores_grosserygroups"
#

DROP TABLE IF EXISTS `stores_grosserygroups`;
CREATE TABLE `stores_grosserygroups` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `store_id` int(11) DEFAULT '0',
  `grosserygroup_id` int(11) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `username` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  `token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Structure for table "user_grossiers"
#

DROP TABLE IF EXISTS `user_grossiers`;
CREATE TABLE `user_grossiers` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT '0',
  `grossery_id` int(11) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "user_stores"
#

DROP TABLE IF EXISTS `user_stores`;
CREATE TABLE `user_stores` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(5) DEFAULT '0',
  `storeid` int(5) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
