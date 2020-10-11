package fit5042.assignm.repository;

import fit5042.assignm.repository.entities.CustomerContact;
import fit5042.assignm.repository.entities.Customer;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;

/**
 * @autor Shuang Xu
 */
@Remote
public interface CustomerRepository {
	
	/**
     * Add the customer being passed as parameter into the repository
     *
     * @param customer - the customer to add
     */
    public void addCustomer(Customer customer) throws Exception;

    /**
     * Search for a customer by its customer ID
     *
     * @param id - the customerId of the customer to search for
     * @return the customer found
     */
    public Customer searchCustomerId(int id) throws Exception;
    
    /**
     * Remove the customer, whose customerID matches the one being passed as parameter, from the repository
     *
     * @param customerId - the ID of the customer to remove
     */
    public void removeCustomer(int customerId) throws Exception;
    
    /**
     * Update a customer in the repository
     *
     * @param customer - the updated information regarding a property
     */
    public void editCustomer(Customer customer) throws Exception;
    
	/**
	 * Return all the customers in the repository
	 *
	 * @return all the customers people in the repository
	 */
	public List<Customer> getAllCustomers() throws Exception;
    
    

}
