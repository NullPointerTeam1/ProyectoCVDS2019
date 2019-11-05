create table if not exists USUARIOS(
	carnet int  primary key,
	nombre varchar(15) not null,
	apellido varchar(15) not null,
	carrera varchar(16)not null,
	correo varchar(100)not null,
	rol varchar(1) not null,
	contrasena varchar(300) not null
);

create table if not exists RECURSOS(
	identificador int primary key,
	nombre varchar(15)not null,
	ubicacion varchar(15)not null,
	capacidad int,
	horario_disponibilidad date,
	diponibilidad varchar(1) not null,
	tiporecurso_id int NOT NULL
);

CREATE TABLE IF NOT EXISTS TIPO_RECURSO (
	id INT primary key,
	descripcion VARCHAR(50)  NOT NULL
);
create table if not exists user_roles(
	correo varchar(100) primary key,
	role_name varchar(30) not null
);