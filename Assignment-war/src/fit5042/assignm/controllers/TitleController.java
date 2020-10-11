package fit5042.assignm.controllers;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
*
* @author Shuang Xu
*/
@Named(value = "titleController")
@RequestScoped
public class TitleController {
	 private String pageTitle;

	    public TitleController() {
	        // Set the page title 
	        pageTitle = "AUSPrintings Pty Ltd ";
	    }

	    public String getPageTitle() {
	        return pageTitle;
	    }

	    public void setPageTitle(String pageTitle) {
	        this.pageTitle = pageTitle;
	    }

}
