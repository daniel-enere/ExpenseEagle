CREATE TABLE account (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
institution VARCHAR(50) NOT NULL,
type ENUM('credit', 'savings','checking','cash') NOT NULL,
number VARCHAR(10) NOT NULL
) AUTO_INCREMENT = 101;


######################################################################################################################################
CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
) AUTO_INCREMENT = 201;

    
######################################################################################################################################
CREATE TABLE subcategory (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(100) NOT NULL
) AUTO_INCREMENT = 251;



######################################################################################################################################

CREATE TABLE category_subcategory (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category_id INT NOT NULL,
    subcategory_id INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id),
    FOREIGN KEY (subcategory_id) REFERENCES subcategory(id)
) AUTO_INCREMENT = 301;


######################################################################################################################################
CREATE TABLE transaction (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    category_subcategory_id INT NOT NULL,
    type ENUM('expense', 'income','adjustment', 'other') NOT NULL,
    date BIGINT NOT NULL,
    entry_date BIGINT NOT NULL,
    FOREIGN KEY (account_id) REFERENCES account(id),
    FOREIGN KEY (category_subcategory_id) REFERENCES category_subcategory(id)
) AUTO_INCREMENT = 1000;

