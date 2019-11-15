/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

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
	private Date fechaInicioReserva;
	private Time horaInicioReserva;
	private Time horaFinReserva;
	private Date fechaFinReserva;
	private Recurso recurso;
	private Usuario usuario;

	public RecursoReservado(int id, Date fechaInicioReserva, Date fechaFinReserva, Time horaInicioReserva, Time horaFinReserva, Recurso recurso,
						    Usuario usuario) {
		this.id = id;
		this.fechaInicioReserva = fechaInicioReserva;
		this.fechaFinReserva = fechaFinReserva;
		this.horaFinReserva = horaFinReserva;
		this.horaInicioReserva = horaInicioReserva;
		this.recurso = recurso;
		this.usuario = usuario;
		
	}

	public RecursoReservado() {

	}

	@Override
	public String toString() {
		return "RecursoRentado{" + "id=" + id + ", recurso=" + recurso + ", fechaInicioReserva=" + fechaInicioReserva
				+ ", fechaFinReserva=" + fechaFinReserva + "horaInicioReserva =" + horaInicioReserva +  "horaFinReserva =" + horaFinReserva  + '}';
	}

}

