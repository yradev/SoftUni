/*
Exercise: 1
*/


CREATE TABLE `minions`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45),
`age` INT 
);

CREATE TABLE `towns`(
`town_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45)
);

/*
Exercise: 2
*/


ALTER TABLE `minions`
ADD COLUMN `town_id` INT NOT NULL AFTER `age`;

ALTER TABLE `minions` 
ADD CONSTRAINT `fk_town_id`
  FOREIGN KEY (`town_id`)
  REFERENCES  `towns` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

/*
Exercise: 3
*/


INSERT INTO `towns` VALUES (1,'Sofia');
INSERT INTO `towns` VALUES (2,'Plovdiv');
INSERT INTO `towns` VALUES (3,'Varna');


INSERT INTO `minions` VALUES (1,'Kevin',22,1);
INSERT INTO `minions` VALUES (2,'Bob',15,3);
INSERT INTO `minions` VALUES (3,'Steward',NULL,2);

/*
Exercise: 4
*/


TRUNCATE `minions`;

/*
Exercise: 5
*/

DROP TABLE `minions`;
DROP TABLE `towns`;

/*
Exercise: 6
*/

CREATE TABLE `people`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` float(32,2),
`weight` float(34,2),
`gender` VARCHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT
);

 INSERT INTO `people` (`name`,`height`,`weight`,`gender`,`birthdate`,`biography`) VALUES('Yanko',22.33,44.33,'m','2021-12-31','Softuni is the best!' );
 INSERT INTO `people` (`name`,`height`,`weight`,`gender`,`birthdate`,`biography`) VALUES('Yanko',22.33,44.33,'m','2021-12-31','Softuni is the best!' );
 INSERT INTO `people` (`name`,`height`,`weight`,`gender`,`birthdate`,`biography`) VALUES('Yanko',22.33,44.33,'m','2021-12-31','Softuni is the best!' );
 INSERT INTO `people` (`name`,`height`,`weight`,`gender`,`birthdate`,`biography`) VALUES('Yanko',22.33,44.33,'m','2021-12-31','Softuni is the best!' );
 INSERT INTO `people` (`name`,`height`,`weight`,`gender`,`birthdate`,`biography`) VALUES('Yanko',22.33,44.33,'m','2021-12-31','Softuni is the best!' );

/*
Exercise: 7
*/


CREATE TABLE `users`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`username` VARCHAR(30) NOT NULL UNIQUE,
`password` VARCHAR(26) NOT NULL,
`profile_picute` BLOB,
`last_login_time` DATE,
`is_deleted` BOOL
);

INSERT INTO `users` (`username`,`password`,`last_login_time`,`is_deleted`) VALUES ('ivan','pass','2021-12-31',false);
INSERT INTO `users` (`username`,`password`,`last_login_time`,`is_deleted`) VALUES ('dido','pass','2021-12-31',false);
INSERT INTO `users` (`username`,`password`,`last_login_time`,`is_deleted`) VALUES ('dimo','pass','2021-12-31',false);
INSERT INTO `users` (`username`,`password`,`last_login_time`,`is_deleted`) VALUES ('galio','pass','2021-12-31',false);
INSERT INTO `users` (`username`,`password`,`last_login_time`,`is_deleted`) VALUES ('pesho','pass','2021-12-31',false);

/*
Exercise: 8
*/


ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users
PRIMARY KEY (`id`, `username`);

/*
Exercise: 9
*/


ALTER TABLE `users`
CHANGE COLUMN `last_login_time` `last_login_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

/*
Exercise: 10
*/


ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users
PRIMARY KEY (`id`),
CHANGE COLUMN `username` `username` VARCHAR(30) UNIQUE;

/*
Exercise: 11
*/


CREATE SCHEMA `moves`;
CREATE TABLE `directors`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`director_name` VARCHAR(30) NOT NULL,
`notes` TEXT
);

INSERT INTO `directors` (`director_name`,`notes`) VALUES ('IVAN','FROM SOFTUNI');
INSERT INTO `directors` (`director_name`,`notes`) VALUES ('DIMO','FROM SOFTUNI');
INSERT INTO `directors` (`director_name`,`notes`) VALUES ('IVANA','FROM SOFTUNI');
INSERT INTO `directors` (`director_name`,`notes`) VALUES ('MIRELA','FROM SOFTUNI');
INSERT INTO `directors` (`director_name`,`notes`) VALUES ('STEFAN','FROM SOFTUNI');

CREATE TABLE `genres`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`genre_name` VARCHAR(30) NOT NULL,
`notes` VARCHAR(30)
);

INSERT INTO `genres` (`genre_name`,`notes`) VALUES ('HORROR','FROM SOFTUNI CINEMA');
INSERT INTO `genres` (`genre_name`,`notes`) VALUES ('COMEDY','FROM SOFTUNI CINEMA');
INSERT INTO `genres` (`genre_name`,`notes`) VALUES ('ACTION','FROM SOFTUNI CINEMA');
INSERT INTO `genres` (`genre_name`,`notes`) VALUES ('ROMANTIC','FROM SOFTUNI CINEMA');
INSERT INTO `genres` (`genre_name`,`notes`) VALUES ('CRIMINAL','FROM SOFTUNI CINEMA');

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category_name` VARCHAR(30) NOT NULL,
`notes` VARCHAR(30)
);

INSERT INTO `categories` (`category_name`,`notes`) VALUES ('name','FROM SOFTUNI CINEMA'); 
INSERT INTO `categories` (`category_name`,`notes`) VALUES ('name2','FROM SOFTUNI CINEMA'); 
INSERT INTO `categories` (`category_name`,`notes`) VALUES ('name3','FROM SOFTUNI CINEMA'); 
INSERT INTO `categories` (`category_name`,`notes`) VALUES ('name4','FROM SOFTUNI CINEMA'); 
INSERT INTO `categories` (`category_name`,`notes`) VALUES ('name5','FROM SOFTUNI CINEMA'); 

CREATE TABLE `movies`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(30) NOT NULL,
`director_id` VARCHAR(30),
`copyright_year` DATE,
`length` INT,
`genre_id` INT,
`category_id` INT,
`rating` DOUBLE,
`notes` VARCHAR(30)
);

INSERT INTO `movies` (`title`) VALUES ('FILM1');
INSERT INTO `movies` (`title`) VALUES ('FILM2');
INSERT INTO `movies` (`title`) VALUES ('FILM3');
INSERT INTO `movies` (`title`) VALUES ('FILM4');
INSERT INTO `movies` (`title`) VALUES ('FILM5');

/*
Exercise: 12
*/



CREATE TABLE `categories` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category` VARCHAR(30) NOT NULL,
`daily_rate` DOUBLE,
`weekly_rate` DOUBLE,
`monthly_rate` DOUBLE,
`weekend_rate` DOUBLE
);

INSERT INTO `categories` (`category`) VALUES 
('name1'),
('name2'),
('name3');

CREATE TABLE `cars`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`plate_number` INT NOT NULL,
`make` VARCHAR(30),
`model` VARCHAR(30),
`car_year` DATE,
`category_id` INT,
`doors` INT,
`picture` BLOB,
`car_condition` VARCHAR(30),
`available` BOOL
);

INSERT INTO `cars` (`plate_number`) VALUES
('3342'),
('4342'),
('3352');

CREATE TABLE `employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30),
`last_name` VARCHAR(30),
`title` TEXT,
`notes` VARCHAR(39)
);

INSERT INTO `employees` (`first_name`,`last_name`) VALUES
('IVAN','DIMOV'),
('PETYR','DIMOV'),
('STEFAN','DIMOV');

CREATE TABLE `customers`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`driver_licence_number` INT,
`full_name` VARCHAR(33),
`address` VARCHAR(34),
`city` VARCHAR(33),
`zip_code` INT,
`notes` TEXT
);

INSERT INTO `customers` (`driver_licence_number`) VALUES
(2323),
(2333),
(2343);

CREATE TABLE `rental_orders`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`employee_id` INT,
`customer_id` INT,
`car_id` INT,
`car_condition` VARCHAR(33),
`tank_level` INT,
`kilometrage_start` INT,
`kilometrage_end` INT,
`total_kilometrage` INT,
`start_date` DATE,
`end_date` DATE,
`total_days` INT,
`rate_applied` double,
`tax_rate` double,
`order_status` VARCHAR(33),
`notes` TEXT
);

INSERT INTO `rental_orders`(`car_id`) VALUES
(1),
(2),
(3);

/*
Exercise: 13
*/

INSERT INTO `towns`(`name`) VALUES
('Sofia'),
('Plovdiv'),
('Varna'),
('Burgas');

INSERT INTO `departments` (`name`) VALUES 
('Engineering'),
('Sales'),
('Marketing'),
('Software Development'),
('Quality Assurance');

INSERT INTO `employees`(`first_name`,`middle_name`,`last_name`,`job_title`,`salary`,`department_id`,`hire_date`) VALUES
('Ivan','Ivanov','Ivanov','.NET Developer', 3500, 4,'2013-02-01'),
('Petar','Petrov','Petrov','Senior Engineer',4000, 1,'2004-03-02'),
('Maria','Petrova','Ivanova','Intern',525.25, 5,'2016-08-28'),
('Georgi','Terziev','Ivanov','CEO',3000,2,'2007-12-09'),
('Peter','Pan','Pan','Intern',599.88,3,'2016-08-28');

/*
Exercise: 14
*/


SELECT * FROM `towns`;
SELECT * FROM `departments`;
SELECT * FROM `employees`;

/*
Exercise: 15
*/


SELECT * FROM `towns`
ORDER BY `name` ASC;
SELECT * FROM `departments`
ORDER BY `name` ASC;
SELECT * FROM `employees`
ORDER BY `salary` DESC;

/*
Exercise: 16
*/


SELECT `name` FROM `towns`
ORDER BY `name` ASC;
SELECT `name` FROM `departments`
ORDER BY `name` ASC;
SELECT `first_name`,`last_name`,`job_title`,`salary` FROM `employees`
ORDER BY `salary` DESC;

/*
Exercise: 17
*/

UPDATE `employees`
SET `salary` = `salary`*1.1 WHERE `id`>0;
SELECT `salary` FROM `employees`;

/*
Exercise: 18
*/

DELETE FROM occupancies;
