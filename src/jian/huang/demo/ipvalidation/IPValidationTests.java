/**
 * The main program to run all valid and invalid IP address test data, 
 * and print the results to a text file
 *
 * @author  Jian Huang
 * @since   2015-02-26
 */

package jian.huang.demo.ipvalidation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jian.huang.demo.utility.Helpers;
import jian.huang.demo.utility.TestData;

public class IPValidationTests {

    boolean isIPValid;
    String IPAddr; // IP address
    static long timeStart;

    @BeforeClass
    public static void setUp() {
        // delete contents inside the file
        Helpers.eraseFileContents();
    }
    
    @Before
    public void beforeStartOfTests() {
        // record the time for starting of the test
        timeStart = Helpers.timeStart();
    }

    @Test
    public void IPValidationPositiveTestCases() throws InterruptedException {
        // test valid IPv4 addresses
        for (int i = 0; i < TestData.VALID_IPV4_TEST_DATA.length; i++) {

            IPAddr = TestData.VALID_IPV4_TEST_DATA[i];
            // invoke the IP validation method
            isIPValid = IPValidation.ValidateIPAddr(IPAddr);
            // update report
            Helpers.updateReportForPositiveTests(isIPValid, IPAddr);
        }
    }

    @Test
    public void IPValidationNegativeTestCases() throws InterruptedException {
        // test invalid IPv4 addresses
        for (int j = 0; j < TestData.INVALID_IPV4_TEST_DATA.length; j++) {

            IPAddr = TestData.INVALID_IPV4_TEST_DATA[j];
            // invoke the IP validation method
            isIPValid = IPValidation.ValidateIPAddr(IPAddr);
            // update report
            Helpers.updateReportForNegativeTests(isIPValid, IPAddr);
        }
    }

    @After
    public void endOfTests() {
        //TODO
    }
    
    @AfterClass
    public static void tearDown() {
     // Test summary and record end-time
        Helpers.testsSummary(timeStart);
    }
}
