package module1Tests.guiTests;


import libraries.*;
import models.appProperties.AppPropertiesModel;
import org.checkerframework.checker.units.qual.C;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @AfterMethod
    public void closeBrowser() {
        WebDriverUtility.getInstance().close();
        WebDriverUtility.getInstance().quit();

    }
}
