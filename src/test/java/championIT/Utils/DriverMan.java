package championIT.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class DriverMan {
	
	WebDriver driver;
	
	
	
	
    public DriverMan() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	    driver = new ChromeDriver();
    }
	
	public WebDriver getDriver() {
		return driver;
	}


   
   


}
