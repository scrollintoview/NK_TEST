

package gov.cbp.junit.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class UploadFilePage extends PageObject{
	 @FindBy(css = "button#cancelButton")
	 public WebElementFacade deleteGroupBtn;
	 
	 @FindBy(css = "input#importApplications")
	 public WebElementFacade importApplications;
	 
	 @FindBy(css = "div.checkout-message-text")
	 public WebElementFacade checkoutMessageText;
	 
}
