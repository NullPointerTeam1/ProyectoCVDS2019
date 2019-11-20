package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.*;
import edu.eci.cvds.sampleprj.dao.*;
import org.mybatis.guice.transactional.Transactional;

import java.time.LocalTime;
import java.util.List;


public class ServiciosReservaImpl implements ServiciosReserva {

	@Inject
	private RecursoDAO recursoDAO;
	@Inject
	private UsuarioDAO usuarioDAO;
	@Inject
	private TipoRecursoDAO tipoRecursoDAO;
	@Inject
	private RecursoReservadoDAO recursoReservadoDAO;
	
	// Usuarios

	@Override
	@Transactional
	public void registrarUsuario(Usuario usuario) throws ExcepcionServiciosBiblioteca {
		if (usuario == null) throw new ExcepcionServiciosBiblioteca("El usuario no puede ser nulo");
		
		try { 
			usuarioDAO.insertarUsuario(usuario);
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al registrar al usuario " + usuario.getCarnet(), e);
		}
	}

	@Override
	public Usuario consultarUsuario(long docu) throws ExcepcionServiciosBiblioteca {
		if (docu <= 0 || docu > 100000000) throw new ExcepcionServiciosBiblioteca("El numero de documento es inválido"); 
		try {
			return usuarioDAO.consultarUsuario(docu);
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
	
	// Recursos
	
	@Override
	@Transactional
	public void registrarRecurso(Recurso recurso) throws ExcepcionServiciosBiblioteca {
		if (recurso.getNombre() == null || recurso.getNombre().equals("")) 
			throw new ExcepcionServiciosBiblioteca("Debe escribir el nombre del recurso.");
		else if (recurso.getUbicacion() == null || recurso.getUbicacion().equals("")) 
			throw new ExcepcionServiciosBiblioteca("La ubicación del recurso no puede ser nula");
		else if  (recurso.getCapacidad() < 0) throw new ExcepcionServiciosBiblioteca("La capacidad del recurso no puede ser negativa.");
		else if (recurso.getTipo() == null) throw new ExcepcionServiciosBiblioteca(ExcepcionServiciosBiblioteca.TIPO_RECURSONULL);
		
		try {
			recursoDAO.insertarRecurso(recurso);
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al registrar el recurso " + recurso.getId(), e);
		}
	}
	
	@Override
	public Recurso consultarRecurso(long id) throws ExcepcionServiciosBiblioteca {
		if (id <= 0 || id > 100000000) throw new ExcepcionServiciosBiblioteca("El numero del recurso es inválido");		
		try {
			return recursoDAO.consultarRecurso(id);
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
	public void actualizarEstadoRecurso(long id, String estado) throws ExcepcionServiciosBiblioteca {
		if (!(estado.equals("Disponible") || estado.equals("Ocupado") || estado.equals("No Disponible"))) 
				throw new ExcepcionServiciosBiblioteca("El nuevo estado es inválido");
		else if (id <= 0 || id > 100000000) throw new ExcepcionServiciosBiblioteca("El numero del recurso es inválido");	
				
		try {
			recursoDAO.actualizarEstadoRecurso(id, estado);
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al cambiar el estado del recurso", e);
		}
	}
	
	// Tipos Recurso
	
	@Override
	@Transactional
	public void registrarTipoRecurso(TipoRecurso tipoRecurso) throws ExcepcionServiciosBiblioteca {
		if (tipoRecurso == null) throw new ExcepcionServiciosBiblioteca("El tipo recurso no puede ser nulo");
		try {
			tipoRecursoDAO.insertarTipoRecurso(tipoRecurso);
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al insertar el tipo de recurso " + tipoRecurso.getId(), e);
		}
	}
	
	@Override
	public TipoRecurso consultarTipoRecurso(long id) throws ExcepcionServiciosBiblioteca {
		if (id <= 0 || id > 100000000) throw new ExcepcionServiciosBiblioteca("El numero del tipo recurso es inválido");	
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
	
	// Reservas
	
	@Override
	@Transactional
	public void registrarReserva(RecursoReservado recursoReservado) throws ExcepcionServiciosBiblioteca, PersistenceException {
		
		if (recursoReservado == null) {
			throw new ExcepcionServiciosBiblioteca(ExcepcionServiciosBiblioteca.RESERVA_NULA);
		}else if (!recursoReservado.getRecurso().getDisponibilidad().equals("Disponible")) {
			throw new ExcepcionServiciosBiblioteca(ExcepcionServiciosBiblioteca.RECURSO_NO_DISPONIBLE);
		}else if (recursoReservado.getHoraInicioReserva().isBefore(recursoReservado.getRecurso().getHorarioI()) || recursoReservado.getHoraInicioReserva().isAfter(recursoReservado.getRecurso().getHorarioF())){
			throw new ExcepcionServiciosBiblioteca(ExcepcionServiciosBiblioteca.RECURSO_NO_DISPONIBLE);
		}else if (isReservable(recursoReservado)) {
			
		}else {
			if (!recursoReservado.getRecurso().getTipo().getDescripcion().equals("Equipo Multimedia")) {
				recursoReservado.setHoraFinReserva(recursoReservado.getHoraInicioReserva().plusHours(2));
			}		
			recursoReservadoDAO.insertarReserva(recursoReservado);
		
		}
	}
	
	private boolean isReservable(RecursoReservado recursoReservado) {
		List<RecursoReservado> reservas = recursoReservadoDAO.consultarReservado(recursoReservado.getRecurso().getId());
		LocalTime horaInicioR = recursoReservado.getHoraInicioReserva();
		LocalTime horaFinR = recursoReservado.getHoraFinReserva();
		boolean res = true;
		for (RecursoReservado r : reservas) {
			if (recursoReservado.getFechaInicioReserva().equals(r.getFechaInicioReserva())) {				
				if (horaInicioR.isAfter(r.getHoraInicioReserva()) && horaInicioR.isBefore(r.getHoraFinReserva())) {
					res = false;
					break;
				} else if (horaFinR.isAfter(r.getHoraInicioReserva()) && horaFinR.isBefore(r.getHoraFinReserva())) {
					res = false;
					break;
				} else if ((horaInicioR.equals(r.getHoraInicioReserva()) || horaInicioR.equals(r.getHoraFinReserva())) || 
						   (horaFinR.equals(r.getHoraInicioReserva()) || horaFinR.equals(r.getHoraFinReserva()))) {
					res = false;
					break;
				}
			}
		}
		return res;
	}

	@Override
	public List<RecursoReservado> consultarReserva(long id) throws ExcepcionServiciosBiblioteca {
		try { 
			return recursoReservadoDAO.consultarReservado(id);
		} catch (Exception e) {
			throw new ExcepcionServiciosBiblioteca("Error al consultar la reserva" + id);
		}
	}

	@Override
	public List<RecursoReservado> consultarReservas() throws ExcepcionServiciosBiblioteca {
		try { 
			return recursoReservadoDAO.consultarReservas();
		} catch (Exception e) {
			throw new ExcepcionServiciosBiblioteca("Error al consultar las reservas");
		}
	}

	@Override
	public List<RecursoReservado> consultarReservasDeUnUsuario(Usuario usuario) throws ExcepcionServiciosBiblioteca {
		if (usuario == null) throw new ExcepcionServiciosBiblioteca("El usuario deseado no existe");
		return recursoReservadoDAO.consultarReservasDeUnUsuario(usuario);
	}


}
