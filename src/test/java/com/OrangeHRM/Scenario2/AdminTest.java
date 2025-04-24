package com.OrangeHRM.Scenario2;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class AdminTest {
    WebDriver driver;
    AdminPage adminPage;
    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);

        loginPage.login("Admin", "admin123");
    }

    @Test(priority = 1)
    public void testMenuOptionsCountAndClickAdmin() {
        int count = adminPage.getMenuOptionsCount();
        System.out.println("Menu Option Count: " + count);
        assert count == 12 : "Menu count is not 12!";
        adminPage.clickAdminMenu();
    }

    @Test(priority = 2)
    public void testSearchByUsername() {
        adminPage.searchByUsername("Admin");
        int recordCount = adminPage.getUserRecordsCount();
        System.out.println("Total user records count: " + recordCount);
        // Optionally, you can add an assertion
        Assert.assertTrue(recordCount > 0, "No user records found!");
        //System.out.println(adminPage.getRecordText());
        adminPage.resetSearch();
    }

    @Test(priority = 3)
    public void testSearchByUserRole() {
        adminPage.searchByUserRole();
        int count = adminPage.getUserRecordsCount();
        System.out.println("User Role search result count: " + count);
        adminPage.resetSearch();
    }

    @Test(priority = 4)
    public void testSearchByStatus() {
        adminPage.searchByStatus();
        int count = adminPage.getUserRecordsCount();
        System.out.println("Status search result count: " + count );
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


	  