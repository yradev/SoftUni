/*
Exercise 2
*/


INSERT INTO `reviews` (`content`,`rating`,`picture_url`,`published_at`)
(SELECT 
(
SELECT SUBSTRING(`description`,1,15)
)as 'content',
(
`price`/8
)as 'rating',
(SELECT REVERSE(`name`)
),
'2010-10-10' as `published_at`
FROM `products` as p
WHERE `id`>=5
);

/*
Exercise 3
*/

UPDATE `products` SET `quantity_in_stock` = `quantity_in_stock` - 5 WHERE `quantity_in_stock` BETWEEN 60 AND 70;

/*
Exercise 4
*/

DELETE FROM `customers` AS c WHERE c.`id` NOT IN (SELECT `customer_id` FROM `orders`) ;

/*
Exercise 5
*/

SELECT `id`,`name`
FROM `categories`
ORDER BY `name` DESC;

/*
Exercise 6
*/

SELECT p.`id`,b.`id`,p.`name`,p.`quantity_in_stock`
FROM `products` as p
JOIN `brands` as b ON p.`brand_id`=b.`id`
WHERE p.`price`>1000 AND p.`quantity_in_stock` < 30
ORDER BY p.`quantity_in_stock`,p.`id`;

/*
Exercise 7
*/

SELECT *
FROM `reviews`
WHERE SUBSTRING(`content`,1,2) = 'MY' AND char_length(`content`) > 61
ORDER BY `rating` DESC;

/*
Exercise 8
*/

SELECT CONCAT_WS(' ',c.`first_name`,c.`last_name`) as 'full_name',c.`address`,o.`order_datetime`
 FROM `customers` as c
 JOIN `orders` as o ON o.`customer_id`=c.`id`
 WHERE YEAR(o.order_datetime)<=2018
 ORDER BY `full_name` DESC;
 
 /*
Exercise 9
*/

SELECT COUNT(c.`id`) AS 'items_count',c.`name`,SUM(`quantity_in_stock`) AS 'total_quantity'
FROM `categories` as c
JOIN `products` as p ON p.`category_id` = c.`id`
GROUP BY p.`category_id`
ORDER BY `items_count` DESC, `total_quantity` ASC
LIMIT 5;

/*
Exercise 10
*/

DELIMITER $$
CREATE FUNCTION `udf_customer_products_count`(`name` VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (
SELECT COUNT(op.`product_id`)
FROM `customers` as c
JOIN `orders`as o ON o.`customer_id` = c.`id`
JOIN `orders_products` AS op ON op.`order_id`= o.`id` 
WHERE c.`first_name` = `name`
);
END
$$

/*
Exercise 11
*/
CREATE PROCEDURE `udp_reduce_price`(`category_name` VARCHAR(50))
BEGIN

UPDATE `products` SET price = price-(price*0.3) WHERE review_id IN (SELECT `id` FROM `reviews` WHERE `rating`<4) AND category_id IN (SELECT `id` FROM `categories` WHERE `name` = `category_name`);

SELECT * 
FROM `products`
WHERE `category_id` IN (SELECT `id` FROM `categories` WHERE `name` = `category_name`);
END
$$
