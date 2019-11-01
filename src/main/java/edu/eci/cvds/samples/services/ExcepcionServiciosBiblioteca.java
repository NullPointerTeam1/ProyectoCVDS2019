package edu.eci.cvds.samples.services;

import org.apache.ibatis.exceptions.PersistenceException;

public class ExcepcionServiciosBiblioteca extends Exception {
	public final static String NO_DISPONIBLE = "Este recurso no esta disponible"; 
	
	public ExcepcionServiciosBiblioteca(String mensaje) {
		super(mensaje);
	}
	public ExcepcionServiciosBiblioteca(String mensaje,PersistenceException ex) {
		super(mensaje);
	}
}
