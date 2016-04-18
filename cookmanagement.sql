/*
DROP DATABASE IF EXISTS cookingmanagement_v1
CREATE DATABASE cookingmanagement_v1
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'C'
       LC_CTYPE = 'C'
       CONNECTION LIMIT = -1;
 */
 CREATE DATABASE cookingmanagement_v1
  WITH ENCODING='UTF8'
       OWNER=postgres
       CONNECTION LIMIT=-1;
------------------------ Creating tables ------------------------ 

DROP TABLE IF EXISTS STAFFTYPE;
CREATE TABLE STAFFTYPE(
	id serial primary key not null, 
	name character(50)
);

DROP TABLE IF EXISTS WORKINGSTATUS;
CREATE TABLE WORKINGSTATUS(
	id serial primary key not null, 
	name character(50)
);

DROP TABLE IF EXISTS WORKINGTIME;
CREATE TABLE WORKINGTIME(
	id serial primary key not null, 
	startHour int, 
	endHour int
);

DROP TABLE IF EXISTS STAFF;
CREATE TABLE STAFF(
	id serial primary key not null, 
	fullName text, 
	image text,
	sex boolean default true,  -- true: man | false: women
	birthday date, 
	startWorking date,
	baseSalary int,
	note text,
	id_staffType int not null references STAFFTYPE(id),  
	id_workingStatus int not null references WORKINGSTATUS(id)
);

DROP TABLE IF EXISTS FOODTYPE;
CREATE TABLE FOODTYPE(
	id serial primary key not null, 
	name text
);

DROP TABLE IF EXISTS FOOD;
CREATE TABLE FOOD(
	id serial primary key not null, 
	"name" text, 
	image text,
	id_foodType int not null references FOODTYPE(id),  
	"number" int default 100,
	price float check(price >= 0) default 0,
	status boolean default true,
	note text
);

DROP TABLE IF EXISTS FOODTABLE;
CREATE TABLE FOODTABLE(
	id serial primary key not null, 
	"name" text UNIQUE
);

DROP TABLE IF EXISTS COOKEDSTATUS;
CREATE TABLE COOKEDSTATUS(
	id serial primary key not null, 
	"name" text 
);


DROP TABLE IF EXISTS USERTYPE;
CREATE TABLE USERTYPE(
	id serial primary key not null, 
	name character(50)
);

DROP TABLE IF EXISTS USERSTATUS;
CREATE TABLE USERSTATUS(
	id serial primary key not null, 
	name character(50)
);

DROP TABLE IF EXISTS "user";
CREATE TABLE "user"(
	id serial primary key not null, 
	fullName text,
	name text, -- user name  
	email text,
	password text,
	image text,
	sex boolean default true,  -- true: man | false: women
	birthday date, 
	id_userType int not null references USERTYPE(id),  
	id_userStatus int not null references USERSTATUS(id)
)


DROP TABLE IF EXISTS HISTORYORDER;
CREATE TABLE HISTORYORDER(
	id_foodeTable int not null, 
	id_food int not null, 
	id_staff int not null, 
	"numberOfCustomer" int not null, 
	"startDate" Date not null,
	"customerName" text, 
	primary key(id_foodeTable, id_food, id_staff, "startDate")	
);

------------------------ insert data ------------------------
 /* 1.  STAFFTYPE data */  
INSERT INTO STAFFTYPE (name) VALUES ('Service personnel');
INSERT INTO STAFFTYPE (name) VALUES ('Bartender');
INSERT INTO STAFFTYPE (name) VALUES ('Receptionist');
INSERT INTO STAFFTYPE (name) VALUES ('Manager');

/* 2. WORKINGSTATUS data */  
INSERT INTO WORKINGSTATUS (name) VALUES ('working');
INSERT INTO WORKINGSTATUS (name) VALUES ('leaving');

 
/* 3. WORKINGTIME data */  
INSERT INTO WORKINGTIME (startHour,endHour) VALUES (8,12);
INSERT INTO WORKINGTIME (startHour,endHour) VALUES (12,17);
INSERT INTO WORKINGTIME (startHour,endHour) VALUES (17,22);

/* 4. FOOTYPE data */  
INSERT INTO FOODTYPE (name) VALUES ('Chiên');
INSERT INTO FOODTYPE (name) VALUES ('Kho');
INSERT INTO FOODTYPE (name) VALUES ('Canh');
INSERT INTO FOODTYPE (name) VALUES ('Xào');
INSERT INTO FOODTYPE (name) VALUES ('Chay');
INSERT INTO FOODTYPE (name) VALUES ('Nướng');
INSERT INTO FOODTYPE (name) VALUES ('Hấp luộc');
INSERT INTO FOODTYPE (name) VALUES ('Other');

/* 5. FOOTYPE data */  
INSERT INTO FOOD (name,image,id_foodType,number,price,status,note) VALUES ('Cơm chiên cá mặn', '',1,100, 30000,true, '');
INSERT INTO FOOD (name,image,id_foodType,number,price,status,note) VALUES ('Gà chiên nước mắm', '',1,100, 30000,true, '');
INSERT INTO FOOD (name,image,id_foodType,number,price,status,note) VALUES ('cá bóng kho tộ', '',2,100, 25000,true, '');
INSERT INTO FOOD (name,image,id_foodType,number,price,status,note) VALUES ('mắm kho quẹt', '',2,100, 25000,true, '');
INSERT INTO FOOD (name,image,id_foodType,number,price,status,note) VALUES ('Canh khổ qua', '',3,100, 20000,true, '');
INSERT INTO FOOD (name,image,id_foodType,number,price,status,note) VALUES ('Canh chua ca lóc', '',3,100, 30000,true, '');
INSERT INTO FOOD (name,image,id_foodType,number,price,status,note) VALUES ('Cơm xào thịt bò', '',4,100, 45000,true, '');
INSERT INTO FOOD (name,image,id_foodType,number,price,status,note) VALUES ('Thịt heo xào cải chua', '',4,100, 25000,true, '');
INSERT INTO FOOD (name,image,id_foodType,number,price,status,note) VALUES ('Rau cải sốt nấm', '',5,100, 20000,true, '');
INSERT INTO FOOD (name,image,id_foodType,number,price,status,note) VALUES ('Hủ tiếu chay', '',5,100, 20000,true, '');
INSERT INTO FOOD (name,image,id_foodType,number,price,status,note) VALUES ('Gà nướng lu', '',6,100, 170000,true, '');
INSERT INTO FOOD (name,image,id_foodType,number,price,status,note) VALUES ('Thịt nướng kiểu Nga', '',6,100, 50000,true, '');
INSERT INTO FOOD (name,image,id_foodType,number,price,status,note) VALUES ('Thịt luộc', '',7,100, 25000,true, '');
INSERT INTO FOOD (name,image,id_foodType,number,price,status,note) VALUES ('Gà luộc nguyên con', '',7,50, 160000,true, '');
INSERT INTO FOOD (name,image,id_foodType,number,price,status,note) VALUES ('Hủ tiếu Sườn', '',5,100, 35000,true, '');

/* 6. FOOTYPE data */  
INSERT INTO FOODTABLE (name) VALUES ('1');
INSERT INTO FOODTABLE (name) VALUES ('2');
INSERT INTO FOODTABLE (name) VALUES ('3');
INSERT INTO FOODTABLE (name) VALUES ('4');
INSERT INTO FOODTABLE (name) VALUES ('5');
INSERT INTO FOODTABLE (name) VALUES ('6');
INSERT INTO FOODTABLE (name) VALUES ('7');
INSERT INTO FOODTABLE (name) VALUES ('8');
INSERT INTO FOODTABLE (name) VALUES ('9');
INSERT INTO FOODTABLE (name) VALUES ('10');

/* 7. USERSTATUS data */  
INSERT INTO USERSTATUS (name) VALUES ('Enable');
INSERT INTO USERSTATUS (name) VALUES ('Disable');

/* 8. USERTYPE data */  
INSERT INTO USERTYPE (name) VALUES ('Customer');
INSERT INTO USERTYPE (name) VALUES ('Admin');
INSERT INTO USERTYPE (name) VALUES ('Boss');
INSERT INTO USERTYPE (name) VALUES ('Service staff');
INSERT INTO USERTYPE (name) VALUES ('Chief staff');