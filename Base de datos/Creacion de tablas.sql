create table if not exists LOGIN(
	correo varchar(20) not null primary key,
	contrasena varchar(300) not null
);

create table if not exists USUARIOS(
	carnet int not null primary key,
	nombre varchar(15) not null,
	apellido varchar not null,
	carrera varchar(16)not null,
	correo varchar(20)not null,
	rol varchar(1) not null
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
	id INT NOT NULL,
	descripcion VARCHAR(50)  NOT NULL
);