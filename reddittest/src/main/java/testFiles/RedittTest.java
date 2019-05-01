package testFiles;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import constants.ConfigConstants;
import constants.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageElements.DashboardPageElements;
import pageElements.LoginPageElements;
import utilities.SeleniumUtilities;

/**
 * @author Param R Mehta 1st May, 2019
 *
 */

public class RedittTest extends SeleniumUtilities {

	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private ChromeOptions options;

	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void testLogin() throws Exception {
		//driver.get(TestData.BASE_URL);

		driver.navigate().to(TestData.BASE_URL);
		// Let's wait till we found Login option in dashboard
		if (waitForRequiredElement(DashboardPageElements.loginHeaderOption, ConfigConstants.GENERAL_WAIT_SECONDS)) {

			click(DashboardPageElements.loginHeaderOption); // Click on Login Option

			if (waitForRequiredElement(LoginPageElements.loginFrame, ConfigConstants.GENERAL_WAIT_SECONDS)) {

				// We need to switch frame to access elements with it
				switchToFrameByElemenet(LoginPageElements.loginFrame);

				// We will enter Login Credentials
				setText(LoginPageElements.userNameField, TestData.USER_NAME);
				setText(LoginPageElements.passwordField, TestData.PASSWORD);

				// After enter Credentials let's try to Login by clicking Login Button
				click(LoginPageElements.signInButton);

				
				// It will try to identify possible error message invalid username and password only if CHECK_FOR_ERRORS is true 
				if (ConfigConstants.CHECK_FOR_ERRORS) {
					if (waitForElement(LoginPageElements.incorrectUserNameErrorMessage,
							ConfigConstants.ERROR_MSG__WAIT_SECONDS)) {
						fail(LoginPageElements.incorrectUserNameErrorMessage.getName());
					}
					if (waitForElement(LoginPageElements.incorrectPasswordErrorMessage,
							ConfigConstants.ERROR_MSG__WAIT_SECONDS)) {
						fail(LoginPageElements.incorrectPasswordErrorMessage.getName());
					}
				}

				// To verify user is logged in successfully or not using user name before proceeding further
				if (waitForRequiredElement(getRunTimeWebElement("Verify Username", "xpath", "//div[text()='"+TestData.USER_NAME+"']"), ConfigConstants.GENERAL_WAIT_SECONDS)) {
					System.out.println("User " + TestData.USER_NAME + " Logged in sucessfully");
				}
				else
				{
					fail("User is not logged in");
				}
			}
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	/*
	 * @AfterSuite public void teardown() { if (driver != null) { driver.close();
	 * driver.quit(); } }
	 */
}
