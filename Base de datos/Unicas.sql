alter table usuarios
add constraint Uk_usuarios_correo
unique (correo);