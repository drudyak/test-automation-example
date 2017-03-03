package com.drudyak.dawanda.objects;

import com.drudyak.dawanda.utils.browser.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Drudyak on 3/2/17.
 */
abstract class IPageObject {
    private Logger logger = Logger.getLogger(IPageObject.class);

    private WebDriver driver = DriverManager.getFirefoxDriver();


    protected void navigateToPage(String url) {
        driver.get(url);
        waitForPageLoad();
    }

    protected void clickBtnAdvanced(WebElement element) {
        element.click();
        if (isElementPresent(element)) {
            element.click();
        } else {
            throw new WebDriverException(element.getTagName() + "\t" + element.getAttribute("class") + "is not clickable");
        }
    }

    protected void clickBtnSimple(WebElement element) {
        element.click();
    }

    protected void hoverMouseOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    protected boolean isElementPresent(WebElement element) {
        boolean isPresent = false;
        try {
            if (element.isDisplayed()) {
                isPresent = true;
            }
        } catch (NoSuchElementException e) {
            isPresent = false;
            logger.error(e);
        }
        return isPresent;


    }

    protected boolean isChckBxSelected(WebElement element) {
        return element.isSelected();
    }

    protected void tickCheckbox(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected void setText(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected boolean isTextPresent(WebElement element, String text) {
        return element.getText().contains(text);
    }

    protected boolean isPageOpen(String url){
        waitForPageLoad();
        return url.equals(driver.getCurrentUrl());
    }

    protected void waitForPageLoad() {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                "complete".equals(((JavascriptExecutor) wd).executeScript("return document.readyState")));
    }
}
