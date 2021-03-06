package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.RecursoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.*;
import edu.eci.cvds.samples.entities.Recurso;
import java.util.List;
import org.apache.ibatis.exceptions.PersistenceException;

public class MyBATISRecursoDAO implements RecursoDAO {

	@Inject
	private RecursoMapper recursoMapper;

	@Override
	public void insertarRecurso(Recurso it) throws PersistenceException {
		try {
			recursoMapper.insertarRecurso(it);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al insertar el recurso " + it.toString(), e);
		}

	}

	@Override
	public Recurso consultarRecurso(long id) throws PersistenceException {
		try {
			return recursoMapper.consultarRecurso(id);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al consultar el Recurso " + id, e);
		}
	}

	@Override
	public List<Recurso> consultarRecursos() throws PersistenceException {
		try {
			return recursoMapper.consultarRecursos();
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al consultar los recursos", e);
		}
	}

	@Override
	public void actualizarEstadoRecurso(long id, String estado) throws PersistenceException {
		try {
			recursoMapper.actualizarEstadoRecurso(id, estado);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al actualizar el estado del recurso" + id, e);
		}
	}
	
	

}

