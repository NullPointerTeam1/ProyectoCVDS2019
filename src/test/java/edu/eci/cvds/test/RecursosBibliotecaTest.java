package edu.eci.cvds.test;

import org.mybatis.guice.transactional.Transactional;

import edu.eci.cvds.authenticator.SessionLogger;
import edu.eci.cvds.authenticator.ShiroSession;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.ExcepcionServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosReserva;
import edu.eci.cvds.samples.services.ServiciosReservaFactory;
import edu.eci.cvds.view.LoginBean;
import static org.junit.Assert.*;

import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.Test;


@Transactional
public class RecursosBibliotecaTest {
	
	private ServiciosReserva serviciosB;
	
	public RecursosBibliotecaTest() {
		serviciosB = ServiciosReservaFactory.getInstance().getServiciosBibliotecaTesting();
	}
	
	@Test
	public void deberiaRegistrarUnRecurso() throws ExcepcionServiciosBiblioteca {
		
		/**TipoRecurso tipo = new TipoRecurso(40,"MULTIMEDIA");
		serviciosB.registrarTipoRecurso(tipo);
		Recurso re = new Recurso(tipo,50,"PRUEBA","Biblioteca",30,java.sql.Date.valueOf("2019-05-11"),"d");
		serviciosB.registrarRecurso(re);**/
		Recurso pruebaRecurso = serviciosB.consultarRecurso(50);
		System.out.println(pruebaRecurso);
		assertTrue(pruebaRecurso.getId() == 50);
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
	}
	
	@Test
	public void nodeberiaRegistrarUnRecursoPorPK() throws ExcepcionServiciosBiblioteca {
		
		Recurso re = new Recurso((new TipoRecurso(10,"MULTIMEDIA")),50,"PRUEBA","Biblioteca",30,java.sql.Date.valueOf("2019-05-11"),"d");
		try
		serviciosB.registrarRecurso(re);
			
	
	}
	
	

	
	
	
}