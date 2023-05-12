package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utilities.Common;

public class ProfileDetails {

	public AppiumDriver driver;

	public ProfileDetails(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}


//	@FindBy (className =  "android.widget.ImageView")
//	private selectTitle;
	
	@FindBy (xpath = "//android.widget.SeekBar[@content-desc=\"Mrs\"]")
	private WebElement titleValue;
	
	@FindBy (xpath = "//android.view.View[2]")
	private WebElement emptySpace;
	
	@FindBy (xpath = "//android.widget.EditText[3]")
	private WebElement txtLastName;
	
	@FindBy (xpath = "//android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[3]")
	private WebElement btnContinue;

	private WebElement getSelectTitle() {
		List<WebElement> selectTitle = driver.findElements(By.className("android.widget.ImageView"));
		return selectTitle.get(1);
	}

	private WebElement getTitleValue() {
		return titleValue;
	}

	public WebElement getEmptySpace() {
		return emptySpace;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public void enterProfileDetails() throws InterruptedException {
		Common.screenshot("Landed on Profile details screen successfully.");
		Thread.sleep(2000);
		getSelectTitle().click();
		
		getTitleValue().click();
		emptySpace.click();
		Common.screenshot("Selected title.");
		txtLastName.click();
		txtLastName.sendKeys(utilities.Helper.generateLastName());
		Common.screenshot("Entered Last name successfully.");
		btnContinue.click();
		Thread.sleep(3000);
		
	}
	
	
	
}
