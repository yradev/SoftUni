/*
Exercise 1
*/

CREATE TABLE `passports`(
`passport_id` INT PRIMARY KEY,
`passport_number` VARCHAR(100) UNIQUE
);

INSERT INTO `passports` VALUES
(101,'N34FG21B'),
(102,'K65LO4R7'),
(103,'ZE657QP2');


CREATE TABLE `people`(
`person_id` INT PRIMARY KEY,
`first_name` VARCHAR(100),
`salary` DECIMAL(10,2),
`passport_id` INT UNIQUE,

CONSTRAINT `fk_pasportid`  
FOREIGN KEY (`passport_id`)
REFERENCES `passports` (`passport_id`));

INSERT INTO `people` VALUES 
(1,'Roberto',43300.00,102),
(2,'Tom',56100.00,103),
(3,'Yana',60200.00,101);

/*
Exercise 2
*/

CREATE TABLE `manufacturers`(
`manufacturer_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(100),
`established_on` DATE
);

CREATE TABLE `models`(
`model_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(100),
`manufacturer_id` INT,
CONSTRAINT `fk_manufacturerid`
FOREIGN KEY (`manufacturer_id`)
REFERENCES `manufacturers` (`manufacturer_id`) 
);

ALTER TABLE `models` AUTO_INCREMENT=101;


INSERT INTO `manufacturers` (`name`,`established_on`) VALUES
('BMW','1916-03-01'),
('Tesla','2003-01-01'),
('Lada','1966-05-01');

INSERT INTO `models` (`name`,`manufacturer_id`) VALUES
('X1',1),
('i6',1),
('Model S',2),
('Model X',2),
('Model 3',2),
('Nova',3);

/*
Exercise 3
*/

CREATE TABLE `students`(
`student_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(100)
 );

CREATE TABLE `exams`(
`exam_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(100)
);

ALTER TABLE `exams` AUTO_INCREMENT=101;

CREATE TABLE `students_exams`(
`student_id` INT,
`exam_id` INT,

CONSTRAINT `pk_doublePublicKeys`
PRIMARY KEY(`student_id`,`exam_id`),

CONSTRAINT `fk_studentId`
FOREIGN KEY (`student_id`)
REFERENCES `students` (`student_id`),

CONSTRAINT fk_examID
FOREIGN KEY (`exam_id`)
REFERENCES `exams` (`exam_id`)
);

INSERT INTO `exams` (`name`) VALUES
('Spring MVC'),
('Neo4j'),
('Oracle 11g');

INSERT INTO `students` (`name`) VALUES
('Mila'),
('Toni'),
('Ron');

INSERT INTO `students_exams` (`student_id`,`exam_id`) VALUES 
(1,101),
(1,102),
(2,101),
(3,103),
(2,102),
(2,103);

/*
Exercise 4
*/


CREATE TABLE `teachers`(
`teacher_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(100),
`manager_id` INT
);

ALTER TABLE `teachers` AUTO_INCREMENT=101;

INSERT INTO `teachers` (`name`,`manager_id`)VALUES
('John',NULL),
('Maya',106),
('Silvia',106),
('Ted',105),
('Mark',101),
('Greta',101);

ALTER TABLE `teachers` 
ADD CONSTRAINT fk_teachermanagerid
FOREIGN KEY (`manager_id`)
REFERENCES `teachers` (`teacher_id`);

/*
Exercise 5
*/

CREATE TABLE `item_types`(
`item_type_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50)
);

CREATE TABLE `items`(
`item_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50),
`item_type_id` INT,
CONSTRAINT fk_itemtype
FOREIGN KEY (`item_type_id`)
REFERENCES `item_types` (`item_type_id`)
);

CREATE TABLE `cities`(
`city_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50)
);

CREATE TABLE `customers`(
`customer_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50),
`birthday` DATE,
`city_id` INT,
CONSTRAINT fk_cityid
FOREIGN KEY (`city_id`)
REFERENCES `cities` (`city_id`)
);


CREATE TABLE `orders`(
`order_id` INT PRIMARY KEY AUTO_INCREMENT,
`customer_id` INT,
CONSTRAINT fk_customerid
FOREIGN KEY (`customer_id`)
REFERENCES `customers` (`customer_id`)
);


CREATE TABLE `order_items`(
`order_id` INT,
`item_id` INT,

CONSTRAINT pk_orderitems
PRIMARY KEY (`order_id`, `item_id`),

CONSTRAINT fk_orderid
FOREIGN KEY (`order_id`)
REFERENCES `orders` (`order_id`),

CONSTRAINT fk_itemid
FOREIGN KEY (`item_id`)
REFERENCES `items` (`item_id`)
);

/*
Exercise 6
*/

CREATE TABLE `majors`(
`major_id` INT PRIMARY KEY,
`name` VARCHAR(50)
);

CREATE TABLE `students`(
`student_id` INT PRIMARY KEY,
`student_number` VARCHAR(12),
`student_name` VARCHAR(50),
`major_id` INT,

CONSTRAINT `fk_majorid`
FOREIGN KEY (`major_id`)
REFERENCES `majors` (`major_id`)
);

CREATE TABLE `payments`(
`payment_id` INT PRIMARY KEY,
`payment_date` DATE,
`payment_amount` DECIMAL(8,2),
`student_id` INT,

CONSTRAINT `fk_student_id`
FOREIGN KEY (`student_id`)
REFERENCES `students` (`student_id`)
);

CREATE TABLE `subjects`(
`subject_id` INT PRIMARY KEY,
`subject_name` VARCHAR(50)
);

CREATE TABLE `agenda`(
`student_id` INT,
`subject_id` INT,

CONSTRAINT pk_doubleprimarykkey
PRIMARY KEY (`student_id`,`subject_id`),

CONSTRAINT fk_studentid
FOREIGN KEY (`student_id`)
REFERENCES `students` (`student_id`),

CONSTRAINT fk_subjectid
FOREIGN KEY (`subject_id`)
REFERENCES `subjects` (`subject_id`)
);


/*
Exercise 9
*/

SELECT a.`mountain_range`,b.peak_name,b.elevation
 FROM `mountains` AS a 
 JOIN `peaks` AS b 
 ON b.mountain_id = a.id
WHERE a.`mountain_range` = 'Rila'
ORDER BY b.`elevation` DESC;