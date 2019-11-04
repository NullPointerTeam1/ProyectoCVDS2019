package edu.eci.cvds.view;

import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;

import java.sql.Date;

@ManagedBean(name = "ReservaRecursosBean")
@ApplicationScoped
public class ReservaRecursosBean extends BasePageBean {

	@Inject
	private ServiciosReserva serviciosReserva;
	private Usuario selectedUsuario;

	public void registrarUsuario(String nombre, long carnet, String carrera, String rol, String correo) {
		try {
			serviciosReserva.registrarUsuario(new Usuario(nombre, carnet, carrera, rol, correo));
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}

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

	public void registrarRecurso(TipoRecurso tipo, int id, String nombre, String ubicacion, int capacidad, Date horario,
			String disponibilidad) {
		try {
			serviciosReserva
					.registrarRecurso(new Recurso(tipo, id, nombre, ubicacion, capacidad, horario, disponibilidad));
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}

	}

	public Recurso consultarRecurso(long id) {
		Recurso recurso = null;
		try {
			recurso = serviciosReserva.consultarRecurso(id);
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

	public void setSelectedUsuario(Usuario usuario) {
		this.selectedUsuario = usuario;
	}

	public Usuario getSelectedUsuario() {
		return selectedUsuario;
	}

	private void setErrorMessage(Exception e) {
		String message = e.getMessage();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
	}

}
