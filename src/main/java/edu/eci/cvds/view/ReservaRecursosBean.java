package edu.eci.cvds.view;

import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.*;


import edu.eci.cvds.samples.services.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;

@SuppressWarnings("deprecation")
@ManagedBean(name = "ReservaRecursosBean")
@ApplicationScoped
public class ReservaRecursosBean extends BasePageBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ServiciosReserva serviciosReserva;
	private Usuario selectedUsuario;
	private List<Recurso> recursosDisponibles;
	private Recurso recursoActual;

	public void registrarUsuario(String nombre, long carnet, String carrera, String rol, String correo) {
		try {
			serviciosReserva.registrarUsuario(new Usuario(nombre, carnet, carrera, rol, correo));
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}

	}

	public Recurso getRecursoActual() {
		return recursoActual;
	}

	public void setRecursoActual(Recurso recursoActual) {
		this.recursoActual = recursoActual;
	}

	public List<Recurso> getRecursosDisponibles(){
		return recursosDisponibles;
	}

	public Usuario consultarUsuario(long documento) {
		Usuario usuario = null;
		try {
			usuario = serviciosReserva.consultarUsuario(documento);
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}
		return usuario;
	}

	public List<Usuario> consultarUsuarios() {
		List<Usuario> usuarios = null;
		try {
			usuarios = serviciosReserva.consultarUsuarios();
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}
		return usuarios;
	}

	public void registrarRecurso(String tipo, String nombre, String ubicacion, String capacidad) {
		System.out.println("ENTREWEEEE");
		try {
			TipoRecurso tipoRecurso = null;
			switch(tipo) {
				case "1":{
					tipoRecurso = new TipoRecurso(1,"Equipo de Computo");
					capacidad = "0";
					break;
				} case "2":{
					tipoRecurso = new TipoRecurso(2,"Sala de Estudio");
					
					break;
				} case "3":{
					tipoRecurso = new TipoRecurso(3,"Equipo de Multimedia");
					capacidad = "0";
					break;
				}
			}
			if (tipoRecurso == null){
				
				throw new ExcepcionServiciosBiblioteca(ExcepcionServiciosBiblioteca.TIPO_RECURSONULL);
			}
			serviciosReserva
					.registrarRecurso(new Recurso(tipoRecurso, 1, nombre, ubicacion, Integer.parseInt(capacidad), LocalTime.now(), LocalTime.now(), "Disponible"));
			setErrorMessage("El registro de "+ nombre +" se hizo correctamente");
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		} catch(NumberFormatException e) {
			setErrorMessage(e);
		} catch(Exception e) {
			setErrorMessage(e);
		}

	}

	public Recurso consultarRecurso(String id) {
		Recurso recurso = null;
		try {
			recurso = serviciosReserva.consultarRecurso(Long.parseLong(id));
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}
		return recurso;
	}

	public List<Recurso> consultarRecursos() {
		List<Recurso> recursos = null;
		
		try {
			recursos = serviciosReserva.consultarRecursos();
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}
		return recursos;
	}
	
	public List<Recurso> consultarRecursosDisponibles() {
		List<Recurso> recursos = new ArrayList<Recurso>();
		try {
			recursos = serviciosReserva.consultarRecursos();
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}
		List<Recurso> disponibles = new ArrayList<Recurso>();
		for (Recurso r: recursos) {
			if (r.getDisponibilidad().equals("Disponible")) {
				disponibles.add(r);
			}
		}

		recursosDisponibles = disponibles;
		return disponibles;
	}
	
	public void actualizarEstadoRecurso(String id, String estado) {
		try {
			
			serviciosReserva.actualizarEstadoRecurso(Long.parseLong(id), estado);
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}
	}

	public void registrarTipoRecurso(int id, String descripcion) {
		try {
			serviciosReserva.registrarTipoRecurso(new TipoRecurso(id, descripcion));
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}

	}

	public TipoRecurso consultarTipoRecurso(long id) {
		TipoRecurso tipoRecurso = null;
		try {
			tipoRecurso = serviciosReserva.consultarTipoRecurso(id);
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}
		return tipoRecurso;
	}

	public List<TipoRecurso> consultarTiposRecursos() {
		List<TipoRecurso> tipoRecursos = null;
		try {
			tipoRecursos = serviciosReserva.consultarTiposRecurso();
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}
		return tipoRecursos;
	}
	
	public void registrarRecursoReservado(int id, LocalDate fechaInicioReserva, LocalDate fechaFinReserva, LocalTime  horaInicioReserva, LocalTime  horaFinReserva, Recurso recurso,
		    Usuario usuario) throws PersistenceException {
		RecursoReservado recursoReservado = new RecursoReservado(id, fechaInicioReserva, fechaFinReserva, horaInicioReserva, horaFinReserva, recurso, usuario);
		try {
			serviciosReserva.registrarReserva(recursoReservado);
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}
	}

	public void setSelectedUsuario(Usuario usuario) {
		this.selectedUsuario = usuario;
	}

	public Usuario getSelectedUsuario() {
		return selectedUsuario;
	}

	protected static void setErrorMessage(Exception e) {
		String message = e.getMessage();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
	}
	
	protected static void setErrorMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
	}

}

