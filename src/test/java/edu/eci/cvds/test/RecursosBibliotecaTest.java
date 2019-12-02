package edu.eci.cvds.test;

import org.mybatis.guice.transactional.Transactional;


import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.ExcepcionServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosReserva;
import edu.eci.cvds.samples.services.ServiciosReservaFactory;
import static org.junit.Assert.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.junit.Test;


@Transactional
public class RecursosBibliotecaTest {
	
	private ServiciosReserva serviciosB;
	
	public RecursosBibliotecaTest() throws ExcepcionServiciosBiblioteca {
		serviciosB = ServiciosReservaFactory.getInstance().getServiciosBibliotecaTesting();
	}
	
	/**
	 * No registra un recurso debido a que intentamos registrarlo con una capacidad negativa, por lo que el check establecido en la base de datos
	 * protege la integridad de los datos.
	 */
	
	@Test
	public void nodeberiaRegistrarUnRecursoPorCheck() {
		Recurso re;
		try {
			re = new Recurso(serviciosB.consultarTipoRecurso(1),0,"RecursoPrueba2","Biblioteca",-30,null,null,"Disponible","Equipo de prueba2 INTEL");
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
		Recurso re = new Recurso(serviciosB.consultarTipoRecurso(2),50,"RecursoPrueba4","Ubiprueba4",100,null,null,"Ocupado","Equipo de prueba3 INTEL");
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
	 * En este caso de prueba no registra una reserva debido a que el recurso ya se encuentra reservado 
	 * @throws edu.eci.cvds.sampleprj.dao.PersistenceException
	 * @throws ExcepcionServiciosBiblioteca
	 */
	
	@Test
	public void nodeberiaRegistrarReservaPorRecursoReservado() throws edu.eci.cvds.sampleprj.dao.PersistenceException, ExcepcionServiciosBiblioteca {
		
		LocalTime localTime1 = LocalTime.of(10, 30, 00);
		LocalTime localTime2 = LocalTime.of(15, 30, 00);
		LocalDate localDate1 = LocalDate.of(2019, Month.NOVEMBER, 15);
		LocalDate now = LocalDate.now();
		RecursoReservado recurPrueba = new RecursoReservado(15,localDate1,localDate1,localTime1,localTime2,now,serviciosB.consultarRecurso(6),serviciosB.consultarUsuario(2148781),"Activa","No");
		try {
			serviciosB.registrarReserva(recurPrueba, "No");
			fail("Debe fallar porque no se puede reservar un recurso ya reservado");
		} catch (ExcepcionServiciosBiblioteca e) {
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
		LocalDate now = LocalDate.now();
		LocalDate localDate1 = LocalDate.of(2019, Month.NOVEMBER, 15);
		RecursoReservado recurPrueba = new RecursoReservado(15,localDate1,localDate1,localTime1,localTime2,now,serviciosB.consultarRecurso(10),serviciosB.consultarUsuario(2148781),"Activa","No");
		try {
			serviciosB.registrarReserva(recurPrueba, "No");
			fail("Debe fallar porque no se puede reservar un Equipo de computo por más de dos horas");
		} catch (ExcepcionServiciosBiblioteca e) {
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
		LocalDate now = LocalDate.now();
		LocalDate localDate1 = LocalDate.of(2019, Month.NOVEMBER, 15);
		RecursoReservado recurPrueba = new RecursoReservado(16,localDate1,localDate1,localTime1,localTime2,now,serviciosB.consultarRecurso(1),serviciosB.consultarUsuario(2148781),"Activa","no");
		try {
			serviciosB.registrarReserva(recurPrueba, "No");
			fail("Debe fallar porque no se puede reservar un recurso Ocupado");
		} catch (ExcepcionServiciosBiblioteca e) {
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
		LocalDate now = LocalDate.now();
		LocalDate localDate1 = LocalDate.of(2019, Month.NOVEMBER, 15);
		RecursoReservado recurPrueba = new RecursoReservado(16,localDate1,localDate1,localTime1,localTime2,now,serviciosB.consultarRecurso(8),serviciosB.consultarUsuario(2148781),"Activa","no");
		try {
			serviciosB.registrarReserva(recurPrueba, "No");
			fail("Debe fallar porque no se puede reservar este recurso en un horario no estipulado");
		} catch (ExcepcionServiciosBiblioteca e) {
			assertTrue(true);
		}		
	}
	
	
	/**
	 * Registra una reserva con los requisitos establecidos, verificamos que en el arreglo de reservas la que acabamos de registrar 
	 * se encuentre en la ultima posicion
	 * @throws ExcepcionServiciosBiblioteca
	 * @throws edu.eci.cvds.sampleprj.dao.PersistenceException
	 */
	@Test
	public void deberiaRegistrarUnaReserva() throws ExcepcionServiciosBiblioteca, edu.eci.cvds.sampleprj.dao.PersistenceException  {
		
		
		LocalDate localDate1 = LocalDate.now();
		LocalDate localDate2 = LocalDate.now();
		if (localDate1.getDayOfWeek() == DayOfWeek.SUNDAY || localDate2.getDayOfWeek() == DayOfWeek.SUNDAY) {
			localDate1 = localDate1.plusDays(1);
			localDate2 = localDate2.plusDays(1);
		}
		LocalDate now = LocalDate.now();
		int ultId = serviciosB.consultarReservas().get(serviciosB.consultarReservas().size()-1).getId();
		Recurso recur = serviciosB.consultarRecurso(15);
		List <RecursoReservado> reservasR = serviciosB.consultarReservaRecurso(recur.getId());
		LocalTime localTime1 = reservasR.get(0).getHoraFinReserva().plusMinutes(15);
		LocalTime localTime2 = localTime1.plusMinutes(15);
		RecursoReservado recurPrueba = new RecursoReservado(ultId,localDate1,localDate2,localTime1,localTime2,
				now,recur ,serviciosB.consultarUsuario(2148782),"Activa","No");
		serviciosB.registrarReserva(recurPrueba,"No");
		assertTrue(ultId == recurPrueba.getId());
	} 
	
	@Test
	public void deberiaRegistrarReservaRecurrenteDiaria () throws ExcepcionServiciosBiblioteca {
		
		int numReservasInicial = serviciosB.consultarReservas().size();
		LocalDate fechaInicio = LocalDate.now();
		LocalDate fechaFin = LocalDate.now().plusDays(2);
		if (fechaInicio.getDayOfWeek() == DayOfWeek.SUNDAY || fechaFin.getDayOfWeek() == DayOfWeek.SUNDAY) {
			fechaInicio = fechaInicio.plusDays(1);
			fechaFin = fechaFin.plusDays(1);
		}
		Recurso recur = serviciosB.consultarRecurso(15);
		List <RecursoReservado> reservasR = serviciosB.consultarReservaRecurso(recur.getId());
		LocalTime horaInicio = reservasR.get(0).getHoraFinReserva().plusMinutes(15);
		LocalTime horaFin = horaInicio.plusMinutes(15);
		LocalDate actual = LocalDate.now();
		Recurso recurso = serviciosB.consultarRecurso(15);
		Usuario usuario = serviciosB.consultarUsuario(2148782);
		String estado = "Activa";
		String recurrente = "Si";
		RecursoReservado nuevo = new RecursoReservado(1, fechaInicio, fechaFin, horaInicio, horaFin, actual,recurso, usuario,estado,recurrente);
		serviciosB.registrarReserva(nuevo, "Diario");
		int numReservasFinal = serviciosB.consultarReservas().size();
		int dif = (int) fechaInicio.until(fechaFin, ChronoUnit.DAYS);
		assertTrue(numReservasInicial  == numReservasFinal - (dif +1) );
	}
	
	@Test
	public void deberiaRegistrarReservaRecurrenteSemanal () throws ExcepcionServiciosBiblioteca {
		
		int numReservasInicial = serviciosB.consultarReservas().size();
		LocalDate fechaInicio = LocalDate.now();
		LocalDate fechaFin = LocalDate.now().plusWeeks(1);
		if (fechaInicio.getDayOfWeek() == DayOfWeek.SUNDAY || fechaFin.getDayOfWeek() == DayOfWeek.SUNDAY) {
			fechaInicio = fechaInicio.plusDays(1);
			fechaFin = fechaFin.plusDays(1);
		}
		Recurso recur = serviciosB.consultarRecurso(15);
		List <RecursoReservado> reservasR = serviciosB.consultarReservaRecurso(recur.getId());
		LocalTime horaInicio = reservasR.get(0).getHoraFinReserva().plusMinutes(15);
		LocalTime horaFin = horaInicio.plusMinutes(15);
		LocalDate actual = LocalDate.now();
		Recurso recurso = serviciosB.consultarRecurso(15);
		Usuario usuario = serviciosB.consultarUsuario(2148782);
		String estado = "Activa";
		String recurrente = "Si";
		RecursoReservado nuevo = new RecursoReservado(1, fechaInicio, fechaFin, horaInicio, horaFin, actual,recurso, usuario,estado,recurrente);
		serviciosB.registrarReserva(nuevo, "Semanal");
		int numReservasFinal = serviciosB.consultarReservas().size();
		int dif = (int) fechaInicio.until(fechaFin, ChronoUnit.WEEKS);
		assertTrue(numReservasInicial  == numReservasFinal - (dif +1) );
	}
	
	
	@Test
	public void nodeberiaRegistrarReservaSemestre() throws ExcepcionServiciosBiblioteca {
		
		LocalDate fechaInicio = LocalDate.now();
		LocalDate fechaFin = LocalDate.now().plusMonths(1);
		if (fechaInicio.getDayOfWeek() == DayOfWeek.SUNDAY || fechaFin.getDayOfWeek() == DayOfWeek.SUNDAY) {
			fechaInicio = fechaInicio.plusDays(1);
			fechaFin = fechaFin.plusDays(1);
		}
		Recurso recurso = serviciosB.consultarRecurso(15);
		List <RecursoReservado> reservasR = serviciosB.consultarReservaRecurso(recurso.getId());
		LocalTime horaInicio = reservasR.get(0).getHoraFinReserva().plusMinutes(15);
		LocalTime horaFin = horaInicio.plusMinutes(15);
		LocalDate actual = LocalDate.now();
		Usuario usuario = serviciosB.consultarUsuario(2148782);
		String estado = "Activa";
		String recurrente = "Si";
		RecursoReservado nuevo = new RecursoReservado(1, fechaInicio, fechaFin, horaInicio, horaFin, actual,recurso, usuario,estado,recurrente);
		try{
			serviciosB.registrarReserva(nuevo, "Mensual");
			fail("Debe fallar porque la fecha de la reserva no corresponde al semestre actual");
		}catch(ExcepcionServiciosBiblioteca e) {
			assertTrue(true);
		}
	}	
	
	@Test
	public void nodeberiaRegistrarReservaPorFecha() throws ExcepcionServiciosBiblioteca {
		
		LocalDate fechaInicio = LocalDate.of(2019, 11,30);
		LocalDate fechaFin = fechaInicio;
		Recurso recurso = serviciosB.consultarRecurso(15);
		List <RecursoReservado> reservasR = serviciosB.consultarReservaRecurso(recurso.getId());
		LocalTime horaInicio = reservasR.get(0).getHoraFinReserva().plusMinutes(15);
		LocalTime horaFin = horaInicio.plusMinutes(15);
		LocalDate actual = LocalDate.now();
		Usuario usuario = serviciosB.consultarUsuario(2148782);
		String estado = "Activa";
		String recurrente = "No";
		RecursoReservado nuevo = new RecursoReservado(1, fechaInicio, fechaFin, horaInicio, horaFin, actual,recurso, usuario,estado,recurrente);
		try {
			serviciosB.registrarReserva(nuevo,"No");
			fail("Debe fallar porque la fecha de la reserva es antes de la fecha actual");
		}catch (ExcepcionServiciosBiblioteca e) {
			assertTrue(true);
		}
		
	}		
	
	
}