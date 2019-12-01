/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.time.LocalTime;


/**
 *
 * @author NullpointerTeam
 */
public class Recurso implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private TipoRecurso tipo;
	private int id;
	private String nombre;
	private String ubicacion;
	private int capacidad;
	private LocalTime  horarioI;
	private LocalTime  horarioF;
	private String disponibilidad, descripcion;
	
/**
 * Metodo encargado de crear un recurso
 * @param tipo Indica el tipo de un recurso
 * @param id idica el identifacador de un recuso
 * @param nombre El nombre del recurso
 * @param ubicacion lugar en el cual esta el recurso
 * @param capacidad la capacidad de uso que tiene el recurso
 * @param horarioI Hora de inicio en la cual  el recurso estara disponible
 * @param horarioF Hora de fin en la cual  el recurso estara disponible
 * @param disponibilidad El estado del recuso, pude ser Disponible, Ocupado, No disponible
 */
	public Recurso(TipoRecurso tipo, int id, String nombre, String ubicacion, int capacidad, LocalTime  horarioI, LocalTime  horarioF, String disponibilidad,
			String descripcion) {
		this.tipo = tipo;
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.capacidad = capacidad;
		this.horarioI = horarioI;
		this.horarioF = horarioF;
		this.disponibilidad = disponibilidad;
		this.descripcion = descripcion;
	}
	
	public Recurso() {
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

	public LocalTime  getHorarioI() {
		return horarioI;
	}

	public void setHorarioI(LocalTime  horarioI) {
		this.horarioI = horarioI;
	}
	
	public LocalTime  getHorarioF() {
		return horarioF;
	}

	public void setHorarioF(LocalTime  horarioF) {
		this.horarioF = horarioF;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	@Override
	public String toString() {
		return "Recurso{" + "tipo=" + tipo + ", id=" + id + ", nombre=" + nombre + ", HorarioI " + horarioI + ", HorarioF " + horarioF + ", Disponibilidad " + disponibilidad + '}';
	}
}
