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
			throw new PersistenceException("Error al registrar el tipo recurso " + ti.toString(), e);
		}
	}

}
