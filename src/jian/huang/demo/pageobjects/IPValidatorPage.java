package jian.huang.demo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import jian.huang.demo.utility.Constants;
import jian.huang.demo.utility.Helpers;

public class IPValidatorPage {
    
    WebDriver driver = null;
    
    public IPValidatorPage(WebDriver driver) {
        // open up the IP Address Validator program webpage
        driver.get(Constants.IP_ADDR_VALIDATOR_PAGE);
        this.driver = driver;
    }
    
    public WebElement IPInputBox() {
        WebElement inputBox = null;
        
        try {
            inputBox = driver.
                    findElement(By.xpath("//input[@name='Query' and @type='text']"));
        } catch (NoSuchElementException e){
            Helpers.updateReportWithException(e);
            driver.quit();
        }
        
        return inputBox;
    }
    
    public boolean isTestFailed() {
        String result = "";
        boolean isValid = false;
        
        try {
            result = driver
                .findElement(By.cssSelector(".result_desc > span")).getText();
        } catch (NoSuchElementException e){
            Helpers.updateReportWithException(e);
            driver.quit();
        }
        
        if(result.equals(Constants.VALID)) {
            isValid = true;
        }
        
        return isValid;
    }
}
