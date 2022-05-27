package championIT.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;




public class DriverMan {
	
	WebDriver driver;
	
	
	
	
    public DriverMan() {
    	
    	ChromeOptions co = new ChromeOptions();
    	co.setHeadless(false);
//		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
//	    driver = new ChromeDriver();
    	driver = WebDriverManager.chromedriver().capabilities(co).create();
    
    }
	
	public WebDriver getDriver() {
		return driver;
	}


   
   


}
