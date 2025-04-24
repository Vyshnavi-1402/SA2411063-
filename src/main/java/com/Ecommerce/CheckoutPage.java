package com.Ecommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    WebDriver driver;

    // Page elements
    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    private WebElement cartButton;

    @FindBy(xpath = "//button[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//input[@id='name']")
      WebElement nameField;

    @FindBy(xpath = "//input[@id='country']")
      WebElement countryField;

    @FindBy(xpath = "//input[@id='city']")
   WebElement cityField;

    @FindBy(xpath = "//input[@id='card']")
     WebElement cardField;

    @FindBy(xpath = "//button[contains(text(),'Purchase')]")
    static WebElement purchaseButton;

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void goToCart() {
        cartButton.click();
    }

    public void proceedToCheckout() {
        proceedToCheckoutButton.click();
    }

    public  void enterCheckoutDetails(String name, String country, String city, String card) {
        nameField.sendKeys(name);
        countryField.sendKeys(country);
        cityField.sendKeys(city);
        cardField.sendKeys(card);
    }

    public static void completePurchase() {
        purchaseButton.click();
    }
}

