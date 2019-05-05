package testCases;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;

import constants.StaticConfiguration;
import constants.TestData;
import pageElements.DashboardPageElements;
import pageElements.LoginPageElements;
import utilities.CommanUtilities;
import utilities.SeleniumUtilities;

public class LoginTestCase extends SeleniumUtilities{
	
	public void doLogin(){
		// Let's wait till we found Login option in dashboard
		if (waitForRequiredElement(DashboardPageElements.loginHeaderOption, StaticConfiguration.GENERAL_WAIT_SECONDS)) {

			click(DashboardPageElements.loginHeaderOption); // Click on Login Option

			if (waitForRequiredElement(LoginPageElements.loginFrame, StaticConfiguration.GENERAL_WAIT_SECONDS)) {

				// We need to switch frame to access elements with it
				switchToFrameByElemenet(LoginPageElements.loginFrame);

				// We will enter Login Credentials
				setText(LoginPageElements.userNameField, TestData.USER_NAME);
				setText(LoginPageElements.passwordField, TestData.PASSWORD);
				click(LoginPageElements.signInButton);
					
				// After enter Credentials let's try to Login by clicking Login Button
			
				CommanUtilities.logCreator(3, "User Credentials Entered");
			}
		}
	}
}
