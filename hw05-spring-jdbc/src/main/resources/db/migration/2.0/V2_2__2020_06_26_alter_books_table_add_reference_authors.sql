--date: 2020-06-26
--author: denmob

alter table books ADD FOREIGN KEY (author_id) REFERENCES authors(id);


