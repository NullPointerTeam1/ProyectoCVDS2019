package edu.eci.cvds.sampleprj.dao.mybatis.mappers;


import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Recurso;

/**
 *
 * @author NullPointerTeam
 */
public interface RecursoMapper {
    
    
    public List<Recurso> consultarRecursos();        
    
    public Recurso consultarRecurso(@Param("Recursoid")int id);
    
    public void insertarRecurso(@Param("Recurso")Recurso it);

        
}
