package com.Ecommerce;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCart() {
        driver.findElement(By.id("cartur")).click();
    }

    public void placeOrder() {
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        
        

    }
}
