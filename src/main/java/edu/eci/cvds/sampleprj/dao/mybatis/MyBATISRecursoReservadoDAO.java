package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.RecursoReservadoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.RecursoReservadoMapper;
import edu.eci.cvds.samples.entities.RecursoReservado;
import edu.eci.cvds.samples.entities.Usuario;

public class MyBATISRecursoReservadoDAO implements RecursoReservadoDAO {

	@Inject
	private RecursoReservadoMapper recursoReservadoMapper;

	@Override
	public void insertarReserva(RecursoReservado recurso) throws PersistenceException {
		try {
			recursoReservadoMapper.registrarReserva(recurso);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al registrar la reserva del recurso" + recurso.toString(), e);
		}
	}

	@Override
	public List<RecursoReservado> consultarReservado(long id) throws PersistenceException {
		try {
			return recursoReservadoMapper.consultarReservaRecurso(id);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al consultar la reserva " + id, e);
		}
	}

	@Override
	public List<RecursoReservado> consultarReservas() throws PersistenceException {
		try {
			return recursoReservadoMapper.consultarReservas();
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al consultar las reservas", e);
		}
	}

	@Override
	public List<RecursoReservado> consultarReservasDeUnUsuario(Usuario usuario) throws PersistenceException {
		try {
			return recursoReservadoMapper.consultarReservasDeUnUsuario(usuario);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al consultar las reservas del usuario " + usuario.getNombre(), e);
		}
	}

	@Override
	public RecursoReservado consultarReserva(long id) throws PersistenceException {
		try {
			return recursoReservadoMapper.consultarReserva(id);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al consultar la reserva " + id, e);
		}
	}

	@Override
	public void actualizarEstadoReserva(long id, String estado) throws PersistenceException {
		try {
			recursoReservadoMapper.actualizarEstadoReserva(id, estado);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al actualizar el estado de la reserva" + id, e);
		}
	}

	
	// CONSULTAS HISOTRIA 9
	@Override
	public List<RecursoReservado> consultarRecursosMasUsados() {
		try {
			return recursoReservadoMapper.consultarRecursosMasUsados();
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al consultar Recursos Mas Usados", e);
		}
	}

	@Override
	public List<RecursoReservado> consultarRecursosMenosUsados() {
		try {
			return recursoReservadoMapper.consultarRecursosMenosUsados();
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al consultar Recursos Menos Usados", e);
		}
	}

	@Override
	public List<RecursoReservado> consultarHorariosDeMayorOcupacion() {
		try {
			return recursoReservadoMapper.consultarHorariosDeMayorOcupacion();
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) consultar Horarios De Mayor Ocupacion", e);
		}
	}

	@Override
	public List<RecursoReservado> consultarHorariosDeMenorOcupacion() {
		try {
			return recursoReservadoMapper.consultarHorariosDeMenorOcupacion();
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) consultar Horarios De Menor Ocupacion", e);
		}
	}

	@Override
	public List<RecursoReservado> consultarReservasRecurrentes() {
		try {
			return recursoReservadoMapper.consultarReservasRecurrentes();
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) consultar Reservas Recurrentes", e);
		}
	}

	@Override
	public List<RecursoReservado> consultarReservasCanceladas() {
		try {
			return recursoReservadoMapper.consultarReservasCanceladas();
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) consultar Reservas Canceladas", e);
		}
	}

}
