/**
 * IP validator web-page
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
        this.driver = driver;
        // open up the IP Address Validator program webpage
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
}
