/*
Exercise 1
 */

SELECT `first_name`,`last_name` FROM `employees` WHERE `first_name` LIKE 'Sa%' ORDER BY `employee_id`;

/*
Exercise 2
 */
 
 SELECT `first_name`,`last_name` FROM `employees` WHERE LOCATE('ei',`last_name`)>0 ORDER BY `employee_id`; 

 /*
Exercise 3
 */
 
 SELECT `first_name` FROM `employees` WHERE `department_id` IN (3,10) AND YEAR(`hire_date`) BETWEEN 1995 AND 2005 ORDER BY `employee_id`;
 
 /*
Exercise 4
 */
 
 SELECT `first_name`,`last_name` FROM `employees` WHERE LOCATE('engineer',`job_title`)=0;
 
 /*
Exercise 5
 */
 
 SELECT `name` FROM `towns` WHERE CHAR_LENGTH(`name`)=5 OR CHAR_LENGTH(`name`)=6 ORDER BY `name` ASC;
 
 /*
Exercise 6
 */
 
 SELECT `town_id`,`name` FROM `towns` WHERE `name` LIKE 'M%' OR `name` LIKE 'K%' OR `name` LIKE 'B%' OR `name` LIKE 'E%' ORDER BY `name`;
 
 /*
Exercise 7
 */

SELECT `town_id`,`name` FROM `towns` WHERE LEFT(`name`,1) NOT IN ('R','B','D') ORDER BY `name`;

/*
Exercise 8
 */
 
 CREATE VIEW `v_employees_hired_after_2000` AS SELECT `first_name`,`last_name` FROM `employees` WHERE YEAR(hire_date)>2000;
 
 /*
Exercise 9
 */
 
 SELECT `first_name`,`last_name` FROM `employees` WHERE CHAR_LENGTH(`last_name`)=5;
 
 /*
Exercise 10
 */
 
 SELECT `country_name`,`iso_code` FROM `countries` WHERE `country_name` LIKE '%A%A%A%' ORDER BY `iso_code`;
 
 /*
Exercise 11
 */
 
 SELECT a.`peak_name`,b.`river_name`,LOWER(CONCAT_WS('',a.`peak_name`,SUBSTRING(b.`river_name`,2))) AS 'mix' 
 FROM `peaks` as a 
JOIN `rivers` AS b 
WHERE RIGHT(a.`peak_name`,1)=LEFT(b.`river_name`,1)
ORDER BY mix;
 
 /*
Exercise 12
 */
 
 SELECT `name`,DATE_FORMAT(`start`,'%Y-%m-%d')FROM `games` WHERE YEAR(`start`) IN (2011,2012) ORDER BY `start` LIMIT 50;
 
 /*
Exercise 13
 */
 
 SELECT `user_name`,SUBSTRING(`email`,LOCATE('@',`email`)+1) AS 'Email Provider' FROM `users` ORDER BY `Email Provider` ASC,`user_name` ASC;
 
 /*
Exercise 14
 */
 
 SELECT `user_name`,`ip_address` FROM `users` WHERE `ip_address` LIKE '___.1%.%.___'  ORDER BY `user_name`;

/*
Exercise 15
 */
--  
 SELECT `name`,
 CASE
  WHEN HOUR(`start`)<12 THEN 'Morning'
  WHEN HOUR(`start`)>=12 AND HOUR(`start`)<18 THEN 'Afternoon'
  WHEN HOUR(`start`)>=18 AND HOUR(`start`)<24 THEN 'Evening'
 END as 'Part of the day',

 CASE
  WHEN `duration`<=3 THEN 'Extra Short'
  WHEN `duration`>3 AND `duration`<=6 THEN 'Short'
  WHEN `duration`>6 AND `duration`<=10 THEN 'Long'
ELSE 'Extra Long'
END AS 'Duration'
FROM `games`;

/*
Exercise 16
 */
 
  SELECT `product_name`,`order_date`,
  DATE_ADD(`order_date`, INTERVAL 3 DAY) as 'pay_due' ,
  DATE_ADD(`order_date`, INTERVAL 1 MONTH) as `deliver_due` 
  FROM `orders`;
