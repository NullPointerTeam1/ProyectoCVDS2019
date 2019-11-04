package edu.eci.cvds.sampleprj.dao.mybatis.mappers;


import java.util.List;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.samples.entities.TipoRecurso;

/**
 * @author NullPointerTeam
*/
public interface TipoRecursoMapper {
	
	public void insertarTipoRecurso(@Param("tipoRecurso") TipoRecurso ti);

}
