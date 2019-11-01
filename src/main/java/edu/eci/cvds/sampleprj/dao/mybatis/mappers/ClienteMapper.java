package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.Date;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Usuario;

/**
 *
 * @author NullPointerTeam
 */
public interface ClienteMapper {
    
    public Usuario consultarCliente(@Param("idcli") long id) throws PersistenceException; 
   
    /**
     * Consultar todos los clientes
     * @return 
     */
    public List<Usuario> consultarClientes();
    
    public void agregarCliente(@Param("cli")Usuario cli);
    
}
