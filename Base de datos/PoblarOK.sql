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
insert into recursos(identificador, nombre, ubicacion, capacidad, horarioi, horariof, tiporecurso_id)values (nextval('recurso_sequence'), 'MODELOS MATEMATICOS', 'Biblioteca Jorge Álvarez Lleras', 15, '07:00:00', '19:00:00', 2);

insert into reservados (idr, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '11/13/2019', '8:00:00', '11/13/2019', '10:00:00', 2148781, 3);
insert into reservados (idr, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '11/29/2019', '9:48:00', '11/29/2019', '11:00:00', 2148781, 2);
insert into reservados (idr, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '11/18/2019', '12:57:00', '11/18/2019', '2:57:00', 2148781, 1);
insert into reservados (idr, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '11/8/2018', '13:51:00', '11/8/2019', '14:35:00', 2148781, 2);
insert into reservados (idr, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '11/19/2019', '15:33:00', '11/19/2018', '16:44:00', 2148781, 1);
insert into reservados (idr, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '11/22/2019', '7:34:00', '11/22/2019', '8:31:00', 2148781, 1);
insert into reservados (idr, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '11/2/2019', '9:41:00', '11/2/2019', '10:03:00', 2148781, 3);
insert into reservados (idr, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '11/3/2018', '12:54:00', '11/3/2019', '13:59:00', 2148781, 1);
insert into reservados (idr, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '11/30/2019', '15:57:00', '11/30/2019', '17:00:00', 2148781, 8);
insert into reservados (idr, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '11/23/2019', '7:01:00', '11/23/2019', '9:00:00', 2148781, 1);
insert into reservados (idr, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '11/8/2019', '9:10:00', '11/8/2019', '9:50:00', 2148781, 11);
insert into reservados (idr, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '11/4/2019', '11:10:00', '11/4/2019', '11:59:00', 2148781, 1);
insert into reservados (idr, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, usuario, recurso) values (nextval('reservados_sequence'), '11/12/2018', '10:14:00', '11/12/2019', '11:14:00', 2148781, 10);
insert into reservados (idr, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, recurrente, usuario, recurso) values (nextval('reservados_sequence'), '11/13/2018', '9:14:00', '11/13/2019', '8:48:00', 13, 2148781, 10);
insert into reservados (idr, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, recurrente, usuario, recurso) values (nextval('reservados_sequence'), '11/14/2018', '9:14:00', '11/14/2019', '8:48:00', 13, 2148781, 10);
insert into reservados (idr, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, recurrente, usuario, recurso) values (nextval('reservados_sequence'), '11/15/2018', '9:14:00', '11/15/2019', '8:48:00', 13, 2148781, 10);
insert into reservados (idr, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, recurrente, usuario, recurso) values (nextval('reservados_sequence'), '11/5/2018', '9:14:00', '11/5/2019', '8:48:00', 12, 2148781, 1);
insert into reservados (idr, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, recurrente, usuario, recurso) values (nextval('reservados_sequence'), '11/6/2018', '9:14:00', '11/6/2019', '8:48:00', 12, 2148781, 1);
insert into reservados (idr, fechainicioreserva, horainicioreserva, fechafinreserva, horafinreserva, recurrente, usuario, recurso) values (nextval('reservados_sequence'), '11/7/2018', '9:14:00', '11/7/2019', '8:48:00', 12, 2148781, 1);


--alter sequence reservados_sequence restart with 1;
--delete from reservados;
--delete from reservados where idr = (select max(idr) from reservados);
