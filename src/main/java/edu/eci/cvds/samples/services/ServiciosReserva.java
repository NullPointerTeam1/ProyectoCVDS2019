package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.*;

import java.util.List;

public interface ServiciosReserva {
	
	
	// Usuarios
	
	public abstract void registrarUsuario(Usuario u) throws ExcepcionServiciosBiblioteca;

	public abstract Usuario consultarUsuario(long docu) throws ExcepcionServiciosBiblioteca;

	public abstract List<Usuario> consultarUsuarios() throws ExcepcionServiciosBiblioteca;
	
	// Recursos
	
	public abstract void registrarRecurso(Recurso re) throws ExcepcionServiciosBiblioteca;

	public abstract Recurso consultarRecurso(long id) throws ExcepcionServiciosBiblioteca;
	
	public abstract List<Recurso> consultarRecursos() throws ExcepcionServiciosBiblioteca;
	
	public abstract void actualizarEstadoRecurso(long id, String estado) throws ExcepcionServiciosBiblioteca;;
	
	// Tipos Recurso
	public abstract void registrarTipoRecurso(TipoRecurso re) throws ExcepcionServiciosBiblioteca;

	public abstract TipoRecurso consultarTipoRecurso(long id) throws ExcepcionServiciosBiblioteca;

	public abstract List<TipoRecurso> consultarTiposRecurso() throws ExcepcionServiciosBiblioteca;
	
	// Reservas
	
	public void registrarReserva(RecursoReservado recursoReservado) throws ExcepcionServiciosBiblioteca;

	public RecursoReservado consultarReserva(long id) throws ExcepcionServiciosBiblioteca;
	
	public List<RecursoReservado> consultarReservas() throws ExcepcionServiciosBiblioteca;
	
	public List<RecursoReservado> consultarReservasDeUnUsuario(Usuario usuario) throws ExcepcionServiciosBiblioteca;
	

}