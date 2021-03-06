package edu.eci.cvds.sampleprj.dao;

import java.util.List;
import edu.eci.cvds.samples.entities.TipoRecurso;

public interface TipoRecursoDAO {

	public void insertarTipoRecurso(TipoRecurso ti) throws PersistenceException;

	public TipoRecurso consultarTipoRecurso(long id) throws PersistenceException;

	public List<TipoRecurso> consultarTiposRecurso() throws PersistenceException;

}
