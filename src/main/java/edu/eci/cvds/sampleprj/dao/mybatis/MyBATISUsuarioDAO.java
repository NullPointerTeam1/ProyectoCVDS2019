package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.Singleton;

import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import java.sql.SQLException;
import java.sql.Date;

import org.apache.ibatis.exceptions.PersistenceException;

public class MyBATISUsuarioDAO implements UsuarioDAO{

	@Inject
	private UsuarioMapper UsuarioMapper;    

	@Override
	public void save(Usuario cli) throws PersistenceException{
		
		try{

			UsuarioMapper.agregarUsuario(cli);

		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al registrar un Usuario "+cli.toString(),e);
		}        

	}

	@Override
	public Usuario load(long id) throws ExcepcionServiciosAlquiler {
		Usuario Usuario = null;
		try{
			Usuario = UsuarioMapper.consultarUsuario(id);
			if (Usuario == null) {
				throw new ExcepcionServiciosAlquiler("Error al consultar");
			}
		} catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,e);
		}
		return Usuario;

	}

	@Override
	public void agregarItemRentado(long docu, Item item, Date fechaini,Date fechafin) {
		try{
			UsuarioMapper.agregarItemRentadoAUsuario(docu, item.getId(), fechaini,fechafin); 
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al registrar el item al Usuario "+docu,e);
		} 
	}
	
	@Override
	public List<Usuario> consultarUsuarios() throws ExcepcionServiciosAlquiler {
		
		List<Usuario> Usuarios = new ArrayList<Usuario>();
		try{
			Usuarios = UsuarioMapper.consultarUsuarios();
	
		} catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new ExcepcionServiciosAlquiler("Error al consultar los Usuarios ",e);
		}
		return Usuarios;

	}
	
}