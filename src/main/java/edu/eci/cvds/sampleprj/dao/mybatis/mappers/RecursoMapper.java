package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.samples.entities.Recurso;

/**
 * @author NullPointerTeam
 */
public interface RecursoMapper {

	public void insertarRecurso(@Param("recurso") Recurso recurso);

	public List<Recurso> consultarRecursos();

	public Recurso consultarRecurso(@Param("id") long id);

}
