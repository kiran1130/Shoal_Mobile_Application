package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class ReviewVideo {
	public AppiumDriver driver;

	public ReviewVideo(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}


	@FindBy (xpath = "//android.view.View[@content-desc=\"Upload video\"]")
	private WebElement btnUpload;

	public WebElement getBtnUpload() {
		return btnUpload;
	}
	
	public void uploadVideo() {
		btnUpload.click();
	}

}
