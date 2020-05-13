create table OTHERSCHEMA.PROGRAMACION (ID_PROGRAMACION bigint generated by default as identity, ES_ACTIVO smallint not null, FECHA_HORA_CREACION timestamp not null, FECHA_HORA_SIGUIENTE_EJECUCION timestamp not null, FECHA_HORA_ULTIMA_EJECUCION timestamp, HORA_PROGRAMACION time not null, NOMBRE_USUARIO varchar(12) not null, PROGRAMACION_HUSO varchar(12) not null, ID_TIPO_AMBITO integer not null, primary key (ID_PROGRAMACION))
create table OTHERSCHEMA.PROGRAMACION_AMBITO (ID_PROGRAMACION_AMBITO bigint generated by default as identity, ID_ORGANIZATION varchar(48) not null, ID_PROGRAMACION bigint not null, primary key (ID_PROGRAMACION_AMBITO))
create table OTHERSCHEMA.PROGRAMACION_AMBITO_EMPRESA (ID_PROGRAMACION_AMBITO_EMPRESA bigint generated by default as identity, STD_ID_LEG_ENT varchar(48) not null, ID_PROGRAMACION_AMBITO bigint not null, primary key (ID_PROGRAMACION_AMBITO_EMPRESA))
create table OTHERSCHEMA.PROGRAMACION_AMBITO_LOCALIZACION (ID_PROGRAMACION_AMBITO_LOCALIZACION bigint generated by default as identity, CCL_ID_ORIGEN varchar(48) not null, STD_ID_LEG_ENT varchar(48) not null, STD_ID_WORK_LOCAT varchar(48) not null, ID_PROGRAMACION_AMBITO bigint not null, primary key (ID_PROGRAMACION_AMBITO_LOCALIZACION))
create table OTHERSCHEMA.PROGRAMACION_AMBITO_ORIGEN (ID_PROGRAMACION_AMBITO_ORIGEN bigint generated by default as identity, CCL_ID_ORIGEN varchar(48) not null, ID_PROGRAMACION_AMBITO bigint not null, primary key (ID_PROGRAMACION_AMBITO_ORIGEN))
create table OTHERSCHEMA.PROGRAMACION_AMBITO_PERSONA (ID_PROGRAMACION_AMBITO_PERSONA bigint generated by default as identity, CCL_ID_ORIGEN varchar(48) not null, CCL_ID_PERSON varchar(48) not null, STD_ID_LEG_ENT varchar(48) not null, STD_OR_HR_PERIOD varchar(48) not null, ID_PROGRAMACION_AMBITO bigint not null, primary key (ID_PROGRAMACION_AMBITO_PERSONA))
create table OTHERSCHEMA.TIPO_AMBITO (ID_TIPO_AMBITO integer not null, NOMBRE varchar(32) not null, primary key (ID_TIPO_AMBITO))
alter table OTHERSCHEMA.PROGRAMACION add constraint FK8riu3w982tfkan73ps03lnlyi foreign key (ID_TIPO_AMBITO) references OTHERSCHEMA.TIPO_AMBITO
alter table OTHERSCHEMA.PROGRAMACION_AMBITO add constraint FK7sp11oihfb7oqcnofwigx031v foreign key (ID_PROGRAMACION) references OTHERSCHEMA.PROGRAMACION
alter table OTHERSCHEMA.PROGRAMACION_AMBITO_EMPRESA add constraint FKsxkmv07wpb6n5ppkjhvimw2yq foreign key (ID_PROGRAMACION_AMBITO) references OTHERSCHEMA.PROGRAMACION_AMBITO
alter table OTHERSCHEMA.PROGRAMACION_AMBITO_LOCALIZACION add constraint FK3e6uvkq268l282rop608uyo1b foreign key (ID_PROGRAMACION_AMBITO) references OTHERSCHEMA.PROGRAMACION_AMBITO
alter table OTHERSCHEMA.PROGRAMACION_AMBITO_ORIGEN add constraint FKnjotatsoygwncuva0p50akfj8 foreign key (ID_PROGRAMACION_AMBITO) references OTHERSCHEMA.PROGRAMACION_AMBITO
alter table OTHERSCHEMA.PROGRAMACION_AMBITO_PERSONA add constraint FKmi7b0no8d6o7jp4768dml29dl foreign key (ID_PROGRAMACION_AMBITO) references OTHERSCHEMA.PROGRAMACION_AMBITO
