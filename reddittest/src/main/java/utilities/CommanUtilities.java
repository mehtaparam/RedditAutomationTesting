package utilities;

import com.aventstack.extentreports.MediaEntityModelProvider;

import constants.StaticConfiguration;

public class CommanUtilities {
	
	public static void logCreator(int result, String msg) {
		try {
			// Lets Take Screenshot According To Platform
			StaticConfiguration.SCREEN_CAPTURE.setPath(Screenshot.getscreenshot());
			
			// Let's Put Result In File
			// 0 = Fail , 1 = Pass, 2 = Error, 3 = Info , 4 = Skip

			if (result == 0) {
				StaticConfiguration.EXTENT_TEST.fail(msg, new MediaEntityModelProvider(StaticConfiguration.SCREEN_CAPTURE));
			} else if (result == 1) {
				StaticConfiguration.EXTENT_TEST.pass(msg, new MediaEntityModelProvider(StaticConfiguration.SCREEN_CAPTURE));
			} else if (result == 2) {
				StaticConfiguration.EXTENT_TEST.error(msg, new MediaEntityModelProvider(StaticConfiguration.SCREEN_CAPTURE));
			} else if (result == 3) {
				StaticConfiguration.EXTENT_TEST.info(msg, new MediaEntityModelProvider(StaticConfiguration.SCREEN_CAPTURE));
			} else if (result == 4) {
				StaticConfiguration.EXTENT_TEST.skip(msg, new MediaEntityModelProvider(StaticConfiguration.SCREEN_CAPTURE));
			} else {
				StaticConfiguration.EXTENT_TEST.info(msg, new MediaEntityModelProvider(StaticConfiguration.SCREEN_CAPTURE));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class LogStatus{
		public static int Fail = 0;
		public static int Pass = 1;
		public static int Error = 2;
		public static int Info = 3;
		public static int Skip = 4;
	}
}
