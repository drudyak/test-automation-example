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
public class RegisterPage extends IPageObject {

    private static final Logger logger = Logger.getLogger(RegisterPage.class);

    private static final String REGISTER_PAGE_URL = "https://en.dawanda.com/account/register";
    private static final String FIRST_NAME_FIELD_CSS = "#firstname";
    private static final String LAST_NAME_FIELD_CSS = "#lastname";
    private static final String USERNAME_FIELD_CSS = "#username";
    private static final String EMAIL_FIELD_CSS = "#email";
    private static final String PSWD_FIELD_CSS = "#password";
    private static final String PRIVACY_CHCKBX_CSS = "#accept_privacy";
    private static final String REGISTER_BTN_CSS = "#register_submit";

    @FindBy(css = FIRST_NAME_FIELD_CSS)
    private WebElement firstNameField;
    @FindBy(css = LAST_NAME_FIELD_CSS)
    private WebElement lastNameField;
    @FindBy(css = USERNAME_FIELD_CSS)
    private WebElement userNameField;
    @FindBy(css = EMAIL_FIELD_CSS)
    private WebElement emailField;
    @FindBy(css = PSWD_FIELD_CSS)
    private WebElement passwordField;
    @FindBy(css = PRIVACY_CHCKBX_CSS)
    private WebElement privacyChckBx;
    @FindBy(css = REGISTER_BTN_CSS)
    private WebElement registerBtn;

    private WebDriver driver;

    public RegisterPage() {
        logger.info("DaWanda Registration page creating");
        this.driver = DriverManager.getFirefoxDriver();
        PageFactory.initElements(driver, this);
    }



    public boolean isRegisterPageOpen(){
        return isPageOpen(REGISTER_PAGE_URL);
    }

    // Check element presence

    public boolean checkFirstNameFieldIsPresent() {
        return isElementPresent(firstNameField);
    }

    public boolean checkLastNameFieldIsPresent() {
        return isElementPresent(lastNameField);
    }

    public boolean checkUsernameNameFieldIsPresent() {
        return isElementPresent(userNameField);
    }

    public boolean checkEmailFieldIsPresent() {
        return isElementPresent(emailField);
    }

    public boolean checkPswdFieldIsPresent() {
        return isElementPresent(passwordField);
    }

    public boolean checkPrivacyCheckboxIsPresent() {
        return isElementPresent(privacyChckBx);
    }

    public boolean checkRegisterBtnIsPresent() {
        return isElementPresent(registerBtn);
    }

    public boolean checkPrivacyCheckboxIsNotSelected() {
        return !isChckBxSelected(privacyChckBx);
    }

    public boolean checkPrivacyCheckboxIsSelected() {
        return isChckBxSelected(privacyChckBx);
    }


    // Set values

    public void setFirstName() {
        setText(firstNameField, UserTestData.getFirstName());
    }

    public void setLastName() {
        setText(lastNameField, UserTestData.getLastName());
    }

    public void setUserName() {
        setText(userNameField, UserTestData.getUSERNAME());
    }

    public void setEmail() {
        setText(emailField, UserTestData.getEMAIL());
    }

    public void setPswd() {
        setText(passwordField, UserTestData.getPSWD());
    }

    public void selectPrivacyChckBx() {
        tickCheckbox(privacyChckBx);
    }

    public void clickRegisterBtn(){
        clickBtnSimple(registerBtn);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            logger.error(e.getStackTrace());
        }
    }


}
