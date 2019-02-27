/*
 * Configuración de base de datos
 */
package com.cds.db;

//Librerias importadas
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *Ejemplo conexió a base de datos MYSQL
 * @author Jaime
 * 11/02/2019
 */
public class Database  extends Config{
        //conexion  	
	private static Connection connection = null;
	
        //solicitud y apertura de conexión 
	public static Connection getConnection(){
		if(connection==null){
			try{
				//Loading The Driver Class
				Class.forName(DRIVER);
				//Getting the connection Object
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}catch (ClassNotFoundException | SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		return connection;
	}
    //cerrar  conexion 
    public void CerrarConexion() throws SQLException{
           if(Database.connection != null){
               if(!Database.connection.isClosed()){
                   Database.connection.close();
                   System.out.println("Conexion Cerrada");
               }         
           }
    }
    
}
