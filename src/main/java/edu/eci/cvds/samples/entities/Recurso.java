/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;


/**
 *
 * @author NullpointerTeam
 */
public class Recurso implements Serializable {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private TipoRecurso tipo;
	private int id;
	private String nombre;
	private String ubicacion;
	private int capacidad;
	private Time horarioI;
	private Time horarioF;
	private String disponibilidad;
	
	public Recurso() {
	}

	public Recurso(TipoRecurso tipo, int id, String nombre, String ubicacion, int capacidad, Time horarioI, Time horarioF, String disponibilidad) {
		this.tipo = tipo;
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.capacidad = capacidad;
		this.horarioI = horarioI;
		this.horarioF = horarioF;
		this.disponibilidad = disponibilidad;
	}

	public TipoRecurso getTipo() {
		return tipo;
	}

	public void setTipo(TipoRecurso tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public Date getHorarioI() {
		return horarioI;
	}

	public void setHorarioI(Time horarioI) {
		this.horarioI = horarioI;
	}
	
	public Date getHorarioF() {
		return horarioF;
	}

	public void setHorarioF(Time horarioF) {
		this.horarioF = horarioF;
	}
	
	@Override
	public String toString() {
		return "Recurso{" + "tipo=" + tipo.toString() + ", id=" + id + ", nombre=" + nombre + '}';
	}
}
