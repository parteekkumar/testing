package multibrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class MultiBrowserTest 
    
{	
	  private WebDriver driver;

      // Configure for multi browser drivers
      @Parameters("browser")
      @BeforeMethod
      public void beforeTest(String browser) {
             
             System.out.println("multiple browser opened");
      }  
      
    @Test    
    public void googleLaunch() throws InterruptedException{
    	WebDriver driver = new FirefoxDriver();
    	System.out.println("entering into test cases_GOOGLE");
    	driver.get("http://google.com");
    	System.out.println("google.com opened");
    	Thread.sleep(10000);
    	driver.findElement(By.id("gbqfq")).sendKeys("testing");    	 
    	//driver.quit();
    	driver.findElement(By.id("gbqfb")).click();
    	
    }
    @AfterTest
    public void afterTest() {
           try {
                  driver.quit();
           } catch (Exception e) {
                  driver = null;
           }
    }
}

