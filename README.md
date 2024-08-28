# Emazon User Microservice

This is a stock microservice for an e-commerce platform developed in pragma bootcamp. It is built using SpringBoot, and MySQL.

You can create a docker container with a MySQL database using the following command:

docker run --name pragma_bootcamp_database_users -e MYSQL_ROOT_PASSWORD=rootpass -e MYSQL_DATABASE=users -e MYSQL_USER=user -e MYSQL_PASSWORD=userpass -p 3307:3306 -d mysql:8.0

and run the next sql script to create the schema and table:

```
CREATE TABLE `User` (UniqueID int(10) NOT NULL AUTO_INCREMENT, name varchar(255) NOT NULL, lastname varchar(255) NOT NULL, documentID varchar(255) NOT NULL, phone varchar(13) NOT NULL, birthday varchar(255) NOT NULL, email varchar(255) NOT NULL, password varchar(255) NOT NULL, locked int(1), disabled int(1), RolUniqueID int(10) NOT NULL, PRIMARY KEY (UniqueID));
CREATE TABLE Role (UniqueID int(10) NOT NULL AUTO_INCREMENT, name varchar(255) NOT NULL UNIQUE, description text, PRIMARY KEY (UniqueID));
ALTER TABLE `User` ADD CONSTRAINT FKUser694657 FOREIGN KEY (RolUniqueID) REFERENCES Role (UniqueID);
```