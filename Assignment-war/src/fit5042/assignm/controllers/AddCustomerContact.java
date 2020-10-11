package fit5042.assignm.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assignm.mbeans.CustomerContactManagedBean;
import fit5042.assignm.mbeans.CustomerManagedBean;
import fit5042.assignm.repository.entities.CustomerContact;

import javax.faces.bean.ManagedProperty;


/**
*
* @author Shuang Xu
*/
@RequestScoped
@Named("addCustomerContact")
public class AddCustomerContact {
	@ManagedProperty(value="#{customerContactManagedBean}") 
	CustomerContactManagedBean customerContactManagedBean;
    
    private boolean showForm = true;

    private CustomerContact customerContact;
    
    ContactApplication app;
    
    public void setCustomerContact(CustomerContact customerContact){
        this.customerContact = customerContact;
    }
    
    public CustomerContact getCustomerContact(){
        return customerContact;
    }
    
    public boolean isShowForm() {
        return showForm;
    }

    public AddCustomerContact() 
    {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app  = (ContactApplication) FacesContext.getCurrentInstance()
                        .getApplication()
                        .getELResolver()
                        .getValue(context, null, "contactApplication");
        
        //instantiate customerContactManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "customerContactManagedBean");
    }

    public void addCustomerContact(CustomerContact localCustomerContact) {
        //this is the local property, not the entity
       try
       {
            //add this property to db via EJB
    	   customerContactManagedBean.addCustomerContact(localCustomerContact);

            //refresh the list in PropertyApplication bean
            app.searchAll();
            //updatePropertyListInPropertyApplicationBean();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer Contact has been added succesfully"));
            //refresh the property list in propertyApplication bean
       }
       catch (Exception ex)
       {
           
       }
        showForm = true;
    }

	
}
