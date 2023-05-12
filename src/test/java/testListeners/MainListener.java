package testListeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import utilities.Common;

public class MainListener implements ITestListener {

	static ExtentReports extentReport;
	static ExtentSparkReporter spark;
	static ExtentTest extentTest;

	private static AppiumDriver driver;
	// private static ITestResult result;
	//
	// public static ITestResult getResult() {
	// return result;
	// }

	public static AppiumDriver getDriver() {
		return driver;
	}

	public static ExtentTest getExtentTest() {
		return extentTest;
	}

	public static void setDriver(AppiumDriver driver) {
		MainListener.driver = driver;
	}

	public void onTestStart(ITestResult res) {
		System.out.println("Started test case is " + res.getName());

		extentTest = extentReport.createTest(res.getMethod().getMethodName(), res.getMethod().getMethodName());
		extentTest.info("Test info");
		try {
			extentTest.addScreenCaptureFromPath(Common.capture(MainListener.getDriver()));
			MediaEntityBuilder media = MediaEntityBuilder.createScreenCaptureFromPath(Common.capture(MainListener.getDriver()));
			extentTest.log(Status.PASS, media.build());
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	public void onStart(ITestContext res) {

		Properties prop = new Properties();
		FileInputStream ip;
		
		try {
			ip = new FileInputStream("./src/resources/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		spark = new ExtentSparkReporter("./Shoal/test-output/Spark Reports/Shoal"+System.currentTimeMillis()+".html");
		extentReport = new ExtentReports();
		ExtentKlovReporter klov = new ExtentKlovReporter("Regression Test");

		klov.initMongoDbConnection("localhost", 27017);
		klov.initKlovServerConnection(prop.getProperty("cloveServerConnection"));
		klov.setProjectName(prop.getProperty("kloveProjectName"));

		extentReport.attachReporter(klov);
		extentReport.attachReporter(spark);

		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", prop.getProperty("deviceName"));
		caps.setCapability("udid", prop.getProperty("udid"));
		caps.setCapability("platformName", prop.getProperty("platformName"));
		caps.setCapability("platformVersion", prop.getProperty("platformVersion"));
		caps.setCapability("appPackage", prop.getProperty("appPackage"));
		caps.setCapability("appActivity", prop.getProperty("appActivity"));
		// caps.setCapability("automationName", prop.getProperty("automationName"));
		// caps.setCapability("appium:AuthToken", prop.getProperty("AuthToken"));
		// caps.setCapability("appium:SessionName", prop.getProperty("SessionName"));
		// caps.setCapability("app", prop.getProperty("app"));
		caps.setCapability("noReset", prop.getProperty("noReset"));

		long elementTimeout = Long.parseLong(prop.getProperty("elementTimeout"));
		

		try {
			URL remoteUrl = new URL(prop.getProperty("url"));

			driver = new AndroidDriver(remoteUrl, caps);

			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(elementTimeout));
			

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Session:" + driver.getSessionId());
	}

	public void onFinish(ITestContext res) {

		extentReport.flush();
		driver.quit();
	}

	// Run when the test case passed successfully
	public void onTestSuccess(ITestResult res) {
		System.out.println("Test case passed is " + res.getName());

	}

	// Run when the test case fails
	public void onTestFailure(ITestResult res) {
		Throwable throwvar = res.getThrowable();
		System.out.println("Test case failed is " + res.getName());
		try {

			extentTest.addScreenCaptureFromPath(capture(MainListener.getDriver())).log(Status.FAIL,
					throwvar.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(capture(MainListener.getDriver())).build());
			System.out.println("Test Failed:" + res.getMethod().getMethodName());
			

		} catch (Exception ex) {

			System.out.println("Error Message:" + ex.getMessage());
		} finally {

			// driver.quit();
		}
	}

	// Run when test case pass with some failures
	public void onTestFailedButWithinSuccessPercentage(ITestResult res) {
		System.out.println("Test case passed with failure is " + res.getName());
	}

	// Run when the test case is skipped
	public void onTestSkipped(ITestResult res) {
		System.out.println("Test case skipped is :" + res.getName());
	}

	private String capture(AppiumDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("D:/Images/" + System.currentTimeMillis() + ".png");
		String errssflpath = Dest.getAbsolutePath();

		Files.copy(scrFile.toPath(), Dest.toPath());
		return errssflpath;
	}

}
