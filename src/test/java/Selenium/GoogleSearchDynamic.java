package Selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchDynamic {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		login();
		autoComplete("java api","java api arraylist");

	}

	public static void login() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://google.com");

	}

	public static void autoComplete(String send,String findActualValue ) {

		WebElement search = driver.findElement(By.name("q"));

		search.sendKeys(send);
		Explicitwait(5, search);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']"));
		// System.out.println(list.size());
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getText());
//		
//			if (list.get(i).getText().equals(findActualValue)) {
//
//				list.get(i).click();
//				break;
//			}
//		}
//		Assert.assertEquals(findActualValue,"java api arraylist123");
		

	for(WebElement handle:list) {
		System.out.println(handle.getText());
		//System.out.println(handle);
		if(handle.getText().equalsIgnoreCase(findActualValue)) {
		handle.click();
		break;
		
		}
	}
	Assert.assertEquals(findActualValue,"java api arraylist");

	}

	public static void Explicitwait(int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

}
