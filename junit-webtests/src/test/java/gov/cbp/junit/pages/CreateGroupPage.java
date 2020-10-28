package gov.cbp.junit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CreateGroupPage extends PageObject {
	@FindBy(xpath = "//a[contains(text(),'Download Excel Template')]")
	public  WebElementFacade downloadExcelTemplate;
	@FindBy(css = "a.btn-cancel")
	public WebElementFacade cancelBtn;
	@FindBy(css = "input#nextButton")
	public WebElementFacade submitBtn;
// Group Contact Info  
	@FindBy(css = "input#groupContactFirstName")
	public WebElementFacade groupContactFirstName;
	@FindBy(css = "input#groupContactLastName")
	public WebElementFacade groupContactLastName;
	@FindBy(css = "input#groupContactOrganization")
	public WebElementFacade groupContactOrganization;
	@FindBy(css = "input#groupContactEmail")
	public WebElementFacade groupContactEmail;
	@FindBy(css = "input#groupConfirmContactEmail")
	public WebElementFacade groupConfirmContactEmail;
	@FindBy(xpath = "//p[contains(text(),'Confirm E-mail must match the E-mail address.')]")
	public WebElementFacade  emailMustMatchError;
}
