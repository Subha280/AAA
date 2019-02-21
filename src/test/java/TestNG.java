
import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestNG
{

	public WebDriver wd;
	public TakeScreenShot ts = new TakeScreenShot();	
	
	@BeforeSuite
	public void beforeMethod() throws Exception 
	{
		      System.setProperty("webdriver.chrome.driver", "C://Users//Sriram//Desktop//Youtube-Life'sexciting//chromedriver.exe");
		      wd = new ChromeDriver();
		      wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      wd.get("C:/Users/Sriram/Desktop/Youtube-Life'sexciting/Automation_Handout_Bundle/index.html");
		      wd.manage().window().maximize();
	}
	//Verifying Title of HomePage
	@Test (priority=1)
	public void homepageTitle() throws Exception
	{
			System.out.println(wd.getTitle());
			String home = wd.findElement(By.xpath("//*[@id=\'nav-motto\']")).getText();
			System.out.println(home);
			if(home.equals("Autonomiae Amittit Auream"))
			{ System.out.println("Title Matched");}
			else 
			{  System.out.println("Title is different"); }
			    ts.takeScreenshotOfPage(wd);
			
			}
	
	//Validating the image in the home page
		@Test (priority=2)
		public void imageDisplayed() throws Exception
		{
			wd.get("C:/Users/Sriram/Desktop/Youtube-Life'sexciting/Automation_Handout_Bundle/index.html");
			WebElement img = wd.findElement(By.id("home-cover"));
		    assertTrue(wd.findElement(By.id("home-cover")).isDisplayed());
		    System.out.println("Image Displayed");
		}
		
	@Test (priority=3)
	public void navigateInfo() throws Exception
	{
		//Validating the Title and Navigation to Info Station Page
		wd.findElement(By.xpath("//*[@id='info-link']")).click();
		String info = wd.getTitle();
		System.out.println(info);
		if(info.equals("Automation Information Station") ){
			System.out.println("Navigation Successful - Info Page");
		} else {
		    System.out.println("Navigation Unsuccessful");
		}ts.takeScreenshotOfPage(wd);
	}
	
	@Test (priority=4)
	public void navigateContact() throws Exception
	{
		//Validating the Title and Navigation to Contact Page
		wd.findElement(By.xpath("//*[@id='contact-link']")).click();
		String contact = wd.getTitle();
		System.out.println(contact);
			if(contact.equals("Contact") ){
		    System.out.println("Navigation Successful - Contact Page");
		} else {
		    System.out.println("Navigation Unsuccessful");
		}ts.takeScreenshotOfPage(wd);
	}
	
	@Test
	public void validateCheckBox() throws Exception
	{
		wd.findElement(By.xpath("//*[@id=\'email\']")).sendKeys("ash@gmail.com");
		wd.findElement(By.xpath("//*[@id='pwd']")).sendKeys("123456");
		wd.findElement(By.id("remember-me-check")).click();
		ts.takeScreenshotOfPage(wd);
		wd.findElement(By.xpath("//*[@id=\'home-submit\']")).click();
	}
	
	
	@Test(dataProvider="SearchProvider")
	public void validateForm(String m,String p) throws Exception
	{
		 wd.get("C:/Users/Sriram/Desktop/Youtube-Life'sexciting/Automation_Handout_Bundle/index.html");
		 WebElement mail=wd.findElement(By.xpath("//*[@id=\'email\']"));
		 WebElement pass=wd.findElement(By.xpath("//*[@id='pwd']"));
		 System.out.println("1");
		 mail.sendKeys(m);
		 pass.sendKeys(p);
		 ts.takeScreenshotOfPage(wd);
		 wd.findElement(By.xpath("//*[@id=\'home-submit\']")).click();
		 String ma = mail.getAttribute("value");
		 String pa = pass.getAttribute("value");
			System.out.println(ma);
			
			if (!ma.isEmpty() && !pa.isEmpty() )
				System.out.println("STRING IS NOT NULL");	
			if(!ma.startsWith(" ") && !ma.startsWith("@,!,£,$"))	
				System.out.println("STRING starts with special ");
			else
			{System.out.println("STRING IS NOT NULL");}}
			
			@DataProvider(name="SearchProvider")
	        public static Object[][] getDataFromDataprovider(){
	            return new Object[][] {
	                { "ash@gmail.com", "Glasgow" },
	                { "", "" },
	                { "@gmail", "London" }
	            }; }
		 
	
	
}


