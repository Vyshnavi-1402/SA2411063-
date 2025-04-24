package com.Ecommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "sign-username")
    WebElement usernameInput;

    @FindBy(id = "sign-password")
    WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Sign up']")
    WebElement signUpButton;

    public void register(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signUpButton.click();
        


    }
}
