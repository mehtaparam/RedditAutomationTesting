**************** How To Setup? ***************
> 1 Clone git hub project

> 2 Import project in Eclipse

> 3 Update Project from Maven option to install required dependencies

> 4 Make changes in constants.TestData class (If you need to change credentials)

> 5 Right click on testng.xml

> 6 Select Run As

> 7 Select TestNG suite


*********** Which flow it will test? *********
> 1 Open URL https://www.reddit.com/

@Test 1
> 2 Click on Login option from dash board

> 3 Switch context to Login frame

> 4 Enter credentials defined in constants>TestData

> 5 Click on Login

@Test 2
> 6 Verify for any error (You can off this verification check by constants.ConfigConstants)

> 7 It will verify login by creating dynamic xpath based on username and for a now it will print success message in console.


@Test 3
> 8 It will read categories list to get total categories

> 9 It will click on categories from the list one by one

> 10 It will get all posts reference xPath and store in array

> 11 It will iterate all the posts and for a now it will read data for post and store in Post's model

> 12 Model will be added to JsonArray

> 13 At the end of execution JsonArray will be store in Posts.json file and Store HTML file.


******** What result will you get? ***********
> ExtentTest will create html report file in following format


	<Output Directory> / <Report Directory> / <Date>	 / htmlReport
	TestResults		   / Report				/ 06-05-2019 / index.html
	
> You can also find screenshots attached to HTML report and it will be stored in following manner


	<Output Directory> / <Report Directory> / <Date>	 / htmlReport
	TestResults		   / Report				/ 06-05-2019 / Screenshots

> posts.json will be created in same manner with following directorory format


	<Output Directory> / <Report Directory> / <Date>	 / posts.json
	TestResults		   / Report				/ 06-05-2019 /  posts.json
