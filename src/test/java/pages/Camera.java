package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utilities.Common;

public class Camera {
	
	public AppiumDriver driver;

	public Camera(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//android.widget.Button[4]")
	private WebElement btnCamera;
	
	@FindBy (xpath = "//android.widget.Button[2]")
	private WebElement btnCancel;

	public WebElement getBtnCamera() {
		return btnCamera;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}
	
	public void capturePhoto() {
		Common.screenshot("Landed on Camera screen successfully.");
		btnCamera.click();
	}
	
	

}
