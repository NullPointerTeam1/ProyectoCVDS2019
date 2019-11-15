package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.TipoRecursoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.*;
import edu.eci.cvds.samples.entities.TipoRecurso;
import java.util.List;
import org.apache.ibatis.exceptions.PersistenceException;

public class MyBATISTipoRecursoDAO implements TipoRecursoDAO {

	@Inject
	private TipoRecursoMapper tipoRecursoMapper;

	@Override
	public void insertarTipoRecurso(TipoRecurso ti) throws PersistenceException {
		try {
			tipoRecursoMapper.insertarTipoRecurso(ti);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al registrar el tipo recurso " + ti.toString(), e);
		}
	}

	@Override
	public TipoRecurso consultarTipoRecurso(long id) throws PersistenceException {
		try {
			return tipoRecursoMapper.consultarTipoRecurso(id);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al consultar el tipo Recurso " + id, e);
		}
	}

	@Override
	public List<TipoRecurso> consultarTiposRecurso() throws PersistenceException {
		try {
			return tipoRecursoMapper.consultarTiposRecurso();
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al consultar los tipos del recurso", e);
		}
	}

}

