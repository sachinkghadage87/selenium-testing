package test.assignment.my_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Hello World!");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://3.96.212.240:8081/contact.html");
        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

		/*
		 * WebElement email1 = driver.findElement(By.name("email")); WebElement password
		 * = driver.findElement(By.name("pass")); WebElement submitButton =
		 * driver.findElement(By.name("login"));
		 */
        
        driver.findElement(By.name("your_name")).sendKeys("Sachin");
        driver.findElement(By.name("phone_number")).sendKeys("123456789");
        driver.findElement(By.name("email_address")).sendKeys("sachin@sachin.com");
        driver.findElement(By.name("your_message")).sendKeys("Hello, how are you?");
        driver.findElement(By.id("my-button")).click();
        
        String message = driver.findElement(By.id("response")).getText();
        System.out.println(message);
        

		/*
		 * email1.sendKeys("Selenium"); password.sendKeys("Selenium1");
		 * Thread.sleep(3000); submitButton.click(); Thread.sleep(30000); WebElement
		 * message = driver.findElement(By.xpath(
		 * "/html/body/div[1]/div[1]/div[1]/div/div[2]/div[2]/form/div/div[2]/div[2]"));
		 * System.out.println(message.getText());
		 */
        
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("test-report.png");
        FileUtils.copyFile(srcFile, destFile);
        
        driver.quit();;
        
    }
}
