package com.hrm.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver ldriver;

public LoginPage(WebDriver rdriver) {
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}

@FindBy(id="txtUsername")
@CacheLookup
WebElement txtusername;

@FindBy(id="txtPassword")
@CacheLookup
WebElement txtpassword;

@FindBy(id="btnLogin")
@CacheLookup
WebElement btnlogin;

@FindBy(id="welcome")
@CacheLookup
WebElement txtwelcome;

//action methods
public void setUserName(String uname) {
	txtusername.sendKeys(uname);
}
public void setPassword(String pwd) {
	txtpassword.sendKeys(pwd);
}
public void clickLogin() {
	btnlogin.click();
}
public String welcomeText() {
	String text=txtwelcome.getText();
	return text;
}













}
