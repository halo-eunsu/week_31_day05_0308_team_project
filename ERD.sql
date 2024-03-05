CREATE TABLE `Users` (
	`user_id`	varchar(50)	NOT NULL,
	`user_name`	varchar(50)	NOT NULL,
	`user_password`	varchar(200)	NOT NULL,
	`user_birth`	varchar(8)	NOT NULL,
	`user_auth`	varchar(10)	NOT NULL,
	`user_point`	int	NOT NULL	DEFAULT 1000000,
	`created_at`	datetime	NOT NULL,
	`latest_login_at`	datetime	NULL	DEFAULT null
);
ALTER TABLE `Products` DROP FOREIGN KEY `fk_Products_Categories`;
ALTER TABLE `ProductCategories` DROP FOREIGN KEY `ProductCategories_ibfk_2`;
describe Categories;
DROP TABLE if exists Categories;
CREATE TABLE `Categories` (
	`CategoryID`	INT auto_increment	NOT NULL,
	`CategoryName`	varchar(50)	NULL,
    PRIMARY KEY (CategoryID)
);
describe Products;

CREATE TABLE `Products` (
	`ProductID`	int auto_increment	NOT NULL,
	`ModelNumber`	nvarchar(10)	NULL,
	`ModelName`	nvarchar(120)	NULL,
	`ProductImage`	nvarchar(30)	NULL,
	`UnitCost`	decimal(15)	NULL,
	`Description`	text	NULL
);
drop table if exists Reviews;
# CREATE TABLE `Reviews` (
# 	`ReviewID`	int	NOT NULL,
# 	`UserId`	varchar(50)	NOT NULL,
# 	`ProductID`	int auto_increment	NOT NULL,
# 	`Rating`	int	NULL,
# 	`Comments`	text	NULL
# );
ALTER TABLE OrderDetails DROP FOREIGN KEY OrderDetails_ibfk_2;
drop table if exists Orders;
CREATE TABLE `Orders` (
	`OrderID`	int	NOT NULL,
	`UserId`	varchar(50)	NOT NULL,
	`OrderDate`	datetime	NULL,
	`ShipDate`	datetime	NULL,
    PRIMARY KEY (OrderID),
    FOREIGN KEY (UserId) REFERENCES Users(user_id)
);
# drop table if exists OrderDetails;
# CREATE TABLE `OrderDetails` (
# 	`OrderDetailID`	VARCHAR(255)	NOT NULL,
# 	`Quantity`	int	NULL,
# 	`OrderID`	int	NOT NULL,
# 	`ProductID`	int auto_increment	NOT NULL
# );
ALTER TABLE `Users` ADD INDEX (user_id);
CREATE TABLE `Reviews` (
                           `ReviewID`	int	NOT NULL auto_increment,
                           `UserId`	varchar(50)	NOT NULL,
                           `ProductID`	int	NOT NULL,
                           `Rating`	int	NULL,
                           `Comments`	text	NULL,
                           PRIMARY KEY (`ReviewID`),
                           FOREIGN KEY (`ProductID`) REFERENCES `Products` (`ProductID`),
                           FOREIGN KEY (`UserId`) REFERENCES `Users` (user_id)
);
CREATE TABLE `OrderDetails` (
                                `OrderDetailID`	VARCHAR(255)	NOT NULL,
                                `Quantity`	int	NULL,
                                `OrderID`	int	NOT NULL,
                                `ProductID`	int	NOT NULL,
                                PRIMARY KEY (`OrderDetailID`),
                                FOREIGN KEY (`ProductID`) REFERENCES `Products` (`ProductID`),
                                FOREIGN KEY (`OrderID`) REFERENCES `Orders` (`OrderID`)
);
CREATE TABLE `ProductCategories` (
                                     `ProductID`	int	NOT NULL,
                                     `CategoryID`	INT	NOT NULL,
                                     PRIMARY KEY (`ProductID`, `CategoryID`),
                                     FOREIGN KEY (`ProductID`) REFERENCES `Products` (`ProductID`),
                                     FOREIGN KEY (`CategoryID`) REFERENCES `Categories` (`CategoryID`)
);
drop table if exists ShoppingCart;
CREATE TABLE `ShoppingCart`
(
    `CartID`  int auto_increment NOT NULL,
    `user_id` varchar(50)        NOT NULL,
    PRIMARY KEY (`CartID`)
);
drop table if exists Product;
CREATE TABLE `Product`
(
    `ProductID` int auto_increment NOT NULL,
    PRIMARY KEY (`ProductID`)
);
drop table if exists CartProduct;
CREATE TABLE `CartProduct`
(
    `CartID`    int NOT NULL,
    `ProductID` int NOT NULL,
    `Quantity`  int NOT NULL,
    PRIMARY KEY (`CartID`, `ProductID`),
    FOREIGN KEY (`CartID`) REFERENCES `ShoppingCart` (`CartID`),
    FOREIGN KEY (`ProductID`) REFERENCES `Product` (`ProductID`)
);
drop table if exists Address;
CREATE TABLE `Address` (
	`AddressID`	int auto_increment	NOT NULL,
	`Address1`	text	NULL,
	`user_id`	varchar(50)	NOT NULL,
	`Address2`	text	NULL,
    PRIMARY KEY (AddressID)
);
drop table if exists ProductCategories;
CREATE TABLE `ProductCategories` (
	`ProductID`	int	NOT NULL,
	`CategoryID`	int	NOT NULL,
    PRIMARY KEY (ProductID, CategoryID)
);

ALTER TABLE `Users` ADD CONSTRAINT `PK_USERS` PRIMARY KEY (
	`user_id`
);

ALTER TABLE `Categories` ADD CONSTRAINT `PK_CATEGORIES` PRIMARY KEY (
	`CategoryID`
);

ALTER TABLE `Products` ADD CONSTRAINT `PK_PRODUCTS` PRIMARY KEY (
	`ProductID`
);

ALTER TABLE `Reviews` ADD CONSTRAINT `PK_REVIEWS` PRIMARY KEY (
	`ReviewID`
);

ALTER TABLE `Orders` ADD CONSTRAINT `PK_ORDERS` PRIMARY KEY (
	`OrderID`
);

ALTER TABLE `OrderDetails` ADD CONSTRAINT `PK_ORDERDETAILS` PRIMARY KEY (
	`OrderDetailID`
);

ALTER TABLE `ShoppingCart` ADD CONSTRAINT `PK_SHOPPINGCART` PRIMARY KEY (
	`CartID`
);

ALTER TABLE `Address` ADD CONSTRAINT `PK_ADDRESS` PRIMARY KEY (
	`AddressID`
);

ALTER TABLE `ProductCategories` ADD CONSTRAINT `PK_PRODUCTCATEGORIES` PRIMARY KEY (
	`ProductID`,
	`CategoryID`
);

ALTER TABLE `ProductCategories` ADD CONSTRAINT `FK_Products_TO_ProductCategories_1` FOREIGN KEY (
	`ProductID`
)
REFERENCES `Products` (
	`ProductID`
);

ALTER TABLE `ProductCategories` ADD CONSTRAINT `FK_Categories_TO_ProductCategories_1` FOREIGN KEY (
	`CategoryID`
)
REFERENCES `Categories` (
	`CategoryID`
);

