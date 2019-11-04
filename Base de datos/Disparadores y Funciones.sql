
------------------------------------------ Usuarios ---------------------------------------------

--------------- Correo --------------------------------------------------------------------------

create function public.BU_USUARIOS_CORREO()
	returns trigger
	language 'plpgsql'
as $BODY$
begin
	RAISE EXCEPTION 'No puede actualizar el correo.';
end;
$BODY$

create trigger BU_USUARIOS_CORREO
before update of correo on usuarios
for each row
execute procedure BU_USUARIOS_CORREO();

--------------- Carnet --------------------------------------------------------------------------

create function public.BU_USUARIOS_CARNET()
	returns trigger
	language 'plpgsql'
as $BODY$
begin
	RAISE EXCEPTION 'No puede actualizar el carnet.';
end;
$BODY$

create trigger BU_USUARIOS_CARNET
before update of carnet on usuarios
for each row
execute procedure BU_USUARIOS_CARNET();
