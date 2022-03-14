package Excel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderDemo {
	WebDriver driver;
	@BeforeClass
	public void setUp()  {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test(dataProvider="login")
	public void login(String user,String pwd,String res)  {
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		WebElement u=driver.findElement(By.name("Email"));
		u.clear();
		u.sendKeys(user);
		
		WebElement e=driver.findElement(By.name("Password"));
		e.clear();
		e.sendKeys(pwd);
		
		WebElement r=driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
		
		r.click();
		
		
		
		String act_result=driver.getTitle();
		
		String exp_result="Dashboard / nopCommerce administration";
		if(res.equals("Valid")) {
			if(exp_result.equals(act_result)) {
				
				WebElement ele=driver.findElement(By.linkText("Logout"));
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click()", ele);
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		else if(res.equals("Invalid")) {
			if(exp_result.equals(act_result)) {
				WebElement ele=driver.findElement(By.linkText("Logout"));
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click()", ele);
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		
	}
	
	@DataProvider(name="login")
	public String [][] data() throws IOException {
		String path=".\\excel folder\\excelDataProvider.xlsx";

		ExcelFile data=new ExcelFile(path);
		int row=data.getRowCount("Sheet1");
		int r=row-1;
		System.out.println(row);
		int col=data.getColumnCount("Sheet1",0);
		String ashok[][]=new String[row][col];
		for(int i=1;i<=r;i++) {
			for(int j=0;j<col;j++) {
				 ashok[i-1][j]=data.getCellData(i, j, "Sheet1");
				 System.out.println(ashok[i-1][j]);
			}
		}
		
		return ashok;
	}
				
						
		
		
		 
		
	@AfterClass
	public void teardown() {
		driver.close();
		
	}
	
}
		// TODO Auto-generated method stub
		

