select version();
SELECT DISTINCT User FROM mysql.user;


#create user and 
CREATE USER 'AppFourAdmin'@'localhost' IDENTIFIED BY 'AppFourAdmin123456';

# grant privellages
GRANT ALL ON AppFour.* TO 'AppFourAdmin'@'localhost';

SHOW DATABASES;

# create databse if not esist
CREATE DATABASE IF NOT EXISTS AppFour;

USE AppFour;

 CREATE TABLE `user` (
`id` int( 11 ) NOT NULL AUTO_INCREMENT ,
`username` varchar( 30 ) NOT NULL ,
`email` varchar( 50 ) NOT NULL ,
`password` varchar( 128 ) NOT NULL ,
PRIMARY KEY ( `id` ) ,
UNIQUE KEY `username` ( `username` )
) ENGINE = MYISAM DEFAULT CHARSET = utf8;

show tables;

select * from user;

DELETE FROM user WHERE username ='olslsl';