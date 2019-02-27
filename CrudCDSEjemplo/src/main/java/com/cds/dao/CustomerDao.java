/*
 * Representación de los metrodos de manipulacion de datos CRUD
 */
package com.cds.dao;
//Librerias
import com.cds.model.Customer;
import java.util.List;

/**
 *11/02/2019
 * @author Jaime
 */
public interface CustomerDao {
        //metodos
        long saveCustomer(Customer customer) throws Exception;

	void updateCustomer(Customer customer) throws Exception;

	void deleteCustomer(int id) throws Exception;

	Customer findCustomerById(Long id);

	List<Customer> findAllCustomers() throws Exception;
}
