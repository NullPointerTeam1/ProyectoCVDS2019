package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.*;
import java.util.Date;
import java.util.List;

public interface UsuarioDAO {

	void insertarUsuario(Usuario usuario) throws PersistenceException;

	public Usuario consultarUsuario(long id) throws PersistenceException;

	public List<Usuario> consultarUsuarios() throws PersistenceException;

	public void agregarRecursoReservadoAUsuario(long id, Recurso recurso, Date fechaIni, Date fechaFin)
			throws PersistenceException;

	public List<RecursoReservado> consultarRecursosReservadosUsuario(long id) throws PersistenceException;

	public Usuario consultarUsuarioPorCorreo(String correo) throws PersistenceException;
}
