/**

Script de creacion de tablas para base de datos BIBLIOTECA

db_usuario : biblioteca_user
db_pass : biblioteca_pass

**/


/* tabla usuarios */
create table usuarios(
    id_usuario serial not null primary key,
    rut_usuario varchar(10) not null unique,
    pass_usuario varchar(250) not null,
    nombres_usuario varchar(60) not null,
    apellidos_usuario varchar(60) not null
)default charset=utf8 auto_increment=1;


/* tabla alumnos */
create table alumnos(
    id_alumno serial not null primary key,
    rut_alumno varchar(10) not null unique,
    nombres_alumno varchar(60) not null,
    apellidos_alumno varchar(60) not null,
    nacimiento_alumno date not null,
    sexo_alumno varchar(10) not null comment 'MASCULINO o FEMENINO',
    direccion_alumno varchar(500) default null
)default charset=utf8 auto_increment=1;


/* tabla generos */
create table generos(
    id_genero tinyint not null primary key,
    nombre_genero varchar(50) not null
) default charset=utf8;

insert into generos values(1, 'Ciencia Ficción');
insert into generos values(2, 'Literatura Española');
insert into generos values(3, 'Literatura Angloamericana');
insert into generos values(4, 'Infantil');
insert into generos values(5, 'Ciencias Exactas');
insert into generos values(6, 'Ciencias Sociales');
insert into generos values(7, 'Ciencias Naturales');
insert into generos values(8, 'Otros');


/* tabla libros */
create table libros(
    id_libro serial not null primary key,
    codigo_libro varchar(15) not null unique comment 'codigo ISBN',
    descripcion_libro varchar(1000) not null,
    cantidad_libro int not null default 0,
    ingreso_libro date not null,
    genero_fk_libro tinyint not null,

    constraint fk_genero_libro foreign key (genero_fk_libro) references generos(id_genero)
) default charset=utf8 auto_increment=1;


/* tabla prestamos */
create table prestamos(
    id_prestamo bigint not null primary key,
    devolucion_prestamo date not null,
    alumno_fk_prestamo bigint unsigned not null,
    libro_fk_prestamo bigint unsigned not null,
    estado_prestamo boolean default 1 comment '1: prestado; 2:devuelto',

    constraint fk_alumno_prestamo foreign key (alumno_fk_prestamo) references alumnos(id_alumno),
    constraint fk_libro_prestamo foreign key (libro_fk_prestamo) references libros(id_libro)
)default charset=utf8 auto_increment=1;
