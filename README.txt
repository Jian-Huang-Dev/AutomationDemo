Demo: Automated Testing for IP Address Validator program

Set up:
1. Download Eclipse IDE for Java Developers or any other suitable versions
Download page: https://www.eclipse.org/downloads/

2. Download Selenium Client & WebDriver Language Bindings (Java)
Download page: http://www.seleniumhq.org/download/

3. Download ChromeDriver (WebDriver for Chrome)
Download page: https://sites.google.com/a/chromium.org/chromedriver/downloads

4.
1) Open Eclipse IDE
2) Import the existing project (IPValidation) into Eclipse
3) Right click on the project name -> configure build path -> add all external JARs from Selenium Client package
4) In Eclipse IDE, under src/jian.huang.demo.utility/Constants.java, change the chrome_driver_path to the path where you placed your ChromeDriver file

Overview of the project:
This project automates test cases for the IP Address Validator program.

Structure of the project:

Under jian.huang.demo.ipvalidation package:
1) IPValidation.java includes core methods to validate the IP addresses
2) IPValidationTests.java is the main program to run all available test cases (both negative and positive)

Under jian.huang.demo.pageobjects
1) IPValidatorPage.java: a page object for the IP validator home page
2) ResultPage.java: a page object for the result page after clicking the submit button

Under jian.huang.demo.utility:
1) Constants.java includes all constants (string, long ..etc) for convenient modifications
2) Helpers.java includes all general methods in helping writing automated test scripts
3) TestData.java includes all the test data needed to perform the tests (both negative and positive tests)

Inside the project, there is also one text file (QuickReport.txt) which records all the IP address test cases being tested, 
and provide a short summary
(ex. pass/fail for each tested IP address, total number of tested performed, total failed tests, total time used ..etc).


