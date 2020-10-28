package gov.cbp.junit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;


public class ErrorPage extends PageObject {
 @FindBy(xpath = "//div[@class='modal-content']//button[contains(text(),'OK')]")
 public WebDriverFacade okBtn;

 @FindBy(xpath = "//div[@class='modal-content']//img[@alt='Close']") 
 public WebDriverFacade closeBtn;

 public WebElement errorObj(String errorMessage) {
		String path = String.format("//div[@class='modal-content']//p[@class='ng-binding'][contains(text(),'%s')]", errorMessage);
		WebElement errorText_obj = getDriver().findElement(By.xpath(path));
		return errorText_obj;
	}
}
