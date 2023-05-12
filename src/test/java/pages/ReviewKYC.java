package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utilities.Common;

public class ReviewKYC {
	
	public AppiumDriver driver;

	public ReviewKYC(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Upload photo\"]")
	private WebElement btnUpload;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"No, Try again\"]")
	private WebElement btnTryAgain;	
	

	public WebElement getBtnUpload() {
		return btnUpload;
	}

	public WebElement getBtnTryAgain() {
		return btnTryAgain;
	}
	
	public void uploadPhotoID() {
		Common.screenshot("Landed on review screen successfully.");
		btnUpload.click();
	
		
	}

}
