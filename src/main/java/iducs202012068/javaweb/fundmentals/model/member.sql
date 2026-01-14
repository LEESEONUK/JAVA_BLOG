select count(*) from tab;

select * from tab;

insert into tab values('induk', 'TABLE', '');

select count(*) from ALL_USERS;

create user sw202012068 identified by cometrue;

grant connect, resource to sw202012068;
commit;

create sequence seq_member increment by 1 start with 1;

create table member(
                       id number(11) not null primary key,
                       email varchar2(30) not null unique,
                       pw varchar2(20) not null,
                       name varchar2(30) not null,
                       phone varchar2(30),
                       address varchar2(50)
);

insert into member values(seq_member.nextval,
                          'root@induk.ac.kr', 'cometrue', 'root', '','');
commit;
update member set name = 'admin', phone='1234', address='seoul' where email='root@induk.ac.kr';
select * from member;
select * from member where email = 'root@induk.ac.kr';