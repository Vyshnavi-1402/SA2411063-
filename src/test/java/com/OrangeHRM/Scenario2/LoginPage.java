package com.OrangeHRM.Scenario2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	@FindBy (name="username")WebElement userName;
	@FindBy (name="password") WebElement pwd;
	@FindBy (xpath = "//button[@type='submit']")WebElement login;
	
	
	public LoginPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
		
	}
	public void login(String un,String pw) {
		userName.sendKeys(un);
		pwd.sendKeys(pw);
		login.click();
	}
	
}
