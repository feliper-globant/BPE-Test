DROP TABLE IF EXISTS `mydb`.`Person` ;

CREATE TABLE
    IF NOT EXISTS `mydb`.`Person` (
        `id` INT NOT NULL,
        `name` VARCHAR(45) NULL,
        `gender` VARCHAR(45) NULL,
        `age` INT NULL,
        `phone` VARCHAR(45) NULL,
        PRIMARY KEY (`id`)
    );

DROP TABLE IF EXISTS `mydb`.`Client` ;

CREATE TABLE
    IF NOT EXISTS `mydb`.`Client` (
        `client_id` VARCHAR(36) NOT NULL,
        `password` VARCHAR(64) NULL,
        `state` VARCHAR(45) NULL,
        `Person_id` INT NOT NULL,
        PRIMARY KEY (`client_id`),
        INDEX `fk_Client_Person_idx` (`Person_id` ASC) VISIBLE,
        CONSTRAINT `fk_Client_Person` FOREIGN KEY (`Person_id`) REFERENCES `mydb`.`Person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
    );

DROP TABLE IF EXISTS `mydb`.`Account` ;

CREATE TABLE
    IF NOT EXISTS `mydb`.`Account` (
        `number` INT NOT NULL,
        `type` VARCHAR(45) NULL,
        `balance` DOUBLE NULL,
        `state` VARCHAR(45) NULL,
        `Client_client_id` VARCHAR(36) NOT NULL,
        PRIMARY KEY (`number`),
        INDEX `fk_Account_Client1_idx` (`Client_client_id` ASC) VISIBLE,
        CONSTRAINT `fk_Account_Client1` FOREIGN KEY (`Client_client_id`) REFERENCES `mydb`.`Client` (`client_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
    );

DROP TABLE IF EXISTS `mydb`.`Transaction` ;

CREATE TABLE
    IF NOT EXISTS `mydb`.`Transaction` (
        `id` VARCHAR(50) NOT NULL,
        `number` INT NULL,
        `date` DATE NULL,
        `type` VARCHAR(45) NULL,
        `value` DOUBLE NULL,
        `balance` DOUBLE NULL,
        `initial_balance` DOUBLE NULL,
        `Account_number` INT NOT NULL,
        PRIMARY KEY (`id`),
        INDEX `fk_Transaction_Account1_idx` (`Account_number` ASC) VISIBLE,
        CONSTRAINT `fk_Transaction_Account1` FOREIGN KEY (`Account_number`) REFERENCES `mydb`.`Account` (`number`) ON DELETE NO ACTION ON UPDATE NO ACTION
    );