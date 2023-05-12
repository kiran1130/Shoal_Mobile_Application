package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utilities.Common;

public class KycIntro {

	public AppiumDriver driver;

	public KycIntro(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}


	@FindBy (xpath = "//android.view.View[@content-desc=\"Understood, let's go\"]")
	private WebElement btnLetsGo;

	public WebElement getBtnLetsGo() {
		return btnLetsGo;
	}
	
	public void clickOnLetsGo() {
		Common.screenshot("Landed on KYC Intro screen successfully.");
		btnLetsGo.click();
	}
	
}
