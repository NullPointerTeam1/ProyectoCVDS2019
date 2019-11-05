package edu.eci.cvds.sampleprj.dao;

import java.util.List;
import edu.eci.cvds.samples.entities.Recurso;

public interface RecursoDAO {

	public void insertarRecurso(Recurso it) throws PersistenceException;

	public Recurso consultarRecurso(long id) throws PersistenceException;

	public List<Recurso> consultarRecursos() throws PersistenceException;
	
	public void actualizarEstadoRecurso(long id, String estado) throws PersistenceException;

}