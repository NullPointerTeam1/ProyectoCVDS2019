package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.*;
import edu.eci.cvds.sampleprj.dao.*;
import org.mybatis.guice.transactional.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
		if (usuario == null)
			throw new ExcepcionServiciosBiblioteca("El usuario no puede ser nulo");

		try {
			usuarioDAO.insertarUsuario(usuario);
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al registrar al usuario " + usuario.getCarnet(), e);
		}
	}

	@Override
	public Usuario consultarUsuario(long docu) throws ExcepcionServiciosBiblioteca {
		if (docu <= 0 || docu > 100000000)
			throw new ExcepcionServiciosBiblioteca("El numero de documento es inválido");
		try {
			return usuarioDAO.consultarUsuario(docu);
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al consultar el usuario" + docu, e);
		}
	}
	
	@Override
	public Usuario consultarUsuarioPorCorreo(String correo) throws ExcepcionServiciosBiblioteca {
		try {
			return usuarioDAO.consultarUsuarioPorCorreo(correo);
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al consultar el usuario" + correo, e);
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
		else if (recurso.getCapacidad() < 0)
			throw new ExcepcionServiciosBiblioteca("La capacidad del recurso no puede ser negativa.");
		else if (recurso.getTipo() == null)
			throw new ExcepcionServiciosBiblioteca(ExcepcionServiciosBiblioteca.TIPO_RECURSONULL);

		try {
			recursoDAO.insertarRecurso(recurso);
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al registrar el recurso " + recurso.getId(), e);
		}
	}

	@Override
	public Recurso consultarRecurso(long id) throws ExcepcionServiciosBiblioteca {
		if (id <= 0 || id > 100000000)
			throw new ExcepcionServiciosBiblioteca("Recurso no encontrado");
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
		else if (id <= 0 || id > 100000000)
			throw new ExcepcionServiciosBiblioteca("Recurso no encontrado");

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
		if (tipoRecurso == null)
			throw new ExcepcionServiciosBiblioteca("El tipo recurso no puede ser nulo");
		try {
			tipoRecursoDAO.insertarTipoRecurso(tipoRecurso);
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al insertar el tipo de recurso " + tipoRecurso.getId(), e);
		}
	}

	@Override
	public TipoRecurso consultarTipoRecurso(long id) throws ExcepcionServiciosBiblioteca {
		if (id <= 0 || id > 100000000)
			throw new ExcepcionServiciosBiblioteca("El numero del tipo recurso es inválido");
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
	public void registrarReserva(RecursoReservado recursoReservado, String recurrencia) throws ExcepcionServiciosBiblioteca {
		if (recurrencia.equals("No")) registrarReserva(recursoReservado);
		else {
			LocalDate ini = recursoReservado.getFechaInicioReserva();
			LocalDate fin = recursoReservado.getFechaFinReserva();
			while (ini.compareTo(fin) < 0 || ini.compareTo(fin) == 0) {
				if (ini.getDayOfWeek() != DayOfWeek.SATURDAY || ini.getDayOfWeek() != DayOfWeek.SUNDAY) {
					int id = recursoReservado.getId();
					LocalDate fechaInicio = ini;
					LocalDate fechaFin = ini;
					LocalTime horaInicio = recursoReservado.getHoraInicioReserva();
					LocalTime horaFin = recursoReservado.getHoraFinReserva();
					Recurso recurso = recursoReservado.getRecurso();
					Usuario usuario = recursoReservado.getUsuario();
					String estado = recursoReservado.getEstado();
					String recurrente = recursoReservado.getRecurrente();
					RecursoReservado nuevo = new RecursoReservado(id, fechaInicio, fechaFin, horaInicio, horaFin, recurso, usuario,estado,recurrente);
					if (recurrencia.equals("Diario")) ini = ini.plusDays(1);
					else if (recurrencia.equals("Semanal")) ini = ini.plusWeeks(1);
					else if (recurrencia.equals("Mensual")) ini = ini.plusMonths(1);
					try {
						registrarReserva(nuevo);
					} catch (ExcepcionServiciosBiblioteca e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	private void registrarReserva(RecursoReservado recursoReservado) throws ExcepcionServiciosBiblioteca {
		if (recursoReservado == null) {
			throw new ExcepcionServiciosBiblioteca(ExcepcionServiciosBiblioteca.RESERVA_NULA);
		} 
		LocalTime horaInicioR = recursoReservado.getHoraInicioReserva();
		LocalTime horaFinR = recursoReservado.getHoraFinReserva();
		LocalTime recursoHoraI = recursoReservado.getRecurso().getHorarioI();
		LocalTime recursoHoraF = recursoReservado.getRecurso().getHorarioF();
		LocalTime resta = horaFinR.minusHours(2);
		if (horaFinR.compareTo(horaInicioR) < 0) {
			throw new ExcepcionServiciosBiblioteca("La hora final debe ser después de la hora inicial.");
		} else if (horaInicioR.compareTo(resta) < 0 ) {
			throw new ExcepcionServiciosBiblioteca("No puede reservar un recurso por más de dos horas");
		} else if (!(recursoReservado.getRecurso().getDisponibilidad().equals("Disponible"))) {
			throw new ExcepcionServiciosBiblioteca(ExcepcionServiciosBiblioteca.RECURSO_NO_DISPONIBLE);
		} else if (horaInicioR.isBefore(recursoHoraI) || horaInicioR.isAfter(recursoHoraF) ||
				   horaFinR.isBefore(recursoHoraI) || horaFinR.isAfter(recursoHoraF)) {
			throw new ExcepcionServiciosBiblioteca("El recurso sólo está disponible en este horario: " + recursoHoraI + " - " + recursoHoraF);
		} else if (isReserved(recursoReservado, horaInicioR, horaFinR)) {
			throw new ExcepcionServiciosBiblioteca(recursoReservado);
		} 
		try {
			recursoReservadoDAO.insertarReserva(recursoReservado);
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al registrar una reserva");
		}
	}

	private boolean isReserved(RecursoReservado recursoReservado, LocalTime horaInicioR, LocalTime horaFinR) throws ExcepcionServiciosBiblioteca {
		List<RecursoReservado> reservas;
		try {
			reservas = recursoReservadoDAO.consultarReservado(recursoReservado.getRecurso().getId());
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al registrar una reserva");
		}
		boolean res = false;
		for (RecursoReservado r : reservas) {
			if (recursoReservado.getFechaInicioReserva().equals(r.getFechaInicioReserva())) {
				if (horaInicioR.isAfter(r.getHoraInicioReserva()) && horaInicioR.isBefore(r.getHoraFinReserva())) {
					res = true;
					break;
				} else if (horaFinR.isAfter(r.getHoraInicioReserva()) && horaFinR.isBefore(r.getHoraFinReserva())) {
					res = true;
					break;
				} else if ((horaInicioR.equals(r.getHoraInicioReserva()) || horaInicioR.equals(r.getHoraFinReserva()))
						|| (horaFinR.equals(r.getHoraInicioReserva()) || horaFinR.equals(r.getHoraFinReserva()))) {
					res = true;
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
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al consultar la reserva" + id);
		}
	}

	@Override
	public List<RecursoReservado> consultarReservas() throws ExcepcionServiciosBiblioteca {
		try {
			return recursoReservadoDAO.consultarReservas();
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al consultar las reservas");
		}
	}

	@Override
	public List<RecursoReservado> consultarReservasDeUnUsuario(Usuario usuario) throws ExcepcionServiciosBiblioteca {
		if (usuario == null)
			throw new ExcepcionServiciosBiblioteca("El usuario deseado no existe");
		try {
			return recursoReservadoDAO.consultarReservasDeUnUsuario(usuario);
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosBiblioteca("Error al consultar las reservas de un usuario");
		}
	}

}
