package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import testListeners.MainListener;
import utilities.Common;

public class SecurityPIN {
	public AppiumDriver driver;
	public int i;

	public SecurityPIN(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//android.widget.Button[@content-desc=\"Reset PIN\"]")
	private WebElement lnkResetPin;
	
	
	public WebElement getLnkResetPin() {
		return lnkResetPin;
	}

	//Setting new security PIN 123456
	public void setNewPIN() {
		for(int i=1;i<7;i++) {
			MainListener.getDriver().findElement(By.xpath("//android.view.View[@content-desc=\""+i+"\"]")).click();
		}
		Common.screenshot("PIN entered successfully.");
	}
	
	public void confirmPIN() {
				
		for(int i=1;i<7;i++) {
			MainListener.getDriver().findElement(By.xpath("//android.view.View[@content-desc=\""+i+"\"]")).click();
		}
		Common.screenshot("PIN confirmed successfully.");
		
	}
}
