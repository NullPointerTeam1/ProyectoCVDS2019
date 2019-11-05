
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
---------------diponibilidad---------------------------------------------------------------------

create function public.BU_Recursos_Disponibilidad()
	returns trigger
	language 'plpgsql'
as $BODY$
begin
	new.diponibilidad:='d';
end;
$BODY$

create trigger BU_Recursos_Disponibilidad
before insert on recursos
for each row
execute procedure BU_Recursos_Disponibilidad();
---------------NO Disponibles---------------------------------------------------------------------

create function public.BU_Recursos_Dano()
	returns trigger
	language 'plpgsql'
as $BODY$
begin
	IF (new.diponibilidad != 'N' or new.diponibilidad != 'n')then
		insert into no_disponibles(id_recurso)values(new.identificador);
	end if;
end;
$BODY$

create trigger BU_Recursos_Dano
before update on recursos
for each row
execute procedure BU_Recursos_Dano();

---------------Reparados---------------------------------------------------------------------

create function public.BU_Recursos_arreglo()
	returns trigger
	language 'plpgsql'
as $BODY$
begin
	IF ((old.diponibilidad = 'N' or old.diponibilidad = 'n') and (new.diponibilidad='d' or new.diponibilidad= 'D'))then
		delete from no_disponibles where id_recurso=old.identificador; 
	end if;
end;
$BODY$

create trigger BU_Recursos_arreglo
before update on recursos
for each row
execute procedure BU_Recursos_arreglo();

------------------------------------------ No diponibles ------------------------------------------
------------------------------------------ Automatizar id-------------------------------------------

create function public.BU_No_diponibles_pk()
	returns trigger
	language 'plpgsql'
as $BODY$
declare 
x int;
begin
	select count(*) into x from no_disponibles;
end;
$BODY$

create trigger BU_No_diponibles_pk
before insert
on no_disponibles
for each row
execute procedure BU_No_diponibles_pk();