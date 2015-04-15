package Express;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import wsgn.commonMethods;



public class ExpressTestcases extends commonMethods{
 
	@Test
  public void f() throws InterruptedException{
		driver.findElement(By.cssSelector("img[alt='Damsel in Dior']")).click();
		
		int count=0;
		
		List<WebElement>list1 = driver.findElements(By.id("total-products"));
		System.out.println("number of images " + list1.size());
		for(WebElement image : list1){
			if (image.isDisplayed()){
				count++;
				System.out.println(image.getAttribute("img alt"));
				System.out.println(image.getText());
			}
		}
		System.out.println("number of total displable image is "+ count);
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
	/*	
		String myarray[]=new String[100];
		//List<WebElement>list2 = driver.findElements(By.xpath(".//*[@id='[a-z]{4}-[0-9]{2}']/div/a[1]/img"));
		List<WebElement>list2 = driver.findElements(By.id("browse-gallery"));
		
		for(WebElement st:list2){
			System.out.println("the size is "+ st.getSize());
			System.out.println("hello " +st.getText());
		}
		
	Thread.sleep(5000);*/
		
		/*System.out.println("the list of images is " + list2.size() );
		int counter =0;
		for(WebElement image:list2)
		{
		if(image.isDisplayed())
		{
		counter++;
		String[] names = image.getAttribute("img").split("=");
		String name = names[names.length-1];
		System.out.println(name);
		
		
		
  }
		System.out.println(counter);
		}*/
		
}}
