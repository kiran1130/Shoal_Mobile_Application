package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utilities.Common;

public class DocumentIdConfirmation {
	public AppiumDriver driver;

	public DocumentIdConfirmation(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Next\"]")
	private WebElement btnNext;
	
	public void clickOnNext() {
		Common.screenshot("Landed on Confirmation screen successfully.");
		
		btnNext.click();
		
	}
	
	
	
	
	
	

}
