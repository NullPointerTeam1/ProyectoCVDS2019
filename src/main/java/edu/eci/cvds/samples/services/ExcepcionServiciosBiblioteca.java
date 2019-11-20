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
	public final static String TIPO_RECURSONULL = "Debe marcar el tipo del recurso";
	public static final String RESERVA_NULA = "La reserva no puede ser nula";
	public static final String RECURSO_NO_DISPONIBLE = "El recurso que desea reservar no esta disponible";
	public static final String RECURSO_YA_RESERVADO = "El recurso que desea reservar ya esta reservado";
	
	public ExcepcionServiciosBiblioteca(String mensaje) {
		super(mensaje);
	}
	public ExcepcionServiciosBiblioteca(String mensaje, Throwable cause) {
		super(mensaje);
	}
	
	public ExcepcionServiciosBiblioteca(String message, Exception e) {
		super(message,e);
	}
}

