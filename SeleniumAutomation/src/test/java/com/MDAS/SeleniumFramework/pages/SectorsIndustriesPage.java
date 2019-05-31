package com.MDAS.SeleniumFramework.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.MDAS.SeleniumFramework.utilities.Driver;
public class SectorsIndustriesPage {
	public SectorsIndustriesPage(){
		PageFactory.initElements(Driver.getDriver(),this);
	}
	@FindBy(id="Path")
    public WebElement homeIcon;
	
	@FindBy(className="canvas chartjs-render-monitor")
	public WebElement firstChart;
	
	@FindBy(className="canvas canvas--nasdaq chartjs-render-monitor")
	public WebElement secondChart;
	
//	 public void open() {
//	        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
//	    }
}
