create table IF NOT EXISTS `customer`(
  `customer_id` int AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `mobile_number` varchar(20) NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `created_at` date NOT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_at` date DEFAULT NULL
);

create table IF NOT EXISTS `accounts`(
  `customer_id` int ,
  `account_number` int AUTO_INCREMENT PRIMARY KEY,
  `account_type` varchar(20) NOT NULL,
  `branch_address` varchar(100) NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `created_at` date NOT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_at` date DEFAULT NULL
);

