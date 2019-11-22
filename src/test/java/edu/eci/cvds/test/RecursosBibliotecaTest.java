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

import org.junit.Test;


@Transactional
public class RecursosBibliotecaTest {
	
	private ServiciosReserva serviciosB;
	
	public RecursosBibliotecaTest() throws ExcepcionServiciosBiblioteca {
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
	public void nodeberiaRegistrarUnRecursoPorCheck() {
		Recurso re;
		try {
			re = new Recurso(serviciosB.consultarTipoRecurso(1),0,"RecursoPrueba2","Biblioteca",-30,null,null,"Disponible");
			serviciosB.registrarRecurso(re);
			fail("Debe fallar porque la capacidad es negativa");
		} catch (ExcepcionServiciosBiblioteca e) {
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
		serviciosB.actualizarEstadoRecurso(1, "Disponible");
		Recurso recurPrueba = serviciosB.consultarRecurso(1);
		assertTrue(recurPrueba.getDisponibilidad().equals("Disponible") && recurPrueba !=null);
		serviciosB.actualizarEstadoRecurso(1, "No Disponible");
		recurPrueba = serviciosB.consultarRecurso(1);
		assertTrue(recurPrueba.getDisponibilidad().equals("No Disponible") && recurPrueba !=null);
		serviciosB.actualizarEstadoRecurso(1, "Disponible");
	}
	
	@Test
	public void deberiaConsultarUnRecurso() throws ExcepcionServiciosBiblioteca {

		Recurso recurPrueba = serviciosB.consultarRecurso(2);
		assertTrue (recurPrueba !=null);
	}
	
	@Test
	public void nodeberiaConsultarUnRecurso() throws ExcepcionServiciosBiblioteca {
		
		assertTrue (serviciosB.consultarRecurso(10000) == null);
		
	}
	
	
	@Test
	public void deberiaRegistrarUnaReserva() throws ExcepcionServiciosBiblioteca, edu.eci.cvds.sampleprj.dao.PersistenceException  {
		
		LocalTime localTime1 = LocalTime.of(13, 30, 45);
		LocalTime localTime2 = LocalTime.of(15, 30, 45);
		LocalDate localDate1 = LocalDate.of(2019, Month.NOVEMBER, 15);
		LocalDate localDate2 = LocalDate.of(2019, Month.NOVEMBER, 16);
		int ultId = serviciosB.consultarReservas().get(serviciosB.consultarReservas().size()-1).getId();
		RecursoReservado recurPrueba = new RecursoReservado(ultId,localDate1,localDate2,localTime1,localTime2,serviciosB.consultarRecurso(6),serviciosB.consultarUsuario(2148781));
		recurPrueba.getRecurso().getTipo().setId(1);
		//serviciosB.registrarReserva(recurPrueba);
		assertTrue(ultId == recurPrueba.getId());
	} 
	
	@Test
	public void nodeberiaRegistrarReservaPorRecursoReservado() throws edu.eci.cvds.sampleprj.dao.PersistenceException, ExcepcionServiciosBiblioteca {
		
		LocalTime localTime1 = LocalTime.of(10, 30, 00);
		LocalTime localTime2 = LocalTime.of(15, 30, 00);
		LocalDate localDate1 = LocalDate.of(2019, Month.NOVEMBER, 15);
		RecursoReservado recurPrueba = new RecursoReservado(15,localDate1,localDate1,localTime1,localTime2,serviciosB.consultarRecurso(6),serviciosB.consultarUsuario(2148781));
		try {
			serviciosB.registrarReserva(recurPrueba);
			fail("Debe fallar porque no se puede reservar un recurso ya reservado");
		} catch (ExcepcionServiciosBiblioteca e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}		
	} 
	
	@Test
	public void nodeberiaRegistrarReservaPorLaHora() throws edu.eci.cvds.sampleprj.dao.PersistenceException, ExcepcionServiciosBiblioteca {
		
		LocalTime localTime1 = LocalTime.of(10, 30, 00);
		LocalTime localTime2 = LocalTime.of(13, 30, 00);
		LocalDate localDate1 = LocalDate.of(2019, Month.NOVEMBER, 15);
		RecursoReservado recurPrueba = new RecursoReservado(15,localDate1,localDate1,localTime1,localTime2,serviciosB.consultarRecurso(10),serviciosB.consultarUsuario(2148781));
		try {
			serviciosB.registrarReserva(recurPrueba);
			fail("Debe fallar porque no se puede reservar un Equipo de computo por más de dos horas");
		} catch (ExcepcionServiciosBiblioteca e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}		
	} 
	
	@Test
	public void nodeberiaRegistrarReservaPorDisponibilidad() throws edu.eci.cvds.sampleprj.dao.PersistenceException, ExcepcionServiciosBiblioteca {
		
		LocalTime localTime1 = LocalTime.of(10, 30, 00);
		LocalTime localTime2 = LocalTime.of(12, 30, 00);
		LocalDate localDate1 = LocalDate.of(2019, Month.NOVEMBER, 15);
		RecursoReservado recurPrueba = new RecursoReservado(16,localDate1,localDate1,localTime1,localTime2,serviciosB.consultarRecurso(16),serviciosB.consultarUsuario(2148781));
		try {
			serviciosB.registrarReserva(recurPrueba);
			fail("Debe fallar porque no se puede reservar un recurso Ocupado");
		} catch (ExcepcionServiciosBiblioteca e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}		
	} 
	
	@Test
	public void nodeberiaRegistrarReservaPorHorario() throws edu.eci.cvds.sampleprj.dao.PersistenceException, ExcepcionServiciosBiblioteca {
		
		LocalTime localTime1 = LocalTime.of(5, 30, 00);
		LocalTime localTime2 = LocalTime.of(6, 30, 00);
		LocalDate localDate1 = LocalDate.of(2019, Month.NOVEMBER, 15);
		RecursoReservado recurPrueba = new RecursoReservado(16,localDate1,localDate1,localTime1,localTime2,serviciosB.consultarRecurso(8),serviciosB.consultarUsuario(2148781));
		try {
			serviciosB.registrarReserva(recurPrueba);
			fail("Debe fallar porque no se puede reservar este recurso en un horario no estipulado");
		} catch (ExcepcionServiciosBiblioteca e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}		
	} 
}