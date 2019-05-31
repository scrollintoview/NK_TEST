package com.MDAS.SeleniumFramework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.MDAS.SeleniumFramework.utilities.Driver;
public class TrainingDataPage {
	WebElement companyTicker;
	WebElement pressReleaseDataText;
	WebElement financialHistoryDataText;
	WebElement secFilingHistoryDataText;
	
	public TrainingDataPage(){
		PageFactory.initElements(Driver.getDriver(),this);
		companyTicker = companyProfiles.get(0).findElement(By.cssSelector("div"));
		pressReleaseDataText = companyProfiles.get(0).findElement(By.xpath("//div[text()='Press Release Data']"));
		financialHistoryDataText = companyProfiles.get(0).findElement(By.xpath("//div[text()='Financial History Data']"));
		secFilingHistoryDataText = companyProfiles.get(0).findElement(By.xpath("//div[text()='SEC Filing History Data']"));
	};
		
    @FindBy(how=How.CSS,using="div.MuiGrid-item.MuiGrid-grid-xs-8")
    public List<WebElement> companyProfiles;

	public WebElement companyTicker(){
		return companyTicker;
	}
	public WebElement pressReleaseDataText(){
		return pressReleaseDataText;
	}
	public WebElement financialHistoryDataText(){
		return financialHistoryDataText;
	}
	public WebElement secFilingHistoryDataText(){
		return secFilingHistoryDataText;
	}
}
