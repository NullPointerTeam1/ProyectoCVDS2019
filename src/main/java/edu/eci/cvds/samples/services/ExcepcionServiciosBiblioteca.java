package edu.eci.cvds.samples.services;



public class ExcepcionServiciosBiblioteca extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public final static String NO_DISPONIBLE = "Este recurso no esta disponible";
	public final static String ERROR_INSERTAR = "Error al insertar";
	public final static String ERROR_CONSULTAR = "Error al consultar";
	public final static String USUARIO_YA_IDENTIFICADO = "Ya hay un usuario conectado";
	
	public ExcepcionServiciosBiblioteca(String mensaje) {
		super(mensaje);
	}
	public ExcepcionServiciosBiblioteca(String mensaje, Throwable cause) {
		super(mensaje);
	}
}
