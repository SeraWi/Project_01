--2021.06.24

-- sale table
-- 판매 순으로 번호, 메뉴 이름, 가격, 날짜, 회원 아이디
-- 1 kim americano 4100 2021/06/22 kim1111
-- 2 kim latte     4600 2021/06/22 kim1111
-- 3 Lee americano 4100 2021/06/22 lee2222
create table member (
--memcode뭔지...id+가입일??
memcode integer constraint mem_PK primary key,
name varchar2(50) not null,
id varchar2(50) unique not null,
pw varchar2(50) not null,
address varchar2(255),
phone varchar2(30) not null,
point number(10,2)default 0
);

desc member;
select * from member;

update member
set point = 500
where id = 'park1234';

drop table member;

create sequence member_sq
start with 1;

drop sequence member_sq;


insert into member(memcode, name, id, pw, address, phone) 
values(member_sq.nextval, 'son','son1234','son1234','Korea','01000000000');

insert into member(memcode, name, id, pw, address, phone) 
values(member_sq.nextval, 'kim','kim1234','kim1234','Korea','01000000000');

insert into member(memcode, name, id, pw, address, phone) 
values(member_sq.nextval, 'lee','lee1234','lee1234','Korea','01000000000');

insert into member(memcode, name, id, pw, address, phone, point) 
values(member_sq.nextval, 'Park','park1234','park1234','Korea','01000000000',5000);

update member set point= 5000 where id = 'park1234';


insert into member(memcode, name, id, pw, address, phone) 
values(member_sq.nextval, 'admin','admin','admin','Korea','01000000000');


commit;

select point from member where id = 'kim1234'; -- 포인트확인하기

---------------------------------------------------------------------------------
create table sale (
salecode varchar2(50) constraint sale_PK primary key,
sname varchar2(50) not null,
price integer not null,
saledate date default sysdate

);
-- salecode
desc sale;
-- salecode 에 seqeunce넣기
create sequence sale_salecode_seq
start with 1;
drop table sale;
drop sequence sale_salecode_seq;

--오늘 아닌 판매
insert into sale (salecode, sname, price,saledate)
values(sale_salecode_seq.nextval, 'americano', 4100,'2020/06/21');

insert into sale (salecode, sname, price,saledate)
values(sale_salecode_seq.nextval, 'americano', 4100,'2021/06/21');

insert into sale (salecode, sname, price,saledate)
values(sale_salecode_seq.nextval, 'americano', 4100,'2021/06/21');


-- 오늘 판매한거 : default sysdate
insert into sale (salecode, sname, price,id)
values(sale_salecode_seq.nextval, 'americano', 4100,'lee1234');

insert into sale(salecode, sname, price,id)
values (sale_salecode_seq.nextval, 'latte', 4600,'lee1234');

insert into sale(salecode, sname, price,id)
values (sale_salecode_seq.nextval, 'sandwich', 6200,'lee1234');



insert into sale(salecode, sname, price)
values (sale_salecode_seq.nextval, 'salad', 5000);

insert into sale(salecode, sname, price)
values (sale_salecode_seq.nextval, 'cake', 5500);

select * from sale order by salecode
;
commit;

-- 지금까지 전체 판매액 확인하기

select sum(price)
from sale;

--오늘 판매액 확인하기( 총 판매액만)
select price
from sale
where saledate like '21/06/24%';

select sum(price)
from sale
where substr(saledate,1,8) = substr(sysdate,1,8);--like '21/06/24%';

-- 오늘 판매액 조회하기( 메뉴별 카운트, 메뉴별 판매액)
select sname, count(sname), sum(price)
from sale
where substr(saledate,1,8) = substr(sysdate,1,8)
group by sname
order by sname;



select TO_DATE(substr(sysdate,1,8),'yy/mm/dd')
from dual;
-------------------------------------------------------------------------------
