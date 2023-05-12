package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utilities.Common;

public class PhotoIDIntro2 {
	
	public AppiumDriver driver;

	public PhotoIDIntro2(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Ok\"]")
	private WebElement btnOk;
	
	public void clickOnOk() {
		Common.screenshot("One Photo is uploaded successfully.");
		
		btnOk.click();
		
	}
	

}
