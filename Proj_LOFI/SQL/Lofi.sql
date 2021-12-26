create database LofiP;
use LofiP;

create table userInfo(
Nationality   char,
Certify         char, 
uID        char(20) primary key,
uPw             char(20),
uZip             char(100),
uAddr1         char(100),
uAddr2         char(100)
);

desc userInfo;
-- --/////////////////////////////////--  -- 

select*from userInfo;
delete from userInfo where uID = '';

-- --/////////////////////////////////--  -- 
insert into userInfo values('','','','','','','');

-- --/////////////////////////////////--  -- 




drop table !userInfo;