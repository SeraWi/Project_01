--2021.06.24


-- 메뉴 DB
create table menu (
menucode integer constraint menu_PK primary key,
mname varchar2(50) not null,
price number(10) not null
);

-- 메뉴 시퀀스
create sequence menu_sq
start with 1;
 
 drop sequence menu_sq;


insert into menu(menucode, mname, price) values (menu_sq.nextval, 'americano', 4100);
insert into menu(menucode, mname, price) values (menu_sq.nextval, 'latte', 4600);
insert into menu(menucode, mname, price) values (menu_sq.nextval, 'sandwich', 6200);
--insert into menu(menucode, mname, price) values (menu_sq.nextval, 'bagel', 2300);
insert into menu(menucode, mname, price) values (menu_sq.nextval, 'cake', 5500);
--insert into menu(menucode, mname, price) values (menu_sq.nextval, 'cake', 4800);
insert into menu(menucode, mname, price) values (menu_sq.nextval, 'salad', 5000);
commit;
rollback;

select * from menu;
drop table menu;

update menu set mname = 'americano' where mname = 'americano';
update menu set mname = ?, price =? where menucode = ?;

insert into menu(menucode, mname, price) values (menu_sq.nextval, carrotcake, 5300);
delete from menu where menucode = 27;
delete from menu where menucode = 1;