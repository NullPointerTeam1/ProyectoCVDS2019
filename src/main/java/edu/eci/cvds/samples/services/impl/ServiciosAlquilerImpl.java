package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

	private final Map<Long,Cliente> clientes;
	private final Map<Integer,Item> itemsDisponibles;
	private final Map<Integer,ItemRentado> itemsrentados;
	private final Map<Integer,TipoItem> tipositems;

	private final Map<Integer,Long> mapaPrestamosPorIdCliente;
	@Inject
	private ItemDAO itemDAO;
	@Inject
	private TipoItemDAO tipoItemDAO;
   @Inject
   private ClienteDAO clienteDAO;
   
   public ServiciosAlquilerImpl() {
       clientes = new HashMap<>();
       itemsDisponibles = new HashMap<>();
       itemsrentados = new HashMap<>();
       tipositems = new HashMap<>();
       mapaPrestamosPorIdCliente=new HashMap<>();
   }
 
   @Override
   public int valorMultaRetrasoxDia(int itemId) {
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
	   try {
           return clienteDAO.load(docu);
       } catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el item "+docu,ex);
       }
   }

   @Override
   public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
	   try {
           return clienteDAO.consultarItemsRentados(idcliente);
       } catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar los clientes ",ex);
       }
   }

   @Override
   public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
	    try {
	           return clienteDAO.consultarClientes();
	       } catch (PersistenceException ex) {
	           throw new ExcepcionServiciosAlquiler("Error al consultar los clientes ",ex);
	       }
   }
   @Override
   public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
       try {
           return itemDAO.load(id);
       } catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,ex);
       }
   }
   @Override
   public List<Item> consultarItemsDisponibles() {
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
	   try {
		   LocalDate fechafin = date.toLocalDate().plusDays(numdias);
		   clienteDAO.agregarItemRentado(docu, item, date, Date.valueOf(fechafin));
       } catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al registrar el item en el cliente "+docu,ex);
       }
   }

   @Override
   public void registrarCliente(Cliente c) throws ExcepcionServiciosAlquiler {
	   clienteDAO.save(c);
   }

   @Override
   public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet.");
   }
   @Override
   public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
	   try {
		   itemDAO.save(i);
	   } catch (PersistenceException ex) {
		   throw new ExcepcionServiciosAlquiler("Error al insertar el item "+i.getId());
	   }
   }
   @Override
   public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
   
   
}