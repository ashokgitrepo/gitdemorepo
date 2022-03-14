package seleniumTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpeningBrowsers {
	public WebDriver driver;
	String path = System.getProperty("user.dir");

	@BeforeTest
	@Parameters("name")
	public void setUp(String browser) throws InterruptedException {

		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("browser name is : " + browser);
			System.out.println(Thread.currentThread().getId());
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		} else {
			System.out.println("browser name is : " + browser);
			System.out.println(Thread.currentThread().getId());
			WebDriverManager.chromedriver().setup();
			;
			driver = new ChromeDriver();
		}
	}

	@Test
	public void run() {
		driver.get("https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.1.0");
		driver.findElement(By.linkText("Gradle")).click();
		System.out.println(driver.getTitle());
	}

	@AfterMethod
	public void teardown() {

		driver.close();
	}

	// TODO Auto-generated method stub

}
