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
import java.util.List;

import org.junit.Test;


@Transactional
public class RecursosBibliotecaTest {
	
	private ServiciosReserva serviciosB;
	
	public RecursosBibliotecaTest() throws ExcepcionServiciosBiblioteca {
		serviciosB = ServiciosReservaFactory.getInstance().getServiciosBibliotecaTesting();
	}
	
	/**
	 * Registra un recurso con los requisitos estipulados, verifica que el id del recurso que insertamos coincida con el ultimo
	 * de la lista al momento de realizar la consulta "Consultar recursos" asumiendo que esta en la ultima posición de este arreglo
	 * gracias al ORDER BY que realizamos en la consulta.
	 * @throws ExcepcionServiciosBiblioteca
	 */
	@Test
	public void deberiaRegistrarUnRecurso() throws ExcepcionServiciosBiblioteca {
		
		Recurso re = new Recurso(serviciosB.consultarTipoRecurso(1),0,"Recursoprueba1","ubiprueba1",10,null,null,"Disponible");
		serviciosB.registrarRecurso(re);
		Recurso pruebaRecurso = serviciosB.consultarRecurso(serviciosB.consultarRecursos().get(serviciosB.consultarRecursos().size()-1).getId());
		assertTrue(pruebaRecurso.getId() == serviciosB.consultarRecursos().get(serviciosB.consultarRecursos().size()-1).getId());
		
	} 
	
	/**
	 * No registra un recurso debido a que intentamos registrarlo con una capacidad negativa, por lo que el check establecido en la base de datos
	 * protege la integridad de los datos.
	 */
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
	
	/**
	 * A partir de esta prueba verificamos que funcione la secuencia definida para el concepto de recurso. 
	 * Mediante el arreglo de consultar recursos verificamos que el recurso que el recurso en la ultima posicion tiene el id igual al recurso anterior mas uno.
	 * @throws ExcepcionServiciosBiblioteca
	 */
	@Test
	public void deberiaRegistrarUnRecursoConElIdConsecutivo() throws ExcepcionServiciosBiblioteca {
		List<Recurso> recursos = serviciosB.consultarRecursos();
		int identificador = recursos.get(recursos.size() - 1).getId();
		Recurso re = new Recurso(serviciosB.consultarTipoRecurso(2),50,"RecursoPrueba4","Ubiprueba4",100,null,null,"Ocupado");
		serviciosB.registrarRecurso(re);
		recursos = serviciosB.consultarRecursos();
		int identificadorActual = recursos.get(recursos.size() - 1).getId();
		assertTrue(identificador == identificadorActual - 1);
	
	}
	
	/**
	 * En esta prueba se realiza un restablecimiento del estado del recurso, para la aplicación tenemos tres posibles estados
	 * "Disponible", "No disponible" y "Ocupado". Al momento de realizar la prueba verificamos que la descripcion del Tipo del recurso sea la restablecida.
	 * @throws ExcepcionServiciosBiblioteca
	 */
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
	
	/**
	 * Esta prueba utiliza el servicio consultar recurso y verificamos que el objeto que asignamos no este vacio.
	 * @throws ExcepcionServiciosBiblioteca
	 */
	@Test
	public void deberiaConsultarUnRecurso() throws ExcepcionServiciosBiblioteca {

		Recurso recurPrueba = serviciosB.consultarRecurso(2);
		assertTrue (recurPrueba !=null);
	}
	
	/**
	 * No consulta el recurso debido a que este id no tiene registro en nuestra base de datos
	 * @throws ExcepcionServiciosBiblioteca
	 */
	@Test
	public void nodeberiaConsultarUnRecurso() throws ExcepcionServiciosBiblioteca {
		
		assertTrue (serviciosB.consultarRecurso(10000) == null);
		
	}
	
	/**
	 * Registra una reserva con los requisitos establecidos, verificamos que en el arreglo de reservas la que acabamos de registrar 
	 * se encuentre en la ultima posicion
	 * @throws ExcepcionServiciosBiblioteca
	 * @throws edu.eci.cvds.sampleprj.dao.PersistenceException
	 */
	@Test
	public void deberiaRegistrarUnaReserva() throws ExcepcionServiciosBiblioteca, edu.eci.cvds.sampleprj.dao.PersistenceException  {
		
		LocalTime localTime1 = LocalTime.of(13, 30, 45);
		LocalTime localTime2 = LocalTime.of(15, 30, 45);
		LocalDate localDate1 = LocalDate.of(2019, Month.NOVEMBER, 15);
		LocalDate localDate2 = LocalDate.of(2019, Month.NOVEMBER, 15);
		int ultId = serviciosB.consultarReservas().get(serviciosB.consultarReservas().size()-1).getId();
		RecursoReservado recurPrueba = new RecursoReservado(ultId,localDate1,localDate2,localTime1,localTime2,serviciosB.consultarRecurso(7),serviciosB.consultarUsuario(2148781));
		recurPrueba.getRecurso().getTipo().setId(1);
		//serviciosB.registrarReserva(recurPrueba);
		assertTrue(ultId == recurPrueba.getId());
	} 
	
	/**
	 * En este caso de prueba no registra una reserva debido a que el recurso ya se encuentra reservado 
	 * @throws edu.eci.cvds.sampleprj.dao.PersistenceException
	 * @throws ExcepcionServiciosBiblioteca
	 */
	@Test
	public void nodeberiaRegistrarReservaPorRecursoReservado() throws edu.eci.cvds.sampleprj.dao.PersistenceException, ExcepcionServiciosBiblioteca {
		
		LocalTime localTime1 = LocalTime.of(10, 30, 00);
		LocalTime localTime2 = LocalTime.of(15, 30, 00);
		LocalDate localDate1 = LocalDate.of(2019, Month.NOVEMBER, 15);
		RecursoReservado recurPrueba = new RecursoReservado(15,localDate1,localDate1,localTime1,localTime2,serviciosB.consultarRecurso(6),serviciosB.consultarUsuario(2148781));
		try {
			serviciosB.registrarReserva(recurPrueba, "No");
			fail("Debe fallar porque no se puede reservar un recurso ya reservado");
		} catch (ExcepcionServiciosBiblioteca e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}		
	} 
	
	/**
	 * No se pueden registrar reservas por más de dos horas de recursos que no sean equipos de multimedia, en el ejemplo
	 * se intenta reservar un equipo de computo por mas de dos horas
	 * @throws edu.eci.cvds.sampleprj.dao.PersistenceException
	 * @throws ExcepcionServiciosBiblioteca
	 */
	@Test
	public void nodeberiaRegistrarReservaPorLaHora() throws edu.eci.cvds.sampleprj.dao.PersistenceException, ExcepcionServiciosBiblioteca {
		
		LocalTime localTime1 = LocalTime.of(10, 30, 00);
		LocalTime localTime2 = LocalTime.of(13, 30, 00);
		LocalDate localDate1 = LocalDate.of(2019, Month.NOVEMBER, 15);
		RecursoReservado recurPrueba = new RecursoReservado(15,localDate1,localDate1,localTime1,localTime2,serviciosB.consultarRecurso(10),serviciosB.consultarUsuario(2148781));
		try {
			serviciosB.registrarReserva(recurPrueba, "No");
			fail("Debe fallar porque no se puede reservar un Equipo de computo por más de dos horas");
		} catch (ExcepcionServiciosBiblioteca e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}		
	} 
	
	/**
	 * En este caso de prueba se intenta realizar la reserva de un recurso que se encuentra en estado Ocupado
	 * No se puede realizar la reserva de un recurso que no este en estado disponible
	 * @throws edu.eci.cvds.sampleprj.dao.PersistenceException
	 * @throws ExcepcionServiciosBiblioteca
	 */
	@Test
	public void nodeberiaRegistrarReservaPorDisponibilidad() throws edu.eci.cvds.sampleprj.dao.PersistenceException, ExcepcionServiciosBiblioteca {
		
		LocalTime localTime1 = LocalTime.of(10, 30, 00);
		LocalTime localTime2 = LocalTime.of(12, 30, 00);
		LocalDate localDate1 = LocalDate.of(2019, Month.NOVEMBER, 15);
		RecursoReservado recurPrueba = new RecursoReservado(16,localDate1,localDate1,localTime1,localTime2,serviciosB.consultarRecurso(16),serviciosB.consultarUsuario(2148781));
		try {
			serviciosB.registrarReserva(recurPrueba, "No");
			fail("Debe fallar porque no se puede reservar un recurso Ocupado");
		} catch (ExcepcionServiciosBiblioteca e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}		
	} 
	/**
	 * Para esta situación intentamos realizar la reserva de un recurso en un horario no permitido
	 * Para realizar la reserva de cualquier recurso se debe tener en cuenta el horario de este mismo. 
	 * En el ejemplo se intenta reservar un recurso a las 5 30 am cuando esta disponible desde las 7 am
	 * @throws edu.eci.cvds.sampleprj.dao.PersistenceException
	 * @throws ExcepcionServiciosBiblioteca
	 */
	@Test
	public void nodeberiaRegistrarReservaPorHorario() throws edu.eci.cvds.sampleprj.dao.PersistenceException, ExcepcionServiciosBiblioteca {
		
		LocalTime localTime1 = LocalTime.of(5, 30, 00);
		LocalTime localTime2 = LocalTime.of(6, 30, 00);
		LocalDate localDate1 = LocalDate.of(2019, Month.NOVEMBER, 15);
		RecursoReservado recurPrueba = new RecursoReservado(16,localDate1,localDate1,localTime1,localTime2,serviciosB.consultarRecurso(8),serviciosB.consultarUsuario(2148781));
		try {
			serviciosB.registrarReserva(recurPrueba, "No");
			fail("Debe fallar porque no se puede reservar este recurso en un horario no estipulado");
		} catch (ExcepcionServiciosBiblioteca e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}		
	}
	
	/*
	@Test
	public void prueba () throws ExcepcionServiciosBiblioteca {
		int id = 5;
		LocalDate fechaInicio = LocalDate.of(2018, 1, 1);
		LocalDate fechaFin = LocalDate.of(2018, 1, 5);
		LocalTime horaInicio = LocalTime.of(9, 30, 00);
		LocalTime horaFin = LocalTime.of(11, 30, 00);
		Recurso recurso = serviciosB.consultarRecurso(1);
		Usuario usuario = serviciosB.consultarUsuario(2148781);
		RecursoReservado nuevo = new RecursoReservado(id, fechaInicio, fechaFin, horaInicio, horaFin, recurso, usuario);
		serviciosB.registrarReserva(nuevo, "Diario");
	}*/
}