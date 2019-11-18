package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.RecursoReservado;
import edu.eci.cvds.samples.entities.Usuario;

public interface RecursoReservadoDAO {

	public void insertarRecursoReservado(RecursoReservado recurso) throws PersistenceException;

	public RecursoReservado consultarReservado(long id) throws PersistenceException;

	public List<RecursoReservado> consultarReservasDeUnUsuario(Usuario usuario) throws PersistenceException;
	
	public List<RecursoReservado> consultarReservas() throws PersistenceException;

}
