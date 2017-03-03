package com.drudyak.dawanda.objects;

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
public class MyDawandaPage extends IPageObject {

    private static final Logger logger = Logger.getLogger(MyDawandaPage.class);

    private final String DAWANDA_MY_PAGE_URL = "https://en.dawanda.com/mydawanda";
    private final String HEADER_USERNAME_CSS = ".logged-in-state span:nth-child(2)";
    private final String HEADER_CSS = ".header-user-welcome";
    private final String HEADER_ROW_EXP_CSS = "div#shared_header_user_nav.open";
    private final String LOGOUT_BTN_CSS = "a[href=\"/account/logout\"]";

    @FindBy(css = HEADER_USERNAME_CSS)
    private WebElement username;
    @FindBy(css = HEADER_CSS)
    private WebElement header;
    @FindBy(css = LOGOUT_BTN_CSS)
    private WebElement logoutBtn;

    private WebDriver driver;


    public MyDawandaPage() {
        logger.info("DaWanda My page creating");
        this.driver = DriverManager.getFirefoxDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean isMyDawandaPageOpen() {
        return isPageOpen(DAWANDA_MY_PAGE_URL);
    }

    public boolean checkUsernameIsDisplayedInHeader() {
        return isElementPresent(username);
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
