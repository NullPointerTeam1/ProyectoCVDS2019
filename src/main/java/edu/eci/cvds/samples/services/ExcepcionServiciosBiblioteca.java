package edu.eci.cvds.samples.services;

import org.apache.ibatis.exceptions.PersistenceException;

public class ExcepcionServiciosBiblioteca extends Exception {
	
	public final static String ERROR_INSERTAR = "Error al insertar";
	public final static String ERROR_CONSULTAR = "Error al consultar";	
	public ExcepcionServiciosBiblioteca(String mensaje) {
		super(mensaje);
	}
	public ExcepcionServiciosBiblioteca(String mensaje, PersistenceException ex) {
		super(mensaje);
	}
}
