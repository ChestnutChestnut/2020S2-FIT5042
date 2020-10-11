package fit5042.assignm.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assignm.repository.entities.CustomerContact;

/**
*
* @author Shuang Xu
*/
@RequestScoped
@Named("searchCustomerContact")
public class SearchCustomerContact {
	private CustomerContact customerContact;

	ContactApplication app;

	private int searchByInt;
	

	public ContactApplication getApp() {
		return app;
	}

	public void setApp(ContactApplication app) {
		this.app = app;
	}


	public int getSearchByInt() {
		return searchByInt;
	}

	public void setSearchByInt(int searchByInt) {
		this.searchByInt = searchByInt;
	}
	

	public void setCustomerContact(CustomerContact customerContact) {
		this.customerContact = customerContact;
	}

	public CustomerContact getCustomerContact() {
		return customerContact;
	}

	public SearchCustomerContact() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (ContactApplication) FacesContext.getCurrentInstance()
                        .getApplication()
                        .getELResolver()
                        .getValue(context, null, "contactApplication");
        
        app.updateCustomerContactList();
    }

	/**
	 * Normally each page should have a backing bean but you can actually do it any
	 * how you want.
	 *
	 * @param customer Index
	 */
	public void searchCustomerContactById(int customerIndex) {
		try {
			// search this customer then refresh the list in PropertyApplication bean
			app.searchCustomerContactById(customerIndex);
		} catch (Exception ex) {

		}
	}

	

	public void searchAll() {
		try {
			// return all properties from db via EJB
			app.searchAll();
		} catch (Exception ex) {

		}
	}

}
