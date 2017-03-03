package com.drudyak.dawanda.business;

import com.drudyak.dawanda.objects.MyDawandaPage;
import org.apache.log4j.Logger;
import org.testng.Assert;

/**
 * Created by Denys_Rudiak on 3/2/2017.
 */
public class MyDawandaPageBO implements IPageBO {
    private final Logger logger = Logger.getLogger(LogoutPageBO.class);

    private MyDawandaPage myDawandaPage;

    public void verifyMyDawandaPageIsOpen(){
        myDawandaPage = new MyDawandaPage();

        Assert.assertTrue(myDawandaPage.isMyDawandaPageOpen());
    }

    public void verifyUsernameIsDisplayedInHeader(){
        myDawandaPage = new MyDawandaPage();

        Assert.assertTrue(myDawandaPage.checkUsernameIsDisplayedInHeader());
    }

    public void logout(){
        myDawandaPage = new MyDawandaPage();

        myDawandaPage.expandMenu();
        Assert.assertTrue(myDawandaPage.checkMenuIsExpanded());
        myDawandaPage.logout();
    }


}
