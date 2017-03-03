package com.drudyak.dawanda.business;

import com.drudyak.dawanda.objects.Homepage;
import org.apache.log4j.Logger;
import org.testng.Assert;

/**
 * Created by Drudyak on 3/2/17.
 */
public class HomepageBO implements IPageBO {
    private final Logger logger = Logger.getLogger(HomepageBO.class);

    private Homepage homePage;

    public void navigateToHomePage() {
        homePage = new Homepage();

        homePage.navigateDaWandaHomePage();
    }

    public void verifyHomepageIsOpen() {
        homePage = new Homepage();

        Assert.assertTrue(homePage.isHomePageOpen());
    }

    public void openRegisterPage() {
        homePage = new Homepage();

        homePage.expandMenu();
        Assert.assertTrue(homePage.checkMenuIsExpanded());
        Assert.assertTrue(homePage.checkRegisterBtnIsPresent());
        homePage.clickRegisterBtn();
    }

    public void openLoginPage() {
        homePage = new Homepage();

        homePage.expandMenu();
        Assert.assertTrue(homePage.checkMenuIsExpanded());
        Assert.assertTrue(homePage.checkLoginBtnIsPresent());
        homePage.clickLoginBtn();
    }

}
