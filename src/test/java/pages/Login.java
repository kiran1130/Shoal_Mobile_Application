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

public class Login{

	public AppiumDriver driver;

	public Login(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy (className = "android.widget.EditText")
	private WebElement txtMobileNumber;

	@FindBy (xpath = "//android.view.View[@content-desc=\"Login\"]")
	private WebElement btnLogin;

	public WebElement getTxtMobileNumber() {
		return txtMobileNumber;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}


	public void login() {
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
		
		txtMobileNumber.click();
		txtMobileNumber.sendKeys(prop.getProperty("mobileNumber"));
		Common.screenshot("Entered Mobile number.");
		btnLogin.click();
		Common.enterPIN(); //PIN Entered
		

	}

}
