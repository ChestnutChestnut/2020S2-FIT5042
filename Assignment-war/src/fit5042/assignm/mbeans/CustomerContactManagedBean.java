package fit5042.assignm.mbeans;

import fit5042.assignm.repository.entities.Customer;
import fit5042.assignm.repository.CustomerContactRepository;
import fit5042.assignm.repository.entities.Customer;
import fit5042.assignm.repository.entities.CustomerContact;
import fit5042.assignm.repository.entities.Industry;

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
* 
*/
@ManagedBean(name = "propertyManagedBean")
@SessionScoped

public class CustomerContactManagedBean implements Serializable {
	@EJB
	CustomerContactRepository customerContactRepository;

	/**
     * Creates a new instance of CustomerContactManagedBean
     */
	 public CustomerContactManagedBean() {
	    }

	public List<CustomerContact> getAllCustomerContacts() {
		try {
			List<CustomerContact> customerContacts = customerContactRepository.getAllCustomerContacts();
			return customerContacts;
		} catch (Exception ex) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public void addCustomerContact(CustomerContact customerContact) {
		try {
			customerContactRepository.addCustomerContact(customerContact);
		} catch (Exception ex) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Search a customerContact by Id
	 */
	public CustomerContact searchCustomerContactById(int id) {
		try {
			return customerContactRepository.searchCustomerContactId(id);
		} catch (Exception ex) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}

		return null;
	}

	public Set<CustomerContact> searchCustomerContactByCustomerId(Customer customer) {
		try {
			return customerContactRepository.searchCustomerContactByCustomer(customer);
		} catch (Exception ex) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}

		return null;
	}

	public List<Customer> getAllCustomers() throws Exception {
		try {
			return customerContactRepository.getAllCustomers();
		} catch (Exception ex) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}

		return null;
	}

	public void removeCustomerContact(int customerContactId) {
		try {
			customerContactRepository.removeCustomerContact(customerContactId);
		} catch (Exception ex) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void editCustomerContact(CustomerContact customerContact) {
		try {
			
			int id = customerContact.getCustomer().getCustomerId();
			Customer customer = customerContact.getCustomer();
			customer.setCustomerId(id);
			customerContact.setCustomer(customer);
			
			customerContactRepository.editCustomerContact(customerContact);

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("CustomerContact has been updated succesfully"));
		} catch (Exception ex) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void addCustomerContact(fit5042.assignm.controllers.CustomerContact localCustomerContact) {
        //convert this newProperty which is the local property to entity property
		CustomerContact customerContact = convertCustomerContactToEntity(localCustomerContact);

        try {
        	customerContactRepository.addCustomerContact(customerContact);
        } catch (Exception ex) {
            Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	private CustomerContact convertCustomerContactToEntity(fit5042.assignm.controllers.CustomerContact localCustomerContact) {
		CustomerContact customerContact = new CustomerContact(); //entity
        int customerId = localCustomerContact.getCustomerId();
        String address = localCustomerContact.getAddress();
        String companyName = localCustomerContact.getCompanyName();
        int officephone = localCustomerContact.getOfficephone();
        String registerDate = localCustomerContact.getRegisterDate();
        String aBN = localCustomerContact.getaBN();
        String email = localCustomerContact.getEmail();
        String CEO = localCustomerContact.getCEO();
        
        String industryType = localCustomerContact.getIndustryType();
        String industryDesc = localCustomerContact.getIndustryDesc();
        
        Industry industry = new Industry(industryType,industryDesc);
        Customer customer = new Customer(customerId, address , officephone,companyName,registerDate, aBN,email, CEO, industry);
        
                    
        customerContact.setCustomerContactId(localCustomerContact.getCustomerContactId());
        customerContact.setContactName(localCustomerContact.getContactName());
        customerContact.setContactPhone(localCustomerContact.getContactPhone());
        customerContact.setContactEmail(localCustomerContact.getContactEmail());
        customerContact.setPosition(localCustomerContact.getPosition());
        customerContact.setGender(localCustomerContact.getGender());
        
        if (customer.getCustomerId() == 0)
            customer = null;
        customerContact.setCustomer(customer);
        return customerContact;
        
        
    }
    

	

	

}
