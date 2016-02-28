/**
 * IP validator page object 
 *
 * @author  Jian Huang
 * @since   2016-02-26
 */

package jian.huang.demo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jian.huang.demo.utility.Constants;
import jian.huang.demo.utility.Helpers;

public class IPValidatorPage {

    WebDriver driver = null;

    /**
     * IPValidatorPage constructor to launch the web page
     * 
     * @param driver
     */
    public IPValidatorPage(WebDriver driver) {
        // open up the IP Address Validator program webpage
        this.driver = driver;
        driver.get(Constants.IP_ADDR_VALIDATOR_PAGE);
    }

    /**
     * IP input box web-element
     * 
     * @return WebElement
     */
    public WebElement IPInputBox() {
        WebElement inputBox = null;

        try {
            inputBox = driver.findElement(By.
                    xpath("//input[@name='Query' and @type='text']"));
        } catch (NoSuchElementException e) {
            // quit driver if an exception thrown
            Helpers.updateReportWithException(e);
            driver.quit();
        }

        return inputBox;
    }

    /**
     * Boolean function to check if the test failed
     * 
     * @return
     */
    public boolean isTestFailed() {
        String result = "";
        boolean isValid = false;

        try {
            result = driver.findElement(By.
                    cssSelector(".result_desc > span")).getText();
        } catch (NoSuchElementException e) {
            // quit driver if an exception thrown
            Helpers.updateReportWithException(e);
            driver.quit();
        }

        // it is a valid test if the criteria met
        if (result.equals(Constants.VALID)) {
            isValid = true;
        }

        return isValid;
    }
}
