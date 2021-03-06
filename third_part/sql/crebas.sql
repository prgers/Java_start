/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/3/5 23:24:28                            */
/*==============================================================*/


drop table if exists dict_item;

drop table if exists dict_type;

/*==============================================================*/
/* Table: dict_item                                             */
/*==============================================================*/
create table dict_item
(
   id                   bigint not null auto_increment,
   name                 varchar(15) not null,
   value                varchar(15) not null,
   sn                   int not null default 0 comment '值越小，排序越靠前，默认值为0',
   type_id              bigint not null,
   enabled              int not null default 1 comment '1表示显示，0表示不显示，默认为1',
   primary key (id),
   unique key AK_uk_name (name, type_id),
   unique key AK_uk_value (value, type_id)
);

alter table dict_item comment '数据字典条目';

/*==============================================================*/
/* Table: dict_type                                             */
/*==============================================================*/
create table dict_type
(
   id                   bigint not null auto_increment,
   name                 varchar(15) not null,
   value                varchar(15) not null,
   intro                varchar(100),
   primary key (id),
   unique key AK_uk_name (name),
   unique key AK_uk_value (value)
);

alter table dict_type comment '数据字典类型';

alter table dict_item add constraint FK_Reference_1 foreign key (type_id)
      references dict_type (id) on delete restrict on update restrict;

