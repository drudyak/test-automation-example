package com.drudyak.dawanda;

import com.drudyak.dawanda.business.*;
import com.drudyak.dawanda.utils.browser.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Drudyak on 3/1/17.
 */
public class DawandaRegistrationTest {

    private HomepageBO homePage;
    private RegisterPageBO registerPage;
    private AccountValidationPageBO accountValidationPageBO;
    private LogoutPageBO logoutPageBO;
    private LoginPageBO loginPageBO;
    private MyDawandaPageBO myDawandaPageBO;

    private WebDriver driver;


    @BeforeClass
    public void initDriver() {
        driver = DriverManager.getFirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterMethod() {
        DriverManager.closeDriver();
    }

    @Test
    public void checkRegisterPageCanBeOpenedTest() {
        homePage = new HomepageBO();

        homePage.navigateToHomePage();
        homePage.verifyHomepageIsOpen();
        homePage.openRegisterPage();
    }

    @Test(dependsOnMethods = "checkRegisterPageCanBeOpenedTest")
    public void checkNewUserCanBeCreatedTest() {
        registerPage = new RegisterPageBO();

        registerPage.verifyRegisterPageIsOpen();
        registerPage.verifyElementsArePresent();
        registerPage.createNewUser();
    }

    @Test(dependsOnMethods = "checkNewUserCanBeCreatedTest")
    public void checkAccountValidationPageIsOpenOnSuccessfulUserCreationTest() {
        accountValidationPageBO = new AccountValidationPageBO();

        accountValidationPageBO.verifyAccountValidationPageIsOpen();
        accountValidationPageBO.verifyElementsArePresent();
        accountValidationPageBO.logout();
    }


    @Test(dependsOnMethods = "checkAccountValidationPageIsOpenOnSuccessfulUserCreationTest")
    public void checkGoodbyePageIsOpenAfterLogoutTest() {
        logoutPageBO = new LogoutPageBO();

        logoutPageBO.verifyLogoutPageIsOpen();
        logoutPageBO.verifyElementsArePresent();
    }

    @Test(dependsOnMethods = "checkGoodbyePageIsOpenAfterLogoutTest")
    public void loginRegisteredUserTest() {
        homePage = new HomepageBO();

        homePage.navigateToHomePage();
        homePage.verifyHomepageIsOpen();
        homePage.openLoginPage();

        loginPageBO = new LoginPageBO();

        loginPageBO.verifyLoginPageIsOpen();
        loginPageBO.verifyElementsPresense();
        loginPageBO.login();

        myDawandaPageBO = new MyDawandaPageBO();

        myDawandaPageBO.verifyMyDawandaPageIsOpen();
        myDawandaPageBO.verifyUsernameIsDisplayedInHeader();
    }

    @Test(dependsOnMethods = "loginRegisteredUserTest")
    public void logoutRegisteredUserTest() {
        myDawandaPageBO = new MyDawandaPageBO();

        myDawandaPageBO.logout();

        logoutPageBO = new LogoutPageBO();

        logoutPageBO.verifyLogoutPageIsOpen();
        logoutPageBO.verifyElementsArePresent();
    }
}
