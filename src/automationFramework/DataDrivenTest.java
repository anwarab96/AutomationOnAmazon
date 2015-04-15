package automationFramework;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
	
	
	private WebDriver driver;
	  private String baseUrl;
	  
	  @DataProvider(name = "myTest")
	  public Object[][] createData1() {
	          return new Object[][] {
	            { "Iphone"},
	            { "computer"},
	            { "candy"},
	            { "books"},
	                      
	          };
	  }
	  
	  @BeforeMethod
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://www.amazon.com";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  
	  @Test(dataProvider = "myTest")
	  public void testSearchCountry(String SrcItem) throws Exception {
	    driver.navigate().to(baseUrl);
	    driver.findElement(By.cssSelector("#twotabsearchtextbox")).clear();
	    driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(SrcItem);
	    driver.findElement(By.cssSelector(".nav-input")).click();
	   String Title = driver.getTitle();
	   Assert.assertEquals("title pass", "Amazon.com: computer - Computers & Accessories: Electronics", Title);
	  }
	 
	  @AfterMethod
	  public void tearDown() throws Exception {
	    driver.quit();  
	  }
}
