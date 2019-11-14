package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.RecursoReservado;
import edu.eci.cvds.samples.entities.Usuario;

public interface RecursoReservadoDAO {

	void insertarRecursoReservado(RecursoReservado recurso) throws PersistenceException;

	RecursoReservado consultarReservado(long id) throws PersistenceException;

	List<RecursoReservado> consultarReservas(Usuario usuario) throws PersistenceException;

}
