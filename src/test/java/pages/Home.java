package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utilities.Common;

public class Home {
	public AppiumDriver driver;

	public Home(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath = "//android.view.View[@content-desc=\"Add funds\"]")
	private WebElement btnAddFunds;

	@FindBy (xpath = "//android.view.View[@content-desc=\"Withdraw\"]")
	private WebElement btnWithdraw;

	@FindBy (xpath = "//android.view.View[@content-desc=\"Save\"]")
	private WebElement btnSave;
	
	@FindBy (xpath = "//android.widget.Button[@content-desc=\"Add £1000\"]")
	private WebElement lnkFund;

	@FindBy (xpath = "//android.view.View[@content-desc=\"Got it\"]")
	private WebElement btnGotIt;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Complete registration\"]")
	private WebElement btnCompleteRegistration;
	
	


	public WebElement getBtnCompleteRegistration() {
		return btnCompleteRegistration;
	}

	public WebElement getBtnGotIt() {
		return btnGotIt;
	}

	public WebElement getBtnAddFunds() {
		return btnAddFunds;
	}

	public WebElement getBtnWithdraw() {
		return btnWithdraw;
	}

	public WebElement getBtnSave() {
		return btnSave;
	}



	public void addFunds() throws InterruptedException {
		Common.screenshot("Landed on Home screen successfully.");
		btnAddFunds.click();
		lnkFund.click();
		Thread.sleep(6000);
		Common.screenshot("Fund Added Successfully");

	}

}
