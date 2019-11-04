ALTER TABLE recursos
ADD CONSTRAINT FK_Recurso_Tipo
FOREIGN KEY (tiporecurso_id) references tipo_recurso(id);