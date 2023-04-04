package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeEx {

	public static void main(String[] args) {
		
   WebDriverManager.chromedriver().setup();
   WebDriver driver = new ChromeDriver();
   driver.get("https://www.seleniumframework.com/Practiceform/");
   WebElement na = driver.findElement(By.name("name"));
   na.sendKeys("SitaRam");
   WebElement em = driver.findElement(By.xpath("//input[@placeholder='E-mail *']"));
   em.sendKeys("SitaRam@gmail.com");
   WebElement tele = driver.findElement(By.name("telephone"));
   tele.sendKeys("1234567894");
   WebElement coun = driver.findElement(By.name("country"));
   coun.sendKeys("Barath");
   driver.findElement(By.name("company")).sendKeys("TCS");
   WebElement msg = driver.findElement(By.name("message"));
   msg.sendKeys("SitaRam is a God");
   WebElement submit = driver.findElement(By.xpath("//a[contains(text(),'Subm')]"));
   submit.click();
	}

}
