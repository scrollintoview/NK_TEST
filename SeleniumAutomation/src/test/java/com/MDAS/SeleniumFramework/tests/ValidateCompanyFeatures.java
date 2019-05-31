package com.MDAS.SeleniumFramework.tests;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.MDAS.SeleniumFramework.utilities.ConfigurationReader;
import com.MDAS.SeleniumFramework.utilities.Driver;
import com.MDAS.SeleniumFramework.utilities.Pages;
import com.MDAS.SeleniumFramework.utilities.TestBase;

public class ValidateCompanyFeatures extends TestBase {
  //Pages companyPg = new Pages();
@Test(priority =1, groups ={"REGRESSION"}, description="Validate Company profiles are available on company page")
 public void ValidateCompanyCount(){
	pages.landingPage().companies_tab.click();
	System.out.println("Total number of companies on company page are : "+pages.companies().tiles.size());
	Assert.assertEquals(pages.companies().tiles.size()>0,true,"Company tiles are available on company page");
 }
@Test(priority =2, groups ={"REGRESSION"}, description="Validate Company Name are available on company page")
public void ValidateCompanyName(){
	pages.landingPage().companies_tab.click();
	System.out.println("Company Name: "+pages.companies().getName().getText());
	Assert.assertEquals(pages.companies().getName().isDisplayed(),true,"Each Company tiles has a company Name");
}
@Test(priority =3, groups ={"REGRESSION"}, description="Validate Company tiles has two pies so user can make a comparision")
public void ValidateMultiplePies(){
	pages.landingPage().companies_tab.click();
	System.out.println("Total pies count on tiles: "+pages.companies().getPies().size());
	Assert.assertEquals(pages.companies().getPies().size()==2,true,"Company tiles has two pies so user can make a comparision");
}
@Test(priority =4, groups ={"REGRESSION"}, description="Validate Company tile has 10 sectors")
public void ValidateMultipleSectors(){
	pages.landingPage().companies_tab.click();
	System.out.println("Sector count: "+pages.companies().getSectors().size());
	Assert.assertEquals(pages.companies().getSectors().size()==10,true,"Company tiles has 10 sectors");
}
@Test(priority =5, groups ={"REGRESSION"}, description="Company tiles has weightage for all sectors")
public void ValidateWeightOfSectors(){
	pages.landingPage().companies_tab.click();
	System.out.println("Total Weightage count : "+pages.companies().getWeights().size());
	List<WebElement> weightage = pages.companies().getWeights();
		for(int i=0; i<weightage.size();i++ ){
					System.out.println("Weightage : "+pages.companies().getWeights().get(i).getText());
	   	}
	Assert.assertEquals(pages.companies().getWeights().size()==10,true,"Company tiles has weightage for all sectors");
}


}
