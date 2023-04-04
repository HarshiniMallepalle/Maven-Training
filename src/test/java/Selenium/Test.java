package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
		   WebDriver driver = new ChromeDriver();
		   driver.get("https://www.seleniumframework.com/Practiceform/");
		   String Exceptedtext="3) JAVA SCRIPT TIMING ALERT";
		   		
		   String Actualtext = driver.findElement(By.xpath("//h4[contains(text(),'Timing')]")).getText();
           System.out.println(Actualtext);
           if(Exceptedtext.equals(Actualtext)) {
        	   System.out.println("Test case is Pass");
           }else {
        	   System.out.println("Test case is fail");
           }
        	   
        	   
           }

}
