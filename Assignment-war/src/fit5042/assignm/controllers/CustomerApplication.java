package fit5042.assignm.controllers;

import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;

import fit5042.assignm.mbeans.CustomerContactManagedBean;
import fit5042.assignm.mbeans.CustomerManagedBean;
import javax.inject.Named;
import fit5042.assignm.repository.entities.Customer;
import fit5042.assignm.repository.entities.CustomerContact;

import javax.el.ELContext;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 * The class is a demonstration of how the application scope works. You can
 * change this scope.
 *
 * @author Shuang Xu
 */
@Named(value = "customerApplication")
@ApplicationScoped

public class CustomerApplication {
	 //dependency injection of managed bean here so that we can use its methods
    @ManagedProperty(value = "#{customerManagedBean}")    
    CustomerManagedBean customerManagedBean;
  

    private ArrayList<Customer> customers;
    
    
    
    private boolean showForm = true;
    
    public boolean isShowForm() {
        return showForm;
    }
    
 // Add some customer and customerContact data from db to app 
    public CustomerApplication() throws Exception {
        customers = new ArrayList<>();
     
        

        //instantiate customerManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "customerManagedBean");

        //get properties from db 
        updateCustomerList();
        
      
        
        
    }
    
 
    
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

   
    
    private void setCustomers(ArrayList<Customer> newCustomers) {
        this.customers = newCustomers;
    }
    
   
    
  //when loading, and after adding or deleting, the property list needs to be refreshed
    //this method is for that purpose
    public void updateCustomerList() {
        if (customers != null && customers.size() > 0)
        {
            
        }
        else
        {
        	customers.clear();

            for (fit5042.assignm.repository.entities.Customer customer : customerManagedBean.getAllCustomers())
            {
            	customers.add(customer);
            }

            setCustomers(customers);
        }
    }
    
    
    
    public void searchCustomerById(int customerId)
    {
    	customers.clear();
        
    	customers.add(customerManagedBean.searchCustomerById(customerId));
    }
    
   
    
    public void searchAll()
    {
        customers.clear();
        
        for (fit5042.assignm.repository.entities.Customer customer : customerManagedBean.getAllCustomers())
        {
        	customers.add(customer);
        }
        
        setCustomers(customers);
    }
    
   
    
   
    

}
