CREATE DATABASE Alumnos_DDI;
USE Alumnos_DDI;

create table IF NOT EXISTS TITULACIONES(
    id      bigint auto_increment PRIMARY KEY,
    titulo  varchar(25)
);

create table IF NOT EXISTS ALUMNOS (
    id         bigint auto_increment PRIMARY KEY,
    nombre     varchar(25),
    edad       bigint,
    titulacion_id bigint
);

alter table ALUMNOS
    add constraint ALUMNOS_TITULACIONES_id_fk
        foreign key (titulacion_id) references TITULACIONES (id);
