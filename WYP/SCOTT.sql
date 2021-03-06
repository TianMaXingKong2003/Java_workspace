/*
 Navicat Premium Data Transfer

 Source Server         : ORACLE
 Source Server Type    : Oracle
 Source Server Version : 110200
 Source Host           : localhost:1521
 Source Schema         : SCOTT

 Target Server Type    : Oracle
 Target Server Version : 110200
 File Encoding         : 65001

 Date: 31/05/2019 13:29:59
*/


-- ----------------------------
-- Table structure for BLACKRECORD
-- ----------------------------
DROP TABLE "SCOTT"."BLACKRECORD";
CREATE TABLE "SCOTT"."BLACKRECORD" (
  "ID" NUMBER NOT NULL ,
  "SELFNAME" VARCHAR2(20 BYTE) NOT NULL ,
  "BLACKNAME" VARCHAR2(20 BYTE) NOT NULL 
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for BONUS
-- ----------------------------
DROP TABLE "SCOTT"."BONUS";
CREATE TABLE "SCOTT"."BONUS" (
  "ENAME" VARCHAR2(10 BYTE) ,
  "JOB" VARCHAR2(9 BYTE) ,
  "SAL" NUMBER ,
  "COMM" NUMBER 
)
TABLESPACE "USERS"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for COMPANY
-- ----------------------------
DROP TABLE "SCOTT"."COMPANY";
CREATE TABLE "SCOTT"."COMPANY" (
  "ID" NUMBER NOT NULL ,
  "USERNAME" VARCHAR2(20 BYTE) ,
  "PASSWORD" VARCHAR2(20 BYTE) ,
  "NAME" VARCHAR2(200 BYTE) ,
  "LOCATION" VARCHAR2(200 BYTE) ,
  "PHONE" VARCHAR2(20 BYTE) ,
  "EMAIL" VARCHAR2(20 BYTE) ,
  "TRADE" VARCHAR2(20 BYTE) ,
  "TIP" VARCHAR2(500 BYTE) ,
  "SALARY" VARCHAR2(20 BYTE) ,
  "PUBTIME" DATE 
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of COMPANY
-- ----------------------------
INSERT INTO "SCOTT"."COMPANY" VALUES ('1', 'sam2', '123456', '国信清软科技有限责任公司', '山西太原', '1212121111', '343242@qq.com', '平面设计师', '国信清软科技有限公司注册在北京中关村高科技园区，始创于2005年3月，已通过软件企业认证，是一家集实训、咨询、开发、服务于一体的高新技术产业公司。2008年被纳入“653工程”。国信清软科技有限公司2009年6月19日与中华人民共和国软件与集成电路促成中心达成战略合作伙伴关系。并承担中国JAVA软件工程师标准的制定，成为中国唯一的Java软件工程师标准制定企业。', '工资面议', TO_DATE('2019-05-29 19:39:08', 'SYYYY-MM-DD HH24:MI:SS'));
INSERT INTO "SCOTT"."COMPANY" VALUES ('2', 'sam1', '123456', '企业金融服务山西中心', '山西太原', '8974562', '2132131', '平面设计师', '人人行科技，依靠九鼎的雄厚实力和强大影响力，集结互联网、金融、支付、法律等领域的专业精英团队，着力为投资者打造个性化的融资及投资需求平台，开创创新型个人金融服务平台的先河。 ', '7000-8000', TO_DATE('2019-05-29 19:39:12', 'SYYYY-MM-DD HH24:MI:SS'));
INSERT INTO "SCOTT"."COMPANY" VALUES ('139', 'sam4', '123456', '瀚信企业管理咨询(上海)有限公司', '上海市静安区北京西路968号嘉地中心808室', '4049785', '66666@qq.com', '软件工程师', 'PKF，全称Pannell Kerr Forster，从1869年只有4间成员所（澳洲、加拿大、英国、美国）发展到如今在全球125个国家拥有超过440间成员所，21,400名拥有专业经验的合伙人和员工。2011年，PKF已跻身全球前10大知名会计师事务所之列，同时在咨询业也是名列前茅，当年PKF其全球营业额超过20亿美元。 ', '4000-5000', TO_DATE('2019-05-17 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'));
INSERT INTO "SCOTT"."COMPANY" VALUES ('140', 'sam5', '123456', ' 南京壹进制信息技术股份有限公司', '南京市秦淮区光华路1号（白下高新园区）斯坦德物联网大厦南楼8层', '3723561', 'yijinzhi@163c.com', '软件工程师', '南京壹进制信息技术股份有限公司成立于2008年12月23日，注册资金2650万元，总部南京，在全国设立了20多个营销和服务分支机构。公司自成立以来秉承自主创新、自有品牌的经营理念，凝聚了众多高端技术人才，拥有多项发明专利和独立知识产权，是江苏省双软企业，产品通过多项国家认证。', '5000-6000', TO_DATE('2019-05-29 21:44:03', 'SYYYY-MM-DD HH24:MI:SS'));
INSERT INTO "SCOTT"."COMPANY" VALUES ('141', 'sam6', '123456', ' 广州水禾田软件科技有限公司 ', '广州市白云区嘉禾望岗粤旺大厦B栋8307 ', '4038521', '4038521@qq.com', '客户经理', '广州水禾田软件科技有限公司成立于2010年，6年来我们一直以专业创造价值，用概念铸就品牌为目的。
公司团队日趋成熟，拥有资深的电子商务应用策划师，一流的网页设计师，经验丰富的程序员。
先后为政府、教育、医卫、部队、金融、交通、地铁、能源化工、房地产等行业用户以及外资、合资企业提供专业网站建设服务。', '5000-6000', TO_DATE('2019-05-29 21:44:07', 'SYYYY-MM-DD HH24:MI:SS'));
INSERT INTO "SCOTT"."COMPANY" VALUES ('138', 'sam3', '123456', '华夏时代广告传媒有限公司', '北京市海淀区', '6093352', '6093352@qq.com', '网站策划', '华夏时代·传媒成立于2005年，致力电视栏目制作、媒体代理发布、广告策划、创意制作、大型活动执行，是以媒体经营为依托、其它媒体服务并举的全方位媒体广告公司。

', '6000-7000', TO_DATE('2019-05-29 21:44:10', 'SYYYY-MM-DD HH24:MI:SS'));
INSERT INTO "SCOTT"."COMPANY" VALUES ('322', 'huawei', '123456', '华为科技有限公司', '中国广东省深圳市龙岗区坂田华为基地', '1234567891111', 'huawei@qq.com', '软件工程师', '发展前景好', '6000-7000', TO_DATE('2019-05-27 21:39:57', 'SYYYY-MM-DD HH24:MI:SS'));

-- ----------------------------
-- Table structure for DEPT
-- ----------------------------
DROP TABLE "SCOTT"."DEPT";
CREATE TABLE "SCOTT"."DEPT" (
  "DEPTNO" NUMBER(2) NOT NULL ,
  "DNAME" VARCHAR2(14 BYTE) ,
  "LOC" VARCHAR2(13 BYTE) 
)
TABLESPACE "USERS"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of DEPT
-- ----------------------------
INSERT INTO "SCOTT"."DEPT" VALUES ('10', 'ACCOUNTING', 'NEW YORK');
INSERT INTO "SCOTT"."DEPT" VALUES ('20', 'RESEARCH', 'DALLAS');
INSERT INTO "SCOTT"."DEPT" VALUES ('30', 'SALES', 'CHICAGO');
INSERT INTO "SCOTT"."DEPT" VALUES ('40', 'OPERATIONS', 'BOSTON');

-- ----------------------------
-- Table structure for EMP
-- ----------------------------
DROP TABLE "SCOTT"."EMP";
CREATE TABLE "SCOTT"."EMP" (
  "EMPNO" NUMBER(4) NOT NULL ,
  "ENAME" VARCHAR2(10 BYTE) ,
  "JOB" VARCHAR2(9 BYTE) ,
  "MGR" NUMBER(4) ,
  "HIREDATE" DATE ,
  "SAL" NUMBER(7,2) ,
  "COMM" NUMBER(7,2) ,
  "DEPTNO" NUMBER(2) 
)
TABLESPACE "USERS"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of EMP
-- ----------------------------
INSERT INTO "SCOTT"."EMP" VALUES ('7369', 'SMITH', 'CLERK', '7902', TO_DATE('1980-12-17 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '800', NULL, '20');
INSERT INTO "SCOTT"."EMP" VALUES ('7499', 'ALLEN', 'SALESMAN', '7698', TO_DATE('1981-02-20 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '1600', '300', '30');
INSERT INTO "SCOTT"."EMP" VALUES ('7521', 'WARD', 'SALESMAN', '7698', TO_DATE('1981-02-22 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '1250', '500', '30');
INSERT INTO "SCOTT"."EMP" VALUES ('7566', 'JONES', 'MANAGER', '7839', TO_DATE('1981-04-02 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '2975', NULL, '20');
INSERT INTO "SCOTT"."EMP" VALUES ('7654', 'MARTIN', 'SALESMAN', '7698', TO_DATE('1981-09-28 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '1250', '1400', '30');
INSERT INTO "SCOTT"."EMP" VALUES ('7698', 'BLAKE', 'MANAGER', '7839', TO_DATE('1981-05-01 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '2850', NULL, '30');
INSERT INTO "SCOTT"."EMP" VALUES ('7782', 'CLARK', 'MANAGER', '7839', TO_DATE('1981-06-09 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '2450', NULL, '10');
INSERT INTO "SCOTT"."EMP" VALUES ('7788', 'SCOTT', 'ANALYST', '7566', TO_DATE('1987-04-19 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '3000', NULL, '20');
INSERT INTO "SCOTT"."EMP" VALUES ('7839', 'KING', 'PRESIDENT', NULL, TO_DATE('1981-11-17 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '5000', NULL, '10');
INSERT INTO "SCOTT"."EMP" VALUES ('7844', 'TURNER', 'SALESMAN', '7698', TO_DATE('1981-09-08 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '1500', '0', '30');
INSERT INTO "SCOTT"."EMP" VALUES ('7876', 'ADAMS', 'CLERK', '7788', TO_DATE('1987-05-23 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '1100', NULL, '20');
INSERT INTO "SCOTT"."EMP" VALUES ('7900', 'JAMES', 'CLERK', '7698', TO_DATE('1981-12-03 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '950', NULL, '30');
INSERT INTO "SCOTT"."EMP" VALUES ('7902', 'FORD', 'ANALYST', '7566', TO_DATE('1981-12-03 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '3000', NULL, '20');
INSERT INTO "SCOTT"."EMP" VALUES ('7934', 'MILLER', 'CLERK', '7782', TO_DATE('1982-01-23 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '1300', NULL, '10');

-- ----------------------------
-- Table structure for EMPLOYEE
-- ----------------------------
DROP TABLE "SCOTT"."EMPLOYEE";
CREATE TABLE "SCOTT"."EMPLOYEE" (
  "ID" NUMBER NOT NULL ,
  "P_ID" NUMBER ,
  "C_ID" NUMBER ,
  "ISAGREED" NUMBER DEFAULT 0
    
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of EMPLOYEE
-- ----------------------------
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('39', '27', '1', '1');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('110', '41', '2', '1');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('111', '32', '2', '1');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('40', '27', '2', '1');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('44', '32', '1', '1');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('112', '99', '2', '1');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('122', '121', '2', '1');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('124', '123', '2', '1');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('126', '125', '2', '1');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('162', '161', '2', '1');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('164', '163', '2', '1');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('181', '27', '140', '0');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('182', '27', '138', '-1');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('183', '27', '141', '0');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('184', '27', '139', '0');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('185', '33', '138', '1');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('202', '32', '138', '0');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('221', '201', '139', '0');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('222', '201', '138', '0');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('241', '201', '2', '0');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('261', '201', '141', '0');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('282', '201', '1', '-1');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('323', '201', '322', '1');
INSERT INTO "SCOTT"."EMPLOYEE" VALUES ('341', '201', '140', '0');

-- ----------------------------
-- Table structure for GRADERECORD
-- ----------------------------
DROP TABLE "SCOTT"."GRADERECORD";
CREATE TABLE "SCOTT"."GRADERECORD" (
  "ID" NUMBER NOT NULL ,
  "MINPOINT" NUMBER NOT NULL ,
  "MAXPOINT" NUMBER NOT NULL ,
  "GRADENAME" VARCHAR2(20 BYTE) NOT NULL ,
  "ICONPATH" VARCHAR2(50 BYTE) NOT NULL 
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of GRADERECORD
-- ----------------------------
INSERT INTO "SCOTT"."GRADERECORD" VALUES ('2', '300', '700', '璺戞灏忓皢', '/images/face2.gif');
INSERT INTO "SCOTT"."GRADERECORD" VALUES ('3', '700', '1200', '璺戞鍋ュ皢', '/images/face3.gif');

-- ----------------------------
-- Table structure for MEMBERINFO
-- ----------------------------
DROP TABLE "SCOTT"."MEMBERINFO";
CREATE TABLE "SCOTT"."MEMBERINFO" (
  "ID" NUMBER NOT NULL ,
  "NICKNAME" VARCHAR2(20 BYTE) NOT NULL ,
  "PASSWORD" VARCHAR2(50 BYTE) NOT NULL ,
  "GENDER" VARCHAR2(1 BYTE) NOT NULL ,
  "AGE" NUMBER NOT NULL ,
  "EMAIL" VARCHAR2(100 BYTE) NOT NULL ,
  "PROVINCECITY" VARCHAR2(10 BYTE) ,
  "ADDRESS" VARCHAR2(200 BYTE) ,
  "PHONE" VARCHAR2(50 BYTE) ,
  "PASSWORDQUESTION" VARCHAR2(200 BYTE) ,
  "PASSWORDANSWER" VARCHAR2(200 BYTE) ,
  "RECOMMENDER" VARCHAR2(20 BYTE) ,
  "POINT" NUMBER DEFAULT 0 ,
  "REGISTERDATE" DATE ,
  "LATESTDATE" DATE ,
  "STATUS" NUMBER DEFAULT 0 ,
  "ISONLINE" NUMBER DEFAULT 0 ,
  "GRADEID" NUMBER 
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for MEMBERSPACE
-- ----------------------------
DROP TABLE "SCOTT"."MEMBERSPACE";
CREATE TABLE "SCOTT"."MEMBERSPACE" (
  "ID" NUMBER NOT NULL ,
  "OPINION" VARCHAR2(200 BYTE) ,
  "RUNTIME" VARCHAR2(20 BYTE) ,
  "RUNPLACE" VARCHAR2(20 BYTE) ,
  "RUNSTAR" VARCHAR2(50 BYTE) ,
  "RUNHABIT" VARCHAR2(50 BYTE) ,
  "CELLPHONE" VARCHAR2(50 BYTE) ,
  "ICON" VARCHAR2(200 BYTE) ,
  "MEMBERID" NUMBER 
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for MESSAGERECORD
-- ----------------------------
DROP TABLE "SCOTT"."MESSAGERECORD";
CREATE TABLE "SCOTT"."MESSAGERECORD" (
  "ID" NUMBER NOT NULL ,
  "SENDER" VARCHAR2(20 BYTE) NOT NULL ,
  "RECEIVER" VARCHAR2(20 BYTE) NOT NULL ,
  "SENDDATE" DATE NOT NULL ,
  "TITLE" VARCHAR2(100 BYTE) NOT NULL ,
  "CONTENT" VARCHAR2(300 BYTE) NOT NULL ,
  "SENDERSTATUS" NUMBER DEFAULT 0 ,
  "RECEIVERSTATUS" NUMBER DEFAULT 0 ,
  "STATUS" NUMBER DEFAULT 0
    
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for PERSON
-- ----------------------------
DROP TABLE "SCOTT"."PERSON";
CREATE TABLE "SCOTT"."PERSON" (
  "ID" NUMBER NOT NULL ,
  "USERNAME" VARCHAR2(20 BYTE) ,
  "PASSWORD" VARCHAR2(20 BYTE) ,
  "NAME" VARCHAR2(20 BYTE) ,
  "SEX" VARCHAR2(4 BYTE) ,
  "BIRTHDAY" VARCHAR2(20 BYTE) ,
  "SCHOOL" VARCHAR2(20 BYTE) ,
  "PHONE" VARCHAR2(20 BYTE) ,
  "EMAIL" VARCHAR2(20 BYTE) ,
  "TRADE" VARCHAR2(20 BYTE) ,
  "SALARY" VARCHAR2(20 BYTE) ,
  "TIP" VARCHAR2(200 BYTE) ,
  "PUBTIME" DATE ,
  "EDUCATION" VARCHAR2(20 CHAR) 
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of PERSON
-- ----------------------------
INSERT INTO "SCOTT"."PERSON" VALUES ('32', 'zhangsan', '123456', '张三', '男', '1998-02-05', '山西大学', '13546869879', '2432432423@qq.com', '经济管理', '4000-5000', '积极向上', TO_DATE('2019-03-14 10:09:37', 'SYYYY-MM-DD HH24:MI:SS'), '学士');
INSERT INTO "SCOTT"."PERSON" VALUES ('33', 'lisi', '123456', '李四', '男', '1993-02-02', '浙江大学', '13502783214', '21313123@abc.com', '土木工程', '6000-7000', '刻苦努力', TO_DATE('2019-05-17 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '硕士');
INSERT INTO "SCOTT"."PERSON" VALUES ('121', 'lihongji', '123456', '李弘基', '男', '1998-03-31', '西北农林大学', '18703548975', '4564545@qq.com', '土木工程', '7000-8000', '勤奋好学,积极向上', TO_DATE('2019-05-17 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '学士');
INSERT INTO "SCOTT"."PERSON" VALUES ('27', 'wangliu', '123456', '王六', '女', '1994-10-22', '太原理工大学', '18635162493', '2411150704qq.com', '数学', '5000-6000', 'good person!', TO_DATE('2019-05-17 15:18:58', 'SYYYY-MM-DD HH24:MI:SS'), '学士');
INSERT INTO "SCOTT"."PERSON" VALUES ('41', 'wangwu', '123456', '王五', '男', '1995-03-01', '中北大学', '18745120012', '45454545@qq.com', '法学', '6000-7000', 'good', TO_DATE('2019-05-17 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '学士');
INSERT INTO "SCOTT"."PERSON" VALUES ('123', 'renchang', '123456', '任畅', '男', '1994-02-14', '太原理工大学', '15476895200', '323453@qq.com', '数学', '7000-8000', '勤奋好学', TO_DATE('2019-05-17 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '学士');
INSERT INTO "SCOTT"."PERSON" VALUES ('125', 'libai', '123456', '李白', '男', '1991-04-11', '清华大学', '13426835455', '7866456@qq.com', '软件工程', '3000-4000', '努力刻苦！！！', TO_DATE('2019-05-17 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '学士');
INSERT INTO "SCOTT"."PERSON" VALUES ('161', 'lihao', '123456', '李昊', '男', '1994-04-07', '武汉大学', '18645310527', '18645310527@qq.com', '经济管理', '7000-8000', '自我评价良好！！', TO_DATE('2019-05-17 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '学士');
INSERT INTO "SCOTT"."PERSON" VALUES ('99', 'wangwei', '123456', '王威', '男', '1992-03-04', '北京大学', '15025470021', '7654321@qq.com', '软件工程', '3000-4000', NULL, TO_DATE('2019-05-17 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '博士');
INSERT INTO "SCOTT"."PERSON" VALUES ('163', 'wanglei', '123456', '王磊', '男', '1994-04-06', '复旦大学', '18635210517', '18635210517@qq.com', '软件工程', '3000-4000', '刻苦努力，勤奋好学', TO_DATE('2019-05-17 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '硕士');
INSERT INTO "SCOTT"."PERSON" VALUES ('55', 'liuyu', '123456', '刘裕', '男', '1996-12-11', '山西医科大学', '13569360032', '23432432@qq.com', '软件工程', '7000-8000', NULL, TO_DATE('2019-05-17 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '学士');
INSERT INTO "SCOTT"."PERSON" VALUES ('201', 'wuyuping', '123456', '吴玉平', '男', '1996-11-14', '南京工程学院', '18795999708', '819232507@qq.com', '数学', '7000-8000', '很腻害', NULL, '学士');
INSERT INTO "SCOTT"."PERSON" VALUES ('321', '123456', '123456', '张三', '男', '2019-05-13', '南京大学', '1234567890', '123@qq.com', '软件工程', '7000-8000', '很不错', NULL, '硕士');
INSERT INTO "SCOTT"."PERSON" VALUES ('302', 'wuhaiming', '123456', '吴海明', '男', '1996-04-10', '南京工程学院', '1234567890', '1234567@qq.com', '软件工程', '7000-8000', NULL, TO_DATE('2019-05-29 21:43:52', 'SYYYY-MM-DD HH24:MI:SS'), '博士');
INSERT INTO "SCOTT"."PERSON" VALUES ('1', 'admin', 'admin', NULL, NULL, NULL, NULL, 'admin', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO "SCOTT"."PERSON" VALUES ('362', 'mengbo', '123456', '孟艳波', '男', '2019-05-17', '南京工程学院', '1234567890', '1234567@qq.com', '软件工程', '5000-6000', NULL, TO_DATE('2019-05-29 21:43:45', 'SYYYY-MM-DD HH24:MI:SS'), '博士');

-- ----------------------------
-- Table structure for POINTACTION
-- ----------------------------
DROP TABLE "SCOTT"."POINTACTION";
CREATE TABLE "SCOTT"."POINTACTION" (
  "ID" NUMBER NOT NULL ,
  "ACTIONNAME" VARCHAR2(20 BYTE) ,
  "POINT" NUMBER NOT NULL ,
  "DESCRIPTION" VARCHAR2(200 BYTE) 
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of POINTACTION
-- ----------------------------
INSERT INTO "SCOTT"."POINTACTION" VALUES ('1', 'REGISTER', '50', '娉ㄥ唽浼氬憳');
INSERT INTO "SCOTT"."POINTACTION" VALUES ('2', 'RECOMMEND', '20', '鎺ㄨ崘浼氬憳');
INSERT INTO "SCOTT"."POINTACTION" VALUES ('3', 'LOGIN', '3', '鐧诲綍');
INSERT INTO "SCOTT"."POINTACTION" VALUES ('4', 'LOGINDESKHELPER', '3', '鐧诲綍妗岄潰鍔╂墜');
INSERT INTO "SCOTT"."POINTACTION" VALUES ('5', 'CREATEPERSONALSPACE', '25', '鍒涘缓涓汉绌洪棿');
INSERT INTO "SCOTT"."POINTACTION" VALUES ('6', 'SENDSTICK', '25', '鍙戝笘');
INSERT INTO "SCOTT"."POINTACTION" VALUES ('7', 'REPLYSTICK', '25', '鍥炲笘');
INSERT INTO "SCOTT"."POINTACTION" VALUES ('10', 'BBSMANAGER', '200', '鎴愪负鐗堜富');
INSERT INTO "SCOTT"."POINTACTION" VALUES ('11', 'REPLYSTICK', '5', '姣?0涓洖澶嶅笘瀛愭ゼ涓?5');
INSERT INTO "SCOTT"."POINTACTION" VALUES ('12', 'EDM', '10', '鎴愪负鐗堜富');
INSERT INTO "SCOTT"."POINTACTION" VALUES ('14', 'WINRUNNING1', '5000', '閮藉競璺戞椿鍔ㄥ緱鍚嶆');
INSERT INTO "SCOTT"."POINTACTION" VALUES ('15', 'WINRUNNING2', '4000', '閮藉競璺戞椿鍔ㄥ緱鍚嶆');

-- ----------------------------
-- Table structure for POINTRECORD
-- ----------------------------
DROP TABLE "SCOTT"."POINTRECORD";
CREATE TABLE "SCOTT"."POINTRECORD" (
  "ID" NUMBER NOT NULL ,
  "NICKNAME" VARCHAR2(20 BYTE) NOT NULL ,
  "RECEIVEDATE" DATE NOT NULL ,
  "POINTACTIONID" NUMBER 
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for SALGRADE
-- ----------------------------
DROP TABLE "SCOTT"."SALGRADE";
CREATE TABLE "SCOTT"."SALGRADE" (
  "GRADE" NUMBER ,
  "LOSAL" NUMBER ,
  "HISAL" NUMBER 
)
TABLESPACE "USERS"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of SALGRADE
-- ----------------------------
INSERT INTO "SCOTT"."SALGRADE" VALUES ('1', '700', '1200');
INSERT INTO "SCOTT"."SALGRADE" VALUES ('2', '1201', '1400');
INSERT INTO "SCOTT"."SALGRADE" VALUES ('3', '1401', '2000');
INSERT INTO "SCOTT"."SALGRADE" VALUES ('4', '2001', '3000');
INSERT INTO "SCOTT"."SALGRADE" VALUES ('5', '3001', '9999');

-- ----------------------------
-- Sequence structure for SEQ
-- ----------------------------
DROP SEQUENCE "SCOTT"."SEQ";
CREATE SEQUENCE "SCOTT"."SEQ" MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_COMMON
-- ----------------------------
DROP SEQUENCE "SCOTT"."SEQ_COMMON";
CREATE SEQUENCE "SCOTT"."SEQ_COMMON" MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 CACHE 20;

-- ----------------------------
-- Primary Key structure for table BLACKRECORD
-- ----------------------------
ALTER TABLE "SCOTT"."BLACKRECORD" ADD CONSTRAINT "SYS_C0011134" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table BLACKRECORD
-- ----------------------------
ALTER TABLE "SCOTT"."BLACKRECORD" ADD CONSTRAINT "SYS_C0011132" CHECK ("SELFNAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "SCOTT"."BLACKRECORD" ADD CONSTRAINT "SYS_C0011133" CHECK ("BLACKNAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Indexes structure for table BLACKRECORD
-- ----------------------------
CREATE UNIQUE INDEX "SCOTT"."SYS_C004040"
  ON "SCOTT"."BLACKRECORD" ("ID" ASC)
  LOGGING
  TABLESPACE "SYSTEM"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
);

-- ----------------------------
-- Primary Key structure for table COMPANY
-- ----------------------------
ALTER TABLE "SCOTT"."COMPANY" ADD CONSTRAINT "SYS_C0011135" PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table COMPANY
-- ----------------------------
CREATE UNIQUE INDEX "SCOTT"."SYS_C004099"
  ON "SCOTT"."COMPANY" ("ID" ASC)
  LOGGING
  TABLESPACE "SYSTEM"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
);

-- ----------------------------
-- Primary Key structure for table DEPT
-- ----------------------------
ALTER TABLE "SCOTT"."DEPT" ADD CONSTRAINT "PK_DEPT" PRIMARY KEY ("DEPTNO");

-- ----------------------------
-- Primary Key structure for table EMP
-- ----------------------------
ALTER TABLE "SCOTT"."EMP" ADD CONSTRAINT "PK_EMP" PRIMARY KEY ("EMPNO");

-- ----------------------------
-- Primary Key structure for table EMPLOYEE
-- ----------------------------
ALTER TABLE "SCOTT"."EMPLOYEE" ADD CONSTRAINT "EMPLOYEE_PK" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table EMPLOYEE
-- ----------------------------
ALTER TABLE "SCOTT"."EMPLOYEE" ADD CONSTRAINT "SYS_C0011137" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table GRADERECORD
-- ----------------------------
ALTER TABLE "SCOTT"."GRADERECORD" ADD CONSTRAINT "SYS_C0011142" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table GRADERECORD
-- ----------------------------
ALTER TABLE "SCOTT"."GRADERECORD" ADD CONSTRAINT "SYS_C0011138" CHECK ("MINPOINT" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "SCOTT"."GRADERECORD" ADD CONSTRAINT "SYS_C0011139" CHECK ("MAXPOINT" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "SCOTT"."GRADERECORD" ADD CONSTRAINT "SYS_C0011140" CHECK ("GRADENAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "SCOTT"."GRADERECORD" ADD CONSTRAINT "SYS_C0011141" CHECK ("ICONPATH" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Indexes structure for table GRADERECORD
-- ----------------------------
CREATE UNIQUE INDEX "SCOTT"."SYS_C004027"
  ON "SCOTT"."GRADERECORD" ("ID" ASC)
  LOGGING
  TABLESPACE "SYSTEM"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
);

-- ----------------------------
-- Primary Key structure for table MEMBERINFO
-- ----------------------------
ALTER TABLE "SCOTT"."MEMBERINFO" ADD CONSTRAINT "SYS_C0011148" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table MEMBERINFO
-- ----------------------------
ALTER TABLE "SCOTT"."MEMBERINFO" ADD CONSTRAINT "SYS_C0011143" CHECK ("NICKNAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "SCOTT"."MEMBERINFO" ADD CONSTRAINT "SYS_C0011144" CHECK ("PASSWORD" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "SCOTT"."MEMBERINFO" ADD CONSTRAINT "SYS_C0011145" CHECK ("GENDER" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "SCOTT"."MEMBERINFO" ADD CONSTRAINT "SYS_C0011146" CHECK ("AGE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "SCOTT"."MEMBERINFO" ADD CONSTRAINT "SYS_C0011147" CHECK ("EMAIL" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Indexes structure for table MEMBERINFO
-- ----------------------------
CREATE UNIQUE INDEX "SCOTT"."SYS_C004033"
  ON "SCOTT"."MEMBERINFO" ("ID" ASC)
  LOGGING
  TABLESPACE "SYSTEM"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
);

-- ----------------------------
-- Primary Key structure for table MEMBERSPACE
-- ----------------------------
ALTER TABLE "SCOTT"."MEMBERSPACE" ADD CONSTRAINT "SYS_C0011149" PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table MEMBERSPACE
-- ----------------------------
CREATE UNIQUE INDEX "SCOTT"."SYS_C004041"
  ON "SCOTT"."MEMBERSPACE" ("ID" ASC)
  LOGGING
  TABLESPACE "SYSTEM"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
);

-- ----------------------------
-- Primary Key structure for table MESSAGERECORD
-- ----------------------------
ALTER TABLE "SCOTT"."MESSAGERECORD" ADD CONSTRAINT "SYS_C0011155" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table MESSAGERECORD
-- ----------------------------
ALTER TABLE "SCOTT"."MESSAGERECORD" ADD CONSTRAINT "SYS_C0011150" CHECK ("SENDER" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "SCOTT"."MESSAGERECORD" ADD CONSTRAINT "SYS_C0011151" CHECK ("RECEIVER" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "SCOTT"."MESSAGERECORD" ADD CONSTRAINT "SYS_C0011152" CHECK ("SENDDATE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "SCOTT"."MESSAGERECORD" ADD CONSTRAINT "SYS_C0011153" CHECK ("TITLE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "SCOTT"."MESSAGERECORD" ADD CONSTRAINT "SYS_C0011154" CHECK ("CONTENT" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Indexes structure for table MESSAGERECORD
-- ----------------------------
CREATE UNIQUE INDEX "SCOTT"."SYS_C004054"
  ON "SCOTT"."MESSAGERECORD" ("ID" ASC)
  LOGGING
  TABLESPACE "SYSTEM"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
);

-- ----------------------------
-- Primary Key structure for table PERSON
-- ----------------------------
ALTER TABLE "SCOTT"."PERSON" ADD CONSTRAINT "SYS_C0011156" PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table PERSON
-- ----------------------------
CREATE UNIQUE INDEX "SCOTT"."SYS_C004100"
  ON "SCOTT"."PERSON" ("ID" ASC)
  LOGGING
  TABLESPACE "SYSTEM"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
);

-- ----------------------------
-- Primary Key structure for table POINTACTION
-- ----------------------------
ALTER TABLE "SCOTT"."POINTACTION" ADD CONSTRAINT "SYS_C0011158" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table POINTACTION
-- ----------------------------
ALTER TABLE "SCOTT"."POINTACTION" ADD CONSTRAINT "SYS_C0011157" CHECK ("POINT" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Indexes structure for table POINTACTION
-- ----------------------------
CREATE UNIQUE INDEX "SCOTT"."SYS_C004044"
  ON "SCOTT"."POINTACTION" ("ID" ASC)
  LOGGING
  TABLESPACE "SYSTEM"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
);

-- ----------------------------
-- Primary Key structure for table POINTRECORD
-- ----------------------------
ALTER TABLE "SCOTT"."POINTRECORD" ADD CONSTRAINT "SYS_C0011161" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table POINTRECORD
-- ----------------------------
ALTER TABLE "SCOTT"."POINTRECORD" ADD CONSTRAINT "SYS_C0011159" CHECK ("NICKNAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "SCOTT"."POINTRECORD" ADD CONSTRAINT "SYS_C0011160" CHECK ("RECEIVEDATE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Indexes structure for table POINTRECORD
-- ----------------------------
CREATE UNIQUE INDEX "SCOTT"."SYS_C004047"
  ON "SCOTT"."POINTRECORD" ("ID" ASC)
  LOGGING
  TABLESPACE "SYSTEM"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
);

-- ----------------------------
-- Foreign Keys structure for table EMP
-- ----------------------------
ALTER TABLE "SCOTT"."EMP" ADD CONSTRAINT "FK_DEPTNO" FOREIGN KEY ("DEPTNO") REFERENCES "SCOTT"."DEPT" ("DEPTNO") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Foreign Keys structure for table EMPLOYEE
-- ----------------------------
ALTER TABLE "SCOTT"."EMPLOYEE" ADD CONSTRAINT "FK_C" FOREIGN KEY ("C_ID") REFERENCES "SCOTT"."COMPANY" ("ID") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "SCOTT"."EMPLOYEE" ADD CONSTRAINT "FK_P" FOREIGN KEY ("P_ID") REFERENCES "SCOTT"."PERSON" ("ID") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Foreign Keys structure for table MEMBERINFO
-- ----------------------------
ALTER TABLE "SCOTT"."MEMBERINFO" ADD CONSTRAINT "INFO_GRADE" FOREIGN KEY ("GRADEID") REFERENCES "SCOTT"."GRADERECORD" ("ID") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Foreign Keys structure for table MEMBERSPACE
-- ----------------------------
ALTER TABLE "SCOTT"."MEMBERSPACE" ADD CONSTRAINT "SPACE_INFO" FOREIGN KEY ("MEMBERID") REFERENCES "SCOTT"."MEMBERINFO" ("ID") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Foreign Keys structure for table POINTRECORD
-- ----------------------------
ALTER TABLE "SCOTT"."POINTRECORD" ADD CONSTRAINT "RECORD_ACTION" FOREIGN KEY ("POINTACTIONID") REFERENCES "SCOTT"."POINTACTION" ("ID") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
