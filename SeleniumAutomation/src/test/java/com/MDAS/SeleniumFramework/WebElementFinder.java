package com.MDAS.SeleniumFramework;


import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class WebElementFinder  {
	 static enum enum_idType {
	     id,
	     name,
	     linktext,
	     cssselector,
	     xpath,classname
	     }
	 
	 WebDriver driver;
	 //private ObjectMap objMap;
	  
	 public WebElementFinder(WebDriver driverIn){
	    
	  this.driver = driverIn;
	  //this.objMap = objMapIn;
	  }
	  
	 public WebElement FindWebElementByID (String objectID)  {
		 System.out.println(objectID);
		 System.out.println("Inside Click Action");
	  
	  final String idTypeValueSerparator = "=";
	  WebElement tgtElement = null;
	  
	  if ((objectID.indexOf("!!!Invalid objectID: ") == 1) || (objectID.indexOf(idTypeValueSerparator) < 0)) {
		  System.out.println("Class WebElementFinder, Function FindWebElementByID: invalid objectID is passed in: " + objectID);
		  return null;
	  }
	  
	  try {

		  String[] objIDTypeValue = objectID.split(idTypeValueSerparator,2);
		  String idType = objIDTypeValue[0].toLowerCase().trim();
		  System.out.println(idType);
		  String idValue = objIDTypeValue[1].trim();
		  System.out.println(idValue);
		  System.out.println(enum_idType.valueOf(idType));
		  switch(enum_idType.valueOf(idType)) {
	
				    case id:
				    	tgtElement = (new WebDriverWait(this.driver, 30))
					  				.until(ExpectedConditions.presenceOfElementLocated(By.linkText(idValue)));
				    	break;
				    case name:
				    	tgtElement = (new WebDriverWait(this.driver, 30))
	  				  				.until(ExpectedConditions.presenceOfElementLocated(By.name(idValue)));
				    	break;
				    case linktext:
				    	tgtElement = (new WebDriverWait(this.driver, 30))
	  				  				.until(ExpectedConditions.presenceOfElementLocated(By.linkText(idValue)));
				    	break;
				    case cssselector:
				    	tgtElement = (new WebDriverWait(this.driver, 30))
	  				  				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(idValue)));
				    	
				    	break;
				    case xpath:
				    	System.out.println("Inside xpath case!!!!!");
				    	tgtElement = (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(idValue)));
	  				  	//tgtElement = driver.findElement(By.xpath(idValue));
				    	System.out.println(tgtElement);
				    	break;	  
				    	
				    case classname:
				    	tgtElement = (new WebDriverWait(this.driver, 30))
			  				        .until(ExpectedConditions.presenceOfElementLocated(By.className(idValue)));
			  			
				    
			   		} //end switch(enum_idType.valueOf(idType)) 	   			
		   } catch (Exception e) {
		      e.printStackTrace();
		  }
	   
	  return tgtElement;

	 } //public WebElement FindWebElementByID (String objectID)


	} //public class WebElementFinder

