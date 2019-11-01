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
package edu.eci.cvds.sampleprj.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.*;

/**
 *
 * @author hcadavid
 */
public class JDBCExample {
    
    public static void main(String args[]){
        try {
            String url="jdbc:mysql://desarrollo.is.escuelaing.edu.co:3306/bdprueba";
            String driver="com.mysql.jdbc.Driver";
            String user="bdprueba";
            String pwd="prueba2019";
                        
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,user,pwd);
            con.setAutoCommit(false);
                 
            
            System.out.println("Valor total pedido 1:"+valorTotalPedido(con, 1));
            
            List<String> prodsPedido=nombresProductosPedido(con, 1);
            
            
            System.out.println("Productos del pedido 1:");
            System.out.println("-----------------------");
            for (String nomprod:prodsPedido){
                System.out.println(nomprod);
            }
            System.out.println("-----------------------");
            
            
            int suCodigoECI=2145271;
            registrarNuevoProducto(con, suCodigoECI, "Arepa mixta del K1", 99999999);            
            con.commit();
                        
            
            con.close();
                                   
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBCExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
        	e.printStackTrace();
        }
        
        
    }
    
    /**
     * Agregar un nuevo producto con los parámetros dados
     * @param con la conexión JDBC
     * @param codigo
     * @param nombre
     * @param precio
     * @throws SQLException 
     */
    public static void registrarNuevoProducto(Connection con, int codigo, String nombre,int precio) throws SQLException{
        //Crear preparedStatement
        //Asignar parámetros
        //usar 'execute'
    	PreparedStatement insertProduct = null;
    	//Toca generalizar la sentencia con ?

        String insertStatment = "INSERT INTO ORD_PRODUCTOS VALUES (?,?,?)";
        
        insertProduct = con.prepareStatement(insertStatment);
        
        insertProduct.setInt(1, codigo);
        insertProduct.setString(2, nombre);
        insertProduct.setInt(3, precio);

        insertProduct.execute();
   

        
        con.commit();
        
    }
    
    /**
     * Consultar los nombres de los productos asociados a un pedido
     * @param con la conexión JDBC
     * @param codigoPedido el código del pedido
     * @return 
     * @throws SQLException 
     */
    public static List<String> nombresProductosPedido(Connection con, int codigoPedido) throws SQLException{
        List<String> np=new LinkedList<>();
       
        //Crear prepared statement
        //asignar parámetros
        //usar executeQuery
        //Sacar resultados del ResultSet
        //Llenar la lista y retornarla
        PreparedStatement listarProductos = null;
        String consultaProductos = "SELECT pedido_fk,nombre FROM ORD_PRODUCTOS,ORD_DETALLE_PEDIDO " + 
        		"WHERE codigo=producto_fk AND pedido_fk=?";
        listarProductos = con.prepareStatement(consultaProductos);
        listarProductos.setInt(1, codigoPedido);
        ResultSet resultado = listarProductos.executeQuery();
        while(resultado.next()) {
        	np.add(resultado.getString("nombre"));
        }
        con.commit();
        
        return np;
    }
    
    /**
     * Calcular el costo total de un pedido
     * @param con
     * @param codigoPedido código del pedido cuyo total se calculará
     * @return el costo total del pedido (suma de: cantidades*precios)
     * @throws SQLException 
     */
    public static int valorTotalPedido(Connection con, int codigoPedido) throws SQLException,NullPointerException{
        
        //Crear prepared statement
        //asignar parámetros
        //usar executeQuery
        //Sacar resultado del ResultSet
    	
    	PreparedStatement consultaTotal = null;
    	String stringConsultaTotal = "SELECT pedido_fk,SUM(precio*cantidad) AS total FROM ORD_PRODUCTOS,ORD_DETALLE_PEDIDO " + 
    			"WHERE producto_fk=codigo AND pedido_fk = ? " + 
    			"GROUP BY pedido_fk";
        
    	consultaTotal = con.prepareStatement(stringConsultaTotal);
    	consultaTotal.setInt(1, codigoPedido);
    	ResultSet resultado = consultaTotal.executeQuery();
    	String resultadoParcial = null;
    	while (resultado.next()) {
    		resultadoParcial = resultado.getString("total");
    	}
    	if (resultadoParcial == null) {
    		throw new NullPointerException("No se encontro la consulta, esta vacia");
    	}
    	con.commit();
        return Integer.parseInt(resultadoParcial);
    }   
}