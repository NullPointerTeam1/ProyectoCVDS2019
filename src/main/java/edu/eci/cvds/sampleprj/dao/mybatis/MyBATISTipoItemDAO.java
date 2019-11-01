package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.TipoRecursoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.RecursoMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoRecursoMapper;
import edu.eci.cvds.samples.entities.TipoRecurso;
import java.sql.SQLException;

import org.apache.ibatis.exceptions.PersistenceException;

public class MyBATISTipoRecursoDAO implements TipoRecursoDAO{

	@Inject
	private TipoRecursoMapper TipoRecursoMapper;    

	@Override
	public void Recurso(TipoRecurso ti) throws PersistenceException{
		try{
			TipoRecursoMapper.insertarTipoRecurso(ti);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al registrar el tipo del Recurso "+ti.toString(),e);
		}        
	}
	@Override
	public TipoRecurso consultar(int id) throws PersistenceException {
		try{
			return TipoRecursoMapper.getTipoRecurso(id);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar el tipo del Recurso "+id,e);
		}
	}

}
