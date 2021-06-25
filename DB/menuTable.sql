--2021.06.25
--menu table

-- 메뉴 DB
create table menu (
menucode integer constraint menu_PK primary key,
mname varchar2(50) not null,
price number(10) not null
);

drop table menu;
-- 메뉴 시퀀스
create sequence menu_sq
start with 1;
drop sequence menu_sq;


insert into menu(menucode, mname, price) values (menu_sq.nextval, 'americano', 4200);
insert into menu(menucode, mname, price) values (menu_sq.nextval, 'latte', 4700);
insert into menu(menucode, mname, price) values (menu_sq.nextval, 'sandwich', 4800);
insert into menu(menucode, mname, price) values (menu_sq.nextval, 'bagel', 2300);
insert into menu(menucode, mname, price) values (menu_sq.nextval, 'cake', 4800);
insert into menu(menucode, mname, price) values (menu_sq.nextval, 'cake', 4800);

update menu set mname = ?, price =? where menucode = 1;

select * from menu;
commit;