package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utilities.Common;

public class VideoIntro {

	public AppiumDriver driver;

	public VideoIntro(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//android.widget.Button[4]")
	private WebElement btnCamera;
	
	@FindBy (xpath = "//android.widget.Button[2]")
	private WebElement btnCancel;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Continue\"]")
	private WebElement btnContinue;
	
	

	public WebElement getBtnCamera() {
		return btnCamera;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}
	
	public void captureVideo() throws InterruptedException {
		Common.screenshot("Landed on Video Intro screen successfully.");
		btnContinue.click();
		Common.screenshot("Landed on Camera screen successfully.");
		btnCamera.click();
		Thread.sleep(4000);
		btnCamera.click();
		
		
	}
	
}
