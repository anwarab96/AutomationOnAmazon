package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CommonMethods {
	public WebDriver driver ;

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
	
	
	
  /*@Test
  public void f() {
  }*/
}
