package com.hrm.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.hrm.utilities.ReadConfig;

public class BaseClass {
	//create ReadConfig class object to access all the methods 
		ReadConfig readconfig=new ReadConfig();
		//configuration files
		public String baseURL=readconfig.getApplicationURL(); //will fetch the url--> ReadConfig-->properties ,similaraly applies for all 
		public String username=readconfig.getUsername();
		public String password=readconfig.getPassword();
		public  WebDriver driver;
		public  Logger logger;
		
		@Parameters("browser")   // browser--> parameter name="browser"  from testng.xml
		@BeforeClass
		public void setUp(String br) {    //browser arguments
		    if(br.equals("chrome"))     //chrome--> parameter value="chrome" from testng.xml
		   {       
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
		   }else if(br.equals("firefox")) {
			   System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
				driver=new FirefoxDriver();
		   }
			//specify the logger properties
			logger = Logger.getLogger("hrm");
			PropertyConfigurator.configure("log4j.properties");
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.get(baseURL);   //baseURL from config file
		}
		@AfterClass
		public void tearDown() {
			driver.quit();
		}
		public void captureScreen(WebDriver driver, String tname) throws IOException {   //to cature the screenshot
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}
		//to generate the random string and number
		public String randomestring()
		{
			String generatedstring=RandomStringUtils.randomAlphabetic(8);
			return(generatedstring);
		}
		
		public static String randomeNum() {
			String generatedString2 = RandomStringUtils.randomNumeric(4);
			return (generatedString2);
		}
		
		
		
		
		
		
		
}
