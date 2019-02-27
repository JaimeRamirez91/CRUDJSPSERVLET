/*
*Representación de la tabla Customer 
 */
package com.cds.model;

/**
 *11/02/2019
 * @author Jaime
 */
public class Customer {
       //Atributos
        private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
        //Constructor Vacio 
	public Customer() {
		// Do Nothing
	}
        //Constructor general 
	public Customer(int id, String firstName, String lastName, String email, String mobile) {
		this.id = id;
                this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
	}
        //Metodos de acceso  
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

  
}
