package wsgn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class commonMethods {
	
		public WebDriver driver;
		@BeforeTest
		  public void beforeMethod() {
			  driver = new FirefoxDriver();
		      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		      //driver.navigate().to("http://www.cnn.com");
		      ///driver.navigate().to("http://www.amazon.com");
		     // driver.navigate().to("http://www.wgsn.com");
		      driver.navigate().to("http://www.express.com");
		      driver.manage().window().maximize();
		  }

		  //@AfterMethod
		  @AfterTest
		  public void afterMethod() {
			  driver.quit();
		  }
}
