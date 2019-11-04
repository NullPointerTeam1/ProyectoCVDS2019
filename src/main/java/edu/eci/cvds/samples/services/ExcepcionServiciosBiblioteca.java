package edu.eci.cvds.samples.services;

import org.apache.ibatis.exceptions.PersistenceException;

public class ExcepcionServiciosBiblioteca extends Exception {
	public final static String NO_DISPONIBLE = "Este recurso no esta disponible";
	public final static String ERROR_INSERTAR = "Error al insertar";
	public final static String ERROR_CONSULTAR = "Error al consultar";	
	
	public ExcepcionServiciosBiblioteca(String mensaje) {
		super(mensaje);
	}
	public ExcepcionServiciosBiblioteca(String mensaje, Throwable cause) {
		super(mensaje);
	}
}
