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
	
	//public static WebPageElements catagoryName = new WebPageElements("Catagory Name", "xpath", "//div[contains(text(),'Sort')]/following-sibling::div/button/span");
	
	public static WebPageElements catagoryName = new WebPageElements("Catagory Name", "xpath", "//button[@id=\"ListingSort--SortPicker\"]/span");
	

	
	public static WebPageElements upVotes = new WebPageElements("Upvotes", "xpath", ".//button//following-sibling::div[1]");
	
	public static WebPageElements title = new WebPageElements("Title", "xpath", ".//h2"); 	
	
	//public static WebPageElements subReddit = new WebPageElements("Subreddit", "xpath", "img[@role=\"presentation\"]/following-sibling::a/span");	
	public static WebPageElements subReddit = new WebPageElements("Subreddit", "xpath", "//a[contains(text(),'r/')]");
	
	public static WebPageElements imageElement = new WebPageElements("Image Element", "xpath", ".//img[contains(@class,'media-element')]");

	public static WebPageElements videoElement = new WebPageElements("Video Element", "xpath", ".//video[contains(@class,'HTML5StreamPlayer__video__regular')]");
		
	public static WebPageElements promoted = new WebPageElements("Promoted", "xpath", ".//span[text()='promoted']/following-sibling::span[@role=\"presentation\"]");
	
	public static WebPageElements overlayScrollContainer = new WebPageElements("overlayScrollContainer", "id", "overlayScrollContainer");
	
	public static WebPageElements paragraphText = new WebPageElements("Paragraph Div for Post's Text", "xpath", ".//div[@data-click-id='text']/div/p");
	
	public static ArrayList<WebPageElements> paragraphTextArrayList;
	//
	
	//div/div/button/div/i[contains(@class,'icon')]
	//div[contains(text(),'Sort')]/parent:://button[]
	
	
}
