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

	public List<RecursoReservado> consultarReserva(@Param("id") long id);
	
	public List<RecursoReservado> consultarReservasDeUnUsuario(@Param("usuario") Usuario usuario);
	
	public List<RecursoReservado> consultarReservas();
	

}
