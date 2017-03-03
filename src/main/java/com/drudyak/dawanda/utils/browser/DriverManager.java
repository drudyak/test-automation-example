package com.drudyak.dawanda.utils.browser;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Denys_Rudiak on 3/1/2017.
 */
public class DriverManager {

    private static final Logger logger = Logger.getLogger(DriverManager.class);

    private static WebDriver instance;

    private DriverManager() {
    }

    // Singleton for WebDriver
    public static WebDriver getFirefoxDriver() {

        System.setProperty("webdriver.gecko.driver", new FirefoxProperties().osDetection());

        if (instance == null) {
            instance = new FirefoxDriver();
            instance.manage().window().maximize();
            logger.info("new instance of FireFoxDriver created");
        }
        return instance;

    }

    public static void closeDriver() {
        if (instance != null) {
            instance.quit();
            instance = null;
        }
    }

}
