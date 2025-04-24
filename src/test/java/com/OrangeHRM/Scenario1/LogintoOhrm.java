package com.OrangeHRM.Scenario1;

import java.io.*;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LogintoOhrm {
    WebDriver driver;
    String fPath = "E://LoginData.xlsx";
    FileInputStream fis;
    FileOutputStream fos;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;
    XSSFCellStyle style;
    XSSFFont font;
    int index = 1;

    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setup() throws IOException {
        // Excel setup
        fis = new FileInputStream(fPath);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);
        fos = new FileOutputStream(fPath);

        // Browser setup
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Extent Report setup
        ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Test(dataProvider = "getLoginData")
    public void loginToHRM(String username, String password) throws InterruptedException, IOException {
        test = extent.createTest("Login Test Case " + index);

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(3000); // Wait for login response

        // Screenshot after login
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "screenshots/Login_AfterClick_" + index + ".png";
        FileUtils.copyFile(screenshot, new File(path));
        test.info("Screenshot after login", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        row = sheet.getRow(index);
        cell = row.getCell(2);

        style = wb.createCellStyle();
        font = wb.createFont();

        String status = driver.getCurrentUrl().contains("dashboard") ? "Pass" : "Fail";

        // Screenshot for result
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "screenshots/Login_" + status + "_" + index + ".png";
        FileUtils.copyFile(screenshot, new File(screenshotPath));
        test.addScreenCaptureFromPath(screenshotPath);

        if (status.equals("Pass")) {
            test.pass("Test Passed");
            font.setColor(HSSFColorPredefined.GREEN.getIndex());
            font.setBold(true);

            try {
                driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")).click();
                driver.findElement(By.linkText("Logout")).click();
            } catch (Exception e) {
                test.warning("Logout not performed");
            }
        } else {
            test.fail("Test Failed");
            font.setColor(HSSFColorPredefined.RED.getIndex());
            font.setItalic(true);
        }

        style.setFont(font);
        cell.setCellStyle(style);
        cell.setCellValue(status);

        index++;
    }

    @AfterTest
    public void closeResources() throws IOException {
        extent.flush();
        wb.write(fos);
        wb.close();
        fis.close();
        fos.close();
        driver.quit();
    }

    @DataProvider
    public Object[][] getLoginData() {
        int rows = sheet.getPhysicalNumberOfRows();
        Object[][] data = new Object[rows - 1][2];

        for (int i = 1; i < rows; i++) {
            row = sheet.getRow(i);
            data[i - 1][0] = row.getCell(0).getStringCellValue();
            data[i - 1][1] = row.getCell(1).getStringCellValue();
        }
        return data;
    }
}
