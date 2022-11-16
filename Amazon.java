import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazon {
  
	public static WebDriver driver;
	
	static String path = "D:\\chromedriver_win32 (6)\\chromedriver.exe";
	
	static String URL  = "https://www.amazon.in/";
	
	
	@BeforeTest
	public static void main() {
	  
		System.setProperty("webdriver.chrome.driver", path);
		
		driver = new ChromeDriver();
		
		driver.get(URL);
		
		driver.manage().window().maximize();
		

	}
	
	@Test
	public static void Fan () {
		  
		WebElement droupdown = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[1]/div/div/select/option[23]"));
		droupdown.click();
		
		WebElement searchbox = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input"));
		searchbox.sendKeys("Fan");
		searchbox.sendKeys(Keys.ENTER);	

	}
	@Test
	public static void FindingLowCostFan () throws InterruptedException {
		  
		WebElement LowCostFan = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[5]/ul[1]/li[1]/span/a/span"));
		LowCostFan.click();
		
		JavascriptExecutor scrolldown = (JavascriptExecutor)driver;
		 
		scrolldown.executeScript("window.scrollBy(0, 300);");
	}
	
	
	@AfterTest
	public void ResultScreenshot () throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		
	    File destinationFile = new File("C:\\Users\\VIGNESH SUNDAR RAJ\\Desktop\\Test Samples\\ssnew.jpg");
	    FileHandler.copy(sourceFile, destinationFile);
		
		

	}
	
	
	
	}
	
