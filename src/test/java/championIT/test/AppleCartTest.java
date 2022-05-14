package championIT.test;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import championIT.POM.AppleCartPOM;
import championIT.Utils.DriverMan;

public class AppleCartTest implements ITestListener {

	private DriverMan driverManager = new DriverMan();
	private WebDriver driver = driverManager.getDriver();

	private AppleCartPOM appleCart = new AppleCartPOM(driver);

	ExtentReports extReport;
	ExtentSparkReporter sparkReporter;

	public AppleCartTest() {
		extReport = new ExtentReports();
		sparkReporter = new ExtentSparkReporter("./extent_report/index.html");
		extReport.attachReporter(sparkReporter);

	}

	@Test
	public void visitHomePage(String url) {

		driver.get(url);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setTimelineEnabled(true);
		sparkReporter.config().setDocumentTitle("Champion-IT Demo");
		sparkReporter.config().setDocumentTitle("Apple MacBook Pro Base Model Cart TEST");
		
		
		Assert.assertEquals(driver.getTitle(), "Apple");

		ExtentTest test_report = extReport.createTest("Home Page Validation");
		test_report.log(Status.PASS, "Successfully Landed on Apple Home Page");
		test_report.assignDevice("Windows 10");
		test_report.addScreenCaptureFromPath(screenShot(driver), "Visited Apple Home Page");

	}

	@Test
	public void searchOn(String search_key) {

		appleCart = new AppleCartPOM(driver);
		appleCart.getSearch_icon().click();
		appleCart.getSearch_box().sendKeys(search_key);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentTest test_report = extReport.createTest("Shows Search Suggestions on Search Result");
		test_report.assignDevice("Windows 10");
		test_report.log(Status.PASS, "Search Suggestions Shows Macbook Pro");
		test_report.addScreenCaptureFromPath(screenShot(driver), "Screen Shot of search suggesstion");

	}

	@Test
	public void selectFromSearchSuggestions() {
		appleCart = new AppleCartPOM(driver);
		appleCart.getFirst_result().click();

		ExtentTest test_report = extReport.createTest("After clicking the Search Button icon");

		test_report.log(Status.PASS, "After clicking the seach button shows search result");
		test_report.addScreenCaptureFromPath(screenShot(driver), "showing search result");
	}

	@Test
	public void selectMacBookProBaseModel() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		appleCart.getBuy_button_2nd().click();
		appleCart.getSelect_mac_pro_base_model().click();

	}

	@Test
	public void chooseKeyBoardType(String KeyBoardLang) {
		Select keyboard = new Select(appleCart.getMacBook_Pro_14inch_base_model_keyboard_select());

		List<WebElement> selectOptions = keyboard.getOptions();
		
		for(int i=0; i<selectOptions.size(); i++) {
			if(selectOptions.get(i).getText().contains(KeyBoardLang)) {
				selectOptions.get(i).click();
			System.out.println(KeyBoardLang);
				System.out.println(selectOptions.get(i).getText());
				break;
			}
		}

	  

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");

		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		ExtentTest test_report = extReport.createTest("Selecting " + KeyBoardLang + " Keyboard");
		test_report.assignDevice("Windows 10");
		test_report.log(Status.PASS, "Selecting the " + KeyBoardLang + " Keyboard");
		test_report.addScreenCaptureFromPath(screenShot(driver), "Keyboard Selection");
		
		
	}

	@Test
	public void gotoCart() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		appleCart.getAdd_to_cart().click();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		appleCart.getReview_bag().click();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals(httpStatusCode(), 200);
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			
			ExtentTest test_report = extReport.createTest("Cart Page Test Failed");
			test_report.assignDevice("Windows 10");
			test_report.log(Status.FAIL, "BAD HTTP " + httpStatusCode());
			test_report.addScreenCaptureFromPath(screenShot(driver), " HTTP ERROR " + httpStatusCode());
			
		}
		
		
		
	
	}

	@Test
	public void finalPriceOnCart(String FinalPrice) {

//		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
//				.until(ExpectedConditions.visibilityOf(appleCart.getTotal_incl_tax()));

		
		WebElement element = explicitWaitElementToBeVisible(driver, appleCart.getTotal_incl_tax());

		String priceWithDollarSign = element.getText();

		double price = stringPriceFormatToDouble(priceWithDollarSign);

		System.out.println(price + " = Final Price" + FinalPrice);
		
		//if(price == Double.parseDouble(FinalPrice)) {
			
			try {
				Assert.assertEquals(price, Double.parseDouble(FinalPrice));
				ExtentTest test_report = extReport.createTest("Cart Page");
				test_report.assignDevice("Windows 10");
				test_report.log(Status.PASS, "Cart shows " + price);
				test_report.addScreenCaptureFromPath(screenShot(driver), " Cart Page " + price);
			} catch (AssertionError e) {
				ExtentTest test_report = extReport.createTest("Cart Page Test Failed");
				test_report.assignDevice("Windows 10");
				test_report.log(Status.FAIL, "Cart shows " + FinalPrice);
				test_report.addScreenCaptureFromPath(screenShot(driver), " Cart Page " + price);
			}
		
		
		
		
		extReport.flush();
	}

	public double stringPriceFormatToDouble(String priceWithDollarSign) {

		StringBuilder sb = new StringBuilder(priceWithDollarSign);
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '$' || sb.charAt(i) == ',') {
				sb.deleteCharAt(i);
			}
		}

		priceWithDollarSign = sb.toString();

		double price_In_String_Type = Double.parseDouble(priceWithDollarSign);
		return price_In_String_Type;
	}

	

	public static WebElement explicitWaitToBeClickable(WebDriver driver, WebElement element) {

		WebElement clickableElement = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element));

		return clickableElement;

	}

	public static List<WebElement> explicitWaitElementsToBeVisible(WebDriver driver, List<WebElement> selectOptions) {

		List<WebElement> elements = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfAllElements(selectOptions));

		return elements;

	}

	public static WebElement explicitWaitElementToBeVisible(WebDriver driver, WebElement selectOptions) {

		WebElement elements = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(selectOptions));

		return elements;

	}

	public String screenShot(WebDriver driver) {
		String screenShot_time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String fileType = ".png";
		String screenShotFileName = screenShot_time + fileType;
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/" + screenShotFileName);

		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}

		return destFile.getAbsolutePath();

	}

	public void testCase(ITestResult result) {
		result.getStatus();

	}
	
	public  int httpStatusCode() {
		try {
			String url = driver.getCurrentUrl();
			HttpURLConnection cn = (HttpURLConnection)new URL(url).openConnection();
			cn.setRequestMethod("HEAD");
		      // connection initiate
		      cn.connect();
		      //get response code
		      int res = cn.getResponseCode();
		      return res;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

}
