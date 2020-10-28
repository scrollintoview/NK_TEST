package gov.cbp.junit.applynewi94;

import java.time.Instant;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import gov.cbp.junit.steps.ApplyNewI94Steps;

import java.time.Duration;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class ApplyNewTest {
	@Managed
	WebDriver driver;

	@Steps
	ApplyNewI94Steps applyNewtestSteps;

	@Test
	    public void applyNew() throws InterruptedException {
	    applyNewtestSteps.opens_home_page();
        ArrayList<String> tdd = new ArrayList<String>();
    	tdd.add("Y");
    	tdd.add("Y");
    	 	for(int i=0; i< tdd.size(); i++) {
    			if(tdd.get(i)=="Y") {
    				Instant start = Instant.now();
    				System.out.println("**** Start Time: "+ start);
                    System.out.println("**** Executing TC: "+ tdd.get(i));
    				 
                            applyNewtestSteps.selectTab("Apply for New I-94");
		                    applyNewtestSteps.selectMenuItem( "Group Upload");
		                    applyNewtestSteps.selectOptionInSecurityNotification("Consent & Continue") ;
		                    applyNewtestSteps.fillGroupContactInfo("testData") ;
		                    applyNewtestSteps.should_see_emailError(null) ;
		                    applyNewtestSteps.checkError("errorMessage");
		                   
		                    applyNewtestSteps.contactConfirmationPanel("YES, CREATE GROUP");
		                    applyNewtestSteps.chooseApplicationFile("fileNameTestData", "checkoutText");
		                    applyNewtestSteps.deleteGroup();
                    
    					Instant end = Instant.now();
    					System.out.println("**** End Time: "+end);
    					Duration timeElapsed = Duration.between(start, end);
    					System.out.println("**** Time taken: "+ timeElapsed.toMillis()/60 +" seconds"); 
    					System.out.println();
    			}
    	 	}
		 }
	  }
