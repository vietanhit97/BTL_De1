create database BTL
go 
use BTL
go 
create table category(
	id int identity primary key ,
	name nvarchar(100) unique,
	status tinyint default(1),
	parentId int not null default(0)
)
go 
create table product(
	id int identity primary key ,
	name nvarchar(100) not null,
	image varchar(150),
	status tinyint default(1),
	price float not null,
	quantity int not null,
	sale_price float default(0),
	description Text ,
	created_date date default(CURRENT_TIMESTAMP),
	category_id int ,
	FOREIGN KEY (category_id)
	REFERENCES category(id)
)
go
create table account(
	id int identity,
	name nvarchar(150) not null,
	email varchar(150) not null unique check (EMAIL like '[a-z]%@gmail.com%' ),
	password varchar(150) not null,
	address nvarchar(150),
	role bit default(0),
)