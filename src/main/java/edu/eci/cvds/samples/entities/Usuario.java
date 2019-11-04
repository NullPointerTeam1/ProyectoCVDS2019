/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class Usuario implements Serializable {

	private String nombre;
	private String apellido;
	private long carnet;
	private String carrera;
	private String correo;
	private String rol;
	private ArrayList<RecursoReservado> reservados;

	public Usuario() {
	}

	public Usuario(String nombre, String apellido, long carnet, String carrera, String correo, String rol,
			ArrayList<RecursoReservado> reservados) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.carnet = carnet;
		this.carrera = carrera;
		this.correo = correo;
		this.rol = rol;
		this.reservados = reservados;
	}

	public Usuario(String nombre, long carnet, String carrera, String rol, String correo) {
		this.nombre = nombre;
		this.carnet = carnet;
		this.carrera = carrera;
		this.rol = rol;
		this.correo = correo;
		this.reservados = new ArrayList<>();
	}

	public String getRol() {
		return rol;
	}

	public ArrayList<RecursoReservado> getReservados() {
		return reservados;
	}

	public void setReservados(ArrayList<RecursoReservado> reservados) {
		this.reservados = reservados;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getCarnet() {
		return carnet;
	}

	public void setCarnet(long carnet) {
		this.carnet = carnet;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Usuario{" + "nombre=" + nombre + ", carnet=" + carnet + ", rentados = \n\t" + reservados + '}';
	}

}
