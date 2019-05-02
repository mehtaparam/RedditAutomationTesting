package utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import constants.ConfigConstants;
import model.WebPageElements;

public class SeleniumUtilities {
	public WebDriver driver;
	
	public WebElement getWebElement(WebPageElements element) {
		WebElement ele = null;
		try {
			if (element.getLocator().equalsIgnoreCase("xpath")) {
				ele = driver.findElement(By.xpath(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("id")) {
				ele = driver.findElement(By.id(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("name")) {
				ele = driver.findElement(By.name(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("linktext")) {
				ele = driver.findElement(By.linkText(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("partiallinktext")) {
				ele = driver.findElement(By.partialLinkText(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("classname")) {
				ele = driver.findElement(By.className(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("tagname")) {
				ele = driver.findElement(By.tagName(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("css")) {
				ele = driver.findElement(By.cssSelector(element.getValue()));
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Not able to find element " + element.getName());
			// Assert.fail();
		}
		if (ele == null) {
			Assert.fail("Not able to find element " + element.getName());
		}
		return ele;
	}
	
	
	public List<WebElement> getWebElements(WebPageElements element) {
		List ele = null;
		try {
			if (element.getLocator().equalsIgnoreCase("xpath")) {
				ele = driver.findElements(By.xpath(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("id")) {
				ele = driver.findElements(By.id(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("name")) {
				ele = driver.findElements(By.name(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("linktext")) {
				ele = driver.findElements(By.linkText(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("partiallinktext")) {
				ele = driver.findElements(By.partialLinkText(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("classname")) {
				ele = driver.findElements(By.className(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("tagname")) {
				ele = driver.findElements(By.tagName(element.getValue()));
			} else if (element.getLocator().equalsIgnoreCase("css")) {
				ele = driver.findElements(By.cssSelector(element.getValue()));
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
	
	public WebElement getChildWebElement(WebPageElements element,WebPageElements parentElement) {
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
			e.printStackTrace();
			Assert.fail("Not able to find elements for " + element.getName());
			// Assert.fail();
		}
		if (ele == null) {
			Assert.fail("Not able to find elements for " + element.getName());
		}
		return ele;
	}

	
	public boolean waitForElement(WebPageElements ele, int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
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
			//e.printStackTrace();		
			return false;
		}
	}
	
	
	public boolean switchToFrameByElemenet(WebPageElements ele) {
		try {
			WebElement element = getWebElement(ele);
			driver.switchTo().frame(element);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Not able to switch to " + ele.getName());
			return false;
		}
	}
	
	public boolean switchToParentFrame() {
		try {
			driver.switchTo().defaultContent();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Not able to switch to Parent Frame ");
			return false;
		}
	}
	
	public WebPageElements getRunTimeWebElement(String name,String locator,String value) {
		System.out.println("Name For Runtime Element: "+ name);
		System.out.println("Name For Runtime Locator: "+ locator);
		System.out.println("Name For Runtime Value: "+ value);
		return new WebPageElements(name,locator,value);
	}
	
	public boolean waitForRequiredElement(WebPageElements ele, int second) {
		if(waitForElement(ele, second)) {
			return true;
		}
		else
		{
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
	
	public String click(WebPageElements ele) {
		String text = null;
		try {
			WebElement element = getWebElement(ele);
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Not able to click " + ele.getName());
		}
		return text;
	}
	
	public ArrayList<WebPageElements> getWebPageElements(WebPageElements ele) {
		ArrayList<WebPageElements> webPageElements = new ArrayList<WebPageElements>();
		try {
			List<WebElement> webElements = getWebElements(ele);
			for(int i=1;i<=webElements.size();i++) {
				webPageElements.add(new WebPageElements(ele.getName() + i, ele.getLocator(), ele.getValue()+"["+i+"]"));
			}
		}
		catch (Exception e) {
			Assert.fail("Get Web Elements error " + e.getMessage());
		}
		return webPageElements;
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
