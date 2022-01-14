create table guitarra (
 id int(11) not null auto_increment,
 marca varchar(45) not null,
 tipo varchar(45) not null,
 referencia varchar(45) not null,
 precio double(11) not null,
 enviado boolean not null,
 primary key (id)
);

create table empresa (
 id int(11) not null auto_increment,
 nombre varchar(45) not null,
 nit varchar(45) not null,
 primary key (id)
);

create table envio (
 id int(11) not null auto_increment,
 id_guitarra int(11) not null,
 id_empresa int(11) not null,
 fecha_envio datetime null,
 valor_total double(11) not null,
 fecha_entrega datetime null,
 primary key (id)
);

INSERT INTO empresa VALUES
(1, 'Mi Guitarra', '839472394'),
(2, 'Armonia Musical', '748390565'),
(3, 'La Nota Musical', '340622509');

INSERT INTO guitarra VALUES
(1, 'Gibson', 'LessPaul', '269285', 2500, false),
(2, 'Fender', 'LessPaul', '269555', 3500, false);

INSERT INTO envio VALUES
(1, 1, 2, '2022-01-07', 2700, '2022-01-12');