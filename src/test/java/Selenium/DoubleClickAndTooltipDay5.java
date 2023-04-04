package Selenium;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClickAndTooltipDay5 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	    //driver.manage().window().maximize();
		driver.get("https://selenium-prd.firebaseapp.com/");
		Thread.sleep(5000);
		WebElement email = driver.findElement(By.id("email_field"));
		email.sendKeys("admin123@gmail.com");
		WebElement pwd = driver.findElement(By.id("password_field"));
		pwd.sendKeys("admin123");
		WebElement loginbutton = driver.findElement(By.xpath("//button[@onclick='login()']"));
		loginbutton.click();
		
		Thread.sleep(5000);
		WebElement interactiontab = driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"));
		interactiontab.click();
		Thread.sleep(5000);

		WebElement doubleclickbutton = driver.findElement(By.xpath("//a[text()='Double Click']"));
		doubleclickbutton.click();
		
//		WebElement doubleclickbutton1 = driver.findElement(By.xpath("//button[text()='Double Click']"));
//		Actions action = new Actions(driver);
//		action.doubleClick(doubleclickbutton1).build().perform();
		Thread.sleep(5000);
		
		WebElement interactiontab1 = driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"));
		interactiontab1.click();
		Thread.sleep(5000);
		WebElement tooltipdrop = driver.findElement(By.xpath("//a[text()='Tool Tip']"));
		tooltipdrop.click();
		
		WebElement Righttooltip = driver.findElement(By.xpath("//div[contains(text(),'Right')]"));
		Actions action =new Actions(driver);
		action.moveToElement(Righttooltip).build().perform();
		String ExceptedText = "Right 1";

		WebElement Rtooltip=driver.findElement(By.xpath("//span[contains(text(),'Right')]"));
		String RightTTText = Rtooltip.getText();
		
		//Assertion using testNG
		compareText(ExceptedText,RightTTText);
		
	}

	private static void compareText( String ActualValue,String ExceptedValue) {

		Assert.assertEquals(ExceptedValue,ActualValue);
	}

}
