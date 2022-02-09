/*
Exercise 1
*/

DELIMITER ##
CREATE PROCEDURE `usp_get_employees_salary_above_35000`()
BEGIN
SELECT `first_name`,`last_name`
FROM `employees`
WHERE `salary`> 35000
ORDER BY `first_name`,`last_name`,`employee_id`;
END;
##

/*
Exercise 2
*/

DELIMITER ##
CREATE PROCEDURE `usp_get_employees_salary_above`(`inputNumber` DECIMAL(15,4))
BEGIN
SELECT `first_name`,`last_name`
FROM `employees`
WHERE `salary`>= `inputNumber`
ORDER BY `first_name`,`last_name`,`employee_id`;
END
##

/*
Exercise 3
*/

DELIMITER ##
CREATE PROCEDURE `usp_get_towns_starting_with`(`input` VARCHAR(100))
BEGIN
SELECT `name`
FROM `towns`
WHERE LEFT(`name`,char_length(`input`))=`input`
ORDER BY `name`;
END
##

/*
Exercise 4
*/

DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(`input` VARCHAR(100))
BEGIN
SELECT emp.`first_name`,emp.`last_name`
FROM `employees` AS emp
JOIN `addresses` AS ad ON emp.`address_id`=ad.`address_id`
JOIN `towns` AS t  ON ad.`town_id` = t.`town_id`
WHERE t.`name`=`input`
ORDER BY emp.`first_name`,emp.`last_name`;
END
$$

/*
Exercise 5
*/

DELIMITER $$
CREATE FUNCTION `ufn_get_salary_level`(`input` DECIMAL(15,2))
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
RETURN
( 
CASE
WHEN `input`< 30000 THEN 'Low'
WHEN `input` BETWEEN 30000 AND 50000 THEN 'Average'
WHEN `input`> 50000 THEN 'High'
END);
END;
$$

/*
Exercise 6
*/

DELIMITER ##
CREATE PROCEDURE `usp_get_employees_by_salary_level`(`levelOfSalary` VARCHAR(100))
BEGIN
SELECT `first_name`,`last_name` 
FROM `employees`
WHERE (
CASE
WHEN `levelOfSalary`='low' THEN `salary`<30000
WHEN `levelOfSalary`='average' THEN `salary` BETWEEN 30000 AND 50000
WHEN `levelOfSalary`='high' THEN `salary`>50000
END
)

ORDER BY `first_name` DESC,`last_name` DESC;
END;
##

/*
Exercise 7
*/


CREATE FUNCTION `ufn_is_word_comprised`(`set_of_letters` varchar(50), `word` varchar(50))
RETURNS INT
DETERMINISTIC
BEGIN

DECLARE `RESULT` INT DEFAULT 1;
DECLARE `curr_charPos` INT DEFAULT 1;
DECLARE `curr_char` VARCHAR(1);

WHILE curr_charPos <= CHAR_LENGTH(`word`) DO
SET curr_char = SUBSTRING(`word`,`curr_charPos`,1);
IF LOCATE(`curr_char`,`set_of_letters`)=0 THEN SET RESULT = 0;
END IF;
SET `curr_charPos` = `curr_charPos` + 1;
END WHILE;
RETURN `RESULT`;
END

/*
Exercise 8
*/

DELIMITER ##
CREATE PROCEDURE`usp_get_holders_full_name`()
BEGIN
SELECT CONCAT_WS(' ',`first_name`,`last_name`) as 'full_name' FROM `account_holders` ORDER BY ``;
END;
##

/*
Exercise 10
*/

DELIMITER ##
CREATE FUNCTION `ufn_calculate_future_value` (`sum` DECIMAL(20,4), `interest` DOUBLE,`years` INT)
RETURNS DECIMAL (19,4)
DETERMINISTIC
BEGIN
RETURN `sum`*pow(1+`interest`,`years`);
END
##

/*
Exercise 11
*/

DELIMITER ##

CREATE PROCEDURE `usp_calculate_future_value_for_account`(`inputId` INT,`interest` DECIMAL (20,4))
BEGIN
SELECT acc.`id`,h.`first_name`,h.`last_name`,acc.`balance`,ufn_calculate_future_value(`balance`,`interest`,5)
FROM `accounts` as acc
JOIN `account_holders` AS h ON acc.`account_holder_id`=h.`id` 
WHERE acc.`id`=`inputId`;
END
##

/*
Exercise 12
*/

DELIMITER $$

CREATE PROCEDURE`usp_deposit_money`(`accID` INT,`money_amount` DECIMAL(20,4))
BEGIN
START TRANSACTION;
IF (`money_amount` <= 0 OR (SELECT COUNT(*) FROM `accounts` AS a WHERE `accid` = a.`id`) = 0 ) THEN ROLLBACK;
ELSE UPDATE `accounts` SET `balance`=`balance`+`money_amount` WHERE `id`=`accID`;
END IF;
END;
$$

/*
Exercise 13
*/


DELIMITER ##
CREATE PROCEDURE `usp_withdraw_money`(`accId` INT,`money_amount` DECIMAL(20,4))
BEGIN
START TRANSACTION;

IF(
`money_amount`<=0 OR 
(SELECT COUNT(*) FROM `accounts` AS a WHERE `accid` = a.`id`) = 0 OR
(SELECT `balance` FROM `accounts` AS a WHERE `accid` = a.`id`)< `money_amount` 
) THEN ROLLBACK;
ELSE UPDATE `accounts` SET `balance`=`balance`-`money_amount` WHERE `id`=`accID`;
END IF;
END;
##

/*
Exercise 14
*/

DELIMITER $$
CREATE PROCEDURE `usp_transfer_money`(`from_account_id` INT,`to_account_id` INT,`amount` DECIMAL(20,4))
BEGIN
START TRANSACTION;
IF(
`amount`<=0 OR 
(SELECT COUNT(*) FROM `accounts` AS a WHERE `to_account_id` = a.`id`) = 0 OR
(SELECT COUNT(*) FROM `accounts` AS a WHERE `from_account_id` = a.`id`) = 0 OR
(SELECT `balance` FROM `accounts` AS a WHERE `from_account_id` = a.`id`)< `amount` 
)  THEN ROLLBACK;
ELSE 
UPDATE `accounts` SET `balance`=`balance`-`amount` WHERE `id` = `from_account_id`;
UPDATE `accounts` SET `balance`=`balance`+`amount` WHERE `id`=`to_account_id`;
END IF;
END;
$$