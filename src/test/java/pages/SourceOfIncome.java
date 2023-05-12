package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utilities.Common;

public class SourceOfIncome {
	
	public AppiumDriver driver;

	public SourceOfIncome(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}


	@FindBy (xpath = "//android.widget.ImageView[@content-desc=\"Investment\"]")
	private WebElement btnInvestment;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Continue\"]")
	private WebElement btnContinue;

	public WebElement getBtnInvestment() {
		return btnInvestment;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}
	
	public void selectIncomeSource() {
		Common.screenshot("Landed on Source of Income screen successfully.");
		btnInvestment.click();
		btnContinue.click();
		
	}

}
