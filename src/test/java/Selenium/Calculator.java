package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Calculator {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");	
		WebElement email = driver.findElement(By.id("email_field"));
		
		Explicitwait(5,email);

		email.sendKeys("admin123@gmail.com");
		WebElement pwd = driver.findElement(By.id("password_field"));
		pwd.sendKeys("admin123");
		WebElement loginbutton = driver.findElement(By.xpath("//button[@onclick='login()']"));
		loginbutton.click();
		

		WebElement Calculator = driver.findElement(By.xpath("//a[text()='Calculator']"));
		Explicitwait(5,Calculator);
		Calculator.click();
		
		WebElement no7 = driver.findElement(By.xpath("//input[@value='7']"));
		no7.click();
		WebElement nomul = driver.findElement(By.xpath("//input[@value='x']"));
		nomul.click();
		WebElement no1 = driver.findElement(By.xpath("//input[@value='1']"));
		no1.click();
		WebElement no0 = driver.findElement(By.xpath("//input[@value='1']"));
		no0.click();
		WebElement equals = driver.findElement(By.xpath("//input[@value='=']"));
		equals.click();
		
		WebElement display1 = driver.findElement(By.id("display"));
		String Actualvalue = display1.getAttribute("value");
		System.out.println("Actualvalue is :"+Actualvalue);
		String Exceptedvalue = "77";
		System.out.println("Exceptedvalue is :"+Exceptedvalue);
		Assert.assertEquals(Actualvalue, Exceptedvalue);
	}
	public static void Explicitwait(int time,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
			
	}

	
}
