package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.RecursoRentado;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ExcepcionServiciosBiblioteca;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;


public interface UsuarioDAO {


	public Usuario load(long id) throws ExcepcionServiciosBiblioteca;

	void save(Usuario cli) throws PersistenceException;

	void agregarRecursoRentado(long docu, Recurso Recurso, java.sql.Date fechaini, java.sql.Date fechafin);

	public List<Usuario> consultarUsuarios() throws ExcepcionServiciosBiblioteca;

	public List<RecursoRentado> consultarRecursosRentados(long id) throws ExcepcionServiciosBiblioteca;


	
}
