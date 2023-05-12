package pages;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import testListeners.MainListener;
import utilities.Common;

public class TermsAndConditions {
	public AppiumDriver driver;

	public TermsAndConditions(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}


	@FindBy (xpath = "//android.view.View[@content-desc=\"Terms & Conditions\"]")
	private WebElement txtPageLabel;

	@FindBy (xpath = "//android.widget.ImageView[@content-desc=\"I'd like to receive personalised updates \"]")
	private WebElement radioBtnConsent;

	@FindBy (xpath = "//android.view.View[@content-desc=\"Accept\"]")
	private WebElement btnAccept;

	@FindBy(xpath = "//android.view.View[@content-desc=\"By clicking accept you are agreeing to these Terms and Conditions.\"]")
	private WebElement finalText;

	public void acceptTermsAndConditions() throws InterruptedException {
		ProfileConfirmation pf = new ProfileConfirmation(MainListener.getDriver());
		WebElement letsGo = pf.getBtnLetsGo();

		btnAccept.click();
		Thread.sleep(5000);
		System.out.println("Let's Go button displayed: "+letsGo.isDisplayed()); 
		Common.screenshot("Landed on Confirmation screen.");

	}

	public void swipeUp() throws InterruptedException {

		
		WebElement source = driver.findElements(By.className("android.widget.ImageView")).get(0);
		Rectangle sourceElementRect = source.getRect();
		int centerX = sourceElementRect.x+(sourceElementRect.width/2);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence dragNDrop = new Sequence(finger, 1);
		dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(0),
				PointerInput.Origin.viewport(), centerX, 1000));
		dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700),
				PointerInput.Origin.viewport(),centerX, 1));
		dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(dragNDrop));

	}


}
