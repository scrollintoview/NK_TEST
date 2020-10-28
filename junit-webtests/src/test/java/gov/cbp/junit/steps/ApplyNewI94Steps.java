package gov.cbp.junit.steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import  gov.cbp.junit.pages.HomePage;
import  gov.cbp.junit.pages.ConfirmGroupContactInfoPage;
import  gov.cbp.junit.pages.CreateGroupPage;
import  gov.cbp.junit.pages.ErrorPage;
import  gov.cbp.junit.pages.SecurityPopUpPage;
import  gov.cbp.junit.pages.UploadFilePage;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.junit.Assert.assertTrue;


@SuppressWarnings("serial")
public class ApplyNewI94Steps  extends ScenarioSteps {
    HomePage homePage;
	ConfirmGroupContactInfoPage confirmGroupContactInfoPage;
	CreateGroupPage createGroupPage;
	ErrorPage errorPage;
	SecurityPopUpPage securityPopUpPage;
	UploadFilePage uploadFilePage;
	
	@Step
	    public void opens_home_page() {
	        homePage.open();
	    }
	@Step 
    public void selectTab(String tabName) {
        homePage.getTab(tabName).click();
    }
    @Step 
    public void selectMenuItem(String menuItem) {
        homePage.getMenuItem(menuItem).click();
    }
    
    @Step 
    public void selectOptionInSecurityNotification(String concentOrDecline) {
    	securityPopUpPage.closeBtn.waitUntilVisible();
    	System.out.println("**** Selecting: "+concentOrDecline);
    	securityPopUpPage.popupBtns(concentOrDecline).click();
    }
    
    @Step 
    public void fillGroupContactInfo(String testData) {
    	createGroupPage.downloadExcelTemplate.waitUntilPresent();
    	System.out.println(createGroupPage.downloadExcelTemplate.getText());
    	createGroupPage.groupContactFirstName.type("testData");
    	createGroupPage.groupContactLastName.type("testData");
    	createGroupPage.groupContactOrganization.type("testData");
    	createGroupPage.groupContactEmail.type("test@Data.com");
    	createGroupPage.groupConfirmContactEmail.type("test@Data.com");
    	createGroupPage.submitBtn.click();
    }  
    
    @Step
    public void should_see_emailError(String testDataEmail) {
    	if(testDataEmail==null) {
            assertThat(createGroupPage.emailMustMatchError.getText()).containsIgnoringCase(testDataEmail);
    	}
    }
    
    @Step
    public void checkError(String errorMessage){
    	//assertTrue("Error message on popup is not displayed", errorPage.errorObj(errorMessage).isDisplayed());
    	//((WebElementFacade) errorPage.okBtn).click();
        
    }
    
    @Step
    public void contactConfirmationPanel(String contactConfirmationBtnName){
    waitABit(3000);
    	confirmGroupContactInfoPage.createOrEditGroup(contactConfirmationBtnName).click();
    }
    
    @Step
    public void chooseApplicationFile(String fileNameTestData, String checkoutText){
    	//uploadFilePage.importApplications.click();
    	// assertThat(uploadFilePage.checkoutMessageText.getText().compareToIgnoreCase(checkoutText)).isGreaterThan(0);
    }
    
    @Step
    public void deleteGroup(){
    	uploadFilePage.deleteGroupBtn.click();
    }
    
    
}

   

