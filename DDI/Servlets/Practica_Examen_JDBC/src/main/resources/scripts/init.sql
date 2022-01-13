create table IF NOT EXISTS TITULACIONES(
                                           id     bigint auto_increment PRIMARY KEY,
                                           titulo varchar(25)
);

create table IF NOT EXISTS ALUMNOS
(
    id         bigint auto_increment PRIMARY KEY,
    nombre     varchar(25),
    edad       bigint,
    titulacion INT,
    FOREIGN KEY (titulacion) REFERENCES TITULACIONES (id)
);
