/*
 * 3. As a product owner, I need to be able to review classifications using an infinite scroll
 *	   HTML web page. The web page shall include data visualization, analysis and insight
 */
package com.MDAS.SeleniumFramework.tests;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MDAS.SeleniumFramework.pages.SectorsPage;
import com.MDAS.SeleniumFramework.utilities.ConfigurationReader;
import com.MDAS.SeleniumFramework.utilities.Driver;
import com.MDAS.SeleniumFramework.utilities.Pages;
import com.MDAS.SeleniumFramework.utilities.TestBase;

public class ValidateSectorFeatures extends TestBase {
	
//@Test(priority =1, groups ={"REGRESSION"}, description="Validate a product owner is able able to review classifications using an infinite scroll HTML web page. The web page shall include data visualization, analysis and insight")
//public void validateClassificationsAndVisualizations(){
////	BasePage basePage= new BasePage();
////	basePage.open();
////	basePage.homeIcon.click();
//
////	int actualTilecount=pages.searchResult().tiles.size();
////	Assert.assertEquals(actualTilecount, 20);
////	System.out.println(actualTilecount);
//	
//	System.out.println("Clicking on Companies button");
//	pages.landingPage().companies_tab.click();
//	System.out.println("Clicking on Sectors button");
//	pages.landingPage().sectors_tab.click();
//	System.out.println("Clicking on How it Works button");
//	pages.landingPage().trainingData_tab.click();
//	
//  }
@Test(priority =1, groups ={"REGRESSION"}, description="Validate available tabs on the landing page")
public void validateMainTabs(){
	System.out.println("Clicking on Companies button");
	pages.landingPage().companies_tab.click();
	System.out.println("Clicking on Training Data button");
	pages.landingPage().trainingData_tab.click();
	System.out.println("Clicking on Sectors button");
	pages.landingPage().sectors_tab.click();
}

@Test(priority =2, groups ={"REGRESSION"}, description="Validate Vectors/Pies on the Section page")
public void validateVectors(){
	System.out.println("Vectors count: "+pages.landingPage().vectors.size());
	Assert.assertEquals(pages.landingPage().vectors.size(), 2,"There are 2 pies displayed");
	Assert.assertEquals(pages.landingPage().vectors.get(0).isDisplayed(), true,"Left vector is displayed");
	Assert.assertEquals(pages.landingPage().vectors.get(1).isDisplayed(), true,"Right vector is displayed");
}

@Test(priority =3, groups ={"REGRESSION"}, description="Validate Raven's Sector")
public void validateRavensSector(){
	System.out.println("Raven's Sector count: "+pages.landingPage().ravensSector.size());
	Assert.assertEquals(pages.landingPage().ravensSector.size(), 11);
}
@Test(priority =4, groups ={"REGRESSION"}, description="Validate Industries Count is no more than 100")
public void validateIndustriesCount(){
	SectorsPage industryPanel=new SectorsPage();
	System.out.println(industryPanel.industriesText.size());
	for(int i =0; i<industryPanel.industriesText.size(); i++){
		System.out.println(industryPanel.industriesText.get(i).getText());
	}
	Assert.assertEquals(industryPanel.industriesText.size()/2<=100, true);
}
}
