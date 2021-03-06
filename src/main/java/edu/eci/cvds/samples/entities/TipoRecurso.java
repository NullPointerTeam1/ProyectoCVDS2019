/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

import java.io.Serializable;

/**
 * @author NullPointerTeam
 */
public class TipoRecurso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String descripcion;
	/**
	 *  Metodo encargado de crear un recurso
	 * @param id Identificaro del tipo del recurso
	 * @param descripcion De que se trata este recurso
	 */
	public TipoRecurso(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public TipoRecurso() {
	}

	public int getId() {
		return id;
	}

	public void setId(int ID) {
		this.id = ID;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String Descripcion) {
		this.descripcion = Descripcion;
	}

	@Override
	public String toString() {
		return "TipoRecurso{" + "id=" + id + ", descripcion=" + descripcion + '}';
	}

}
