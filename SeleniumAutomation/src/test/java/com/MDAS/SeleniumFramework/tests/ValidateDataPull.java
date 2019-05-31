/*
	 * 1. As a product owner, I need to be able to review data and re-collect all the
	 *    information used for the research.
	 * 5. As a data scientist, I need to be able to have an infinity scroll infographic to view the
	      raw data.
*/
package com.MDAS.SeleniumFramework.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.MDAS.SeleniumFramework.utilities.BrowserUtility;
import com.MDAS.SeleniumFramework.utilities.TestBase;


public class ValidateDataPull extends TestBase{
	
	// WebDriver driver;
	
//	@BeforeTest(description= "Navigate to the application")
//	public void invokeApplication(){
//		driver= BrowserUtility.openApplication("http://localhost:4200/home");
//	}
//	
//	@AfterTest(description = "Closing the web browser")
//	public void tearDown(){
//		BrowserUtility.closeApplication(this.driver);
//	}
	
	@Test(priority =1, groups ={"REGRESSION"}, description="Validate a product owner is able to review data and re-collect all the information used for the research.")
	public void homePage() throws InterruptedException{
		//BrowserUtility bt = new BrowserUtility();
		//WebDriver b = bt.openApplication("http://localhost:4200/home");
		//HomePage homepage=new HomePage();
		
		//homepage.searchBox.sendKeys("Hello World");
	
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.cssSelector("p.app-header__greeting")).getText(), "Hello, Vanessa");
		
		driver.findElement(By.cssSelector("input.wrapper__input")).sendKeys("Hello World");
		driver.findElement(By.cssSelector("i.icon.wrapper__icon")).click();
		
		Thread.sleep(5000);
		List<WebElement> tiles = driver.findElements(By.cssSelector("div.ticker"));
		
		Assert.assertTrue(tiles.size()>0, "Table is not avaliable");
		
		System.out.println("Total number of results displayed are "+tiles.size());
		if(tiles.size()>1){
			System.out.println("Lets print the names");
			for(int i=0; i<tiles.size()-1;i++){
				  WebElement ownerName = tiles.get(i).findElement(By.cssSelector("h2[class*='ng-tns-c4']"));
				  WebElement ticker    = tiles.get(i).findElement(By.cssSelector("span.ticker__sign"));
				  WebElement moreBtn   = tiles.get(i).findElement(By.cssSelector("button.btn btn--toggle mt-auto"));
				  WebElement Sector;
				  WebElement Industry;
			      WebElement Exchange;
			      WebElement NasdaqStockExchangeGlobalSelectMark;
			      Assert.assertTrue(moreBtn.isDisplayed());
			      System.out.println("Text for the owner name: " +	ownerName.getText());
				  System.out.println("Text for the ticker sign: "+	ticker.getText());
				  System.out.println("Button is displayed: "     +	moreBtn.isDisplayed());
			}
		}
		
		
		
		
		
		
//		String url = "https://eog-tmng.uspto.gov";
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\WebDrivers\\chromedriver.exe");
//		WebDriver driverC = new ChromeDriver();
//		driverC.manage().window().maximize();
//		System.out.println("Navigating to "+ url);
//		driverC.get(url);
//		
////		
//		Thread.sleep(5000);
//		
//		WebElement tbox = driverC.findElement(By.cssSelector("input.searchBy"));
//		System.out.println(tbox.getTagName());
//		tbox.sendKeys("Hello World");
//		driverC.findElement(By.cssSelector("span.glyphicon.glyphicon-search")).click();
//		
	    
	    
	    
	}
}
