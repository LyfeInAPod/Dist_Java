package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBContext {
    
    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
/*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
 public static Connection getConnection()throws Exception {
	 
         Class.forName("com.mysql.jdbc.Driver");
         
         Connection cnn =  DriverManager.getConnection(
        		 "jdbc:mysql://localhost:3306/psystem?autoReconnect=true&useSSL=true","root", "");
         
         if(cnn == null)
        	 System.out.print("not connected");
         
         return cnn;
//         String url = "jdbc:mysql://"+serverName+":"+portNumber+"/"+dbName+"?autoReconnect=true&useSSL=true";
//         
//         Connection cnn = null;
//         
//         cnn =  DriverManager.getConnection(
//            url,userID, password);
//         
//         if(cnn != null)
//        	 System.out.print("connected");
//         
//         return cnn;
         
	 
//    String url = "jdbc:sqlserver://"+serverName+":"+portNumber +";databaseName="+dbName;
//    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//    return DriverManager.getConnection(url, userID, password);
    
 }
    /*Insert your other code right after this comment*/
   
    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private static String serverName = "localhost";
    private static String dbName = "psystem";
    private static String portNumber = "3306";
    private static String userID = "root";
    private static String password = "";
}