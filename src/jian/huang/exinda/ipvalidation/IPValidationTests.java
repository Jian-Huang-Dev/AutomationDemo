/**
 * The main program to run all valid and invalid IP address test data, and print the results to a text file
 *
 * @author  Jian Huang
 * @since   2015-07-06
 */

package jian.huang.exinda.ipvalidation;

import jian.huang.exinda.utility.Constant;
import jian.huang.exinda.utility.Helper;
import jian.huang.exinda.utility.TestData;

import org.junit.Test;

public class IPValidationTests {

	// start of the test
	long time_start = Helper.TimeStart();

	boolean is_ip_valid;
	String ip_addr;
	int total_failed_tests = 0;
	int total_num_test = 0;

	@Test
	public void IPValidationTestCases() throws InterruptedException {

		// test valid IPv4 addresses
		for (int i = 0; i < TestData.valid_ipv4_test_data.length; i++) {

			ip_addr = TestData.valid_ipv4_test_data[i];

			// IP validation
			is_ip_valid = IPValidation.ValidateIPAddr(ip_addr);

			// update report file
			if (is_ip_valid) {
				Helper.AppendText(Constant.test_passed + " \"" + ip_addr + "\""
						+ " should be a " + Constant.valid_ip);
			} else {
				Helper.AppendText(Constant.test_failed + " \"" + ip_addr + "\""
						+ " should be a " + Constant.valid_ip);

				// record total number of failed tests
				total_failed_tests++;
			}

			// record total number of tests
			total_num_test++;

		}

		// test invalid IPv4 addresses
		for (int i = 0; i < TestData.invalid_ipv4_test_data.length; i++) {

			ip_addr = TestData.invalid_ipv4_test_data[i];

			// ip validation
			is_ip_valid = IPValidation.ValidateIPAddr(ip_addr);

			// update report file
			if (!is_ip_valid) {
				Helper.AppendText(Constant.test_passed + " \"" + ip_addr + "\""
						+ " should be an " + Constant.invalid_ip);
			} else {
				Helper.AppendText(Constant.test_failed + " \"" + ip_addr + "\""
						+ " should be an " + Constant.invalid_ip);

				// record total failed tests
				total_failed_tests++;
			}

			// record total tests
			total_num_test++;
		}

		// test valid IPv6 addresses
		for (int i = 0; i < TestData.valid_ipv6_test_data.length; i++) {

			ip_addr = TestData.valid_ipv6_test_data[i];

			// ip validation
			is_ip_valid = IPValidation.ValidateIPAddr(ip_addr);

			// update report file
			if (is_ip_valid) {
				Helper.AppendText(Constant.test_passed + " \"" + ip_addr + "\""
						+ " should be a " + Constant.valid_ip);
			} else {
				Helper.AppendText(Constant.test_failed + " \"" + ip_addr + "\""
						+ " should be a " + Constant.valid_ip);

				// record total failed tests
				total_failed_tests++;
			}

			// record total tests
			total_num_test++;
		}

		// test invalid Ipv6 addresses
		for (int i = 0; i < TestData.invalid_ipv6_test_data.length; i++) {

			ip_addr = TestData.invalid_ipv6_test_data[i];

			// ip validation
			is_ip_valid = IPValidation.ValidateIPAddr(ip_addr);

			// update report file
			if (!is_ip_valid) {
				Helper.AppendText(Constant.test_passed + " \"" + ip_addr + "\""
						+ " should be an " + Constant.invalid_ip);
			} else {
				Helper.AppendText(Constant.test_failed + " \"" + ip_addr + "\""
						+ " should be an " + Constant.invalid_ip);

				// record total failed tests
				total_failed_tests++;
			}

			// record total tests
			total_num_test++;
		}

		// Test summary
		Helper.AppendText("* Total Tests: " + total_num_test
				+ ", * Total Failed Tests: " + total_failed_tests);

		// end of the test
		Helper.TimeEnd(time_start);
	}

}
