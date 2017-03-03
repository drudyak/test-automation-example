package com.drudyak.dawanda.objects;

import com.drudyak.dawanda.testdata.UserTestData;
import com.drudyak.dawanda.utils.browser.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Denys_Rudiak on 3/2/2017.
 */
public class LoginPage extends IPageObject {
    private static final Logger logger = Logger.getLogger(LoginPage.class);

    private static final String LOGIN_PAGE_URL = "https://en.dawanda.com/account/login";
    private static final String USERNAME_FIELD_CSS = "#username";
    private static final String PSWD_FIELD_CSS = "#login_credentials_password";
    private static final String LOGIN_BTN_CSS = "#login_submit";


    @FindBy(css = USERNAME_FIELD_CSS)
    private WebElement userNameField;
    @FindBy(css = PSWD_FIELD_CSS)
    private WebElement passwordField;
    @FindBy(css = LOGIN_BTN_CSS)
    private WebElement loginBtn;

    private WebDriver driver;

    public LoginPage() {
        logger.info("DaWanda Login page creating");
        this.driver = DriverManager.getFirefoxDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean isLoginPageOpen(){
        return isPageOpen(LOGIN_PAGE_URL);
    }

    public boolean checkUsernameNameFieldIsPresent() {
        return isElementPresent(userNameField);
    }

    public boolean checkPswdFieldIsPresent() {
        return isElementPresent(passwordField);
    }

    public boolean checkLoginBtnIsPresent() {
        return isElementPresent(loginBtn);
    }


    public void setUserName() {
        setText(userNameField, UserTestData.getUSERNAME());
    }

    public void setPswd() {
        setText(passwordField, UserTestData.getPSWD());
    }

    public void clickLoginBtn(){
        clickBtnAdvanced(loginBtn);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
