package edu.eci.cvds.sampleprj.dao;

import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;

public interface ItemDAO {

   public void save(Item it) throws PersistenceException;

   public Item load(int id) throws ExcepcionServiciosAlquiler;

}