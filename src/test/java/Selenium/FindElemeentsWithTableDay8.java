package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElemeentsWithTableDay8 {
static WebDriver driver;
	public static void main(String[] args) {
     login();
     table();
	}
	public static void login(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
	}
	
	public static void table() {
		
		List<WebElement> row5 = driver.findElements(By.xpath("//table[@class='ws-table-all notranslate']//tr[6]//td"));

//		for(int i=0;i<row5.size();i++) {
//			System.out.println(row5.get(i).getText());
//			if(row5.get(i).getText().equalsIgnoreCase("<caption>"))
//					row5.get(i).click();
//			System.out.println("We got the excepted page open");
//			break;
//			
//		}
		
		for(WebElement handle:row5) {
			System.out.println(handle.getText());
			if(handle.getText().equalsIgnoreCase("<caption>"));
			handle.click();
			System.out.println("We got the excepted page open");

			break;
		}
	}
	
	public static void Explicitwait(int time,WebElement table) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfAllElements(table));
			
	}
}
