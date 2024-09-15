create table if not exists book_status(
	id bigint primary key,
	status varchar(10) not null
);

insert into book_status (id, status) values
(1, 'AVAILABLE'),
(2, 'AVAILABLE'),
(3, 'AVAILABLE'),
(4, 'AVAILABLE'),
(5, 'AVAILABLE'),
(6, 'AVAILABLE');

