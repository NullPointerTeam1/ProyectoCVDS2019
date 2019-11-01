package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;
import java.sql.SQLException;

import org.apache.ibatis.exceptions.PersistenceException;

public class MyBATISTipoItemDAO implements TipoItemDAO{

	@Inject
	private TipoItemMapper TipoitemMapper;    

	@Override
	public void save(TipoItem ti) throws PersistenceException{
		try{
			TipoitemMapper.insertarTipoItem(ti);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al registrar el tipo del item "+ti.toString(),e);
		}        
	}
	@Override
	public TipoItem load(int id) throws PersistenceException {
		try{
			return TipoitemMapper.getTipoItem(id);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar el tipo del item "+id,e);
		}
	}

}
