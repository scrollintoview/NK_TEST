package gov.cbp.junit.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class SecurityPopUpPage extends PageObject{
	//Security Notification
		@FindBy(css = "img[alt='Close']")
		 public WebElementFacade closeBtn;
		 public WebElement popupBtns(String buttonName) {
				String path = String.format("//div[@class='modal-footer ng-scope']//button[contains(text(),'%s')]", buttonName);
				
				WebElement popupbtn = getDriver().findElement(By.xpath(path));
				return popupbtn;
			}
}
