package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utilities.Common;

public class ConfirmOnboarding {
	
	public AppiumDriver driver;

	public ConfirmOnboarding(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Done\"]")
	private WebElement btnDone;
	
	public WebElement getBtnDone() {
		return btnDone;
	}

	public void clickOnDone() {
		Common.screenshot("Landed on Onboarding Confirmation screen successfully");
		btnDone.click();
		
	}

}
