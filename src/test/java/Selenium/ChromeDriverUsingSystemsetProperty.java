package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChromeDriverUsingSystemsetProperty {

	public static void main(String[] args) throws InterruptedException {
	//System.setProperty("webdriver.gecko.driver","C:\\Training\\Drivers\\geckodriver-v0.32.2-win-aarch64\\geckodriver.exe");
//WebDriver driver = new FirefoxDriver();
//driver.get("https://www.google.com/");
System.setProperty("webdriver.chrome.driver","C:\\Training\\Drivers\\chromedriver_win32\\chromedriver.exe");
WebDriver driver =new ChromeDriver();
driver.get("https://www.fb.com/");
String s=driver.getCurrentUrl();
System.out.println(s);
	}

}
