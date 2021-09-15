-- tblBook 테이블 생성
create table tblBook(
  title varchar2(30),
  name  varchar2(20),
  isbn  varchar2(20) primary key not null,
  company varchar2(20),
  cost  number,
  qty   number,
  price number
);

-- 전체레코드 검색
select * from tblBook;