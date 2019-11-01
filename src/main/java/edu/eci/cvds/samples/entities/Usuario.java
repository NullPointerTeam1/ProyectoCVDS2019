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

public class Usuario implements Serializable{
    
    private String nombre;
    private String apellido;
    private long carnet;
    private String carrera;
    private String correo;
    private String rol;
    private ArrayList<RecursoRentado> reservados;

  
	public Usuario() {
    }

    public Usuario(String nombre, String apellido,long carnet, String carrera, String correo,String rol, ArrayList<RecursoRentado> reservados) {   
        this.nombre = nombre;
        this.apellido = apellido;
        this.carnet = carnet;
        this.carrera = carrera;
        this.correo = correo;
        this.rol = rol;
        this.reservados = reservados;
    }
   
    public String getRol() {
		return rol;
	}
    
    public ArrayList<RecursoRentado> getReservados() {
		return reservados;
	}

	public void setReservados(ArrayList<RecursoRentado> reservados) {
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
