/*
Exercise 1
*/
SELECT emp.`employee_id`,emp.`job_title`,emp.`address_id`,a.`address_text`
FROM `employees` as emp 
JOIN `addresses` as a
ON emp.`address_id` = a.`address_id`
ORDER BY emp.`address_id` ASC
LIMIT 5;

/*
Exercise 2 
*/

SELECT emp.`first_name`,emp.`last_name`,town.`name`,address.`address_text`
FROM `employees` AS emp
JOIN `addresses` AS address ON address.`address_id`=emp.`address_id`
JOIN `towns` AS town ON address.`town_id`=town.`town_id`
ORDER BY `first_name` ASC,`last_name` ASC
LIMIT 5;

/*
Exercise 3
*/

SELECT emp.`employee_id`,emp.`first_name`,emp.`last_name`,dep.`name`
FROM `employees` AS emp
JOIN `departments` AS dep ON emp.`department_id`=dep.`department_id`
WHERE dep.`name`='Sales'
ORDER BY `employee_id` DESC;

/*
Exercise 4
*/

SELECT emp.`employee_id`, emp.`first_name`, emp.`salary`,dep.`name`
FROM `employees` AS emp
JOIN `departments` AS dep ON emp.`department_id`= dep.`department_id`
WHERE emp.`salary`>15000
ORDER BY emp.`department_id` DESC
LIMIT 5;

/*
Exercise 5
*/

SELECT `employee_id`,`first_name` 
FROM `employees`  
WHERE `employee_id` NOT IN (SELECT `employee_id` FROM `employees_projects`)
ORDER BY `employee_id` DESC
LIMIT 3;

/*
Exercise 6
*/

SELECT emp.`first_name`,emp.`last_name`,emp.`hire_date`,dep.`name`
FROM `employees` as emp
JOIN `departments` AS dep ON dep.`department_id`=emp.`department_id`
WHERE emp.`hire_date`>'1999-01-01' AND dep.`name`= 'Sales' OR dep.`name` = 'Finance'
ORDER BY emp.`hire_date`;

/*
Exercise 7
*/

SELECT emp.`employee_id`,emp.`first_name`,p.`name`
FROM `employees` AS `emp`
JOIN `employees_projects` AS ep ON emp.`employee_id`=ep.`employee_id`
JOIN `projects` AS p ON ep.`project_id` = p.`project_id`
WHERE DATE(p.`start_date`)>'2002-08-13' AND `end_date` IS NULL
ORDER BY emp.`first_name` ASC,p.`name`
LIMIT 5;

/*
Exercise 8
*/

SELECT emp.`employee_id`,emp.`first_name`,
(IF(YEAR(p.`start_date`)>='2005',NULL,p.`name`))
FROM `employees` AS `emp`
JOIN `employees_projects` AS ep ON emp.`employee_id`=ep.`employee_id`
JOIN `projects` AS p ON ep.`project_id` = p.`project_id`
WHERE ep.`employee_id`=24 
ORDER BY p.`name`;

/*
Exercise 9
*/

SELECT emp.`employee_id`,emp.`first_name`,m.`employee_id` , m.`first_name` AS `manager_name`
FROM `employees` as emp
JOIN `employees` AS m ON emp.`manager_id`= m.`employee_id`
WHERE emp.`manager_id` IN (3,7)
ORDER BY emp.`first_name` ASC;

/*
Exercise 10
*/

SELECT emp.`employee_id`,
CONCAT_WS(' ',emp.`first_name`,emp.`last_name`) AS 'employee_name',
CONCAT_WS(' ', men.`first_name`, men.`last_name`) AS 'manager_name',
dep.`name` AS 'department_name'

FROM `employees` AS emp
JOIN `employees` AS men ON emp.`manager_id` = men.`employee_id`
JOIN `departments` AS dep ON emp.`department_id` = dep.`department_id`
WHERE emp.`manager_id` IS NOT NULL
ORDER BY emp.`employee_id` ASC
LIMIT 5;

/*
Exercise 11
*/

SELECT AVG(emp.`salary`) AS 'min_average_salary'
FROM `employees` as emp
JOIN `departments` as dep ON emp.`department_id` = dep.`department_id`
GROUP BY `name`
ORDER BY `min_average_salary`
LIMIT 1;

/*
Exercise 12 
*/

SELECT c.`country_code`,m.`mountain_range`,p.`peak_name`,p.`elevation`
FROM `countries` AS c
JOIN `mountains_countries` AS mc ON c.`country_code`= mc.`country_code`
JOIN `mountains` AS m ON mc.`mountain_id` = m.`id`
JOIN `peaks` AS p ON  m.`id`=p.`mountain_id`
WHERE c.`country_code`='BG' AND p.`elevation`>2835
ORDER BY p.`elevation` DESC;

/*
Exercise 13
*/

 SELECT c.`country_code`,COUNT(c.`country_code`) AS 'mountain_range'
 FROM `countries` AS c
 JOIN `mountains_countries` AS mc ON c.`country_code`= mc.`country_code`
 JOIN `mountains` AS m ON mc.`mountain_id` = m.`id`
 WHERE c.`country_code` IN ('US','RU','BG')
 GROUP BY c.`country_code`
 ORDER BY `mountain_range` DESC;

/*
Exercise 14
*/

SELECT c.`country_name`,r.`river_name`
FROM `countries` AS c
LEFT JOIN `countries_rivers` AS cr ON c.`country_code`= cr.`country_code`
LEFT JOIN `rivers` AS r ON cr.`river_id` = r.`id`
WHERE c.`continent_code` IN ('AF')
ORDER BY `country_name` ASC
LIMIT 5;

/*
Exercise 15
*/

SELECT c1.`continent_code`,c1.`currency_code`,c1.`currency_usage`
FROM(
SELECT `c`.`continent_code`, `c`.`currency_code`,
    COUNT(`c`.`currency_code`) AS `currency_usage` FROM countries as c
	GROUP BY c.currency_code, c.continent_code 
    HAVING currency_usage > 1) as c1
    
    LEFT JOIN(
    SELECT `c`.`continent_code`, `c`.`currency_code`,
    COUNT(`c`.`currency_code`) AS `currency_usage` FROM countries as c
	GROUP BY c.currency_code, c.continent_code 
    HAVING currency_usage > 1) as c2 ON c1.continent_code = c2.continent_code AND c2.currency_usage > c1.currency_usage

    
    WHERE c2.currency_usage IS NULL
    ORDER BY c1.continent_code, c1.currency_code;

/*
Exercise 16
*/

SELECT COUNT(c.`country_code`) as 'country_count'
FROM `countries` as c
LEFT JOIN `mountains_countries` as m ON m.`country_code`=c.`country_code`
WHERE m.`mountain_id` IS NULL;

/*
Exercise 17
*/

SELECT `country_name`,MAX(p.`elevation`) AS 'highest_peak_elevation', MAX(r.`length`) AS 'longest_river_length'
FROM `countries` as c
LEFT JOIN `mountains_countries` as mc ON c.`country_code`=mc.`country_code`
LEFT JOIN `mountains` AS m ON m.`id`=mc.`mountain_id`
LEFT JOIN `countries_rivers` AS cr ON  c.`country_code`=cr.`country_code`
JOIN `rivers` AS r ON r.`id`=cr.`river_id`
JOIN `peaks` AS p ON m.`id`=p.`mountain_id`
GROUP BY `country_name`
ORDER BY `highest_peak_elevation` DESC,'longest_river_length' DESC, `country_name` ASC
LIMIT 5;