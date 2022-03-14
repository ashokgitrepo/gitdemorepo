package headlessbrowsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("headless");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("7981625775");
		driver.findElement(By.name("pass")).sendKeys("Kithusinha@");
		driver.findElement(By.name("login")).sendKeys(Keys.RETURN);
		System.out.println(driver.getTitle());
		driver.close();

	}

}
