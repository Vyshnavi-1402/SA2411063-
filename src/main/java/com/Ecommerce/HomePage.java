package com.Ecommerce;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login2")
    WebElement loginButton;

    @FindBy(id = "signin2")
    WebElement registerButton;

    public void clickLogin() {
        loginButton.click();
    }

    public void clickRegister() {
        registerButton.click();
   
      

    }
    
}
