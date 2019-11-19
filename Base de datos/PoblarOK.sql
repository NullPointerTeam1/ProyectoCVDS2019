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


insert into reservados (id, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '8/28/2019', '2:27:00', '6/13/2019', '11:31:00', 2148781, 3);
insert into reservados (id, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '1/2/2019', '6:48:00', '5/29/2019', '1:59:00', 2148781, 2);
insert into reservados (id, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '7/7/2019', '1:57:00', '10/18/2019', '10:59:00', 2148781, 1);
insert into reservados (id, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '9/30/2018', '3:51:00', '7/8/2019', '5:35:00', 2148781, 2);
insert into reservados (id, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '11/4/2019', '3:33:00', '11/19/2018', '12:44:00', 2148781, 1);
insert into reservados (id, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '10/18/2019', '10:34:00', '8/22/2019', '6:31:00', 2148781, 1);
insert into reservados (id, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '1/9/2019', '10:41:00', '7/2/2019', '8:03:00', 2148781, 3);
insert into reservados (id, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '8/14/2018', '2:54:00', '10/3/2019', '10:59:00', 2148781, 1);
insert into reservados (id, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '3/11/2019', '3:57:00', '5/31/2019', '5:01:00', 2148781, 3);
insert into reservados (id, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '2/3/2019', '5:01:00', '4/23/2019', '6:40:00', 2148781, 1);
insert into reservados (id, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '3/24/2019', '9:10:00', '1/8/2019', '9:36:00', 2148781, 1);
insert into reservados (id, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '6/6/2019', '11:10:00', '11/3/2019', '11:25:00', 2148781, 1);
insert into reservados (id, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '8/14/2018', '9:14:00', '7/12/2019', '8:48:00', 2148781, 3);

