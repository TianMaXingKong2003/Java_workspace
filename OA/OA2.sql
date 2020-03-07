-- MySQL dump 10.10
--
-- Host: localhost    Database: OA2
-- ------------------------------------------------------
-- Server version	5.0.18-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `applys`
--

DROP TABLE IF EXISTS `applys`;
CREATE TABLE `applys` (
  `number` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `startDate` date default NULL,
  `endDate` date default NULL,
  `closed` bit(1) default NULL,
  `successed` bit(1) default NULL,
  `status` varchar(100) default NULL,
  `totalGrade` float(8,2) default NULL,
  `classesId` int(11) default NULL,
  `customerId` int(11) default NULL,
  PRIMARY KEY  (`number`),
  KEY `classesId_id_fk` (`classesId`),
  KEY `customerId_id_fk` (`customerId`),
  CONSTRAINT `classesId_id_fk` FOREIGN KEY (`classesId`) REFERENCES `classes` (`id`),
  CONSTRAINT `customerId_id_fk` FOREIGN KEY (`customerId`) REFERENCES `customers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `applys`
--


/*!40000 ALTER TABLE `applys` DISABLE KEYS */;
LOCK TABLES `applys` WRITE;
INSERT INTO `applys` VALUES ('2015021000000012','沙建秋_入学申请','2015-02-10','2015-02-10','','\0','申请审批中',NULL,13,3),('2015021000000015','胖志远_入学申请','2015-02-10',NULL,NULL,NULL,'申请审批通过',NULL,6,5),('2015021000000016','奥巴马_入学申请','2015-02-10',NULL,NULL,NULL,'申请审批通过',NULL,6,13),('2015021000000017','奥特曼_入学申请','2015-02-10',NULL,'','\0','申请已关闭',NULL,5,10),('2015021000000018','传智金庸_入学申请','2015-02-10',NULL,'','\0','申请已关闭',NULL,17,16),('2015031200000021','沙建秋_入学申请','2015-03-12',NULL,NULL,NULL,'申请审批中',NULL,5,3);
UNLOCK TABLES;
/*!40000 ALTER TABLE `applys` ENABLE KEYS */;

--
-- Table structure for table `basetestapply`
--

DROP TABLE IF EXISTS `basetestapply`;
CREATE TABLE `basetestapply` (
  `number` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `upTime` date default NULL,
  `status` varchar(100) default NULL,
  `checkDate` date default NULL,
  `checker` varchar(100) default NULL,
  `grade` float(8,2) default NULL,
  `path` varchar(100) default NULL,
  `filename` varchar(100) default NULL,
  `oldFilename` varchar(100) default NULL,
  `message` varchar(500) default NULL,
  PRIMARY KEY  (`number`),
  CONSTRAINT `number_id_fk2` FOREIGN KEY (`number`) REFERENCES `applys` (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `basetestapply`
--


/*!40000 ALTER TABLE `basetestapply` DISABLE KEYS */;
LOCK TABLES `basetestapply` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `basetestapply` ENABLE KEYS */;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `startDate` date default NULL,
  `endDate` date default NULL,
  `planNumber` int(11) default NULL,
  `number` int(11) default NULL,
  `actualNumber` int(11) default NULL,
  `status` varchar(100) default NULL,
  `classTypeId` int(11) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `classType_id_fk` (`classTypeId`),
  CONSTRAINT `classType_id_fk` FOREIGN KEY (`classTypeId`) REFERENCES `classtypes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `classes`
--


/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
LOCK TABLES `classes` WRITE;
INSERT INTO `classes` VALUES (5,'JavaEE和安卓_1期','2015-03-08','2015-03-06',80,NULL,NULL,'火热报名中',1),(6,'JavaEE和安卓_3期','2015-08-08','2015-09-09',100,NULL,NULL,'火热报名中',1),(7,'JavaEE和安卓_2期','2015-04-08','2015-04-06',90,NULL,NULL,'火热报名中',1),(8,'IOS_55期','2015-02-10','2015-02-03',22222,NULL,NULL,'火热报名中',3),(9,'JavaEE和Hadoop大数据_1期','2015-03-10','2015-03-08',70,NULL,NULL,'火热报名中',2),(10,'dotNet_1期','2015-03-12','2015-03-10',60,NULL,NULL,'火热报名中',4),(11,'IOS_2期','2015-04-08','2015-04-06',100,NULL,NULL,'火热报名中',3),(12,'JavaEE和安卓_4期','2015-05-22','2015-05-20',80,NULL,NULL,'火热报名中',1),(13,'JavaEE和安卓_5期','2015-06-08','2015-06-06',80,NULL,NULL,'火热报名中',1),(14,'IOS_5期','2015-03-10','2015-03-08',200,NULL,NULL,'火热报名中',3),(15,'IOS_1期','2015-03-12','2015-03-10',90,NULL,NULL,'火热报名中',3),(16,'dotNet_2期','2015-04-10','2015-04-08',60,NULL,NULL,'火热报名中',4),(17,'JavaEE和Hadoop大数据_2期','2015-04-10','2015-04-08',70,NULL,NULL,'火热报名中',2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;

--
-- Table structure for table `classtypes`
--

DROP TABLE IF EXISTS `classtypes`;
CREATE TABLE `classtypes` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `classtypes`
--


/*!40000 ALTER TABLE `classtypes` DISABLE KEYS */;
LOCK TABLES `classtypes` WRITE;
INSERT INTO `classtypes` VALUES (1,'JavaEE和安卓','招生很好'),(2,'JavaEE和Hadoop大数据','招生很好'),(3,'IOS','招生很好'),(4,'dotNet','。net');
UNLOCK TABLES;
/*!40000 ALTER TABLE `classtypes` ENABLE KEYS */;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `phoneNumber` varchar(20) NOT NULL,
  `gender` varchar(10) default NULL,
  `qq` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(255) default NULL,
  `status` varchar(100) default NULL,
  `classType` varchar(100) default NULL,
  `infoSource` varchar(100) default NULL,
  `message` varchar(500) default NULL,
  `actived` bit(1) default NULL,
  `activeCode` varchar(100) default NULL,
  `activeDate` date default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `phoneNumber` (`phoneNumber`),
  UNIQUE KEY `qq` (`qq`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customers`
--


/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
LOCK TABLES `customers` WRITE;
INSERT INTO `customers` VALUES (1,'疯子','1245466','男','疯324','5431523','5425','家里蹲','JavaEE和Hadoop大数据','朋友介绍','25425325234',NULL,NULL,NULL),(2,'忍者神龟','123456789','男','120','110','屯里','待业','IOS','百度','..',NULL,NULL,NULL),(3,'沙建秋','123','女','123456789','itheima14@163.com','北京市朝阳区','待业','JavaEE和安卓','百度','没什么可留的','','966ac2c7-aef4-4f8d-8d7b-a0217a29c5c8','2015-03-12'),(4,'123','5465','男','123','123@123','faf','幼儿园','JavaEE和安卓','百度','fadsfasfasdf a fa',NULL,NULL,NULL),(5,'胖志远','12345678','女','6666666','pangzhiyuan@38.com','火星','家里蹲','JavaEE和安卓','老学员','胖纸元',NULL,'e6dee0ce-89af-4c4c-b8c7-5e6c2c1259da',NULL),(6,'皮卡球','213456','女','324567','234567','34567','家里蹲','JavaEE和安卓','百度','435',NULL,NULL,NULL),(7,'金庸','13333333333','男','10086','10086@qq.com','中国香港','在读研究生','JavaEE和安卓','百度','飞雪连天射白鹿,笑书神侠倚碧鸳',NULL,NULL,NULL),(8,'500','521','男','3245324','2345345','控偶师','家里蹲','JavaEE和安卓','百度','500.是傻瓜',NULL,NULL,NULL),(9,'虚空假面','654321','男','123456','123456','北京市','在读研究生','IOS','朋友介绍','牛掰',NULL,NULL,NULL),(10,'奥特曼','13999999999','男','88888888','wzt@itcast.cn','日本东京市','家里蹲','JavaEE和安卓','老学员','录取我吧~~',NULL,NULL,NULL),(11,'远神','158...','男','00','00','沟里..','待业','JavaEE和安卓','百度','...',NULL,NULL,NULL),(12,'aaa','12345678900','男','87654321','sadas@itcast.com','湖北','待业','JavaEE和安卓','百度','????????',NULL,NULL,NULL),(13,'奥巴马','12345','男','12345','12345@qq.com','美国','大五','JavaEE和安卓','百度','',NULL,'9eed62d3-3551-47e6-aef6-2eaa3e9ae563',NULL),(15,'1','111111111','男','11','11','11','家里蹲','dotNet','老学员','1111111',NULL,NULL,NULL),(16,'传智金庸','15858585438','男','77585438','itheimacloud@163.com','北京市海淀区','幼儿园','JavaEE和Hadoop大数据','百度','请叫我带头大哥',NULL,NULL,NULL),(17,'','','男','','','','待业','JavaEE和安卓','百度','',NULL,NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;

--
-- Table structure for table `customerstatus`
--

DROP TABLE IF EXISTS `customerstatus`;
CREATE TABLE `customerstatus` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customerstatus`
--


/*!40000 ALTER TABLE `customerstatus` DISABLE KEYS */;
LOCK TABLES `customerstatus` WRITE;
INSERT INTO `customerstatus` VALUES (1,'待业','没有工作'),(2,'在读研究生','学生'),(3,'大一','大一'),(4,'大二','大二'),(5,'大三','大三'),(7,'幼儿园','园长'),(8,'大四','混吃等死'),(9,'大五','回老家结婚'),(10,'家里蹲','吃饭睡觉打豆豆');
UNLOCK TABLES;
/*!40000 ALTER TABLE `customerstatus` ENABLE KEYS */;

--
-- Table structure for table `functions`
--

DROP TABLE IF EXISTS `functions`;
CREATE TABLE `functions` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `uri` varchar(500) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `functions`
--


/*!40000 ALTER TABLE `functions` DISABLE KEYS */;
LOCK TABLES `functions` WRITE;
INSERT INTO `functions` VALUES (1,'查询申请','/manage/ProcessServlet?op=listApplys'),(2,'信息来源设置','/manage/ConfigServlet?op=listAllInfoSources'),(3,'功能管理','/manage/PrivilegeServlet?op=listFunctions'),(4,'后台管理主页','/manage/index.jsp'),(5,'角色管理','/manage/PrivilegeServlet?op=listRoles'),(6,'用户管理','/manage/PrivilegeServlet?op=listUsers');
UNLOCK TABLES;
/*!40000 ALTER TABLE `functions` ENABLE KEYS */;

--
-- Table structure for table `infosources`
--

DROP TABLE IF EXISTS `infosources`;
CREATE TABLE `infosources` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `infosources`
--


/*!40000 ALTER TABLE `infosources` DISABLE KEYS */;
LOCK TABLES `infosources` WRITE;
INSERT INTO `infosources` VALUES (1,'百度','百度搜索'),(2,'朋友介绍','同学告诉我的'),(3,'老学员','老学员亲友券'),(4,'CSDN','通过CSDN官网'),(5,'传智视频','视频开头广告');
UNLOCK TABLES;
/*!40000 ALTER TABLE `infosources` ENABLE KEYS */;

--
-- Table structure for table `quotaapply`
--

DROP TABLE IF EXISTS `quotaapply`;
CREATE TABLE `quotaapply` (
  `number` varchar(100) NOT NULL,
  `checkDate` date default NULL,
  `checker` varchar(100) default NULL,
  `checkMessage` varchar(500) default NULL,
  PRIMARY KEY  (`number`),
  CONSTRAINT `number_id_fk3` FOREIGN KEY (`number`) REFERENCES `applys` (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `quotaapply`
--


/*!40000 ALTER TABLE `quotaapply` DISABLE KEYS */;
LOCK TABLES `quotaapply` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `quotaapply` ENABLE KEYS */;

--
-- Table structure for table `resumeapply`
--

DROP TABLE IF EXISTS `resumeapply`;
CREATE TABLE `resumeapply` (
  `number` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `upTime` date default NULL,
  `status` varchar(100) default NULL,
  `checkDate` date default NULL,
  `checker` varchar(100) default NULL,
  `grade` float(8,2) default NULL,
  `path` varchar(100) default NULL,
  `filename` varchar(100) default NULL,
  `oldFilename` varchar(100) default NULL,
  `message` varchar(500) default NULL,
  PRIMARY KEY  (`number`),
  CONSTRAINT `number_id_fk1` FOREIGN KEY (`number`) REFERENCES `applys` (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `resumeapply`
--


/*!40000 ALTER TABLE `resumeapply` DISABLE KEYS */;
LOCK TABLES `resumeapply` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `resumeapply` ENABLE KEYS */;

--
-- Table structure for table `role_function`
--

DROP TABLE IF EXISTS `role_function`;
CREATE TABLE `role_function` (
  `r_id` int(11) NOT NULL default '0',
  `f_id` int(11) NOT NULL default '0',
  PRIMARY KEY  (`r_id`,`f_id`),
  KEY `f_id_fk` (`f_id`),
  CONSTRAINT `f_id_fk` FOREIGN KEY (`f_id`) REFERENCES `functions` (`id`),
  CONSTRAINT `r_id_fk2` FOREIGN KEY (`r_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role_function`
--


/*!40000 ALTER TABLE `role_function` DISABLE KEYS */;
LOCK TABLES `role_function` WRITE;
INSERT INTO `role_function` VALUES (1,1),(1,2),(3,2),(1,3),(1,4),(3,4),(1,5),(1,6);
UNLOCK TABLES;
/*!40000 ALTER TABLE `role_function` ENABLE KEYS */;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `description` varchar(100) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `roles`
--


/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
LOCK TABLES `roles` WRITE;
INSERT INTO `roles` VALUES (1,'超级管理员','什么都能干'),(3,'系统配置员','只能操作系统配置的内容');
UNLOCK TABLES;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `u_id` int(11) NOT NULL default '0',
  `r_id` int(11) NOT NULL default '0',
  PRIMARY KEY  (`u_id`,`r_id`),
  KEY `r_id_fk1` (`r_id`),
  CONSTRAINT `r_id_fk1` FOREIGN KEY (`r_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `u_id_fk` FOREIGN KEY (`u_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_role`
--


/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
LOCK TABLES `user_role` WRITE;
INSERT INTO `user_role` VALUES (1,1),(1,3),(2,3);
UNLOCK TABLES;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nickname` varchar(100) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--


/*!40000 ALTER TABLE `users` DISABLE KEYS */;
LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES (1,'admin','123','超级管理员'),(2,'sjq','123','沙建秋');
UNLOCK TABLES;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

