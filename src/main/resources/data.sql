-------- insert country values ----------
 INSERT INTO `foodydb`.`country` (`id`, `name`, `phone_code`) VALUES ('1', 'US', '+1');

 -------- insert state values --------
 INSERT INTO `foodydb`.`state` (`id`, `abbreviation`, `name`, `country_id`) VALUES (1, 'GA', 'Georgia', 1);
 INSERT INTO `foodydb`.`state` (`id`, `abbreviation`, `name`, `country_id`) VALUES (2, 'TX', 'Texas', 1);
 INSERT INTO `foodydb`.`state` (`id`, `abbreviation`, `name`, `country_id`) VALUES (3, 'OH', 'Ohio', 1);
 INSERT INTO `foodydb`.`state` (`id`, `abbreviation`, `name`, `country_id`) VALUES (4, 'CA', 'California', 1);

-------- insert city values ----------
 INSERT INTO `foodydb`.`city` (`id`, `name`, `zip_code`,`state_id`) VALUES (1, 'Riverdale', '30274', 1);
 INSERT INTO `foodydb`.`city` (`id`, `name`, `zip_code`,`state_id`) VALUES (2, 'Austin', '78758', 2);
 INSERT INTO `foodydb`.`city` (`id`, `name`, `zip_code`,`state_id`) VALUES (3, 'Milford', '45067', 3);
 INSERT INTO `foodydb`.`city` (`id`, `name`, `zip_code`,`state_id`) VALUES (4, 'Santa Clara', '95050', 4);
 INSERT INTO `foodydb`.`city` (`id`, `name`, `zip_code`,`state_id`) VALUES (5, 'Morrow', '30260', 1);


-------- insert food type join table ----------
INSERT INTO `foodydb`.`restaurant_food_type` ( `restaurant_id`, `food_id`) VALUES (1, 1);
INSERT INTO `foodydb`.`restaurant_food_type` ( `restaurant_id`, `food_id`) VALUES (1, 3);
INSERT INTO `foodydb`.`restaurant_food_type` ( `restaurant_id`, `food_id`) VALUES (2, 4);

-------- insert restaurant type join table ----------
INSERT INTO `foodydb`.`restaurant_restaurant_type` ( `restaurant_id`, `type_id`) VALUES (1, 1);
INSERT INTO `foodydb`.`restaurant_restaurant_type` ( `restaurant_id`, `type_id`) VALUES (2, 3);


-------- insert food type table ----------
INSERT INTO `foodydb`.`food_type` VALUES (1, 'BBQ/Steak');
INSERT INTO `foodydb`.`food_type` VALUES (2, 'Coffee');
INSERT INTO `foodydb`.`food_type` VALUES (3, 'Desert');
INSERT INTO `foodydb`.`food_type` VALUES (4, 'Boba');
INSERT INTO `foodydb`.`food_type` VALUES (5, 'Noodle/Ramen');
INSERT INTO `foodydb`.`food_type` VALUES (6, 'Fastfood');
INSERT INTO `foodydb`.`food_type` VALUES (7, 'Boba');

-------- insert Restaurant type table ----------
INSERT INTO `foodydb`.`restaurant_type` VALUES (1, 'Vietnamese');
INSERT INTO `foodydb`.`restaurant_type` VALUES (2, 'Asian');
INSERT INTO `foodydb`.`restaurant_type` VALUES (3, 'Mediterranean');
INSERT INTO `foodydb`.`restaurant_type` VALUES (4, 'Mexican');
INSERT INTO `foodydb`.`restaurant_type` VALUES (5, 'American');

-------- insert Role table ----------
INSERT INTO `foodydb`.`role` VALUES (1, 'Admin');
INSERT INTO `foodydb`.`role` VALUES (2, 'User');

-------- insert Restaurant table ----------
INSERT INTO `foodydb`.`restaurant` VALUES (1, '246 Heathrow dr Riverdale, GA 30274', 'pho@gmail.com', 33.571369, -84.398567,'Pho VN', '43412343241');
INSERT INTO `foodydb`.`restaurant` VALUES (2, '7050 Highway 85, Riverdale, GA 30274', 'crawfish@gmail.com', 33.56363, -84.41098, 'Crawfish Restaurant', '404432432');


-------- Procedure to add new review ----------
CREATE PROCEDURE `AddReview`(IN cleanliness INT, IN customer_service INT, IN deliver INT, IN taste INT, IN comment_str varchar(200), IN restaurant_id  INT, IN user_id INT)
BEGIN
	DECLARE isUserExist int;
    DECLARE isRestaurantExist int;
    SET isUserExist = 0;
    SET isRestaurantExist = 0;
    SELECT count(*) INTO isUserExist from `foodydb`.`user` WHERE id = user_id;
	SELECT count(*) INTO isRestaurantExist from `foodydb`.`restaurant` WHERE id = restaurant_id;
    IF(isUserExist>0 AND isRestaurantExist>0) THEN
		INSERT INTO `foodydb`.`review`(`cleanliness`, `comment`, `customer_service`, `deliver`, `taste`,`restaurant_id`,`user_id`)
        VALUES
        (cleanliness, comment_str, customer_service, deliver,taste,restaurant_id,user_id);
	END IF;
END

