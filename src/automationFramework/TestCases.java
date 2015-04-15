package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases extends CommonMethods{
	public WebDriver driver;
	

	@BeforeTest
	public void setUp() throws Exception {
	  driver = new FirefoxDriver();
	   String baseUrl = "http://www.amazon.com";
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	@AfterTest
	public void tearDown() throws Exception {
	  driver.quit();  
	}
	
  @Test
  public void testElementtext() throws Exception {
	  
	  WebElement tryprime = driver.findElement(By.xpath(".//*[@id='nav-link-prime']"));
	                 String elementText = tryprime.getText();
	                 System.out.printf("%S",elementText);
	                 Assert.assertEquals(elementText, "Try Prime");
	                 
  }
}
