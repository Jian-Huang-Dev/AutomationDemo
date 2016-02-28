/**
 * General methods to help writing automated test scripts
 *
 * @author  Jian Huang
 * @since   2015-02-26
 */

package jian.huang.demo.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class Helpers {
    
    public static int totalTests = 0;
    public static int totalFailedTests = 0;
    
    /**
     * Return an instance of Chrome driver
     * 
     * @return WebDriver
     */
    public static WebDriver getChromeDriver() {
     // if not specified, WebDriver will search your path for chromedriver
        System.setProperty("webdriver.chrome.driver",
                Constants.CHROME_WEB_DRIVER_PATH);
        
        // the test environment will be performed in Chrome web browser
        return new ChromeDriver();
    }
    
    /**
     * Update the report for positive test cases
     * 
     * @param isIPValid
     * @param IPAddr
     */
    public static void updateReportForPositiveTests(boolean isIPValid, String IPAddr) {
        // update report
        if (isIPValid) {
            appendText(Constants.TEST_PASSED + ", \"" + IPAddr + "\""
                    + " is a " + Constants.VALID_IP);
        } else {
            appendText(Constants.TEST_FAILED + ", \"" + IPAddr + "\""
                    + " should be a " + Constants.VALID_IP);
            
            // record total failed tests
            totalFailedTests++;
        }
        
        // record total number of tests
        totalTests++;
    }
    
    /**
     * Update the report for negative test cases
     * 
     * @param isIPValid
     * @param IPAddr
     */
    public static void updateReportForNegativeTests(boolean isIPValid, String IPAddr) {
        // update report
        if (!isIPValid) {
            appendText(Constants.TEST_PASSED + ", \"" + IPAddr + "\""
                    + " is an " + Constants.INVALID_IP);
        } else {
            appendText(Constants.TEST_FAILED + ", \"" + IPAddr + "\""
                    + " should be an " + Constants.INVALID_IP);
            
            // record total failed tests
            totalFailedTests++;
        }
        
        // record total number of tests
        totalTests++;
    }
    
    /**
     * Update report when there is an exception thrown
     * 
     * @param e
     */
    public static void updateReportWithException(Exception e) {
        appendText("Element is not found with exception:\n" + e);
    }
    
    /**
     * Update the report summary
     * 
     * @param timeStart
     */
    public static void testsSummary(long timeStart) {
     // Test summary
        appendText("* Total Tests: " + totalTests + 
                ", * Total Failed Tests: " + totalFailedTests);

        // end of the test
        timeEnd(timeStart);
    }

	/**
	 * Return the starting time of the test
	 * 
	 * @return The start of the test
	 */
	public static long timeStart() {
		long time_start = System.currentTimeMillis();
		appendText("*** TEST STARTS ***");
		return time_start;
	}

    /**
     * An indication of the ending time of the test, and execution time
     * 
     * @param time_start
     */
    public static void timeEnd(long time_start) {
        long time_end = System.currentTimeMillis();
        long time_duration = (time_end - time_start) / 1000;
        appendText(
                "Test ends at: " + currentDateTime() + " --> Time Duration: " + 
                        String.valueOf(time_duration) + " s");
    }

	/**
	 * Display current date and time
	 * 
	 * @return current date and time
	 */
	public static String currentDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
		dateFormat.setTimeZone(TimeZone.getTimeZone(Constants.TIME_ZONE));
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public static void eraseFileContents() {
	    PrintWriter writer = null;
        try {
            writer = new PrintWriter(Constants.FILE);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    writer.print("");
	    writer.close();
	}

    /**
     * Add text to the report file
     * 
     * @param string
     */
    public static void appendText(String string) {
        FileWriter fileOutput = null;
        File file = Constants.FILE;

        try {
            fileOutput = new FileWriter(file, true);

            // create a new file if it doesn't exit
            if (!file.exists()) {
                file.createNewFile();
            }

            // write contents into file
            fileOutput.
                write("\n" + currentDateTime() + " --> " + string + "\n");
            fileOutput.flush();
            fileOutput.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutput != null) {
                    fileOutput.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
