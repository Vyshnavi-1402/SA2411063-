package com.Ecommerce;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectProduct(String productName) {
        driver.findElement(By.linkText(productName)).click();
    }

    public void addToCart() {
        driver.findElement(By.linkText("Add to cart")).click();
     
    }
}