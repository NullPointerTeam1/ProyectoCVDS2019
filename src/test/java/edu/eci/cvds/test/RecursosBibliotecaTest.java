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
	
	@Test
	public void deberiaRegistrarUnRecurso() throws ExcepcionServiciosBiblioteca {
		
		Recurso re = new Recurso(serviciosB.consultarTipoRecurso(1),0,"Recursoprueba1","ubiprueba1",10,null,null,"Disponible");
		serviciosB.registrarRecurso(re);
		Recurso pruebaRecurso = serviciosB.consultarRecurso(serviciosB.consultarRecursos().get(serviciosB.consultarRecursos().size()-1).getId());
		assertTrue(pruebaRecurso.getId() == serviciosB.consultarRecursos().get(serviciosB.consultarRecursos().size()-1).getId());
	} 
	
	@Test
	public void nodeberiaRegistrarUnRecursoPorCheck() throws ExcepcionServiciosBiblioteca{
		Recurso re = new Recurso(serviciosB.consultarTipoRecurso(1),0,"RecursoPrueba2","Biblioteca",-30,null,null,"dee");
		try {
			serviciosB.registrarRecurso(re);
			assertTrue(false);
		} catch (PersistenceException | ExcepcionServiciosBiblioteca e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void deberiaRegistrarUnRecursoConElIdConsecutivo() throws ExcepcionServiciosBiblioteca {
		
		Recurso re = new Recurso(serviciosB.consultarTipoRecurso(2),50,"RecursoPrueba3","Ubiprueba3",100,null,null,"Ocupado");
		serviciosB.registrarRecurso(re);
		assertTrue(serviciosB.consultarRecursos().get(serviciosB.consultarRecursos().size()-1).getId() == serviciosB.consultarRecursos().get(serviciosB.consultarRecursos().size()-2).getId()+1);
		
	}
	
	@Test
	public void deberiaActualizarEstadoyConsultar() throws ExcepcionServiciosBiblioteca {
		
		Recurso recurPrueba = serviciosB.consultarRecurso(1);
		serviciosB.actualizarEstadoRecurso(1, "No Disponible");
		assertTrue(recurPrueba.getDisponibilidad().equals("No Disponible") && recurPrueba !=null);
	}
	
	@Test
	public void deberiaConsultarUnRecurso() throws ExcepcionServiciosBiblioteca {

		Recurso recurPrueba = serviciosB.consultarRecurso(2);
		assertTrue (recurPrueba !=null);
	}
	
	@Test
	public void nodeberiaConsultarUnRecurso() throws ExcepcionServiciosBiblioteca {
		
		assertTrue (serviciosB.consultarRecurso(1000) == null);
		
	}
	
	
	
	
}