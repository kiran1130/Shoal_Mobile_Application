package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import testListeners.MainListener;

public class Common {




	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("./screenshots/Image" + System.currentTimeMillis() + ".png");
		String errssflpath = Dest.getAbsolutePath();

		Files.copy(scrFile.toPath(), Dest.toPath());
		return errssflpath;
	}

	public static void screenshot(String stepMessage) {

		try {
			ExtentTest extentTest = MainListener.getExtentTest();
			extentTest.addScreenCaptureFromPath(capture(MainListener.getDriver())).log(Status.PASS, stepMessage,
					MediaEntityBuilder.createScreenCaptureFromPath(capture(MainListener.getDriver())).build());
			//			System.out.println("Test Passed:" + res.getMethod().getMethodName());

		} catch (Exception ex) {

			System.out.println("Error Message:" + ex.getMessage());
		}
		finally {

			//	driver.quit();
		}
	}

	public static WebElement GetElement(String locator, String locatorValue) {
		WebElement element = null;
		switch (locator.toLowerCase()) {
		case "xpath": 
			element = (new WebDriverWait(MainListener.getDriver(), Duration.ofSeconds(30)))
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));
			break;
		}
		return element;
		
	}
	
	public static void enterPIN() {
		for(int i=1;i<7;i++) {
		
			MainListener.getDriver().findElement(By.xpath("//android.view.View[@content-desc=\""+i+"\"]")).click();
		}
		
		Common.screenshot("PIN has been entered successfully.");
	}



}

