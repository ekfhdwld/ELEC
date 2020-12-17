----권한부여
--create user sem 
--identified by sem
--default tablespace users;
--
----권한부여
--grant connect, resource to sem;



--회원테이블
create table member(
    member_id varchar2(20),
    member_name varchar2(15),
    member_pwd varchar2(300),
    member_role char(1),
    member_phone varchar2(11),
    member_address varchar2(200),
    member_enroll_date date default sysdate,
    member_secession char(1) default 'N',
    constraint pk_member_id primary key(member_id),
    constraint ck_member_role check(member_role in ('S','A','B')),
    constraint ck_member_secession check(member_secession in ('Y','N'))
);
commit;


--테스트 데이터
insert into member values ('honggd', '홍길동', '1234', 'B', '01011112222', '서울 강남구', default, default ); 
Insert into MEMBER (MEMBER_ID, MEMBER_NAME, MEMBER_PWD, MEMBER_ROLE, MEMBER_PHONE, MEMBER_ADDRESS, MEMBER_ENROLL_DATE, MEMBER_SECESSION) 
values ('admin','관리자', '1111', 'A', '01056745678', '06234, 서울시 강남구 테헤란로14길 남도빌딩 5층 ', to_date('01/04/02','RR/MM/DD'), DEFAULT);
Insert into MEMBER (MEMBER_ID, MEMBER_NAME, MEMBER_PWD, MEMBER_ROLE, MEMBER_PHONE, MEMBER_ADDRESS, MEMBER_ENROLL_DATE, MEMBER_SECESSION) 
values ('SAMSUNG','SAMSUNG', '1234', 'S', '01056745678', '04583, 서울시 중구 난계로 125', to_date('01/04/02','RR/MM/DD'), DEFAULT);
Insert into MEMBER (MEMBER_ID, MEMBER_NAME, MEMBER_PWD, MEMBER_ROLE, MEMBER_PHONE, MEMBER_ADDRESS, MEMBER_ENROLL_DATE, MEMBER_SECESSION) 
values ('APPLE','APPLE', '1234', 'S', '01012345678', '06036, 서울시 강남구 가로수길 13', to_date('01/05/22','RR/MM/DD'), DEFAULT);
Insert into MEMBER (MEMBER_ID, MEMBER_NAME, MEMBER_PWD, MEMBER_ROLE, MEMBER_PHONE, MEMBER_ADDRESS, MEMBER_ENROLL_DATE, MEMBER_SECESSION) 
values ('LG','LG', '1234', 'S', '01012345111', '04575, 서울시 중구 난계로 11길 36 ', to_date('01/10/22','RR/MM/DD'), DEFAULT);
Insert into MEMBER (MEMBER_ID, MEMBER_NAME, MEMBER_PWD, MEMBER_ROLE, MEMBER_PHONE, MEMBER_ADDRESS, MEMBER_ENROLL_DATE, MEMBER_SECESSION) 
values ('light','정은지', '0000', 'B', '01012345111', '03470, 서울시 은평구 가좌로 162', to_date('01/08/22','RR/MM/DD'), DEFAULT);
Insert into MEMBER (MEMBER_ID, MEMBER_NAME, MEMBER_PWD, MEMBER_ROLE, MEMBER_PHONE, MEMBER_ADDRESS, MEMBER_ENROLL_DATE, MEMBER_SECESSION) 
values ('onemore','구본승', '0000', 'B', '01012001111', '03479, 서울시 은평구 가좌로 203', to_date('02/01/22','RR/MM/DD'), DEFAULT);
Insert into MEMBER (MEMBER_ID, MEMBER_NAME, MEMBER_PWD, MEMBER_ROLE, MEMBER_PHONE, MEMBER_ADDRESS, MEMBER_ENROLL_DATE, MEMBER_SECESSION) 
values ('han9010','한고은', '1111', 'B', '01012001111', '03484, 서울시 은평구 가좌로 236-7 ', to_date('02/01/22','RR/MM/DD'), DEFAULT);
Insert into MEMBER (MEMBER_ID, MEMBER_NAME, MEMBER_PWD, MEMBER_ROLE, MEMBER_PHONE, MEMBER_ADDRESS, MEMBER_ENROLL_DATE, MEMBER_SECESSION) 
values ('positive_park','박승희', '1111', 'B', '01012001111', '03441, 서울시 은평구 가좌로 294-4 ', to_date('02/01/22','RR/MM/DD'), DEFAULT);
Insert into MEMBER (MEMBER_ID, MEMBER_NAME, MEMBER_PWD, MEMBER_ROLE, MEMBER_PHONE, MEMBER_ADDRESS, MEMBER_ENROLL_DATE, MEMBER_SECESSION) 
values ('ja20han','가제현', '10011', 'B', '01023301111', '06626, 서울시 서초구 강남대로351 ', to_date('04/11/12','RR/MM/DD'), DEFAULT);
Insert into MEMBER (MEMBER_ID, MEMBER_NAME, MEMBER_PWD, MEMBER_ROLE, MEMBER_PHONE, MEMBER_ADDRESS, MEMBER_ENROLL_DATE, MEMBER_SECESSION) 
values ('hansonghi','한송희', '1111', 'B', '01091293943', '03900, 서울시 마포구 가양대로 3 ', to_date('05/11/12','RR/MM/DD'), DEFAULT);

SELECT * FROM MEMBER;

--색상테이블
create table product_color(
    color_code varchar2(10),
    color_name varchar2(10),
    color_rgb varchar2(20),
    color_eng_name varchar2(20),
    constraint pk_color_code primary key(color_code)
);

insert into product_color values ('c1','블랙', '#000000', 'Black');
insert into product_color values ('c2','레드', '#FF0000','Red');
insert into product_color values ('c3','블루', '#0000FF', 'Blue');
insert into product_color values ('c5','그린', '#008000', 'Green');
insert into product_color values ('c6','그레이','#808080', 'Gray');
insert into product_color values ('c7','화이트','#FFFFFF', 'White');
insert into product_color values ('c9','퍼플','#800080', 'Purple');
insert into product_color values ('c10','실버','#C0C0C0', 'Silver');
insert into product_color values ('c11','골드','#FFD700', 'Gold');

select * from product_color;

--상품분류 테이블
create table product_category(
    product_code varchar2(10),
    brand varchar2(20),
    product_name varchar2(20),
    product_desc varchar2(1000),
    product_img varchar2(300),
   constraint pk_product_code primary key(product_code)
);


--상품카테고리 테스트데이터
insert into product_category values('N1','APPLE','MacBook Air', 'Retina Display,4코어 Intel Core i7 프로세서,4만pixel,11시간배터리사용,Touch ID,백라이트 키보드', '/upload/Apple/N/N1');
insert into product_category values('N2', 'APPLE', 'MacBook Pro', 'Retina Display,4코어 Intel Core i7 프로세서,4만pixel,10시간배터리사용,Touch ID,백라이트 키보드', '/upload/Apple/N/N2');
insert into product_category values('N3', 'SAMSUNG', 'GalaxyBook S', 'WINDOW10,LED display,Intel Core i5 프로세서,17시간 배터리사용,Touch screen', '/upload/Samsung/N/N3');
insert into product_category values('N4', 'SAMSUNG', 'Galaxy ION', ' WINDOW10,QLED display,intel Core i7 프로세서,21시간 배터리사용,Touch screen','/upload/Samsung/N/N4');
insert into product_category values('N5', 'SAMSUNG', 'GalaxyBook Flex', ' WINDOW10,QLED display,intel Core i7 프로세서,19시간 배터리사용,Touch screen', '/upload/Samsung/N/N5');

insert into product_category values('N6', 'LG', 'Gram', ' WINDOW10,QLED display,intel Core i7 프로세서,80시간 배터리사용,지문인식,4열숫자키보드', '/upload/LG/N/N6');
insert into product_category values('N7', 'LG', '울트라기어', ' WINDOW10,QLED display,intel Core i5 프로세서,72시간 배터리사용,지문인식,백라이트키보드', '/upload/LG/N/N7');
insert into product_category values('N8', 'LG', '울트라PC', ' WINDOW10,QLED display,intel Core i7 프로세서,80시간 배터리사용,Touch pad,백라이트키보드', '/upload/LG/N/N8');
insert into product_category values('P1', 'APPLE','아이폰SE','single camera(wide),13시간 동영상재생,생활방수(수심1m),Retina HD display', '/upload/Apple/P/P1');
insert into product_category values('P2', 'APPLE', '아이폰11', 'dual camera(ultra wide),17시간 동영상재생,생활방수(수심2m),Liquid Retina HD display', '/upload/Apple/P/P2');
insert into product_category values('P3', 'Apple', '아이폰11 Pro', 'triple camera(ultra wide),20시간 동영상재생,생활방수(수심 4m),Liquid Retina HD display', '/upload/Apple/P/P3');
insert into product_category values('P4', 'SAMSUNG', 'galaxy S20', '하이브리드 광학줌,6200만화소카메라,8K동영상촬영,4000mAh배터리', '/upload/Samsung/P/P4');
insert into product_category values('P5', 'SAMSUNG', 'galaxy Z filp', 'free-stop,1000만화소 전면카메라,Active window기능,2개내장배터리', '/upload/Samsung/P/P5');
insert into product_category values('P6', 'SAMSUNG', 'galaxy Note 20', '169.5mm display,192g,PC와연동가능,120 frame FHD,초고속충전', '/upload/Samsung/P/P6');
insert into product_category values('P7', 'LG', 'Q70', ' 162.5mm FHD+,전면 1600만 화소,Android 9.0 pie,4GB LRDDR4', '/upload/LG/P/P7');
insert into product_category values('P8', 'LG', 'ThinkQ', '162.4mm OLED FHD+,전면 3200만 화소,Android 9.0 pie,8GB LRDDR4', '/upload/LG/P/P8');
insert into product_category values('P9', 'LG', 'Velvet', '172.7mm OLED FHD+,전면 1600만 화소,Android 10.0 pie', '/upload/LG/P/P9'); 

select * from product_category;

update product_category set  product_name = 'Ultra Gear' where product_code = 'N7';
update product_category set  product_name = 'Ultra PC' where product_code = 'N8';
update product_category set  product_name = 'iPhone SE' where product_code = 'P1';
update product_category set  product_name = 'iPhone11' where product_code = 'P2';
update product_category set  product_name = 'iPhone11 Pro' where product_code = 'P3';
update product_category set  product_name = 'Galaxy S20' where product_code = 'P4';
update product_category set  product_name = 'Galaxy Z filp' where product_code = 'P5';
update product_category set  product_name = 'Galaxy Note20' where product_code = 'P6';

commit;

--상품테이블
create table product(
    prod_serial_code varchar2(100),
    prod_code varchar2(10),
    category varchar2(10),
    color varchar2(10),
    inch varchar2(2) default '0',
    capacity varchar2(10),
    stock number,
    price number,
    discount_rate number,
    prod_delete char(1) default 'N',
    constraint pk_prod_serial_code primary key(prod_serial_code),
    constraint ck_category check(category in ('N', 'P')),
    constraints fk_prod_code foreign key(prod_code)
                                        references product_category(product_code)
                                        on delete cascade,
    constraints fk_color foreign key(color)
                                        references product_color(color_code)
                                        on delete cascade,
    constraints ck_product check (stock >= 0)
);

--테스트 데이터
insert into product values ('N1C3I13M500', 'N1', 'N', 'c3', '13', '500GB', 50, 1320000, 5, default);
insert into product values ('N1C3I15M500', 'N1', 'N', 'c3', '15', '500GB', 50, 1320000, 5, default);
insert into product values ('N1C3I17M500', 'N1', 'N', 'c3', '17', '500GB', 50, 1320000, 5, default);
insert into product values ('N1C3I13M1', 'N1', 'N', 'c3', '13', '1TB', 50, 1320000, 5, default);
insert into product values ('N1C3I15M1', 'N1', 'N', 'c3', '15', '1TB', 50, 1320000, 5, default);
insert into product values ('N1C3I17M1', 'N1', 'N', 'c3', '17', '1TB', 50, 1320000, 5, default);
insert into product values ('N1C6I13M500', 'N1', 'N', 'c6', '13', '500GB', 50, 1320000, 5, default);
insert into product values ('N1C6I15M500', 'N1', 'N', 'c6', '15', '500GB', 50, 1320000, 5, default);
insert into product values ('N1C6I17M500', 'N1', 'N', 'c6', '17', '500GB', 50, 1320000, 5, default);
insert into product values ('N1C6I13M1', 'N1', 'N', 'c6', '13', '1TB', 50, 1320000, 5, default);
insert into product values ('N1C6I15M1', 'N1', 'N', 'c6', '15', '1TB', 50, 1320000, 5, default);
insert into product values ('N1C6I17M1', 'N1', 'N', 'c6', '17', '1TB', 50, 1320000, 5, default);
insert into product values ('N1C7I13M500', 'N1', 'N', 'c7', '13', '500GB', 50, 1320000, 5, default);
insert into product values ('N1C7I15M500', 'N1', 'N', 'c7', '15', '500GB', 50, 1320000, 5, default);
insert into product values ('N1C7I17M500', 'N1', 'N', 'c7', '17', '500GB', 50, 1320000, 5, default);
insert into product values ('N1C7I13M1', 'N1', 'N', 'c7', '13', '1TB', 50, 1320000, 5, default);
insert into product values ('N1C7I15M1', 'N1', 'N', 'c7', '15', '1TB', 50, 1320000, 5, default);
insert into product values ('N1C7I17M1', 'N1', 'N', 'c7', '17', '1TB', 50, 1320000, 5, default);
insert into product values ('N1C10I13M500', 'N1', 'N', 'c10', '13', '500GB', 50, 1320000, 5, default);
insert into product values ('N1C10I15M500', 'N1', 'N', 'c10', '15', '500GB', 50, 1320000, 5, default);
insert into product values ('N1C10I17M500', 'N1', 'N', 'c10', '17', '500GB', 50, 1320000, 5, default);
insert into product values ('N1C10I13M1', 'N1', 'N', 'c10', '13', '1TB', 50, 1320000, 5, default);
insert into product values ('N1C10I15M1', 'N1', 'N', 'c10', '15', '1TB', 50, 1320000, 5, default);
insert into product values ('N1C10I17M1', 'N1', 'N', 'c10', '17', '1TB', 50, 1320000, 5, default);
--N2
insert into product values ('N2C3I13M500', 'N2', 'N', 'c3', '13', '500GB', 50, 1720000, 5, default);
insert into product values ('N2C3I13M1', 'N2', 'N', 'c3', '13', '1TB', 50, 2000000, 5, default);
insert into product values ('N2C6I13M500', 'N2', 'N', 'c6', '13', '500GB', 50, 1720000, 5, default);
insert into product values ('N2C6I13M1', 'N2', 'N', 'c6', '13', '1TB', 50, 2000000, 5, default);
insert into product values ('N2C7I13M500', 'N2', 'N', 'c7', '13', '500GB', 50, 1720000, 5, default);
insert into product values ('N2C7I13M1', 'N2', 'N', 'c7', '13', '1TB', 50, 2000000, 5, default);
insert into product values ('N2C10I13M500', 'N2', 'N', 'c10', '13', '500GB', 50, 1720000, 5, default);
insert into product values ('N2C10I13M1', 'N2', 'N', 'c10', '13', '1TB', 50, 2000000, 5, default);
--N3
insert into product values ('N3C3I13M500', 'N3', 'N', 'c3', '13', '500GB', 50, 1249000, 5, default);
insert into product values ('N3C3I15M500', 'N3', 'N', 'c3', '15', '500GB', 50, 1249000, 5, default);
insert into product values ('N3C6I13M500', 'N3', 'N', 'c6', '13', '500GB', 50, 1249000, 5, default);
insert into product values ('N3C6I15M500', 'N3', 'N', 'c6', '15', '500GB', 50, 1249000, 5, default);
insert into product values ('N3C7I13M500', 'N3', 'N', 'c7', '13', '500GB', 50, 1249000, 5, default);
insert into product values ('N3C7I15M500', 'N3', 'N', 'c7', '15', '500GB', 50, 1249000, 5, default);
insert into product values ('N3C10I13M500', 'N3', 'N', 'c10', '13', '500GB', 50, 1249000, 5, default);
insert into product values ('N3C10I15M500', 'N3', 'N', 'c10', '15', '500GB', 50, 1249000, 5, default);
insert into product values ('N3C3I13M1', 'N3', 'N', 'c3', '13', '1TB', 50, 1649000, 5, default);
insert into product values ('N3C3I15M1', 'N3', 'N', 'c3', '15', '1TB', 50, 1649000, 5, default);
insert into product values ('N3C6I13M1', 'N3', 'N', 'c6', '13', '1TB', 50, 1649000, 5, default);
insert into product values ('N3C6I15M1', 'N3', 'N', 'c6', '15', '1TB', 50, 1649000, 5, default);
insert into product values ('N3C7I13M1', 'N3', 'N', 'c7', '13', '1TB', 50, 1649000, 5, default);
insert into product values ('N3C7I15M1', 'N3', 'N', 'c7', '15', '1TB', 50, 1649000, 5, default);
insert into product values ('N3C10I13M1', 'N3', 'N', 'c10', '13', '1TB', 50, 1649000, 5, default);
insert into product values ('N3C10I15M1', 'N3', 'N', 'c10', '15', '1TB', 50, 1649000, 5, default);
--N4
insert into product values ('N4C3I13M500', 'N4', 'N', 'c3', '13', '500GB', 50, 2190000, 5, default);
insert into product values ('N4C3I15M500', 'N4', 'N', 'c3', '15', '500GB', 50, 2190000, 5, default);
insert into product values ('N4C3I17M500', 'N4', 'N', 'c3', '17', '500GB', 50, 2190000, 5, default);
insert into product values ('N4C6I13M500', 'N4', 'N', 'c6', '13', '500GB', 50, 2190000, 5, default);
insert into product values ('N4C6I15M500', 'N4', 'N', 'c6', '15', '500GB', 50, 2190000, 5, default);
insert into product values ('N4C6I17M500', 'N4', 'N', 'c6', '17', '500GB', 50, 2190000, 5, default);
insert into product values ('N4C7I13M500', 'N4', 'N', 'c7', '13', '500GB', 50, 2190000, 5, default);
insert into product values ('N4C7I15M500', 'N4', 'N', 'c7', '15', '500GB', 50, 2190000, 5, default);
insert into product values ('N4C7I17M500', 'N4', 'N', 'c7', '17', '500GB', 50, 2190000, 5, default);
insert into product values ('N4C10I13M500', 'N4', 'N', 'c10', '13', '500GB', 50, 2190000, 5, default);
insert into product values ('N4C10I15M500', 'N4', 'N', 'c10', '15', '500GB', 50, 2190000, 5, default);
insert into product values ('N4C10I17M500', 'N4', 'N', 'c10', '17', '500GB', 50, 2190000, 5, default);
insert into product values ('N4C3I13M1', 'N4', 'N', 'c3', '13', '1TB', 50, 2390000, 5, default);
insert into product values ('N4C3I15M1', 'N4', 'N', 'c3', '15', '1TB', 50, 2390000, 5, default);
insert into product values ('N4C3I17M1', 'N4', 'N', 'c3', '17', '1TB', 50, 2390000, 5, default);
insert into product values ('N4C6I13M1', 'N4', 'N', 'c6', '13', '1TB', 50, 2390000, 5, default);
insert into product values ('N4C6I15M1', 'N4', 'N', 'c6', '15', '1TB', 50, 2390000, 5, default);
insert into product values ('N4C6I17M1', 'N4', 'N', 'c6', '17', '1TB', 50, 2390000, 5, default);
insert into product values ('N4C7I13M1', 'N4', 'N', 'c7', '13', '1TB', 50, 2390000, 5, default);
insert into product values ('N4C7I15M1', 'N4', 'N', 'c7', '15', '1TB', 50, 2390000, 5, default);
insert into product values ('N4C7I17M1', 'N4', 'N', 'c7', '17', '1TB', 50, 2390000, 5, default);
insert into product values ('N4C10I13M1', 'N4', 'N', 'c10', '13', '1TB', 50, 2390000, 5, default);
insert into product values ('N4C10I15M1', 'N4', 'N', 'c10', '15', '1TB', 50, 2390000, 5, default);
insert into product values ('N4C10I17M1', 'N4', 'N', 'c10', '17', '1TB', 50, 2390000, 5, default);
--N5
insert into product values ('N5C3I13M500', 'N5', 'N', 'c3', '13', '500GB', 50, 2599000, 5, default);
insert into product values ('N5C3I15M500', 'N5', 'N', 'c3', '15', '500GB', 50, 2599000, 5, default);
insert into product values ('N5C6I13M500', 'N5', 'N', 'c6', '13', '500GB', 50, 2599000, 5, default);
insert into product values ('N5C6I15M500', 'N5', 'N', 'c6', '15', '500GB', 50, 2599000, 5, default);
insert into product values ('N5C7I13M500', 'N5', 'N', 'c7', '13', '500GB', 50, 2599000, 5, default);
insert into product values ('N5C7I15M500', 'N5', 'N', 'c7', '15', '500GB', 50, 2599000, 5, default);
insert into product values ('N5C10I13M500', 'N5', 'N', 'c10', '13', '500GB', 50, 2599000, 5, default);
insert into product values ('N5C10I15M500', 'N5', 'N', 'c10', '15', '500GB', 50, 2599000, 5, default);
insert into product values ('N5C3I13M1', 'N5', 'N', 'c3', '13', '1TB', 50, 2899000, 5, default);
insert into product values ('N5C3I15M1', 'N5', 'N', 'c3', '15', '1TB', 50, 2899000, 5, default);
insert into product values ('N5C6I13M1', 'N5', 'N', 'c6', '13', '1TB', 50, 2899000, 5, default);
insert into product values ('N5C6I15M1', 'N5', 'N', 'c6', '15', '1TB', 50, 2899000, 5, default);
insert into product values ('N5C7I13M1', 'N5', 'N', 'c7', '13', '1TB', 50, 2899000, 5, default);
insert into product values ('N5C7I15M1', 'N5', 'N', 'c7', '15', '1TB', 50, 2899000, 5, default);
insert into product values ('N5C10I13M1', 'N5', 'N', 'c10', '13', '1TB', 50, 2899000, 5, default);
insert into product values ('N5C10I15M1', 'N5', 'N', 'c10', '15', '1TB', 50, 2899000, 5, default);
--N6
insert into product values ('N6C3I13M500', 'N6', 'N', 'c3', '13', '500GB', 50, 1789000, 5, default);
insert into product values ('N6C3I15M500', 'N6', 'N', 'c3', '15', '500GB', 50, 1789000, 5, default);
insert into product values ('N6C3I17M500', 'N6', 'N', 'c3', '17', '500GB', 50, 1789000, 5, default);
insert into product values ('N6C6I13M500', 'N6', 'N', 'c6', '13', '500GB', 50, 1789000, 5, default);
insert into product values ('N6C6I15M500', 'N6', 'N', 'c6', '15', '500GB', 50, 1789000, 5, default);
insert into product values ('N6C6I17M500', 'N6', 'N', 'c6', '17', '500GB', 50, 1789000, 5, default);
insert into product values ('N6C7I13M500', 'N6', 'N', 'c7', '13', '500GB', 50, 1789000, 5, default);
insert into product values ('N6C7I15M500', 'N6', 'N', 'c7', '15', '500GB', 50, 1789000, 5, default);
insert into product values ('N6C7I17M500', 'N6', 'N', 'c7', '17', '500GB', 50, 1789000, 5, default);
insert into product values ('N6C10I13M500', 'N6', 'N', 'c10', '13', '500GB', 50, 1789000, 5, default);
insert into product values ('N6C10I15M500', 'N6', 'N', 'c10', '15', '500GB', 50, 1789000, 5, default);
insert into product values ('N6C10I17M500', 'N6', 'N', 'c10', '17', '500GB', 50, 1789000, 5, default);
insert into product values ('N6C3I13M1', 'N6', 'N', 'c3', '13', '1TB', 50, 1989000, 5, default);
insert into product values ('N6C3I15M1', 'N6', 'N', 'c3', '15', '1TB', 50, 1989000, 5, default);
insert into product values ('N6C3I17M1', 'N6', 'N', 'c3', '17', '1TB', 50, 1989000, 5, default);
insert into product values ('N6C6I13M1', 'N6', 'N', 'c6', '13', '1TB', 50, 1989000, 5, default);
insert into product values ('N6C6I15M1', 'N6', 'N', 'c6', '15', '1TB', 50, 1989000, 5, default);
insert into product values ('N6C6I17M1', 'N6', 'N', 'c6', '17', '1TB', 50, 1989000, 5, default);
insert into product values ('N6C7I13M1', 'N6', 'N', 'c7', '13', '1TB', 50, 1989000, 5, default);
insert into product values ('N6C7I15M1', 'N6', 'N', 'c7', '15', '1TB', 50, 1989000, 5, default);
insert into product values ('N6C7I17M1', 'N6', 'N', 'c7', '17', '1TB', 50, 1989000, 5, default);
insert into product values ('N6C10I13M1', 'N6', 'N', 'c10', '13', '1TB', 50, 1989000, 5, default);
insert into product values ('N6C10I15M1', 'N6', 'N', 'c10', '15', '1TB', 50, 1989000, 5, default);
insert into product values ('N6C10I17M1', 'N6', 'N', 'c10', '17', '1TB', 50, 1989000, 5, default);
--N7
insert into product values ('N7C3I15M500', 'N7', 'N', 'c3', '15', '500GB', 50, 1900000, 5, default);
insert into product values ('N7C3I17M500', 'N7', 'N', 'c3', '17', '500GB', 50, 1900000, 5, default);
insert into product values ('N7C6I15M500', 'N7', 'N', 'c6', '15', '500GB', 50, 1900000, 5, default);
insert into product values ('N7C6I17M500', 'N7', 'N', 'c6', '17', '500GB', 50, 1900000, 5, default);
insert into product values ('N7C7I15M500', 'N7', 'N', 'c7', '15', '500GB', 50, 1900000, 5, default);
insert into product values ('N7C7I17M500', 'N7', 'N', 'c7', '17', '500GB', 50, 1900000, 5, default);
insert into product values ('N7C10I15M500', 'N7', 'N', 'c10', '15', '500GB', 50, 1900000, 5, default);
insert into product values ('N7C10I17M500', 'N7', 'N', 'c10', '17', '500GB', 50, 1900000, 5, default);
insert into product values ('N7C3I15M1', 'N7', 'N', 'c3', '15', '1TB', 50, 2100000, 5, default);
insert into product values ('N7C3I17M1', 'N7', 'N', 'c3', '17', '1TB', 50, 2100000, 5, default);
insert into product values ('N7C6I15M1', 'N7', 'N', 'c6', '15', '1TB', 50, 2100000, 5, default);
insert into product values ('N7C6I17M1', 'N7', 'N', 'c6', '17', '1TB', 50, 2100000, 5, default);
insert into product values ('N7C7I15M1', 'N7', 'N', 'c7', '15', '1TB', 50, 2100000, 5, default);
insert into product values ('N7C7I17M1', 'N7', 'N', 'c7', '17', '1TB', 50, 2100000, 5, default);
insert into product values ('N7C10I15M1', 'N7', 'N', 'c10', '15', '1TB', 50, 2100000, 5, default);
insert into product values ('N7C10I17M1', 'N7', 'N', 'c10', '17', '1TB', 50, 2100000, 5, default);
--N8
insert into product values ('N8C3I13M500', 'N8', 'N', 'c3', '13', '500GB', 50, 2489000, 5, default);
insert into product values ('N8C3I15M500', 'N8', 'N', 'c3', '15', '500GB', 50, 2489000, 5, default);
insert into product values ('N8C6I13M500', 'N8', 'N', 'c6', '13', '500GB', 50, 1489000, 5, default);
insert into product values ('N8C6I15M500', 'N8', 'N', 'c6', '15', '500GB', 50, 1489000, 5, default);
insert into product values ('N8C7I13M500', 'N8', 'N', 'c7', '13', '500GB', 50, 1489000, 5, default);
insert into product values ('N8C7I15M500', 'N8', 'N', 'c7', '15', '500GB', 50, 1489000, 5, default);
insert into product values ('N8C10I13M500', 'N8', 'N', 'c10', '13', '500GB', 50, 1489000, 5, default);
insert into product values ('N8C10I15M500', 'N8', 'N', 'c10', '15', '500GB', 50, 1489000, 5, default);
insert into product values ('N8C3I13M1', 'N8', 'N', 'c3', '13', '1TB', 50, 1689000, 5, default);
insert into product values ('N8C3I15M1', 'N8', 'N', 'c3', '15', '1TB', 50, 1689000, 5, default);
insert into product values ('N8C6I13M1', 'N8', 'N', 'c6', '13', '1TB', 50, 1689000, 5, default);
insert into product values ('N8C6I15M1', 'N8', 'N', 'c6', '15', '1TB', 50, 1689000, 5, default);
insert into product values ('N8C7I13M1', 'N8', 'N', 'c7', '13', '1TB', 50, 1689000, 5, default);
insert into product values ('N8C7I15M1', 'N8', 'N', 'c7', '15', '1TB', 50, 1689000, 5, default);
insert into product values ('N8C10I13M1', 'N8', 'N', 'c10', '13', '1TB', 50, 1689000, 5, default);
insert into product values ('N8C10I15M1', 'N8', 'N', 'c10', '15', '1TB', 50, 1689000, 5, default);


--P1
insert into product values ('P1C1I0M32', 'P1', 'P', 'c1', default, '32GB', 50, 550000, 3, default);
insert into product values ('P1C2I0M32', 'P1', 'P', 'c2', default, '32GB', 50, 550000, 3, default);
insert into product values ('P1C7I0M32', 'P1', 'P', 'c7', default, '32GB', 50, 550000, 3, default);
insert into product values ('P1C1I0M64', 'P1', 'P', 'c1', default, '64GB', 50, 620000, 3, default);
insert into product values ('P1C2I0M64', 'P1', 'P', 'c2', default, '64GB', 50, 620000, 3, default);
insert into product values ('P1C7I0M64', 'P1', 'P', 'c7', default, '64GB', 50, 620000, 3, default);
insert into product values ('P1C1I0M256', 'P1', 'P', 'c1', default, '256GB', 50, 760000, 3, default);
insert into product values ('P1C2I0M256', 'P1', 'P', 'c2', default, '256GB', 50, 760000, 3, default);
insert into product values ('P1C7I0M256', 'P1', 'P', 'c7', default, '256GB', 50, 760000, 3, default);
--P2
select * froI0M product;
insert into product values ('P2C1I0M64', 'P2', 'P', 'c1', default, '64GB', 50, 990000, 3, default);
insert into product values ('P2C2I0M64', 'P2', 'P', 'c2', default, '64GB', 50, 990000, 3, default);
insert into product values ('P2C5I0M64', 'P2', 'P', 'c5', default, '64GB', 50, 990000, 3, default);
insert into product values ('P2C7I0M64', 'P2', 'P', 'c7', default, '64GB', 50, 990000, 3, default);
insert into product values ('P2C9I0M64', 'P2', 'P', 'c9', default, '64GB', 50, 990000, 3, default);
insert into product values ('P2C1I0M256', 'P2', 'P', 'c1', default, '256GB', 50, 1200000, 3, default);
insert into product values ('P2C2I0M256', 'P2', 'P', 'c2', default, '256GB', 50, 1200000, 3, default);
insert into product values ('P2C5I0M256', 'P2', 'P', 'c5', default, '256GB', 50, 1200000, 3, default);
insert into product values ('P2C7I0M256', 'P2', 'P', 'c7', default, '256GB', 50, 1200000, 3, default);
insert into product values ('P2C9I0M256', 'P2', 'P', 'c9', default, '256GB', 50, 1200000, 3, default);
--P3
insert into product values ('P3C5I0M64', 'P3', 'P', 'c5', default, '64GB', 50, 1390000, 3, default);
insert into product values ('P3C6I0M64', 'P3', 'P', 'c6', default, '64GB', 50, 1390000, 3, default);
insert into product values ('P3C11I0M64', 'P3', 'P', 'c11', default, '64GB', 50, 1390000, 3, default);
insert into product values ('P3C5I0M256', 'P3', 'P', 'c5', default, '256GB', 50, 1600000, 3, default);
insert into product values ('P3C6I0M256', 'P3', 'P', 'c6', default, '256GB', 50, 1600000, 3, default);
insert into product values ('P3C11I0M256', 'P3', 'P', 'c11', default, '256GB', 50, 1600000, 3, default);
insert into product values ('P3C5I0M512', 'P3', 'P', 'c5', default, '512GB', 50, 1870000, 3, default);
insert into product values ('P3C6I0M512', 'P3', 'P', 'c6', default, '512GB', 50, 1870000, 3, default);
insert into product values ('P3C11I0M512', 'P3', 'P', 'c11', default, '512GB', 50, 1870000, 3, default);
--P4
insert into product values ('P4C1I0M256', 'P4', 'P', 'c1', default, '256GB', 50, 1390000, 3, default);
insert into product values ('P4C6I0M256', 'P4', 'P', 'c6', default, '256GB', 50, 1390000, 3, default);
insert into product values ('P4C9I0M256', 'P4', 'P', 'c9', default, '256GB', 50, 1390000, 3, default);
insert into product values ('P4C1I0M512', 'P4', 'P', 'c1', default, '512GB', 50, 1600000, 3, default);
insert into product values ('P4C6I0M512', 'P4', 'P', 'c6', default, '512GB', 50, 1600000, 3, default);
insert into product values ('P4C9I0M512', 'P4', 'P', 'c9', default, '512GB', 50, 1600000, 3, default);
--P5
insert into product values ('P5C1I0M256', 'P5', 'P', 'c1', default, '256GB', 50, 1650000, 3, default);
insert into product values ('P5C9I0M256', 'P5', 'P', 'c9', default, '256GB', 50, 1650000, 3, default);
insert into product values ('P5C11I0M256', 'P5', 'P', 'c11', default, '256GB', 50, 1650000, 3, default);
insert into product values ('P5C1I0M512', 'P5', 'P', 'c1', default, '512GB', 50, 1998000, 3, default);
insert into product values ('P5C6I0M512', 'P5', 'P', 'c6', default, '512GB', 50, 1998000, 3, default);
--P6
insert into product values ('P6C1I0M256', 'P6', 'P', 'c1', default, '256GB', 50, 1550000, 3, default);
insert into product values ('P6C6I0M256', 'P6', 'P', 'c6', default, '256GB', 50, 1550000, 3, default);
insert into product values ('P6C7I0M256', 'P6', 'P', 'c7', default, '256GB', 50, 1550000, 3, default);
insert into product values ('P6C11I0M256', 'P6', 'P', 'c11', default, '256GB', 50, 1550000, 3, default);
--P7
insert into product values ('P7C1I0M32', 'P7', 'P', 'c1', default, '32GB', 50, 590000, 3, default);
insert into product values ('P7C1I0M64', 'P7', 'P', 'c1', default, '64GB', 50, 790000, 3, default);
--P8
insert into product values ('P8C1I0M256', 'P8', 'P', 'c1', default, '256GB', 50, 1590000, 3, default);
insert into product values ('P8C3I0M256', 'P8', 'P', 'c3 ', default, '256GB', 50, 1590000, 3, default);
insert into product values ('P8C9I0M256', 'P8', 'P', 'c9', default, '256GB', 50, 1590000, 3, default);
insert into product values ('P8C1I0M512', 'P8', 'P', 'c1', default, '512GB', 50, 1790000, 3, default);
insert into product values ('P8C3I0M512', 'P8', 'P', 'c3 ', default, '512GB', 50, 1790000, 3, default);
insert into product values ('P8C9I0M512', 'P8', 'P', 'c9', default, '512GB', 50, 1790000, 3, default);
--P9
insert into product values ('P9C1I0M256', 'P9', 'P', 'c1', default, '256GB', 50, 1390000, 3, default);
insert into product values ('P9C5I0M256', 'P9', 'P', 'c5', default, '256GB', 50, 1390000, 3, default);
insert into product values ('P9C7I0M256', 'P9', 'P', 'c7', default, '256GB', 50, 1390000, 3, default);
insert into product values ('P9C11I0M256', 'P9', 'P', 'c11', default, '256GB', 50, 1390000, 3, default);

select * from  product;

create table board(
    board_no number,
    board_writer varchar2(20),
    board_content varchar2(200),
    board_date date default sysdate,
    board_grade number,
    prod_code varchar2(10),
    constraint pk_board_no primary key(board_no),
    constraints fk_board_prod_code foreign key(prod_code) references product_category(product_code) on delete cascade,
    constraint ck_board_grade check (board_grade>=0 and board_grade<= 5),
    constraints fk_board_writer foreign key(board_writer) references member(member_id) on delete cascade
);

create sequence seq_board_no;


--테스트 데이터
insert into board values(seq_board_no.nextval, 'admin', '역시 애플... 좋습니다', default,  3.5 , 'N2' );
insert into board values(seq_board_no.nextval, 'han9010', '배송은 늦었지만 진짜 화면도 크고 좋아요', default,  5 , 'P3' );
insert into board values(seq_board_no.nextval, 'onemore', '카메라가 많은 거 빼고는 다 좋아요', default,  4 , 'P3' );

---------------------------------------------------------핸드폰 삼성----------------------------------------------------------

insert into board values(seq_board_no.nextval, 'hansonghi', '미쳤습니까 휴먼? 카메라 화질 무슨일,,,,', default,  4 , 'P4' );
insert into board values(seq_board_no.nextval, 'ja20han', '삼성이 일냈네요 너무 좋아요!!', default,  5 , 'P4' );
insert into board values(seq_board_no.nextval, 'positive_park', '색깔이 좀 구린거 빼고 편하고 좋아여', default,  4 , 'P4' );
insert into board values(seq_board_no.nextval, 'han9010', '삼성이 진짜 폰은 편한데 안이쁘넹,,,', default,  3 , 'P4' );
insert into board values(seq_board_no.nextval, 'onemore', '폰도 커서 게임이랑 영상보기 좋아욯ㅎ', default,  5 , 'P4' );

insert into board values(seq_board_no.nextval, 'hansonghi', '브이로그 찍기 개꿀쓰', default,  5 , 'P5' );
insert into board values(seq_board_no.nextval, 'ja20han', '진짜 너무이뻐요 제발 다들 사세요!!', default,  5 , 'P5' );
insert into board values(seq_board_no.nextval, 'positive_park', '스티커 사서 꾸밀생각에 숨막혀요', default,  5 , 'P5' );
insert into board values(seq_board_no.nextval, 'han9010', '이쁘긴 진자 이쁜데 비싸기도 진짜 비싸요;', default,  3 , 'P5' );
insert into board values(seq_board_no.nextval, 'onemore', '셀카찍기 좋으네여~~', default,  4 , 'P5' );

-----------------------------------------------------------핸드폰 엘지--------------------------------------------------------

insert into board values(seq_board_no.nextval, 'hansonghi', '화면이 커서 영화보기가 너무 좋네요~', default,  5 , 'P7' );
insert into board values(seq_board_no.nextval, 'ja20han', '디스플레이가 엄청 좋네요', default,  5 , 'P7' );
insert into board values(seq_board_no.nextval, 'positive_park', '잘 쓸게요~~', default,  4 , 'P7' );
insert into board values(seq_board_no.nextval, 'han9010', '싼 값에 사서 기분이 좋아요', default,  4 , 'P7' );
insert into board values(seq_board_no.nextval, 'onemore', '엘지폰 좋네여', default,  5 , 'P7' );

insert into board values(seq_board_no.nextval, 'hansonghi', 'LG페이 있어서 간편하고 좋아요', default,  4 , 'P8' );
insert into board values(seq_board_no.nextval, 'ja20han', 'AI기능이 진짜 쩌네요 인식이 진짜 잘돼요', default,  5 , 'P8' );
insert into board values(seq_board_no.nextval, 'positive_park', '사진이 잘나와요', default,  4 , 'P8' );
insert into board values(seq_board_no.nextval, 'han9010', '지문인식 버튼이 뒤에있어서 불편하네요', default,  3 , 'P8' );
insert into board values(seq_board_no.nextval, 'onemore', '잘쓰겠습니당', default,  4 , 'P8' );

select * from board;


--주문내역리스트 테이블
create table order_list(
    order_no number,
    order_total number,
    member_id varchar2(20),
    order_date date default sysdate,
    address varchar2(200),
    recipient varchar2(15),
    recipient_phone varchar(11),
    constraint pk_order_no primary key(order_no),
    constraints fk_member_id foreign key(member_id) references member(member_id) on delete set null
);

create sequence seq_order_no;

--테스트 데이터
insert into order_list  values(seq_order_no.nextval, 2340000, 'honggd', default, '서울 서대문구', '송인애', '01044332211');
insert into order_list values(seq_order_no.nextval, 2000000, 'honggd', default, '서울 강남구', '백다진', '01098728342');
insert into order_list values(seq_order_no.nextval, 3100000, 'light', default, '서울 동작구', '이지혜', '01010728142');
insert into order_list values(seq_order_no.nextval, 1500000, 'onemore', default, '서울 서초구', '조원혁', '01090028002');
insert into order_list values(seq_order_no.nextval, 1450000, 'han9010', default, '서울 은평구', '김동현', '01090029902');
insert into order_list values(seq_order_no.nextval, 1830000, 'han9010', default, '서울 성북구', '홍기수', '01091028002');
insert into order_list values(seq_order_no.nextval, 8900275, 'positive_park', default, '서울 강남구', '백다진', '01091028002');

select * from order_list;

--주문번호별 구매내역
create table order_detail(
    o_no number,
    order_no number,
    prod_serial_code varchar2(100),
    amount number,
    constraints pk_o_no primary key(o_no),
    constraints fk_order_no foreign key(order_no) references order_list(order_no) on delete set null,
    constraints fk_prod_serial_code foreign key(prod_serial_code) references product(prod_serial_code) on delete set null
);

create sequence seq_o_no;

--테스트데이터
insert into order_detail values(seq_o_no.nextval, 1, 'N1C3I13M500', 3);
insert into order_detail values(seq_o_no.nextval, 2, 'P2C1I0M256', 1);
insert into order_detail values(seq_o_no.nextval, 2, 'P7C1I0M32', 2);
insert into order_detail values(seq_o_no.nextval, 2, 'N3C3I13M500', 1);
insert into order_detail values(seq_o_no.nextval, 3, 'N8C7I13M1', 1);
insert into order_detail values(seq_o_no.nextval, 4, 'P7C1I0M64', 1);
insert into order_detail values(seq_o_no.nextval, 5, 'P2C7I0M64', 1);
insert into order_detail values(seq_o_no.nextval, 5, 'N7C10I17M1', 1);
insert into order_detail values(seq_o_no.nextval, 6, 'N6C3I13M500', 1);
insert into order_detail values(seq_o_no.nextval, 6, 'N6C3I17M500', 1);
insert into order_detail values(seq_o_no.nextval, 6, 'N6C7I17M500', 1);
insert into order_detail values(seq_o_no.nextval, 6, 'N6C10I17M500', 1);
insert into order_detail values(seq_o_no.nextval, 6, 'N6C6I15M500', 1);


--입출고 테이블
create table product_io(
    io_no number,
    prod_serial_code varchar2(100),
    amount number,
    io_date date default sysdate,
    status char(1),
    constraint pk_io_no primary key(io_no),
    constraints fk_io_prod_serial_code foreign key(prod_serial_code) references product(prod_serial_code) on delete cascade,
    constraint ck_status check(status in ('I', 'O'))
);
create sequence seq_product_io;


--입출고 트리거
create or replace trigger trig_product_stock
before
insert on product_io
for each row
begin
    --pseudo record
    if :new.status = 'I' then
        --입고
        update product 
        set stock = stock + :new.amount
        where prod_serial_code = :new.prod_serial_code;
    else
        --출고
        update product 
        set stock = stock - :new.amount
        where prod_serial_code = :new.prod_serial_code;
    end if;
end;
/

commit;


--테스트 데이터
insert into product_io values(seq_product_io.nextval, 'N2C10I13M1', 1, default,  'O');
insert into product_io values(seq_product_io.nextval, 'N3C3I13M500', 1, default,  'O');
insert into product_io values(seq_product_io.nextval, 'P2C7I0M64', 1, default,  'O');
insert into product_io values(seq_product_io.nextval, 'N6C6I15M500', 1, default,  'O');
insert into product_io values(seq_product_io.nextval, 'N8C7I13M1', 1, default,  'O');
insert into product_io values(seq_product_io.nextval, 'P7C1I0M32', 1, default,  'O');
insert into product_io values(seq_product_io.nextval, 'P8C3I0M512', 1, default,  'O');
insert into product_io values(seq_product_io.nextval, 'P4C9I0M256', 1, default,  'O');
insert into product_io values(seq_product_io.nextval, 'P5C9I0M256', 1, default,  'O');
insert into product_io values(seq_product_io.nextval, 'P9C5I0M256', 1, default,  'O');
insert into product_io values(seq_product_io.nextval, 'P1C1I0M256', 1, default,  'O');
insert into product_io values(seq_product_io.nextval, 'P3C6I0M64', 1, default,  'O');

insert into product_io values(seq_product_io.nextval, 'N7C6I17M1', 1, default,  'O');
insert into product_io values(seq_product_io.nextval, 'N6C10I15M1', 1, default,  'O');
insert into product_io values(seq_product_io.nextval, 'N4C6I13M1', 1, default,  'O');
insert into product_io values(seq_product_io.nextval, 'N5C6I13M500', 1, default,  'O');
insert into product_io values(seq_product_io.nextval, 'N3C6I13M1', 1, default,  'O');
insert into product_io values(seq_product_io.nextval, 'N2C6I13M500', 1, default,  'O');
insert into product_io values(seq_product_io.nextval, 'N1C10I15M1', 1, default,  'O');
 commit;

-- 장바구니 테이블
create table cart(
    cart_no number,
    member_id varchar2(20),
    prod_serial_code varchar2(100),
    amount number default 1,
    constraint pk_cart_no primary key(cart_no),
    constraints fk_cart_member_id foreign key(member_id) references member(member_id) on delete cascade,
    constraints fk_cart_prod_serial_code foreign key(prod_serial_code) references product(prod_serial_code) on delete cascade
);

create sequence seq_cart_no;


--테스트 데이터
insert into cart values(seq_cart_no.nextval, 'honggd', 'N1C7I17M1', 1);
insert into cart values(seq_cart_no.nextval, 'honggd', 'N2C10I13M1', 2);
insert into cart values(seq_cart_no.nextval, 'hansonghi', 'N8C6I15M1', default);
insert into cart values(seq_cart_no.nextval, 'ja20han', 'N6C10I13M500', 2);
insert into cart values(seq_cart_no.nextval, 'positive_park', 'N2C6I13M1', default);
insert into cart values(seq_cart_no.nextval, 'ja20han', 'P2C7I0M64', default);
insert into cart values(seq_cart_no.nextval, 'positive_park', 'P3C6I0M512', default);
insert into cart values(seq_cart_no.nextval, 'light', 'N2C3I13M500', default);
insert into cart values(seq_cart_no.nextval, 'han9010', 'P4C1I0M512', 2);
insert into cart values(seq_cart_no.nextval, 'hansonghi', 'P6C6I0M256', default);
insert into cart values(seq_cart_no.nextval, 'light', 'P1C1MI0256', default);
insert into cart values(seq_cart_no.nextval, 'positive_park', 'P7C1I0M64', default);
insert into cart values(seq_cart_no.nextval, 'ja20han', 'N2C3I13M500', default);
insert into cart values(seq_cart_no.nextval, 'han9010', 'P9C5I0M256', 2);
insert into cart values(seq_cart_no.nextval, 'positive_park', 'N3C7I15M500', default);
insert into cart values(seq_cart_no.nextval, 'hansonghi', 'P9C11I0M256', default);
insert into cart values(seq_cart_no.nextval, 'onemore', 'N8C6I15M1', default);
insert into cart values(seq_cart_no.nextval, 'positive_park', 'N2C3I13M500', default);
insert into cart values(seq_cart_no.nextval, 'ja20han', 'P9C5I0M256', 2);
insert into cart values(seq_cart_no.nextval, 'light', 'N4C10I13M1', default);
insert into cart values(seq_cart_no.nextval, 'hansonghi', 'N7C7I17M1', default);
insert into cart values(seq_cart_no.nextval, 'onemore', 'P3C6I0M512', default);

select * from cart;

--commit;

with v as ( select pc.brand, prod_serial_code, amount from product p left outer join  product_category pc on(p.prod_code=pc.product_code) left outer join product_io pi using (prod_serial_code) where status = 'O' ) select a.*, floor(count/(select sum(amount)  from v)*100) percent  from ( select nvl(brand, 'total') brand, sum(amount) count from v group by brand ) a;
