ALTER TABLE recursos
ADD CONSTRAINT FK_Recurso_Tipo
FOREIGN KEY (tiporecurso_id) references tipo_recurso(id);

alter table reservados 
add constraint Fk_reserva_usuario
foreign key (usuario) references usuarios(carnet);

alter table reservados
add constraint Fk_reserva_recurso
foreign key (recurso) references recursos(identificador);

alter table reservados
add constraint FK_reserva_recurente
foreign key (recurrente) references reservados(idr);