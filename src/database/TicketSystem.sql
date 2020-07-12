create database HighWayTicketSystem;

use HighWayTicketSystem;

use master

ALTER DATABASE HighWayTicketSystem
    SET SINGLE_USER WITH ROLLBACK IMMEDIATE

ALTER DATABASE HighWayTicketSystem
    COLLATE Chinese_PRC_CI_AS

ALTER DATABASE HighWayTicketSystem
    SET MULTI_USER

drop table train;

-- Train表
create table train(
    id int primary key ,
    TrainId varchar(30) not null ,
    StartStation int not null ,
    EndStation int not null ,
    StartDate varchar(30) not null ,
    EndDate varchar(30) not null ,
    service int not null ,
)
drop table train;
select * from train;
select * from train where TrainId = 'C1002';

-- station 表
create table station(
    id int primary key ,
    name varchar(30) not null ,
    latitude decimal(12, 6) not null,
    longitude decimal(12, 5) not null ,
)
select * from station;

-- pass 表
create table pass(
    id int primary key ,
    TrainId int not null ,
    StationOrder int not null ,
    StationId int not null ,
    ArrivalTime varchar(30) not null ,
    SetOffTime varchar(30) not null ,
)
drop table pass;
select * from pass;

-- user表
create table costumer(
    Id int primary key ,
    UserName varchar(30) not null ,
    Password varchar(30) not null ,
    UserId varchar(20) not null ,
    RealName varchar(20) not null ,
    Sex bit not null ,
)
drop table costumer;
select * from costumer;

-- ticket表
create table ticket(
    TicketId int primary key ,
    CostumerId int not null ,
    BookTime varchar(20) not null ,
    TrainId varchar(30) not null ,
    StartStation int not null ,
    EndStation int not null ,
    Car int not null ,
    CarRow int not null ,
    CarColumn int not null ,
    BuyStatus int not null ,
    BuyLocation int not null ,
    BuyDate datetime not null ,
)
drop table ticket;
select * from ticket;
