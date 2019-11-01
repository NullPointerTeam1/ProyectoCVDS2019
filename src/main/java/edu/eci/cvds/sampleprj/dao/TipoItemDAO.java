package edu.eci.cvds.sampleprj.dao;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.TipoItem;

public interface TipoItemDAO {

	void save(TipoItem ti) throws PersistenceException;

	TipoItem load(int id) throws PersistenceException;

}
