--2021.06.25
-- Sale Table 컬럼 추가 테스트


create table sale (
salecode varchar2(50) constraint sale_PK primary key,
sname varchar2(50) not null,
price integer not null,
saledate date default sysdate,
id varchar2(50)not null,
count number(10) not null
);

-- salecode
desc sale;
-- salecode 에 seqeunce넣기
create sequence sale_sq
start with 1;
drop table sale;
drop sequence sale_sq;

--오늘 아닌 판매
insert into sale (salecode, sname, price,saledate, id)
values(sale_sq.nextval, 'americano', 4100,'2020/06/21','park1234');

insert into sale (salecode, sname, price,saledate,id)
values(sale_sq.nextval, 'americano', 4100,'2021/06/21','park1234');

insert into sale (salecode, sname, price,saledate,id)
values(sale_sq.nextval, 'americano', 4100,'2021/06/21','Lee1234');


-- 오늘 판매한거 : default sysdate
insert into sale (salecode, sname, price, id,count)
values(sale_sq.nextval, 'americano', 4100,'park1234', 1);

insert into sale(salecode, sname, price, id,count)
values (sale_sq.nextval, 'latte', 4600,'park1234',1);

insert into sale(salecode, sname, price, id,count)
values (sale_sq.nextval, 'sandwich', 6200,'Lee1234',1);

commit;


insert into sale(salecode, sname, price)
values (sale_sq.nextval, 'salad', 5000);

insert into sale(salecode, sname, price)
values (sale_sq.nextval, 'cake', 5500);

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