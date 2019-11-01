create trigger Login_actualiza
before update of correo
on login
for each row
begin
	raise_application_error(-20001,'Solo se puede actualizar el correo.' );
end;
execute procedure Login_actualiza

insert into login(correo, contrasena) values('jose','jjj');
update login set correo='hola' where correo='jose';
delete from login;