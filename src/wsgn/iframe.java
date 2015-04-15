package wsgn;


import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class iframe  {
	public WebDriver driver;
	@BeforeTest
	  public void beforeMethod() {
		  driver = new FirefoxDriver();
	      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	      //driver.navigate().to("http://www.cnn.com");
	      ///driver.navigate().to("http://www.amazon.com");
	      driver.navigate().to("http://www.wgsn.com");
	     // driver.navigate().to("http://www.wgsninstock.com");
	      driver.manage().window().maximize();
	  }

	  //@AfterMethod
	  @AfterTest
	  public void afterMethod() {
		  driver.quit();
	  }
	//================================================================================================================
	   @Test
	   public void handlingWindow() throws InterruptedException{
		   
		   String currentWindow = driver.getWindowHandle();
	   driver.findElement(By.cssSelector("#homepage-ad>a>img")).click();
	           
	             Thread.sleep(5000);
	             Set<String> allwindows = driver.getWindowHandles();
	                   for(String windowname : allwindows){
	                	   driver.switchTo().window(windowname);
	                	   String strTitle = driver.getTitle();
	                	   System.out.println("page title is " + strTitle);
	                	   driver.findElement(By.cssSelector(".more_link")).click();
	                	   List<WebElement>experts = driver.findElements(By.className(".more_link"));
	                	   for(int i=0; i <experts.size();i++){
	                		   System.out.println("experts name is :" +experts.get(i).getText());
	                		 
	                	   }
	                	   
	                   }
	                   //driver.close();
	                   driver.switchTo().window(currentWindow);
	                   System.out.println("home page title is : " + driver.getTitle());
	                   
	             /*String NextWindow = driver.getWindowHandle();
	             driver.switchTo().window(NextWindow);
	             String title  = driver.getTitle();
	             System.out.println("the tutke is "+ title);
	             WebElement login =driver.findElement(By.cssSelector("#header-login-btn>p>a"));
	                        login.click();
	                        Thread.sleep(9000);
	                        
	                       // driver.switchTo().window(currentWindow);
	                        driver.switchTo().defaultContent();
	                   WebElement home=     driver.findElement(By.cssSelector("#menu-item-108>a"));
	                   home.click();
	                   String title1 = driver.getTitle();
	                   System.out.println("the title is :" + title1);
	                        Thread.sleep(3000);*/
	           
	             
	             
	             
	             /*Set<String> allWindows = driver.getWindowHandles();
	             if(!allWindows.isEmpty()){
	            	 for(String windowId : allWindows){
	            		 driver.switchTo().window(windowId);
	            		String actualTitle = driver.getTitle();
	            		  Assert.assertEquals(actualTitle, "WGSN INstock");
	            		  driver.close();
	            		  break;
	            		 }
	            	 }*/
	             //driver.switchTo().window(currentWindow);
	            // driver.switchTo().defaultContent();
	             }
	           
	  
	  //=======================================================================================================
@Test
public void getTtitle(){
	String title = driver.getTitle();
	System.out.println(title);
	Assert.assertTrue(true);
}
}
	  
	  
	  
	  
	  
	  
	
	//===================================================================================================================
  /*@Test
  public void f() throws InterruptedException{
	 
	  //WebElement fram1= driver.findElement(By.xpath(//*[@ src="www.googletagmanager.com/ns.html?id=GTM-MZTN9C"]));
	  WebElement element = driver.findElement(By.cssSelector("#menu-item-108>a"));
	             element.click();
	              			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
  }*/
  
/*  @Test   ///counting number of images
  public void getnumOfImg() throws InterruptedException{
	  
	  WebElement imagelink = driver.findElement(By.className("slider_backdrop"));
	             imagelink.click();
	             Thread.sleep(9000);
	             driver.navigate().back();
	  
  }*/
  /*@Test
  
  public void clickOnRadiogroup() throws InterruptedException{
	  
	 // List<WebElement> list1 = driver.findElements(By.cssSelector(".flex-control-nav.flex-control-paging"));
	  List<WebElement> list1 = driver.findElements(By.xpath(".//*[@id='slider_4037']/ol/li[1-4]/a"));
	  
	 for(int i=0;i<list1.size();i++){
		 System.out.println(listwebelement.get(i).getAttribute("class"));
	  }
	 
	 for (WebElement option : list1) {
		 String text = option.getText();
		 System.out.println("text name of radioGroup is "+ text);
			if (option.getText() !=""){
				option.click();
				Thread.sleep(5000);
			}
  }*/
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

