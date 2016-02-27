/**
 * IP validation function implementations 
 *
 * @author  Jian Huang
 * @since   2015-07-06
 */

package jian.huang.exinda.ipvalidation;

import jian.huang.exinda.utility.Constant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IPValidation {

	/**
	 * To validate any type of IP address, including IPv4 and IPv6
	 * 
	 * @param ip_addr
	 * @throws InterruptedException
	 */
	public static boolean ValidateIPAddr(String ip_addr)
			throws InterruptedException {

		// variables initialization
		boolean mIsIPValid = false;

		// if not specified, WebDriver will search your path for chromedriver
		System.setProperty("webdriver.chrome.driver",
				Constant.chrome_driver_path);

		// the test environment will be performed in Chrome web browser
		WebDriver driver = new ChromeDriver();

		// open up the IP Address Validator program webpage
		driver.get(Constant.ip_addr_validator_page);

		// give it a moment to fully load the webpage
		Thread.sleep(Constant.short_wait);

		// clear the IP address text box and then enter the desired IP address
		WebElement ip_txt_box = driver.findElement(By
				.id(Constant.ip_addr_txt_box));
		ip_txt_box.clear();
		ip_txt_box.sendKeys(ip_addr);
		// click to proceed to result page
		ip_txt_box.submit();

		// check if the IP address valid or invalid
		mIsIPValid = !driver.getPageSource().contains(Constant.invalid_text);

		// wait a moment before closing the browser
		Thread.sleep(Constant.short_wait);
		driver.quit();

		// return the validation result
		return mIsIPValid;
	}
}
