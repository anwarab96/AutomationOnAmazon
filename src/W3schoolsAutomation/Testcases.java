package W3schoolsAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

import automationFramework.DataReader;

public class Testcases {
 WebDriver driver;
	/*DataReader reader = new DataReader();
	String [][] locators;*/
	
	@BeforeTest
	  public void beforeMethod() throws Exception{
		
		  /*driver = new FirefoxDriver();
	      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	      //driver.navigate().to("http://www.cnn.com");
	      ///driver.navigate().to("http://www.amazon.com");
	      driver.navigate().to("http://www.W3schools.com");
	      driver.manage().window().maximize();*/
		String baseUrl ="http://www.amazon.com";
		String nodeUrl= "http://192.168.197.1:5555/wd/hub";
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL(nodeUrl),capability);
		
		
	  }

	  //@AfterMethod
	  @AfterTest
	  public void afterMethod() {
		  driver.quit();
	  }
	@Test
	  //=====================================================
	  				//reading data from excel file
	  //=================================================
	  public void readDataExcel() throws Exception{
	  File excel = new File("C:\\Users\\my_pc\\Desktop\\seleniumRC-server\\amazon.xls");
	  FileInputStream fis = new FileInputStream(excel);
	  
	  HSSFWorkbook wb = new HSSFWorkbook(fis);
	  HSSFSheet ws = wb.getSheet("Sheet1");
	  
	  int rowNum = ws.getLastRowNum() + 1;
	  int colNum = ws.getRow(0).getLastCellNum();
	  
	  String [][] data = new String [rowNum][colNum];
	  
	  for(int i =1; i < rowNum; i++){
		  	HSSFRow row = ws.getRow(i);
		  for(int j=0 ; j< colNum; j++){
			 // HSSFCell cell = row.getCell(j);
			 HSSFCell cell = row.getCell(j);
			 
			    String value = cellToString(cell);
			   // String value2 =cellToString(cell);
			    
			    	data[i][j]= value;
			    	//data[1][1]=value2;
			    		WebElement searchbox= driver.findElement(By.name("field-keywords"));
			    			searchbox.sendKeys(value);
			    driver.findElement(By.xpath("//div[@id='nav-search']/form/div[2]/div/input")).click();
				 Thread.sleep(2000);
				driver.navigate().back();
		  }}
				 /*//driver.findElement(By.cssSelector("#gsc-i-id1"));
				 
				 driver.findElement(By.cssSelector(".gsc-results-close-btn.gsc-results-close-btn-visible")).click();
				 Thread.sleep(2000);
			    System.out.printf("%s  ", value);*/
		  
		  
	  
	  }
	  public String cellToString(HSSFCell cell){
		  int type;
		  Object result;
		  type = cell.getCellType();
		   
		  switch(type){
		  case 0 :
			  result = cell.getNumericCellValue();
			  break;
		  case 1 :
			  result = cell.getStringCellValue();
			  break;
			  default:
				  throw new RuntimeException("no type is selected");
		  }
		  return result.toString();
	  }
	  /*@Test
	  public void searchbox() throws IOException{
		  try{
		  String path = "C:\\Users\\my_pc\\Desktop\\seleniumRC-server\\amazon.xls";
		  locators = reader.read(path);
		  for(int i=0; i<locators.length; i++){
		  for(int j=0; j<6; j++){
		  String locator = locators[i][j];
		 WebElement searchbox= driver.findElement(By.cssSelector("#gsc-i-id1"));
		 searchbox.sendKeys(locator);
		 driver.findElement(By.cssSelector(".gsc-search-button.gsc-search-button-v2"));
		 Thread.sleep(2000);
		 driver.navigate().back();
		 driver.findElement(By.cssSelector("#gsc-i-id1"));
		 
		  }
		  }}catch (Exception e){System.out.println(e);
			  
		  }
	  }*/
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
 /* @Test
  
  public void navigationTab() throws Exception{
	  
	  try{
	  WebElement html = driver.findElement(By.cssSelector(".box>h1"));
	  html.click();
	 // WebElement element = driver.findElement(By.cssSelector(".nav.nav-pills.topnav"));
	 // WebElement element = driver.findElement(By.xpath("html/body/div[3]/div/ul"));
	  
	  //System.out.println(element.getText());
	  	//List<WebElement> list = new ArrayList<WebElement>(); 
	List<WebElement> elements =driver.findElements(By.xpath("html/body/div[3]/div/ul"));
	List<String>list1 = new ArrayList<String>();
	  	for(String st: elements){
	  		
	
	  		
	  		list1.add(st);
	  		System.out.print(list2);
	  		String links= st.getText();
	  		
	  		System.out.print(links);
	  	
	  	
	  		
	  		
	  		
	  		for(String l2 : list2){
	  			if (l2 != "")
	  List<WebElement> alllinks= driver.findElements(By.xpath("html/body/div[3]/div/ul"));
	    for(int i=0;i<alllinks.size();i++)
	        System.out.println(alllinks.get(i).getText());

	    for(int i=0;i<alllinks.size();i++){
	    	if(i ==1 || i == 3 || i ==5)
	        alllinks.get(i).click();
	        Thread.sleep(4000);
	        //driver.navigate().back();
	    }
	  			Thread.sleep(2000);
	  		}catch (Exception e){
	  			System.out.println("exception "+ e);
	  		}
	  			
	  		}
	  			
	  		
	  		
	  		list2.add(st.getText());
	  		System.out.print(list2);
	  		
	  			
	  		
	  		
	  	
	  	List<String>gettext = new ArrayList<String>();
	  	for(WebElement st1: list1){
	  		gettext.add(st1.getText());
	  		
	  		System.out.printf("%S ",st1);
	  		
	  	}
	  	*/
	  	
  }
  

