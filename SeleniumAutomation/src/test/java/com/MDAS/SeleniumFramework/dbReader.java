package com.MDAS.SeleniumFramework;
import  java.sql.Connection;		
import  java.sql.Statement;		
import  java.sql.ResultSet;		
import  java.sql.DriverManager;		
import  java.sql.SQLException;		
public class  dbReader {				
    	public static void  main(String[] args) throws  ClassNotFoundException, SQLException {													
				//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
                String dbUrl = "jdbc:mysql://localhost:3306/practice";					

				//Database Username		
				String username = "root";	
                
				//Database Password		
				String password = "root";				

				//Query to Execute		
				String query = "select * from TASK_DESIGN LIMIT 10;";	
                
         	    //Load mysql jdbc driver		
           	    Class.forName("com.mysql.jdbc.Driver");			
           
           		//Create Connection to DB		
            	Connection con = DriverManager.getConnection(dbUrl,username,password);
          
          		//Create Statement Object		
        	   Statement stmt = con.createStatement();					
       
       			// Execute the SQL Query. Store results in ResultSet		
         		ResultSet rs= stmt.executeQuery(query);							
         
         		// While Loop to iterate through all data and print results		
				while (rs.next()){
			        		String AIS = rs.getString(1);								        
                            String step = rs.getString(2);
                            String component = rs.getString(3);
                            String objAction = rs.getString(4);
                            String objName = rs.getString(5);
                            String data1 = rs.getString(6);
                            String data2 = rs.getString(7);
                            System. out.println(AIS+"  "+step+" "+component+" "+objAction+" "+objName+" "+data1+" "+data2 );	
                            
                    }		
      			 // closing DB Connection		
      			con.close();			
		}
}
