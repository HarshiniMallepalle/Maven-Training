package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Firefox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver =new FirefoxDriver();
		driver.get("https://www.google.com");
		 driver.findElement(By.name("q")).sendKeys("Harshini");
		 Thread.sleep(3000);
		 driver.findElement(By.name("btnK")).click();

	}

}
