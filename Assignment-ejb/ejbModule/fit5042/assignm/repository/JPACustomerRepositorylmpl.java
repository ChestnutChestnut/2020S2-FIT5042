package fit5042.assignm.repository;

import fit5042.assignm.repository.CustomerContactRepository;
import fit5042.assignm.repository.CustomerRepository;

import fit5042.assignm.repository.entities.Customer;
import fit5042.assignm.repository.entities.CustomerContact;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Shuang Xu
 */
@Stateless


public class JPACustomerRepositorylmpl implements CustomerRepository {
	@PersistenceContext(unitName = "Assignment-ejb")
    private EntityManager entityManager;
	
	@Override
    public void addCustomer(Customer customer) throws Exception {
    	List<Customer> customers =  entityManager.createNamedQuery(Customer.GET_ALL_QUERY_NAME).getResultList(); 
    	customer.setCustomerId(customers.get(0).getCustomerId() + 1);
        entityManager.persist(customer);
    }
     
    @Override
    public Customer searchCustomerId(int id) throws Exception {
    	Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }
    
    @Override
    public void removeCustomer(int customerId) throws Exception {
    	Customer customer = this.searchCustomerId(customerId);

        if (customer!= null) {
            entityManager.remove(customer);
        }
    }

    @Override
    public void editCustomer(Customer customer) throws Exception {   
         try {
            entityManager.merge(customer);
        } catch (Exception ex) {
            
        }
    }

    
    
    @Override
    public List<Customer> getAllCustomers() throws Exception {
        return entityManager.createNamedQuery(Customer.GET_ALL_QUERY_NAME).getResultList();
    }
	

}
