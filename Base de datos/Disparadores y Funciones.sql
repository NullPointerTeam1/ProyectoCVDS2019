
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
------------------------------------------ Recursos ---------------------------------------------
---------------Identificador---------------------------------------------------------------------
create function public.BU_Recursos_Identificador()
	returns trigger
	language 'plpgsql'
as $BODY$
DECLARE x INT;
begin
	select max(identificador) into x from recursos;
	new.identificador:= x + 1;
	return new.identificador;
end;
$BODY$

create trigger BU_Recursos_Identificador
before insert on recursos
for each row
execute procedure BU_Recursos_Identificador();

---------------diponibilidad---------------------------------------------------------------------

create function public.BU_Recursos_Disponibilidad()
	returns trigger
	language 'plpgsql'
as $BODY$
begin
	new.disponibilidad:='Disponible';
	return new;
end;
$BODY$

create trigger BU_Recursos_Disponibilidad
before insert on recursos
for each row
execute procedure BU_Recursos_Disponibilidad();
------------------------------------------ reservados--------------------------------------------
---------------Identificador---------------------------------------------------------------------
create function public.BU_Reservados_Identificador()
	returns trigger
	language 'plpgsql'
as $BODY$
DECLARE x INTEGER;
begin
	select max(id) into x from reservados;
	new.id:= x + 1;
	return new;
end;
$BODY$

create trigger BU_Reservados_Identificador
before insert on reservados
for each row
execute procedure BU_Reservados_Identificador();

