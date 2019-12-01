package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.RecursoReservado;
import edu.eci.cvds.samples.entities.Usuario;

public interface RecursoReservadoDAO {
	
	/**
	 * Inserta una reserva en la base de datos 
	 * @param recurso LA reserva  que se desea insertar
	 * @throws PersistenceException
	 */
	public void insertarReserva(RecursoReservado recurso) throws PersistenceException;
	
	/**
	 * Consulta si las reservas de un recurso
	 * @param id identificador de una reserva
	 * @return la informacion de la reserva
	 * @throws PersistenceException
	 */
	public List<RecursoReservado> consultarReservado(long id) throws PersistenceException;
	
	/**
	 * Consulta si un usuario tiene una reserva 
	 * @param usuario identificador del usuario 
	 * @return Las reservas de un usuario
	 * @throws PersistenceException
	 */
	
	public List<RecursoReservado> consultarReservasDeUnUsuario(Usuario usuario) throws PersistenceException;
	/**
	 * Consulta toda la tabla reserva
	 * @return Todos los datos de la tabla
	 * @throws PersistenceException
	 */
	
	public List<RecursoReservado> consultarReservas() throws PersistenceException;
	
	public RecursoReservado consultarReserva(long id) throws PersistenceException;
	
	/**
	 * Actuaiza la infomacion de una reserva
	 * @param id identificador del estado que desea actualizar
	 * @param estado El nuevo estado de la reserva
	 * @throws PersistenceException
	 */
	public void actualizarEstadoReserva(long id, String estado) throws PersistenceException;

}
