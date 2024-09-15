create table rented_books (
    id serial primary key,
    book_id bigint not null,
    borrowed_at timestamp with time zone not null,
    return_by timestamp with time zone not null,
    constraint fk_book
        foreign key (book_id)
        references book_status (id)
        on delete cascade
)