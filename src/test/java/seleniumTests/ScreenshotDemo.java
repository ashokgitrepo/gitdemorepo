package seleniumTests;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotDemo {

	public static void main(String[] args) throws IOException {
		Date time=new Date();
		//System.out.println(time);
		String screen=time.toString().replace(" ", "-").replace(":", "-");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ebay.com/");
	    File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshot, new File(".//screenshot//"+screen+".png"));
		// TODO Auto-generated method stub

	}

}
