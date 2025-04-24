package com.Ecommerce;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;


public class E2EFlowTest extends BaseTest {

    @Test(priority = 1)
    public void userJourneyTest() throws InterruptedException {
    	
        HomePage home = new HomePage(driver);
        RegisterPage register = new RegisterPage(driver);
        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);

       
        home.clickRegister();
        Thread.sleep(1000); // wait for modal
        register.register("hnajamAdas", "Alkaaijhadad");
        Thread.sleep(2000);
        
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept(); // Clicks 'OK' on the alert
        } catch (NoAlertPresentException e) {
            // No alert popped up, safe to continue
        }
        takeScreenshot(driver, "REGISTERPAGE");
       
        home.clickLogin();
        Thread.sleep(1000);
        login.login("hnajamAdas", "Alkaaijhadad");
        Thread.sleep(3000);
        takeScreenshot(driver, "LoginPage");

        
        
       
        product.selectProduct("Samsung galaxy s6");
        Thread.sleep(2000);
        product.addToCart();
        Thread.sleep(2000);
     
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept(); // Clicks 'OK' on the alert
        } catch (NoAlertPresentException e) {
            // No alert popped up, safe to continue
        }
        takeScreenshot(driver, "PDP");
       
        cart.goToCart();
        Thread.sleep(2000);
        cart.placeOrder();
        takeScreenshot(driver, "cart");
        Thread.sleep(3000);
       
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutDetails("Vyshnavi H K", "India", "Davanagere", "1234 5678 9101 1121");
        takeScreenshot(driver, "CheckoutDetailsEntered");

        // 5. Complete the purchase
        CheckoutPage.completePurchase();

        // 6. Verify purchase confirmation
        String confirmationMessage = driver.getPageSource(); // Or use a more specific verification method
        assert confirmationMessage.contains("Thank you for your purchase!");
        takeScreenshot(driver, "PurchaseConfirmed");
        
    }
}
