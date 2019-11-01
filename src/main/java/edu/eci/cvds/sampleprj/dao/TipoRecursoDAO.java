package edu.eci.cvds.sampleprj.dao;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.TipoRecurso;

public interface TipoRecursoDAO {

	void save(TipoRecurso ti) throws PersistenceException;

	TipoRecurso load(int id) throws PersistenceException;

}
