package com.MDAS.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TilesCount {
	public List<WebElement> getTiles(WebDriver driver){
		List<WebElement> tiles = driver.findElements(By.cssSelector("div.ticker"));
		Assert.assertTrue(tiles.size()>0, "Table is not avaliable");
		System.out.println("Total number of results displayed are "+tiles.size());
        return tiles;
	 }
	}
        //		if(tiles.size()>1){
//			System.out.println("Lets print the names");
//			for(int i=0; i<tiles.size()-1;i++){
//				  WebElement ownerName = tiles.get(i).findElement(By.cssSelector("h2[class*='ng-tns-c4']"));
//				  WebElement ticker    = tiles.get(i).findElement(By.cssSelector("span.ticker__sign"));
//				  WebElement moreBtn   = tiles.get(i).findElement(By.cssSelector("button.btn btn--toggle mt-auto"));
//				  WebElement Sector;
//				  WebElement Industry;
//			      WebElement Exchange;
//			      WebElement NasdaqStockExchangeGlobalSelectMark;
//			      Assert.assertTrue(moreBtn.isDisplayed());
//			      System.out.println("Text for the owner name: " +	ownerName.getText());
//				  System.out.println("Text for the ticker sign: "+	ticker.getText());
//				  System.out.println("Button is displayed: "     +	moreBtn.isDisplayed());
//		    }
//		  }

	
	

