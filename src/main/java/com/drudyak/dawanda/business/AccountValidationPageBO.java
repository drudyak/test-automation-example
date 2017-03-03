package com.drudyak.dawanda.business;

import com.drudyak.dawanda.objects.AccountValidationPage;
import org.apache.log4j.Logger;
import org.testng.Assert;

/**
 * Created by Denys_Rudiak on 3/2/2017.
 */
public class AccountValidationPageBO implements IPageBO {

    private final Logger logger = Logger.getLogger(AccountValidationPageBO.class);

    private AccountValidationPage accountValidationPage;


    public void verifyAccountValidationPageIsOpen(){
        accountValidationPage = new AccountValidationPage();

        Assert.assertTrue(accountValidationPage.isAccountValidationPageOpen());
    }

    public void verifyElementsArePresent() {
        accountValidationPage = new AccountValidationPage();

        Assert.assertTrue(accountValidationPage.checkEmailValidationHintIsPresent());
        Assert.assertTrue(accountValidationPage.checkEmailIsPresentInHint());
    }

    public void logout(){
        accountValidationPage = new AccountValidationPage();

        accountValidationPage.expandMenu();
        Assert.assertTrue(accountValidationPage.checkMenuIsExpanded());
        accountValidationPage.logout();
    }
}
