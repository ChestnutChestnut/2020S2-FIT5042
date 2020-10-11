package fit5042.assignm.repository.entities;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Shuang Xu
 */
@Embeddable
@Access(AccessType.PROPERTY)
public class Industry implements Serializable {
    
   

	private String industryType;
    private String industryDesc;
   

    public Industry() {
    }

    public Industry(String industryType, String industryDesc) {
		this.industryType = industryType;
		this.industryDesc = industryDesc;
	}
    
    @Column(name = "Industry_type")    
	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	@Column(name = "Industry_description")
	public String getIndustryDesc() {
		return industryDesc;
	}

	public void setIndustryDesc(String industryDesc) {
		this.industryDesc = industryDesc;
	}
	
	 @Override
	public String toString() {
		return "Industry [industryType=" + industryType + ", industryDesc=" + industryDesc + "]";
	}
	

}	