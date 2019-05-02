package pageElements;

import java.util.ArrayList;

import model.WebPageElements;

public class DashboardPageElements {
	public static WebPageElements loginHeaderOption = new WebPageElements("Login Header Option", "xpath", "//a[contains(text(),'log in')]");
	public static WebPageElements userDropdown = new WebPageElements("User Name Field", "id", "USER_DROPDOWN_ID");
	
	//For sort dropdown
	public static WebPageElements sortDropdown = new WebPageElements("Sort Dropdown", "xpath", "//button[@id=\"ListingSort--SortPicker\"]");
	public static WebPageElements sortDropdownOptions = new WebPageElements("Sort Dropdown Options","xpath","//a[@role=\"menuitem\"]");
	public static ArrayList<WebPageElements> sortDropdownOptionArrayList;
	
	//For Posts
	public static WebPageElements postsContainer = new WebPageElements("Post Container","xpath","//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[2]/div/div/div/div[2]/div[4]/div[1]/div[1]/div");
	public static ArrayList<WebPageElements> postsArrayList;
	
	
	////*[@id="SHORTCUT_FOCUSABLE_DIV"]/div[2]/div/div/div/div[2]/div[4]/div[1]/div[1]/div[1]//descendant::button//following-sibling::div
	public static WebPageElements redditUserName = new WebPageElements("Reddit Username", "xpath", ".//a[contains(text(),'u/')]");
	
	public static WebPageElements upVotes = new WebPageElements("Upvotes", "xpath", ".//button//following-sibling::div[1]");
}
