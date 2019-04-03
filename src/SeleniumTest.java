import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class SeleniumTest {
    protected static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src\\BrowserDrivers\\chromedriver.exe");

        DateFormat dateFormat = new SimpleDateFormat("mmddyyyyHHmmss");

        Date date = new Date();

        String date1 = dateFormat.format(date);

        System.out.println("Current date and time is " + date1);

        driver = new ChromeDriver();


        //implicit wait is being used for driver instance which wil be applied to all driver instance.

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        //asking driver to get URL

        driver.get("https://demo.nopcommerce.com/");

        //register as new user

        //asking driver to click on register

        driver.findElement(By.xpath("//a[@class='ico-register']")).click();

        //asking driver to select gender

        driver.findElement(By.xpath("//input[@id='gender-female']")).click();

        //asking driver to enter first name

        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Dhara");

        //asking driver to enter last name

        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Desai");


        //asking user to enter email

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("text" + date1 + "@test.com");

        // asking driver to enter password

        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("Dhara123");

        //asking driver to enter confirm password

        driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).sendKeys("Dhara123");

        //asking user to click on register and user should see welcome message
        driver.findElement(By.xpath("//input[@name='register-button']")).click();


        // Verify actual result  equals expected result

        String actualRegistrationSuccessfulMessage = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals("Your registration completed", actualRegistrationSuccessfulMessage);


        driver.quit();
    }

}