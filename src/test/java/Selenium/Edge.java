package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Edge {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com");
		 driver.findElement(By.name("q")).sendKeys("Harshini");
		 Thread.sleep(3000);
		 driver.findElement(By.name("btnK")).click();
	}

}
