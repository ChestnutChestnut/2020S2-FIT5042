package fit5042.assignm.controllers;

import fit5042.assignm.repository.entities.CustomerContact;
import fit5042.assignm.repository.entities.Industry;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.sql.Date;

/**
 *
 * @author Shuang Xu
 */
@RequestScoped
@Named(value = "customer")
public class Customer implements Serializable  {
	private int customerId;
	private String address;
	private String companyName;
    private int officephone;
    private String registerDate;
    private String aBN;
    private String email;
    private String CEO;
    
    private Set<CustomerContact> customerContacts;
    
    private Industry industry;
    
    private String industryType;
    private String industryDesc;
    
   

    private Set<fit5042.assignm.repository.entities.Customer> customers;

    public Customer() {
        
    }

    //non-defaut constructor
    public Customer(int customerId, String address, String companyName, int officephone, String registerDate, String aBN,
			String email, String CEO, Industry industry,Set<CustomerContact> customerContacts) {
		this.customerId = customerId;
		this.address = address;		
		this.companyName = companyName;
		this.officephone = officephone;
		this.registerDate = registerDate;
		this.aBN = aBN;
		this.email = email;
		this.CEO = CEO;
		this.industry = industry;
		this.customerContacts = customerContacts;
	
	}
    

	

	public int getCustomerId() {
		return customerId;
	}
	
	

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName= companyName;
	}

	public int getOfficephone() {
		return officephone;
	}

	public void setOfficephone(int officephone) {
		this.officephone = officephone;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getaBN() {
		return aBN;
	}

	public void setaBN(String aBN) {
		this.aBN = aBN;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCEO() {
		return CEO;
	}

	public void setCEO(String CEO) {
		this.CEO = CEO;
	}

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public String getIndustryDesc() {
		return industryDesc;
	}

	public void setIndustryDesc(String industryDesc) {
		this.industryDesc = industryDesc;
	}

	public Set<fit5042.assignm.repository.entities.Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<fit5042.assignm.repository.entities.Customer> customers) {
		this.customers = customers;
	}

	public Set<CustomerContact> getCustomerContacts() {
		return customerContacts;
	}

	public void setCustomerContacts(Set<CustomerContact> customerContacts) {
		this.customerContacts = customerContacts;
	}

	

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", address=" + address + ", companyName=" + companyName
				+ ", officephone=" + officephone + ", registerDate=" + registerDate + ", aBN=" + aBN + ", email="
				+ email + ", CEO=" + CEO + ", customerContacts=" + customerContacts + ", industry=" + industry + "]";
	}

   

}
