package com.drudyak.dawanda.business;

import com.drudyak.dawanda.objects.Homepage;
import com.drudyak.dawanda.objects.RegisterPage;
import org.apache.log4j.Logger;
import org.testng.Assert;

/**
 * Created by Denys_Rudiak on 3/2/2017.
 */
public class RegisterPageBO implements IPageBO {
    private final Logger logger = Logger.getLogger(RegisterPageBO.class);

    private RegisterPage registerPage;


    public void verifyRegisterPageIsOpen() {
        registerPage = new RegisterPage();

        Assert.assertTrue(registerPage.isRegisterPageOpen());
    }

    public void verifyElementsArePresent() {
        registerPage = new RegisterPage();

        Assert.assertTrue(registerPage.checkFirstNameFieldIsPresent());
        Assert.assertTrue(registerPage.checkLastNameFieldIsPresent());
        Assert.assertTrue(registerPage.checkUsernameNameFieldIsPresent());
        Assert.assertTrue(registerPage.checkEmailFieldIsPresent());
        Assert.assertTrue(registerPage.checkPswdFieldIsPresent());
        Assert.assertTrue(registerPage.checkPrivacyCheckboxIsPresent());
        Assert.assertTrue(registerPage.checkPrivacyCheckboxIsNotSelected());
        Assert.assertTrue(registerPage.checkRegisterBtnIsPresent());

    }

    public void createNewUser() {
        registerPage.setFirstName();
        registerPage.setLastName();
        registerPage.setUserName();
        registerPage.setEmail();
        registerPage.setPswd();
        registerPage.selectPrivacyChckBx();
        Assert.assertTrue(registerPage.checkPrivacyCheckboxIsSelected());
        registerPage.clickRegisterBtn();
    }
}
