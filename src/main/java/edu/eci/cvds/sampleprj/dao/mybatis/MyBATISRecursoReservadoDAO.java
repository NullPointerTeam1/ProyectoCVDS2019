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
			throw new PersistenceException("Error (P) al registrar la reserva del recurso" + recurso.toString(), e);
		}
	}

	@Override
	public RecursoReservado consultarReservado(long id) throws PersistenceException {
		try {
			return RecursoReservadoMapper.consultarReserva(id);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al consultar la reserva " + id, e);
		}
	}

	@Override
	public List<RecursoReservado> consultarReservas() throws PersistenceException {
		try {
			return RecursoReservadoMapper.consultarReservas();
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al consultar las reservas", e);
		}
	}

	@Override
	public List<RecursoReservado> consultarReservasDeUnUsuario(Usuario usuario) throws PersistenceException {
		try {
			return RecursoReservadoMapper.consultarReservasDeUnUsuario(usuario);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al consultar las reservas del usuario " + usuario.getNombre(), e);
		}
	}
}
