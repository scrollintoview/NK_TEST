package com.MDAS.SeleniumFramework;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class elementCompiler {
	

	public static WebElement xpathElement(WebDriver driver, String xpath) throws IOException, InterruptedException
	{
		System.out.println(xpath);
	
		WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		
		if(driver.findElements( By.xpath(xpath) ).size() != 0){
			System.out.println("Element Exists");
			WebElement element = driver.findElement(By.xpath(xpath));
			return element;
		}
		else {
			System.out.println("Element does NOT Exits");
			return null;
		}
		

	}

}

