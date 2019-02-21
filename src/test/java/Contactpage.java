import static org.testng.Assert.assertTrue;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Contactpage 
{
	WebDriver wd;
	WebDriverWait wait;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	public TakeScreenShot ts = new TakeScreenShot();
	@BeforeTest
	public void beforeMethod() throws Exception 
	{
		      System.setProperty("webdriver.chrome.driver", "C://Users//Sriram//Desktop//Youtube-Life'sexciting//chromedriver.exe");
		      wd = new ChromeDriver();
		      wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      wd.get("C:/Users/Sriram/Desktop/Youtube-Life'sexciting/Automation_Handout_Bundle/contact.html");
		      wd.manage().window().maximize();
	}
	
	@Test (priority=1)	
	public void imageDisplayed() 
	{
		WebElement img = wd.findElement(By.id("contact-cover"));
		assertTrue(wd.findElement(By.cssSelector("img#contact-cover")).isDisplayed());
	    System.out.println("Image Displayed");
	}
	@Test (priority=2)	
	 public void ReadData() throws IOException
	 {
		 // Import excel sheet.
		 File src=new File("C:\\Users\\Sriram\\Desktop\\Inputdata.xlsx");
		 
		 // Load the file.
		 FileInputStream finput = new FileInputStream(src);
		 
		 // Load the workbook.
		workbook = new XSSFWorkbook(finput);
		 
	     // Load the sheet in which data is stored.
		 sheet= workbook.getSheetAt(0);
		
		for(int i=1; i<=sheet.getLastRowNum(); i++)
		 {
			 // Import data for Email.
			 cell = sheet.getRow(i).getCell(1);
			 wd.findElement(By.xpath("//*[@id=\'email\']")).sendKeys(cell.getStringCellValue());
			 
			 // Import data for FirstName.
			 cell = sheet.getRow(i).getCell(2);
			 wd.findElement(By.xpath("//*[@id=\'name\']")).sendKeys(cell.getStringCellValue());
			 
			// Import data for LastName
			 cell = sheet.getRow(i).getCell(3);
			 wd.findElement(By.xpath("//*[@id='contact-form']/form/div[3]/input")).sendKeys(cell.getStringCellValue());
			 
			// Import data for Phone Number
			 cell = sheet.getRow(i).getCell(4);
			 wd.findElement(By.xpath("//*[@id='tel']")).sendKeys(cell.getRawValue());
			 
			 //Selecting Request Type as New Ticket
			 Select s  = new Select(wd.findElement(By.xpath("//*[@id='contact-form']/form/div[5]/select")));
				s.selectByValue("new");
				
			//Importing data for Text area	
			 cell = sheet.getRow(i).getCell(5);
			  wd.findElement(By.cssSelector("textarea")).sendKeys(cell.getStringCellValue());	
			  ts.takeScreenshotOfPage(wd);	
			  //Submit
			  wd.findElement(By.xpath("//*[@id='home-submit']")).click();
			   		
	        }
		
		
	  } 

	}

