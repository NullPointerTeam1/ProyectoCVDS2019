package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.RecursoReservado;
import edu.eci.cvds.samples.entities.Usuario;

/**
 * @author NullPointerTeam
*/

public interface RecursoReservadoMapper {
	
	public void registrarReserva(@Param("reservado") RecursoReservado reservado);

	public List<RecursoReservado> consultarReservaRecurso(@Param("id") long id);
	
	public List<RecursoReservado> consultarReservasDeUnUsuario(@Param("usuario") Usuario usuario);
	
	public List<RecursoReservado> consultarReservas();

	public RecursoReservado consultarReserva(@Param("idR") long id);
	
	public void actualizarEstadoReserva(@Param("id") long id, @Param("estado") String estado);
	
	public List<RecursoReservado> consultarRecursosMasUsados();
	
	public List<RecursoReservado> consultarRecursosMenosUsados();
	
	public List<RecursoReservado> consultarHorariosDeMayorOcupacion();
	
	public List<RecursoReservado> consultarHorariosDeMenorOcupacion();
	
	public List<RecursoReservado> consultarReservasRecurrentes();
	
	public List<RecursoReservado> consultarReservasCanceladas();
}
