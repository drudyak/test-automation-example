package com.drudyak.dawanda.objects;

import com.drudyak.dawanda.utils.browser.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Drudyak on 3/2/17.
 */
public class Homepage extends IPageObject {

    private static final Logger logger = Logger.getLogger(Homepage.class);

    private final String DAWANDA_HOME_PAGE_URL = "https://en.dawanda.com/";
    private final String HEADER_CSS = ".header-user-welcome";
    private final String LOGIN_BTN_CSS = "a[href=\"/account/login\"]";
    private final String HEADER_ROW_EXP_CSS = "div#shared_header_user_nav.open";
    private final String REGISTER_BTN_CSS = "a[href=\"/account/register\"]";

    @FindBy(css = HEADER_CSS)
    private WebElement header;
    @FindBy(css = REGISTER_BTN_CSS)
    private WebElement registerBtn;
    @FindBy(css = LOGIN_BTN_CSS)
    private WebElement loginBtn;

    private WebDriver driver;

    public Homepage() {
        logger.info("DaWanda Home page creating");
        this.driver = DriverManager.getFirefoxDriver();
        PageFactory.initElements(driver, this);
    }




    public void navigateDaWandaHomePage() {
        navigateToPage(DAWANDA_HOME_PAGE_URL);
    }

    public boolean isHomePageOpen(){
        return isPageOpen(DAWANDA_HOME_PAGE_URL);
    }

    public void expandMenu() {
        hoverMouseOverElement(header);
    }

    public boolean checkMenuIsExpanded() {
        return isElementPresent(driver.findElement(By.cssSelector(HEADER_ROW_EXP_CSS)));
    }

    public boolean checkRegisterBtnIsPresent() {
        return isElementPresent(registerBtn);
    }

    public void clickRegisterBtn() {
        clickBtnSimple(registerBtn);
    }

    public boolean checkLoginBtnIsPresent() {
        return isElementPresent(loginBtn);
    }

    public void clickLoginBtn(){
        clickBtnSimple(loginBtn);
    }

}
