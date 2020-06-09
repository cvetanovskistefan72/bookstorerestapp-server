drop schema if exists `book_category_database2`;

create schema `book_category_database2`;

use `book_category_database2`;

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(128) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `books_left` int(11) default null,
  `created_at` date default null,
  primary key(`id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) DEFAULT NULL,
  `category_color` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
 

DROP TABLE IF EXISTS `book_category`;

CREATE TABLE `book_category` (
  `book_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  
  PRIMARY KEY (`book_id`,`category_id`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) 
  REFERENCES `category` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `fk_book1` FOREIGN KEY (`book_id`) 
  REFERENCES `book` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

 

drop table if exists `user`;

create table `user`(
`id` int(11) not null auto_increment,
`email` varchar(64) default null,
`username` varchar(64) default null,
`password` varchar(64) default null,

 
primary key(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;

drop table if exists `shopping_cart`;

create table `shopping_cart`(
`id` int(11) not null auto_increment ,
`cart_status` varchar(64) default null,
`cart_created` date default null,
`cart_closed` date default null,
`username` varchar(64) default null,
`user_id` int(11)NOT NULL,
primary key(`id`),
 KEY `user_id` (`user_id`),
 CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
 

)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;

CREATE TABLE `book_shopping_cart` (
  `book_id` int(11) NOT NULL,
  `shopping_cart_id` int(11) NOT NULL,
  
  PRIMARY KEY (`book_id`,`shopping_cart_id`),
  CONSTRAINT `fk_shopping_cart` FOREIGN KEY (`shopping_cart_id`) 
  REFERENCES `shopping_cart` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `fk_book2` FOREIGN KEY (`book_id`) 
  REFERENCES `book` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
  
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;





INSERT INTO `category` (`category_name`, `category_color`)
		VALUES ('Mystery','dark');
INSERT INTO `category` (`category_name`, `category_color`)
		VALUES ('Fiction','info');
INSERT INTO `category` (`category_name`, `category_color`)
		VALUES ('Horror','danger');
INSERT INTO `category` (`category_name`, `category_color`)
		VALUES ('Romance','primary');
INSERT INTO `category` (`category_name`, `category_color`)
		VALUES ('Drama','success');
INSERT INTO `category` (`category_name`, `category_color`)
		VALUES ('Novel','warning');
INSERT INTO `category` (`category_name`, `category_color`)
		VALUES ('Thriller.','danger');
INSERT INTO `category` (`category_name`, `category_color`)
		VALUES ('Fantasy','primary');
INSERT INTO `category` (`category_name`, `category_color`)
		VALUES ('Adventure','success');

        
        
        
  












