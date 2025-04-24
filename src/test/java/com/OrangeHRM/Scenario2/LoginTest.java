package com.OrangeHRM.Scenario2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
  WebDriver driver;
  LoginPage loginpg;
  
  
  @BeforeClass
  	public void setup() {
	  driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.manage().window().maximize();
      driver.get("https://opensource-demo.orangehrmlive.com/");

      loginpg = new LoginPage(driver);
       }
  
  @Test
  public void testvalidlogin() {
	  loginpg.login("Admin","admin123");
	  }
  
  @AfterClass
  public void tearDown() {
      driver.quit();
  }
  }

