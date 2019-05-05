**************** How To Setup? ***************

> Clone git hub project
> Import project in Eclipse
> Update Project from Maven option to install required dependencies
> Make changes in constants.TestData class (If you need to change credentials)
> Right click on testng.xml
> Select Run As
> Select TestNG suite

*********** Which flow it will test? *********
> Open URL https://www.reddit.com/

@Test 1
> Click on Login option from dashboard
> Switch context to Login frame
> Enter credentials defined in constants>TestData
> Click on Login
> Verify for any error (You can off this verification check by constants.ConfigConstants)
> It will verify login by creating dynamic xpath based on username and for a now it will print success message in console.

@Test 2
> It will read categories list to get total categories
> It will click on categories from the list one by one
> It will get all posts reference xPath and store in array
> It will iterate all the posts and for a now it will read data for post and store in Post's model
> Model will be added to JsonArray
> At the end of execution JsonArray will be store in Posts.json file and Store HTML file.

******** What result will you get? ***********
> ExtentTest will create html report file in following format

	<Output Directory> / <Report Directory> / <Date>	 / htmlReport
	TestResults		   / Report				/ 06-05-2019 / index.html
	
> You can also find screenshots attached to HTML report and it will be stored in following manner

	<Output Directory> / <Report Directory> / <Date>	 / htmlReport
	TestResults		   / Report				/ 06-05-2019 / Screenshots
