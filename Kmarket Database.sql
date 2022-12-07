create database `java1_kmarket`;
create user 'java1_team1'@'%' identified by '1234';
grant all privileges on `java1_kmarket`.* to 'java1_team1'@'%';
flush PRIVILEGES;

#회원 테이블
CREATE TABLE `km_member`(
	`uid` VARCHAR(20) PRIMARY KEY,
	`pass` VARCHAR(255) NOT NULL,
	`name` VARCHAR(20) NOT NULL,
	`gender` TINYINT NOT NULL,
	`hp` CHAR(13) NOT NULL,
	`email`VARCHAR(100) NOT NULL,
	`type` TINYINT NOT NULL,
	`point` INT DEFAULT 0,
	`level` TINYINT DEFAULT 1,
	`zip` VARCHAR(10),
	`addr1` VARCHAR(255),
	`addr2` VARCHAR(255),
	`company` VARCHAR(20),
	`ceo` VARCHAR(20),
	`bizRegNum` CHAR(12),
	`comRegNum` VARCHAR(100),
	`tel` VARCHAR(20),
	`manager` VARCHAR(20),
	`managerHp` CHAR(13),
	`fax` VARCHAR(20),
	`regip` VARCHAR(100) NOT NULL,
	`wdate` DATETIME,
	`rdate` DATETIME NOT NULL,
	`etc1` INT,
	`etc2` INT,
	`etc3` VARCHAR(10),
	`etc4` VARCHAR(20),
	`etc5` VARCHAR(30)
);
#약관 테이블
CREATE TABLE `km_member_terms`(
	`terms` TEXT NOT NULL,
	`privacy` TEXT NOT NULL, 
	`location` TEXT NOT NULL,
	`finance` TEXT NOT NULL,
	`tax` TEXT NOT NULL
);
#회원 적립포인트 테이블
CREATE TABLE `km_member_point`(
	`pointNo` INT AUTO_INCREMENT PRIMARY KEY,
	`uid` VARCHAR(20) NOT NULL,
	`ordNo` INT NOT NULL,
	`point` INT NOT NULL,
	`pointDate` DATETIME NOT NULL
);
#상품 테이블
CREATE TABLE `km_product`(
	`prodNo` INT(10) AUTO_INCREMENT PRIMARY KEY,
	`prodCate1` TINYINT NOT NULL,
	`prodCate2` TINYINT NOT NULL,
	`prodName` VARCHAR(100) NOT NULL,
	`descipt` VARCHAR(100) NOT NULL,
	`company` VARCHAR(100) NOT NULL,
	`seller` VARCHAR(20) NOT NULL,
	`price` INT NOT NULL,
	`discount` TINYINT DEFAULT 0,
	`point` INT DEFAULT 0,
	`stock` INT DEFAULT 0,
	`sold` INT DEFAULT 0,
	`delivery` INT DEFAULT 0,
	`hit` INT DEFAULT 0,
	`score` TINYINT DEFAULT 0,
	`review` INT DEFAULT 0,
	`thumb1` VARCHAR(255) NOT NULL,
	`thumb2` VARCHAR(255) NOT NULL,
	`thumb3` VARCHAR(255) NOT NULL,
	`detail` VARCHAR(255) NOT NULL,
	`status` VARCHAR(20) DEFAULT '새상품',
	`duty` VARCHAR(20) DEFAULT '과세상품',
	`receipt` VARCHAR(30) DEFAULT '발행가능-신용카드 전표,온라인 현금영수증',
	`dizType` VARCHAR(20) DEFAULT '사업자 판매자',
	`origin` VARCHAR(20) DEFAULT '상세설명참고',
	`ip` VARCHAR(20) NOT NULL,
	`rdate` DATETIME NOT NULL,
	`etc1` INT,
	`etc2` INT,
	`etc3` VARCHAR(10),
	`etc4` VARCHAR(20),
	`etc5` VARCHAR(30)
);
#1차 상품 카테고리 테이블
CREATE TABLE `km_product_cate1`(
	`cate1` TINYINT NOT NULL PRIMARY KEY,
	`c1Name` VARCHAR(20) NOT NULL
);
#2차 상품 카테고리 테이블
CREATE TABLE `km_product_cate2`(
	`cate1` INT NOT NULL,
	`cate2` INT NOT NULL,
	`c2Name` VARCHAR(20) NOT NULL 
);
#장바구니 테이블
CREATE TABLE `km_product_cart`(
	`cartNo` INT AUTO_INCREMENT PRIMARY KEY,
	`uid` VARCHAR(20) NOT NULL,
	`prodNo` INT NOT NULL,
	`count` INT NOT NULL,
	`price` INT NOT NULL,
	`discount` INT NOT NULL,
	`point` INT NOT NULL,
	`delivery` INT NOT NULL,
	`total` INT NOT NULL,
	`rdate` DATETIME NOT NULL
);
#주문 테이블
CREATE TABLE `km_product_order`(
	`ordNo` INT AUTO_INCREMENT PRIMARY KEY,
	`ordUid` VARCHAR(20) NOT NULL,
	`ordCount` INT DEFAULT 0,
	`ordPrice` INT DEFAULT 0,
	`ordDiscount` INT DEFAULT 0,
	`ordDelivery` INT DEFAULT 0,
	`savePoint` INT DEFAULT 0,
	`usedPoint` INT DEFAULT 0,
	`recipName` VARCHAR(20) NOT NULL,
	`recipHp` CHAR(13) NOT NULL,
	`recipZip` CHAR(5) NOT NULL,
	`recipAddr1` VARCHAR(255) NOT NULL,
	`recipAddr2` VARCHAR(255) NOT NULL,
	`ordPayment` TINYINT NOT NULL,
	`ordComplete` TINYINT NOT NULL,
	`ordDate` DATETIME NOT NULL
);
#주문 상세 아이템 테이블
CREATE TABLE `km_product_order_item`(
	`ordNo` INT NOT NULL,
	`prodNo` INT NOT NULL,
	`count` INT NOT NULL,
	`price` INT NOT NULL,
	`discount` TINYINT NOT NULL,
	`point` INT NOT NULL,
	`delivery` INT NOT NULL,
	`total` INT NOT NULL
);
#상품 리뷰 테이블
CREATE TABLE `km_product_review`(
	`revNo` INT AUTO_INCREMENT PRIMARY KEY,
	`prodNo` INT NOT NULL,
	`content` VARCHAR(255) NOT NULL,
	`uid` VARCHAR(20) NOT NULL,
	`rating` TINYINT NOT NULL,
	`regip` VARCHAR(100) NOT NULL,
	`rdate` DATETIME NOT null
);