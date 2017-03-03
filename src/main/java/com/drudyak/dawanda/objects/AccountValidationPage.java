package com.drudyak.dawanda.objects;

import com.drudyak.dawanda.testdata.UserTestData;
import com.drudyak.dawanda.utils.browser.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Denys_Rudiak on 3/2/2017.
 */
public class AccountValidationPage extends IPageObject {

    private static final Logger logger = Logger.getLogger(AccountValidationPage.class);

    private static final String ACCOUNT_VALIDATION_PAGE_URL = "https://en.dawanda.com/account/validate";
    private static final String VALIDATE_EMAIL_HINT_CSS = "#validate_email_hint";
    private final String HEADER_CSS = ".header-user-welcome";
    private final String HEADER_ROW_EXP_CSS = "div#shared_header_user_nav.open";
    private final String LOGOUT_BTN_CSS = "a[href=\"/account/logout\"]";

    @FindBy(css = VALIDATE_EMAIL_HINT_CSS)
    private WebElement emailHintText;
    @FindBy(css = HEADER_CSS)
    private WebElement header;
    @FindBy(css = LOGOUT_BTN_CSS)
    private WebElement logoutBtn;

    private WebDriver driver;

    public AccountValidationPage() {
        logger.info("DaWanda Account Validation page creating");
        this.driver = DriverManager.getFirefoxDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean isAccountValidationPageOpen() {
        waitForPageLoad();
        return isPageOpen(ACCOUNT_VALIDATION_PAGE_URL);
    }

    public boolean checkEmailValidationHintIsPresent() {
        return isElementPresent(emailHintText);
    }

    public boolean checkEmailIsPresentInHint() {
        return isTextPresent(emailHintText, UserTestData.getAccountValidationMsg());
    }

    public void expandMenu() {
        hoverMouseOverElement(header);
    }

    public boolean checkMenuIsExpanded() {
        return isElementPresent(driver.findElement(By.cssSelector(HEADER_ROW_EXP_CSS)));
    }

    public void logout() {
        clickBtnSimple(logoutBtn);
    }

}
