package edu.eci.cvds.test;

import org.mybatis.guice.transactional.Transactional;


import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.ExcepcionServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosReserva;
import edu.eci.cvds.samples.services.ServiciosReservaFactory;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

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
		System.out.println(serviciosB.consultarRecursos());
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
	
	
	@Test
	public void deberiaRegistrarUnaReservaYCambiarEstado()  {
		
		LocalTime localTime1 = LocalTime.of(4, 30, 45);
		LocalTime localTime2 = LocalTime.of(6, 30, 45);
		LocalDate localDate1 = LocalDate.of(2019, Month.NOVEMBER, 15);
		LocalDate localDate2 = LocalDate.of(2019, Month.NOVEMBER, 16);
		RecursoReservado recurPrueba = null;
		try {
			recurPrueba = new RecursoReservado(1,localDate1,localDate2,localTime1,localTime2,serviciosB.consultarRecurso(6),serviciosB.consultarUsuario(2148781));
		} catch (ExcepcionServiciosBiblioteca e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			serviciosB.registrarReserva(recurPrueba);
		} catch (ExcepcionServiciosBiblioteca | edu.eci.cvds.sampleprj.dao.PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertTrue (recurPrueba !=null && serviciosB.consultarRecurso(5).getDisponibilidad().equals("No Disponible"));
		} catch (ExcepcionServiciosBiblioteca e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	@Test
	public void deberiaRegistrarReservaConHoraEstablecida() throws ExcepcionServiciosBiblioteca, edu.eci.cvds.sampleprj.dao.PersistenceException {
		
		LocalTime localTime1 = LocalTime.of(5, 30, 00);
		LocalTime localTime2 = null;
		LocalDate localDate1 = LocalDate.of(2019, Month.NOVEMBER, 15);
		RecursoReservado recurPrueba = new RecursoReservado(0,localDate1,localDate1,localTime1,localTime2,serviciosB.consultarRecurso(10),serviciosB.consultarUsuario(2148781));
		System.out.println(serviciosB.consultarRecurso(10));
		System.out.println(serviciosB.consultarReservas());
		serviciosB.registrarReserva(recurPrueba);
		//assertTrue (recurPrueba !=null && serviciosB.consultarRecurso(10).getDisponibilidad().equals("No Disponible"));
	} 
	
	
	
	

	
	
}