package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import java.util.List;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.*;
import edu.eci.cvds.samples.entities.*;
import java.util.Date;
import org.apache.ibatis.exceptions.PersistenceException;

public class MyBATISUsuarioDAO implements UsuarioDAO {

	@Inject
	private UsuarioMapper usuarioMapper;

	@Override
	public void insertarUsuario(Usuario usuario) throws PersistenceException {
		try {
			usuarioMapper.insertarUsuario(usuario);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al registrar el usuario " + usuario.toString(), e);
		}

	}

	@Override
	public Usuario consultarUsuario(long id) throws PersistenceException {
		try {
			return usuarioMapper.consultarUsuario(id);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al consultar el usuario: " + id, e);
		}

	}

	@Override
	public Usuario consultarUsuarioPorCorreo(String correo) throws PersistenceException {
		try {
			return usuarioMapper.consultarUsuarioPorCorreo(correo);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al consultar el usuario: " + correo, e);
		}

	}

	@Override
	public List<Usuario> consultarUsuarios() throws PersistenceException {
		try {
			return usuarioMapper.consultarUsuarios();
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al consultar los Usuarios ", e);
		}
	}

	@Override
	public void agregarRecursoReservadoAUsuario(long id, Recurso recurso, Date fechaIni, Date fechaFin) throws PersistenceException {
		try {
			//usuarioMapper.agregarRecursoRentadoAUsuario(id, recurso.getId(), fechaIni, fechaFin);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al registrar el recurso al usuario:" + id, e);
		}
	}

	@Override
	public List<RecursoReservado> consultarRecursosReservadosUsuario(long id) throws PersistenceException {
		try {
			//return usuarioMapper.consultarRecursosRentadosUsuario(id);
		} catch (PersistenceException e) {
			throw new PersistenceException("Error (P) al consultar los recursos rentados del cliente" + id, e);
		}
		return null;
	}

}
