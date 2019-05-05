package utilities;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import constants.StaticConfiguration;

public class Screenshot {

	public static String getscreenshot()  {
		
		String imagePath = StaticConfiguration.OUTPUT_DIRECTORY 
				+ "\\" + StaticConfiguration.HTML_REPORT_DIRECTORY 
				+ "\\" + Screenshot.date() 
				+ "\\" + StaticConfiguration.SCREENSHOT_DIRECTORY +
				"\\" + StaticConfiguration.CATEGORY_NAME + "\\"
				+ Screenshot.timestamp() + ".png";// Create Dynamic path using configuration

		
		try {
			File scr = ((TakesScreenshot) StaticConfiguration.WEB_DRIVER).getScreenshotAs(OutputType.FILE);
			File dest = new File(imagePath);
			FileUtils.copyFile(scr, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return imagePath.replace(
				 StaticConfiguration.OUTPUT_DIRECTORY 
					+ "\\" + StaticConfiguration.HTML_REPORT_DIRECTORY 
					+ "\\" + Screenshot.date()
				+ "\\",
				""); // Remove common path
	}

	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	
	public static String time() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}
	

	public static String date() {
		return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	}

}
