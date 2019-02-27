/*
 *Implementacion de los metodos Dao Custumer
 */
package com.cds.daoImp;
import  com.cds.dao.CustomerDao;
import com.cds.model.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.cds.db.MySQLlConnexion;

/**
 *
 * @author Jaime Ramírez
 */
public class CustomerDaoImpl extends MySQLlConnexion implements CustomerDao{
    
    private static  CustomerDaoImpl customerDaoImpl = null;

    @Override
    public long saveCustomer(Customer customer) throws Exception{
       
    String sql = "INSERT INTO customer_master(first_name, last_name, email, mobile)" 
					+ "VALUES(?,?,?,?)";
    long id = 0;
        try {
            //Abrir Conexion con MySQL
            this.conectar();
            //Preparar la Query
            PreparedStatement statment = this.getCn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //Setear los datos
            statment.setString(1, customer.getFirstName());
	    statment.setString(2, customer.getLastName());
            statment.setString(3, customer.getEmail());
	    statment.setString(4, customer.getMobile());
            //Ejecutar la insercion
            statment.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            //Excepciones
            throw e;
            
        }finally{
            //Cerrar la Conexion
            this.cerrarCn();
        }
	       
		return id;   
    }

    @Override
    public void updateCustomer(Customer customer) throws Exception{ 
        String sql = "UPDATE customer_master SET first_name = ?,last_name= ? , email= ?, mobile = ? WHERE Customer_id = ?" ;
        try {
            //Abrir Conexion con MySQL
            this.conectar();
            //Preparar la Query
            PreparedStatement statment = this.getCn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statment.setString(1, customer.getFirstName());
	    statment.setString(2, customer.getLastName());
            statment.setString(3, customer.getEmail());
	    statment.setString(4, customer.getMobile());
            statment.setInt(5, customer.getId());
            //Actualiza los valores
            statment.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }finally{
            this.cerrarCn();
        }
            
        
        
      }

    @Override
    public void deleteCustomer(int id) throws Exception{
        //DELETE FROM customer_master WHERE 0
          String sql = "DELETE FROM customer_master WHERE Customer_id = ?" ;
          try {
                //Abrir Conexion con MySQL
                this.conectar();
                //Preparar la Query
                PreparedStatement statment = this.getCn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statment.setLong(1, id);
                statment.executeUpdate();
          } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }finally{
            this.cerrarCn();
        }
    }

    @Override
    public Customer findCustomerById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   @Override
   public List<Customer> findAllCustomers() throws Exception{
		String sql = "SELECT * FROM customer_master";
		List<Customer> customers = null;
                ResultSet rs;
               
		try {
                        //Abrir Conexion con MySQL
                        this.conectar();
                        //Preparar la Query
                        PreparedStatement statment = this.getCn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                        rs = statment.executeQuery();//Devuelve un resulset
                        //Lista
                        customers = new ArrayList();
                        //recorremos el resultSet
                        while (rs.next()){
                              //instancia de Objeto Customers
                              Customer customer = new Customer();
                              customer.setId(rs.getInt(1));
			      customer.setFirstName(rs.getString(2));
			      customer.setLastName(rs.getString(3));
			      customer.setEmail(rs.getString(4));
			      customer.setMobile(rs.getString(5));
                              
                              //Agregamos los elementos 
                              customers.add(customer);
                        }
			
		} catch (SQLException e) {
			//System.out.println(ex.getMessage());
                        throw  e;
		}finally{
                        //Cerrar conexion
                        this.cerrarCn();
                } 
                
		return customers;
	}
   
    //Instancia Dao Imp Para acceder a los metodos
    public static CustomerDao getInstance() {
		if (customerDaoImpl == null)
			customerDaoImpl = new CustomerDaoImpl();
		return customerDaoImpl;
    }
}
