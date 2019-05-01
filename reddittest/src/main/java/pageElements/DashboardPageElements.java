package pageElements;

import model.WebPageElements;

public class DashboardPageElements {
	public static WebPageElements loginHeaderOption = new WebPageElements("Login Header Option", "xpath", "//a[contains(text(),'log in')]");
	public static WebPageElements userDropdown = new WebPageElements("User Name Field", "id", "USER_DROPDOWN_ID");
	
}
