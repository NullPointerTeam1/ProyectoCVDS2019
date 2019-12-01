
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
CREATE SEQUENCE recurso_sequence
  start 1
  increment 1;
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
CREATE SEQUENCE TIPO_RECURSO_sequence
  start 1
  increment 1;

 CREATE SEQUENCE reservados_sequence
  start 1
  increment 1;

create function public.BU_Reservados_Estado()
	returns trigger
	language 'plpgsql'
as $BODY$
begin
	new.estado:='Activa';
	new.fechaDeReserva:=current_date;
	return new;
end;
$BODY$

create trigger BU_Reservados_Estado
before insert on reservados
for each row
execute procedure BU_Reservados_Estado();
