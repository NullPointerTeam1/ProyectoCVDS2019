package edu.eci.cvds.view;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;

import org.primefaces.PrimeFaces;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;

@ManagedBean(name = "servicios")
@ApplicationScoped
public class Servicios extends BasePageBean {
	public static final long MULTA_DIARIA = 5000;
	private List<Cliente> clientes;
	private List<RecursoReservado> Recursos;
	private List<RecursoReservado> RecursosRetardados;
	private Cliente clienteIngresado;
	private long idClienteIngresado;
	@Inject
	private ServiciosAlquiler service;
	
	public List<Recurso> RecursosAlquilados(){
		return null;
	}
	
	public List<Cliente> getClientes() {
		List<Cliente> clientes = null;
		try {
			 clientes = service.consultarClientes();
		} catch (ExcepcionServiciosAlquiler e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<RecursoReservado> getRecursos() throws ExcepcionServiciosAlquiler {
		return Recursos;
	}

	public void setRecursos(List<RecursoReservado> list) {
		this.Recursos = list;
	}
	public Cliente getClienteIngresado() throws ExcepcionServiciosAlquiler {
		clienteIngresado = service.consultarCliente(idClienteIngresado);
		return clienteIngresado;
	}
	public void setClienteIngresado(Cliente clienteIngresado) {
		this.clienteIngresado = clienteIngresado;
	}
	public long getIdClienteIngresado() {
		return idClienteIngresado;
	}
	public void setIdClienteIngresado(long idClienteIngresado) throws ExcepcionServiciosAlquiler {
		setRecursos(service.consultarRecursosCliente(idClienteIngresado));
		setRecursosRetardados(service.consultarRecursosCliente(idClienteIngresado));
		this.idClienteIngresado = idClienteIngresado;
	}
	public void registrarCliente(String nombre, long documento, String telefono, String direccion, String correo) {
		Cliente nuevoCliente = new Cliente(nombre,documento,telefono,direccion,correo,false,new ArrayList<RecursoReservado>());
		try {
			service.registrarCliente(nuevoCliente);
		} catch (ExcepcionServiciosAlquiler e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<RecursoReservado> getRecursosRetardados() {
		return RecursosRetardados;
	}

	public void setRecursosRetardados(List<RecursoReservado> RecursosRetardados) {
		List<RecursoReservado> RecursosSuperRetardados = new ArrayList<RecursoReservado>();
		for (int i = 0; i<RecursosRetardados.size();i++) {
			LocalDate fechaEntrega=RecursosRetardados.get(i).getFechafinrenta().toLocalDate();
	        LocalDate fechaHoy= LocalDate.now();
	        long diasRetraso = ChronoUnit.DAYS.between(fechaHoy, fechaEntrega);
	        if (diasRetraso < 0) {
	        	RecursosSuperRetardados.add(RecursosRetardados.get(i));
	        }
		}
		this.RecursosRetardados = RecursosSuperRetardados;
	}
	
	public long hallarMultaRecurso(int id) {
		long multa = 0;
		for (int i = 0; i<RecursosRetardados.size();i++) {
			LocalDate fechaEntrega=RecursosRetardados.get(i).getFechafinrenta().toLocalDate();
	        LocalDate fechaHoy= LocalDate.now();
	        long diasRetraso = ChronoUnit.DAYS.between(fechaHoy, fechaEntrega);
	        if (id == RecursosRetardados.get(i).getId()) {
	        	multa = diasRetraso*MULTA_DIARIA;
	        }
		}
		return Math.abs(multa);
	}
	
	public void registrarRecursoCliente(int id,int dias) {
		Recurso RecursoNuevo = null;
		RecursoReservado RecursoReservado = null;
		try {
			RecursoNuevo = service.consultarRecurso(id);
			
			service.registrarAlquilerCliente(Date.valueOf(LocalDate.now()),idClienteIngresado, RecursoNuevo, dias);
			setIdClienteIngresado(idClienteIngresado);
			
		} catch (ExcepcionServiciosAlquiler e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
