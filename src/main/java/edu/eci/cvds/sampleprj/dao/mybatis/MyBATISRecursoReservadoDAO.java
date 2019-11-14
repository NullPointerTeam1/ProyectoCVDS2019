package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.RecursoReservadoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.RecursoReservadoMapper;
import edu.eci.cvds.samples.entities.RecursoReservado;
import edu.eci.cvds.samples.entities.Usuario;


public class MyBATISRecursoReservadoDAO implements RecursoReservadoDAO{
	@Inject
	private RecursoReservadoMapper RecursoReservadoMapper;
	@Override
	public void insertarRecursoReservado(RecursoReservado recurso) throws PersistenceException {
		try {
			RecursoReservadoMapper.insertarReservado(recurso);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al registrar la reserva " + recurso.toString(), e);
		}
	}

	@Override
	public RecursoReservado consultarReservado(long id) throws PersistenceException {
		try {
			return RecursoReservadoMapper.consultarReserva(id);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar la reserva " + id, e);
		}
	}

	@Override
	public List<RecursoReservado> consultarReservas(Usuario usuario) throws PersistenceException {
		try {
			return RecursoReservadoMapper.consultarReservas(usuario);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar las reservas", e);
		}
	}
}
