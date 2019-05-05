package utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import constants.StaticConfiguration;
import model.WebPageElements;
import pageElements.DashboardPageElements;

public class SeleniumUtilities {


	public void closeAllTabs() {
		String originalHandle = StaticConfiguration.WEB_DRIVER.getWindowHandle();
		// Do something to open new tabs

		for (String handle : StaticConfiguration.WEB_DRIVER.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				StaticConfiguration.WEB_DRIVER.switchTo().window(handle);
				StaticConfiguration.WEB_DRIVER.close();
			}
		}
		StaticConfiguration.WEB_DRIVER.switchTo().window(originalHandle);
	}
	
	public String closeTab(int index) {
		String basicHandle = "";
		int counter=0;
		for (String handle : StaticConfiguration.WEB_DRIVER.getWindowHandles()) {
			if(counter == 0) {
				 basicHandle = StaticConfiguration.WEB_DRIVER.getWindowHandle();
			}
			else if (counter == index) {
				StaticConfiguration.WEB_DRIVER.switchTo().window(handle);
				StaticConfiguration.WEB_DRIVER.close();
			}
			System.out.println("Colse TAB Counter " + counter);
			counter++;
		}
		System.out.println("First Window Handler " + basicHandle);
		return basicHandle;
	}

	public void moveToTab(int index) {
		int counter=0;
		for (String handle : StaticConfiguration.WEB_DRIVER.getWindowHandles()) {
			if (counter == index) {
				StaticConfiguration.WEB_DRIVER.switchTo().window(handle);
			}
			System.out.println("Move Tab Counter " + counter);
			counter++;
		}
	}

	public void closeCurrentTAB() {
		try {
			Actions action = new Actions(StaticConfiguration.WEB_DRIVER);
			action.keyDown(Keys.CONTROL).sendKeys("W").build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickWithCtrl(WebPageElements ele) {

		try {
			WebElement element = getWebElement(ele);
			Actions builder = new Actions(StaticConfiguration.WEB_DRIVER);
			Action seriesOfActions = builder.keyDown(Keys.CONTROL).click(element).build();
			seriesOfActions.perform();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Not able to click " + ele.getName());
		}

	}

	public By getBy(WebPageElements element) {
		By by = null;
		try {
			if (element.getLocator().equalsIgnoreCase("xpath")) {
				by = By.xpath(element.getValue());
			} else if (element.getLocator().equalsIgnoreCase("id")) {
				by = By.id(element.getValue());
			} else if (element.getLocator().equalsIgnoreCase("name")) {
				by = By.name(element.getValue());
			} else if (element.getLocator().equalsIgnoreCase("linktext")) {
				by = By.linkText(element.getValue());
			} else if (element.getLocator().equalsIgnoreCase("partiallinktext")) {
				by = By.partialLinkText(element.getValue());
			} else if (element.getLocator().equalsIgnoreCase("classname")) {
				by = By.className(element.getValue());
			} else if (element.getLocator().equalsIgnoreCase("tagname")) {
				by = By.tagName(element.getValue());
			} else if (element.getLocator().equalsIgnoreCase("css")) {
				by = By.cssSelector(element.getValue());
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Not able to find get By " + element.getName());
			// Assert.fail();
		}
		if (by == null) {
			Assert.fail("Not able to find get By " + element.getName());
		}
		return by;
	}

	public WebElement getWebElement(WebPageElements element) {
		WebElement ele = null;
		try {
			if (element.getLocator().equalsIgnoreCase("xpath")) {
				ele = StaticConfiguration.WEB_DRIVER.findElement(By.xpath(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("id")) {
				ele = StaticConfiguration.WEB_DRIVER.findElement(By.id(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("name")) {
				ele = StaticConfiguration.WEB_DRIVER.findElement(By.name(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("linktext")) {
				ele = StaticConfiguration.WEB_DRIVER.findElement(By.linkText(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("partiallinktext")) {
				ele = StaticConfiguration.WEB_DRIVER.findElement(By.partialLinkText(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("classname")) {
				ele = StaticConfiguration.WEB_DRIVER.findElement(By.className(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("tagname")) {
				ele = StaticConfiguration.WEB_DRIVER.findElement(By.tagName(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("css")) {
				ele = StaticConfiguration.WEB_DRIVER.findElement(By.cssSelector(element.getValue()));
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Not able to find element " + element.getName());
			// Assert.fail();
		}
		if (ele == null) {
			System.out.println("Not able to find element ");
			Assert.fail("Not able to find element " + element.getName());
		}
		return ele;
	}

	public List<WebElement> getWebElements(WebPageElements element) {
		List ele = null;
		try {
			if (element.getLocator().equalsIgnoreCase("xpath")) {
				ele = StaticConfiguration.WEB_DRIVER.findElements(By.xpath(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("id")) {
				ele = StaticConfiguration.WEB_DRIVER.findElements(By.id(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("name")) {
				ele = StaticConfiguration.WEB_DRIVER.findElements(By.name(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("linktext")) {
				ele = StaticConfiguration.WEB_DRIVER.findElements(By.linkText(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("partiallinktext")) {
				ele = StaticConfiguration.WEB_DRIVER.findElements(By.partialLinkText(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("classname")) {
				ele = StaticConfiguration.WEB_DRIVER.findElements(By.className(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("tagname")) {
				ele = StaticConfiguration.WEB_DRIVER.findElements(By.tagName(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("css")) {
				ele = StaticConfiguration.WEB_DRIVER.findElements(By.cssSelector(element.getValue()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Not able to find elements for " + element.getName());
			// Assert.fail();
		}
		if (ele == null) {
			Assert.fail("Not able to find elements for " + element.getName());
		}
		return ele;
	}

	public WebElement getChildWebElement(WebPageElements element, WebPageElements parentElement) {
		WebElement ele = null;
		WebElement parentWebelement = getWebElement(parentElement);

		try {
			if (element.getLocator().equalsIgnoreCase("xpath")) {
				ele = parentWebelement.findElement(By.xpath(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("id")) {
				ele = parentWebelement.findElement(By.id(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("name")) {
				ele = parentWebelement.findElement(By.name(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("linktext")) {
				ele = parentWebelement.findElement(By.linkText(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("partiallinktext")) {
				ele = parentWebelement.findElement(By.partialLinkText(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("classname")) {
				ele = parentWebelement.findElement(By.className(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("tagname")) {
				ele = parentWebelement.findElement(By.tagName(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("css")) {
				ele = parentWebelement.findElement(By.cssSelector(element.getValue()));
			}
		} catch (Exception e) {
			//e.printStackTrace();
			//Assert.fail("Not able to find elements for " + element.getName());
			// Assert.fail();
		}
		if (ele == null) {
			//Assert.fail("Not able to find elements for " + element.getName());
		}
		return ele;
	}

	public boolean waitForWebPageElement(WebPageElements ele, int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(StaticConfiguration.WEB_DRIVER, seconds);
			if (ele.getLocator().equalsIgnoreCase("xpath")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ele.getValue())));
			} else if (ele.getLocator().equalsIgnoreCase("id")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ele.getValue())));
			} else if (ele.getLocator().equalsIgnoreCase("linktext")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(ele.getValue())));
			} else if (ele.getLocator().equalsIgnoreCase("name")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(ele.getValue())));
			} else if (ele.getLocator().equalsIgnoreCase("classname")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(ele.getValue())));
			} else if (ele.getLocator().equalsIgnoreCase("css")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ele.getValue())));
			}
			return true;
		} catch (Exception e) {
			// e.printStackTrace();
			return false;
		}
	}
	
	public boolean waitForElement(WebElement ele, int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(StaticConfiguration.WEB_DRIVER, seconds);
				wait.until(ExpectedConditions.visibilityOf(ele));
			return true;
		} catch (Exception e) {
			// e.printStackTrace();
			return false;
		}
	}

	public boolean switchToFrameByElemenet(WebPageElements ele) {
		try {
			WebElement element = getWebElement(ele);
			StaticConfiguration.WEB_DRIVER.switchTo().frame(element);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Not able to switch to " + ele.getName());
			return false;
		}
	}

	public boolean switchToParentFrame() {
		try {
			StaticConfiguration.WEB_DRIVER.switchTo().defaultContent();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Not able to switch to Parent Frame ");
			return false;
		}
	}

	public WebPageElements getRunTimeWebElement(String name, String locator, String value) {
		return new WebPageElements(name, locator, value);
	}

	public boolean waitForRequiredElement(WebPageElements ele, int second) {
		if (waitForWebPageElement(ele, second)) {
			return true;
		} else {
			Assert.fail("Not able to find " + ele.getName() + " after " + second + " seconds.");
			return false;
		}
	}

	public void setText(WebPageElements ele, String text) {
		try {
			WebElement element = getWebElement(ele);
			clearText(ele);
			element.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Not able to set text for " + ele.getName());
		}
	}

	public String getText(WebPageElements ele) {
		String text = null;
		try {
			WebElement element = getWebElement(ele);
			text = element.getText();
			if(text == "")
				text = element.getAttribute("text");
			/* System.out.println(text); */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Not able to get text for " + ele.getName());
		}
		return text;
	}

	public String getValue(WebPageElements ele) {
		String text = null;
		try {
			WebElement element = getWebElement(ele);
			text = element.getAttribute("value");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Not able to get value for " + ele.getName());
		}
		return text;
	}

	public void click(WebPageElements ele) {
		try {
			WebElement element = getWebElement(ele);
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Not able to click " + ele.getName());
		}
	}

	public ArrayList<WebPageElements> getWebPageElements(WebPageElements ele) {
		ArrayList<WebPageElements> webPageElements = new ArrayList<WebPageElements>();
		try {
			List<WebElement> webElements = getWebElements(ele);
			for (int i = 1; i <= webElements.size(); i++) {
				
				/*System.out.println(ele.getName() + i);
				System.out.println(ele.getValue() + "[" + i + "]");
				*/
				webPageElements
						.add(new WebPageElements(ele.getName() + i, ele.getLocator(), ele.getValue() + "[" + i + "]"));
			}
		} catch (Exception e) {
			Assert.fail("Get Web Elements error " + e.getMessage());
		}
		return webPageElements;
	}
	
	
	public String getParagraphText(WebPageElements post) {
		String text = "";
		try {
			WebElement element = getWebElement(post);
			List<WebElement> webElements = element.findElements(By.xpath(DashboardPageElements.paragraphText.getValue()));
						
			for (WebElement paragraphs:webElements) {
				text = text + paragraphs.getText() + "<br>";
			}
			
			System.out.println("Paragraph Text" + text);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	public void clearText(WebPageElements ele) {
		try {
			WebElement element = getWebElement(ele);
			element.clear();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Not able to clear text for " + ele.getName());
		}
	}
}
