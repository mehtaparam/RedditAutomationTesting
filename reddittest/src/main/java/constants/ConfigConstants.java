package constants;

public class ConfigConstants {
	/*
	 * These Constants will be used to configure and/or store required values
	 */
	public static int MAX_POST_COUNT = 5;   // It will be used to define Maximum Post you want from each categories
	public static int CATAGORIES_COUNT = 0; // It will be used to store and/or get categories counts runtime
	public static int TOTAL_POST_COUNT = 0; // It will be used to store and/or get total post counts runtime
	public static int GENERAL_WAIT_SECONDS = 30 ; // It will be used to define and/or get general wait seconds 
	public static int ERROR_MSG__WAIT_SECONDS = 3 ; // It will be used to define and/or get general wait seconds
	
	
	/*
	 * It should be true before doing negative testing
	 */
	public static boolean CHECK_FOR_ERRORS = true; // Our program will only try to identify error messages if we set true value
}
