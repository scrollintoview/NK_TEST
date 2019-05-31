//package com.MDAS.SeleniumFramework;
//
//
//import java.io.IOException;
////import java.util.ArrayList;
//
//
//import org.openqa.selenium.WebDriver;
////import org.openqa.selenium.WebDriver;
////import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//
//import com.MDAS.SeleniumFramework.Xls_Reader;
//import com.MDAS.SeleniumFramework.actions;
//
//
//public class automationDriverTest { 
//	public WebDriver driver;
//	//public static ArrayList<String> testDescription = new ArrayList<String>();
//	//public static ArrayList<String> testStatus = new ArrayList<String>();
//	//public static ArrayList<String> Scrnshot = new ArrayList<String>();
//	//public static String screenshotFilePath = "C:\\Users\\MHAque3\\Desktop\\SeleniumFramework";
//	//public static String status = "PASS";
//@Test
//public void helloBuddy()
//{
//System.out.println("Preparing testcase");	
//
//}
//
//
// @Test
//	public static void runTest() throws IOException, InterruptedException {
//
//		
//		actions action = new actions();
//		String aisExecutionStep, step, component, objAction, objName, data1, data2, data3, data4;
//		Xls_Reader workFlowData = new Xls_Reader(System.getProperty("user.dir")+"\\TestData\\FrameworkDataSheet.xls");
//		aisExecutionStep = "ACTSIfilingSmokeTest"; // Need to extract from .txt 
//		
//		//ReportUtil.currentDir = System.getProperty("user.dir");	
//		//String testCaseName = "ACTSIfilingSmokeTest";
//		//String testCaseStartTime = TestUtil.now("dd.MMMMM.yyyy");
//		//String testCaseEndTime = TestUtil.now("dd.MMMMM.yyyy");
//		//String status = "PASS";
//
//		//String fileName = "output\\";
//		//String testStartTime = TestUtil.now("dd.MMMMM.yyyy");
//		//String rls = "2";
//		//ReportUtil.startTestReport(fileName, testStartTime, env, rls);
//		System.out.println("Executing: " + aisExecutionStep);
//		
//		for (int i =1;i< workFlowData.getSheetRowCountByName("WorkFlow");i++)
//		{
//			String AIS = workFlowData.getCellData("WorkFlow", "AIS", i).trim();
//			if (aisExecutionStep.equals(AIS)) {
//			step= workFlowData.getCellData("WorkFlow", "Step Discription", i).trim();
//			System.out.println(step);
//			component= workFlowData.getCellData("WorkFlow", "component", i).trim();
//			System.out.println(component);
//			objAction= workFlowData.getCellData("WorkFlow", "ObjAction", i).trim();
//			System.out.println(objAction);
//			objName= workFlowData.getCellData("WorkFlow", "objName", i).trim();
//			System.out.println(objName);
//			data1= workFlowData.getCellData("WorkFlow", "data1", i).trim();
//			System.out.println(data1);
//			data2= workFlowData.getCellData("WorkFlow", "data2", i).trim();
//			System.out.println(data2);
//			data3= workFlowData.getCellData("WorkFlow", "data3", i).trim(); 
//			System.out.println(data3);
//			data4= workFlowData.getCellData("WorkFlow", "data4", i).trim();
//			System.out.println(data4);	
//			action.actionParser(component, objAction, objName, data1, data2);
//			//testDescription.add(step);
//			//testStatus.add(status);
//			//Scrnshot.add(screenshotFilePath);
//			
//		}
//			
//		
//	
//			//ReportUtil.testStepDescArr = testDescription;
//			//ReportUtil.testStepResultArr = testStatus;
//			//ReportUtil.screenshotPathArr = Scrnshot;
//			//ReportUtil.addTestCase(testCaseName, testCaseStartTime, testCaseEndTime, status);
//
//		}
//		
//
//	}
//
//}