

insert into user_roles(correo, role_name) values('jose.gomez-ca@mail.escuelaing.edu.co', 'A');
insert into user_roles(correo, role_name) values('jordi.el-nino@mail.escuelaing.edu.co', 'u');
insert into user_roles(correo, role_name) values('prueba.2019@mail.escuelaing.edu.co', 'u');

insert into usuarios(carnet, nombre, apellido, carrera, correo, rol, contrasena)values('2148781', 'jose', 'gomez', 'sistemas', 'jose.gomez-ca@mail.escuelaing.edu.co', 'A', '123456789');
insert into usuarios(carnet, nombre, apellido, carrera, correo, rol, contrasena)values('2148782', 'jordi', 'nino', 'sistemas', 'jordi.el-nino@mail.escuelaing.edu.co', 'u', '123456789');
insert into usuarios(carnet, nombre, apellido, carrera, correo, rol, contrasena)values('2148783', 'prueba', '2019', 'sistemas', 'prueba.2019@mail.escuelaing.edu.co', 'u', '123456789');  

insert into tipo_recurso(id,descripcion)values(1 ,'1. Equipo de Computo');
insert into tipo_recurso(id,descripcion)values(2 ,'2. Sala de Estudio');
insert into tipo_recurso(id,descripcion)values(3 ,'3. Equipo Multimedia');
insert into tipo_recurso(id,descripcion)values(4 ,'Equipo de Computo');
insert into tipo_recurso(id,descripcion)values(5 ,'Sala de Estudio');
insert into tipo_recurso(id,descripcion)values(6 ,'Equipo Multimedia');