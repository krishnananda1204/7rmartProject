package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility {

	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); //location
		reporter.config().setReportName("7rmart Project");  //project name
		extentReports.attachReporter(reporter); //connect the ExtentReports and ExtentSparkReporter
		extentReports.setSystemInfo("Organization", "Obsqura"); //project details
		extentReports.setSystemInfo("Name", "Krishna");
		return extentReports;
	}

}
