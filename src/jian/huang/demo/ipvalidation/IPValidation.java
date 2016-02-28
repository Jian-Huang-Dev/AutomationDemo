/**
 * IP validation function implementations 
 *
 * @author  Jian Huang
 * @since   2016-02-26
 */

package jian.huang.demo.ipvalidation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jian.huang.demo.pageobjects.IPValidatorPage;
import jian.huang.demo.pageobjects.ResultPage;
import jian.huang.demo.utility.Helpers;

public class IPValidation {

    /**
     * To validate any a IP address
     * 
     * @param IPAddr
     * @throws InterruptedException
     */
    public static boolean ValidateIPAddr(String IPAddr) throws InterruptedException {
        
        // variables initialization
        boolean isIPValid = false;
        WebElement IPInputBox = null;
        WebDriver driver = null;
        IPValidatorPage validatorPage = null;

        driver = Helpers.getChromeDriver(); // Chrome driver
        validatorPage = new IPValidatorPage(driver); // get the page object
        IPInputBox = validatorPage.IPInputBox(); // find the input box element

        // enter the IP address provided into the text box
        IPInputBox.clear();
        IPInputBox.sendKeys(IPAddr);
        IPInputBox.sendKeys(Keys.ENTER);
        
        // validation
        ResultPage resultPage = new ResultPage(driver);
        isIPValid = resultPage.isTestFailed(); 

        // quit driver once finished
        driver.quit();

        // return the validation result
        return isIPValid;
    }
}
