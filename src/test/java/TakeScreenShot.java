import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;


public class TakeScreenShot {

	public static void main(String[] args )throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Users//Sriram//Desktop//Youtube-Life'sexciting//chromedriver.exe");
		WebDriver wd = new ChromeDriver();
			wd.manage().window().maximize();
			wd.manage().deleteAllCookies();
					
			wd.get("C:/Users/Sriram/Desktop/Youtube-Life'sexciting/Automation_Handout_Bundle/index.html");
			takeScreenshotOfPage(wd);
			
	}
			public static void takeScreenshotOfPage(WebDriver driver) throws IOException
			{
			File src=	 ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File Des = new File("D://Screenshots//"+ getDateTimeStamp() +".png");
			FileUtils.copyFile(src,Des);
			
			}
			public static String getDateTimeStamp()
			{
			    // creates a date time stamp that is Windows OS filename compatible
			    return new SimpleDateFormat("MMM dd HH.mm.ss").format(Calendar.getInstance().getTime());
			}
		}


