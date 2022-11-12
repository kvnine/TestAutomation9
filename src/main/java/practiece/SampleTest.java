package practiece;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SampleTest {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://demo.guru99.com/test/newtours/index.php";
        String username = "test";
        String password = "test";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\KVR\\selenium\\TestAutomation\\BrowserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        Thread.sleep(3000);
        if(driver.findElement(By.xpath("//h3[.='Login Successfully']")).isDisplayed()){
            //syso
            System.out.printf("User logged in successfully");
        }else{
            System.out.println("User login is failed");
        }
        driver.findElement(By.xpath("//a[text()='Flights']")).click();
        Thread.sleep(5);
        driver.findElement(By.xpath("//input[@value='roundtrip']")).click();

        WebElement element = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select selectBox = new Select(element);
        selectBox.selectByIndex(2);


        WebElement element1 = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select selectBox1 = new Select(element1);
        selectBox1.selectByVisibleText("Acapulco ");









    }
}
