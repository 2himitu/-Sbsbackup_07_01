DROP databasse IF EXISTS sb_c_2022_2nd;
CREATE DATABASE sb_c_2022_2nd;
USE sb_c_2022_2nd;

CREATE TABLE article (
id INT (10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
regDate DATETIME NOT NULL,
updateDate DATETIME NOT NULL,
title CHAR(100) NOT NULL,
`body` TEXT NOT NULL
);

INSERT INTO article SET 
regDate = NOW(),
updateDate = NOW(),
title = '제목 1',
`body` = '내용 1';

INSERT INTO article SET 
regDate = NOW(),
updateDate = NOW(),
title = '제목 2',
`body` = '내용 2';

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = '제목 3',
`body` = '내용 3';

SELECT * FROM article;

CREATE TABLE `member` (
id INT (10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
regDate DATETIME NOT NULL,
updateDate DATETIME NOT NULL,
loginId CHAR(20) NOT NULL,
loginPw CHAR(60) NOT NULL,
authLevel SMALLINT(2) UNSIGNED DEFAULT 3 COMMENT '(3=일반,7==관리자)',
`name` CHAR(20) NOT NULL,
nickname CHAR(20) NOT NULL,
cellphoneNo CHAR(20) NOT NULL,
email CHAR(50) NOT NULL,
delStatus TINYINT (1) UNSIGNED NOT NULL  DEFAULT 0 COMMENT '탈퇴여부(0=탈퇴전 ,1=탈퇴)',
delDate DATETIME COMMENT'탈퇴날짜'

);

INSERT INTO `member`
SET 
regDate = NOW(),
updateDate = NOW(),
loginId = 'admin',
loginPw = 'admin',
authLevel = 7,
`name` ='관리자',
nickname ='관리자',
cellphoneNo ='01000000000',
email = 'lhs12002@naver.com';


INSERT INTO `member`
SET 
regDate = NOW(),
updateDate = NOW(),
loginId = 'user1',
loginPw = 'user1',
`name` ='유저1',
nickname ='유저1',
cellphoneNo ='01000000000',
email = 'lhs12002@naver.com';


INSERT INTO `member`
SET 
regDate = NOW(),
updateDate = NOW(),
loginId = 'user2',
loginPw = 'user2',
`name` ='유저2',
nickname ='유저2',
cellphoneNo ='01000000000',
email = 'lhs12002@naver.com';


SELECT * FROM `member`; 



