package automationFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;


@RunWith(value = Parameterized.class)

public class TestNG {
	
	public WebDriver driver;
	public StringBuffer verificationErrors = new StringBuffer();
	
	/*@DataProvider
	public Object[] testData(){
		return new Object[]{
				new Object[]{"apple"},
				new Object[]{"computer"}
		};
	}
	
	//datadriven test in the search box field
	@Test(dataProvider = "testData")
	public void searchProduct(String item){
		try{
			WebElement searchField = driver.findElement(By.cssSelector(".//*[@id='twotabsearchtextbox']"));
			searchField.clear();
			searchField.sendKeys(item);
			WebElement clickButton =driver.findElement(By.cssSelector(".//*[@id='nav-search']/form/div[2]/div/input"));
			clickButton.click();
			String title = driver.getTitle();
			Assert.assertEquals(item, title);
		}catch (Error e){
		verificationErrors.append(e.toString());
		}
	}*/
	
	public String item;


	/*@Parameters
	public static Collection testData() throws Exception{
		InputStream spreadsheet = new FileInputStream("C:\\Users\\my_pc\\Desktop\\seleniumRC-server\\amazon.xls");
		return new SpreadsheetData(spreadsheet).getData();
		
	}*/
	/*public TestNG(String item){
	this.item=item;
	}*/
	
	
	@Test
	public void serachItem() throws Exception{
		try{
			WebElement searchField = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
			searchField.clear();
			searchField.sendKeys("java");
			WebElement clickButton =driver.findElement(By.cssSelector(".nav-input"));
			clickButton.click();
			String actual = driver.getTitle();
			//Assert.assertEquals("iphone", actual);
		}catch (Error e){
			//verificationErrors.append(e.toString());
	}
	}
	//===================================================================================
					//testCase
	//=====================================================================================
	@Test
	  public void testElementtext() throws Exception {
		  
		  WebElement tryprime = driver.findElement(By.xpath(".//*[@id='nav-link-prime']"));
		                 String elementText = tryprime.getText();
		                 System.out.println("the elements are : " + elementText);
		               //  Assert.assertEquals(elementText, "Try[[]]Prime");
		                 
	  }
	
	
	
	
	

	
	//===============================================================================================================
	//=================================================differnt function for datadriven Testing=======================
		/* public void dataDriven(){
				WebElement searchbox = driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']"));
				WebElement clickButton=driver.findElement(By.cssSelector(".nav-input"));
				try{
					FileInputStream file = new FileInputStream(new File("C:\\Users\\my_pc\\Desktop\\seleniumRC-server\\amazon.xls"));
					HSSFWorkbook workbook = new HSSFWorkbook(file);
					HSSFSheet sheet = workbook.getSheetAt(0);
					
					for(int i=0; i <sheet.getLastRowNum(); i++){
						String keyword = sheet.getRow(i).getCell(0).getStringCellValue();
						
						searchbox.sendKeys(keyword);
						clickButton.click();
						driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
						driver.navigate().back();
						driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
						driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']"));
					}
					workbook.close();
					file.close();
					
				}catch(FileNotFoundException fnfe){
					fnfe.printStackTrace();
					
				}catch(IOException ioe){
					ioe.printStackTrace();
				}
				
			}*/
	
	
		
	
	//testing the search button of amazon
 /* @Test
  public void searchNclick() {
	  
	  driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone");
	  driver.findElement(By.cssSelector(".nav-input")).click();
	  String getTitle = driver.getTitle();
	  System.out.println("title is :" + getTitle);
	 // Assert.assertEquals("jjdjd", getTitle);
	  String expectedTtle= "Amazon.com: iphone - Cell Phones: Cell Phones & Accessories";
	  			if ( getTitle.equals(expectedTtle))
	  				System.out.println("verification home page title is pass");
	  			else
	  				System.out.println("verification of home page title is fail");
	  			
	  			//Assert.assertEquals("jjdjd", getTitle);
  }
	  			
	  					
	  
  //getting the list of link-text from the navigation links/tabs
  @Test
  
  public void getListOfElement(){
	  WebElement gettext = driver.findElement(By.cssSelector("#nav-xshop-container"));
	  	List<WebElement>list = gettext.findElements(By.id("nav-xshop"));
	  
	  		for( WebElement listtext : list){
	  			System.out.print(listtext.getText());
	  	}
  		}*/
	 
	  				
	  			
	  
  
  
  
  
  //@BeforeMethod
  @BeforeTest
  public void beforeMethod() {
	  driver = new FirefoxDriver();
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      //driver.navigate().to("http://www.cnn.com");
      ///driver.navigate().to("http://www.amazon.com");
      driver.navigate().to("http://www.amazon.com");
      driver.manage().window().maximize();
  }

  //@AfterMethod
  @AfterTest
  public void afterMethod() {
	  driver.quit();
  }

}
