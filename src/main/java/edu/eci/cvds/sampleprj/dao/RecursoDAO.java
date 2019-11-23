package edu.eci.cvds.sampleprj.dao;

import java.util.List;
import edu.eci.cvds.samples.entities.Recurso;

public interface RecursoDAO {
	
	/**
	 * Metodo que inserta un recuso 
	 * @param it EL recurso que se desea insertar
	 * @throws PersistenceException
	 */
	public void insertarRecurso(Recurso it) throws PersistenceException;
	/**
	 * Metodo para consultar un recurso
	 * @param id Identificador del recurso a consultar
	 * @return Retorna los datos de del recurso 
	 * @throws PersistenceException
	 */

	public Recurso consultarRecurso(long id) throws PersistenceException;
	
	/**
	 * Consulta todos los elemetos de la tabla recursos
	 * @return la tabla recursos 
	 * @throws PersistenceException
	 */

	public List<Recurso> consultarRecursos() throws PersistenceException;
	
	/**
	 * Acturliza la infomacion de un recurso
	 * @param id identificador del estado que desea actualizar
	 * @param estado El nuevo estado del recurso
	 * @throws PersistenceException
	 */
	public void actualizarEstadoRecurso(long id, String estado) throws PersistenceException;

}