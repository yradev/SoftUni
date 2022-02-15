/*
Exercise 2
*/

INSERT INTO `clients` (`full_name`,`phone_number`) 
SELECT 
CONCAT_WS(' ',d.`first_name`,d.`last_name`)  as 'full_name',
CONCAT_WS('','(088) 9999',d.`id`*2) as `phone_number`
FROM `drivers` as d
WHERE `id` BETWEEN 10 AND 20;

SELECT * FROM `clients`;

/*
Exercise 3
*/


UPDATE `cars` 
SET `condition` = 'C'
WHERE (`mileage` >= 800000 OR `mileage` IS NULL) AND `year`<=2010 AND `make` != 'Mercedes-Benz';

/*
Exercise 4
*/


DELETE FROM `clients` AS c WHERE c.`id` NOT IN (SELECT `client_id` FROM `courses`) OR char_length(`full_name`)<=3; 

/*
Exercise 5
*/


SELECT `make`,`model`,`condition`
FROM `cars`
ORDER BY `id`;

/*
Exercise 6
*/


SELECT d.`first_name`,d.`last_name`,c.`make`,c.`model`,c.`mileage`
FROM `drivers` as d
JOIN `cars_drivers` AS cd ON cd.`driver_id`=d.`id`
JOIN `cars` AS c ON cd.`car_id` = c.`id`
WHERE `mileage` IS NOT NULL
ORDER BY `mileage` DESC, `first_name` ASC;

/*
Exercise 7
*/


SELECT c.`id` as `car_id`, c.`make`, c.`mileage`, COUNT(co.`car_id`) AS 'count_of_courses',ROUND(AVG(`bill`),2) AS `avg_bill`
FROM `cars` as c
LEFT JOIN `courses` as co ON c.`id` = co.`car_id`
GROUP BY c.`id`
HAVING `count_of_courses` != 2
ORDER BY `count_of_courses` DESC,`car_id`;

/*
Exercise 8
*/


SELECT c.`full_name`,COUNT(co.`client_id`) AS 'count_of_cars',SUM(`bill`) AS 'total_sum'
FROM `clients` AS c
JOIN `courses` as co ON co.`client_id` = c.`id`
WHERE SUBSTRING(c.`full_name`,2,1) = 'a'
GROUP BY co.`client_id`
HAVING `count_of_cars` >1
ORDER BY c.`full_name`;

/*
Exercise 9
*/


SELECT a.`name`,
(IF(HOUR(`start`) BETWEEN 6 AND 20,'Day','Night')) as 'day_time',
cu.`bill`,cl.`full_name`,ca.`make`,ca.`model`,cat.`name` as 'category_name'
FROM `addresses` as a
JOIN `courses` as cu ON cu.`from_address_id`=a.`id`
JOIN `clients` as cl ON cu.`client_id`=cl.`id`
JOIN `cars` AS ca ON cu.`car_id`=ca.`id`
JOIN `categories` AS cat ON cat.`id` = ca.`category_id`
ORDER BY cu.`id`;

/*
Exercise 10
*/


DELIMITER $$
CREATE FUNCTION `udf_courses_by_client`(`phone_num` VARCHAR(20))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(co.`id`)
FROM `clients` as cl
JOIN `courses` as co ON cl.`id`=co.`client_id`
WHERE `phone_number` = `phone_num`);
END;

/*
Exercise 11
*/

DELIMITER $$
CREATE PROCEDURE `udp_courses_by_address`(`address_name` VARCHAR(100))
BEGIN
SELECT 
address.`name`,`client`.`full_name`,
(
CASE
WHEN course.`bill`<=20 THEN 'Low'
WHEN course.`bill` BETWEEN 21 AND 30 THEN 'Medium'
WHEN course.`bill`>30 THEN 'High'
END
)AS 'level_of_bill',
car.`make`,car.`condition`,category.`name`as'cat_name'
FROM `addresses` as address
JOIN `courses` as course ON address.`id`=course.`from_address_id`
JOIN `clients` as `client` ON course.`client_id`= `client`.`id`
JOIN `cars` as car ON car.`id`=course.`car_id`
JOIN `categories` as category ON category.`id`=car.`category_id`
WHERE address.`name` = `address_name` 
ORDER BY car.`make`,`client`.`full_name`;
END;
$$
