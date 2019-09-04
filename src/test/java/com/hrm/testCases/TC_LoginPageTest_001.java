package com.hrm.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.pageObjects.LoginPage;



public class TC_LoginPageTest_001 extends BaseClass{

	@Test
	public void loginTest() throws IOException {
		logger.info("URL is opend");
		LoginPage lp=new LoginPage(driver);//accesing methods from baseclass
		lp.setUserName(username);   //username from config file and setUserName from LoginPage
		logger.info("Username is entered");
		lp.setPassword(password);    //password from config file and setPassword fromLoginPage
		logger.info("password is entered");
		lp.clickLogin();    //clickSubmit from LoginPage
		
		if(driver.getTitle().contains("OrangeHRM")) {
			Assert.assertTrue(true);
			logger.info("title is passed");
		}else {
			captureScreen(driver, "loginTest()");//mention deiver and method name as parameters
			Assert.assertTrue(false);
			logger.info("title is failed ");
		}
	}
	}

