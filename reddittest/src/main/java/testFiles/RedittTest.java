package testFiles;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import constants.ConfigConstants;
import constants.TestData;

import io.github.bonigarcia.wdm.WebDriverManager;
import model.Post;
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
		driver.get(TestData.BASE_URL);
	}

	@BeforeMethod
	public void setup() {

	}

	@Test(priority = 1, enabled = false)
	public void testLogin() throws Exception {
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
				clickWithCtrl(LoginPageElements.signInButton);

				// To verify user is logged in successfully or not using user name before
				// proceeding further
				if (waitForRequiredElement(
						getRunTimeWebElement("Verify Username", "xpath", "//div[text()='" + TestData.USER_NAME + "']"),
						ConfigConstants.GENERAL_WAIT_SECONDS)) {
					System.out.println("User " + TestData.USER_NAME + " Logged in sucessfully");
				} else {
					// It will try to identify possible error message invalid username and password
					// only if CHECK_FOR_ERRORS is true
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
					fail("User is not logged in");
				}
			}
		}
	}

	@Test(priority = 2, enabled = true)
	public void getSortedPosts() {
		click(DashboardPageElements.sortDropdown);
		DashboardPageElements.sortDropdownOptionArrayList = getWebPageElements(
				DashboardPageElements.sortDropdownOptions);
		ConfigConstants.CATEGORIES_COUNT = DashboardPageElements.sortDropdownOptionArrayList.size();
		System.out.println("Categories Count" + DashboardPageElements.sortDropdownOptionArrayList.size());
		click(DashboardPageElements.sortDropdown);

		System.out.println("Drop down shoud closed");

		// This loop will help us to click on categories one by one
		for (int count = 0; count < ConfigConstants.CATEGORIES_COUNT; count++) {
			if (waitForElement(DashboardPageElements.sortDropdownOptionArrayList.get(count), 3)) {
				System.out.println("Click on Sort Dropdown");
				System.out.println(DashboardPageElements.sortDropdownOptionArrayList.get(count).getValue());
				click(DashboardPageElements.sortDropdownOptionArrayList.get(count));
			} else {
				System.out.println("Click on Sort Dropdown");
				System.out.println(DashboardPageElements.sortDropdownOptionArrayList.get(count).getValue());
				click(DashboardPageElements.sortDropdown);
				click(DashboardPageElements.sortDropdownOptionArrayList.get(count));
			}

			// For a now i have added thread but i will find better solution for page to
			// load
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			DashboardPageElements.postsArrayList = getWebPageElements(DashboardPageElements.postsContainer);
			System.out.println("Post Count " + DashboardPageElements.postsArrayList.size());

			// Now we have all the posts web page elements in array to have a loop and
			// access the, one by one
			for (int postCounter = 0; postCounter < ConfigConstants.MAX_POST_COUNT; postCounter++) {

				clickWithCtrl(DashboardPageElements.postsArrayList.get(postCounter));

				// moveToTab(1);

				/*
				 * if (waitForElement(DashboardPageElements.subReddit, 10)) {
				 * System.out.println("Sub Reddit" + getText(DashboardPageElements.subReddit));
				 * }
				 * 
				 * else { System.out.println("Not able to find SubRedit"); }
				 */
								/*
				 * WebElement parentElement =
				 * getWebElement(DashboardPageElements.postsArrayList.get(postCounter));
				 * 
				 * WebDriverWait wait = new WebDriverWait(driver, 5);
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(getBy(
				 * DashboardPageElements.promoted))); waitForElement
				 * 
				 * if() {
				 * 
				 * 
				 * System.out.println("Promoted " +
				 * getChildWebElement(DashboardPageElements.promoted,
				 * DashboardPageElements.postsArrayList.get(postCounter)).getText()); } else {
				 * 
				 * }
				 */
				// driver.switchTo().window(closeTab(1));

				// moveToTab(0);

				System.out.println("User Name " + getChildWebElement(DashboardPageElements.redditUserName,
						DashboardPageElements.postsArrayList.get(postCounter)).getText());
				System.out.println("Upvotes   " + getChildWebElement(DashboardPageElements.upVotes,
						DashboardPageElements.postsArrayList.get(postCounter)).getText());

				// I will add more elements
			}
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		}
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed");
		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("Skipped");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("Success");
		}
	}

	@AfterSuite
	public void teardown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
}
