alter table Usuarios
add constraint FK_Usuario_login
foreign key (correo) references Login(Correo);