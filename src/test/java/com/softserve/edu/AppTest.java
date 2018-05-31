package com.softserve.edu;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppTest {

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        // System.setProperty("webdriver.chrome.driver",
        // "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",
                "target/test-classes/chromedriver-windows-32bit.exe");
        //driver = new ChromeDriver();
        //
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-proxy-server");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-fullscreen");
        driver = new ChromeDriver(options);
        //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testSelen() throws Exception {
        driver.get("https://www.google.com.ua/");
        Thread.sleep(1000);
        //
        driver.findElement(By.id("lst-ib")).sendKeys("Ha-Ha-Ha");
        Thread.sleep(2000);
        //
        driver.navigate().refresh();
        //
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("Selenium IDE Download" + Keys.ENTER);
        //
        //WebElement search = driver.findElement(By.id("lst-ib"));
        //search.sendKeys("Ha-Ha-Ha");
        //Thread.sleep(2000);
        //
        //driver.navigate().refresh();
        //
        //search.click();
        //search.clear();
        //search.sendKeys("Selenium IDE Download" + Keys.ENTER);
        Thread.sleep(1000);
        //
        driver.findElement(By.id("mKlEF")).click();
        Thread.sleep(1000);
        //
        // Scrolling
        //Actions action = new Actions(driver);
        //action.moveToElement(driver.findElement(By.cssSelector("a[aria-label='Page 2']"))).perform();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(By.cssSelector("a[aria-label='Page 2']")));
        Thread.sleep(4000);
        //
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // For example copy somewhere
        FileUtils.copyFile(scrFile, new File("target/surefire-reports/screenshot.png"));
        //
        driver.findElement(By.linkText("Downloads - Selenium")).click();
        Thread.sleep(1000);
        WebElement active = driver.findElement(By.cssSelector("a[name='selenium_ide'] > p"));
        Assert.assertEquals(active.getText(),
                "Selenium IDE is a Chrome and Firefox plugin which records and plays back user interactions with the browser. Use this to either create simple scripts or assist in exploratory testing.");
        Thread.sleep(1000);
        //
        ((JavascriptExecutor)driver).executeScript("document.getElementById('side').innerHTML='<B>HA-HA-HA</B>';");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }

    // @Test
    public void testApp() {
        Assert.assertTrue(true);
    }

}
