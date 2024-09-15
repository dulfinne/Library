alter table if exists rented_books
drop constraint if exists fk_book;

drop table if exists rented_books