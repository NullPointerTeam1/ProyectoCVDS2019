package edu.eci.cvds.sampleprj.dao.mybatis.mappers;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.TipoRecurso;

public interface TipoRecursoMapper {
    
    
    public List<TipoRecurso> getTiposRecursos();
    
    public TipoRecurso getTipoRecurso(@Param("tipoRecursoid")int id);
    
    public void insertarTipoRecurso(@Param("ti")TipoRecurso ti); 
    
    public void addTipoRecurso(String des);

}
