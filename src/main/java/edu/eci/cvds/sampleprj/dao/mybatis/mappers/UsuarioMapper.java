package edu.eci.cvds.sampleprj.dao.mybatis.mappers;



import java.util.List;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.samples.entities.Usuario;

/**
 * @author NullPointerTeam
 */
public interface UsuarioMapper {

	public void insertarUsuario(@Param("usuario") Usuario usuario);

	public Usuario consultarUsuario(@Param("id") long id);

	public List<Usuario> consultarUsuarios();

	/*public void agregarRecursoRentadoAUsuario(
			@Param("idUsuario") long idUsu, 
			@Param("idRecurso") long idRe,
			@Param("fechaIni") Date fechaIni, 
			@Param("fechaFin") Date fechaFin);*/

	// public List<RecursoReservado> consultarRecursosRentadosUsuario(@Param("id") long id);

}
