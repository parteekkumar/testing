package multibrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class gmailMultiBrowser {	 

     // Configure for multi browser drivers
   
	private WebDriver driver;
     
   @Test(dataProvider = "browsersmulti") 
   public void gmailMulti(String browser) throws InterruptedException{
    	 
    	 
    	 {
             if (browser.equalsIgnoreCase("firefox")) {
                    driver = new FirefoxDriver();
                    System.out.println("FF Browser is Launching");
             } else if (browser.equalsIgnoreCase("chrome")) {
                    // Set Path for the executable file
                    System.setProperty("webdriver.chrome.driver",
                                 "C:\\Work\\all exe\\IEDriverServer_Win32_2.42.0\\chromedriver.exe");
                    driver = new ChromeDriver();
                    System.out.println("Chrome Browser is Launching");
             } else if (browser.equalsIgnoreCase("ie")) {
                    // Set Path for the executable file
                    System.setProperty("webdriver.ie.driver", "C:\\Work\\all exe\\IEDriverServer_Win32_2.42.0\\IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                    System.out.println("IE Browser is Launching");
             } else {
                    throw new IllegalArgumentException("The Browser Type is Undefined");
             }   
             
      }  
   	//WebDriver driver = new FirefoxDriver();
   	driver.get("https://gmail.com");
   	System.out.println("gmail.com opened");
   	Thread.sleep(5000);
 	 
   
   	
   	
   }
   
   @AfterTest   
   
	   public void closeBrowser(){
		driver.quit();
		
   }
   
  @DataProvider(parallel = true)
  
    public Object[][] browsersmulti(){
	  
	  Object browsers[][] = new Object[3][1];
	  
	  browsers[0][0] = "firefox";
	  browsers[1][0] = "chrome";
	  browsers[2][0] = "ie";
	  
	  return browsers;
  }

}
