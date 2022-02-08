/*
Exersice 1
*/

SELECT COUNT(`id`) FROM `wizzard_deposits`;

/*
Exersice 2
*/

SELECT MAX(`magic_wand_size`) AS 'longest_magic_wand' FROM `wizzard_deposits`; 

/*
Exersice 3
*/

SELECT `deposit_group`, MAX(`magic_wand_size`) AS 'longest_magic_wand'
 FROM `wizzard_deposits` 
 GROUP BY `deposit_group` 
 ORDER BY `longest_magic_wand` ASC, `deposit_group` ASC; 
  		
/*
 Exersice 4
 */         

SELECT `deposit_group` FROM `wizzard_deposits` 
 GROUP BY `deposit_group`
 ORDER BY MIN(`magic_wand_size`) ASC 
 LIMIT 1;
 
 /*
 Exersice 5
 */         

SELECT `deposit_group`,SUM(`deposit_amount`) AS 'total_sum' 
FROM `wizzard_deposits` 
GROUP BY `deposit_group`
ORDER BY `total_sum` ASC;

 /*
 Exersice 6
 */         

SELECT `deposit_group`,SUM(`deposit_amount`) AS 'total_sum' 
FROM `wizzard_deposits` 
WHERE `magic_wand_creator` = 'Ollivander Family'
GROUP BY `deposit_group`
ORDER BY `deposit_group` ASC;

 /*
 Exersice 7
 */     

SELECT `deposit_group`,SUM(`deposit_amount`) AS 'total_sum' 
 FROM `wizzard_deposits` 
 WHERE `magic_wand_creator` = 'Ollivander Family'
 GROUP BY `deposit_group`
 HAVING `total_sum`<150000
 ORDER BY `total_sum` DESC;
 
  /*
 Exersice 8
 */     
 
 SELECT `deposit_group`,`magic_wand_creator`,MIN(`deposit_charge`)
 FROM `wizzard_deposits` 
 GROUP BY `deposit_group`, `magic_wand_creator`
 ORDER BY `magic_wand_creator`,`deposit_group`;
 
  /*
 Exersice 9
 */  
 
 SELECT
 CASE
 WHEN `age`>=0 AND `age` <=10 THEN '[0-10]'
 WHEN `age`>=11 AND `age` <=20 THEN '[11-20]'
 WHEN `age`>=21 AND `age` <=30 THEN '[21-30]'
 WHEN `age`>=31 AND `age` <=40 THEN '[31-40]'
 WHEN `age`>=41 AND `age` <=50 THEN '[41-50]'
 WHEN `age`>=51 AND `age` <=60 THEN '[51-60]'
 ELSE '[61+]' 
 END AS 'age_group',
 
 COUNT(`id`) as `wizard_count`
 FROM `wizzard_deposits`
 GROUP BY `age_group`
 ORDER BY `wizard_count` ASC;
 
  /*
 Exersice 10
 */  
 

SELECT SUBSTRING(`first_name`,1,1) AS 'first_letter'
FROM `wizzard_deposits`
 WHERE `deposit_group` = 'Troll Chest'
 GROUP BY `first_letter` 
 ORDER BY `first_letter`;
 
 /*
 Exersice 11
 */  
 
SELECT `deposit_group`,`is_deposit_expired`,AVG(deposit_interest) AS 'average_interest'
FROM `wizzard_deposits` WHERE `deposit_start_date`>'1985-01-01'
GROUP BY `deposit_group`,`is_deposit_expired`
ORDER BY `deposit_group` DESC,`is_deposit_expired` ASC;

/*
 Exersice 12
 */  

SELECT `department_id`,MIN(`salary`) AS 'minimum_salary' 
FROM `employees`
WHERE `department_id` IN (2,5,7) 
GROUP BY `department_id`;

/*
 Exersice 13
 */  

CREATE TABLE `highPeidEmployeesTable` AS SELECT *
FROM `employees`
WHERE `salary`>30000;

DELETE FROM `highPeidEmployeesTable` WHERE `manager_id` = 42;

UPDATE `highPeidEmployeesTable` SET salary=salary+5000 WHERE `department_id`=1;

SELECT `departmEnt_id`,AVG(`salary`) AS 'avg_salary'
FROM `highPeidEmployeesTable`
GROUP BY `department_id`
ORDER BY `department_id` ASC;

/*
 Exersice 14
 */  

SELECT `department_id`,MAX(`salary`) AS 'max_salary'
FROM `employees`
GROUP BY `department_id`
HAVING NOT `max_salary` BETWEEN 30000 AND 70000
ORDER BY `department_id` ASC;

/*
 Exersice 15
 */  
 

SELECT COUNT(`employee_id`) AS 'Count' 
FROM `employees` 
WHERE `manager_id` IS NULL;

/*
 Exersice 16
 */  
 
SELECT `department_id`,
(
SELECT DISTINCT `salary` 
FROM `employees` as b
WHERE a.`department_id`=b.`department_id`
ORDER BY `salary` DESC
LIMIT 1 OFFSET 2
) AS 'third_highest_salary'
FROM `employees` AS a
GROUP BY `department_id`
HAVING `third_highest_salary` IS NOT NULL
ORDER BY `department_id`;

/*
 Exersice 17
 */

SELECT `first_name`,`last_name`,`department_id`
FROM `employees` AS a
WHERE `salary`>(SELECT AVG(`salary`) FROM `employees` AS b WHERE a.`department_id`=b.`department_id`)
ORDER BY department_id, employee_id
LIMIT 10;

/*
 Exersice 18
 */

SELECT `department_id`, SUM(`salary`) as 'total_sum'
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;