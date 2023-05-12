package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utilities.Common;

public class DocumentID {
	
	public AppiumDriver driver;
	private static PhotoIDIntro1 pfIntro;

	public DocumentID(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//android.widget.ScrollView/android.widget.ImageView[1]")
	private WebElement btnPassport;
	
	@FindBy (xpath = "//android.widget.ImageView[2]")
	private WebElement btnUkDrivingLicence;
	
	@FindBy (xpath = "//android.widget.ImageView[3]")
	private WebElement btnProvisionalUkDrivingLicence;
	
	@FindBy (xpath = "//android.widget.ImageView[4]")
	private WebElement btnUkResidencyPermit;
	
	@FindBy (xpath = "//android.widget.ImageView[5]")
	private WebElement btnEuIdentityCard;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Continue\"]")
	private WebElement btnContinue;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Got it\"]")
	private WebElement btnGotIt;
	

	public WebElement getBtnPassport() {
		return btnPassport;
	}

	public WebElement getBtnUkDrivingLicence() {
		return btnUkDrivingLicence;
	}

	public WebElement getBtnProvisionalUkDrivingLicence() {
		return btnProvisionalUkDrivingLicence;
	}

	public WebElement getBtnUkResidencyPermit() {
		return btnUkResidencyPermit;
	}

	public WebElement getBtnEuIdentityCard() {
		return btnEuIdentityCard;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	
	public void selectID() {
		Common.screenshot("Landed on Document ID screen successfully.");
		pfIntro = new PhotoIDIntro1(driver);
		WebElement btnIntroContinue = pfIntro.getBtnContinue();
		
		btnIntroContinue.click();
		btnUkResidencyPermit.click();
		Common.screenshot("Selected Document Type successfully.");
		btnContinue.click();
		btnGotIt.click();
	}
}
