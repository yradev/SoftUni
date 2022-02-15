/*
Exercise 1
*/

INSERT INTO `travel_cards` (`card_number`,`job_during_journey`,`colonist_id`,`journey_id`)
SELECT(
(IF(
c.`birth_date`>'1980-01-01',
CONCAT_WS('',YEAR(c.`birth_date`),DAY(`birth_date`),LEFT(c.`ucn`,4)),
CONCAT_WS('',YEAR(c.`birth_date`),MONTH(`birth_date`),RIGHT(c.`ucn`,4)))
))AS 'card_number',
(CASE
WHEN c.`id`%2=0 THEN 'Pilot'
WHEN c.`id`%3=0 THEN 'Cook'
ELSE 'Engineer'
END
) AS 'job_during_journe',
c.`id`,SUBSTRING(c.`ucn`,1,1) AS 'journey_id'
FROM `colonists` as c
WHERE c.`id` BETWEEN 96 AND 100;

/*
Exercise 2
*/

UPDATE `journeys` 
SET purpose = 
CASE
WHEN id%2=0 THEN 'Medical'
WHEN id%3=0 THEN 'Technical'
WHEN id%5=0 THEN 'Educational'
WHEN id%7=0 THEN 'Military'
ELSE purpose
END;

/*
Exercise 3
*/

DELETE FROM `colonists` AS c WHERE c.`id` NOT IN (
SELECT `colonist_id` FROM `travel_cards`);


/*
Exercise 4
*/

SELECT `card_number`,`job_during_journeY`
FROM `travel_cards`
ORDER BY `card_number` ASC;

/*
Exercise 5
*/


SELECT `id`,CONCAT_WS(' ',`first_name`,`last_name`)AS'full_name',`ucn`
FROM `colonists`
ORDER BY `first_name`,`last_name`,`id`;

/*
Exercise 6
*/


SELECT `id`,`journey_start`,`journey_end`
FROM `journeys`
WHERE `purpose` = 'Military'
ORDER BY `journey_start`;

/*
Exercise 7
*/


SELECT `id`,CONCAT_WS(' ',`first_name`,`last_name`)AS'full_name'
FROM `colonists` as c 
WHERE c.`id` IN (
SELECT `colonist_id` FROM `travel_cards` WHERE `job_during_journey`='Pilot')
ORDER BY `id`;

/*
Exercise 8
*/


SELECT COUNT(`id`)
FROM `colonists` AS c
WHERE `id` IN ( 
SELECT `colonist_id` FROM `travel_cards` WHERE `journey_id` IN (
SELECT `id` FROM `journeys` WHERE `purpose` = 'Technical'));

/*
Exercise 9
*/


SELECT ss.`name` as 'spaceship_name' , sp.`name` as 'spaceport_name'
FROM `spaceports` as sp
JOIN `journeys` as j ON sp.`id`=j.`destination_spaceport_id` 
JOIN `spaceships` as ss ON j.`spaceship_id`=ss.`id` 
ORDER BY `light_speed_rate` DESC
LIMIT 1;

/*
Exercise 10
*/


SELECT ss.`name`,ss.`manufacturer`
FROM `spaceships` as ss
JOIN `journeys` as j ON ss.`id`=j.`spaceship_id`
JOIN `travel_cards` as t ON j.`id`=t.`journey_id`
JOIN `colonists` as c ON c.`id`=t.`colonist_id` 
WHERE t.`job_during_journey` = 'Pilot' AND c.`birth_date` > DATE_SUB('2019-01-01', INTERVAL 30 YEAR)
ORDER BY ss.`name`;

/*
Exercise 11
*/


SELECT p.`name` as 'planet_name', s.`name` as 'spaceport_name'
FROM `journeys` AS j
JOIN `spaceports` as s ON s.`id`=j.`destination_spaceport_id`
JOIN `planets` AS p ON s.`planet_id` = p.`id`
WHERE j.`purpose` = 'Educational'
ORDER BY `spaceport_name` DESC;

/*
Exercise 12
*/


SELECT p.`name` as 'planet_name', COUNT(s.`id`) as 'journeys_count'
FROM `planets` as p
JOIN `spaceports` as s ON p.`id`=s.`planet_id`
JOIN `journeys` as j ON s.`id` = j.`destination_spaceport_id`
GROUP BY s.`planet_id`
ORDER BY `journeys_count` DESC, `planet_name` ASC;

/*
Exercise 13
*/


SELECT j.`id`,p.`name` AS 'planet_name', s.`name` AS 'spaceport_name', j.`purpose` AS 'journey_purpose'
FROM `journeys` AS j
JOIN `spaceports` AS s ON j.`destination_spaceport_id` = s.`id`
JOIN `planets` AS p ON p.`id` = s.`planet_id`
ORDER BY DATEDIFF(j.journey_end, j.journey_start)
LIMIT 1;

/*
Exercise 14
*/


SELECT tc.`job_during_journey` as 'job_name'
FROM `journeys` AS j
JOIN `travel_cards` AS tc on j.`id`= tc.`journey_id`
WHERE tc.`job_during_journey` = (SELECT `job_during_journey` GROUP by `colonist_id` ORDER BY `colonist_id` LIMIT 1)
ORDER BY DATEDIFF(j.`journey_end`, j.`journey_start`) DESC
LIMIT 1;

/*
Exercise 15
*/



DELIMITER $$
CREATE FUNCTION `udf_count_colonists_by_destination_planet` (`planet_name` VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN 
(SELECT COUNT(t.`colonist_id`)
FROM `planets` as pl
JOIN `spaceports` AS sp ON pl.`id` = sp.`planet_id`
JOIN `journeys` as j ON j.`destination_spaceport_id` = sp.`id` 
JOIN `travel_cards` AS t ON `journey_id` = j.`id`
WHERE pl.`name` = `planet_name`);
END;
$$

/*
Exercise 16
*/


DELIMITER ##

CREATE PROCEDURE `udp_modify_spaceship_light_speed_rate`(`spaceship_name` VARCHAR(50), `light_speed_rate_increse` INT(11))
BEGIN
START TRANSACTION;
IF(SELECT COUNT(`name`) FROM `spaceships` where `name` = `spaceship_name`) = 0 THEN
SIGNAL SQLSTATE '45000'
SET MESSAGE_TEXT = 'Spaceship you are trying to modify does not exists.';
ROLLBACK;
ELSE
UPDATE `spaceships` SET `light_speed_rate` = `light_speed_rate` + `light_speed_rate_increse` WHERE `name` = `spaceship_name`;
END IF;
END;

##