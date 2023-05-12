package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.Biometrics;
import pages.Email;
import pages.Logout;
import pages.MobileNumber;
import pages.Name;
import pages.Notifications;
import pages.OTP;
import pages.ProfileConfirmation;
import pages.SecurityPIN;
import pages.ShoalUserWelcome;
import pages.TermsAndConditions;
import pages.Welcome;
import testListeners.MainListener;
import utilities.Common;
import utilities.Helper;


@Listeners(testListeners.MainListener.class)
public class SignUp {
	@Test
	public static void signUp() throws InterruptedException {
		Welcome pfWelcomePage = new Welcome(MainListener.getDriver());
		Name pfNamePage = new Name(MainListener.getDriver());
		MobileNumber pfMobNumberPage = new MobileNumber(MainListener.getDriver());
		OTP pfOTP = new OTP(MainListener.getDriver());
		Email pfEmailPage = new Email(MainListener.getDriver());
		SecurityPIN pfSecurityPIN = new SecurityPIN(MainListener.getDriver());
		Biometrics pfBiometricsPage = new Biometrics(MainListener.getDriver());
		Notifications pfNotifications = new Notifications(MainListener.getDriver());
		TermsAndConditions pfTnCPage= new TermsAndConditions(MainListener.getDriver());
		ProfileConfirmation pfProfileConfirm = new ProfileConfirmation(MainListener.getDriver());
		ShoalUserWelcome pfShoalWelcome = new ShoalUserWelcome(MainListener.getDriver());
		Logout pfLogout = new Logout(MainListener.getDriver());
		
		
		//Tap on Sign Up link
		pfWelcomePage.clickSignUp();

		//Entering Name of the user.
		pfNamePage.enterName();
		pfNamePage.tapOnContinue();

		//Entering Mobile number and OTP
		String mobNumber = Helper.generateMobileNumber();
		pfMobNumberPage.enterMobNumber("77888"+mobNumber);
		
		pfOTP.enterOTP();

		//Entering Email and OTP
		pfEmailPage.enterEmail("kiran@mailinator.com");
		pfOTP.enterOTP();

		//Setting security PIN and Confirming the same
		pfSecurityPIN.setNewPIN(); //Setting new PIN as 123456
		pfSecurityPIN.confirmPIN();

		//declining the Biometrics request
		pfBiometricsPage.doItLater();

		//Declining the Notification request
		pfNotifications.doItLater();
		
		
		//Swipe Up the Terms and Conditions screen
		Common.screenshot("Landed on TnC screen successfully.");
		for(int i=0; i<50; i++) {
			pfTnCPage.swipeUp();
			Thread.sleep(300);
		}

		pfTnCPage.acceptTermsAndConditions();

		//Tapping Let's go on Confirmation screen
		pfProfileConfirm.clickOnLetsGo();

		pfShoalWelcome.clickOnExploreApp();

		Thread.sleep(3000);
		
		
		//logging Out
		pfLogout.logout();

	}
	
}
