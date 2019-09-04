package com.hrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
Properties pro;
	
	public ReadConfig()   //constructor
	{
		File src = new File("C:\\Users\\User\\eclipse-workspace\\hrm\\Configuration\\config.properties");//path of config.properties

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()    //method to read url from config.properties
	{
		String url=pro.getProperty("baseURL"); //baseURL from config.properties
		return url;
	}
	
	public String getUsername()            //method to read username from config.properties
	{
	String username=pro.getProperty("username");    //username from config.properties
	return username;
	}
	
	public String getPassword()           //method to read password from config.properties
	{
	String password=pro.getProperty("password");    //password from config.properties
	return password;
	}
	
	public String getChromePath()           //method to read chromepath from config.properties
	{
	String chromepath=pro.getProperty("chromepath");  //chromepath from config.properties
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()                    //method to read firefoxpath from config.properties
	{
	String firefoxpath=pro.getProperty("firefoxpath");   //firefoxpath from config.properties
	return firefoxpath;
	}


}
