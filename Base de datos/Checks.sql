ALTER TABLE login
ADD CONSTRAINT  CK_login_correo
CHECK ((correo NOT LIKE '%@hotmail.com' or correo NOT LIKE '%@gmail.com' or correo NOT LIKE '%@yahoo.com') );

ALTER TABLE usuarios
ADD CONSTRAINT  CK_usuarios_correo
CHECK ((correo NOT LIKE '%@hotmail.com' or correo NOT LIKE '%@gmail.com' or correo NOT LIKE '%@yahoo.com'));

ALTER TABLE recursos
ADD CONSTRAINT  CK_recursos_disponibilidad
CHECK(diponibilidad ='d' or diponibilidad= 'D' or diponibilidad = 'O' or diponibilidad = 'o' or diponibilidad = 'N' or diponibilidad = 'n');

