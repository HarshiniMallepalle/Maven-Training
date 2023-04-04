package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBasicsDay1to3 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.get("https://selenium-prd.firebaseapp.com/");
		Thread.sleep(2000);
        String titl = driver.getTitle();
        String ExceptedTitle = "Selenium1";
        if(ExceptedTitle.equals(titl)) {
        	System.out.println("Browser launched sucessfully");
        }else {
        	System.out.println("Test case failed Excepted title is "+ExceptedTitle+" but actual title is "+titl);
        }
		WebElement email = driver.findElement(By.id("email_field"));
		email.sendKeys("admin123@gmail.com");
		WebElement pwd = driver.findElement(By.id("password_field"));
		pwd.sendKeys("admin123");
		WebElement loginbutton = driver.findElement(By.xpath("//button[@onclick='login()']"));
		loginbutton.click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		driver.findElement(By.name("name")).sendKeys("Harshini");
		driver.findElement(By.name("lastname")).sendKeys("Mallepalle");
		driver.findElement(By.id("postaladdress")).sendKeys("29 Tisdale ln,Clifton Park,NY");
		driver.findElement(By.id("personaladdress")).sendKeys("Clifton Park");
		driver.findElement(By.xpath("//input[@value='female']")).click();
		
		//driver.findElement(By.xpath("//select[@name='city']//descendant::option[@value='newdelhi']")).click();
		WebElement cityDropdwon = driver.findElement(By.id("city"));
		Select city = new Select(cityDropdwon);
		city.selectByVisibleText("MUMBAI");
		
		WebElement coursedropdown = driver.findElement(By.id("course"));
		Select course = new Select(coursedropdown);
		course.selectByValue("btech");
		WebElement districtdropdown = driver.findElement(By.id("district"));
		Select district = new Select(districtdropdown);
		district.selectByIndex(3);
		driver.findElement(By.xpath("//select[@name='state']//descendant::option[@value='mba']")).click();
		driver.findElement(By.id("pincode")).sendKeys("12065");
		driver.findElement(By.id("emailid")).sendKeys("Harshini@gmail.com");
		driver.findElement(By.xpath("//button[contains(text(),'Submi')]")).click();




	}

}
