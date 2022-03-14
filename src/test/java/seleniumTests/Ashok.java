package seleniumTests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class Ashok {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASHOK KUMAR\\eclipse-workspace\\org.seleniumframework\\Drivers\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testAshok() throws Exception {
    driver.get("https://www.facebook.com/");
    driver.findElement(By.id("email")).click();
   // driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("7981625775");
    driver.findElement(By.id("pass")).click();
   // driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("Kithusinha@");
    driver.findElement(By.name("login")).click();
    driver.findElement(By.xpath("//div[@id='mount_0_0_uf']/div/div/div/div[2]/div[4]/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div[3]/div/div[4]/div/div/div[2]/div/div/div/div/span")).click();
    driver.close();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
