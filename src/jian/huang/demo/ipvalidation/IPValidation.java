/**
 * IP validation function implementations 
 *
 * @author  Jian Huang
 * @since   2015-07-06
 */

package jian.huang.demo.ipvalidation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jian.huang.demo.pageobjects.IPValidatorPage;
import jian.huang.demo.utility.Helpers;

public class IPValidation {

	/**
	 * To validate any type of IP address, including IPv4 and IPv6
	 * 
	 * @param IPAddr
	 * @throws InterruptedException
	 */
	public static boolean ValidateIPAddr(String IPAddr)
			throws InterruptedException {
	    
		// variables initialization
		boolean isIPValid = false;
		WebElement IPInputBox = null;
		WebDriver driver = null;
		IPValidatorPage validatorPage = null;

		driver = Helpers.getChromeDriver();
		validatorPage = new IPValidatorPage(driver);
		IPInputBox = validatorPage.IPInputBox();
		
		IPInputBox.clear();
		IPInputBox.sendKeys(IPAddr);
		IPInputBox.sendKeys(Keys.ENTER);
		isIPValid = validatorPage.isTestFailed();
		driver.quit();

		// return the validation result
		return isIPValid;
	}
}
