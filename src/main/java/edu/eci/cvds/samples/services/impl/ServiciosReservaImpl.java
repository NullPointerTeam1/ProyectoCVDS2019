package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.*;
import edu.eci.cvds.sampleprj.dao.*;
import org.mybatis.guice.transactional.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ServiciosReservaImpl implements ServiciosReserva {

	@Inject
	private RecursoDAO recursoDAO;
	@Inject
	private UsuarioDAO usuarioDAO;
	@Inject
	private TipoRecursoDAO tipoRecursoDAO;

	@Override
	@Transactional
	public void registrarUsuario(Usuario usuario) throws ExcepcionServiciosBiblioteca {
		try {
			usuarioDAO.insertarUsuario(usuario);
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al registrar al usuario " + usuario.getCarnet(), e);
		}
	}

	@Override
	public Usuario consultarUsuario(long docu) throws ExcepcionServiciosBiblioteca {
		try {
			Usuario usuario = usuarioDAO.consultarUsuario(docu);
			if (usuario == null)
				throw new ExcepcionServiciosBiblioteca(ExcepcionServiciosBiblioteca.ERROR_CONSULTAR);
			return usuario;

		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al consultar el usuario" + docu, e);
		}
	}

	@Override
	public List<Usuario> consultarUsuarios() throws ExcepcionServiciosBiblioteca {
		try {
			return usuarioDAO.consultarUsuarios();
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al consultar los usuarios", e);
		}
	}

	@Override
	@Transactional
	public void registrarRecurso(Recurso recurso) throws ExcepcionServiciosBiblioteca {
		try {
			recursoDAO.insertarRecurso(recurso);
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al registrar el recurso " + recurso.getId(), e);
		}
	}
	
	@Override
	public Recurso consultarRecurso(long id) throws ExcepcionServiciosBiblioteca {
		try {
			Recurso recurso = recursoDAO.consultarRecurso(id);
			if (recurso == null)
				throw new ExcepcionServiciosBiblioteca(ExcepcionServiciosBiblioteca.ERROR_CONSULTAR);
			return recurso;

		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al consultar el recurso" + id, e);
		}
	}

	@Override
	public List<Recurso> consultarRecursos() throws ExcepcionServiciosBiblioteca {
		try {
			return recursoDAO.consultarRecursos();
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al consultar los recursos", e);
		}
	}

	@Override
	@Transactional
	public void registrarTipoRecurso(TipoRecurso tipoRecurso) throws ExcepcionServiciosBiblioteca {
		try {
			tipoRecursoDAO.insertarTipoRecurso(tipoRecurso);
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al insertar el tipo de recurso " + tipoRecurso.getId(), e);
		}
	}
	
	@Override
	public TipoRecurso consultarTipoRecurso(long id) throws ExcepcionServiciosBiblioteca {
		try {
			TipoRecurso tipoRecurso = tipoRecursoDAO.consultarTipoRecurso(id);
			if (tipoRecurso == null)
				throw new ExcepcionServiciosBiblioteca(ExcepcionServiciosBiblioteca.ERROR_CONSULTAR);
			return tipoRecurso;

		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al consultar el tipo del recurso" + id, e);
		}
	}

	@Override
	public List<TipoRecurso> consultarTiposRecurso() throws ExcepcionServiciosBiblioteca {
		try {
			return tipoRecursoDAO.consultarTiposRecurso();
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al consultar los tipos de los recursos", e);
		}
	}

}