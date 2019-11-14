package edu.eci.cvds.test;

import org.mybatis.guice.transactional.Transactional;

import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.ExcepcionServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosReserva;
import edu.eci.cvds.samples.services.ServiciosReservaFactory;
import static org.junit.Assert.*;

import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.Test;


@Transactional
public class RecursosBibliotecaTest {
	
	private ServiciosReserva serviciosB;
	
	public RecursosBibliotecaTest() {
		serviciosB = ServiciosReservaFactory.getInstance().getServiciosBibliotecaTesting();
	}
	
	/**@Test
	public void deberiaRegistrarUnRecurso() throws ExcepcionServiciosBiblioteca {
		
		Recurso re = new Recurso((new TipoRecurso(4,"SALOON")),200,"PRUEBATEST1","Biblioteca",30,java.sql.Date.valueOf("2019-05-11"),java.sql.Date.valueOf("2019-05-11"),"d");
		serviciosB.registrarRecurso(re);
		Recurso pruebaRecurso = serviciosB.consultarRecurso(serviciosB.consultarRecursos().get(serviciosB.consultarRecursos().size()-1).getId());
		assertTrue(pruebaRecurso.getId() == serviciosB.consultarRecursos().get(serviciosB.consultarRecursos().size()-1).getId());
	} 
	
	@Test
	public void nodeberiaRegistrarUnRecursoPorCheck() throws ExcepcionServiciosBiblioteca {
		Recurso re = new Recurso((new TipoRecurso(10,"MULTIMEDIA")),70,"PRUEBA","Biblioteca",30,java.sql.Date.valueOf("2019-05-11"),"dee");
		try {
			serviciosB.registrarRecurso(re);
			assertTrue(false);
		} catch (PersistenceException e) {
			assertTrue(true);
		}
	}**/
	
	/**@Test
	public void deberiaRegistrarUnRecursoConElIdConsecutivo() throws ExcepcionServiciosBiblioteca {
		
		Recurso re = new Recurso((new TipoRecurso(10,"MULTIMEDIA")),50,"PRUEBATEST2","PRUEBATEST2",100,java.sql.Date.valueOf("2019-05-11"),"d");
		serviciosB.registrarRecurso(re);
		System.out.println(serviciosB.consultarRecursos());
		assertTrue(serviciosB.consultarRecursos().get(serviciosB.consultarRecursos().size()-1).getId() == serviciosB.consultarRecursos().get(serviciosB.consultarRecursos().size()-2).getId()+1);
		
	}**/
	
	@Test
	public void deberiaActualizarEstadoyConsultar() throws ExcepcionServiciosBiblioteca {
		
		Recurso recurPrueba = serviciosB.consultarRecurso(1);
		serviciosB.actualizarEstadoRecurso(1, "n");
		assertTrue(recurPrueba.getDisponibilidad().equals("n") && recurPrueba !=null);
	}
	
	@Test
	public void deberiaConsultarUnRecurso() throws ExcepcionServiciosBiblioteca {
		
		Recurso recurPrueba = serviciosB.consultarRecurso(1);
		assertTrue (recurPrueba !=null);
	}
	
	@Test
	public void nodeberiaConsultarUnRecurso() {
		
		try{
			serviciosB.consultarRecurso(1000);
			assertTrue(false);
		}catch(ExcepcionServiciosBiblioteca e) {
			assertTrue(true);
		}
	}
	
	
	
	
}