package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utilities.Common;

public class PhotoIDIntro1 {

	public AppiumDriver driver;

	public PhotoIDIntro1(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Continue\"]")
	private WebElement btnContinue;

	public WebElement getBtnContinue() {
		return btnContinue;
	}
	
	public void clickContinue() {
		Common.screenshot("Landed on Photo ID Intro screen successfully.");
		btnContinue.click();
	}
	
}
