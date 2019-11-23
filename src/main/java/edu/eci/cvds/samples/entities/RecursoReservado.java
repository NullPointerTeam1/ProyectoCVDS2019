/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author NullPointerTeam
 */
public class RecursoReservado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private LocalDate fechaInicioReserva;
	private LocalTime horaInicioReserva;
	private LocalTime horaFinReserva;
	private LocalDate fechaFinReserva;
	private Recurso recurso;
	private Usuario usuario;
	
	/**
	 *  Metodo encargado de crear una reserva 
	 * @param id Identificador de un recurso
	 * @param fechaInicioReserva Fecha de inicio de la reserva
	 * @param fechaFinReserva Fecha fin de la reserva
	 * @param horaInicioReserva Hora inicio de la reserva
	 * @param horaFinReserva Hora fin de la reserva
	 * @param recurso El recurso que quieren reservar
	 * @param usuario El usuario que hace la reserva
	 */

	public RecursoReservado(int id, LocalDate  fechaInicioReserva, LocalDate fechaFinReserva, LocalTime  horaInicioReserva, LocalTime  horaFinReserva, Recurso recurso,
						    Usuario usuario) {
		this.id = id;
		this.fechaInicioReserva = fechaInicioReserva;
		this.fechaFinReserva = fechaFinReserva;
		this.horaFinReserva = horaFinReserva;
		this.horaInicioReserva = horaInicioReserva;
		this.recurso = recurso;
		this.usuario = usuario;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFechaInicioReserva() {
		return fechaInicioReserva;
	}

	public void setFechaInicioReserva(LocalDate fechaInicioReserva) {
		this.fechaInicioReserva = fechaInicioReserva;
	}

	public LocalTime getHoraInicioReserva() {
		return horaInicioReserva;
	}

	public void setHoraInicioReserva(LocalTime horaInicioReserva) {
		this.horaInicioReserva = horaInicioReserva;
	}

	public LocalTime getHoraFinReserva() {
		return horaFinReserva;
	}

	public void setHoraFinReserva(LocalTime horaFinReserva) {
		this.horaFinReserva = horaFinReserva;
	}

	public LocalDate getFechaFinReserva() {
		return fechaFinReserva;
	}

	public void setFechaFinReserva(LocalDate fechaFinReserva) {
		this.fechaFinReserva = fechaFinReserva;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public RecursoReservado() {

	}

	@Override
	public String toString() {
		return "RecursoReservado{" + "id=" + id + ", recurso=" + recurso + ", fechaInicioReserva=" + fechaInicioReserva
				+ ", fechaFinReserva=" + fechaFinReserva + " horaInicioReserva =" + horaInicioReserva +  
				" horaFinReserva =" + horaFinReserva +'}';
	}

}

