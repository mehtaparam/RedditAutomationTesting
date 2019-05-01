*************** Task Completed (30st April and 1st May) *************** 
1. Created Maven Project
2. Added needed dependencies in .pom file
3. Made Framework setup to organize our test using modular approach
	1) Created constant package which consist classed for constant values for Test data ( We can Use DB or Excel or etc. data source in future) and Configurations
	2) Created model package to create/store required models (Bean classed)
	3) Created page element package to create/store required xpaths organized by pages to identify and modify them easily.
	4) Created utilities package which consists SeleniumUtilites who overrides Selenium methods and add functionalities of error handling and other common features
	5) Created testFiles package which consist RedittTest (TestNG class) to define test.
	6) Created testng.xml to run Test
	
*************************** How To Setup? ***************************

1. Clone git hub project
2. Import project in Eclipse
3. Update Project from Maven option to install required dependencies
4. Make changes in constants.TestData class (If you need to change credentials)
5. Right click on testng.xml
6. Select Run As
7. Select TestNG suite

********************** Which flow it will test? **********************
1. Open URL https://www.reddit.com/
2. Click on Login option from dashboard
3. Switch context to Login frame
4. Enter credentials defined in constants.TestData
5. Click on Login
6. Verify for any error (You can off this verification check by constants.ConfigConstants)
7. It will verify login by creting dynamic xpath based on username and for a now it will print success message in console.
