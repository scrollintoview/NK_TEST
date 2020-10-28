package gov.cbp.junit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;


public class ConfirmGroupContactInfoPage extends PageObject {
	
	@FindBy(jquery = "button.btn:contains('YES, CREATE GROUP')")
	public WebDriverFacade yesBtn;
	
	public WebElement createOrEditGroup(String buttonLabel) {
		String path = String.format("//button[contains(text(),'%s')]", buttonLabel);
		WebElement confirmationBtn = getDriver().findElement(By.xpath(path));
		return confirmationBtn;
	}

	
}