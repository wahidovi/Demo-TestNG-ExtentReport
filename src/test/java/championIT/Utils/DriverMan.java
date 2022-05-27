package championIT.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;




public class DriverMan {
	
	WebDriver driver;
	
	
	
	
    public DriverMan() {
//		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
//	    driver = new ChromeDriver();
    	driver = WebDriverManager.chromedriver().create();
    }
	
	public WebDriver getDriver() {
		return driver;
	}


   
   


}
