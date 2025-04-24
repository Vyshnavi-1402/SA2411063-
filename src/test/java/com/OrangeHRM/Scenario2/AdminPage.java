package com.OrangeHRM.Scenario2;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
    WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Left Menu Options
    @FindBy(xpath = "//ul[@class='oxd-main-menu']/li")
    List<WebElement> leftMenuOptions;

    // Admin Menu
    @FindBy(xpath = "//span[text()='Admin']")
    WebElement adminMenu;

    // Search Box
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
    WebElement usernameField;

    // Search Button
    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchBtn;

    // Reset Button
    @FindBy(xpath = "//button[normalize-space()='Reset']")
    WebElement resetBtn;

    // Record Text
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div")
    WebElement recordText;

    // User Role dropdown
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]/i")
    WebElement userRoleDropdown;

    @FindBy(xpath = "//div[@role='listbox']//span[text()='Admin']")
    WebElement userRoleAdminOption;

    // Status dropdown
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]/i")
    WebElement statusDropdown;

    @FindBy(xpath = "//div[@role='listbox']//span[text()='Enabled']")
    WebElement statusEnabledOption;

    // Actions
    public int getMenuOptionsCount() {
        return leftMenuOptions.size();
    }

    public void clickAdminMenu() {
        adminMenu.click();
    }
    public int getUserRecordsCount() {
        List<WebElement> userRows = driver.findElements(By.xpath("//div[@class='oxd-table-body']//div[@role='row']"));
        return userRows.size();
    }


    public void searchByUsername(String username) {
        WebElement usernameField = driver.findElement(By.xpath("//label[text()='Username']/../following-sibling::div/input"));
        usernameField.clear();
        usernameField.sendKeys(username);

        WebElement searchBtn = driver.findElement(By.xpath("//button[normalize-space()='Search']"));
        searchBtn.click();

        // Wait for the table to update
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(
            By.xpath("//span[contains(@class,'oxd-text') and contains(text(),'No Records Found')]")
        ));

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//div[@class='oxd-table-body']//div[@role='row']")
        ));
    }

    public void searchByUserRole() {
        userRoleDropdown.click();
        userRoleAdminOption.click();
        searchBtn.click();
    }

    public void searchByStatus() {
        statusDropdown.click();
        statusEnabledOption.click();
        searchBtn.click();
    }
    

    public String getRecordText() {
        return recordText.getText();
    }

    public void resetSearch() {
        resetBtn.click();
    }
}