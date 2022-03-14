package seleniumTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Timetests {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().setScriptTimeout(5,TimeUnit.SECONDS);
		
		driver.get("https://www.selenium.dev/");
		
		// TODO Auto-generated method stub

	}

}
