package com.MDAS.SeleniumFramework;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.MDAS.SeleniumFramework.TestUtil;

import java.util.ArrayList;
//import java.util.Iterator;

public class ReportUtil {
	
	public static int scriptNumber = 1;
	public static String indexResultFilename;
	protected static String currentDir;//public static String currentDir;
	public static int tcid;
	public static String currentSuiteName;
	
	public static double passNumber;
	public static double failNumber;
	public static boolean newTest= true;
	
	//per test
	
	public static ArrayList<String> testStatus = new ArrayList<String>();
	
	//per test step, e.g. row on work flow
	
	public static ArrayList<String> testStepDescArr = new ArrayList<String>();//=parent;obj;action;inputOrProperty;expValue
	public static ArrayList<String> testStepResultArr = new ArrayList<String>(); // Using Array List
	public static ArrayList<String> screenshotPathArr = new ArrayList<String>();
	
	//startTestRun in report, write HTML report to fileName provided
	
	public static void startTestReport(String fileName, String testStartTime, String env, String rls){
		
		indexResultFilename = fileName;
		currentDir = indexResultFilename.substring(0, indexResultFilename.lastIndexOf("\\"));
		
		FileWriter fstream = null;
		BufferedWriter out = null; 
		
		try {
			
			fstream = new FileWriter(fileName);
			out = new BufferedWriter(fstream);
			
			String RUN_DATE = TestUtil.now("dd.MMMMM.yyyy").toString();
			String ENVIRONMENT = env;
			String RELEASE = rls;
			
			out.newLine();
			out.write("<html>\n");
			out.write("<HEAD>\n");
			out.write(" <TITLE>TEST RUN RESULTS</TITLE>\n");
			out.write("</HEAD>\n");
			out.write("<body>\n");
			out.write("<h4 align=center><FONT COLOR=660066 FACE=Arial SIZ=6><b><u>TEST RUN RESULTS</u></b></h4>\n");
			out.write("<table border=1 cellspacing=1 cellpadding=1>\n");
			
			//run date
			
			out.write("<tr>\n");
			//out.write("<h4> <FONT COLOR=660000 FACE=Arial SIZ=4.5><b><u>Test Run Details: </u></h4>\n");
			out.write("<td width=150 align=left bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZ=2.5><b>Run Date</b></td>\n");
			out.write("<td width=150 align=left><FONT COLOR=#153E7E FACE=Arial SIZ=2.5><b>"+RUN_DATE+"</b></td>\n");
			out.write("</tr>\n");
			
			//run start time
			
			out.write("<tr>\n");
			out.write("<h4> <FONT COLOR=660000 FACE=Arial SIZ=4.5><b><u>Test Run Details: </u></h4>\n");
			out.write("<td width=150 align=left bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZ=2.5><b>Run Start Time</b></td>\n");
			out.write("<td width=150 align=left><FONT COLOR=#153E7E FACE=Arial SIZ=2.5><b>"+testStartTime+"</b></td>\n");
			out.write("</tr>\n");
			
			//run end time
			
			out.write("<tr>\n");
			out.write("<h4> <FONT COLOR=660000 FACE=Arial SIZ=4.5><b><u>Test Run Details: </u></h4>\n");
			out.write("<td width=150 align=left bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZ=2.5><b>Run End Time</b></td>\n");
			//out.write("<td width=150 align=left><FONT COLOR=#153E7E FACE=Arial SIZ=2.5><b>"+testEndTime+"</b></td>\n");
			out.write("</tr>\n");
			
			//env
			
			out.write("<tr>\n");
			out.write("<h4> <FONT COLOR=660000 FACE=Arial SIZ=4.5><b><u>Test Run Details: </u></h4>\n");
			out.write("<td width=150 align=left bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZ=2.5><b>Environment</b></td>\n");
			out.write("<td width=150 align=left><FONT COLOR=#153E7E FACE=Arial SIZ=2.5><b>"+ENVIRONMENT+"</b></td>\n");
			out.write("</tr>\n");
			
			//rls
			
			out.write("<tr>\n");
			out.write("<h4> <FONT COLOR=660000 FACE=Arial SIZ=4.5><b><u>Test Run Details: </u></h4>\n");
			out.write("<td width=150 align=left bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZ=2.5><b>Release</b></td>\n");
			out.write("<td width=150 align=left><FONT COLOR=#153E7E FACE=Arial SIZ=2.5><b>"+RELEASE+"</b></td>\n");
			out.write("</tr>\n");
			
			out.write("</table>\n");
			out.close();			
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	// startSuite  in report
	
	public static void startSuite(String suiteName, String browser){
		
		currentSuiteName = suiteName.replaceAll(" ", "_");
		tcid=1;
		
		FileWriter fstream = null;
		BufferedWriter out = null;
		
		try {
			fstream = new FileWriter(indexResultFilename);
			out = new BufferedWriter(fstream);
			
			//suite report
			
			out.write("<h4> <FONT COLOR=660000 FACE=Arial SIZ=4.5><u>Suite "+suiteName+" Report: Browser: "+browser+"</u></h4>\n");
			out.write("<table border=1 cellspacing=1 cellpadding=1 width=100%>\n");
			out.write("</tr>\n");
			out.write("<td width=10% align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZ=2><b>Test Script #</b></td>\n");
			out.write("<td width=40% align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZ=2><b>Test Case Name</b></td>\n");
			out.write("<td width=10% align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZ=2><b>Status</b></td>\n");
			//out.write("<td width=10% align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZ=2><b>Browser</b></td>\n");
			out.write("<td width=20% align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZ=2><b>Run Start Time</b></td>\n");
			out.write("<td width=20% align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZ=2><b>Run End Time</b></td>\n");
			out.write("</tr>\n");
			out.close();
			
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			fstream = null;
			out = null;
		}
	}
	
	//endSuite in report
	
	public static void endSuite(int executedTestCount, int passedTestCount, int failedTestCount){//String suiteName){
		
		FileWriter fstream = null;
		BufferedWriter out = null;
		
		int passRate = 0;//passedTestCount * 100 / executedTestCount;
		int failRate = 0;//failedTestCount * 100 / executedTestCount;
		if (executedTestCount != 0 ) {
			passRate = passedTestCount * 100 / executedTestCount;
			failRate = failedTestCount * 100 / executedTestCount;
		}
		try {
			fstream = new FileWriter(indexResultFilename, true);
			out = new BufferedWriter(fstream);
			//out.write("</table>\n");
			out.write("<body><p>Total number of tests executed: " + executedTestCount);
			out.write("<br>");
			out.write("Number of tests passed: <font color=#006600>" + passedTestCount + "</font>; pass rate: <font color=#006600>" + passRate + " %</font>");
			out.write("<br>");
			out.write("Number of tests failed: <font color=#FF0000>" + failedTestCount + "</font>; fail rate: <font color=#FF0000>" + failRate + " %</font>");
			out.write("<br></p></body>");
			out.close();	
		} catch (IOException e){
			e.printStackTrace();
		//} finally {
		} 
	}
	
	// Add test case in our case it's step
	
	public static void addTestCase(String testCaseName, String testCaseStartTime, String testCaseEndTime, String status){//, String browser, String testLogFilePath){//, String workflowFilePath, ArrayList<String> stepResultsS){//tring status){
		
		newTest = true;
		FileWriter fstream = null;
		BufferedWriter out = null;
		String testCaseStatus = "pass"; //defaults to pass, if any stepResult is "fail", changes to fail
		
		try {
			newTest = true;
			if(status.equalsIgnoreCase("Skipped") || status.equalsIgnoreCase("Skip")){//cannot happen?
			} else {
				//File f = new File(currentDir+"//"+currentSuiteName+"_TC"+tcid+"_"+testCaseName.replaceAll(" ","_")+".html"); //Test with our parameters
				File f = new File(currentDir+"_"+testCaseName.replaceAll(" ","_")+".html");
				f.createNewFile();
				//fstream = new FileWriter(currentDir+"//"+currentSuiteName+"_TC"+tcid+"_"+testCaseName.replaceAll(" ","_")+".html");
				fstream = new FileWriter(currentDir+"_"+testCaseName.replaceAll(" ","_")+".html");
				out = new BufferedWriter(fstream);				
				
				out.newLine();
				out.write("<html>\n");
				out.write("<HEAD>\n");
				out.write(" <TITLE>Test Results for: " + testCaseName + "</TITLE>\n");
				out.write("</HEAD>\n");
				out.write("<body>\n");
				out.write("<h4> <FONT COLOR=660000 FACE=Arial SIZ=4.5><b><u>Test Case Run Details: </u></h4>\n");
				out.write("<table border=1 cellspacing=1 cellpadding=1 width=100%>\n");
				out.write("<tr> ");
				out.write("<td width=10% align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZ=2><b>Step</b></td>");
				out.write("<td width=50% align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZ=2><b>Step Description</b></td>");
				out.write("<td width=25% align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZ=2><b>Step Result</b></td>");
				out.write("<td width=15% align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZ=2><b>Screenshot</b></td>");
				out.write("</tr>");
				
				if(testStepDescArr!=null){
					for(int i=0;i<testStepDescArr.size();i++){
						out.write("<tr> ");
						out.write("<td width=10% align=center><FONT COLOR=#153E7E FACE=Arial SIZ=1><b>"+(i+1)+"</b></td>\n");
						out.write("<td width=50% align=center><FONT COLOR=#153E7E FACE=Arial SIZ=1><b>"+testStepDescArr.get(i)+"</b></td>");
						if(testStepResultArr.get(i).toLowerCase().startsWith("pass"))
							out.write("<td width=25% align=center bgcolor=Green><FONT COLOR=#153E7E FACE=Arial SIZ=1><b>"+testStepResultArr.get(i)+"</b></td>\n");						
						else if(testStepResultArr.get(i).toLowerCase().startsWith("fail")) {
							out.write("<td width=25% align=center bgcolor=Red><FONT COLOR=#153E7E FACE=Arial SIZ=1><b>"+testStepResultArr.get(i)+"</b></td>\n");						
							testCaseStatus = "fail";
							//to do: screen shot only when result == fail
							if(screenshotPathArr.get(i)!=null)
								out.write("<td width=15% align=center><FONT COLOR=#153E7E FACE=Arial SIZ=1><b><a href="+screenshotPathArr.get(i)+" target=_blank>Screen Shot</a></b></td>");
							
							
						} else {
							out.write("<td width=25% align=center><FONT COLOR=#153E7E FACE=Arial SIZ=1><b>"+testStepResultArr.get(i)+"</b></td>\n");
						}
							out.write("<td width=15% align=center><FONT COLOR=#153E7E FACE=Arial SIZ=1><b>&nbsp</b></td>");
						out.write("</tr>");
					}
				}
				//out.write("</table>\n");
				out.close();	
				testStatus = new ArrayList<String>();
				testStepDescArr = new ArrayList<String>();//=parent;obj;action;inputOrProperty;expValue
				testStepResultArr = new ArrayList<String>();
				screenshotPathArr = new ArrayList<String>();
				newTest = false;	
			
				//continue to write result on suite log
				fstream = new FileWriter(indexResultFilename, true);
				out = new BufferedWriter(fstream);			
				out.write("</tr>\n");
				out.write("<td width=10% align=center><FONT COLOR=#153E7E FACE=Arial SIZ=1><b>"+scriptNumber+"</b></td>\n");
				if(status.equalsIgnoreCase("Skipped") || status.equalsIgnoreCase("Skip")){
					out.write("<td width=40% align=center><FONT COLOR=#153E7E FACE=Arial SIZ=2><b>"+testCaseName+"</b></td>\n");
				} else {
					out.write("<td width=40% align=center><FONT COLOR=#153E7E FACE=Arial SIZ=2><b><a href=./"+currentSuiteName+"_TC"+tcid+"_"+testCaseName.replaceAll(" ", "_")+".html>"+testCaseName+"</a></b></td>\n");//"+currentDir+"//"+currentSuiteName+"_TC"+tcid+"_"+testCaseName.replaceAll(" ", "_")+".html</b></td>\n");
				}
				tcid++;
				if(testCaseStatus.toLowerCase().startsWith("pass"))
					out.write("<td width=10% align=center bgcolor=Green><FONT COLOR=#153E7E FACE=Arial SIZ=2><b>"+testCaseStatus+"</b></td>\n");						
				else if(testCaseStatus.toLowerCase().startsWith("fail"))
					out.write("<td width=10% align=center bgcolor=Red><FONT COLOR=#153E7E FACE=Arial SIZ=2><b>"+testCaseStatus+"</b></td>\n");						
				else if(testCaseStatus.equalsIgnoreCase("Skipped") || status.equalsIgnoreCase("Skip"))
					out.write("<td width=10% align=center bgcolor=yellow><FONT COLOR=#153E7E FACE=Arial SIZ=2><b>"+testCaseStatus+"</b></td>\n");
				//out.write("<td width=20% align=center><FONT COLOR=#153E7E FACE=Arial SIZ=2><b>"+browser+"</b></td>\n");
				out.write("<td width=20% align=center><FONT COLOR=#153E7E FACE=Arial SIZ=2><b>"+testCaseStartTime+"</b></td>\n");
				out.write("<td width=20% align=center><FONT COLOR=#153E7E FACE=Arial SIZ=2><b>"+testCaseEndTime+"</b></td>\n");
				out.write("</tr>\n");
				scriptNumber++;
				out.close();
			}
		} catch (IOException e){
			e.printStackTrace();
			return;
		} //finally {}
			
	}
	
	//add value to ArrayList
	
	public static void addTestKey(String desc, String stepResult, String screenshotFilePath){//, String path){//String key
		
		testStepDescArr.add(desc);
		testStepResultArr.add(stepResult);
		screenshotPathArr.add(screenshotFilePath);
		
	}
	
	//update end time
	
	public static void updateEndTime(String endTime){
		
		StringBuffer buf = new StringBuffer();
		try{
			FileInputStream fstream = new FileInputStream(indexResultFilename);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			while((strLine=br.readLine()) != null){
				if(strLine.indexOf("END_TIME") != -1){
					strLine = strLine.replace("END_TIME", endTime);
				}
				buf.append(strLine);
			}
			//close input stream
			in.close();
			System.out.println(buf);
			FileOutputStream fos = new FileOutputStream(indexResultFilename);
			DataOutputStream output = new DataOutputStream(fos);
			output.writeBytes(buf.toString());
			fos.close();			
		} catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
	
		//zip log files
	
		public static void zipLogAndScreenshotFiles(File sourceDir, String zipFileNamePath){
			
			List<String> filesListInDir = new ArrayList<String>();
			String filePath = ""; 
			     try {
			    	 File[] files = sourceDir.listFiles();
			         for(File file : files){
			             if(file.isFile()) {
			            	 filePath = file.getAbsolutePath();
			            	 //System.out.println("filePath="+ filePath);
			            	 if ((filePath.indexOf(".html")!=-1) || (filePath.indexOf(".png")!=-1)){
			            	 	filesListInDir.add(file.getAbsolutePath());
			            	 }
			             }
			         } 
			           
			        FileOutputStream fos = new FileOutputStream(zipFileNamePath);
		            ZipOutputStream zos = new ZipOutputStream(fos);
		            
		            	for(String filePath1 : filesListInDir){
		            
		                System.out.println("Zipping "+filePath1);
		                //for ZipEntry we need to keep only relative file path, so we used substring on absolute path
		                ZipEntry ze = new ZipEntry(filePath1.substring(sourceDir.getAbsolutePath().length()+1, filePath1.length()));
		                zos.putNextEntry(ze);
		                //read the file and write to ZipOutputStream
		                FileInputStream fis = new FileInputStream(filePath1);
		                byte[] buffer = new byte[1024];
		                int len;
		                while ((len = fis.read(buffer)) > 0) {
		                    zos.write(buffer, 0, len);
		                }
		                zos.closeEntry();
		                fis.close();
		            	}
		            zos.close();
		            fos.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		}

}
