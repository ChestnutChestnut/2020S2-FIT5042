package fit5042.assignm.mbeans;

import fit5042.assignm.repository.CustomerRepository;
import fit5042.assignm.repository.entities.Industry;

import fit5042.assignm.repository.entities.CustomerContact;
import fit5042.assignm.repository.entities.Customer;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
*
* @author Shuang Xu
*/
@ManagedBean(name = "customerManagedBean")
@SessionScoped

public class CustomerManagedBean implements Serializable {
	 @EJB
	 CustomerRepository customerRepository;
	 
	 /**
	     * Creates a new instance of CustomerManagedBean
	     */
	    public CustomerManagedBean() {
	    }

	    public List<Customer> getAllCustomers() {
	        try {
	            List<Customer> customers = customerRepository.getAllCustomers();
	            return customers;
	        } catch (Exception ex) {
	            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return null;
	    }

	    public void addCustomer(Customer customer) {
	        try {
	        	customerRepository.addCustomer(customer);
	        } catch (Exception ex) {
	            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    
	    /**
	     * Search a customer by Id
	     */
	    public Customer searchCustomerById(int id) {
	        try {
	            return customerRepository.searchCustomerId(id);
	        } catch (Exception ex) {
	            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
	        }

	        return null;
	    }
	    public void removeCustomer(int customerId) {
	        try {
	            customerRepository.removeCustomer(customerId);
	        } catch (Exception ex) {
	            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    public void editCustomer(Customer customer) {
	        try {
	        	String s = customer.getIndustry().getIndustryType();
	            Industry industry = customer.getIndustry();
	            industry.setIndustryType(s);
	            customer.setIndustry(industry);
	         
	            customerRepository.editCustomer(customer);

	            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer has been updated succesfully"));
	        } catch (Exception ex) {
	            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    
	    public void addCustomer(fit5042.assignm.controllers.Customer localCustomer) {
	        //convert this newProperty which is the local property to entity property
	        Customer customer = convertCustomerToEntity(localCustomer);

	        try {
	            customerRepository.addCustomer(customer);
	        } catch (Exception ex) {
	            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    
	    private Customer convertCustomerToEntity(fit5042.assignm.controllers.Customer localCustomer) {
	        Customer customer = new Customer(); //entity
	        
	        String industryType = localCustomer.getIndustryType();
	        String industryDesc = localCustomer.getIndustryDesc();
	        Industry industry = new Industry(industryType, industryDesc);
	        customer.setIndustry(industry);		
	        
	        customer.setCustomerId(localCustomer.getCustomerId());
	        customer.setAddress(localCustomer.getAddress());
	        customer.setCompanyName(localCustomer.getCompanyName());
	        customer.setOfficephone(localCustomer.getOfficephone());
	        customer.setRegisterDate(localCustomer.getRegisterDate());
	        customer.setaBN(localCustomer.getaBN());
	        customer.setEmail(localCustomer.getEmail());
	        customer.setCEO(localCustomer.getCEO());
	        
	        return customer;
	        
	        
	    }


}
