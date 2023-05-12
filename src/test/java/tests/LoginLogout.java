package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.Login;
import pages.Logout;
import pages.Welcome;
import testListeners.MainListener;


@Listeners(testListeners.MainListener.class)
public class LoginLogout {
	
	private static Login pfLogin;
	private static Welcome pfWelcomePage;
	private static Logout pfLogout;
	
	@Test
	public static void loginLogout() {
		pfLogin = new Login(MainListener.getDriver());
		pfWelcomePage = new Welcome(MainListener.getDriver());
		pfLogout = new Logout(MainListener.getDriver());

		pfWelcomePage.clickLoginLnk();
		pfLogin.login(); //Login as existing user
		pfLogout.logout(); //Logout as existing user
	}
}
