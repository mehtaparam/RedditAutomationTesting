package testCases;

import static org.testng.Assert.fail;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.google.gson.stream.JsonWriter;

import constants.StaticConfiguration;
import constants.TestData;
import model.Post;
import pageElements.DashboardPageElements;
import pageElements.LoginPageElements;
import utilities.CommanUtilities;
import utilities.SeleniumUtilities;

public class ReadPostsTestCase extends SeleniumUtilities {

	public void readPosts() {

		click(DashboardPageElements.sortDropdown);
		DashboardPageElements.sortDropdownOptionArrayList = getWebPageElements(
				DashboardPageElements.sortDropdownOptions);

		System.out.println("******************************************************");
		System.out.println("Total Categories: " + DashboardPageElements.sortDropdownOptionArrayList.size());
		System.out.println("******************************************************");

		CommanUtilities.logCreator(CommanUtilities.LogStatus.Info,
				"Total Categories: " + DashboardPageElements.sortDropdownOptionArrayList.size());

		click(DashboardPageElements.sortDropdown);

		try {
			// StaticConfiguration.WebDriver.wait(5000);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// This loop will help us to click on categories one by one
		for (int count = 0; count < DashboardPageElements.sortDropdownOptionArrayList.size(); count++) {

			if (waitForWebPageElement(DashboardPageElements.sortDropdownOptionArrayList.get(count),
					StaticConfiguration.SHORT_WAIT)) {
				click(DashboardPageElements.sortDropdownOptionArrayList.get(count));
			} else {
				click(DashboardPageElements.sortDropdown);
				if (waitForWebPageElement(DashboardPageElements.sortDropdownOptionArrayList.get(count),
						StaticConfiguration.SHORT_WAIT)) {
					click(DashboardPageElements.sortDropdownOptionArrayList.get(count));
				}
			}

			// For a now I have added thread but i will find better solution for page
			try {
				// StaticConfiguration.WebDriver.wait(5000);
				Thread.sleep(StaticConfiguration.MAX_POST_COUNT * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			StaticConfiguration.CATEGORY_NAME = getText(DashboardPageElements.catagoryName);

			System.out.println();
			System.out.println();
			System.out.println("******************************************************");
			System.out.println("Category Name :" + StaticConfiguration.CATEGORY_NAME);
			System.out.println("******************************************************");
			System.out.println();

			CommanUtilities.logCreator(CommanUtilities.LogStatus.Info,
					"Category Name :" + StaticConfiguration.CATEGORY_NAME);

			DashboardPageElements.postsArrayList = getWebPageElements(DashboardPageElements.postsContainer);
			// Now we have all the posts web page elements in array to have a loop and
			// access the, one by one
			for (int postCounter = 0; postCounter < StaticConfiguration.MAX_POST_COUNT; postCounter++) {

				Post post = new Post();

				post.setPostID(StaticConfiguration.POSTS_ARRAY.size() + 1);
				post.setCatagory(StaticConfiguration.CATEGORY_NAME);

				if ((getChildWebElement(DashboardPageElements.title,
						DashboardPageElements.postsArrayList.get(postCounter))) != null) {
					post.setTitle(getChildWebElement(DashboardPageElements.title,
							DashboardPageElements.postsArrayList.get(postCounter)).getText());
				}

				if ((getChildWebElement(DashboardPageElements.redditUserName,
						DashboardPageElements.postsArrayList.get(postCounter))) != null) {
					post.setUserName(getChildWebElement(DashboardPageElements.redditUserName,
							DashboardPageElements.postsArrayList.get(postCounter)).getText());
				}

				if ((getChildWebElement(DashboardPageElements.subReddit,
						DashboardPageElements.postsArrayList.get(postCounter))) != null) {
					post.setSubReddit(getChildWebElement(DashboardPageElements.subReddit,
							DashboardPageElements.postsArrayList.get(postCounter)).getText());
				}

				if ((getChildWebElement(DashboardPageElements.imageElement,
						DashboardPageElements.postsArrayList.get(postCounter))) != null) {
					post.setMediaType("Image");
					post.setMediaURL(getChildWebElement(DashboardPageElements.imageElement,
							DashboardPageElements.postsArrayList.get(postCounter)).getAttribute("src"));
				} else if ((getChildWebElement(DashboardPageElements.videoElement,
						DashboardPageElements.postsArrayList.get(postCounter))) != null) {
					post.setMediaType("Video");
					post.setMediaURL(getChildWebElement(DashboardPageElements.videoElement,
							DashboardPageElements.postsArrayList.get(postCounter)).getAttribute("src"));
				}

				post.setText(getParagraphText(DashboardPageElements.postsArrayList.get(postCounter)));

				if ((getChildWebElement(DashboardPageElements.upVotes,
						DashboardPageElements.postsArrayList.get(postCounter))) != null) {
					post.setUpVotes(getChildWebElement(DashboardPageElements.upVotes,
							DashboardPageElements.postsArrayList.get(postCounter)).getText());
				}
				// I will add more elements

				System.out.println();
				System.out.println("*******************  POST " + post.getPostID() + "  **********************");
				System.out.println(StaticConfiguration.GSON_PREETY_JSON.toJson(post).toString());

				StaticConfiguration.EXTENT_TEST
						.info("Post "+post.getPostID()+"'s JSON <br><pre>" + StaticConfiguration.GSON_PREETY_JSON.toJson(post) + "</pre>");

				StaticConfiguration.POSTS_ARRAY.add(StaticConfiguration.GSON.toJson(post));
			}
			((JavascriptExecutor) StaticConfiguration.WEB_DRIVER)
					.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		}
	}
}
