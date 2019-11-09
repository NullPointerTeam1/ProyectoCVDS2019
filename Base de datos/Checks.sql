ALTER TABLE usuarios
ADD CONSTRAINT  CK_usuarios_correo
CHECK ((correo NOT LIKE '%@hotmail.com' or correo NOT LIKE '%@gmail.com' or correo NOT LIKE '%@yahoo.com'));

ALTER TABLE recursos
ADD CONSTRAINT  CK_recursos_disponibilidad
CHECK(diponibilidad ='d' or diponibilidad= 'D' or diponibilidad = 'O' or diponibilidad = 'o' or diponibilidad = 'N' or diponibilidad = 'n');

ALTER TABLE Usuarios
ADD constraint CK_Usuarios_rol
check(rol='a' or rol='u' or rol='A' or rol='U');

ALTER TABLE tipo_recurso
add constraint CK_recurso_Descripcion
check (descripcion='Equipo de Computo' or descripcion='Sala de Estudio' or descripcion='Equipo Multimedia' or descripcion='1. Equipo de Computo' or descripcion='2. Sala de Estudio' or descripcion='3. Equipo Multimedia');

