insert into usuarios(carnet, nombre, apellido, carrera, correo, rol, contrasena)values('2148781', 'jose', 'gomez', 'sistemas', 'jose.gomez-ca@mail.escuelaing.edu.co', 'A', '15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225');
insert into usuarios(carnet, nombre, apellido, carrera, correo, rol, contrasena)values('2148782', 'johann', 'paez', 'sistemas', 'johann.paez@mail.escuelaing.edu.co', 'A', '15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225');
insert into usuarios(carnet, nombre, apellido, carrera, correo, rol, contrasena)values('2148783', 'prueba', '2019', 'sistemas', 'prueba.2019@mail.escuelaing.edu.co', 'U', '15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225');  

insert into tipo_recurso(id,descripcion)values(1 ,'Equipo de Computo');
insert into tipo_recurso(id,descripcion)values(2 ,'Sala de Estudio');
insert into tipo_recurso(id,descripcion)values(3 ,'Equipo Multimedia');

insert into recursos(identificador, nombre, ubicacion, capacidad, horarioi, horariof, tiporecurso_id)values (nextval('recurso_sequence'),'Computador 1', 'Bloque B', 15, '07:00:00', '19:00:00', 1);
insert into recursos(identificador, nombre, ubicacion, capacidad, horarioi, horariof, tiporecurso_id)values (nextval('recurso_sequence'), 'Computador 2', 'Bloque B', 15, '07:00:00', '19:00:00', 1);
insert into recursos(identificador, nombre, ubicacion, capacidad, horarioi, horariof, tiporecurso_id)values (nextval('recurso_sequence'), 'Computador 3', 'Bloque B', 15, '07:00:00', '19:00:00', 1);
insert into recursos(identificador, nombre, ubicacion, capacidad, horarioi, horariof, tiporecurso_id)values (nextval('recurso_sequence'), 'Computador 4', 'Bloque B', 15, '07:00:00', '19:00:00', 1);
insert into recursos(identificador, nombre, ubicacion, capacidad, horarioi, horariof, tiporecurso_id)values (nextval('recurso_sequence'), 'Computador 5', 'Bloque B', 15, '07:00:00', '19:00:00', 1);
insert into recursos(identificador, nombre, ubicacion, capacidad, horarioi, horariof, tiporecurso_id)values (nextval('recurso_sequence'), 'Computador 6', 'Bloque B', 15, '07:00:00', '19:00:00', 1);
insert into recursos(identificador, nombre, ubicacion, capacidad, horarioi, horariof, tiporecurso_id)values (nextval('recurso_sequence'), 'Computador 7', 'Bloque B', 15, '07:00:00', '19:00:00', 1);
insert into recursos(identificador, nombre, ubicacion, capacidad, horarioi, horariof, tiporecurso_id)values (nextval('recurso_sequence'), 'Computador 8', 'Bloque B', 15, '07:00:00', '19:00:00', 1);
insert into recursos(identificador, nombre, ubicacion, capacidad, horarioi, horariof, tiporecurso_id)values (nextval('recurso_sequence'), 'Computador 9', 'Bloque B', 15, '07:00:00', '19:00:00', 1);
insert into recursos(identificador, nombre, ubicacion, capacidad, horarioi, horariof, tiporecurso_id)values (nextval('recurso_sequence'), 'Computador 10', 'Bloque B', 15, '07:00:00', '19:00:00', 1);
insert into recursos(identificador, nombre, ubicacion, capacidad, horarioi, horariof, tiporecurso_id)values (nextval('recurso_sequence'), 'Computador 11', 'Bloque B', 15, '07:00:00', '19:00:00', 1);
insert into recursos(identificador, nombre, ubicacion, capacidad, horarioi, horariof, tiporecurso_id)values (nextval('recurso_sequence'), 'calculo de una variable james stewart', 'Biblioteca Jorge Álvarez Lleras', 15, '07:00:00', '19:00:00', 2);
insert into recursos(identificador, nombre, ubicacion, capacidad, horarioi, horariof, tiporecurso_id)values (nextval('recurso_sequence'), 'APRENDIENDO A PROGRAMAR A PARTIR DE CERO', 'Biblioteca Jorge Álvarez Lleras', 15, '07:00:00', '19:00:00', 2);




select * from recursos;

