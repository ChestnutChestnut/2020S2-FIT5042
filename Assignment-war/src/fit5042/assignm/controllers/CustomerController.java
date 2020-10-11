package fit5042.assignm.controllers;

import javax.el.ELContext;
import javax.inject.Named;

import fit5042.assignm.controllers.CustomerApplication;
import fit5042.assignm.repository.entities.Industry;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;


/**
*
* @author Shuang Xu
*/
@Named(value = "customerController")
@RequestScoped
public class CustomerController {
	private int customerIndex; //this customerIndex is the index
	
	

    public int getCustomerIndex() {
        return customerIndex;
    }

    public void setCustomerIndex(int customerIndex) {
        this.customerIndex = customerIndex;
    }
    private fit5042.assignm.repository.entities.Customer customer;

    public CustomerController() {
        // Assign customer identifier via GET param 
        //this customerIndex is the index, don't confuse with the customer Id
    	customerIndex = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("customerIndex"));
        // Assign customer based on the id provided 
        customer = getCustomer();
    }

    public fit5042.assignm.repository.entities.Customer getCustomer() {
        if (customer == null) {
            // Get application context bean CustomerApplication 
            ELContext context
                    = FacesContext.getCurrentInstance().getELContext();
            CustomerApplication app
                    = (CustomerApplication) FacesContext.getCurrentInstance()
                            .getApplication()
                            .getELResolver()
                            .getValue(context, null, "customerApplication");
            // -1 to customerId since we +1 in JSF (to always have positive customer index!) 
            return app.getCustomers().get(--customerIndex); //this customer index is the index, don't confuse with the Customer Id
        }
        return customer;
    }
    
    
   

}
