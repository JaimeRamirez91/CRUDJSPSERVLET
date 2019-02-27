package com.cds.controller;

/**
 *
 * @author Jaime
 */

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cds.dao.CustomerDao;
import com.cds.daoImp.CustomerDaoImpl;
import com.cds.model.Customer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "Customer", urlPatterns = {"/Custumer"})
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private final  CustomerDao customerDao = CustomerDaoImpl.getInstance();
	
	public HomeController() {
		// Do Nothing
	}

        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                //captura de parametro action
                String action = request.getParameter("action");;
                
                //Validación peticiones get vacias 
                if(action==null){
                    action = "  ";
                    System.out.println(true); 
                }else{
                     System.out.println(false); 
                }
               
                switch(action){
                      case "index":
                            try{
                             //listar
                             request.setAttribute("customerList", listar());
                            }catch (Exception ex) {
                                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            //redirect
		            request.getRequestDispatcher("ListarCustomerView.jsp").forward(request, response);
                            break;
                      case "add":
                          
                            request.getRequestDispatcher("AgregarCustomerView.jsp").forward(request, response);;
                            break;
                     /* case "delete":
                          
                            request.getRequestDispatcher("DeleteCustomerView.jsp").forward(request, response);;
                            break;
                      case "update":
                          
                            request.getRequestDispatcher("UpdateCustomerView.jsp").forward(request, response);;
                            break;*/
                      default:
                            break;
                        }
   
	}
        
       
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                        int id = 0;
                        
                        if(request.getParameter("custId") != null){
                            id =  Integer.parseInt(request.getParameter("custId"));
                          
                        }
                        
                        String redirectUpdate = request.getParameter("redirectUpdate");
                        String option = request.getParameter("option");
                        String custFirstName = request.getParameter("firstName");
                        String custLastName = request.getParameter("lastName");
                        String custEmail = request.getParameter("email");
                        String custMobile = request.getParameter("mobile");
                      
                        //int id = Integer.parseInt(custId);
                        //Lista
                        List<Customer> listaCustomer = new ArrayList<Customer>();
                        //Objeto
                        Customer customer = new Customer();
                        //Set  datos
                        customer.setId(id);

                        customer.setFirstName(custFirstName);
                        customer.setLastName(custLastName);
                        customer.setMobile(custMobile);
                        customer.setEmail(custEmail);
                        
                        //add to list
                        listaCustomer.add(customer);
                       
                        switch(option){
                            //AdCustomer
                            case "add":                          
                                request.setAttribute("mensaje", "dato agregado");
                                try {
                                    
                                    this.guardarCustumers(id,custFirstName, custLastName,  custEmail, custMobile);
                                } catch (Exception ex) {
                                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                 request.getRequestDispatcher("AgregarCustomerView.jsp").forward(request, response);
                            break;
                            
                            //UpdateCostomer
                            case "update":
                                if("true".equals(redirectUpdate)){
            
                                    request.setAttribute("datos", listaCustomer);
                                    request.getRequestDispatcher("UpdateCustomerView.jsp").forward(request, response);
                                }else{
                                   
                                    request.setAttribute("mensaje", "test");
                               try {
                                    
                                     this.updateCustumers(id , custFirstName, custLastName,  custEmail, custMobile);
                                    } catch (Exception ex) {
                                        System.out.println(ex+".............---");
                                       // Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    String contextPath= "";
                                    response.sendRedirect(response.encodeRedirectURL(contextPath + "/CrudCDSEjemplo/Custumer?action=index"));
                                }
                               
                            break;
                            //Delete Customer
                            case "delete":   
                                if("true".equals(redirectUpdate)){    
                                    request.setAttribute("datos", listaCustomer);
                                    request.getRequestDispatcher("DeleteCustomerView.jsp").forward(request, response);
                                }else{
 
                               try {
                                    
                                     this.deleteCustumers(id);
                                    } catch (Exception ex) {
                                        System.out.println(ex+".............---");
                                       // Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    String contextPath= "";
                                    response.sendRedirect(response.encodeRedirectURL(contextPath + "/CrudCDSEjemplo/Custumer?action=index"));
                               }
                               
                            break;
                            
                            default:
                            
                             break;
                        
                        }

	}
        //Listar
        private  List<Customer>  listar() throws Exception{
             List<Customer> customers = customerDao.findAllCustomers();
             return customers;
        }
        //SAVE CUSTUMER
         private String  guardarCustumers(int id, String firstName, String lastName, String email,String mobile) throws Exception{
             Customer customer = new Customer(id, firstName, lastName, email, mobile);
	     customerDao.saveCustomer(customer);
            // customerDao.saveCustomer(customer);
             System.out.println("OK custumer controller");
             return "ok";
        }
         
        //Update CUSTUMER
         private String  updateCustumers(int id, String firstName, String lastName, String email,String mobile) throws Exception{
             Customer customer = new Customer(id,firstName, lastName, email, mobile);
	     customerDao.updateCustomer(customer);
            // customerDao.saveCustomer(customer);
             System.out.println("OK custumer controller");
             return "ok";
        } 
         private String deleteCustumers(int id) throws Exception{
              customerDao.deleteCustomer(id);
             System.out.println(id);
            return "ok"; 
         }
}
