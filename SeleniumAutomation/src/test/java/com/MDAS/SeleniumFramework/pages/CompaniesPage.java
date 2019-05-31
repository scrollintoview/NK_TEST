package com.MDAS.SeleniumFramework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.MDAS.SeleniumFramework.utilities.Driver;

public class CompaniesPage {
	List<WebElement> sectors;
	List<WebElement> weights;
	WebElement name;
	List<WebElement> details;
	List<WebElement> pies;
	
	public CompaniesPage(){
		PageFactory.initElements(Driver.getDriver(),this);
		sectors = tiles.get(0).findElements(By.cssSelector("div.MuiGrid-item.MuiGrid-grid-xs-10"));
		weights = tiles.get(0).findElements(By.cssSelector("div.MuiGrid-item.MuiGrid-grid-xs-2"));
		pies    = tiles.get(0).findElements(By.cssSelector("canvas.chartjs-render-monitor"));
		name    = tiles.get(0).findElement(By.cssSelector("h6.MuiTypography-root.MuiTypography-h6"));
	}
    @FindBy(how=How.CSS,using="div.MuiExpansionPanel-root")
    public List<WebElement> tiles;
    
    public List<WebElement> getPies(){
    	return pies;
    }
    
    public List<WebElement> getSectors(){
    	return sectors;
    }
    
    public List<WebElement> getWeights(){
    	return weights;
    }
    public WebElement getName(){
    	return name;
    }
}
