package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utilities.Common;

public class CurrentAddress {
	
	public AppiumDriver driver;

	public CurrentAddress(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Postcode House number\"]/android.widget.EditText[1]")
	private WebElement txtPostCode;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Continue\"]")
	private WebElement btnContinue;
	
	@FindBy (xpath = "//android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[2]")
	private WebElement selectAddress;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Yes\"]")
	private WebElement btnYes;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Confirm\"]")
	private WebElement btnConfirm;

	public WebElement getTxtPostCode() {
		return txtPostCode;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public WebElement getSelectAddress() {
		return selectAddress;
	}

	public WebElement getBtnYes() {
		return btnYes;
	}

	public WebElement getBtnConfirm() {
		return btnConfirm;
	}
	
	public void submitAddress() {
		Common.screenshot("Landed on Current address screen successfully.");
		Properties prop = new Properties();
		FileInputStream ip;
		
		try {
			ip = new FileInputStream("./src/resources/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		txtPostCode.click();
		txtPostCode.sendKeys(prop.getProperty("postCode"));
		Common.screenshot("Entered Post code successfully.");
		btnContinue.click();
		selectAddress.click();
		Common.screenshot("Selected Address successfully.");
		btnContinue.click();
		btnYes.click();
		Common.screenshot("Landed on Review screen successfully."); 
		btnConfirm.click();
	}

}
