package module1Tests.guiTests;


import libraries.*;
import models.appProperties.AppPropertiesModel;
import org.checkerframework.checker.units.qual.C;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageObjects.Module1Page;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Module1GuiTests {
    WebDriver webDriver = WebDriverUtility.getInstance();
    Module1Page module1Page = PageFactory.initElements(webDriver, Module1Page.class);

    CommonUtility commonUtility = new CommonUtility();

    AppPropertiesModel appPropertiesModel;

    public Module1GuiTests(){
         appPropertiesModel = commonUtility.readPropertiesYml();
    }


    @Test
    public void test_gui() throws InterruptedException, IOException {

        webDriver.get(appPropertiesModel.getApp1().getUrl());
        String previousVal = "";
        int i = 0;
        if (true) {
            String dateTime = new SimpleDateFormat("EEE dd-MM-yyyy HH:mm:ss.SSS Z").format(new Date());
            if (i > 1) {
                webDriver.navigate().refresh();
            }

            new WebDriverWait(webDriver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.textToBePresentInElement(module1Page.subscribersCount,
                            "subscribers"));
            String[] content = module1Page.subscribersCount.getText().split("subscribers");
            System.out.println(dateTime + ", " + content[0].trim
                    () + ", " + "subscribers - kundabaddalu2.0");

            if (!previousVal.equalsIgnoreCase(content[0].trim())) {
                previousVal = content[0].trim();
                TextFileUtility.appendContentToTextFile(dateTime + ", " + content[0].trim() + ", " + "subscribers - kundabaddalu2.0");
            }
            i = i + 1;
            Thread.sleep(5000);//Every 5 mins

        }

    }


    @Test
    public void test_create_account() throws InterruptedException {
        //how to define string variable
        String app_url = "https://demo.guru99.com/test/newtours/index.php";
        //how to print it console log
        System.out.println("Given url: " + app_url);

        //how to set the driver location
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\KVR\\selenium\\TestAutomation\\BrowserDrivers\\chromedriver.exe");
        //how to initiate the chrome driver
        WebDriver driver = new ChromeDriver();
        //how to launch the application
        driver.get(app_url);

        //how to enter value in a text box
        String username_txt_box = "//input[@name='userName']";
        WebElement x = driver.findElement(By.xpath(username_txt_box));
        x.sendKeys("test");

        String password_txt_box = "//input[@name='password']";
        driver.findElement(By.xpath(password_txt_box)).sendKeys("test");
        driver.findElement(By.xpath("//input[@name='submit']")).click();



        if (driver.findElement(By.xpath("//h3[text()='Login Successfully']")).isDisplayed()){
            System.out.println("Login is successful");
        }else {
            System.out.println("Login is not successful");
        }
//        Thread.sleep(5);
//        driver.navigate().refresh();

        driver.findElement(By.xpath("//a[@href='reservation.php']")).click();

        Thread.sleep(5);
        driver.navigate().refresh();
        Thread.sleep(5);
        driver.findElement(By.xpath("//a[@href='reservation.php']")).click();

        //        driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
        driver.findElement(By.xpath("//input[@value='roundtrip']")).click();

        WebElement element1 = driver.findElement(By.xpath("//select[@name='passCount']"));

        //how to define select object
        Select passengerSelect = new Select(element1);
        passengerSelect.selectByVisibleText("2");

        new Select(driver.findElement(By.xpath("//select[@name='fromPort']"))).selectByVisibleText("London");

        //how selenium works.
//        object.action;

        new Select(driver.findElement(By.xpath("//select[@name='fromMonth']"))).selectByVisibleText("June");

        new Select(driver.findElement(By.xpath("//select[@name='fromDay']"))).selectByVisibleText("26");

        new Select(driver.findElement(By.xpath("//select[@name='toPort']"))).selectByVisibleText("Frankfurt");
        new Select(driver.findElement(By.xpath("//select[@name='toMonth']"))).selectByVisibleText("July");
        new Select(driver.findElement(By.xpath("//select[@name='toDay']"))).selectByVisibleText("30");










    }


//    @AfterMethod
//    public void closeBrowser() {
//        WebDriverUtility.getInstance().close();
//        WebDriverUtility.getInstance().quit();
//
//    }

}
