Create table userMaster(
id int not null,
userName varchar(50) not null,
mobileNo varchar(50) not null,
registerDate Date not null,
userCategory varchar(3) not null,
primary key (id)
);

insert into userMaster values (1,'Nila','1234123412',convert(DATE,'2020-11-14'),'E');
insert into userMaster values (2,'Mark','1334123412',convert(DATE,'2020-11-14'),'A');
insert into userMaster values (3,'Cathe','1434123412',convert(DATE,'2017-10-24'),'C');
insert into userMaster values (4,'Steve','1434123412',convert(DATE,'2020-11-14'),'C');

Create table PercentageDiscount(
userCategory varchar(3),
DiscountPercent int
);

insert into PercentageDiscount values('E',30);
insert into PercentageDiscount values('A',10);
insert into PercentageDiscount values('C',5);


create table priceDiscount(
cutOffAmt int,
discount int);

insert into priceDiscount values (100,5);

