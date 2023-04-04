package Selenium;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.GetAllWindowHandles;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingOnDifferentWindowDay7 {
	
    static WebDriver driver;
	public static void main(String[] args) {
    
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		
		WebElement email = driver.findElement(By.id("email_field"));
		
		findElement(5,email);

		email.sendKeys("admin123@gmail.com");
		WebElement pwd = driver.findElement(By.id("password_field"));
		pwd.sendKeys("admin123");
		WebElement loginbutton = driver.findElement(By.xpath("//button[@onclick='login()']"));
		loginbutton.click();
		

		WebElement switchto = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		findElement(5,switchto);
		switchto.click();
		
		WebElement window = driver.findElement(By.xpath("//a[contains(text(),'Windows')]"));
		findElement(5,window);
		window.click();
		
		WebElement windowTab = driver.findElement(By.xpath("//button[contains(text(),'Tab')]"));
		findElement(5,windowTab);
		windowTab.click();
		
		//String Parentwindow = driver.getWindowHandle();
       // System.out.println(" Parent "+Parentwindow);
		String Parenttitle = driver.getTitle();
		System.out.println(Parenttitle);
		
		//It works only for two Windows/Tabs
//		for(String handle1 :driver.getWindowHandles()) {
//			driver.switchTo().window(handle1);
//		}
		
		
		//It works for any number of windows
		Set<String> handle = driver.getWindowHandles();
		//System.out.println(handle);
		int n = handle.size();
		//System.out.println("Number of windows : "+n);

		//assigning index value for handle 
		 String[] indexOfWindows = handle.toArray(new String[n]);
        // System.out.println(indexOfWindows[1]);

		
		driver.switchTo().window(indexOfWindows[1]);
			
		String Childtitle = driver.getTitle();
		System.out.println(Childtitle);
		
		WebElement googlesearch = driver.findElement(By.name("q"));
		googlesearch.sendKeys("Harshini");
		
		driver.switchTo().window(indexOfWindows[0]);
		System.out.println(driver.getTitle());
		
		// driver.close();
		//driver.quit();
	}

	public static void findElement(int time,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
