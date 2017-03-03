package com.drudyak.dawanda.objects;

import com.drudyak.dawanda.utils.browser.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Denys_Rudiak on 3/2/2017.
 */
public class LogoutPage extends IPageObject {

    private static final Logger logger = Logger.getLogger(LogoutPage.class);

    private static final String LOGOUT_PAGE_URL = "https://en.dawanda.com/account/logout";
    private static final String BYE_GIRL_BLOCK_CSS = ".bye-girl";
    private static final String BYE_GIRL_IMG_CSS = ".bye-img img[src=\"/assets/frontend/goodbye-8026f842fe09f7e7963f5e5c805dee3c.gif\"]";
    private static final String FIRST_LINE_TEXT_CSS = ".bye-text h2";
    private static final String SECOND_LINE_TEXT_CSS = ".bye-text h3";
    private static final String FIRST_LINE_TEXT_VALUE = "Bye for now from DaWanda!";
    private static final String SECOND_LINE_TEXT_VALUE = "We look forward to seeing you next time.";

    @FindBy(css = BYE_GIRL_BLOCK_CSS)
    private WebElement byeGirlBlock;
    @FindBy(css = BYE_GIRL_IMG_CSS)
    private WebElement byeGirlImg;
    @FindBy(css = FIRST_LINE_TEXT_CSS)
    private WebElement firstLineText;
    @FindBy(css = SECOND_LINE_TEXT_CSS)
    private WebElement secondLineText;

    private WebDriver driver;

    public LogoutPage() {
        logger.info("DaWanda Logout page creating");
        this.driver = DriverManager.getFirefoxDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean isLogoutPageopen(){
        return isPageOpen(LOGOUT_PAGE_URL);
    }

    public boolean checkByeGirlBlockIsPresent(){
        return isElementPresent(byeGirlBlock);
    }
    public boolean checkByeGirlImgIsPresent(){
        return isElementPresent(byeGirlImg);
    }
    public boolean checkFirstLineTextIsPresent(){
        return isElementPresent(firstLineText);
    }
    public boolean checkSecondLineTextIsPresent(){
        return isElementPresent(secondLineText);
    }

    public boolean checkFirstLineContainsText(){
        return isTextPresent(firstLineText, FIRST_LINE_TEXT_VALUE);
    }
    public boolean checkSecondLineContainsText(){
        return isTextPresent(secondLineText, SECOND_LINE_TEXT_VALUE);
    }

}
