/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cds.db;

import static com.cds.db.Config.URL;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jaime
 */
public class MySQLlConnexion extends Config{
    //Atributo conexion
    private Connection cn;
       
    //Metodos de acceso
    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    //Abrir conexion con MYSQL
    public void conectar() throws ClassNotFoundException, SQLException{
        try {
            Class.forName(DRIVER);
            cn =  (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }
    //Cerrar conexion con MYSQL
    public void cerrarCn() throws SQLException{
        try {
                if(cn != null){
                   if(cn.isClosed() == false){
                       cn.close();
                   }
                }
        } catch (SQLException e) {
            throw e;
        }
    }
}
