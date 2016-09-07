/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.1.37-community : Database - fund
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`fund` /*!40100 DEFAULT CHARACTER SET gb2312 */;

USE `fund`;

/*Table structure for table `accounts` */

DROP TABLE IF EXISTS `accounts`;

CREATE TABLE `accounts` (
  `A_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CLIENT_ID` int(11) DEFAULT NULL,
  `A_CARD` varchar(255) DEFAULT NULL,
  `A_PWD` varchar(255) DEFAULT NULL,
  `A_MARGIN` int(255) DEFAULT NULL,
  `A_STATE` varchar(255) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL,
  `CREATE_TIME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`A_ID`),
  KEY `FK_Reference_9` (`CLIENT_ID`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`CLIENT_ID`) REFERENCES `client` (`CLIENT_ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

/*Data for the table `accounts` */

insert  into `accounts`(`A_ID`,`CLIENT_ID`,`A_CARD`,`A_PWD`,`A_MARGIN`,`A_STATE`,`REMARK`,`CREATE_TIME`) values (45,12,'48946549','444444',444444444,'1','无','2015-09-18'),(46,22,'45646316','454574',487987464,'1','无','2015-09-18'),(47,18,'64654321','544654',416545641,'1','无','2015-09-18'),(48,18,'45413214','132123',131324165,'1','sb','2015-09-18'),(49,22,'98941564','574787',465489,'1','无','2015-09-18'),(50,15,'54579879','684764',6846546,'1','无','2015-09-18'),(51,23,'789764','456465',4654654,'1','无','2015-09-18'),(52,21,'46879886','784687',489749874,'1','无','2015-09-18'),(53,19,'46546546','465456',654654,'1','无','2015-09-18'),(54,12,'4846546','456465',464,'1','无','2015-09-18');

/*Table structure for table `bank_card` */

DROP TABLE IF EXISTS `bank_card`;

CREATE TABLE `bank_card` (
  `ACC_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ACC_NO` varchar(20) NOT NULL,
  `ACC_PWD` varchar(50) NOT NULL,
  `BANK_TYPE` int(25) NOT NULL,
  `CLIENT_ID` varchar(50) NOT NULL,
  `CREATE_TIME` varchar(50) NOT NULL,
  `BLANCE` double(10,0) DEFAULT NULL,
  `ACC_STATE` int(5) NOT NULL,
  PRIMARY KEY (`ACC_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `bank_card` */

insert  into `bank_card`(`ACC_ID`,`ACC_NO`,`ACC_PWD`,`BANK_TYPE`,`CLIENT_ID`,`CREATE_TIME`,`BLANCE`,`ACC_STATE`) values (14,'41561465564','11111111111',1,'12','2015-09-18',455464,1),(15,'16746546574','11111111111',1,'15','2015-09-18',123456,1),(16,'41564146541','11111111111',2,'12','2015-09-18',1111111111,1),(17,'45641146545','11111111111',2,'15','2015-09-18',1234151541,1),(18,'15641564651','11111111111',1,'16','2015-09-18',4564564132,1),(19,'15645416546','11111111111',1,'17','2015-09-18',1564561567,1),(20,'48414654654','44444444444',3,'18','2015-09-18',4556465444,1),(21,'48979845445','44444444444',2,'19','2015-09-18',5454564156,1),(22,'54564564657','44444444444',2,'21','2015-09-18',9856465465,1),(23,'15641544132','44444444444',2,'22','2015-09-18',5664654654,1),(24,'46474654694','44444444444',3,'23','2015-09-18',5856544641,2);

/*Table structure for table `client` */

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `CLIENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CLIENT_NAME` varchar(32) DEFAULT NULL,
  `SEX` varchar(32) DEFAULT NULL,
  `PHONE` varchar(32) DEFAULT NULL,
  `CLIENT_CARD` varchar(32) DEFAULT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `EMAIL` varchar(32) DEFAULT NULL,
  `HOBBY` varchar(32) DEFAULT NULL,
  `REMARK` varchar(200) DEFAULT NULL,
  `CREATE_TIME` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`CLIENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `client` */

insert  into `client`(`CLIENT_ID`,`CLIENT_NAME`,`SEX`,`PHONE`,`CLIENT_CARD`,`ADDRESS`,`EMAIL`,`HOBBY`,`REMARK`,`CREATE_TIME`) values (12,'杨强可','1','18234069021','184456465498154146','福建省','979892861@qq.com','游泳、打球','这是一个美好的时代','2015-09-18 13:21:40'),(13,'范兴贵','1','18734898235','142202199006061910','北京市海淀区马连洼北路','1287346035@qq.com','看书','这是客户信息添加','2015-09-18 13:23:37'),(15,'张月明','1','12555661446','125486585564897497','阿富汗','154564154@qq.com','美女与野兽','这是一个美好的时代……','2015-09-18 13:27:40'),(16,'康立平','1','15616456419','122484454964546469','巴基斯坦','154145622@aa.com','韩国欧巴','这是一个美好的时代','2015-09-18 13:30:10'),(17,'褚瑞丰','1','15244798454','124554846549846549','梵蒂冈','484649874@qq.com','涮蛋蛋','这是一个美好的时代','2015-09-18 13:31:48'),(18,'王洋洋','1','13655659544','142165498465494947','老挝','5464984146@qq.com','卡哇伊','这是一个美好的时代','2015-09-18 13:34:00'),(19,'郭美美','2','15244846549','142264654984516465','泰国','165465469@qq.com','欧巴','这是一个美好的时代','2015-09-18 13:36:07'),(21,'范冰冰','2','18254841654','142894765498765464','白俄罗斯','8744644646@qq.com','欺负李晨','这是一个美好的时代','2015-09-18 13:37:36'),(22,'高圆圆','2','14487654645','126564654564657641','中国台湾','48976454@qq.com','赵又廷','这是一个美好的时代','2015-09-18 13:40:10'),(23,'赵丽颖','2','15245874564','142974654941984645','朝鲜','458956452@qq.com','金正恩','这是一个美好的时代','2015-09-18 13:42:42');

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `DEPT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEPT_NAME` varchar(64) DEFAULT NULL,
  `REMARK` varchar(512) DEFAULT NULL,
  `CREATE_TIME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`DEPT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `dept` */

insert  into `dept`(`DEPT_ID`,`DEPT_NAME`,`REMARK`,`CREATE_TIME`) values (28,'人事部','123132','2015-09-01 19:17:46'),(29,'技术部','技术部','2015-06-01 19:18:00'),(30,'财务部','财务部','2015-09-02 19:18:22'),(31,'营销部','营销部','2015-09-03 19:18:35'),(32,'信息部','信息部','2010-09-01 14:33:24');

/*Table structure for table `dictionary` */

DROP TABLE IF EXISTS `dictionary`;

CREATE TABLE `dictionary` (
  `DICTIONARY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TYPE_CODE` varchar(64) DEFAULT NULL,
  `DICTIONARY_KEY` int(11) DEFAULT NULL,
  `DICTIONARY_VALUE` varchar(64) DEFAULT NULL,
  `PARENT_ID` int(11) DEFAULT '0',
  `SORT` int(11) DEFAULT '0',
  `REMARK` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`DICTIONARY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8 COMMENT='描述业务系统中的一些公用代码；\n如：性别，证件类型，民族等。\n';

/*Data for the table `dictionary` */

insert  into `dictionary`(`DICTIONARY_ID`,`TYPE_CODE`,`DICTIONARY_KEY`,`DICTIONARY_VALUE`,`PARENT_ID`,`SORT`,`REMARK`) values (1,'SEX',1,'男',0,0,NULL),(2,'SEX',2,'女',0,0,NULL),(6,'CITY',1,'海淀区',1,0,'海淀区'),(7,'CITY',2,'朝阳区',1,0,'朝阳区'),(8,'CITY',3,'东城区',1,0,'东城区'),(14,'EDUCATION',1,'小学',0,0,''),(15,'EDUCATION',2,'中学',0,0,''),(16,'EDUCATION',3,'高中',0,0,''),(17,'EDUCATION',4,'大学专科',0,0,''),(18,'EDUCATION',5,'大学本科',0,0,''),(19,'EDUCATION',6,'硕士/研究生',0,0,''),(20,'EDUCATION',7,'博士',0,0,''),(21,'EDUCATION',8,'博士后',0,0,''),(22,'BANK_TYPE',1,'工商银行',0,0,''),(23,'BANK_TYPE',2,'建设银行',0,0,''),(24,'BANK_TYPE',3,'中国银行',0,0,''),(25,'BANK_TYPE',4,'农业银行',0,0,''),(26,'PROVINCE',1,'北京',0,0,''),(27,'PROVINCE',2,'黑龙江',0,0,''),(28,'PROVINCE',3,'河北',0,0,''),(29,'CITY',1,'哈尔滨',2,0,''),(30,'CITY',2,'大庆',2,0,''),(31,'CITY',3,'鸡西',2,0,''),(50,'CITY',1,'石家庄市',3,0,NULL),(51,'CITY',2,'邢台市',3,0,NULL),(52,'CITY',3,'唐山市',3,0,NULL),(53,'F_STATUS',1,'可交易',0,0,NULL),(54,'F_STATUS',2,'未上市',0,0,NULL),(55,'A_STATE',1,'可用',0,0,NULL),(56,'A_STATE',2,'冻结',0,0,NULL),(57,'T_R_TYPE',1,'基金购买',0,0,NULL),(58,'T_R_TYPE',2,'赎回基金',0,0,NULL),(59,'ACC_STATE',1,'正常',0,0,NULL),(60,'ACC_STATE',2,'挂失',0,0,NULL),(61,'ACC_STATE',3,'销户',0,0,NULL);

/*Table structure for table `fund_holding` */

DROP TABLE IF EXISTS `fund_holding`;

CREATE TABLE `fund_holding` (
  `HID` int(11) NOT NULL AUTO_INCREMENT,
  `F_ID` int(11) DEFAULT NULL,
  `A_ID` int(11) DEFAULT NULL,
  `AMOUNT` varchar(32) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL,
  `CREATE_TIME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`HID`),
  KEY `FK_Reference_13` (`F_ID`),
  KEY `FK_Reference_14` (`A_ID`),
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`F_ID`) REFERENCES `fund_info` (`F_ID`) ON DELETE CASCADE,
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`A_ID`) REFERENCES `accounts` (`A_ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `fund_holding` */

insert  into `fund_holding`(`HID`,`F_ID`,`A_ID`,`AMOUNT`,`REMARK`,`CREATE_TIME`) values (7,20,45,'45','无','2015-09-05'),(8,21,46,'554','无','2015-09-11'),(9,20,45,'652','无','2015-09-17'),(10,21,47,'454','这是一笔大交易','2015-09-18'),(11,20,46,'854','这 你交易也很重要','2015-09-18'),(12,20,46,'66','第三笔交易','2015-09-09'),(13,20,45,'121','无','2015-09-18');

/*Table structure for table `fund_info` */

DROP TABLE IF EXISTS `fund_info`;

CREATE TABLE `fund_info` (
  `F_ID` int(11) NOT NULL AUTO_INCREMENT,
  `F_ISSURE_ID` int(11) DEFAULT NULL,
  `F_NAME` varchar(255) DEFAULT NULL,
  `F_PRICE` varchar(255) DEFAULT NULL,
  `F_DESCRIPTION` varchar(255) DEFAULT NULL,
  `F_STATUS` varchar(255) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`F_ID`),
  KEY `FK_Reference_3` (`F_ISSURE_ID`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`F_ISSURE_ID`) REFERENCES `fund_issue` (`F_ISSURE_ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `fund_info` */

insert  into `fund_info`(`F_ID`,`F_ISSURE_ID`,`F_NAME`,`F_PRICE`,`F_DESCRIPTION`,`F_STATUS`,`REMARK`,`CREATE_TIME`) values (15,22,'华夏基金','1000.10','华夏公司的基金','1','无','2015-09-17 16:50:25'),(20,23,'汇成基金','1500.13','汇成集团旗下的基金','2','无','2015-09-18 13:47:56'),(21,24,'华城基金','2000.15','华城公司的基金','1','无','2015-09-18 13:49:27'),(23,25,'成仁基金','1800.10','成仁旗下基金','1','无','2015-09-18 13:50:53'),(24,26,'神奇基金','2100.10','神奇公司基金','2','无','2015-09-18 13:52:40'),(25,27,'人才基金','1500.10','人才教育基金','1','无','2015-09-18 13:53:40'),(26,28,'华侨基金','6000.10','华侨股份公司基金','1','无','2015-09-18 13:55:00'),(27,29,'腾讯基金','6000.80','腾讯公司基金','2','即将上市','2015-09-18 13:55:37'),(28,30,'百度基金','6000.15','百度公司基金','1','无','2015-09-18 13:56:10'),(29,31,'淘宝基金','8000.10','淘宝公司基金','2','即将上市','2015-09-18 13:56:51');

/*Table structure for table `fund_issue` */

DROP TABLE IF EXISTS `fund_issue`;

CREATE TABLE `fund_issue` (
  `F_ISSURE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `F_ISSURE_Name` varchar(255) DEFAULT NULL,
  `PHONE` varchar(255) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`F_ISSURE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `fund_issue` */

insert  into `fund_issue`(`F_ISSURE_ID`,`F_ISSURE_Name`,`PHONE`,`REMARK`,`CREATE_TIME`) values (22,'华夏成长','18811300059','无','2015-09-17 16:41:52'),(23,'汇成商贸','18811300076','汇成商贸','2015-09-17 16:42:51'),(24,'华城贸易','13699277718','华城贸易','2015-09-17 16:43:28'),(25,'成仁股份','13699299006','成仁股份','2015-09-17 16:44:10'),(26,'神奇科技','13699299529','神奇科技','2015-09-17 16:45:00'),(27,'人才教育','18810551099','人才教育','2015-09-17 16:45:38'),(28,'华侨商务','18810525288','华侨商务','2015-09-17 16:46:22'),(29,'腾讯公司','18810578088','腾讯公司','2015-09-17 16:47:10'),(30,'百度公司','18810628088','百度公司','2015-09-17 16:47:46'),(31,'淘宝公司','13911005253','淘宝公司','2015-09-17 16:48:23');

/*Table structure for table `position` */

DROP TABLE IF EXISTS `position`;

CREATE TABLE `position` (
  `POSITION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `POSITION_NAME` varchar(64) DEFAULT NULL,
  `WAGE` int(11) DEFAULT NULL,
  `SUBSIDY_WAGE` int(11) DEFAULT NULL,
  `REMARK` varchar(512) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`POSITION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `position` */

insert  into `position`(`POSITION_ID`,`POSITION_NAME`,`WAGE`,`SUBSIDY_WAGE`,`REMARK`,`CREATE_TIME`) values (1,'管理员',1000,1000,'1000','2015-03-01 12:02:42'),(2,'预约经理',1000,1000,NULL,'2015-03-01 12:02:42'),(3,'咨询经理',1000,1000,NULL,'2015-03-01 12:02:42'),(9,'正式经理',2000,2000,'2000',NULL);

/*Table structure for table `shouru` */

DROP TABLE IF EXISTS `shouru`;

CREATE TABLE `shouru` (
  `id` varchar(64) NOT NULL,
  `shouRuJinEr` varchar(64) DEFAULT NULL,
  `riQi` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shouru` */

insert  into `shouru`(`id`,`shouRuJinEr`,`riQi`) values ('1','50000','2013-01-01'),('10','130000','2013-10-01'),('11','140000','2013-11-01'),('12','150000','2013-12-01'),('2','60000','2013-02-01'),('3','70000','2013-03-01'),('4','80000','2013-04-01'),('5','90000','2013-05-01'),('6','100000','2013-06-01'),('7','170000','2013-07-01'),('8','110000','2013-08-01'),('9','120000','2013-09-01');

/*Table structure for table `staff_info` */

DROP TABLE IF EXISTS `staff_info`;

CREATE TABLE `staff_info` (
  `Staff_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Staff_NAME` varchar(64) DEFAULT NULL,
  `TestFile` varchar(100) DEFAULT NULL,
  `DEPT_ID` int(11) DEFAULT NULL,
  `SEX` int(11) DEFAULT NULL,
  `TEL` varchar(64) DEFAULT NULL,
  `EDUCATION` int(11) DEFAULT NULL,
  `SCHOOL` varchar(64) DEFAULT NULL,
  `GRADUATION_DATE` date DEFAULT NULL,
  `CARD_NO` varchar(18) DEFAULT NULL,
  `EMAIL` varchar(128) DEFAULT NULL,
  `BANK_TYPE` int(11) DEFAULT NULL,
  `BANK_NO` varchar(32) DEFAULT NULL,
  `PROVINCE` int(11) DEFAULT NULL,
  `CITY` int(11) DEFAULT NULL,
  `REMARK` varchar(512) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`Staff_ID`),
  KEY `DEPT_ID` (`DEPT_ID`),
  CONSTRAINT `staff_info_ibfk_1` FOREIGN KEY (`DEPT_ID`) REFERENCES `dept` (`DEPT_ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `staff_info` */

insert  into `staff_info`(`Staff_ID`,`Staff_NAME`,`TestFile`,`DEPT_ID`,`SEX`,`TEL`,`EDUCATION`,`SCHOOL`,`GRADUATION_DATE`,`CARD_NO`,`EMAIL`,`BANK_TYPE`,`BANK_NO`,`PROVINCE`,`CITY`,`REMARK`,`CREATE_TIME`) values (2,'刘占波','20150917081901406.gif',28,1,'18745678912',6,'北京大学','2015-08-31','140108199306073615','123@qq.com',3,'60123547896',2,2,'张三','2015-09-15 19:21:06'),(3,'廖惠英','20150917081831765.gif',30,2,'18734892314',6,'11','2013-09-10','140108199306073615','11@qq.com',2,'111',2,1,'11','2015-09-16 10:07:26'),(4,'旋卫忠','20150917081948250.gif',28,1,'18734898235',5,'1','2015-09-01','140108199306073615','111@qq',1,'1213231231',1,1,'1','2015-09-16 10:08:24'),(5,'康丽萍',NULL,31,2,'18734567894',3,'清华大学','2010-09-01','145236789963354663','11@qq.com',2,'15548878787546',2,2,'无','2015-09-16 17:06:26'),(12,'陈建','20150918023619656.sql',28,1,'15234476798',1,'哥伦比亚大学','2015-09-18','544444564646546549','465456445@qq.com',2,'5484894646575465456',1,1,'','2015-09-18 14:37:30'),(13,'黄朗毅','20150918023757203.sql',29,1,'15411564146',2,'哈弗大学','2015-09-18','152489465498746498','75649874@qq.com',1,'7456749841346844986',1,1,'','2015-09-18 14:39:15'),(14,'李晓红','20150918023939734.sql',30,2,'15426546444',5,'北京大学','2015-09-18','142244489741449874','894564744@qq.com',2,'4845498746514464198',2,3,'','2015-09-18 14:40:30'),(15,'李元','20150918024053312.sql',31,1,'18648454984',2,'清华大学','2015-09-18','145244464744149666','654446574@qq.com',3,'5447415674654149843',2,3,'','2015-09-18 14:41:38'),(16,'李思思','20150918024156312.sql',32,1,'18644845644',6,'复旦大学','2014-09-30','142321545614749544','564321697@qq.com',2,'4654897474449849645',1,1,'','2015-09-18 14:42:57'),(17,'何红','20150918024352671.sql',32,1,'15254841464',1,'山东大学','2015-09-18','142555643246746167','7845649874@qq.com',2,'1487489541564984654',2,1,'','2015-09-18 14:45:00');

/*Table structure for table `transaction_info` */

DROP TABLE IF EXISTS `transaction_info`;

CREATE TABLE `transaction_info` (
  `R_ID` int(11) NOT NULL AUTO_INCREMENT,
  `A_ID` int(11) DEFAULT NULL,
  `R_DATE` date DEFAULT NULL,
  `R_TYPE` int(11) DEFAULT NULL,
  `R_ORDER_ID` int(11) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL,
  `CREATE_TIME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`R_ID`),
  KEY `FK_Reference_10` (`A_ID`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`A_ID`) REFERENCES `accounts` (`A_ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `transaction_info` */

insert  into `transaction_info`(`R_ID`,`A_ID`,`R_DATE`,`R_TYPE`,`R_ORDER_ID`,`REMARK`,`CREATE_TIME`) values (1,45,'2015-09-17',1,1,'无','2015-09-18 14:50:05'),(2,46,'2015-09-03',2,2,'无','2015-09-04 14:50:24'),(3,46,'2015-09-18',1,1,'无','2015-09-09 14:52:23');

/*Table structure for table `transaction_record` */

DROP TABLE IF EXISTS `transaction_record`;

CREATE TABLE `transaction_record` (
  `T_R_ID` int(11) NOT NULL AUTO_INCREMENT,
  `A_ID` int(11) DEFAULT NULL,
  `F_ID` int(11) DEFAULT NULL,
  `T_R_TYPE` int(11) DEFAULT NULL,
  `T_R_AMOUNT` int(32) DEFAULT NULL,
  `T_R_PRICE` int(32) DEFAULT NULL,
  `T_R_TIME` varchar(32) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`T_R_ID`),
  KEY `FK_Reference_11` (`A_ID`),
  KEY `FK_Reference_12` (`F_ID`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`A_ID`) REFERENCES `accounts` (`A_ID`) ON DELETE CASCADE,
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`F_ID`) REFERENCES `fund_info` (`F_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `transaction_record` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEPT_ID` int(11) DEFAULT NULL,
  `POSITION_ID` int(11) DEFAULT NULL,
  `LOGIN_NAME` varchar(64) DEFAULT NULL,
  `NAME` varchar(32) DEFAULT NULL,
  `PASSWORD` varchar(64) DEFAULT NULL,
  `SALT` varchar(64) DEFAULT NULL,
  `ROLES` varchar(256) DEFAULT NULL,
  `REGISTER_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `FK_Reference_7` (`DEPT_ID`),
  KEY `FK_Reference_8` (`POSITION_ID`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`DEPT_ID`) REFERENCES `dept` (`DEPT_ID`) ON DELETE CASCADE,
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`POSITION_ID`) REFERENCES `position` (`POSITION_ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`ID`,`DEPT_ID`,`POSITION_ID`,`LOGIN_NAME`,`NAME`,`PASSWORD`,`SALT`,`ROLES`,`REGISTER_DATE`) values (1,2,1,'admin','admin','691b14d79bf0fa2215f155235df5e670b64394cc','7efbd59d9741d34f','admin','2015-08-26 12:12:37'),(2,1,2,'admin1','预约经理','691b14d79bf0fa2215f155235df5e670b64394cc','7efbd59d9741d34f','admin','2015-08-26 21:22:48'),(3,1,3,'admin2','咨询经理','691b14d79bf0fa2215f155235df5e670b64394cc','7efbd59d9741d34f','admin','2015-08-26 21:22:43'),(4,1,3,'admin3','咨询A','691b14d79bf0fa2215f155235df5e670b64394cc','7efbd59d9741d34f','admin','2015-08-26 21:22:43'),(9,31,NULL,'33333333333','33','691b14d79bf0fa2215f155235df5e670b64394cc',NULL,'admin','2015-09-16 19:40:35'),(10,NULL,NULL,'11111111111','11','11111111111',NULL,NULL,'2015-09-12 20:29:45'),(11,NULL,NULL,'33333333333','33','33333333333',NULL,NULL,'2015-09-12 20:44:02'),(12,NULL,NULL,'15212345678','张三','15212345678',NULL,NULL,'2015-09-13 13:47:10'),(13,NULL,NULL,'11111111111','李四','11111111111',NULL,NULL,'2015-09-13 13:53:52'),(14,NULL,NULL,'11111111111','11','11111111111',NULL,NULL,'2015-09-13 13:55:22'),(15,NULL,NULL,'222222222222','22','222222222222',NULL,NULL,'2015-09-13 14:09:37'),(16,NULL,NULL,'33333333333','33','33333333333',NULL,NULL,'2015-09-13 15:15:27'),(17,NULL,NULL,'11111111111','张三','11111111111',NULL,NULL,'2015-09-15 12:44:44'),(18,NULL,NULL,'18734898235','张三','18734898235',NULL,NULL,'2015-09-15 19:21:06'),(19,NULL,NULL,'18734892314','李四','18734892314',NULL,NULL,'2015-09-16 10:07:26'),(20,NULL,NULL,'11111111111','1','11111111111',NULL,NULL,'2015-09-16 10:08:24'),(21,NULL,NULL,'18734567894','康丽萍','18734567894',NULL,NULL,'2015-09-16 17:06:26'),(22,NULL,NULL,'88888888888','88','88888888888',NULL,NULL,'2015-09-16 21:56:11'),(23,NULL,NULL,'18734898235','111111111','18734898235',NULL,NULL,'2015-09-17 17:14:29'),(24,NULL,NULL,'15234476798','赵六','15234476798',NULL,NULL,'2015-09-18 14:37:30'),(25,NULL,NULL,'15411564146','小明','15411564146',NULL,NULL,'2015-09-18 14:39:15'),(26,NULL,NULL,'15426546444','小红','15426546444',NULL,NULL,'2015-09-18 14:40:30'),(27,NULL,NULL,'18648454984','李元','18648454984',NULL,NULL,'2015-09-18 14:41:38'),(28,NULL,NULL,'18644845644','李思思','18644845644',NULL,NULL,'2015-09-18 14:42:57'),(29,NULL,NULL,'15254841464','何红','15254841464',NULL,NULL,'2015-09-18 14:45:00');

/*Table structure for table `yusuan` */

DROP TABLE IF EXISTS `yusuan`;

CREATE TABLE `yusuan` (
  `id` varchar(64) NOT NULL,
  `yuSuanJinEr` varchar(64) DEFAULT NULL,
  `riQi` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `yusuan` */

insert  into `yusuan`(`id`,`yuSuanJinEr`,`riQi`) values ('1','2000','2013-01-01'),('10','11000','2013-10-01'),('11','12000','2013-11-01'),('12','13000','2013-12-01'),('2','3000','2013-02-01'),('3','4000','2013-03-01'),('4','5000','2013-04-01'),('5','6000','2013-05-01'),('6','7000','2013-06-01'),('7','8000','2013-07-01'),('8','9000','2013-08-01'),('9','10000','2013-09-01');

/*Table structure for table `zhichu` */

DROP TABLE IF EXISTS `zhichu`;

CREATE TABLE `zhichu` (
  `id` varchar(64) NOT NULL,
  `zhiChuJinEr` varchar(64) DEFAULT NULL,
  `riQi` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `zhichu` */

insert  into `zhichu`(`id`,`zhiChuJinEr`,`riQi`) values ('1','3000','2013-01-01'),('10','2000','2013-02-01'),('11','5000','2013-03-01'),('12','1000','2013-04-01'),('2','7000','2013-05-01'),('3','2000','2013-06-01'),('4','6000','2013-07-01'),('5','2400','2013-08-01'),('6','10000','2013-09-01'),('7','9000','2013-10-01'),('8','12000','2013-11-01'),('9','15000','2013-12-01');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
