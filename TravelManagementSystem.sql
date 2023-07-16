create database TravelManagementSystem;

use TravelManagementSystem;

create table user_account(username varchar(30), name varchar(20),password varchar(20), security_question varchar(100), answer varchar(60));

select * from user_account;

create table customer(username varchar(30), id varchar(30), number varchar(30), name varchar(30), gender varchar(10), country varchar(30), address varchar(50), phone varchar(15),email varchar(40));

show tables;

select * from customer;

create table bookpackage(username varchar(30),package varchar(30),persons varchar(20),id varchar(30),number varchar(30),phone varchar(15),price varchar(20));

select * from bookpackage;

create table hotel(name varchar(30),costperperson varchar(20), acroom varchar(10),foodincluded varchar(10));

insert into hotel values('Raddison Blue Hotel','3400','1000','1700');

insert into hotel values('River View Hotel','2400','1600','1000');

insert into hotel values('JW Marriot Hotel','4400','2000','2700');

insert into hotel values('Mandarin Oriental Hotel','4000','2500','2100');

create table bookhotel(username varchar(30),name varchar(30),persons varchar(10),days varchar(10),ac varchar(10), food varchar(10), id varchar(20),number varchar(30),phone varchar(20),price varchar(20));