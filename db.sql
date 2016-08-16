create table roles(roleid integer primary key, rolename varchar(20));

create table users(username varchar(30), userid integer primary key, password varchar(10), email varchar(20), roleid integer references roles(roleid),productid integer references product(productid));

create table product(productid integer primary key, productname varchar(30),price integer, brand varchar(20), imgpath varchar(500));

create table prodspecification(productid integer references product(productid), modelid integer primary key,modelname varchar(50));





