package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.Date;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.samples.entities.RecursoReservado;
import edu.eci.cvds.samples.entities.Usuario;

/**
 * @author NullPointerTeam
 */
public interface UsuarioMapper {

	public void insertarUsuario(@Param("usuario") Usuario usuario);

	public Usuario consultarUsuario(@Param("id") long id);

	public List<Usuario> consultarUsuarios();


}
