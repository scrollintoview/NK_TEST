package com.MDAS.SeleniumFramework.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.MDAS.SeleniumFramework.utilities.TestBase;

public class ValidateTrainingDataFeatures extends TestBase {
	@Test(priority =1, groups ={"REGRESSION"}, description="Validate list of training data page components")
	 public void validateTrainingFeatures(){
		pages.landingPage().trainingData_tab.click();
		System.out.println("Total number of companies on training data page are : "+pages.trainingDataPage().companyProfiles.size());
		Assert.assertEquals(pages.trainingDataPage().companyProfiles.size()>0,true,"Training data page has Company tiles are available");
	 }
}
