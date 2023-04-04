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

public class FindElementsAutoCompleteDay8 {

	static WebDriver driver;

	public static void main(String[] args) {
		login();
		widget();
		autoComplete("h","Hong Kong");
	}

	public static void login() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		WebElement email = driver.findElement(By.id("email_field"));
		Explicitwait(5, email);

		email.sendKeys("admin123@gmail.com");
		WebElement pswd = driver.findElement(By.id("password_field"));
		pswd.sendKeys("admin123");
		WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login to Account']"));
		loginButton.click();
	}

	public static void widget() {

		WebElement moveTOWidget = driver.findElement(By.xpath("//button[contains(text(),'Widget')]"));
		Explicitwait(5, moveTOWidget);

		Actions action = new Actions(driver);
		action.moveToElement(moveTOWidget).build().perform();
	}

	public static void autoComplete(String element,String Actualvalue) {

		WebElement Auto = driver.findElement(By.xpath("//a[text()='AutoComplete']"));
		Auto.click();
		WebElement country = driver.findElement(By.id("myInput"));
		country.sendKeys(element);
		List<WebElement> valueList = driver.findElements(By.xpath("//div[@id='myInputautocomplete-list']/div"));

		for (WebElement handle : valueList) {
			System.out.println(handle.getText());
			System.out.println(handle);
			Explicitwait(10, handle);

			if (handle.getText().equalsIgnoreCase(Actualvalue)) {
				//Explicitwait(10, handle);
				handle.click();
				break;
			}

		}

	}

	public static void Explicitwait(int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
}
