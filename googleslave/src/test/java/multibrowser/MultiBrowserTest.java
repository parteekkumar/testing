package multibrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class MultiBrowserTest 
    
{	
	public WebDriver driver;

      // Configure for multi browser drivers
      //@Parameters("browser")
      
      @BeforeTest
      public void beforeTest() {
    	  driver = new FirefoxDriver();
             
             System.out.println("In Beforetest");
      }  
      
    @Test(priority = 1)    
    public void googleLaunch() throws InterruptedException{
    	//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
    	
    	System.out.println("entering into test cases_GOOGLE");
    	driver.get("http://google.com");
    	System.out.println("google.com opened");
    	
    	
    	Thread.sleep(2000);
    	driver.findElement(By.id("gbqfq")).sendKeys("testing");    	 
    	//driver.quit();
    	driver.findElement(By.id("gbqfb")).click();
    	
    }
   
    @Test(priority = 2)  
    public void assertion2(){
    	System.out.println("In failed test2");
    	Assert.fail("Assert.fail2");
    	
    }
    
    @Test(priority = 3)  
    public void assertion3(){
    	System.out.println("In failed test3");
    	Assert.fail("Assert.fail3");
    	
    }
    @AfterTest
    public void aftertest() {
    	
    	System.out.println("In AfterTest1");
          driver.quit();
          System.out.println("In AfterTest2");
          
    }
}

