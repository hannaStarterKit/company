insert into library (id, name) values (4, 'Pierwsza biblioteka');
insert into library (id, name) values (5, 'Druga biblioteka');
insert into library (id, name) values (6, 'Trzecia biblioteka');

insert into book (id, title, library_id) values (1, 'Pierwsza książka', 4);
insert into book (id, title, library_id) values (2, 'Druga książka', 5);
insert into book (id, title, library_id) values (3, 'Trzecia książka', 6);

insert into author (id, first_name, last_name) values (7, 'Jan', 'Kowalski');
insert into author (id, first_name, last_name) values (8, 'Zbigniew', 'Nowak');
insert into author (id, first_name, last_name) values (9, 'Janusz', 'Jankowski');

insert into book_author(book_id, author_id) values (1, 7);
insert into book_author(book_id, author_id) values (2, 8);
insert into book_author(book_id, author_id) values (3, 9);

insert into title_author_library(title, author, library_name) values ('Pierwsza książka','Jan Kowalski', 'Pierwsza biblioteka');
insert into title_author_library(title, author, library_name) values ('Druga książka', 'Zbigniew Nowak', 'Druga biblioteka');
insert into title_author_library(title, author, library_name) values ('Trzecia książka', 'Janusz Jankowski', 'Trzecia biblioteka');

