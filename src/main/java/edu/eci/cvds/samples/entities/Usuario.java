/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;


import java.io.Serializable;
import java.util.ArrayList;


public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String apellido;
	private long carnet;
	private String carrera;
	private String correo;
	private String contrasena;
	private String rol;
	private ArrayList<RecursoReservado> reservados;

	public Usuario() {
	}

	/**
	 * Metodo encargado de crear un usuario
	 *
	 * @param nombre Nombre del usuario 
	 * @param apellido Apellido del usuraio 
	 * @param carnet Numero de identificacion de la universidad 
	 * @param carrera Programa al que esta vinculado 
	 * @param correo Correo institucional
	 * @param contrasena Contraseña del ususario el cual esta incriptada 
	 * @param rol Rol que representa en la aplicacion Administrador= A Usuario = U 
	 * @param reservados Articulos que tiene reservado el usuario
	 */
	public Usuario(String nombre, String apellido, long carnet, String carrera, String correo, String contrasena, String rol,
			ArrayList<RecursoReservado> reservados) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.carnet = carnet;
		this.carrera = carrera;
		this.correo = correo;
		this.contrasena = contrasena;
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

	public String getcontrasena() {
		return contrasena;
	}

	public void setcontrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	@Override
	public String toString() {
		return "Usuario{" + "nombre=" + nombre + ", carnet=" + carnet + ", reservados = \n\t" + reservados + '}';
	}

}
