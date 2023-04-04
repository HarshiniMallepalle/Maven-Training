package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitTypesDay4a {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();

		//implicit wait
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://selenium-prd.firebaseapp.com/");
		WebElement email = driver.findElement(By.id("email_field"));
		email.sendKeys("admin123@gmail.com");
		WebElement pswd = driver.findElement(By.id("password_field"));
		pswd.sendKeys("admin123");
		WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login to Account']"));
		loginButton.click();
		
		WebElement homeBtn = driver.findElement(By.xpath("//a[text()='Home']"));
		//ExplicitWait(10,homeBtn);
		fluentwait(homeBtn);
		homeBtn.click();

	}
	
	public static void ExplicitWait(int time,WebElement element) {
		
		WebDriverWait ewait = new WebDriverWait(driver, time);
		ewait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public static void fluentwait(WebElement element) {
		
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
	wait.withTimeout(10, TimeUnit.SECONDS);
	wait.pollingEvery(200, TimeUnit.MILLISECONDS);
	wait.until(ExpectedConditions.visibilityOf(element));
	}


}
