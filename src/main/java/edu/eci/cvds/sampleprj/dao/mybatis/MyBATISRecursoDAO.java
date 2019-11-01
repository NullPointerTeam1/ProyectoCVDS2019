package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.RecursoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.RecursoMapper;
import edu.eci.cvds.samples.entities.TipoRecurso;
import edu.eci.cvds.samples.services.ExcepcionServiciosBiblioteca;

import java.sql.SQLException;

import org.apache.ibatis.exceptions.PersistenceException;

public class MyBATISRecursoDAO implements RecursoDAO{

	@Inject
	private RecursoMapper RecursoMapper;    

	@Override
	public void insertar(Recurso it) throws PersistenceException{
		try{
			RecursoMapper.insertarRecurso(it);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al registrar el Recurso "+it.toString(),e);
		}        

	}

	@Override
	public Recurso consultar(int id) throws ExcepcionServiciosBiblioteca{
		Recurso Recurso = null;
		try{
			 Recurso= RecursoMapper.consultarRecurso(id);
			 if (Recurso == null) {
				  throw new ExcepcionServiciosBiblioteca("Error al consultar");
			  }
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar el Recurso "+id,e);
		}
		return Recurso;
	}

}
