Step 1: Install Eclipse & Java JDK
Download and install Java JDK
Set JAVA_HOME and update PATH environment variables
Install Eclipse IDE for Java developers

Step 2: Create a Maven Project
Open Eclipse → File → New → Maven Project
Maven automatically provides the standard folder structure

Steps 3 : we have pom.xml in floder where we have to provide the dependencies required to our project 
selenium-java → For browser automation
webdrivermanager → Auto driver setup
testng → To create and run tests
apache-poi → To read/write Excel files
json-simple → To read JSON test data
Download and use the latest versions of each dependency.

Step 4: Create Base Class
Location: src/main/java → base package
Create a class BaseClass
Responsibilities:
Initialize WebDriver
Load configuration
Launch browser
Close browser

Step 5: Create Utility Classes
Location: src/main/java → utils package
Add utility classes:
WaitUtils → implicit wait, explicit wait
ExcelUtils → read/write Excel
ActionUtils → sendKeys, click, dropdown handling
JsonUtils → read JSON files

Step 6: Create Page Object Classes (POM)
Location: src/main/java → pageObjects package
Create one class per page
Each page class contains:
Locators
Page actions (methods)
PageFactory initialization (optional)

Step 7: Create Properties File
Create a folder: Configuration
Add config.properties
URL
Browser
Username
Password
Load it in BaseClass using Properties class.

Step 8: Create Test Data Folder (JSON Files)
Create TestData/
Store your data.json files inside
Use json-simple to read values


Step 9: Create Excel Test Data File
Store Excel files in TestData/
Use Apache POI to read/write test data
Useful for:
Login data
Form inputs
Multiple test combinations

Step 10: Create Test Classes
Location: src/test/java
Create test packages:
sanity or regression
Each class contains @Test methods
Use POM classes to perform actions


Steps 11 : create the testng,xml to run the test classses
Right-click project → TestNG → Convert to TestNG
testng.xml is generated
Add the test classes you want to execute

Step 12: Execute the Test Suite
Right-click testng.xml → Run As → TestNG Suite
Maven downloads dependencies and tests execute.



