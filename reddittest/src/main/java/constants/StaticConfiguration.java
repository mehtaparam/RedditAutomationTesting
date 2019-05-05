package constants;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.ScreenCapture;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import model.Post;

public class StaticConfiguration {
	/*
	 * These Constants will be used to configure and/or store required values
	 */
	public static int MAX_POST_COUNT = 5;   // It will be used to define Maximum Post you want from each categories
	public static int GENERAL_WAIT_SECONDS = 30 ; // It will be used to define and/or get general wait seconds 
	public static int ERROR_MSG__WAIT_SECONDS = 3 ; // It will be used to define and/or get general wait seconds
	
	public static String OUTPUT_DIRECTORY = "TestResults";
	public static String HTML_REPORT_DIRECTORY = "Report";
	public static String SCREENSHOT_DIRECTORY = "Screenshots";
	
	
	public static WebDriver WEB_DRIVER;
	public static ScreenCapture SCREEN_CAPTURE;
	public static ExtentHtmlReporter EXTENT_HTML_REPORTER;
	public static ExtentTest EXTENT_TEST;
	public static ExtentReports EXTENT_REPORTS;
	
	
	public static int SHORT_WAIT = 5;
	
	public static String CATEGORY_NAME = "";
	
	//public static ArrayList<Post> CURRENT_POSTS = new ArrayList<Post>;
	//public static ArrayList<Post> TOTAL_POSTS = new ArrayList<Post>();
	
	public static Gson GSON = new Gson();

	public static Gson GSON_PREETY_JSON = new GsonBuilder().setPrettyPrinting().create();

	
	public static JSONArray POSTS_ARRAY = new JSONArray();
	
	/*
	 * It should be true before doing negative testing
	 */
	public static boolean CHECK_FOR_ERRORS = true; // Our program will only try to identify error messages if we set true value
}
