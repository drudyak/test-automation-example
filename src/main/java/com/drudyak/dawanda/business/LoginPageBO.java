package com.drudyak.dawanda.business;

import com.drudyak.dawanda.objects.LoginPage;
import org.apache.log4j.Logger;
import org.testng.Assert;

/**
 * Created by Denys_Rudiak on 3/2/2017.
 */
public class LoginPageBO implements IPageBO {
    private final Logger logger = Logger.getLogger(LoginPageBO.class);

    private LoginPage loginPage;


    public void verifyLoginPageIsOpen(){
        loginPage = new LoginPage();

        Assert.assertTrue(loginPage.isLoginPageOpen());
    }

    public void verifyElementsPresense(){
        loginPage = new LoginPage();

        Assert.assertTrue(loginPage.checkUsernameNameFieldIsPresent());
        Assert.assertTrue(loginPage.checkPswdFieldIsPresent());
        Assert.assertTrue(loginPage.checkLoginBtnIsPresent());
    }

    public void login(){
        loginPage = new LoginPage();

        loginPage.setUserName();
        loginPage.setPswd();
        loginPage.clickLoginBtn();
    }

}
