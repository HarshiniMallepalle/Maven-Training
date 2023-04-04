package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOverAndPopUpAlertHandlingDay4 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		login();
		//driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
		Thread.sleep(3000);
		mouseHover();
		clickOnAlert();
		Thread.sleep(300);
		clickonWindowAlert();
		Thread.sleep(300);
		clickonPromtAlert();
	}

	public static void login() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
	    Thread.sleep(5000);
		WebElement email = driver.findElement(By.id("email_field"));
		email.sendKeys("admin123@gmail.com");
		WebElement pswd = driver.findElement(By.id("password_field"));
		pswd.sendKeys("admin123");
		WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login to Account']"));
		loginButton.click();

	}
	public static void mouseHover() {
		
		WebElement moveSwitchTo = driver.findElement(By.xpath("//button[contains(text(),'Switch')]"));
		Actions action= new Actions(driver);
		action.moveToElement(moveSwitchTo).build().perform();
	}
	
	public static void clickOnAlert() {
		WebElement alert = driver.findElement(By.xpath("//a[text()='Alert']"));
		alert.click();
		}
	
	public static void clickonWindowAlert() {
		WebElement windowAlert = driver.findElement(By.xpath("//button[text()='Window Alert']"));
		windowAlert.click();
		String text=driver.switchTo().alert().getText();
		System.out.println(text);
		driver.switchTo().alert().accept();
	}
	public static void clickonPromtAlert() {
		WebElement promtAlert = driver.findElement(By.xpath("//button[contains(text(),'Promt')]"));
		promtAlert.click();
		driver.switchTo().alert().sendKeys("Harshini");
		driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();
		WebElement text1= driver.findElement(By.xpath("//p[@id='Selenium']"));
	    String text2=text1.getText();
	    System.out.println(text2);
	}
}
