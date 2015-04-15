package automationFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataReader {
	public WebDriver driver;
	DataReader reader = new DataReader();
	String [][] locators;
	@Test
	public void nav()throws IOException {
		String path = "C:\\Users\\my_pc\\Desktop\\seleniumRC-server\\amazon.xls";
		locators = reader.read(path);
		for(int i=1; i<locators.length; i++){
		for(int j=0; j<=i; j++){
		String locator = locators[i][j];
		//clickOnCss(locator);
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).clear();
	    driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(locator);
	    driver.findElement(By.cssSelector(".nav-input")).click();
	   String Title = driver.getTitle();
	   driver.navigate().back();
		}}
	}
	 public int numRow, numCol;
	
	public String [][] read(String filename) throws IOException{
		
		String [][] dataContainer;
		
		File file = new File(filename);
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet = wb.getSheetAt(0);
		numRow = sheet.getLastRowNum();
		numCol = sheet.getRow(0).getLastCellNum();
		dataContainer = new String[numRow][numCol];
		for(int i=0; i<dataContainer.length; i++){
		HSSFRow row = sheet.getRow(i);
		for(int j=0; j<numCol; j++){
		HSSFCell cell = row.getCell(j);
		String cellData = convertCell(cell);
		dataContainer[i][j] = cellData;
		}
	}
		return dataContainer;
	}
	public String convertCell(HSSFCell cell){
		Object data= null;
		int dataType = cell.getCellType();
		switch (dataType){
		case HSSFCell.CELL_TYPE_NUMERIC:
		data = cell.getNumericCellValue();
		break;
		case HSSFCell.CELL_TYPE_STRING:
		data = cell.getStringCellValue();
		break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
		data = cell.getBooleanCellValue();
		break;
		}
		return data.toString();
		}
	
@BeforeTest
public void setUp() throws Exception {
  driver = new FirefoxDriver();
   String baseUrl = "http://www.amazon.com";
  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
}
@AfterTest
public void tearDown() throws Exception {
  driver.quit();  
}}	
	
	
 
