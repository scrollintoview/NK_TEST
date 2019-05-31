package com.MDAS.SeleniumFramework;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class actions {
	private WebDriver driver;
	public WebElementFinder ElementFinder;
	
	
	public void actionParser(String component, String ObjAction, String objName, String data1, String data2) throws IOException, InterruptedException
	{ // Action method
		
			switch(component)
			{
				case "Browser":
					switch(ObjAction){
					
					case "Open":
						switch(objName)
						{
						case "Chrome":
						System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\WebDrivers\\chromedriver.exe");
						WebDriver driverC = new ChromeDriver();
						driverC.manage().window().maximize();
						System.out.println("Driver open!!");
						driver = driverC;
						break;
						case "ie":
						System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\WebDrivers\\IEDriverServer.exe");
						driver = new InternetExplorerDriver();
						driver.manage().window().maximize();
						break;
						}
					break;		
					
					case "Navigate":
						switch(objName)
						{
						case "Chrome":
						driver.get(data1);
						System.out.println("Navigation Successful");
						break;
						case "ie":
						driver.get(data1);
						break;
						}
					break;		
					
					case "Close":
						switch(objName)
						{
						case "Chrome":
						driver.quit();
						System.out.println("Driver CLosed!!");
						break;
						case "IE":
						Runtime.getRuntime().exec("taskkill /f /im IEDriverServer.exe");
						Runtime.getRuntime().exec("taskkill /f /im iexplore.exe");
						Runtime.getRuntime().exec("taskkill /f /im iexplore.exe*32");
						break;
						}
					break;		
					}
				break;
				case "WebObject":
				WebElement element = elementCompiler.xpathElement(driver, objName);
				
				if(element != null){
					System.out.println("element found");
				}
					switch(ObjAction){
					
					case "Click":
						
						System.out.println(element.isEnabled());
						System.out.println(element.isDisplayed());
						
					element.click();
					System.out.println("Object clicked");
					break;
					case "ClickItem":
					break;
					case "Close":
					break;
					case "CreateVarUsingRegexMatch":
					break;
					case "DoubleClick":
					Actions action = new Actions(driver);
					action.doubleClick(element);
					break;
					case "DoubleClickItem":
					break;
					case "Exists":
					if (element.isDisplayed()) {
						System.out.println("Element exists");
					} else {
						System.out.println("Element does not exist");
					}	
					break;
					case "MouseHover":
					break;
					case "negativeValidation":
					break;
					case "OverWrite":
					break;
					case "validationViaRegex":
					break;
					case "regexMatchCountValidation":
					break;
					case "RightClick":
					break;
					case "SelectListItem":
					break;
					case "SetText":
					element.sendKeys(data1);
					break;
					case "SetObjectAttribute":
					break;
					case "SetFileFromProj":
					break;
					case "ValidateObjProperty":
					break;					
					}
				break;
			}
	}

	}


