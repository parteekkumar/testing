package multibrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
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
             if (browser.equalsIgnoreCase("firefox")) {
                    driver = new FirefoxDriver();
             } else if (browser.equalsIgnoreCase("chrome")) {
                    // Set Path for the executable file
                    System.setProperty("webdriver.chrome.driver",
                                 "C:\\Work\\all exe\\IEDriverServer_Win32_2.42.0\\chromedriver.exe");
                    driver = new ChromeDriver();
             } else if (browser.equalsIgnoreCase("ie")) {
                    // Set Path for the executable file
                    System.setProperty("webdriver.ie.driver", "C:\\Work\\all exe\\IEDriverServer_Win32_2.42.0\\IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
             } else {
                    throw new IllegalArgumentException("The Browser Type is Undefined");
             }   
             System.out.println("multiple browser opened");
      }  
      
    @Test    
    public void googleLaunch() throws InterruptedException{
    	//WebDriver driver = new FirefoxDriver();
    	driver.get("http://google.com");
    	System.out.println("google.com opened");
    	Thread.sleep(10000);
    	driver.findElement(By.id("gbqfq")).sendKeys("testing");    	 
    	//driver.quit();
    	driver.findElement(By.id("gbqfb")).click();
    	
    }
    @AfterMethod 
    public void afterTest() {
           try {
                  driver.quit();
           } catch (Exception e) {
                  driver = null;
           }
    }
}

