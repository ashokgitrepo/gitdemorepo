package Excel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		System.out.println("hello mail");
		WebElement button=driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		System.out.println("hello mail");
		WebElement u=driver.findElement(By.name("Email"));
		u.clear();
		u.sendKeys("admin@yourstore.com");
		System.out.println("hello after mail");
		System.out.println("hello before pwd");
		WebElement e=driver.findElement(By.name("Password"));
		System.out.println("hello after pwd");
		e.clear();
		
		e.sendKeys("admin");
		System.out.println("hello before login");
		driver.findElement(By.name("RememberMe")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		button.click();
		System.out.println("hello after login");
		System.out.println(driver.getTitle());
		//driver.close();
		// TODO Auto-generated method stub

	}

}
