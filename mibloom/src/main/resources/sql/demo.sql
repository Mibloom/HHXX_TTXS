
-- DDL 语句操作数据库的语句
create database lpk;

drop database lpk;

use lpk;

show databases;

show tables;

create table t_lpk (name varchar(32));

create table t_lpk2 (name varchar(32));

alter table t_lpk modify name varchar(64);

alter table t_lpk add age int(3) after name ;

alter table t_lpk drop age;

alter table t_lpk change age age1 int(4);

alter table t_lpk rename to t_lpk_info;

-- DML 语句 对表数据进行操作

insert into t_lpk (name,age) values ('lipeng',25);

insert into t_lpk values ('lpkienge','');

insert into t_lpk values ('lpk1111',24),('lpk2',25);

insert into t_lpk select name from t_lpk2;


update  t_lpk2 set name = 'lpk2' where age = 20;

delete from t_lpk2 where age = 26;

-- 创建索引

alter table t_lpk add index index_name (name,age);

alter table t_lpk add primary key (age);

alter table t_lpk add unique (name);

create index index_name on t_lpk (name);

create unique  index_name on t_lpk (name);

alter table t_lpk drop index index_name ;

show index from t_lpk;





