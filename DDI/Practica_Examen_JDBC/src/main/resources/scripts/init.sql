create table IF NOT EXISTS TITULACIONES (
    id bigint auto_increment,
    titulo varchar(25)
);

create table IF NOT EXISTS ALUMNOS (
    id bigint auto_increment,
    nombre varchar(25),
    edad bigint,
    titulacion INT,
    FOREIGN KEY (titulacion) REFERENCES TITULACIONES(id)
);


ALTER TABLE IF EXISTS ALUMNOS
    ADD FOREIGN KEY (titulacion)
        REFERENCES TITULACIONES(id)
