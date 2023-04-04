package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchStatic {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
            
			//Launch the Browser
			WebDriver driver = new ChromeDriver();
			
			//Enter the URL
			
			driver.get("https://www.google.com");
			driver.findElement(By.name("q")).sendKeys("Harshini");
			Thread.sleep(3000);
			driver.findElement(By.name("btnK")).click();

	}

}
