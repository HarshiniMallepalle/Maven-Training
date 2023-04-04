package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropAndiframeDay5 {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
    
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		
		//iframe
		WebElement frames = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
		driver.switchTo().frame(frames);
		Thread.sleep(000);

		
	      //drag and drop
		Actions action = new Actions(driver);
		WebElement dragfrom = driver.findElement(By.xpath("//img[@alt=\"The peaks of High Tatras\"]"));
		WebElement dropto = driver.findElement(By.id("trash"));

		action.dragAndDrop(dragfrom, dropto).build().perform();
		
		
	}

}
