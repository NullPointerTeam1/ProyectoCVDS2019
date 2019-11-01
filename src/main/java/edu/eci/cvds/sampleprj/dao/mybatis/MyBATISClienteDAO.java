package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.Singleton;

import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;

import java.sql.SQLException;
import java.sql.Date;

import org.apache.ibatis.exceptions.PersistenceException;

public class MyBATISClienteDAO implements ClienteDAO{

	@Inject
	private ClienteMapper ClienteMapper;    

	@Override
	public void save(Cliente cli) throws PersistenceException{
		
		try{

			ClienteMapper.agregarCliente(cli);

		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al registrar un cliente "+cli.toString(),e);
		}        

	}

	@Override
	public Cliente load(long id) throws ExcepcionServiciosAlquiler {
		Cliente cliente = null;
		try{
			cliente = ClienteMapper.consultarCliente(id);
			if (cliente == null) {
				throw new ExcepcionServiciosAlquiler("Error al consultar");
			}
		} catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,e);
		}
		return cliente;

	}

	@Override
	public void agregarItemRentado(long docu, Item item, Date fechaini,Date fechafin) {
		try{
			ClienteMapper.agregarItemRentadoACliente(docu, item.getId(), fechaini,fechafin); 
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al registrar el item al cliente "+docu,e);
		} 
	}
	
	@Override
	public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		try{
			clientes = ClienteMapper.consultarClientes();
	
		} catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new ExcepcionServiciosAlquiler("Error al consultar los clientes ",e);
		}
		return clientes;

	}
	
	@Override
	public List<ItemRentado> consultarItemsRentados(long id) throws ExcepcionServiciosAlquiler{
		Cliente cliente = load(id);
		return cliente.getRentados();
		
	}
}