/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cvds.samples.services.client;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;
import edu.eci.cvds.samples.services.impl.ServiciosAlquilerImpl;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }
    
    
    

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     */
    public static void main(String args[]) throws SQLException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();

        SqlSession sqlss = sessionfact.openSession();

        
        
        /**
         * //Crear el mapper y usarlo: 
        ClienteMapper cm=sqlss.getMapper(ClienteMapper.class);  
        //CONSULTAR TODOS LOS CLIENTES
        System.out.println(cm.consultarClientes());
        //CONSULTAR UNO DE LOS CLIENTES
        System.out.println(cm.consultarCliente(4));
        // NOTA IMPORTANTE: EL METODO DE LA CLASE DATE SUMA 1900 AL AÑO, 1 AL MES Y EL DIA QUEDA IGUAL
        // POR LO TANTO LAS FECHAS DE LOS EJEMPLOS SON : 2019-09-03 Y 2019-09-04
        cm.agregarItemRentadoACliente(4, 1, new Date(119,8,03), new Date(119,8,04));
        //cm...
        ItemMapper cmItem= sqlss.getMapper(ItemMapper.class);
        Item item = new Item (new TipoItem(3,"Pelicula"),69692853,"peliculasss","JOHAN ITEEEM 22222",
        				new Date(119,8,03),2000,"formatoComun","terror");
        //AGREGAR UN ITEM
        cmItem.insertarItem(item);
        //IMPRIMIR TODOS LOS ITEMS
        System.out.println(cmItem.consultarItems());
        //IMPRIMIR UN SOLO ITEM
        System.out.println(cmItem.consultarItem(4)); 
        TipoItemMapper cmti= sqlss.getMapper(TipoItemMapper.class);  
        System.out.println(cmti.getTipoItem(1));
        TipoItem tipo = new TipoItem (69,"peli");
        cmti.insertarTipoItem(tipo);*/
        
        
        sqlss.commit();
        
        
        sqlss.close();
        
        ServiciosAlquilerFactory factory = ServiciosAlquilerFactory.getInstance();
        ServiciosAlquiler implementacion = factory.getServiciosAlquiler();
        try {
			System.out.println(implementacion.consultarItem(1).toString());
		} catch (ExcepcionServiciosAlquiler e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
        
    }


}
