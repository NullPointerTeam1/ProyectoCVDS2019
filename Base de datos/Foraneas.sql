ALTER TABLE recursos
ADD CONSTRAINT FK_Recurso_Tipo
FOREIGN KEY (tiporecurso_id) references tipo_recurso(id);

ALTER TABLE usuarios 
ADD CONSTRAINT fk_ususario_rol 
FOREIGN KEY (correo) REFERENCES user_roles(correo);

alter table no_disponibles 
add constraint FK_No_Disponibles
foreign key (id_recurso) references recursos(identificador);