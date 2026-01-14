create sequence seq_blog increment by 1 start with 1;

create table blog(
                       id number(11) not null primary key,
                       title varchar2(30) not null,
                       content varchar2(200),
                       author varchar2(30) not null,
                       email varchar2(30) not null

);

select * from blog;