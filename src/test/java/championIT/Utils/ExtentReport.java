package championIT.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	ExtentReports extReport;
	ExtentSparkReporter sparkReporter;

	public ExtentReport() {
		extReport = new ExtentReports();
		sparkReporter = new ExtentSparkReporter("./extent_report/index.html");
		extReport.attachReporter(sparkReporter);
	}
	
	public void createTest() {
		
	}

}
