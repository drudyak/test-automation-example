package com.drudyak.dawanda.business;

import com.drudyak.dawanda.objects.LogoutPage;
import org.apache.log4j.Logger;
import org.testng.Assert;

/**
 * Created by Denys_Rudiak on 3/2/2017.
 */
public class LogoutPageBO implements IPageBO {

    private final Logger logger = Logger.getLogger(LogoutPageBO.class);

    private LogoutPage logoutPage;

    public void verifyLogoutPageIsOpen(){
        logoutPage = new LogoutPage();

        Assert.assertTrue(logoutPage.isLogoutPageopen());
    }

    public void verifyElementsArePresent() {
        logoutPage = new LogoutPage();

        Assert.assertTrue(logoutPage.checkByeGirlBlockIsPresent());
        Assert.assertTrue(logoutPage.checkByeGirlImgIsPresent());
        Assert.assertTrue(logoutPage.checkFirstLineTextIsPresent());
        Assert.assertTrue(logoutPage.checkSecondLineTextIsPresent());
        Assert.assertTrue(logoutPage.checkFirstLineContainsText());
        Assert.assertTrue(logoutPage.checkSecondLineContainsText());
    }
}
