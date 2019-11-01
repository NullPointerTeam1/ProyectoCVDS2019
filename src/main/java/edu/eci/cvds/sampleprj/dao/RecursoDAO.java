package edu.eci.cvds.sampleprj.dao;

import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.services.ExcepcionServiciosBiblioteca;

public interface RecursoDAO {

   public void insertar(Recurso it) throws PersistenceException;

   public Recurso consultar(int id) throws ExcepcionServiciosBiblioteca;

}