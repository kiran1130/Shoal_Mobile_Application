package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utilities.Common;

public class ReviewIncomeDetails {
	public AppiumDriver driver;

	public ReviewIncomeDetails(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Submit\"]")
	private WebElement btnSubmit;

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public void submitIncomeDetails() {
		Common.screenshot("Landed on Income Review screen successfully");
		btnSubmit.click();
	}
}
