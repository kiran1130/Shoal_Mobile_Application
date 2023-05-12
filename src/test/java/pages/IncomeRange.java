package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utilities.Common;

public class IncomeRange {
	public AppiumDriver driver;

	public IncomeRange(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}


	@FindBy (xpath = "//android.widget.ImageView[@content-desc=\"Less than £15,000 per year\"]")
	private WebElement btnIncomeRange1;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Next\"]")
	private WebElement btnNext;

	public WebElement getBtnIncomeRange1() {
		return btnIncomeRange1;
	}

	public WebElement getBtnNext() {
		return btnNext;
	}
	
	public void selectIncomeRange() {
		Common.screenshot("Landed on Income Range screen successfully.");
		btnIncomeRange1.click();
		Common.screenshot("Selected Income Range successfully.");
		btnNext.click();
	}

}
