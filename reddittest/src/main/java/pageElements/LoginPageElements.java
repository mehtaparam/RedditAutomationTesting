package pageElements;

import model.WebPageElements;

public class LoginPageElements {	
	public static WebPageElements loginFrame = new WebPageElements("Login Frame", "xpath", "//iframe[@src='https://www.reddit.com/login/']");
	public static WebPageElements userNameField = new WebPageElements("User Name Field", "xpath", "//*[@id='loginUsername']");
	public static WebPageElements passwordField = new WebPageElements("Password Field","xpath", "//*[@id='loginPassword']");
	
	public static WebPageElements incorrectUserNameErrorMessage = new WebPageElements("Incorrect Username Error","xpath", "//div[text()='Incorrect username or password']");
	public static WebPageElements incorrectPasswordErrorMessage = new WebPageElements("Incorrect Password Error","xpath", "//div[text()='Incorrect password']");

	public static WebPageElements signInButton = new WebPageElements("Login Button", "xpath", "//button[text()='Sign in']");

}
