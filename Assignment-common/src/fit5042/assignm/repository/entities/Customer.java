package fit5042.assignm.repository.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;



/**
 *
 * @author Shuang Xu
 */
@Entity
@Table(name = "CUSTOMER")
@NamedQueries({@NamedQuery(name = Customer.GET_ALL_QUERY_NAME, query = "SELECT c FROM Customer c order by c.customerId desc")})
public class Customer implements Serializable {
    
    public static final String GET_ALL_QUERY_NAME = "Customer.getAll";
    
    
	private int customerId;
	private String companyName;
    private int officephone;
    private String address;
    private String registerDate;
    private String aBN;
    private String email;
    private String CEO;
    private Industry industry;
    
    
    private Set<CustomerContact> customerContacts;

    public Customer() {
    }

    public Customer(int customerId, String companyName, int officephone, String address, String registerDate,
			String aBN, String email, String CEO,Industry industry) {
		this.customerId = customerId;
		this.companyName = companyName;
		this.officephone = officephone;
		this.address = address;
		this.registerDate = registerDate;
		this.aBN = aBN;
		this.email = email;
		this.CEO =CEO;
		this.industry = industry;
		this.customerContacts = new HashSet<>();
	}

    
  


	@Id
    @GeneratedValue
    @Column(name = "customer_id")
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "office_phone")
	public int getOfficephone() {
		return officephone;
	}

	public void setOfficephone(int officephone) {
		this.officephone = officephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	
	
	@Column(name = "ABN")
	public String getaBN() {
		return aBN;
	}

	public void setaBN(String aBN) {
		this.aBN = aBN;
	}

	@Column(name = "office_email")
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
 
	@Embedded
	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}	
	
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<CustomerContact> getCustomerContacts() {
		return customerContacts;
	}

	public void setCustomerContacts(Set<CustomerContact> customerContacts) {
		this.customerContacts = customerContacts;
	}
	
	

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", companyName=" + companyName + ", officephone=" + officephone
				+ ", address=" + address + ", regist_date=" + registerDate + ", aBN=" + aBN + ", email=" + email
				+ ", website=" + CEO + ", industry=" + industry + "]";
	}
	
	
    



}   