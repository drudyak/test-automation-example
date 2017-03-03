package com.drudyak.dawanda.testdata;

import com.drudyak.dawanda.utils.numbergenerator.RandomNumberGenerator;

/**
 * Created by Denys_Rudiak on 3/2/2017.
 */
public class UserTestData {

    private static final int length = 10;
    private static final String FIRST_NAME = "First";
    private static final String LAST_NAME = "Last";
    private static final long RANDOM_NUMBER = RandomNumberGenerator.generateRandom(length);
    private static final String USERNAME = "test-user" + getRandomNumber();
    private static final String EMAIL = getRandomNumber() + "+drudyak" + "@gmail.com";
    private static final String PSWD = "1234567890";

    private static final String ACCOUNT_VALIDATION_MSG = "We sent a confirmation link to " + EMAIL + ". Clicking it will grant you full access to your DaWanda account.";


    private UserTestData() {
    }

    public static String getAccountValidationMsg() {
        return ACCOUNT_VALIDATION_MSG;
    }

    public static String getFirstName() {
        return FIRST_NAME;
    }

    public static String getLastName() {
        return LAST_NAME;
    }

    public static long getRandomNumber() {
        return RANDOM_NUMBER;
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getEMAIL() {
        return EMAIL;
    }

    public static String getPSWD() {
        return PSWD;
    }
}
