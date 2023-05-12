package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utilities.Common;

public class DOB {
	public AppiumDriver driver;

	public DOB(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]")
	private WebElement txtDob;
	
	@FindBy (xpath = "//android.widget.Button[@content-desc=\"OK\"]")
	private WebElement btnOk ;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Confirm\"]")
	private WebElement btnContinue;

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public WebElement getTxtDob() {
		return txtDob;
	}

	public WebElement getBtnOk() {
		return btnOk;
	}
	
	public void submitDOB() {
		Common.screenshot("Landed on DOB screen successfully.");
		txtDob.click();
		btnOk.click();
		Common.screenshot("Selected DOB successfully.");
		btnContinue.click();
		
	}
	
	
}
