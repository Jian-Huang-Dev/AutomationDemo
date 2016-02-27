/**
 * The main program to run all valid and invalid IP address test data, and print the results to a text file
 *
 * @author  Jian Huang
 * @since   2015-07-06
 */

package jian.huang.demo.ipvalidation;

import org.junit.Test;

import jian.huang.demo.utility.Helpers;
import jian.huang.demo.utility.TestData;

public class IPValidationTests {

	boolean isIPValid;
	String IPAddr;
	
	// start of the test
    long timeStart = Helpers.timeStart();

	@Test
	public void IPValidationTestCases() throws InterruptedException {

		// test valid IPv4 addresses
		for (int i = 0; i < TestData.VALID_IPV4_TEST_DATA.length; i++) {

			IPAddr = TestData.VALID_IPV4_TEST_DATA[i];
			isIPValid = IPValidation.ValidateIPAddr(IPAddr);
			Helpers.updateReportForPositiveTests(isIPValid, IPAddr);
		}
;
		// test invalid IPv4 addresses
		for (int j = 0; j < TestData.INVALID_IPV4_TEST_DATA.length; j++) {
		    
			IPAddr = TestData.INVALID_IPV4_TEST_DATA[j];

			// IP validation
			isIPValid = IPValidation.ValidateIPAddr(IPAddr);

			Helpers.updateReportForNegativeTests(isIPValid, IPAddr);
		}
		
		// Test summary
		Helpers.appendText("* Total Tests: " + Helpers.totalTests
				+ ", * Total Failed Tests: " + Helpers.totalFailedTests);

		// end of the test
		Helpers.timeEnd(timeStart);
	}

}
