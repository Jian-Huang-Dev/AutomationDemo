/**
 * Result page for IP validator web-page 
 *
 * @author  Jian Huang
 * @since   2016-02-26
 */

package jian.huang.demo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import jian.huang.demo.utility.Constants;
import jian.huang.demo.utility.Helpers;

public class ResultPage {
    
    WebDriver driver = null;
    
    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }
    
    /**
     * Boolean function to check if the test failed
     * 
     * @return true if valid, false otherwise
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
