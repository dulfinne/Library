create table if not exists books(
	id serial primary key,
	ISBN varchar(17) not null unique,
	name varchar(70) not null,
	genre varchar(30) not null,
	info varchar(250) not null,
	author varchar(50) not null
)
