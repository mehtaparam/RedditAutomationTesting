package testSuit;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.model.ScreenCapture;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import constants.StaticConfiguration;
import constants.TestData;

import io.github.bonigarcia.wdm.WebDriverManager;
import model.Post;
import pageElements.DashboardPageElements;
import pageElements.LoginPageElements;
import testCases.LoginTestCase;
import testCases.ReadPostsTestCase;
import testCases.VerifyTestCase;
import utilities.CommanUtilities;
import utilities.Screenshot;
import utilities.SeleniumUtilities;


/**
 * @author Param R Mehta 1st May, 2019
 *
 */

public class RedittTest extends SeleniumUtilities {

	private String baseUrl;
	private ChromeOptions options;

	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--disable-notifications");
		StaticConfiguration.WEB_DRIVER = new ChromeDriver(options);
		StaticConfiguration.WEB_DRIVER.manage().window().maximize();
		StaticConfiguration.WEB_DRIVER.get(TestData.BASE_URL);
		
		
		
		String htmlReportPath = StaticConfiguration.OUTPUT_DIRECTORY + "\\" + StaticConfiguration.HTML_REPORT_DIRECTORY
				+ "\\" + Screenshot.date() + "\\" + "index.html"; 

		StaticConfiguration.EXTENT_HTML_REPORTER = new ExtentHtmlReporter(htmlReportPath); // Initialize HTML Reporter using defined path
		StaticConfiguration.EXTENT_REPORTS = new ExtentReports();
		StaticConfiguration.EXTENT_REPORTS.attachReporter(StaticConfiguration.EXTENT_HTML_REPORTER); // Attach HTML Reporter
		StaticConfiguration.SCREEN_CAPTURE = new ScreenCapture(); // Initialize screen capture for CV

	}

	@BeforeMethod
	public void setup() {

	}

	@Test(priority = 1, enabled = true)
	public void testLogin() throws Exception {
	
		StaticConfiguration.SCREEN_CAPTURE.setName("Login Functionality");
		StaticConfiguration.EXTENT_TEST = StaticConfiguration.EXTENT_REPORTS.createTest("Login Functionality");	
		new LoginTestCase().doLogin();
		
	}

	@Test(priority = 2, enabled = true)
	public void verifyLogin() throws Exception {

		StaticConfiguration.SCREEN_CAPTURE.setName("Login Verification");
		StaticConfiguration.EXTENT_TEST = StaticConfiguration.EXTENT_REPORTS.createTest("Login Verification");
		new VerifyTestCase().verifyLogin();
		
	}

	@Test(priority = 3, enabled = true)
	public void readPosts() {
		
		StaticConfiguration.SCREEN_CAPTURE.setName("Read Posts");
		StaticConfiguration.EXTENT_TEST = StaticConfiguration.EXTENT_REPORTS.createTest("Read Posts");
		new ReadPostsTestCase().readPosts();
		
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			CommanUtilities.logCreator(CommanUtilities.LogStatus.Fail, "Test Case Failed");
			System.out.println("Test Case Failed");
		} else if (result.getStatus() == ITestResult.SKIP) {
			CommanUtilities.logCreator(CommanUtilities.LogStatus.Skip, "Test Case Skipped");
			System.out.println("Test Case Skipped");
		} else if (result.getStatus() == ITestResult.SUCCESS) 
			CommanUtilities.logCreator(CommanUtilities.LogStatus.Pass, "Test Case Passed Successfylly");{
			System.out.println("Test Case Passed Successfylly");
		}
	}

	@AfterSuite
	public void teardown() {
		
		if (StaticConfiguration.POSTS_ARRAY.size() > 0) {
			// Write JSON file
			try {
				
				FileWriter file = new FileWriter(StaticConfiguration.OUTPUT_DIRECTORY 
						+ "\\" + StaticConfiguration.HTML_REPORT_DIRECTORY 
						+ "\\" + Screenshot.date() 
						+ "\\"+"posts.json");
				
				file.write(StaticConfiguration.POSTS_ARRAY.toJSONString());
				file.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		StaticConfiguration.WEB_DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		StaticConfiguration.EXTENT_REPORTS.flush();
		
		System.out.println(StaticConfiguration.POSTS_ARRAY.toString());

		if (StaticConfiguration.WEB_DRIVER != null) {
			StaticConfiguration.WEB_DRIVER.close();
			StaticConfiguration.WEB_DRIVER.quit();
		}
	}
}
