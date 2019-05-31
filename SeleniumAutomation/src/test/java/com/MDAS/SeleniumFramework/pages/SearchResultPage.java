package com.MDAS.SeleniumFramework.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MDAS.SeleniumFramework.utilities.Driver;

public class SearchResultPage {
	public SearchResultPage(){
		PageFactory.initElements(Driver.getDriver(),this);
	}
//	@FindBy(css="div.ticker")
//	List<WebElement> tiles ; //= driver.findElements(By.cssSelector("div.ticker"));
	@FindBy(css="span[ng-bind-html*='case.seriaNum']")
	public List<WebElement> tiles ;
	
}
