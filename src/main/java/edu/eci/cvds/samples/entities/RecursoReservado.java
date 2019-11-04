/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author NullPointerTeam
 */
public class RecursoReservado implements Serializable {

	private int id;

	private Recurso recurso;
	private Date fechainiciorenta;
	private Date fechafinrenta;

	public RecursoReservado(int id, Recurso recurso, Date fechainiciorenta, Date fechafinrenta) {
		this.id = id;
		this.recurso = recurso;
		this.fechainiciorenta = fechainiciorenta;
		this.fechafinrenta = fechafinrenta;
	}

	public RecursoReservado() {

	}

	@Override
	public String toString() {
		return "RecursoRentado{" + "id=" + id + ", recurso=" + recurso + ", fechainiciorenta=" + fechainiciorenta
				+ ", fechafinrenta=" + fechafinrenta + '}';
	}

}
