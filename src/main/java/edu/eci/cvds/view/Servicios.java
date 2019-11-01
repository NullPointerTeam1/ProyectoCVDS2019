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
	private List<ItemRentado> items;
	private List<ItemRentado> itemsRetardados;
	private Cliente clienteIngresado;
	private long idClienteIngresado;
	@Inject
	private ServiciosAlquiler service;
	
	public List<Item> itemsAlquilados(){
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

	public List<ItemRentado> getItems() throws ExcepcionServiciosAlquiler {
		return items;
	}

	public void setItems(List<ItemRentado> list) {
		this.items = list;
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
		setItems(service.consultarItemsCliente(idClienteIngresado));
		setItemsRetardados(service.consultarItemsCliente(idClienteIngresado));
		this.idClienteIngresado = idClienteIngresado;
	}
	public void registrarCliente(String nombre, long documento, String telefono, String direccion, String correo) {
		Cliente nuevoCliente = new Cliente(nombre,documento,telefono,direccion,correo,false,new ArrayList<ItemRentado>());
		try {
			service.registrarCliente(nuevoCliente);
		} catch (ExcepcionServiciosAlquiler e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<ItemRentado> getItemsRetardados() {
		return itemsRetardados;
	}

	public void setItemsRetardados(List<ItemRentado> itemsRetardados) {
		List<ItemRentado> itemsSuperRetardados = new ArrayList<ItemRentado>();
		for (int i = 0; i<itemsRetardados.size();i++) {
			LocalDate fechaEntrega=itemsRetardados.get(i).getFechafinrenta().toLocalDate();
	        LocalDate fechaHoy= LocalDate.now();
	        long diasRetraso = ChronoUnit.DAYS.between(fechaHoy, fechaEntrega);
	        if (diasRetraso < 0) {
	        	itemsSuperRetardados.add(itemsRetardados.get(i));
	        }
		}
		this.itemsRetardados = itemsSuperRetardados;
	}
	
	public long hallarMultaItem(int id) {
		long multa = 0;
		for (int i = 0; i<itemsRetardados.size();i++) {
			LocalDate fechaEntrega=itemsRetardados.get(i).getFechafinrenta().toLocalDate();
	        LocalDate fechaHoy= LocalDate.now();
	        long diasRetraso = ChronoUnit.DAYS.between(fechaHoy, fechaEntrega);
	        if (id == itemsRetardados.get(i).getId()) {
	        	multa = diasRetraso*MULTA_DIARIA;
	        }
		}
		return Math.abs(multa);
	}
	
	public void registrarItemCliente(int id,int dias) {
		Item itemNuevo = null;
		ItemRentado itemRentado = null;
		try {
			itemNuevo = service.consultarItem(id);
			
			service.registrarAlquilerCliente(Date.valueOf(LocalDate.now()),idClienteIngresado, itemNuevo, dias);
			setIdClienteIngresado(idClienteIngresado);
			
		} catch (ExcepcionServiciosAlquiler e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
