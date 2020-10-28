package gov.cbp.junit.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.etsy.com")
public class HomePage extends PageObject{
 public WebElement getTab(String tabName) {
		String path = String.format("//span[contains(text(),'%s')]", tabName);
		System.out.println(path);
		WebElement tabItem = getDriver().findElement(By.xpath(path));
		System.out.println(tabItem.getText());
		return tabItem;
	}

 public WebElement getMenuItem(String menuName) {
		String path = String.format("//span[contains(text(),'%s')]", menuName);
		WebElement menuItem = getDriver().findElement(By.xpath(path));
		return menuItem;
	}	
}
