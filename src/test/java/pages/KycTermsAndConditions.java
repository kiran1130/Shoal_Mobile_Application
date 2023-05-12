package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utilities.Common;

public class KycTermsAndConditions {
	public AppiumDriver driver;

	public KycTermsAndConditions(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//android.view.View[5]")
	private WebElement btnSubmitApplication;

	public WebElement getBtnSubmitApplication() {
		return btnSubmitApplication;
	}
	
	public void submitApplication() {
		Common.screenshot("Landed on Submit Application screen");
		btnSubmitApplication.click();
		
	}

}
