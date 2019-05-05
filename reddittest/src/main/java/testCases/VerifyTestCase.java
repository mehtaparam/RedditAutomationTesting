package testCases;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import constants.StaticConfiguration;
import constants.TestData;
import pageElements.DashboardPageElements;
import pageElements.LoginPageElements;
import utilities.CommanUtilities;
import utilities.SeleniumUtilities;

public class VerifyTestCase extends SeleniumUtilities {

	public void verifyLogin() {
		// To verify user is logged in successfully or not using user name before
		// proceeding further
		if (waitForRequiredElement(
				getRunTimeWebElement("Verify Username", "xpath", "//div[text()='" + TestData.USER_NAME + "']"),
				StaticConfiguration.GENERAL_WAIT_SECONDS)) {
				CommanUtilities.logCreator(CommanUtilities.LogStatus.Pass, "User " + TestData.USER_NAME + " Logged in sucessfully");
				System.out.println("User " + TestData.USER_NAME + " Logged in sucessfully");
		} else {
			// It will try to identify possible error message invalid username and password
			// only if CHECK_FOR_ERRORS is true
			if (StaticConfiguration.CHECK_FOR_ERRORS) {
				if (waitForWebPageElement(LoginPageElements.incorrectUserNameErrorMessage,
						StaticConfiguration.ERROR_MSG__WAIT_SECONDS)) {
					Assert.fail(LoginPageElements.incorrectUserNameErrorMessage.getName());
				}
				if (waitForWebPageElement(LoginPageElements.incorrectPasswordErrorMessage,
						StaticConfiguration.ERROR_MSG__WAIT_SECONDS)) {
					Assert.fail(LoginPageElements.incorrectPasswordErrorMessage.getName());
				}
			}
			else {
				Assert.fail("User is not logged in");	
			}
		}
	}
}
