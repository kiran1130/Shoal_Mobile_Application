

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utilities.Common;

public class VideoSuccess {
	public AppiumDriver driver;

	public VideoSuccess(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Continue\"]")
	private WebElement btnContinue;

	public WebElement getBtnContinue() {
		return btnContinue;
	}
	
	public void clickOnContinue() {
		Common.screenshot("Landed on Success screen successfully.");
		btnContinue.click();
	}

}
