package com.MDAS.SeleniumFramework;



public class doResearch {
	


	public static void main(String[] args) {
	ReportUtil.currentDir = "C:\\Users\\MHAque3\\Desktop\\SeleniumFramework\\";	
	String testCaseName = "Open Chrome Browser";
	String testCaseStartTime = TestUtil.now("dd.MMMMM.yyyy");
	String testCaseEndTime = TestUtil.now("dd.MMMMM.yyyy");
	String status = "PASS";

	String fileName = "output\\";
	String testStartTime = TestUtil.now("dd.MMMMM.yyyy");
	String env = "FQT"	;
	String rls = "2";
		
	String desc = "Opening browser";
	String stepResult = "Fail";
	String screenshotFilePath = "C:\\Users\\MHAque3\\Desktop\\SeleniumFramework";
	String desc1 = "Opening browser";
	String stepResult1 = "Pass";
		ReportUtil.currentDir = "C:\\Users\\MHAque3\\Desktop\\SeleniumFramework\\";
		ReportUtil.startTestReport(fileName, testStartTime, env, rls);
		ReportUtil.addTestKey(desc, stepResult, screenshotFilePath);
		ReportUtil.addTestKey(desc1, stepResult1, screenshotFilePath);
		ReportUtil.addTestCase(testCaseName, testCaseStartTime, testCaseEndTime, status);
		
		

		
		}




}

